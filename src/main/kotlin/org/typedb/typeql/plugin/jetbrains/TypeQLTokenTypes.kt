package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.tree.IElementType

class TypeQLTokenType(debugName: String) : IElementType(debugName, TypeQLLanguage)
class TypeQLElementType(debugName: String) : IElementType(debugName, TypeQLLanguage)

object TypeQLTokenTypes {
    // Keywords
    @JvmField val DEFINE = TypeQLTokenType("DEFINE")
    @JvmField val UNDEFINE = TypeQLTokenType("UNDEFINE")
    @JvmField val REDEFINE = TypeQLTokenType("REDEFINE")
    @JvmField val MATCH = TypeQLTokenType("MATCH")
    @JvmField val INSERT = TypeQLTokenType("INSERT")
    @JvmField val DELETE = TypeQLTokenType("DELETE")
    @JvmField val UPDATE = TypeQLTokenType("UPDATE")
    @JvmField val PUT = TypeQLTokenType("PUT")
    @JvmField val FETCH = TypeQLTokenType("FETCH")
    @JvmField val SELECT = TypeQLTokenType("SELECT")
    @JvmField val SORT = TypeQLTokenType("SORT")
    @JvmField val DISTINCT = TypeQLTokenType("DISTINCT")
    @JvmField val OFFSET = TypeQLTokenType("OFFSET")
    @JvmField val LIMIT = TypeQLTokenType("LIMIT")
    @JvmField val REQUIRE = TypeQLTokenType("REQUIRE")
    @JvmField val REDUCE = TypeQLTokenType("REDUCE")
    @JvmField val FUN = TypeQLTokenType("FUN")
    @JvmField val RETURN = TypeQLTokenType("RETURN")
    @JvmField val WITH = TypeQLTokenType("WITH")
    @JvmField val ISA = TypeQLTokenType("ISA")
    @JvmField val HAS = TypeQLTokenType("HAS")
    @JvmField val LINKS = TypeQLTokenType("LINKS")
    @JvmField val OWNS = TypeQLTokenType("OWNS")
    @JvmField val PLAYS = TypeQLTokenType("PLAYS")
    @JvmField val RELATES = TypeQLTokenType("RELATES")
    @JvmField val SUB = TypeQLTokenType("SUB")
    @JvmField val OR = TypeQLTokenType("OR")
    @JvmField val NOT = TypeQLTokenType("NOT")
    @JvmField val TRY = TypeQLTokenType("TRY")
    @JvmField val AS = TypeQLTokenType("AS")
    @JvmField val OF = TypeQLTokenType("OF")
    @JvmField val FROM = TypeQLTokenType("FROM")
    @JvmField val IN = TypeQLTokenType("IN")
    @JvmField val IS = TypeQLTokenType("IS")
    @JvmField val LET = TypeQLTokenType("LET")
    @JvmField val END = TypeQLTokenType("END")
    @JvmField val ASC = TypeQLTokenType("ASC")
    @JvmField val DESC = TypeQLTokenType("DESC")

    // Schema types
    @JvmField val ENTITY = TypeQLTokenType("ENTITY")
    @JvmField val RELATION = TypeQLTokenType("RELATION")
    @JvmField val ATTRIBUTE = TypeQLTokenType("ATTRIBUTE")
    @JvmField val STRUCT = TypeQLTokenType("STRUCT")

    // Value types
    @JvmField val BOOLEAN_TYPE = TypeQLTokenType("BOOLEAN_TYPE")
    @JvmField val INTEGER_TYPE = TypeQLTokenType("INTEGER_TYPE")
    @JvmField val DOUBLE_TYPE = TypeQLTokenType("DOUBLE_TYPE")
    @JvmField val DECIMAL_TYPE = TypeQLTokenType("DECIMAL_TYPE")
    @JvmField val STRING_TYPE = TypeQLTokenType("STRING_TYPE")
    @JvmField val DATE_TYPE = TypeQLTokenType("DATE_TYPE")
    @JvmField val DATETIME_TYPE = TypeQLTokenType("DATETIME_TYPE")
    @JvmField val DATETIME_TZ_TYPE = TypeQLTokenType("DATETIME_TZ_TYPE")
    @JvmField val DURATION_TYPE = TypeQLTokenType("DURATION_TYPE")

