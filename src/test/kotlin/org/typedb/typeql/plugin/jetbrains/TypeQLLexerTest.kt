package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

class TypeQLLexerTest {

    private fun tokenize(input: String): List<Pair<IElementType, String>> {
        val lexer = TypeQLLexerAdapter()
        lexer.start(input)
        val tokens = mutableListOf<Pair<IElementType, String>>()
        while (lexer.tokenType != null) {
            tokens.add(lexer.tokenType!! to input.substring(lexer.tokenStart, lexer.tokenEnd))
            lexer.advance()
        }
        return tokens
    }

    private fun tokenTypes(input: String): List<IElementType> = tokenize(input).map { it.first }

    private fun tokenTexts(input: String): List<String> = tokenize(input).map { it.second }

    private fun assertSingleToken(input: String, expectedType: IElementType) {
        val tokens = tokenize(input)
        assertEquals("Expected single token for '$input'", 1, tokens.size)
        assertEquals(expectedType, tokens[0].first)
        assertEquals(input, tokens[0].second)
    }

    // ---- Keywords ----

    @Test
    fun testKeywords() {
        val keywords = mapOf(
            "define" to TypeQLTypes.DEFINE,
            "undefine" to TypeQLTypes.UNDEFINE,
            "redefine" to TypeQLTypes.REDEFINE,
            "match" to TypeQLTypes.MATCH,
            "insert" to TypeQLTypes.INSERT,
            "delete" to TypeQLTypes.DELETE,
            "update" to TypeQLTypes.UPDATE,
            "put" to TypeQLTypes.PUT,
            "fetch" to TypeQLTypes.FETCH,
            "select" to TypeQLTypes.SELECT,
            "sort" to TypeQLTypes.SORT,
            "distinct" to TypeQLTypes.DISTINCT,
            "offset" to TypeQLTypes.OFFSET,
            "limit" to TypeQLTypes.LIMIT,
            "require" to TypeQLTypes.REQUIRE,
            "reduce" to TypeQLTypes.REDUCE,
            "fun" to TypeQLTypes.FUN,
            "return" to TypeQLTypes.RETURN,
            "with" to TypeQLTypes.WITH,
            "isa" to TypeQLTypes.ISA,
            "has" to TypeQLTypes.HAS,
            "links" to TypeQLTypes.LINKS,
            "owns" to TypeQLTypes.OWNS,
            "plays" to TypeQLTypes.PLAYS,
            "relates" to TypeQLTypes.RELATES,
            "sub" to TypeQLTypes.SUB,
            "or" to TypeQLTypes.OR,
            "not" to TypeQLTypes.NOT,
            "try" to TypeQLTypes.TRY,
            "as" to TypeQLTypes.AS,
            "of" to TypeQLTypes.OF,
            "from" to TypeQLTypes.FROM,
            "in" to TypeQLTypes.IN,
            "is" to TypeQLTypes.IS,
            "let" to TypeQLTypes.LET,
            "end" to TypeQLTypes.END,
            "asc" to TypeQLTypes.ASC,
            "desc" to TypeQLTypes.DESC,
        )
        for ((text, type) in keywords) {
            assertSingleToken(text, type)
        }
    }

    @Test
    fun testNewKeywords() {
        assertSingleToken("role", TypeQLTypes.ROLE)
        assertSingleToken("value", TypeQLTypes.VALUE)
        assertSingleToken("alias", TypeQLTypes.ALIAS)
        assertSingleToken("first", TypeQLTypes.FIRST)
        assertSingleToken("last", TypeQLTypes.LAST)
        assertSingleToken("check", TypeQLTypes.CHECK)
        assertSingleToken("groupby", TypeQLTypes.GROUPBY)
        assertSingleToken("iid", TypeQLTypes.IID_KW)
        assertSingleToken("like", TypeQLTypes.LIKE)
        assertSingleToken("contains", TypeQLTypes.CONTAINS)
    }

    @Test
    fun testExactKeywords() {
        assertSingleToken("sub!", TypeQLTypes.SUB_EXACT)
        assertSingleToken("isa!", TypeQLTypes.ISA_EXACT)
    }

    @Test
    fun testKeywordAsPartOfIdentifier() {
        // "defined" should be a LABEL, not DEFINE + "d"
        assertSingleToken("defined", TypeQLTypes.LABEL)
        assertSingleToken("matching", TypeQLTypes.LABEL)
        assertSingleToken("subset", TypeQLTypes.LABEL)
    }

    // ---- Schema types ----

