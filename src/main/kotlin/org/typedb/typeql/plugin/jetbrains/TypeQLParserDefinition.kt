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
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLStatementType

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
//        val completionErrorListener = TypeQLCompletionErrorListener() // TODO: Decide if we use it.
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
            TypeQLParser.RULE_statement_type -> PsiTypeQLStatementType(node)
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

        private fun refCheckInContainer(node: ASTNode, container: List<IElementType> , index: Int): Boolean {
            return if (index < container.size) node.elementType === container[index] else false
        }
        
        fun checkNode(node: ASTNode?, elementId: Int) : Boolean {
            if (node?.elementType is TokenIElementType) {
                return refCheckInContainer(node, TOKEN_ELEMENT_TYPES, elementId)
            }
            if (node?.elementType is RuleIElementType) {
                return refCheckInContainer(node, RULE_ELEMENT_TYPES, elementId)
            }

            return false
        }

        fun isWhiteSpace(node: ASTNode?): Boolean {
            return checkNode(node, TypeQLParser.WS)
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
                    return PsiTypeQLRelatesOverrideType(node)
                }
            }

            if (checkNode(node.treeParent?.treeNext?.treeNext?.firstChildNode, TypeQLParser.SUB_)
                && node.firstChildNode != null
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

            while(TypeQLParserDefinition.isWhiteSpace(ownsToNode)) {
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
                return PsiTypeQLSubType(node)
            }

            return null
        }
    }
}
