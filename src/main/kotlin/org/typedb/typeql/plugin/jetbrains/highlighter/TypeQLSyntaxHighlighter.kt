package org.typedb.typeql.plugin.jetbrains.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import com.vaticle.typeql.grammar.TypeQLLexer
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

        val attrKey: TextAttributesKey = when (tokenType.antlrTokenType) {
            TypeQLLexer.THING,
            TypeQLLexer.ENTITY,
            TypeQLLexer.ATTRIBUTE,
            TypeQLLexer.RELATION,
            TypeQLLexer.ROLE,
                -> THING

            TypeQLLexer.LONG,
            TypeQLLexer.DOUBLE,
            TypeQLLexer.STRING,
            TypeQLLexer.BOOLEAN,
            TypeQLLexer.DATETIME,
                -> TYPE

            TypeQLLexer.MATCH,
            TypeQLLexer.GET,
            TypeQLLexer.DEFINE,
            TypeQLLexer.UNDEFINE,
            TypeQLLexer.RULE,
            TypeQLLexer.INSERT,
            TypeQLLexer.DELETE,
            TypeQLLexer.COMPUTE,

            TypeQLLexer.TYPE,
            TypeQLLexer.ABSTRACT,
            TypeQLLexer.SUB_,
            TypeQLLexer.SUB,
            TypeQLLexer.SUBX,
            TypeQLLexer.OWNS,
            TypeQLLexer.REGEX,
            TypeQLLexer.AS,
            TypeQLLexer.PLAYS,
            TypeQLLexer.RELATES,
            TypeQLLexer.WHEN,
            TypeQLLexer.THEN,
            TypeQLLexer.IID,
            TypeQLLexer.ISA_,
            TypeQLLexer.ISA,
            TypeQLLexer.ISAX,
            TypeQLLexer.HAS,
            TypeQLLexer.VALUE,
            TypeQLLexer.IS,

            TypeQLLexer.OFFSET,
            TypeQLLexer.LIMIT,
            TypeQLLexer.SORT,
            TypeQLLexer.ORDER_,
            TypeQLLexer.ASC,
            TypeQLLexer.DESC,

            TypeQLLexer.UNRECOGNISED,
                -> KEYWORD

            TypeQLLexer.PAREN_OPEN,
            TypeQLLexer.PAREN_CLOSE,
            TypeQLLexer.ASSIGN,
            TypeQLLexer.ADD,
            TypeQLLexer.SUBTRACT,
            TypeQLLexer.DIVIDE,
            TypeQLLexer.MULTIPLY,
            TypeQLLexer.POWER,
            TypeQLLexer.MODULO,

            TypeQLLexer.OR,
            TypeQLLexer.NOT,
            TypeQLLexer.EQ,
            TypeQLLexer.NEQ,
            TypeQLLexer.GT,
            TypeQLLexer.GTE,
            TypeQLLexer.LT,
            TypeQLLexer.LTE,
            TypeQLLexer.LIKE,
            TypeQLLexer.CONTAINS,
                -> OPERATOR

            TypeQLLexer.ANNOTATION_KEY,
            TypeQLLexer.ANNOTATION_UNIQUE ,
                -> ANNOTATION

            TypeQLLexer.GROUP,
            TypeQLLexer.COUNT,
            TypeQLLexer.MAX,
            TypeQLLexer.MIN,
            TypeQLLexer.MEAN,
            TypeQLLexer.MEDIAN,
            TypeQLLexer.STD,
            TypeQLLexer.SUM,
                -> FUNCTION

            TypeQLLexer.BOOLEAN_,
            TypeQLLexer.TRUE,
            TypeQLLexer.FALSE,
                -> BOOLEAN

            TypeQLLexer.QUOTED_STRING,
                -> STRING

            TypeQLLexer.LONG_,
            TypeQLLexer.DOUBLE_,
                -> NUMBER

            TypeQLLexer.DATE_,
            TypeQLLexer.DATETIME_,
                -> DATE

            TypeQLLexer.VAR_CONCEPT_,
            TypeQLLexer.VAR_CONCEPT_ANONYMOUS_,
            TypeQLLexer.VAR_CONCEPT_NAMED_,
            TypeQLLexer.VAR_VALUE_,
                -> VAR

            TypeQLLexer.LABEL_,
            TypeQLLexer.LABEL_SCOPED_,
                -> LABEL

            TypeQLLexer.IID_, // Variable.language
                -> IID

            TypeQLLexer.COMMENT,
                -> LINE_COMMENT

            else
                -> return EMPTY_KEYS
        }

        return arrayOf(attrKey)
    }

    companion object {
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()

        // DefaultLanguageHighlighterColors is only needed in case if colorSchemes from resources do not work.

        val THING = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_THING",
            DefaultLanguageHighlighterColors.IDENTIFIER)

        val TYPE = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_TYPE",
            DefaultLanguageHighlighterColors.MARKUP_TAG)

        val KEYWORD = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD)

        val OPERATOR = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_OPERATOR",
            DefaultLanguageHighlighterColors.KEYWORD)

        val ANNOTATION = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_ANNOTATION",
            DefaultLanguageHighlighterColors.LABEL)

        val FUNCTION = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_FUNCTION",
            DefaultLanguageHighlighterColors.LABEL)

        val BOOLEAN = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_BOOLEAN",
            DefaultLanguageHighlighterColors.PARAMETER)

        val STRING = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_STRING",
            DefaultLanguageHighlighterColors.STRING)

        val NUMBER = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER)

        val DATE = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_DATE",
            DefaultLanguageHighlighterColors.NUMBER)

        val VAR = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_VAR",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE)

        val LABEL = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_LABEL",
            DefaultLanguageHighlighterColors.CONSTANT)

        val IID = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_IID",
            DefaultLanguageHighlighterColors.CONSTANT)

        val LINE_COMMENT = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_LINE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT)

        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
            "TYPEQL_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER)

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                TypeQLLanguage.INSTANCE, TypeQLLexer.tokenNames, TypeQLLexer.ruleNames
            )
        }
    }
}