    // Aggregates / unreserved keywords
    @JvmField val COUNT = TypeQLTokenType("COUNT")
    @JvmField val MAX = TypeQLTokenType("MAX")
    @JvmField val MIN = TypeQLTokenType("MIN")
    @JvmField val SUM = TypeQLTokenType("SUM")
    @JvmField val MEAN = TypeQLTokenType("MEAN")
    @JvmField val MEDIAN = TypeQLTokenType("MEDIAN")
    @JvmField val STD = TypeQLTokenType("STD")
    @JvmField val LIST = TypeQLTokenType("LIST")
    @JvmField val LABEL_KW = TypeQLTokenType("LABEL_KW")
    @JvmField val ABSTRACT = TypeQLTokenType("ABSTRACT")

    // Booleans
    @JvmField val TRUE = TypeQLTokenType("TRUE")
    @JvmField val FALSE = TypeQLTokenType("FALSE")

    // Literals
    @JvmField val STRING_LITERAL = TypeQLTokenType("STRING_LITERAL")
    @JvmField val INTEGER_LITERAL = TypeQLTokenType("INTEGER_LITERAL")
    @JvmField val DOUBLE_LITERAL = TypeQLTokenType("DOUBLE_LITERAL")
    @JvmField val DATE_LITERAL = TypeQLTokenType("DATE_LITERAL")
    @JvmField val DATETIME_LITERAL = TypeQLTokenType("DATETIME_LITERAL")
    @JvmField val DURATION_LITERAL = TypeQLTokenType("DURATION_LITERAL")

    // Variable & annotation
    @JvmField val VARIABLE = TypeQLTokenType("VARIABLE")
    @JvmField val ANNOTATION = TypeQLTokenType("ANNOTATION")

    // Comment
    @JvmField val LINE_COMMENT = TypeQLTokenType("LINE_COMMENT")

    // Operators
    @JvmField val PLUS = TypeQLTokenType("PLUS")
    @JvmField val MINUS = TypeQLTokenType("MINUS")
    @JvmField val STAR = TypeQLTokenType("STAR")
    @JvmField val SLASH = TypeQLTokenType("SLASH")
    @JvmField val PERCENT = TypeQLTokenType("PERCENT")
    @JvmField val CARET = TypeQLTokenType("CARET")
    @JvmField val EQ_EQ = TypeQLTokenType("EQ_EQ")
    @JvmField val NOT_EQ = TypeQLTokenType("NOT_EQ")
    @JvmField val LT = TypeQLTokenType("LT")
    @JvmField val GT = TypeQLTokenType("GT")
    @JvmField val LT_EQ = TypeQLTokenType("LT_EQ")
    @JvmField val GT_EQ = TypeQLTokenType("GT_EQ")
    @JvmField val EQ = TypeQLTokenType("EQ")
    @JvmField val QUESTION = TypeQLTokenType("QUESTION")
    @JvmField val EXCLAMATION = TypeQLTokenType("EXCLAMATION")
    @JvmField val DOT_DOT = TypeQLTokenType("DOT_DOT")
    @JvmField val ARROW = TypeQLTokenType("ARROW")

    // Punctuation
    @JvmField val LPAREN = TypeQLTokenType("LPAREN")
    @JvmField val RPAREN = TypeQLTokenType("RPAREN")
    @JvmField val LBRACE = TypeQLTokenType("LBRACE")
    @JvmField val RBRACE = TypeQLTokenType("RBRACE")
    @JvmField val LBRACKET = TypeQLTokenType("LBRACKET")
    @JvmField val RBRACKET = TypeQLTokenType("RBRACKET")
    @JvmField val SEMICOLON = TypeQLTokenType("SEMICOLON")
    @JvmField val COMMA = TypeQLTokenType("COMMA")
    @JvmField val COLON = TypeQLTokenType("COLON")
    @JvmField val DOT = TypeQLTokenType("DOT")
    @JvmField val AT = TypeQLTokenType("AT")
    @JvmField val PIPE = TypeQLTokenType("PIPE")

    // Identifier (type labels)
    @JvmField val LABEL = TypeQLTokenType("LABEL")

    // Whitespace & bad character
    @JvmField val WHITE_SPACE = com.intellij.psi.TokenType.WHITE_SPACE
    @JvmField val BAD_CHARACTER = com.intellij.psi.TokenType.BAD_CHARACTER

    // File-level element
    @JvmField val FILE = TypeQLElementType("FILE")
}
