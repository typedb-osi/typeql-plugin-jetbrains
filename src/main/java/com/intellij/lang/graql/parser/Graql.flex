package com.intellij.lang.graql.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.lang.graql.psi.GraqlTokenTypes.*;

%%

%{
  public _GraqlLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GraqlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

DATATYPE=(long|double|string|boolean|date)
ORDER_SORT=(asc|desc)
BOOLEAN=(true|false)
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
REGEX="/"([^\\\/]+)"/"
INTEGER=([-+]?[0-9]+)
SPACE=[ \t\n\x0B\f\r]+
SINGLE_LINE_COMMENT=#.*
ID=[a-zA-Z_0-9-]*
VARIABLE=\$[a-zA-Z0-9_-]*

%%
<YYINITIAL> {
  {WHITE_SPACE}              { return WHITE_SPACE; }

  ":"                        { return COLON; }
  ";"                        { return SEMICOLON; }
  ","                        { return COMMA; }
  "("                        { return LPAREN; }
  ")"                        { return RPAREN; }
  "{"                        { return LBRACE; }
  "}"                        { return RBRACE; }
  "<"                        { return LTHAN; }
  "<="                       { return LTHANEQ; }
  ">"                        { return GTHAN; }
  ">="                       { return GTHANEQ; }
  "sub"                      { return SUB; }
  "key"                      { return KEY; }
  "has"                      { return HAS; }
  "plays"                    { return PLAYS; }
  "relates"                  { return RELATES; }
  "role"                     { return ROLE; }
  "relationship"             { return RELATIONSHIP; }
  "entity"                   { return ENTITY; }
  "attribute"                { return ATTRIBUTE; }
  "datatype"                 { return DATATYPE; }
  "long"                     { return LONG; }
  "double"                   { return DOUBLE; }
  "string"                   { return STRING; }
  "date"                     { return DATE; }
  "boolean"                  { return BOOLEAN; }
  "via"                      { return VIA; }
  "isa"                      { return ISA; }
  "commit"                   { return COMMIT; }
  "define"                   { return DEFINE; }
  "insert"                   { return INSERT; }
  "match"                    { return MATCH; }
  "rule"                     { return RULE; }
  "when"                     { return WHEN; }
  "then"                     { return THEN; }
  "get"                      { return GET; }
  "compute"                  { return COMPUTE; }
  "cluster"                  { return CLUSTER; }
  "in"                       { return IN; }
  "member"                   { return MEMBER; }
  "label"                    { return LABEL; }
  "is-abstract"              { return IS-ABSTRACT; }
  "as"                       { return AS; }
  "delete"                   { return DELETE; }
  "aggregate"                { return AGGREGATE; }
  "ask"                      { return ASK; }
  "count"                    { return COUNT; }
  "sum"                      { return SUM; }
  "max"                      { return MAX; }
  "min"                      { return MIN; }
  "mean"                     { return MEAN; }
  "median"                   { return MEDIAN; }
  "group"                    { return GROUP; }
  "of"                       { return OF; }
  "std"                      { return STD; }
  "val"                      { return VAL; }
  "contains"                 { return CONTAINS; }
  "or"                       { return OR; }
  "offset"                   { return OFFSET; }
  "limit"                    { return LIMIT; }
  "order"                    { return ORDER; }
  "by"                       { return BY; }
  "UNDEFINE"                 { return UNDEFINE; }
  "MEMBERS"                  { return MEMBERS; }
  "SIZE"                     { return SIZE; }
  "REAL"                     { return REAL; }
  "DATETIME"                 { return DATETIME; }
  "IMPLICIT_IDENTIFIER"      { return IMPLICIT_IDENTIFIER; }
  "PATH"                     { return PATH; }
  "DEGREES"                  { return DEGREES; }

  {DATATYPE}                 { return DATATYPE; }
  {ORDER_SORT}               { return ORDER_SORT; }
  {BOOLEAN}                  { return BOOLEAN; }
  {STRING}                   { return STRING; }
  {REGEX}                    { return REGEX; }
  {INTEGER}                  { return INTEGER; }
  {SPACE}                    { return SPACE; }
  {SINGLE_LINE_COMMENT}      { return SINGLE_LINE_COMMENT; }
  {ID}                       { return ID; }
  {VARIABLE}                 { return VARIABLE; }

}

[^] { return BAD_CHARACTER; }
