package org.typedb.typeql.plugin.jetbrains;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes.*;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;

%%

%class TypeQLLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%{
  public TypeQLLexer() {
    this((java.io.Reader)null);
  }
%}

WHITE_SPACE_CHAR = [ \t\n\r]+
LINE_COMMENT    = #[^\n\r]*

// String literals: double-quoted and single-quoted, with escape sequences
STRING_LITERAL  = \"([^\"\\]|\\.)*\"
SINGLE_STRING_LITERAL = '([^'\\]|\\.)*'

// Numeric literals
INTEGER         = [0-9]+
DOUBLE          = [0-9]+\.[0-9]+([eE][+\-]?[0-9]+)?
DECIMAL         = [0-9]+(\.[0-9]+)?dec

// Date/time literals  (YYYY-MM-DD, with optional time, optional timezone)
DATETIME_TZ     = [0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}(:[0-9]{2}(\.[0-9]+)?)?(Z|[+\-][0-9]{2}(:[0-9]{2}|[0-9]{2})?|\ [A-Z][A-Za-z0-9_+\-]+(\/[A-Z][A-Za-z0-9_+\-]+)*)
DATETIME        = [0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}(:[0-9]{2}(\.[0-9]+)?)?
DATE            = [0-9]{4}-[0-9]{2}-[0-9]{2}

// ISO 8601 duration: P with at least one date component, or PT with at least one time component
DURATION_DATE   = P[0-9]+[YMWD][0-9YMWDTHS.]*
DURATION_TIME   = PT[0-9]+(\.[0-9]+)?[HMS][0-9HMS.]*

// IID literal: hex value
IID             = 0x[0-9a-fA-F]+

// Variable: $ followed by identifier chars (may start with digit), or $_
VARIABLE_ANON   = \$_
VARIABLE        = \$[a-zA-Z0-9_][a-zA-Z0-9_\-]*

// Annotation: @ followed by identifier chars
ANNOTATION      = @[a-zA-Z_][a-zA-Z0-9_\-]*

// Identifiers (type labels): may contain hyphens but not start with one
LABEL           = [a-zA-Z_][a-zA-Z0-9_\-]*

%%

