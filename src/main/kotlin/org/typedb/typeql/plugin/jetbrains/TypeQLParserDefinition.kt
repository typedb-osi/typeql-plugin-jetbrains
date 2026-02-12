package org.typedb.typeql.plugin.jetbrains

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class TypeQLParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(TypeQLLanguage)
    }

    override fun createLexer(project: Project?): Lexer = TypeQLLexerAdapter()

    override fun createParser(project: Project?): PsiParser = PsiParser { root, builder ->
        val marker = builder.mark()
        while (!builder.eof()) {
            builder.advanceLexer()
        }
        marker.done(root)
        builder.treeBuilt
    }

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TypeQLTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TypeQLTokenSets.STRINGS

    override fun getWhitespaceTokens(): TokenSet = TypeQLTokenSets.WHITE_SPACES

    override fun createElement(node: ASTNode): PsiElement =
        throw UnsupportedOperationException("Not yet implemented")

    override fun createFile(viewProvider: FileViewProvider): PsiFile = TypeQLFile(viewProvider)
}
