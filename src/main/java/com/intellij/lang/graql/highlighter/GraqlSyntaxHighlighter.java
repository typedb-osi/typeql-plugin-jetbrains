package com.intellij.lang.graql.highlighter;

import com.intellij.lang.graql.parser.GraqlLexer;
import com.intellij.lang.graql.psi.GraqlTokenTypeSets;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author github.com/BFergerson
 */
public class GraqlSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey SINGLE_LINE_COMMENT =
            createTextAttributesKey("GQL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private static final TextAttributesKey KEYWORD =
            createTextAttributesKey("GQL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey STRING =
            createTextAttributesKey("GQL_STRING", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey DATATYPES =
            createTextAttributesKey("GQL_DATATYPES", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("GQL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    private static final TextAttributesKey SEMICOLON =
            createTextAttributesKey("GQL_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    private static final TextAttributesKey COMMA =
            createTextAttributesKey("GQL_COMMA", DefaultLanguageHighlighterColors.COMMA);
    private static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("GQL_BAD_TOKEN", HighlighterColors.BAD_CHARACTER);
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        fillMap(ATTRIBUTES, SINGLE_LINE_COMMENT, GraqlTokenTypes.SINGLE_LINE_COMMENT);
        fillMap(ATTRIBUTES, BAD_CHARACTER, TokenType.BAD_CHARACTER);
        fillMap(ATTRIBUTES, IDENTIFIER, GraqlTokenTypes.IDENTIFIER);
        fillMap(ATTRIBUTES, SEMICOLON, GraqlTokenTypes.SEMICOLON);
        fillMap(ATTRIBUTES, COMMA, GraqlTokenTypes.COMMA);
        fillMap(ATTRIBUTES, STRING, GraqlTokenTypes.STRING_LITERAL);
        fillMap(ATTRIBUTES, GraqlTokenTypeSets.MODEL, STRING);
        fillMap(ATTRIBUTES, GraqlTokenTypeSets.KEYWORDS, KEYWORD);
        fillMap(ATTRIBUTES, GraqlTokenTypeSets.DATATYPES, DATATYPES);
    }

    @NotNull
    public Lexer getHighlightingLexer() {
        return new GraqlLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }

}