    @Test
    fun testSchemaTypes() {
        assertSingleToken("entity", TypeQLTypes.ENTITY)
        assertSingleToken("relation", TypeQLTypes.RELATION)
        assertSingleToken("attribute", TypeQLTypes.ATTRIBUTE)
        assertSingleToken("struct", TypeQLTypes.STRUCT)
    }

    // ---- Value types ----

    @Test
    fun testValueTypes() {
        assertSingleToken("boolean", TypeQLTypes.BOOLEAN_TYPE)
        assertSingleToken("integer", TypeQLTypes.INTEGER_TYPE)
        assertSingleToken("double", TypeQLTypes.DOUBLE_TYPE)
        assertSingleToken("decimal", TypeQLTypes.DECIMAL_TYPE)
        assertSingleToken("string", TypeQLTypes.STRING_TYPE)
        assertSingleToken("date", TypeQLTypes.DATE_TYPE)
        assertSingleToken("datetime", TypeQLTypes.DATETIME_TYPE)
        assertSingleToken("datetime-tz", TypeQLTypes.DATETIME_TZ_TYPE)
        assertSingleToken("duration", TypeQLTypes.DURATION_TYPE)
    }

    // ---- Aggregates / functions ----

    @Test
    fun testFunctions() {
        assertSingleToken("count", TypeQLTypes.COUNT)
        assertSingleToken("max", TypeQLTypes.MAX)
        assertSingleToken("min", TypeQLTypes.MIN)
        assertSingleToken("sum", TypeQLTypes.SUM)
        assertSingleToken("mean", TypeQLTypes.MEAN)
        assertSingleToken("median", TypeQLTypes.MEDIAN)
        assertSingleToken("std", TypeQLTypes.STD)
        assertSingleToken("list", TypeQLTypes.LIST)
        assertSingleToken("label", TypeQLTypes.LABEL_KW)
        assertSingleToken("abstract", TypeQLTypes.ABSTRACT)
    }

    @Test
    fun testBuiltinFunctions() {
        assertSingleToken("abs", TypeQLTypes.ABS_KW)
        assertSingleToken("ceil", TypeQLTypes.CEIL_KW)
        assertSingleToken("floor", TypeQLTypes.FLOOR_KW)
        assertSingleToken("round", TypeQLTypes.ROUND_KW)
        assertSingleToken("len", TypeQLTypes.LEN_KW)
    }

    // ---- Booleans ----

    @Test
    fun testBooleans() {
        assertSingleToken("true", TypeQLTypes.TRUE)
        assertSingleToken("false", TypeQLTypes.FALSE)
    }

    // ---- Variables ----

    @Test
    fun testVariables() {
        assertSingleToken("\$x", TypeQLTypes.VARIABLE)
        assertSingleToken("\$person", TypeQLTypes.VARIABLE)
        assertSingleToken("\$my_var", TypeQLTypes.VARIABLE)
        assertSingleToken("\$my-var", TypeQLTypes.VARIABLE)
    }

    @Test
    fun testVariablesWithDigitStart() {
        assertSingleToken("\$1", TypeQLTypes.VARIABLE)
        assertSingleToken("\$2x", TypeQLTypes.VARIABLE)
        assertSingleToken("\$0name", TypeQLTypes.VARIABLE)
    }

    @Test
    fun testAnonymousVariable() {
        assertSingleToken("\$_", TypeQLTypes.VARIABLE_ANON)
    }

    @Test
    fun testAnonymousVariableVsNamedUnderscore() {
        // $_x should be VARIABLE (not VARIABLE_ANON + LABEL)
        assertSingleToken("\$_x", TypeQLTypes.VARIABLE)
    }

    // ---- Annotations ----

    @Test
    fun testAnnotations() {
        assertSingleToken("@card", TypeQLTypes.ANNOTATION)
        assertSingleToken("@key", TypeQLTypes.ANNOTATION)
        assertSingleToken("@unique", TypeQLTypes.ANNOTATION)
        assertSingleToken("@my-annotation", TypeQLTypes.ANNOTATION)
    }

    @Test
    fun testAnnotationWithParens() {
        val tokens = tokenize("@card(0..1)")
        assertEquals(TypeQLTypes.ANNOTATION, tokens[0].first)
        assertEquals("@card", tokens[0].second)
        assertEquals(TypeQLTypes.LPAREN, tokens[1].first)
    }

    @Test
    fun testBareAtIsToken() {
        // Bare "@" (not followed by identifier) should be AT punctuation, not ANNOTATION
        assertSingleToken("@", TypeQLTypes.AT)
    }

