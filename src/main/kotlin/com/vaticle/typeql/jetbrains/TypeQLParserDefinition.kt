package com.vaticle.typeql.jetbrains

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
import com.vaticle.typeql.jetbrains.completion.TypeQLCompletionErrorListener
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLElement
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLFileBase
import com.vaticle.typeql.jetbrains.psi.constraint.*
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

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

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE
    override fun getCommentTokens(): TokenSet = COMMENTS
    override fun getStringLiteralElements(): TokenSet = STRING

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

    override fun createFile(viewProvider: FileViewProvider): PsiFile = PsiTypeQLFileBase(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        val ruleElType = node.elementType as RuleIElementType
        return when (ruleElType.ruleIndex) {
            TypeQLParser.RULE_variable_type -> updateWrappedTypeIfNecessary(
                node,
                PsiStatementType(node)
            )
            TypeQLParser.RULE_type_constraint -> {
                val ruleTypePropertyElement = getRuleTypePropertyElement(node)
                if (ruleTypePropertyElement != null) {
                    return updateWrappedTypeIfNecessary(node, ruleTypePropertyElement)
                }
                val ruleTypeElement = getRuleTypeElement(node)
                if (ruleTypeElement != null) {
                    updateWrappedTypeIfNecessary(node, ruleTypeElement)
                } else updateWrappedTypeIfNecessary(node, PsiTypeQLElement(node))
            }
            TypeQLParser.RULE_type -> {
                val ruleTypeElement = getRuleTypeElement(node)
                if (ruleTypeElement != null) {
                    updateWrappedTypeIfNecessary(node, ruleTypeElement)
                } else updateWrappedTypeIfNecessary(node, PsiTypeQLElement(node))
            }
            else -> updateWrappedTypeIfNecessary(node, PsiTypeQLElement(node))
        }
    }

    companion object {
        private var WRAPPER_SET = Key<Boolean>("typeql.wrapper")
        lateinit var INSTANCE: TypeQLParserDefinition

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                TypeQLLanguage.INSTANCE, TypeQLParser.tokenNames, TypeQLParser.ruleNames
            )
        }

        val FILE = IFileElementType(TypeQLLanguage.INSTANCE)
        val IDS = PSIElementTypeFactory.createTokenSet(TypeQLLanguage.INSTANCE, TypeQLParser.LABEL_)!!
        val COMMENTS = PSIElementTypeFactory.createTokenSet(TypeQLLanguage.INSTANCE, TypeQLLexer.COMMENT)!!
        val WHITESPACE = PSIElementTypeFactory.createTokenSet(TypeQLLanguage.INSTANCE, TypeQLLexer.WS)!!
        val STRING = PSIElementTypeFactory.createTokenSet(TypeQLLanguage.INSTANCE, TypeQLLexer.STRING_)!!
        val TOKEN_ELEMENT_TYPES = PSIElementTypeFactory.getTokenIElementTypes(TypeQLLanguage.INSTANCE)!!
        val RULE_ELEMENT_TYPES = PSIElementTypeFactory.getRuleIElementTypes(TypeQLLanguage.INSTANCE)!!

        fun getRuleTypeElement(node: ASTNode): PsiTypeQLElement? {
            if (node.treePrev != null && node.treePrev.treePrev != null && node.treePrev.treePrev.text == "as") {
                return PsiRelatesSuperRoleTypeConstraint(node)
            } else if (node.treeParent != null
                && node.treeParent.treeNext != null
                && node.treeParent.treeNext.treeNext != null
                && node.treeParent.treeNext.treeNext.firstChildNode != null
                && node.treeParent.treeNext.treeNext.firstChildNode.text == "sub"
                && node.firstChildNode != null
                && node.firstChildNode.elementType === RULE_ELEMENT_TYPES[TypeQLParser.RULE_label]
            ) {
                return PsiTypeConstraint(node)
            }
            return null
        }

        fun getRuleTypePropertyElement(node: ASTNode): PsiTypeQLElement? {
            if (node.firstChildNode != null && (node.firstChildNode.text == "owns" || node.firstChildNode.text == "key")) {
                val ownsTo = node.lastChildNode.text
                if (ownsTo.isNotEmpty()) {
                    return PsiOwnsTypeConstraint(node)
                }
            } else if (node.firstChildNode != null && node.firstChildNode.text == "plays") {
                val playsTo = node.lastChildNode.text
                if (playsTo.isNotEmpty()) {
                    return PsiPlaysTypeConstraint(node)
                }
            } else if (node.firstChildNode != null && node.firstChildNode.text == "relates") {
                val relatesTo = node.lastChildNode.text
                if (relatesTo.isNotEmpty()) {
                    return PsiRelatesTypeConstraint(node)
                }
            } else if (node.firstChildNode != null && node.firstChildNode.text == "sub") {
                val subsTo = node.lastChildNode.text
                if (subsTo.isNotEmpty() && !TypeQLLanguage.GRAQL_TYPES.contains(subsTo)) {
                    return PsiSubTypeConstraint(node)
                }
            }
            return null
        }

        fun updateWrappedTypeIfNecessary(node: ASTNode, element: PsiTypeQLElement): PsiTypeQLElement {
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
