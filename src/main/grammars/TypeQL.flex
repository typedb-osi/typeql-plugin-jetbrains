package org.typedb.typeql.plugin.jetbrains;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static org.typedb.typeql.plugin.jetbrains.TypeQLTokenTypes.*;

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

WHITE_SPACE     = [ \t\n\r]+
LINE_COMMENT    = #[^\n\r]*

// String literal: double-quoted, with escape sequences
STRING_LITERAL  = \"([^\"\\]|\\.)*\"

// Numeric literals
INTEGER         = [0-9]+
DOUBLE          = [0-9]+\.[0-9]+

// Date/time literals  (YYYY-MM-DD, with optional time, optional timezone)
DATETIME        = [0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}(:[0-9]{2}(\.[0-9]+)?)?(Z|[+\-][0-9]{2}:[0-9]{2})?
DATE            = [0-9]{4}-[0-9]{2}-[0-9]{2}

// ISO 8601 duration: P with at least one date component, or PT with at least one time component
DURATION_DATE   = P[0-9]+[YMWD][0-9YMWDTHS.]*
DURATION_TIME   = PT[0-9]+(\.[0-9]+)?[HMS][0-9HMS.]*

// Variable: $ followed by identifier chars
VARIABLE        = \$[a-zA-Z_][a-zA-Z0-9_\-]*

// Annotation: @ followed by identifier chars
ANNOTATION      = @[a-zA-Z_][a-zA-Z0-9_\-]*

// Identifiers (type labels): may contain hyphens but not start with one
LABEL           = [a-zA-Z_][a-zA-Z0-9_\-]*

%%

<YYINITIAL> {
    {WHITE_SPACE}       { return WHITE_SPACE; }
    {LINE_COMMENT}      { return TypeQLTokenTypes.LINE_COMMENT; }

    // String literal
    {STRING_LITERAL}    { return STRING_LITERAL; }

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

    // Variable
    {VARIABLE}          { return TypeQLTokenTypes.VARIABLE; }

    // Annotation
    {ANNOTATION}        { return TypeQLTokenTypes.ANNOTATION; }

    // Keywords: datetime-tz must come before datetime and before generic label
    "datetime-tz"       { return DATETIME_TZ_TYPE; }
    "datetime"          { return DATETIME_TYPE; }

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

    // Booleans
    "true"              { return TRUE; }
    "false"             { return FALSE; }

    // Duration literal (must come before date/datetime and integer)
    {DURATION_DATE}     { return DURATION_LITERAL; }
    {DURATION_TIME}     { return DURATION_LITERAL; }

    // Datetime literal (must come before date)
    {DATETIME}          { return DATETIME_LITERAL; }

    // Date literal
    {DATE}              { return DATE_LITERAL; }

    // Numeric literals
    {DOUBLE}            { return DOUBLE_LITERAL; }
    {INTEGER}           { return INTEGER_LITERAL; }

    // Identifier (type labels) — must be last
    {LABEL}             { return TypeQLTokenTypes.LABEL; }
}

// Fallback
[^]                     { return BAD_CHARACTER; }
