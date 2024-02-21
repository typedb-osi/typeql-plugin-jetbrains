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
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.vaticle.typeql.grammar.TypeQLLexer
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLFile
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import org.typedb.typeql.plugin.jetbrains.psi.statement.PsiStatementType

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
//        val completionErrorListener = TypeQLCompletionErrorListener()
        return object : ANTLRParserAdaptor(TypeQLLanguage.INSTANCE, parser) {
            override fun parse(parser: Parser, root: IElementType): ParseTree {
//                parser.addErrorListener(completionErrorListener)
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

        return when (elType.ruleIndex) {
            TypeQLParser.RULE_statement_type -> PsiStatementType(node)
            TypeQLParser.RULE_type_constraint -> createTypeConstraintWrapper(node)
            TypeQLParser.RULE_type -> createTypeWrapper(node)
            else -> createBasePsiElement(node)
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
        val TOKEN_ELEMENT_TYPES = PSIElementTypeFactory.getTokenIElementTypes(TypeQLLanguage.INSTANCE)!!
        val RULE_ELEMENT_TYPES = PSIElementTypeFactory.getRuleIElementTypes(TypeQLLanguage.INSTANCE)!!

        private fun createBasePsiElement(node: ASTNode): PsiElement {
            return ANTLRPsiNode(node)
        }

        private fun createTypeConstraintWrapper(node: ASTNode): PsiElement {
            return getRuleTypePropertyElement(node) ?: createTypeWrapper(node)
        }

        private fun createTypeWrapper(node: ASTNode): PsiElement {
            return getRuleTypeElement(node) ?: createBasePsiElement(node)
        }
        
        private fun checkToken(node: ASTNode, tokenId: Int) : Boolean {
            if (node.elementType !is TokenIElementType) {
                return false
            }

            if (tokenId >= TOKEN_ELEMENT_TYPES.size) {
                return false
            }

            return node.elementType === TOKEN_ELEMENT_TYPES[tokenId]
        }

       private fun checkRule(node: ASTNode?, ruleId: Int) : Boolean {
            if (node == null) {
               return false
            }

            if (node.elementType !is RuleIElementType) {
                return false
            }

            if (ruleId >= RULE_ELEMENT_TYPES.size) {
               return false
            }

            return node.elementType === RULE_ELEMENT_TYPES[ruleId]
        }

        fun checkNode(node: ASTNode?, elementId: Int) : Boolean {
            if (node?.elementType is TokenIElementType) {
                return checkToken(node, elementId)
            }
            if (node?.elementType is RuleIElementType) {
                return checkRule(node, elementId)
            }

            return false
        }

        private fun checkRightNeighbour(node: ASTNode, elementId: Int) : Boolean {
            if (node.treeParent == null
                || node.treeParent.treeNext == null // WS
                || node.treeParent.treeNext.treeNext == null
                || node.treeParent.treeNext.treeNext.firstChildNode == null
            ) {
                return false
            }

            return checkNode(node.treeParent.treeNext.treeNext.firstChildNode, elementId)
        }

        fun isWhiteSpace(node: ASTNode): Boolean {
            return checkNode(node, TypeQLParser.WS)
        }

        fun getRuleTypeElement(node: ASTNode): PsiElement? {
            if (checkNode(node.treePrev?.treePrev, TypeQLParser.AS)
            ) {
                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.OWNS)) {
                    return PsiOwnsAsSuperRoleTypeConstraint(node)
                }

                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.PLAYS)) {
                    return PsiPlaysAsSuperRoleTypeConstraint(node)
                }

                if (checkNode(node.treeParent?.firstChildNode, TypeQLParser.RELATES)) {
                    return PsiRelatesAsSuperRoleTypeConstraint(node)
                }
            }

            if (checkRightNeighbour(node, TypeQLParser.SUB_)
                && node.firstChildNode != null
                && checkNode(node.firstChildNode, TypeQLParser.RULE_label)
            ) {
                val res = PsiTypeConstraint(node)
                println("PsiTypeConstaint: $res")
                return res
            }

            return null
        }

        private fun getRuleTypePropertyElement(node: ASTNode): PsiElement? {
            if (node.firstChildNode == null) {
                return null
            }

            if (checkNode(node.firstChildNode, TypeQLParser.OWNS)) {
                val annotation = node.lastChildNode
                var ownsTo = annotation.treePrev
                while(isWhiteSpace(ownsTo)) {
                    ownsTo = ownsTo.treePrev
                }
                if (ownsTo.text.isNotEmpty()) {
                    return PsiOwnsTypeConstraint(node)
                }
            } else if (checkNode(node.firstChildNode, TypeQLParser.PLAYS)) {
                val playsTo = node.lastChildNode.text
                if (playsTo.isNotEmpty()) {
                    return PsiPlaysTypeConstraint(node)
                }
            } else if (checkNode(node.firstChildNode, TypeQLParser.RELATES)) {
                val relatesTo = node.lastChildNode.text
                if (relatesTo.isNotEmpty()) {
                    return PsiRelatesTypeConstraint(node)
                }
            } else if (checkNode(node.firstChildNode, TypeQLParser.SUB_)) {
                val subsTo = node.lastChildNode.text
                if (subsTo.isNotEmpty() && !TypeQLLanguage.TYPEQL_TYPES.contains(subsTo)) {
                    return PsiSubTypeConstraint(node)
                }
            }

            return null
        }
//
//        fun updateWrappedTypeIfNecessary(node: ASTNode, element: PsiTypeQLElement): PsiTypeQLElement {
//            val composite = node as CompositeElement
//            val wrapperSet = composite.getUserData(WRAPPER_SET)
//            if (wrapperSet == null || wrapperSet && element.javaClass != composite.psi.javaClass) {
//                composite.psi = element
//                composite.putUserData(WRAPPER_SET, true)
//            }
//            return element
//        }
    }
}
