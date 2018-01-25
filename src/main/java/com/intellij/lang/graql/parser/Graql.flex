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

SPACE=[ \t\n\x0B\f\r]+
SINGLE_LINE_COMMENT=#.*
NUMBER_LITERAL=[0-9]+(\.[0-9]*)?
STRING_LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=[a-zA-Z_0-9-]*
VARIABLE=\$[a-zA-Z0-9_]*

%%
<YYINITIAL> {
  {WHITE_SPACE}              { return WHITE_SPACE; }

  "id"                       { return ID; }
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
  "is-abstract"              { return IS_ABSTRACT; }
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
  "!="                       { return NOT_EQUAL; }
  ":"                        { return COLON; }
  ";"                        { return SEMICOLON; }
  ","                        { return COMMA; }
  "("                        { return LPAREN; }
  ")"                        { return RPAREN; }
  "{"                        { return LBRACE; }
  "}"                        { return RBRACE; }

  {SPACE}                    { return SPACE; }
  {SINGLE_LINE_COMMENT}      { return SINGLE_LINE_COMMENT; }
  {NUMBER_LITERAL}           { return NUMBER_LITERAL; }
  {STRING_LITERAL}           { return STRING_LITERAL; }
  {IDENTIFIER}               { return IDENTIFIER; }
  {VARIABLE}                 { return VARIABLE; }

}

[^] { return BAD_CHARACTER; }
