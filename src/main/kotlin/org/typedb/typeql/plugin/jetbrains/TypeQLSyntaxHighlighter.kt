package org.typedb.typeql.plugin.jetbrains

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

class TypeQLSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val KEYWORD = createTextAttributesKey("TYPEQL_KEYWORD")
        val STORAGE_TYPE = createTextAttributesKey("TYPEQL_STORAGE_TYPE")
        val STORAGE_MODIFIER = createTextAttributesKey("TYPEQL_STORAGE_MODIFIER")
        val FUNCTION = createTextAttributesKey("TYPEQL_FUNCTION")
        val VARIABLE = createTextAttributesKey("TYPEQL_VARIABLE")
        val ANNOTATION = createTextAttributesKey("TYPEQL_ANNOTATION")
        val STRING = createTextAttributesKey("TYPEQL_STRING")
        val NUMERIC = createTextAttributesKey("TYPEQL_NUMERIC")
        val DATE = createTextAttributesKey("TYPEQL_DATE")
        val BOOLEAN = createTextAttributesKey("TYPEQL_BOOLEAN")
        val LINE_COMMENT = createTextAttributesKey("TYPEQL_LINE_COMMENT")
        val OPERATOR = createTextAttributesKey("TYPEQL_OPERATOR")
        val LABEL = createTextAttributesKey("TYPEQL_LABEL")

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STORAGE_TYPE_KEYS = arrayOf(STORAGE_TYPE)
        private val STORAGE_MODIFIER_KEYS = arrayOf(STORAGE_MODIFIER)
        private val FUNCTION_KEYS = arrayOf(FUNCTION)
        private val VARIABLE_KEYS = arrayOf(VARIABLE)
        private val ANNOTATION_KEYS = arrayOf(ANNOTATION)
        private val STRING_KEYS = arrayOf(STRING)
        private val NUMERIC_KEYS = arrayOf(NUMERIC)
        private val DATE_KEYS = arrayOf(DATE)
        private val BOOLEAN_KEYS = arrayOf(BOOLEAN)
        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val LABEL_KEYS = arrayOf(LABEL)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer(): Lexer = TypeQLLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when {
        TypeQLTokenSets.KEYWORDS.contains(tokenType) -> KEYWORD_KEYS
        TypeQLTokenSets.SCHEMA_TYPES.contains(tokenType) -> STORAGE_TYPE_KEYS
        TypeQLTokenSets.VALUE_TYPES.contains(tokenType) -> STORAGE_MODIFIER_KEYS
        TypeQLTokenSets.FUNCTIONS.contains(tokenType) -> FUNCTION_KEYS
        TypeQLTokenSets.BOOLEANS.contains(tokenType) -> BOOLEAN_KEYS
        TypeQLTokenSets.OPERATORS.contains(tokenType) -> OPERATOR_KEYS
        TypeQLTokenSets.NUMERICS.contains(tokenType) -> NUMERIC_KEYS
        TypeQLTokenSets.DATES.contains(tokenType) -> DATE_KEYS
        tokenType == TypeQLTypes.VARIABLE || tokenType == TypeQLTypes.VARIABLE_ANON -> VARIABLE_KEYS
        tokenType == TypeQLTypes.ANNOTATION -> ANNOTATION_KEYS
        tokenType == TypeQLTypes.STRING_LITERAL || tokenType == TypeQLTypes.SINGLE_STRING_LITERAL -> STRING_KEYS
        tokenType == TypeQLTypes.LINE_COMMENT -> LINE_COMMENT_KEYS
        tokenType == TypeQLTypes.LABEL -> LABEL_KEYS
        else -> EMPTY_KEYS
    }
}