    @Test
    fun testBareDollarIsBadCharacter() {
        // Bare "$" (not followed by identifier) is invalid TypeQL
        assertSingleToken("$", TokenType.BAD_CHARACTER)
    }

    // ---- Strings ----

    @Test
    fun testStrings() {
        assertSingleToken("\"hello\"", TypeQLTypes.STRING_LITERAL)
        assertSingleToken("\"hello world\"", TypeQLTypes.STRING_LITERAL)
        assertSingleToken("\"escaped \\\"quote\\\"\"", TypeQLTypes.STRING_LITERAL)
        assertSingleToken("\"\"", TypeQLTypes.STRING_LITERAL)
    }

    @Test
    fun testSingleQuotedStrings() {
        assertSingleToken("'hello'", TypeQLTypes.SINGLE_STRING_LITERAL)
        assertSingleToken("'hello world'", TypeQLTypes.SINGLE_STRING_LITERAL)
        assertSingleToken("''", TypeQLTypes.SINGLE_STRING_LITERAL)
    }

    @Test
    fun testSingleQuotedStringsWithEscapes() {
        assertSingleToken("'it\\'s'", TypeQLTypes.SINGLE_STRING_LITERAL)
        assertSingleToken("'escaped \\\\backslash'", TypeQLTypes.SINGLE_STRING_LITERAL)
    }

    @Test
    fun testUnterminatedString() {
        // Unterminated string: the quote doesn't match STRING_LITERAL, falls through to BAD_CHARACTER
        val tokens = tokenize("\"hello")
        assertTrue("Unterminated string should not produce STRING_LITERAL",
            tokens.none { it.first == TypeQLTypes.STRING_LITERAL })
        assertEquals(TokenType.BAD_CHARACTER, tokens[0].first)
        assertEquals("\"", tokens[0].second)
    }

    @Test
    fun testStringWithNewline() {
        // JFlex character class [^\"\\] matches \n, so a string spanning lines
        // is treated as a single STRING_LITERAL (better for syntax highlighting)
        val tokens = tokenize("\"hello\nworld\"")
        assertEquals(1, tokens.size)
        assertEquals(TypeQLTypes.STRING_LITERAL, tokens[0].first)
    }

    // ---- Numbers ----

    @Test
    fun testIntegers() {
        assertSingleToken("0", TypeQLTypes.INTEGER_LITERAL)
        assertSingleToken("42", TypeQLTypes.INTEGER_LITERAL)
        assertSingleToken("123456", TypeQLTypes.INTEGER_LITERAL)
    }

    @Test
    fun testDoubles() {
        assertSingleToken("3.14", TypeQLTypes.DOUBLE_LITERAL)
        assertSingleToken("0.5", TypeQLTypes.DOUBLE_LITERAL)
        assertSingleToken("100.0", TypeQLTypes.DOUBLE_LITERAL)
    }

    @Test
    fun testDoubleScientificNotation() {
        assertSingleToken("1.5e10", TypeQLTypes.DOUBLE_LITERAL)
        assertSingleToken("1.0E5", TypeQLTypes.DOUBLE_LITERAL)
        assertSingleToken("2.5e-3", TypeQLTypes.DOUBLE_LITERAL)
        assertSingleToken("3.0e+2", TypeQLTypes.DOUBLE_LITERAL)
    }

    @Test
    fun testDecimalLiterals() {
        assertSingleToken("123dec", TypeQLTypes.DECIMAL_LITERAL)
        assertSingleToken("1.5dec", TypeQLTypes.DECIMAL_LITERAL)
        assertSingleToken("0dec", TypeQLTypes.DECIMAL_LITERAL)
    }

    @Test
    fun testIidLiterals() {
        assertSingleToken("0x1a2b3c", TypeQLTypes.IID_LITERAL)
        assertSingleToken("0xABCD", TypeQLTypes.IID_LITERAL)
        assertSingleToken("0x0", TypeQLTypes.IID_LITERAL)
    }

    // ---- Dates ----

    @Test
    fun testDates() {
        assertSingleToken("2024-01-15", TypeQLTypes.DATE_LITERAL)
    }

    @Test
    fun testDatetimes() {
        assertSingleToken("2024-01-15T10:30:00", TypeQLTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30", TypeQLTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30:00.123", TypeQLTypes.DATETIME_LITERAL)
    }

