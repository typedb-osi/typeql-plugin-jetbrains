package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.tree.TokenSet

object TypeQLTokenSets {
    @JvmField
    val COMMENTS = TokenSet.create(TypeQLTokenTypes.LINE_COMMENT)

    @JvmField
    val STRINGS = TokenSet.create(TypeQLTokenTypes.STRING_LITERAL)

    @JvmField
    val WHITE_SPACES = TokenSet.create(TypeQLTokenTypes.WHITE_SPACE)

    @JvmField
    val KEYWORDS = TokenSet.create(
        TypeQLTokenTypes.DEFINE, TypeQLTokenTypes.UNDEFINE, TypeQLTokenTypes.REDEFINE,
        TypeQLTokenTypes.MATCH, TypeQLTokenTypes.INSERT, TypeQLTokenTypes.DELETE,
        TypeQLTokenTypes.UPDATE, TypeQLTokenTypes.PUT, TypeQLTokenTypes.FETCH,
        TypeQLTokenTypes.SELECT, TypeQLTokenTypes.SORT, TypeQLTokenTypes.DISTINCT,
        TypeQLTokenTypes.OFFSET, TypeQLTokenTypes.LIMIT, TypeQLTokenTypes.REQUIRE,
        TypeQLTokenTypes.REDUCE, TypeQLTokenTypes.FUN, TypeQLTokenTypes.RETURN,
        TypeQLTokenTypes.WITH, TypeQLTokenTypes.ISA, TypeQLTokenTypes.HAS,
        TypeQLTokenTypes.LINKS, TypeQLTokenTypes.OWNS, TypeQLTokenTypes.PLAYS,
        TypeQLTokenTypes.RELATES, TypeQLTokenTypes.SUB, TypeQLTokenTypes.OR,
        TypeQLTokenTypes.NOT, TypeQLTokenTypes.TRY, TypeQLTokenTypes.AS,
        TypeQLTokenTypes.OF, TypeQLTokenTypes.FROM, TypeQLTokenTypes.IN,
        TypeQLTokenTypes.IS, TypeQLTokenTypes.LET, TypeQLTokenTypes.END,
        TypeQLTokenTypes.ASC, TypeQLTokenTypes.DESC
    )

    @JvmField
    val SCHEMA_TYPES = TokenSet.create(
        TypeQLTokenTypes.ENTITY, TypeQLTokenTypes.RELATION,
        TypeQLTokenTypes.ATTRIBUTE, TypeQLTokenTypes.STRUCT
    )

    @JvmField
    val VALUE_TYPES = TokenSet.create(
        TypeQLTokenTypes.BOOLEAN_TYPE, TypeQLTokenTypes.INTEGER_TYPE,
        TypeQLTokenTypes.DOUBLE_TYPE, TypeQLTokenTypes.DECIMAL_TYPE,
        TypeQLTokenTypes.STRING_TYPE, TypeQLTokenTypes.DATE_TYPE,
        TypeQLTokenTypes.DATETIME_TYPE, TypeQLTokenTypes.DATETIME_TZ_TYPE,
        TypeQLTokenTypes.DURATION_TYPE
    )

    @JvmField
    val FUNCTIONS = TokenSet.create(
        TypeQLTokenTypes.COUNT, TypeQLTokenTypes.MAX, TypeQLTokenTypes.MIN,
        TypeQLTokenTypes.SUM, TypeQLTokenTypes.MEAN, TypeQLTokenTypes.MEDIAN,
        TypeQLTokenTypes.STD, TypeQLTokenTypes.LIST, TypeQLTokenTypes.LABEL_KW,
        TypeQLTokenTypes.ABSTRACT
    )

    @JvmField
    val BOOLEANS = TokenSet.create(TypeQLTokenTypes.TRUE, TypeQLTokenTypes.FALSE)

    @JvmField
    val OPERATORS = TokenSet.create(
        TypeQLTokenTypes.PLUS, TypeQLTokenTypes.MINUS, TypeQLTokenTypes.STAR,
        TypeQLTokenTypes.SLASH, TypeQLTokenTypes.PERCENT, TypeQLTokenTypes.CARET,
        TypeQLTokenTypes.EQ_EQ, TypeQLTokenTypes.NOT_EQ,
        TypeQLTokenTypes.LT, TypeQLTokenTypes.GT,
        TypeQLTokenTypes.LT_EQ, TypeQLTokenTypes.GT_EQ,
        TypeQLTokenTypes.EQ, TypeQLTokenTypes.QUESTION, TypeQLTokenTypes.EXCLAMATION,
        TypeQLTokenTypes.DOT_DOT, TypeQLTokenTypes.ARROW
    )

    @JvmField
    val NUMERICS = TokenSet.create(
        TypeQLTokenTypes.INTEGER_LITERAL, TypeQLTokenTypes.DOUBLE_LITERAL
    )

    @JvmField
    val DATES = TokenSet.create(
        TypeQLTokenTypes.DATE_LITERAL, TypeQLTokenTypes.DATETIME_LITERAL,
        TypeQLTokenTypes.DURATION_LITERAL
    )
}
