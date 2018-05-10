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

STRING_LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
REGEX="/"([^\\\/]+)"/"
INTEGER=([-+]?[0-9]+)
REAL=([-+]?[0-9]+.[0-9]+)
SPACE=[ \t\n\x0B\f\r]+
SINGLE_LINE_COMMENT=#.*
ID=[a-zA-Z_0-9-]*
VARIABLE=\$[a-zA-Z0-9_-]*

%%
<YYINITIAL> {
  {WHITE_SPACE}              { return WHITE_SPACE; }

  "@"                        { return AT; }
  "["                        { return LBR; }
  "]"                        { return RBR; }
  "."                        { return PERIOD; }
  ":"                        { return COLON; }
  ";"                        { return SEMICOLON; }
  ","                        { return COMMA; }
  "("                        { return LPAREN; }
  ")"                        { return RPAREN; }
  "{"                        { return LBRACE; }
  "}"                        { return RBRACE; }
  "<"                        { return LESS; }
  "<="                       { return LESSEQ; }
  ">"                        { return GREATER; }
  ">="                       { return GREATEREQ; }
  "="                        { return EQ; }
  "!="                       { return NEQ; }
  "sub"                      { return SUB_KEYWORD; }
  "key"                      { return KEY_KEYWORD; }
  "has"                      { return HAS_KEYWORD; }
  "plays"                    { return PLAYS_KEYWORD; }
  "relates"                  { return RELATES_KEYWORD; }
  "role"                     { return ROLE_KEYWORD; }
  "relationship"             { return RELATIONSHIP_KEYWORD; }
  "entity"                   { return ENTITY_KEYWORD; }
  "attribute"                { return ATTRIBUTE_KEYWORD; }
  "datatype"                 { return DATATYPE_KEYWORD; }
  "long"                     { return LONG_KEYWORD; }
  "double"                   { return DOUBLE_KEYWORD; }
  "string"                   { return STRING_KEYWORD; }
  "date"                     { return DATE_KEYWORD; }
  "boolean"                  { return BOOLEAN_KEYWORD; }
  "via"                      { return VIA_KEYWORD; }
  "isa"                      { return ISA_KEYWORD; }
  "commit"                   { return COMMIT_KEYWORD; }
  "define"                   { return DEFINE_KEYWORD; }
  "undefine"                 { return UNDEFINE_KEYWORD; }
  "insert"                   { return INSERT_KEYWORD; }
  "match"                    { return MATCH_KEYWORD; }
  "rule"                     { return RULE_KEYWORD; }
  "when"                     { return WHEN_KEYWORD; }
  "then"                     { return THEN_KEYWORD; }
  "get"                      { return GET_KEYWORD; }
  "compute"                  { return COMPUTE_KEYWORD; }
  "cluster"                  { return CLUSTER_KEYWORD; }
  "in"                       { return IN_KEYWORD; }
  "member"                   { return MEMBER_KEYWORD; }
  "label"                    { return LABEL_KEYWORD; }
  "is-abstract"              { return IS_ABSTRACT_KEYWORD; }
  "as"                       { return AS_KEYWORD; }
  "delete"                   { return DELETE_KEYWORD; }
  "aggregate"                { return AGGREGATE_KEYWORD; }
  "ask"                      { return ASK_KEYWORD; }
  "count"                    { return COUNT_KEYWORD; }
  "sum"                      { return SUM_KEYWORD; }
  "max"                      { return MAX_KEYWORD; }
  "min"                      { return MIN_KEYWORD; }
  "mean"                     { return MEAN_KEYWORD; }
  "median"                   { return MEDIAN_KEYWORD; }
  "group"                    { return GROUP_KEYWORD; }
  "of"                       { return OF_KEYWORD; }
  "std"                      { return STD_KEYWORD; }
  "contains"                 { return CONTAINS_KEYWORD; }
  "and"                      { return AND_KEYWORD; }
  "or"                       { return OR_KEYWORD; }
  "offset"                   { return OFFSET_KEYWORD; }
  "limit"                    { return LIMIT_KEYWORD; }
  "order"                    { return ORDER_KEYWORD; }
  "by"                       { return BY_KEYWORD; }
  "asc"                      { return ASC_KEYWORD; }
  "desc"                     { return DESC_KEYWORD; }
  "true"                     { return TRUE_KEYWORD; }
  "false"                    { return FALSE_KEYWORD; }
  "for"                      { return FOR_KEYWORD; }
  "do"                       { return DO_KEYWORD; }
  "if"                       { return IF_KEYWORD; }
  "not"                      { return NOT_KEYWORD; }
  "else"                     { return ELSE_KEYWORD; }
  "elseif"                   { return ELSEIF_KEYWORD; }
  "null"                     { return NULL_KEYWORD; }
  "id"                       { return ID_KEYWORD; }
  "degrees"                  { return DEGREES_KEYWORD; }
  "path"                     { return PATH_KEYWORD; }
  "paths"                    { return PATHS_KEYWORD; }
  "from"                     { return FROM_KEYWORD; }
  "to"                       { return TO_KEYWORD; }
  "regex"                    { return REGEX_KEYWORD; }
  "size"                     { return SIZE_KEYWORD; }
  "int"                      { return INT_KEYWORD; }
  "noescp"                   { return NOESCP_KEYWORD; }
  "equals"                   { return EQUALS_KEYWORD; }
  "MEMBERS"                  { return MEMBERS; }
  "SIZE"                     { return SIZE; }
  "DATE"                     { return DATE; }
  "DATETIME"                 { return DATETIME; }
  "IMPLICIT_IDENTIFIER"      { return IMPLICIT_IDENTIFIER; }
  "DOUBLE"                   { return DOUBLE; }

  {STRING_LITERAL}           { return STRING_LITERAL; }
  {REGEX}                    { return REGEX; }
  {INTEGER}                  { return INTEGER; }
  {REAL}                     { return REAL; }
  {SPACE}                    { return SPACE; }
  {SINGLE_LINE_COMMENT}      { return SINGLE_LINE_COMMENT; }
  {ID}                       { return ID; }
  {VARIABLE}                 { return VARIABLE; }

}

[^] { return BAD_CHARACTER; }
