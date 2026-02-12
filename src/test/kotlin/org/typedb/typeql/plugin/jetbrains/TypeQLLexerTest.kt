package org.typedb.typeql.plugin.jetbrains

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

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
            "define" to TypeQLTokenTypes.DEFINE,
            "undefine" to TypeQLTokenTypes.UNDEFINE,
            "redefine" to TypeQLTokenTypes.REDEFINE,
            "match" to TypeQLTokenTypes.MATCH,
            "insert" to TypeQLTokenTypes.INSERT,
            "delete" to TypeQLTokenTypes.DELETE,
            "update" to TypeQLTokenTypes.UPDATE,
            "put" to TypeQLTokenTypes.PUT,
            "fetch" to TypeQLTokenTypes.FETCH,
            "select" to TypeQLTokenTypes.SELECT,
            "sort" to TypeQLTokenTypes.SORT,
            "distinct" to TypeQLTokenTypes.DISTINCT,
            "offset" to TypeQLTokenTypes.OFFSET,
            "limit" to TypeQLTokenTypes.LIMIT,
            "require" to TypeQLTokenTypes.REQUIRE,
            "reduce" to TypeQLTokenTypes.REDUCE,
            "fun" to TypeQLTokenTypes.FUN,
            "return" to TypeQLTokenTypes.RETURN,
            "with" to TypeQLTokenTypes.WITH,
            "isa" to TypeQLTokenTypes.ISA,
            "has" to TypeQLTokenTypes.HAS,
            "links" to TypeQLTokenTypes.LINKS,
            "owns" to TypeQLTokenTypes.OWNS,
            "plays" to TypeQLTokenTypes.PLAYS,
            "relates" to TypeQLTokenTypes.RELATES,
            "sub" to TypeQLTokenTypes.SUB,
            "or" to TypeQLTokenTypes.OR,
            "not" to TypeQLTokenTypes.NOT,
            "try" to TypeQLTokenTypes.TRY,
            "as" to TypeQLTokenTypes.AS,
            "of" to TypeQLTokenTypes.OF,
            "from" to TypeQLTokenTypes.FROM,
            "in" to TypeQLTokenTypes.IN,
            "is" to TypeQLTokenTypes.IS,
            "let" to TypeQLTokenTypes.LET,
            "end" to TypeQLTokenTypes.END,
            "asc" to TypeQLTokenTypes.ASC,
            "desc" to TypeQLTokenTypes.DESC,
        )
        for ((text, type) in keywords) {
            assertSingleToken(text, type)
        }
    }

    @Test
    fun testKeywordAsPartOfIdentifier() {
        // "defined" should be a LABEL, not DEFINE + "d"
        assertSingleToken("defined", TypeQLTokenTypes.LABEL)
        assertSingleToken("matching", TypeQLTokenTypes.LABEL)
        assertSingleToken("subset", TypeQLTokenTypes.LABEL)
    }

    // ---- Schema types ----

    @Test
    fun testSchemaTypes() {
        assertSingleToken("entity", TypeQLTokenTypes.ENTITY)
        assertSingleToken("relation", TypeQLTokenTypes.RELATION)
        assertSingleToken("attribute", TypeQLTokenTypes.ATTRIBUTE)
        assertSingleToken("struct", TypeQLTokenTypes.STRUCT)
    }

    // ---- Value types ----

    @Test
    fun testValueTypes() {
        assertSingleToken("boolean", TypeQLTokenTypes.BOOLEAN_TYPE)
        assertSingleToken("integer", TypeQLTokenTypes.INTEGER_TYPE)
        assertSingleToken("double", TypeQLTokenTypes.DOUBLE_TYPE)
        assertSingleToken("decimal", TypeQLTokenTypes.DECIMAL_TYPE)
        assertSingleToken("string", TypeQLTokenTypes.STRING_TYPE)
        assertSingleToken("date", TypeQLTokenTypes.DATE_TYPE)
        assertSingleToken("datetime", TypeQLTokenTypes.DATETIME_TYPE)
        assertSingleToken("datetime-tz", TypeQLTokenTypes.DATETIME_TZ_TYPE)
        assertSingleToken("duration", TypeQLTokenTypes.DURATION_TYPE)
    }

    // ---- Aggregates / functions ----

    @Test
    fun testFunctions() {
        assertSingleToken("count", TypeQLTokenTypes.COUNT)
        assertSingleToken("max", TypeQLTokenTypes.MAX)
        assertSingleToken("min", TypeQLTokenTypes.MIN)
        assertSingleToken("sum", TypeQLTokenTypes.SUM)
        assertSingleToken("mean", TypeQLTokenTypes.MEAN)
        assertSingleToken("median", TypeQLTokenTypes.MEDIAN)
        assertSingleToken("std", TypeQLTokenTypes.STD)
        assertSingleToken("list", TypeQLTokenTypes.LIST)
        assertSingleToken("label", TypeQLTokenTypes.LABEL_KW)
        assertSingleToken("abstract", TypeQLTokenTypes.ABSTRACT)
    }

    // ---- Booleans ----

    @Test
    fun testBooleans() {
        assertSingleToken("true", TypeQLTokenTypes.TRUE)
        assertSingleToken("false", TypeQLTokenTypes.FALSE)
    }

    // ---- Variables ----

    @Test
    fun testVariables() {
        assertSingleToken("\$x", TypeQLTokenTypes.VARIABLE)
        assertSingleToken("\$person", TypeQLTokenTypes.VARIABLE)
        assertSingleToken("\$my_var", TypeQLTokenTypes.VARIABLE)
        assertSingleToken("\$my-var", TypeQLTokenTypes.VARIABLE)
    }

    // ---- Annotations ----

    @Test
    fun testAnnotations() {
        assertSingleToken("@card", TypeQLTokenTypes.ANNOTATION)
        assertSingleToken("@key", TypeQLTokenTypes.ANNOTATION)
        assertSingleToken("@unique", TypeQLTokenTypes.ANNOTATION)
        assertSingleToken("@my-annotation", TypeQLTokenTypes.ANNOTATION)
    }

    @Test
    fun testAnnotationWithParens() {
        val tokens = tokenize("@card(0..1)")
        assertEquals(TypeQLTokenTypes.ANNOTATION, tokens[0].first)
        assertEquals("@card", tokens[0].second)
        assertEquals(TypeQLTokenTypes.LPAREN, tokens[1].first)
    }

    @Test
    fun testBareAtIsToken() {
        // Bare "@" (not followed by identifier) should be AT punctuation, not ANNOTATION
        assertSingleToken("@", TypeQLTokenTypes.AT)
    }

    @Test
    fun testBareDollarIsBadCharacter() {
        // Bare "$" (not followed by identifier) is invalid TypeQL
        assertSingleToken("$", TokenType.BAD_CHARACTER)
    }

    // ---- Strings ----

    @Test
    fun testStrings() {
        assertSingleToken("\"hello\"", TypeQLTokenTypes.STRING_LITERAL)
        assertSingleToken("\"hello world\"", TypeQLTokenTypes.STRING_LITERAL)
        assertSingleToken("\"escaped \\\"quote\\\"\"", TypeQLTokenTypes.STRING_LITERAL)
        assertSingleToken("\"\"", TypeQLTokenTypes.STRING_LITERAL)
    }

    @Test
    fun testUnterminatedString() {
        // Unterminated string: the quote doesn't match STRING_LITERAL, falls through to BAD_CHARACTER
        val tokens = tokenize("\"hello")
        assertTrue("Unterminated string should not produce STRING_LITERAL",
            tokens.none { it.first == TypeQLTokenTypes.STRING_LITERAL })
        assertEquals(TokenType.BAD_CHARACTER, tokens[0].first)
        assertEquals("\"", tokens[0].second)
    }

    @Test
    fun testStringWithNewline() {
        // JFlex character class [^\"\\] matches \n, so a string spanning lines
        // is treated as a single STRING_LITERAL (better for syntax highlighting)
        val tokens = tokenize("\"hello\nworld\"")
        assertEquals(1, tokens.size)
        assertEquals(TypeQLTokenTypes.STRING_LITERAL, tokens[0].first)
    }

    // ---- Numbers ----

    @Test
    fun testIntegers() {
        assertSingleToken("0", TypeQLTokenTypes.INTEGER_LITERAL)
        assertSingleToken("42", TypeQLTokenTypes.INTEGER_LITERAL)
        assertSingleToken("123456", TypeQLTokenTypes.INTEGER_LITERAL)
    }

    @Test
    fun testDoubles() {
        assertSingleToken("3.14", TypeQLTokenTypes.DOUBLE_LITERAL)
        assertSingleToken("0.5", TypeQLTokenTypes.DOUBLE_LITERAL)
        assertSingleToken("100.0", TypeQLTokenTypes.DOUBLE_LITERAL)
    }

    // ---- Dates ----

    @Test
    fun testDates() {
        assertSingleToken("2024-01-15", TypeQLTokenTypes.DATE_LITERAL)
    }

    @Test
    fun testDatetimes() {
        assertSingleToken("2024-01-15T10:30:00", TypeQLTokenTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30", TypeQLTokenTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30:00.123", TypeQLTokenTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30:00Z", TypeQLTokenTypes.DATETIME_LITERAL)
        assertSingleToken("2024-01-15T10:30:00+05:30", TypeQLTokenTypes.DATETIME_LITERAL)
    }

    @Test
    fun testDurations() {
        assertSingleToken("P1Y", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("P1Y2M", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("P1Y2M3D", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("P30D", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("PT1H", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("PT30M", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("PT1H30M", TypeQLTokenTypes.DURATION_LITERAL)
    }

    @Test
    fun testDurationCombinedDateAndTime() {
        assertSingleToken("P1Y2M3DT4H5M6S", TypeQLTokenTypes.DURATION_LITERAL)
    }

    @Test
    fun testDurationFractionalSeconds() {
        assertSingleToken("PT1.5S", TypeQLTokenTypes.DURATION_LITERAL)
        assertSingleToken("PT0.001S", TypeQLTokenTypes.DURATION_LITERAL)
    }

    @Test
    fun testBarePIsLabel() {
        // Bare "P" should be a label, not a duration
        assertSingleToken("P", TypeQLTokenTypes.LABEL)
    }

    @Test
    fun testBarePTIsLabel() {
        // Bare "PT" should be a label, not a duration (no time component)
        assertSingleToken("PT", TypeQLTokenTypes.LABEL)
    }

    // ---- Comments ----

    @Test
    fun testLineComments() {
        assertSingleToken("# this is a comment", TypeQLTokenTypes.LINE_COMMENT)
        assertSingleToken("#comment", TypeQLTokenTypes.LINE_COMMENT)
    }

    @Test
    fun testCommentDoesNotConsumeNewline() {
        val tokens = tokenize("# comment\ndefine")
        assertEquals(3, tokens.size) // comment, whitespace (newline), keyword
        assertEquals(TypeQLTokenTypes.LINE_COMMENT, tokens[0].first)
        assertEquals(TypeQLTokenTypes.WHITE_SPACE, tokens[1].first)
        assertEquals(TypeQLTokenTypes.DEFINE, tokens[2].first)
    }

    @Test
    fun testMultipleCommentLines() {
        val tokens = tokenize("# comment1\n# comment2\nmatch")
        val nonWs = tokens.filter { it.first != TypeQLTokenTypes.WHITE_SPACE }
        assertEquals(3, nonWs.size)
        assertEquals(TypeQLTokenTypes.LINE_COMMENT, nonWs[0].first)
        assertEquals("# comment1", nonWs[0].second)
        assertEquals(TypeQLTokenTypes.LINE_COMMENT, nonWs[1].first)
        assertEquals("# comment2", nonWs[1].second)
        assertEquals(TypeQLTokenTypes.MATCH, nonWs[2].first)
    }

    // ---- Operators ----

    @Test
    fun testOperators() {
        assertSingleToken("+", TypeQLTokenTypes.PLUS)
        assertSingleToken("-", TypeQLTokenTypes.MINUS)
        assertSingleToken("*", TypeQLTokenTypes.STAR)
        assertSingleToken("/", TypeQLTokenTypes.SLASH)
        assertSingleToken("%", TypeQLTokenTypes.PERCENT)
        assertSingleToken("^", TypeQLTokenTypes.CARET)
        assertSingleToken("==", TypeQLTokenTypes.EQ_EQ)
        assertSingleToken("!=", TypeQLTokenTypes.NOT_EQ)
        assertSingleToken("<", TypeQLTokenTypes.LT)
        assertSingleToken(">", TypeQLTokenTypes.GT)
        assertSingleToken("<=", TypeQLTokenTypes.LT_EQ)
        assertSingleToken(">=", TypeQLTokenTypes.GT_EQ)
        assertSingleToken("=", TypeQLTokenTypes.EQ)
        assertSingleToken("?", TypeQLTokenTypes.QUESTION)
        assertSingleToken("!", TypeQLTokenTypes.EXCLAMATION)
        assertSingleToken("..", TypeQLTokenTypes.DOT_DOT)
        assertSingleToken("->", TypeQLTokenTypes.ARROW)
    }

    @Test
    fun testArrowVsMinusGreaterThan() {
        // "->" is a single ARROW token
        val arrowTokens = tokenize("->")
        assertEquals(1, arrowTokens.size)
        assertEquals(TypeQLTokenTypes.ARROW, arrowTokens[0].first)

        // "- >" with space is MINUS + WHITE_SPACE + GT
        val separateTokens = tokenize("- >")
        val types = separateTokens.map { it.first }
        assertEquals(listOf(TypeQLTokenTypes.MINUS, TypeQLTokenTypes.WHITE_SPACE, TypeQLTokenTypes.GT), types)
    }

    @Test
    fun testDotDotVsDot() {
        // ".." is DOT_DOT
        assertSingleToken("..", TypeQLTokenTypes.DOT_DOT)

        // "..." is DOT_DOT + DOT
        val tokens = tokenize("...")
        assertEquals(2, tokens.size)
        assertEquals(TypeQLTokenTypes.DOT_DOT, tokens[0].first)
        assertEquals(TypeQLTokenTypes.DOT, tokens[1].first)

        // "0..1" is INTEGER + DOT_DOT + INTEGER
        val rangeTokens = tokenize("0..1")
        assertEquals(3, rangeTokens.size)
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, rangeTokens[0].first)
        assertEquals(TypeQLTokenTypes.DOT_DOT, rangeTokens[1].first)
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, rangeTokens[2].first)
    }

    @Test
    fun testNegativeNumberIsTwoTokens() {
        // "-42" is MINUS + INTEGER_LITERAL (parser handles unary minus)
        val tokens = tokenize("-42")
        assertEquals(2, tokens.size)
        assertEquals(TypeQLTokenTypes.MINUS, tokens[0].first)
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, tokens[1].first)
        assertEquals("42", tokens[1].second)
    }

    // ---- Punctuation ----

    @Test
    fun testPunctuation() {
        assertSingleToken("(", TypeQLTokenTypes.LPAREN)
        assertSingleToken(")", TypeQLTokenTypes.RPAREN)
        assertSingleToken("{", TypeQLTokenTypes.LBRACE)
        assertSingleToken("}", TypeQLTokenTypes.RBRACE)
        assertSingleToken("[", TypeQLTokenTypes.LBRACKET)
        assertSingleToken("]", TypeQLTokenTypes.RBRACKET)
        assertSingleToken(";", TypeQLTokenTypes.SEMICOLON)
        assertSingleToken(",", TypeQLTokenTypes.COMMA)
        assertSingleToken(":", TypeQLTokenTypes.COLON)
        assertSingleToken(".", TypeQLTokenTypes.DOT)
        assertSingleToken("|", TypeQLTokenTypes.PIPE)
    }

    // ---- Identifiers (labels) ----

    @Test
    fun testLabels() {
        assertSingleToken("person", TypeQLTokenTypes.LABEL)
        assertSingleToken("my_type", TypeQLTokenTypes.LABEL)
        assertSingleToken("my-type", TypeQLTokenTypes.LABEL)
        assertSingleToken("_private", TypeQLTokenTypes.LABEL)
    }

    @Test
    fun testHyphenatedLabelVsKeyword() {
        // "sub-type" should be a single LABEL, not SUB + MINUS + ...
        assertSingleToken("sub-type", TypeQLTokenTypes.LABEL)
        assertSingleToken("has-value", TypeQLTokenTypes.LABEL)
    }

    // ---- Full define block ----

    @Test
    fun testDefineBlock() {
        val input = """
            define
            entity person sub entity,
                owns name @card(0..1);
        """.trimIndent()
        val tokens = tokenize(input).filter { it.first != TypeQLTokenTypes.WHITE_SPACE }
        val types = tokens.map { it.first }

        assertEquals(TypeQLTokenTypes.DEFINE, types[0])           // define
        assertEquals(TypeQLTokenTypes.ENTITY, types[1])           // entity
        assertEquals(TypeQLTokenTypes.LABEL, types[2])            // person
        assertEquals(TypeQLTokenTypes.SUB, types[3])              // sub
        assertEquals(TypeQLTokenTypes.ENTITY, types[4])           // entity
        assertEquals(TypeQLTokenTypes.COMMA, types[5])            // ,
        assertEquals(TypeQLTokenTypes.OWNS, types[6])             // owns
        assertEquals(TypeQLTokenTypes.LABEL, types[7])            // name
        assertEquals(TypeQLTokenTypes.ANNOTATION, types[8])       // @card
        assertEquals(TypeQLTokenTypes.LPAREN, types[9])           // (
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, types[10]) // 0
        assertEquals(TypeQLTokenTypes.DOT_DOT, types[11])         // ..
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, types[12]) // 1
        assertEquals(TypeQLTokenTypes.RPAREN, types[13])          // )
        assertEquals(TypeQLTokenTypes.SEMICOLON, types[14])       // ;
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
        val tokens = tokenize(input).filter { it.first != TypeQLTokenTypes.WHITE_SPACE }
        val types = tokens.map { it.first }

        assertEquals(TypeQLTokenTypes.MATCH, types[0])           // match
        assertEquals(TypeQLTokenTypes.VARIABLE, types[1])        // $p
        assertEquals(TypeQLTokenTypes.ISA, types[2])             // isa
        assertEquals(TypeQLTokenTypes.LABEL, types[3])           // person
        assertEquals(TypeQLTokenTypes.COMMA, types[4])           // ,
        assertEquals(TypeQLTokenTypes.HAS, types[5])             // has
        assertEquals(TypeQLTokenTypes.LABEL, types[6])           // name
        assertEquals(TypeQLTokenTypes.STRING_LITERAL, types[7])  // "Alice"
        assertEquals(TypeQLTokenTypes.SEMICOLON, types[8])       // ;
        assertEquals(TypeQLTokenTypes.SELECT, types[9])          // select
        assertEquals(TypeQLTokenTypes.VARIABLE, types[10])       // $p
        assertEquals(TypeQLTokenTypes.SEMICOLON, types[11])      // ;
        assertEquals(TypeQLTokenTypes.SORT, types[12])           // sort
        assertEquals(TypeQLTokenTypes.VARIABLE, types[13])       // $p
        assertEquals(TypeQLTokenTypes.ASC, types[14])            // asc
        assertEquals(TypeQLTokenTypes.SEMICOLON, types[15])      // ;
        assertEquals(TypeQLTokenTypes.LIMIT, types[16])          // limit
        assertEquals(TypeQLTokenTypes.INTEGER_LITERAL, types[17])// 10
        assertEquals(TypeQLTokenTypes.SEMICOLON, types[18])      // ;
    }

    @Test
    fun testHyphenatedKeywordExtension() {
        // "datetime-tz-extra" should be a single LABEL, not DATETIME_TZ_TYPE + something
        assertSingleToken("datetime-tz-extra", TypeQLTokenTypes.LABEL)
        // "date-time" should be a single LABEL, not DATE_TYPE + ...
        assertSingleToken("date-time", TypeQLTokenTypes.LABEL)
    }

    // ---- Datetime with timezone ----

    @Test
    fun testDatetimeWithNegativeTimezone() {
        assertSingleToken("2024-01-15T10:30:00-05:00", TypeQLTokenTypes.DATETIME_LITERAL)
    }

    // ---- Whitespace handling ----

    @Test
    fun testWhitespace() {
        val tokens = tokenize("  \t\n  ")
        assertEquals(1, tokens.size)
        assertEquals(TypeQLTokenTypes.WHITE_SPACE, tokens[0].first)
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