<YYINITIAL> {
    {WHITE_SPACE_CHAR}  { return WHITE_SPACE; }
    {LINE_COMMENT}      { return LINE_COMMENT; }

    // String literals
    {STRING_LITERAL}    { return STRING_LITERAL; }
    {SINGLE_STRING_LITERAL} { return SINGLE_STRING_LITERAL; }

    // Multi-character operators (must come before single-char)
    "=="                { return EQ_EQ; }
    "!="                { return NOT_EQ; }
    "<="                { return LT_EQ; }
    ">="                { return GT_EQ; }
    ".."                { return DOT_DOT; }
    "->"                { return ARROW; }

    // Single-character operators
    "+"                 { return PLUS; }
    "-"                 { return MINUS; }
    "*"                 { return STAR; }
    "/"                 { return SLASH; }
    "%"                 { return PERCENT; }
    "^"                 { return CARET; }
    "<"                 { return LT; }
    ">"                 { return GT; }
    "="                 { return EQ; }
    "?"                 { return QUESTION; }
    "!"                 { return EXCLAMATION; }

    // Punctuation
    "("                 { return LPAREN; }
    ")"                 { return RPAREN; }
    "{"                 { return LBRACE; }
    "}"                 { return RBRACE; }
    "["                 { return LBRACKET; }
    "]"                 { return RBRACKET; }
    ";"                 { return SEMICOLON; }
    ","                 { return COMMA; }
    ":"                 { return COLON; }
    "."                 { return DOT; }
    "@"                 { return AT; }
    "|"                 { return PIPE; }

    // Anonymous variable (must come before VARIABLE)
    {VARIABLE_ANON}     { return VARIABLE_ANON; }

    // Variable
    {VARIABLE}          { return VARIABLE; }

    // Annotation
    {ANNOTATION}        { return ANNOTATION; }

    // Keywords: datetime-tz must come before datetime and before generic label
    "datetime-tz"       { return DATETIME_TZ_TYPE; }
    "datetime"          { return DATETIME_TYPE; }

    // Exact match keywords (must come before sub/isa)
    "sub!"              { return SUB_EXACT; }
    "isa!"              { return ISA_EXACT; }

    // Keywords
    "define"            { return DEFINE; }
    "undefine"          { return UNDEFINE; }
    "redefine"          { return REDEFINE; }
    "match"             { return MATCH; }
    "insert"            { return INSERT; }
    "delete"            { return DELETE; }
    "update"            { return UPDATE; }
    "put"               { return PUT; }
    "fetch"             { return FETCH; }
    "select"            { return SELECT; }
    "sort"              { return SORT; }
    "distinct"          { return DISTINCT; }
    "offset"            { return OFFSET; }
    "limit"             { return LIMIT; }
    "require"           { return REQUIRE; }
    "reduce"            { return REDUCE; }
    "fun"               { return FUN; }
    "return"            { return RETURN; }
    "with"              { return WITH; }
    "isa"               { return ISA; }
    "has"               { return HAS; }
    "links"             { return LINKS; }
    "owns"              { return OWNS; }
    "plays"             { return PLAYS; }
    "relates"           { return RELATES; }
    "sub"               { return SUB; }
    "or"                { return OR; }
    "not"               { return NOT; }
    "try"               { return TRY; }
    "as"                { return AS; }
    "of"                { return OF; }
    "from"              { return FROM; }
    "in"                { return IN; }
    "is"                { return IS; }
    "let"               { return LET; }
    "end"               { return END; }
    "asc"               { return ASC; }
    "desc"              { return DESC; }
    "role"              { return ROLE; }
    "value"             { return VALUE; }
    "alias"             { return ALIAS; }
    "first"             { return FIRST; }
    "last"              { return LAST; }
    "check"             { return CHECK; }
    "groupby"           { return GROUPBY; }
    "iid"               { return IID_KW; }
    "like"              { return LIKE; }
    "contains"          { return CONTAINS; }

    // Schema types
    "entity"            { return ENTITY; }
    "relation"          { return RELATION; }
    "attribute"         { return ATTRIBUTE; }
    "struct"            { return STRUCT; }

    // Value types
    "boolean"           { return BOOLEAN_TYPE; }
    "integer"           { return INTEGER_TYPE; }
    "double"            { return DOUBLE_TYPE; }
    "decimal"           { return DECIMAL_TYPE; }
    "string"            { return STRING_TYPE; }
    "date"              { return DATE_TYPE; }
    "duration"          { return DURATION_TYPE; }

    // Aggregates / unreserved keywords
    "count"             { return COUNT; }
    "max"               { return MAX; }
    "min"               { return MIN; }
    "sum"               { return SUM; }
    "mean"              { return MEAN; }
    "median"            { return MEDIAN; }
    "std"               { return STD; }
    "list"              { return LIST; }
    "label"             { return LABEL_KW; }
    "abstract"          { return ABSTRACT; }

    // Built-in function keywords
    "abs"               { return ABS_KW; }
    "ceil"              { return CEIL_KW; }
    "floor"             { return FLOOR_KW; }
    "round"             { return ROUND_KW; }
    "len"               { return LEN_KW; }

    // Booleans
    "true"              { return TRUE; }
    "false"             { return FALSE; }

    // Duration literal (must come before date/datetime and integer)
    {DURATION_DATE}     { return DURATION_LITERAL; }
    {DURATION_TIME}     { return DURATION_LITERAL; }

    // Decimal literal (must come before double and integer — "123dec" or "1.5dec")
    {DECIMAL}           { return DECIMAL_LITERAL; }

    // Datetime-tz literal (must come before datetime)
    {DATETIME_TZ}       { return DATETIME_TZ_LITERAL; }

    // Datetime literal (must come before date)
    {DATETIME}          { return DATETIME_LITERAL; }

    // Date literal
    {DATE}              { return DATE_LITERAL; }

    // IID literal (must come before integer — "0x1a2b")
    {IID}               { return IID_LITERAL; }

    // Numeric literals
    {DOUBLE}            { return DOUBLE_LITERAL; }
    {INTEGER}           { return INTEGER_LITERAL; }

    // Identifier (type labels) — must be last
    {LABEL}             { return LABEL; }
}

// Fallback
[^]                     { return BAD_CHARACTER; }
