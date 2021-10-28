package org.typedb.typeql.plugin.jetbrains.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import org.typedb.typeql.plugin.jetbrains.TypeQLLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        val lexer = TypeQLLexer(null)
        return ANTLRLexerAdaptor(TypeQLLanguage.INSTANCE, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType !is TokenIElementType) return EMPTY_KEYS
        if (tokenType == TokenType.BAD_CHARACTER) return arrayOf(BAD_CHARACTER)
        val type = tokenType.antlrTokenType
        val attrKey: TextAttributesKey
        attrKey = when (type) {
            TypeQLLexer.IID_, TypeQLLexer.VAR_, TypeQLLexer.VAR_NAMED_, TypeQLLexer.LABEL_, TypeQLLexer.LABEL_SCOPED_ -> ID
            TypeQLLexer.THING, TypeQLLexer.ENTITY, TypeQLLexer.ATTRIBUTE, TypeQLLexer.RELATION, TypeQLLexer.ROLE, TypeQLLexer.RULE -> THING
            TypeQLLexer.DEFINE, TypeQLLexer.UNDEFINE, TypeQLLexer.MATCH, TypeQLLexer.GET, TypeQLLexer.INSERT, TypeQLLexer.DELETE, TypeQLLexer.COMPUTE, TypeQLLexer.OFFSET, TypeQLLexer.LIMIT, TypeQLLexer.GROUP, TypeQLLexer.SORT, TypeQLLexer.ASC, TypeQLLexer.DESC, TypeQLLexer.CENTRALITY, TypeQLLexer.USING, TypeQLLexer.ABSTRACT, TypeQLLexer.AS, TypeQLLexer.TYPE, TypeQLLexer.ISA, TypeQLLexer.ISAX, TypeQLLexer.ISA_, TypeQLLexer.SUB, TypeQLLexer.SUBX, TypeQLLexer.SUB_, TypeQLLexer.OWNS, TypeQLLexer.PLAYS, TypeQLLexer.RELATES, TypeQLLexer.VALUE, TypeQLLexer.REGEX, TypeQLLexer.WHEN, TypeQLLexer.THEN, TypeQLLexer.LONG, TypeQLLexer.DOUBLE, TypeQLLexer.STRING, TypeQLLexer.BOOLEAN, TypeQLLexer.DATETIME -> KEYWORD
            TypeQLLexer.COMMENT -> LINE_COMMENT
            TypeQLLexer.LONG_, TypeQLLexer.DOUBLE_, TypeQLLexer.BOOLEAN_, TypeQLLexer.DATE_, TypeQLLexer.DATETIME_ -> NUMBER
            TypeQLLexer.STRING_ -> STRING
            else -> return EMPTY_KEYS
        }
        return arrayOf(attrKey)
    }

    companion object {
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
        val LINE_COMMENT =
            TextAttributesKey.createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val KEYWORD = TextAttributesKey.createTextAttributesKey("GQL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = TextAttributesKey.createTextAttributesKey("GQL_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = TextAttributesKey.createTextAttributesKey("GQL_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val ID = TextAttributesKey.createTextAttributesKey("GQL_IDENTIFIER", DefaultLanguageHighlighterColors.CONSTANT)
        val THING = TextAttributesKey.createTextAttributesKey("GQL_THING", DefaultLanguageHighlighterColors.IDENTIFIER)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                TypeQLLanguage.INSTANCE, TypeQLLexer.tokenNames, TypeQLLexer.ruleNames
            )
        }
    }
}