/*
 * Copyright (C) 2022 Vaticle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.vaticle.typeql.grammar.TypeQLLexer
import com.vaticle.typeql.grammar.TypeQLParser
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import org.typedb.typeql.plugin.jetbrains.completion.TypeQLCompletionErrorListener
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLFile
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLStatementType
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLUtils
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLParserDefinition : ParserDefinition {
    init {
        INSTANCE = this
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = TypeQLLexer(null)
        return ANTLRLexerAdaptor(TypeQLLanguage.INSTANCE, lexer)
    }

    override fun getWhitespaceTokens(): TokenSet = TypeQLTokenSets.WHITESPACES
    override fun getCommentTokens(): TokenSet = TypeQLTokenSets.COMMENTS
    override fun getStringLiteralElements(): TokenSet = TypeQLTokenSets.STRINGS

    override fun createParser(project: Project): PsiParser {
        val parser = TypeQLParser(null)
        val completionErrorListener = TypeQLCompletionErrorListener()
        return object : ANTLRParserAdaptor(TypeQLLanguage.INSTANCE, parser) {
            override fun parse(parser: Parser, root: IElementType): ParseTree {
                parser.addErrorListener(completionErrorListener)

                if (root is IFileElementType) {
                    return (parser as TypeQLParser).eof_queries()
                }
                throw UnsupportedOperationException()
            }
        }
    }

    override fun getFileNodeType(): IFileElementType = FILE

    override fun createFile(viewProvider: FileViewProvider): PsiFile = PsiTypeQLFile(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        val elType: IElementType = node.elementType

        if (elType is TokenIElementType) {
            return createBasePsiElement(node)
        }

        if (elType !is RuleIElementType) {
            return createBasePsiElement(node)
        }

        return updateWrappedTypeIfNecessary(
            node,
            when (elType.ruleIndex) {
                TypeQLParser.RULE_statement_type -> PsiTypeQLStatementType(node)
                TypeQLParser.RULE_type_constraint -> createTypeConstraintWrapper(node)
                TypeQLParser.RULE_type -> createTypeWrapper(node)
                else -> createBasePsiElement(node)
            }
        )
    }

    companion object {
        lateinit var INSTANCE: TypeQLParserDefinition
        private var WRAPPER_SET = Key<Boolean>("typeql.wrapper")

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                TypeQLLanguage.INSTANCE, TypeQLParser.tokenNames, TypeQLParser.ruleNames
            )
        }

        val FILE = IFileElementType(TypeQLLanguage.INSTANCE)

        private val TOKEN_ELEMENT_TYPES: List<TokenIElementType> =
            PSIElementTypeFactory.getTokenIElementTypes(TypeQLLanguage.INSTANCE)!!
        private val RULE_ELEMENT_TYPES: List<RuleIElementType> =
            PSIElementTypeFactory.getRuleIElementTypes(TypeQLLanguage.INSTANCE)!!

        fun getRule(ruleId: Int): RuleIElementType? {
            return if (ruleId < RULE_ELEMENT_TYPES.size) {
                RULE_ELEMENT_TYPES[ruleId]
            } else {
                null
            }
        }

        fun getToken(tokenId: Int): TokenIElementType? {
            return if (tokenId < TOKEN_ELEMENT_TYPES.size) {
                TOKEN_ELEMENT_TYPES[tokenId]
            } else {
                null
            }
        }

        fun getTokenText(tokenId: Int): String {
            return (getToken(tokenId) ?: "").toString()
        }

        fun checkNode(node: ASTNode?, elementId: Int): Boolean {
            if (node?.elementType is TokenIElementType) {
                return refCheckInContainer(node, TOKEN_ELEMENT_TYPES, elementId)
            }
            if (node?.elementType is RuleIElementType) {
                return refCheckInContainer(node, RULE_ELEMENT_TYPES, elementId)
            }

            return false
        }

        fun getRuleTypeElement(node: ASTNode): PsiElement? {
            if (checkNode(node.treePrev?.treePrev, TypeQLParser.AS)) {
                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.OWNS)) {
                    return PsiTypeQLOwnsAsOverrideType(node)
                }

                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.PLAYS)) {
                    return PsiTypeQLPlaysAsOverrideType(node)
                }

                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.RELATES)) {
                    return PsiTypeQLRelatesAsOverrideType(node)
                }
            }

            if (checkNode(node.treeParent?.treeNext?.treeNext?.firstChildNode, TypeQLParser.SUB_)
                && checkNode(node.firstChildNode, TypeQLParser.RULE_label)
            ) {
                return PsiTypeQLType(node)
            }

            return null
        }

        private fun getRuleTypePropertyElement(node: ASTNode): PsiElement? {
            var newNode: PsiElement? = null

            if (node.firstChildNode != null) {
                if (checkNode(node.firstChildNode, TypeQLParser.OWNS)) {
                    newNode = createOwnsType(node)
                } else if (checkNode(node.firstChildNode, TypeQLParser.PLAYS)) {
                    newNode = createPlaysType(node)
                } else if (checkNode(node.firstChildNode, TypeQLParser.RELATES)) {
                    newNode = createRelatesType(node)
                } else if (checkNode(node.firstChildNode, TypeQLParser.SUB_)) {
                    newNode = createSubType(node)
                }
            }

            return newNode
        }

        private fun createOwnsType(node: ASTNode): PsiTypeQLOwnsType? {
            val annotationNode = node.lastChildNode
            var ownsToNode = annotationNode?.treePrev

            while (isWhiteSpace(ownsToNode)) {
                ownsToNode = ownsToNode!!.treePrev
            }

            val ownsTo = ownsToNode?.text
            if (!ownsTo.isNullOrEmpty()) {
                return PsiTypeQLOwnsType(node)
            }

            return null
        }

        private fun createPlaysType(node: ASTNode): PsiTypeQLPlaysType? {
            val playsTo = node.lastChildNode?.text

            if (!playsTo.isNullOrEmpty()) {
                return PsiTypeQLPlaysType(node)
            }

            return null
        }

        private fun createRelatesType(node: ASTNode): PsiTypeQLRelatesType? {
            val relatesTo = node.lastChildNode?.text

            if (!relatesTo.isNullOrEmpty()) {
                return PsiTypeQLRelatesType(node)
            }

            return null
        }

        private fun createSubType(node: ASTNode): PsiTypeQLSubType? {
            val subsTo = node.lastChildNode?.text

            if (!subsTo.isNullOrEmpty() && !TypeQLLanguage.TYPEQL_TYPES.contains(subsTo)) {
                // PsiTypeQLType is not reparsed without extra changes, so we update it manually after finding a "sub":
                PsiTypeQLUtils.ensureTypeQLElementsUpToDate(node.treePrev?.treePrev?.firstChildNode?.psi)
                return PsiTypeQLSubType(node)
            }

            return null
        }

        private fun createBasePsiElement(node: ASTNode): PsiElement {
            return PsiTypeQLElement(node)
        }

        private fun createTypeConstraintWrapper(node: ASTNode): PsiElement {
            return getRuleTypePropertyElement(node) ?: createTypeWrapper(node)
        }

        private fun createTypeWrapper(node: ASTNode): PsiElement {
            return getRuleTypeElement(node) ?: createBasePsiElement(node)
        }

        private fun refCheckInContainer(node: ASTNode, container: List<IElementType>, index: Int): Boolean {
            return if (index < container.size) node.elementType === container[index] else false
        }

        private fun isWhiteSpace(node: ASTNode?): Boolean {
            return checkNode(node, TypeQLParser.WS)
        }

        fun updateWrappedTypeIfNecessary(node: ASTNode, element: PsiElement): PsiElement {
            val composite = node as CompositeElement
            val wrapperSet = composite.getUserData(WRAPPER_SET)

            if (wrapperSet == null || wrapperSet && element.javaClass != composite.psi.javaClass) {
                composite.psi = element
                composite.putUserData(WRAPPER_SET, true)
            }

            return element
        }
    }
}
