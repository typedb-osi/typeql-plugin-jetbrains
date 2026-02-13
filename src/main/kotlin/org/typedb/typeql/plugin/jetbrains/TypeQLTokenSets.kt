package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.tree.TokenSet
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

object TypeQLTokenSets {
    @JvmField
    val IDENTIFIERS = TokenSet.create(TypeQLTypes.LABEL, TypeQLTypes.VARIABLE)

    @JvmField
    val COMMENTS = TokenSet.create(TypeQLTypes.LINE_COMMENT)

    @JvmField
    val STRINGS = TokenSet.create(TypeQLTypes.STRING_LITERAL, TypeQLTypes.SINGLE_STRING_LITERAL)

    @JvmField
    val WHITE_SPACES = TokenSet.create(com.intellij.psi.TokenType.WHITE_SPACE)

    @JvmField
    val KEYWORDS = TokenSet.create(
        TypeQLTypes.DEFINE, TypeQLTypes.UNDEFINE, TypeQLTypes.REDEFINE,
        TypeQLTypes.MATCH, TypeQLTypes.INSERT, TypeQLTypes.DELETE,
        TypeQLTypes.UPDATE, TypeQLTypes.PUT, TypeQLTypes.FETCH,
        TypeQLTypes.SELECT, TypeQLTypes.SORT, TypeQLTypes.DISTINCT,
        TypeQLTypes.OFFSET, TypeQLTypes.LIMIT, TypeQLTypes.REQUIRE,
        TypeQLTypes.REDUCE, TypeQLTypes.FUN, TypeQLTypes.RETURN,
        TypeQLTypes.WITH, TypeQLTypes.ISA, TypeQLTypes.ISA_EXACT,
        TypeQLTypes.HAS, TypeQLTypes.LINKS, TypeQLTypes.OWNS,
        TypeQLTypes.PLAYS, TypeQLTypes.RELATES,
        TypeQLTypes.SUB, TypeQLTypes.SUB_EXACT,
        TypeQLTypes.OR, TypeQLTypes.NOT, TypeQLTypes.TRY,
        TypeQLTypes.AS, TypeQLTypes.OF, TypeQLTypes.FROM,
        TypeQLTypes.IN, TypeQLTypes.IS, TypeQLTypes.LET,
        TypeQLTypes.END, TypeQLTypes.ASC, TypeQLTypes.DESC,
        TypeQLTypes.ROLE, TypeQLTypes.VALUE, TypeQLTypes.ALIAS,
        TypeQLTypes.FIRST, TypeQLTypes.LAST, TypeQLTypes.CHECK,
        TypeQLTypes.GROUPBY, TypeQLTypes.IID_KW,
        TypeQLTypes.LIKE, TypeQLTypes.CONTAINS
    )

    @JvmField
    val SCHEMA_TYPES = TokenSet.create(
        TypeQLTypes.ENTITY, TypeQLTypes.RELATION,
        TypeQLTypes.ATTRIBUTE, TypeQLTypes.STRUCT
    )

    @JvmField
    val VALUE_TYPES = TokenSet.create(
        TypeQLTypes.BOOLEAN_TYPE, TypeQLTypes.INTEGER_TYPE,
        TypeQLTypes.DOUBLE_TYPE, TypeQLTypes.DECIMAL_TYPE,
        TypeQLTypes.STRING_TYPE, TypeQLTypes.DATE_TYPE,
        TypeQLTypes.DATETIME_TYPE, TypeQLTypes.DATETIME_TZ_TYPE,
        TypeQLTypes.DURATION_TYPE
    )

    @JvmField
    val FUNCTIONS = TokenSet.create(
        TypeQLTypes.COUNT, TypeQLTypes.MAX, TypeQLTypes.MIN,
        TypeQLTypes.SUM, TypeQLTypes.MEAN, TypeQLTypes.MEDIAN,
        TypeQLTypes.STD, TypeQLTypes.LIST, TypeQLTypes.LABEL_KW,
        TypeQLTypes.ABSTRACT,
        TypeQLTypes.ABS_KW, TypeQLTypes.CEIL_KW, TypeQLTypes.FLOOR_KW,
        TypeQLTypes.ROUND_KW, TypeQLTypes.LEN_KW
    )

    @JvmField
    val BOOLEANS = TokenSet.create(TypeQLTypes.TRUE, TypeQLTypes.FALSE)

    @JvmField
    val OPERATORS = TokenSet.create(
        TypeQLTypes.PLUS, TypeQLTypes.MINUS, TypeQLTypes.STAR,
        TypeQLTypes.SLASH, TypeQLTypes.PERCENT, TypeQLTypes.CARET,
        TypeQLTypes.EQ_EQ, TypeQLTypes.NOT_EQ,
        TypeQLTypes.LT, TypeQLTypes.GT,
        TypeQLTypes.LT_EQ, TypeQLTypes.GT_EQ,
        TypeQLTypes.EQ, TypeQLTypes.QUESTION, TypeQLTypes.EXCLAMATION,
        TypeQLTypes.DOT_DOT, TypeQLTypes.ARROW
    )

    @JvmField
    val NUMERICS = TokenSet.create(
        TypeQLTypes.INTEGER_LITERAL, TypeQLTypes.DOUBLE_LITERAL,
        TypeQLTypes.DECIMAL_LITERAL, TypeQLTypes.IID_LITERAL
    )

    @JvmField
    val DATES = TokenSet.create(
        TypeQLTypes.DATE_LITERAL, TypeQLTypes.DATETIME_LITERAL,
        TypeQLTypes.DATETIME_TZ_LITERAL, TypeQLTypes.DURATION_LITERAL
    )
}
