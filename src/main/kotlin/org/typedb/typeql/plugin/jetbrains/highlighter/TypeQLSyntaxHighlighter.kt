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
            TypeQLLexer.IID_, TypeQLLexer.LABEL_, TypeQLLexer.LABEL_SCOPED_ -> ID

            TypeQLLexer.THING, TypeQLLexer.ENTITY, TypeQLLexer.ATTRIBUTE, TypeQLLexer.RELATION, TypeQLLexer.ROLE
            -> THING

            TypeQLLexer.DEFINE, TypeQLLexer.UNDEFINE, TypeQLLexer.MATCH, TypeQLLexer.GET, TypeQLLexer.INSERT,
                TypeQLLexer.DELETE, TypeQLLexer.COMPUTE, TypeQLLexer.OFFSET, TypeQLLexer.LIMIT,
                TypeQLLexer.SORT, TypeQLLexer.ASC, TypeQLLexer.DESC, TypeQLLexer.ABSTRACT, TypeQLLexer.AS,
                TypeQLLexer.TYPE, TypeQLLexer.ISA_, TypeQLLexer.SUB_,
                TypeQLLexer.OWNS, TypeQLLexer.PLAYS, TypeQLLexer.RELATES, TypeQLLexer.VALUE, TypeQLLexer.REGEX,
                TypeQLLexer.WHEN, TypeQLLexer.THEN, TypeQLLexer.HAS, TypeQLLexer.PAREN_OPEN,
                TypeQLLexer.PAREN_CLOSE, TypeQLLexer.UNRECOGNISED, TypeQLLexer.NOT, TypeQLLexer.RULE,
                TypeQLLexer.OR, TypeQLLexer.EQ, TypeQLLexer.NEQ, TypeQLLexer.GT, TypeQLLexer.GTE, TypeQLLexer.LT,
                TypeQLLexer.LTE, TypeQLLexer.LIKE, TypeQLLexer.CONTAINS, TypeQLLexer.ASSIGN, TypeQLLexer.ADD,
                TypeQLLexer.SUBTRACT, TypeQLLexer.DIVIDE, TypeQLLexer.MULTIPLY, TypeQLLexer.POWER, TypeQLLexer.MODULO,
                TypeQLLexer.LABEL_SCOPED_, TypeQLLexer.ORDER_
            -> KEYWORD

            TypeQLLexer.COUNT, TypeQLLexer.MAX, TypeQLLexer.MIN, TypeQLLexer.MEAN, TypeQLLexer.MEDIAN, TypeQLLexer.STD,
                TypeQLLexer.SUM, TypeQLLexer.GROUP
            -> AGGREGATE

            TypeQLLexer.LONG, TypeQLLexer.DOUBLE, TypeQLLexer.STRING, TypeQLLexer.BOOLEAN, TypeQLLexer.DATETIME
            -> TYPE

            TypeQLLexer.COMMENT -> LINE_COMMENT

            TypeQLLexer.LONG_, TypeQLLexer.DOUBLE_, TypeQLLexer.DATE_, TypeQLLexer.DATETIME_
            -> NUMBER

            TypeQLLexer.BOOLEAN_ -> BOOLEAN

            TypeQLLexer.STRING_ -> STRING

            TypeQLLexer.VAR_CONCEPT_, TypeQLLexer.VAR_CONCEPT_ANONYMOUS_, TypeQLLexer.VAR_CONCEPT_NAMED_,
                TypeQLLexer.VAR_VALUE_
            -> VAR
            else -> return EMPTY_KEYS
        }
        return arrayOf(attrKey)
    }

    companion object {
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
        val LINE_COMMENT =
            TextAttributesKey.createTextAttributesKey("TYPEQL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val KEYWORD = TextAttributesKey.createTextAttributesKey("TYPEQL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = TextAttributesKey.createTextAttributesKey("TYPEQL_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = TextAttributesKey.createTextAttributesKey("TYPEQL_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val ID = TextAttributesKey.createTextAttributesKey("TYPEQL_IDENTIFIER", DefaultLanguageHighlighterColors.CONSTANT)
        val THING = TextAttributesKey.createTextAttributesKey("TYPEQL_THING", DefaultLanguageHighlighterColors.IDENTIFIER)
        val VAR = TextAttributesKey.createTextAttributesKey("TYPEQL_VAR", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
        val BOOLEAN = TextAttributesKey.createTextAttributesKey("TYPEQL_BOOLEAN", DefaultLanguageHighlighterColors.PARAMETER)
        val AGGREGATE = TextAttributesKey.createTextAttributesKey("TYPEQL_AGGREGATE", DefaultLanguageHighlighterColors.LABEL)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("TYPEQL_SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val TYPE = TextAttributesKey.createTextAttributesKey("TYPEQL_TYPE", DefaultLanguageHighlighterColors.MARKUP_TAG)
        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                TypeQLLanguage.INSTANCE, TypeQLLexer.tokenNames, TypeQLLexer.ruleNames
            )
        }
    }
}