    @Test
    fun testDatetimeWithTimezone() {
        assertSingleToken("2024-01-15T10:30:00Z", TypeQLTypes.DATETIME_TZ_LITERAL)
        assertSingleToken("2024-01-15T10:30:00+05:30", TypeQLTypes.DATETIME_TZ_LITERAL)
        assertSingleToken("2024-01-15T10:30:00-05:00", TypeQLTypes.DATETIME_TZ_LITERAL)
    }

    @Test
    fun testDatetimeWithTimezoneShortOffset() {
        // +HH only (no minutes)
        assertSingleToken("2024-01-15T10:30:00+05", TypeQLTypes.DATETIME_TZ_LITERAL)
        // +HHMM (no colon)
        assertSingleToken("2024-01-15T10:30:00+0530", TypeQLTypes.DATETIME_TZ_LITERAL)
        assertSingleToken("2024-01-15T10:30:00-0800", TypeQLTypes.DATETIME_TZ_LITERAL)
    }

    @Test
    fun testDatetimeWithIanaTimezone() {
        assertSingleToken("2024-01-15T10:30:00 America/New_York", TypeQLTypes.DATETIME_TZ_LITERAL)
        assertSingleToken("2024-01-15T10:30:00 Europe/London", TypeQLTypes.DATETIME_TZ_LITERAL)
        assertSingleToken("2024-01-15T10:30:00 Asia/Kolkata", TypeQLTypes.DATETIME_TZ_LITERAL)
    }

