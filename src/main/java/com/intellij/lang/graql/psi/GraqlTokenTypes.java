// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.psi.impl.*;

public interface GraqlTokenTypes {

  IElementType AGGREGATE = new GraqlElementType("AGGREGATE");
  IElementType AGGREGATE_QUERY = new GraqlElementType("AGGREGATE_QUERY");
  IElementType AND_PATTERN = new GraqlElementType("AND_PATTERN");
  IElementType ARGUMENT = new GraqlElementType("ARGUMENT");
  IElementType CASTING = new GraqlElementType("CASTING");
  IElementType CLUSTER_PARAM = new GraqlElementType("CLUSTER_PARAM");
  IElementType DEFINE_QUERY = new GraqlElementType("DEFINE_QUERY");
  IElementType DELETE_QUERY = new GraqlElementType("DELETE_QUERY");
  IElementType GET_QUERY = new GraqlElementType("GET_QUERY");
  IElementType ID = new GraqlElementType("ID");
  IElementType IDENTIFIER = new GraqlElementType("IDENTIFIER");
  IElementType INSERT_QUERY = new GraqlElementType("INSERT_QUERY");
  IElementType IN_LIST = new GraqlElementType("IN_LIST");
  IElementType LABEL = new GraqlElementType("LABEL");
  IElementType LABEL_LIST = new GraqlElementType("LABEL_LIST");
  IElementType MATCH_LIMIT = new GraqlElementType("MATCH_LIMIT");
  IElementType MATCH_LIMIT_OFFSET = new GraqlElementType("MATCH_LIMIT_OFFSET");
  IElementType MATCH_OFFSET = new GraqlElementType("MATCH_OFFSET");
  IElementType MATCH_OFFSET_LIMIT = new GraqlElementType("MATCH_OFFSET_LIMIT");
  IElementType MATCH_ORDER_BY = new GraqlElementType("MATCH_ORDER_BY");
  IElementType MATCH_PART = new GraqlElementType("MATCH_PART");
  IElementType NAMED_AGG = new GraqlElementType("NAMED_AGG");
  IElementType OF_LIST = new GraqlElementType("OF_LIST");
  IElementType OR_PATTERN = new GraqlElementType("OR_PATTERN");
  IElementType PATTERN = new GraqlElementType("PATTERN");
  IElementType PATTERNS = new GraqlElementType("PATTERNS");
  IElementType PREDICATE = new GraqlElementType("PREDICATE");
  IElementType PROPERTY = new GraqlElementType("PROPERTY");
  IElementType QUERY = new GraqlElementType("QUERY");
  IElementType UNDEFINE_QUERY = new GraqlElementType("UNDEFINE_QUERY");
  IElementType VALUE = new GraqlElementType("VALUE");
  IElementType VALUE_OR_VAR = new GraqlElementType("VALUE_OR_VAR");
  IElementType VARIABLE = new GraqlElementType("VARIABLE");
  IElementType VARIABLES = new GraqlElementType("VARIABLES");
  IElementType VAR_PATTERN = new GraqlElementType("VAR_PATTERN");
  IElementType VAR_PATTERNS = new GraqlElementType("VAR_PATTERNS");

