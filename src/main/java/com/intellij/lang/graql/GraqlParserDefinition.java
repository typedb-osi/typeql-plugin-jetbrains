package com.intellij.lang.graql;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lang.graql.parser.GraqlLexer;
import com.intellij.lang.graql.parser.GraqlParser;
import com.intellij.lang.graql.psi.GraqlFile;
import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * @author github.com/BFergerson
 */
public class GraqlParserDefinition implements ParserDefinition {

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new GraqlLexer();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return GraqlTokenTypeSets.WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return GraqlTokenTypeSets.COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new GraqlParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return GraqlTokenTypeSets.GRAQL_FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new GraqlFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return GraqlTokenTypes.Factory.createElement(node);
    }

}