    @Test
    fun testDurations() {
        assertSingleToken("P1Y", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("P1Y2M", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("P1Y2M3D", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("P30D", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("PT1H", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("PT30M", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("PT1H30M", TypeQLTypes.DURATION_LITERAL)
    }

    @Test
    fun testDurationWithWeeks() {
        assertSingleToken("P2W", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("P4W", TypeQLTypes.DURATION_LITERAL)
    }

    @Test
    fun testDurationCombinedDateAndTime() {
        assertSingleToken("P1Y2M3DT4H5M6S", TypeQLTypes.DURATION_LITERAL)
    }

    @Test
    fun testDurationFractionalSeconds() {
        assertSingleToken("PT1.5S", TypeQLTypes.DURATION_LITERAL)
        assertSingleToken("PT0.001S", TypeQLTypes.DURATION_LITERAL)
    }

    @Test
    fun testBarePIsLabel() {
        // Bare "P" should be a label, not a duration
        assertSingleToken("P", TypeQLTypes.LABEL)
    }

    @Test
    fun testBarePTIsLabel() {
        // Bare "PT" should be a label, not a duration (no time component)
        assertSingleToken("PT", TypeQLTypes.LABEL)
    }

    // ---- Comments ----

    @Test
    fun testLineComments() {
        assertSingleToken("# this is a comment", TypeQLTypes.LINE_COMMENT)
        assertSingleToken("#comment", TypeQLTypes.LINE_COMMENT)
    }

    @Test
    fun testCommentDoesNotConsumeNewline() {
        val tokens = tokenize("# comment\ndefine")
        assertEquals(3, tokens.size) // comment, whitespace (newline), keyword
        assertEquals(TypeQLTypes.LINE_COMMENT, tokens[0].first)
        assertEquals(com.intellij.psi.TokenType.WHITE_SPACE, tokens[1].first)
        assertEquals(TypeQLTypes.DEFINE, tokens[2].first)
    }

    @Test
    fun testMultipleCommentLines() {
        val tokens = tokenize("# comment1\n# comment2\nmatch")
        val nonWs = tokens.filter { it.first != com.intellij.psi.TokenType.WHITE_SPACE }
        assertEquals(3, nonWs.size)
        assertEquals(TypeQLTypes.LINE_COMMENT, nonWs[0].first)
        assertEquals("# comment1", nonWs[0].second)
        assertEquals(TypeQLTypes.LINE_COMMENT, nonWs[1].first)
        assertEquals("# comment2", nonWs[1].second)
        assertEquals(TypeQLTypes.MATCH, nonWs[2].first)
    }

    // ---- Operators ----

    @Test
    fun testOperators() {
        assertSingleToken("+", TypeQLTypes.PLUS)
        assertSingleToken("-", TypeQLTypes.MINUS)
        assertSingleToken("*", TypeQLTypes.STAR)
        assertSingleToken("/", TypeQLTypes.SLASH)
        assertSingleToken("%", TypeQLTypes.PERCENT)
        assertSingleToken("^", TypeQLTypes.CARET)
        assertSingleToken("==", TypeQLTypes.EQ_EQ)
        assertSingleToken("!=", TypeQLTypes.NOT_EQ)
        assertSingleToken("<", TypeQLTypes.LT)
        assertSingleToken(">", TypeQLTypes.GT)
        assertSingleToken("<=", TypeQLTypes.LT_EQ)
        assertSingleToken(">=", TypeQLTypes.GT_EQ)
        assertSingleToken("=", TypeQLTypes.EQ)
        assertSingleToken("?", TypeQLTypes.QUESTION)
        assertSingleToken("!", TypeQLTypes.EXCLAMATION)
        assertSingleToken("..", TypeQLTypes.DOT_DOT)
        assertSingleToken("->", TypeQLTypes.ARROW)
    }

    @Test
    fun testArrowVsMinusGreaterThan() {
        // "->" is a single ARROW token
        val arrowTokens = tokenize("->")
        assertEquals(1, arrowTokens.size)
        assertEquals(TypeQLTypes.ARROW, arrowTokens[0].first)

        // "- >" with space is MINUS + WHITE_SPACE + GT
        val separateTokens = tokenize("- >")
        val types = separateTokens.map { it.first }
        assertEquals(listOf(TypeQLTypes.MINUS, com.intellij.psi.TokenType.WHITE_SPACE, TypeQLTypes.GT), types)
    }

    @Test
    fun testDotDotVsDot() {
        // ".." is DOT_DOT
        assertSingleToken("..", TypeQLTypes.DOT_DOT)

        // "..." is DOT_DOT + DOT
        val tokens = tokenize("...")
        assertEquals(2, tokens.size)
        assertEquals(TypeQLTypes.DOT_DOT, tokens[0].first)
        assertEquals(TypeQLTypes.DOT, tokens[1].first)

        // "0..1" is INTEGER + DOT_DOT + INTEGER
        val rangeTokens = tokenize("0..1")
        assertEquals(3, rangeTokens.size)
        assertEquals(TypeQLTypes.INTEGER_LITERAL, rangeTokens[0].first)
        assertEquals(TypeQLTypes.DOT_DOT, rangeTokens[1].first)
        assertEquals(TypeQLTypes.INTEGER_LITERAL, rangeTokens[2].first)
    }

    @Test
    fun testNegativeNumberIsTwoTokens() {
        // "-42" is MINUS + INTEGER_LITERAL (parser handles unary minus)
        val tokens = tokenize("-42")
        assertEquals(2, tokens.size)
        assertEquals(TypeQLTypes.MINUS, tokens[0].first)
        assertEquals(TypeQLTypes.INTEGER_LITERAL, tokens[1].first)
        assertEquals("42", tokens[1].second)
    }

    // ---- Punctuation ----

    @Test
    fun testPunctuation() {
        assertSingleToken("(", TypeQLTypes.LPAREN)
        assertSingleToken(")", TypeQLTypes.RPAREN)
        assertSingleToken("{", TypeQLTypes.LBRACE)
        assertSingleToken("}", TypeQLTypes.RBRACE)
        assertSingleToken("[", TypeQLTypes.LBRACKET)
        assertSingleToken("]", TypeQLTypes.RBRACKET)
        assertSingleToken(";", TypeQLTypes.SEMICOLON)
        assertSingleToken(",", TypeQLTypes.COMMA)
        assertSingleToken(":", TypeQLTypes.COLON)
        assertSingleToken(".", TypeQLTypes.DOT)
        assertSingleToken("|", TypeQLTypes.PIPE)
    }

    // ---- Identifiers (labels) ----

    @Test
    fun testLabels() {
        assertSingleToken("person", TypeQLTypes.LABEL)
        assertSingleToken("my_type", TypeQLTypes.LABEL)
        assertSingleToken("my-type", TypeQLTypes.LABEL)
        assertSingleToken("_private", TypeQLTypes.LABEL)
    }

    @Test
    fun testHyphenatedLabelVsKeyword() {
        // "sub-type" should be a single LABEL, not SUB + MINUS + ...
        assertSingleToken("sub-type", TypeQLTypes.LABEL)
        assertSingleToken("has-value", TypeQLTypes.LABEL)
    }

    // ---- Full define block ----

    @Test
    fun testDefineBlock() {
        val input = """
            define
            entity person sub entity,
                owns name @card(0..1);
        """.trimIndent()
        val tokens = tokenize(input).filter { it.first != com.intellij.psi.TokenType.WHITE_SPACE }
        val types = tokens.map { it.first }

        assertEquals(TypeQLTypes.DEFINE, types[0])           // define
        assertEquals(TypeQLTypes.ENTITY, types[1])           // entity
        assertEquals(TypeQLTypes.LABEL, types[2])            // person
        assertEquals(TypeQLTypes.SUB, types[3])              // sub
        assertEquals(TypeQLTypes.ENTITY, types[4])           // entity
        assertEquals(TypeQLTypes.COMMA, types[5])            // ,
        assertEquals(TypeQLTypes.OWNS, types[6])             // owns
        assertEquals(TypeQLTypes.LABEL, types[7])            // name
        assertEquals(TypeQLTypes.ANNOTATION, types[8])       // @card
        assertEquals(TypeQLTypes.LPAREN, types[9])           // (
        assertEquals(TypeQLTypes.INTEGER_LITERAL, types[10]) // 0
        assertEquals(TypeQLTypes.DOT_DOT, types[11])         // ..
        assertEquals(TypeQLTypes.INTEGER_LITERAL, types[12]) // 1
        assertEquals(TypeQLTypes.RPAREN, types[13])          // )
        assertEquals(TypeQLTypes.SEMICOLON, types[14])       // ;
    }

    // ---- Full match pipeline ----

    @Test
    fun testMatchPipeline() {
        val input = """
            match
            ${'$'}p isa person, has name "Alice";
            select ${'$'}p;
            sort ${'$'}p asc;
            limit 10;
        """.trimIndent()
        val tokens = tokenize(input).filter { it.first != com.intellij.psi.TokenType.WHITE_SPACE }
        val types = tokens.map { it.first }

        assertEquals(TypeQLTypes.MATCH, types[0])           // match
        assertEquals(TypeQLTypes.VARIABLE, types[1])        // $p
        assertEquals(TypeQLTypes.ISA, types[2])             // isa
        assertEquals(TypeQLTypes.LABEL, types[3])           // person
        assertEquals(TypeQLTypes.COMMA, types[4])           // ,
        assertEquals(TypeQLTypes.HAS, types[5])             // has
        assertEquals(TypeQLTypes.LABEL, types[6])           // name
        assertEquals(TypeQLTypes.STRING_LITERAL, types[7])  // "Alice"
        assertEquals(TypeQLTypes.SEMICOLON, types[8])       // ;
        assertEquals(TypeQLTypes.SELECT, types[9])          // select
        assertEquals(TypeQLTypes.VARIABLE, types[10])       // $p
        assertEquals(TypeQLTypes.SEMICOLON, types[11])      // ;
        assertEquals(TypeQLTypes.SORT, types[12])           // sort
        assertEquals(TypeQLTypes.VARIABLE, types[13])       // $p
        assertEquals(TypeQLTypes.ASC, types[14])            // asc
        assertEquals(TypeQLTypes.SEMICOLON, types[15])      // ;
        assertEquals(TypeQLTypes.LIMIT, types[16])          // limit
        assertEquals(TypeQLTypes.INTEGER_LITERAL, types[17])// 10
        assertEquals(TypeQLTypes.SEMICOLON, types[18])      // ;
    }

    @Test
    fun testHyphenatedKeywordExtension() {
        // "datetime-tz-extra" should be a single LABEL, not DATETIME_TZ_TYPE + something
        assertSingleToken("datetime-tz-extra", TypeQLTypes.LABEL)
        // "date-time" should be a single LABEL, not DATE_TYPE + ...
        assertSingleToken("date-time", TypeQLTypes.LABEL)
    }

    // ---- Whitespace handling ----

    @Test
    fun testWhitespace() {
        val tokens = tokenize("  \t\n  ")
        assertEquals(1, tokens.size)
        assertEquals(com.intellij.psi.TokenType.WHITE_SPACE, tokens[0].first)
    }

    // ---- Edge cases ----

    @Test
    fun testEmptyInput() {
        val tokens = tokenize("")
        assertTrue("Empty input should produce no tokens", tokens.isEmpty())
    }

    @Test
    fun testBadCharacters() {
        assertSingleToken("~", TokenType.BAD_CHARACTER)
        assertSingleToken("`", TokenType.BAD_CHARACTER)

        // Multiple bad characters are individual tokens
        val tokens = tokenize("~`")
        assertEquals(2, tokens.size)
        assertEquals(TokenType.BAD_CHARACTER, tokens[0].first)
        assertEquals(TokenType.BAD_CHARACTER, tokens[1].first)
    }
}