  IElementType AS = new GraqlTokenType("as");
  IElementType ASC = new GraqlTokenType("asc");
  IElementType ASK = new GraqlTokenType("ask");
  IElementType ATTRIBUTE = new GraqlTokenType("attribute");
  IElementType BOOLEAN = new GraqlTokenType("boolean");
  IElementType BY = new GraqlTokenType("by");
  IElementType CLUSTER = new GraqlTokenType("CLUSTER");
  IElementType COLON = new GraqlTokenType(":");
  IElementType COMMA = new GraqlTokenType(",");
  IElementType COMMIT = new GraqlTokenType("commit");
  IElementType COMPUTE = new GraqlTokenType("compute");
  IElementType CONTAINS = new GraqlTokenType("contains");
  IElementType COUNT = new GraqlTokenType("COUNT");
  IElementType DATATYPE = new GraqlTokenType("datatype");
  IElementType DATE = new GraqlTokenType("DATE");
  IElementType DATETIME = new GraqlTokenType("DATETIME");
  IElementType DEFINE = new GraqlTokenType("DEFINE");
  IElementType DEGREES = new GraqlTokenType("DEGREES");
  IElementType DELETE = new GraqlTokenType("delete");
  IElementType DESC = new GraqlTokenType("desc");
  IElementType DOUBLE = new GraqlTokenType("double");
  IElementType ENTITY = new GraqlTokenType("ENTITY");
  IElementType FALSE = new GraqlTokenType("false");
  IElementType GET = new GraqlTokenType("get");
  IElementType GROUP = new GraqlTokenType("group");
  IElementType GTHAN = new GraqlTokenType(">");
  IElementType GTHANEQ = new GraqlTokenType(">=");
  IElementType HAS = new GraqlTokenType("has");
  IElementType IMPLICIT_IDENTIFIER = new GraqlTokenType("IMPLICIT_IDENTIFIER");
  IElementType IN = new GraqlTokenType("in");
  IElementType INSERT = new GraqlTokenType("INSERT");
  IElementType INTEGER = new GraqlTokenType("INTEGER");
  IElementType ISA = new GraqlTokenType("isa");
  IElementType IS_ABSTRACT = new GraqlTokenType("is-abstract");
  IElementType KEY = new GraqlTokenType("key");
  IElementType LBRACE = new GraqlTokenType("{");
  IElementType LIMIT = new GraqlTokenType("limit");
  IElementType LONG = new GraqlTokenType("long");
  IElementType LPAREN = new GraqlTokenType("(");
  IElementType LTHAN = new GraqlTokenType("<");
  IElementType LTHANEQ = new GraqlTokenType("<=");
  IElementType MATCH = new GraqlTokenType("MATCH");
  IElementType MAX = new GraqlTokenType("MAX");
  IElementType MEAN = new GraqlTokenType("MEAN");
  IElementType MEDIAN = new GraqlTokenType("MEDIAN");
  IElementType MEMBER = new GraqlTokenType("member");
  IElementType MEMBERS = new GraqlTokenType("MEMBERS");
  IElementType MIN = new GraqlTokenType("MIN");
  IElementType OF = new GraqlTokenType("of");
  IElementType OFFSET = new GraqlTokenType("offset");
  IElementType OR = new GraqlTokenType("or");
  IElementType ORDER = new GraqlTokenType("order");
  IElementType PATH = new GraqlTokenType("PATH");
  IElementType PLAYS = new GraqlTokenType("plays");
  IElementType RBRACE = new GraqlTokenType("}");
  IElementType REAL = new GraqlTokenType("REAL");
  IElementType REGEX = new GraqlTokenType("REGEX");
  IElementType RELATES = new GraqlTokenType("relates");
  IElementType RELATIONSHIP = new GraqlTokenType("RELATIONSHIP");
  IElementType ROLE = new GraqlTokenType("role");
  IElementType RPAREN = new GraqlTokenType(")");
  IElementType RULE = new GraqlTokenType("RULE");
  IElementType SEMICOLON = new GraqlTokenType(";");
  IElementType SINGLE_LINE_COMMENT = new GraqlTokenType("single_line_comment");
  IElementType SIZE = new GraqlTokenType("SIZE");
  IElementType STD = new GraqlTokenType("STD");
  IElementType STRING = new GraqlTokenType("STRING");
  IElementType SUB = new GraqlTokenType("sub");
  IElementType SUM = new GraqlTokenType("SUM");
  IElementType THEN = new GraqlTokenType("then");
  IElementType TRUE = new GraqlTokenType("true");
  IElementType UNDEFINE = new GraqlTokenType("UNDEFINE");
  IElementType VAL = new GraqlTokenType("val");
  IElementType VIA = new GraqlTokenType("via");
  IElementType WHEN = new GraqlTokenType("when");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == AGGREGATE) {
        return new GraqlAggregateImpl(node);
      }
      else if (type == AGGREGATE_QUERY) {
        return new GraqlAggregateQueryImpl(node);
      }
      else if (type == AND_PATTERN) {
        return new GraqlAndPatternImpl(node);
      }
      else if (type == ARGUMENT) {
        return new GraqlArgumentImpl(node);
      }
      else if (type == CASTING) {
        return new GraqlCastingImpl(node);
      }
      else if (type == CLUSTER_PARAM) {
        return new GraqlClusterParamImpl(node);
      }
      else if (type == DEFINE_QUERY) {
        return new GraqlDefineQueryImpl(node);
      }
      else if (type == DELETE_QUERY) {
        return new GraqlDeleteQueryImpl(node);
      }
      else if (type == GET_QUERY) {
        return new GraqlGetQueryImpl(node);
      }
      else if (type == ID) {
        return new GraqlIdImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new GraqlIdentifierImpl(node);
      }
      else if (type == INSERT_QUERY) {
        return new GraqlInsertQueryImpl(node);
      }
      else if (type == IN_LIST) {
        return new GraqlInListImpl(node);
      }
      else if (type == LABEL) {
        return new GraqlLabelImpl(node);
      }
      else if (type == LABEL_LIST) {
        return new GraqlLabelListImpl(node);
      }
      else if (type == MATCH_LIMIT) {
        return new GraqlMatchLimitImpl(node);
      }
      else if (type == MATCH_LIMIT_OFFSET) {
        return new GraqlMatchLimitOffsetImpl(node);
      }
      else if (type == MATCH_OFFSET) {
        return new GraqlMatchOffsetImpl(node);
      }
      else if (type == MATCH_OFFSET_LIMIT) {
        return new GraqlMatchOffsetLimitImpl(node);
      }
      else if (type == MATCH_ORDER_BY) {
        return new GraqlMatchOrderByImpl(node);
      }
      else if (type == MATCH_PART) {
        return new GraqlMatchPartImpl(node);
      }
      else if (type == NAMED_AGG) {
        return new GraqlNamedAggImpl(node);
      }
      else if (type == OF_LIST) {
        return new GraqlOfListImpl(node);
      }
      else if (type == OR_PATTERN) {
        return new GraqlOrPatternImpl(node);
      }
      else if (type == PATTERNS) {
        return new GraqlPatternsImpl(node);
      }
      else if (type == PREDICATE) {
        return new GraqlPredicateImpl(node);
      }
      else if (type == PROPERTY) {
        return new GraqlPropertyImpl(node);
      }
      else if (type == QUERY) {
        return new GraqlQueryImpl(node);
      }
      else if (type == UNDEFINE_QUERY) {
        return new GraqlUndefineQueryImpl(node);
      }
      else if (type == VALUE) {
        return new GraqlValueImpl(node);
      }
      else if (type == VALUE_OR_VAR) {
        return new GraqlValueOrVarImpl(node);
      }
      else if (type == VARIABLE) {
        return new GraqlVariableImpl(node);
      }
      else if (type == VARIABLES) {
        return new GraqlVariablesImpl(node);
      }
      else if (type == VAR_PATTERN) {
        return new GraqlVarPatternImpl(node);
      }
      else if (type == VAR_PATTERNS) {
        return new GraqlVarPatternsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
