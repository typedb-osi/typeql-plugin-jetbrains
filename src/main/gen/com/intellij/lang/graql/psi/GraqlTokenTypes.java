// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.psi.impl.*;

public interface GraqlTokenTypes {

  IElementType ACCESSOR = new GraqlElementType("ACCESSOR");
  IElementType AGGREGATE = new GraqlElementType("AGGREGATE");
  IElementType AGGREGATE_QUERY = new GraqlElementType("AGGREGATE_QUERY");
  IElementType AND_BOOL = new GraqlElementType("AND_BOOL");
  IElementType AND_PATTERN = new GraqlElementType("AND_PATTERN");
  IElementType ARGUMENT = new GraqlElementType("ARGUMENT");
  IElementType BLOCK = new GraqlElementType("BLOCK");
  IElementType BLOCK_CONTENTS = new GraqlElementType("BLOCK_CONTENTS");
  IElementType BOOL = new GraqlElementType("BOOL");
  IElementType CASTING = new GraqlElementType("CASTING");
  IElementType CLUSTER = new GraqlElementType("CLUSTER");
  IElementType CLUSTER_PARAM = new GraqlElementType("CLUSTER_PARAM");
  IElementType COMPUTE_METHOD = new GraqlElementType("COMPUTE_METHOD");
  IElementType COMPUTE_QUERY = new GraqlElementType("COMPUTE_QUERY");
  IElementType COUNT = new GraqlElementType("COUNT");
  IElementType DEFINE_QUERY = new GraqlElementType("DEFINE_QUERY");
  IElementType DEGREES = new GraqlElementType("DEGREES");
  IElementType DELETE_QUERY = new GraqlElementType("DELETE_QUERY");
  IElementType DOUBLE_ = new GraqlElementType("DOUBLE_");
  IElementType ELSE_IF_PARTIAL = new GraqlElementType("ELSE_IF_PARTIAL");
  IElementType ELSE_PARTIAL = new GraqlElementType("ELSE_PARTIAL");
  IElementType ESCAPED_EXPRESSION = new GraqlElementType("ESCAPED_EXPRESSION");
  IElementType EXPRESSION = new GraqlElementType("EXPRESSION");
  IElementType FOR_EACH_STATEMENT = new GraqlElementType("FOR_EACH_STATEMENT");
  IElementType FOR_IN_STATEMENT = new GraqlElementType("FOR_IN_STATEMENT");
  IElementType GET_QUERY = new GraqlElementType("GET_QUERY");
  IElementType GROUP_BOOL = new GraqlElementType("GROUP_BOOL");
  IElementType IDENTIFIER = new GraqlElementType("IDENTIFIER");
  IElementType ID_MACRO = new GraqlElementType("ID_MACRO");
  IElementType IF_PARTIAL = new GraqlElementType("IF_PARTIAL");
  IElementType IF_STATEMENT = new GraqlElementType("IF_STATEMENT");
  IElementType INSERT_QUERY = new GraqlElementType("INSERT_QUERY");
  IElementType INT_ = new GraqlElementType("INT_");
  IElementType IN_LIST = new GraqlElementType("IN_LIST");
  IElementType LABEL = new GraqlElementType("LABEL");
  IElementType LABEL_LIST = new GraqlElementType("LABEL_LIST");
  IElementType LABEL_OR_VAR = new GraqlElementType("LABEL_OR_VAR");
  IElementType LIST = new GraqlElementType("LIST");
  IElementType MACRO_EQUALS = new GraqlElementType("MACRO_EQUALS");
  IElementType MACRO_NOESCP = new GraqlElementType("MACRO_NOESCP");
  IElementType MATCH_LIMIT = new GraqlElementType("MATCH_LIMIT");
  IElementType MATCH_LIMIT_OFFSET = new GraqlElementType("MATCH_LIMIT_OFFSET");
  IElementType MATCH_OFFSET = new GraqlElementType("MATCH_OFFSET");
  IElementType MATCH_OFFSET_LIMIT = new GraqlElementType("MATCH_OFFSET_LIMIT");
  IElementType MATCH_ORDER_BY = new GraqlElementType("MATCH_ORDER_BY");
  IElementType MATCH_PART = new GraqlElementType("MATCH_PART");
  IElementType MAX = new GraqlElementType("MAX");
  IElementType MEAN = new GraqlElementType("MEAN");
  IElementType MEDIAN = new GraqlElementType("MEDIAN");
  IElementType MIN = new GraqlElementType("MIN");
  IElementType NAMED_AGG = new GraqlElementType("NAMED_AGG");
  IElementType NIL = new GraqlElementType("NIL");
  IElementType NOT_BOOL = new GraqlElementType("NOT_BOOL");
  IElementType NUMBER = new GraqlElementType("NUMBER");
  IElementType OF_LIST = new GraqlElementType("OF_LIST");
  IElementType OR_BOOL = new GraqlElementType("OR_BOOL");
  IElementType OR_PATTERN = new GraqlElementType("OR_PATTERN");
  IElementType PATH = new GraqlElementType("PATH");
  IElementType PATHS = new GraqlElementType("PATHS");
  IElementType PATTERN = new GraqlElementType("PATTERN");
  IElementType PATTERNS = new GraqlElementType("PATTERNS");
  IElementType PREDICATE = new GraqlElementType("PREDICATE");
  IElementType PROPERTY = new GraqlElementType("PROPERTY");
  IElementType QUERY = new GraqlElementType("QUERY");
  IElementType STATEMENT = new GraqlElementType("STATEMENT");
  IElementType STD = new GraqlElementType("STD");
  IElementType SUM = new GraqlElementType("SUM");
  IElementType UNDEFINE_QUERY = new GraqlElementType("UNDEFINE_QUERY");
  IElementType UNTYPED_EXPRESSION = new GraqlElementType("UNTYPED_EXPRESSION");
  IElementType VALUE = new GraqlElementType("VALUE");
  IElementType VALUE_OR_VAR = new GraqlElementType("VALUE_OR_VAR");
  IElementType VARIABLES = new GraqlElementType("VARIABLES");
  IElementType VAR_PATTERN = new GraqlElementType("VAR_PATTERN");
  IElementType VAR_PATTERNS = new GraqlElementType("VAR_PATTERNS");

  IElementType AGGREGATE_KEYWORD = new GraqlTokenType("aggregate");
  IElementType AND_KEYWORD = new GraqlTokenType("and");
  IElementType ASC_KEYWORD = new GraqlTokenType("asc");
  IElementType ASK_KEYWORD = new GraqlTokenType("ask");
  IElementType AS_KEYWORD = new GraqlTokenType("as");
  IElementType AT = new GraqlTokenType("@");
  IElementType ATTRIBUTE_KEYWORD = new GraqlTokenType("attribute");
  IElementType BOOLEAN_KEYWORD = new GraqlTokenType("boolean");
  IElementType BY_KEYWORD = new GraqlTokenType("by");
  IElementType CLUSTER_KEYWORD = new GraqlTokenType("cluster");
  IElementType COLON = new GraqlTokenType(":");
  IElementType COMMA = new GraqlTokenType(",");
  IElementType COMMIT_KEYWORD = new GraqlTokenType("commit");
  IElementType COMPUTE_KEYWORD = new GraqlTokenType("compute");
  IElementType CONTAINS_KEYWORD = new GraqlTokenType("contains");
  IElementType COUNT_KEYWORD = new GraqlTokenType("count");
  IElementType DATATYPE_KEYWORD = new GraqlTokenType("datatype");
  IElementType DATE = new GraqlTokenType("DATE");
  IElementType DATETIME = new GraqlTokenType("DATETIME");
  IElementType DATE_KEYWORD = new GraqlTokenType("date");
  IElementType DEFINE_KEYWORD = new GraqlTokenType("define");
  IElementType DEGREES_KEYWORD = new GraqlTokenType("degrees");
  IElementType DELETE_KEYWORD = new GraqlTokenType("delete");
  IElementType DESC_KEYWORD = new GraqlTokenType("desc");
  IElementType DOUBLE = new GraqlTokenType("DOUBLE");
  IElementType DOUBLE_KEYWORD = new GraqlTokenType("double");
  IElementType DO_KEYWORD = new GraqlTokenType("do");
  IElementType ELSEIF_KEYWORD = new GraqlTokenType("elseif");
  IElementType ELSE_KEYWORD = new GraqlTokenType("else");
  IElementType ENTITY_KEYWORD = new GraqlTokenType("entity");
  IElementType EQ = new GraqlTokenType("=");
  IElementType EQUALS_KEYWORD = new GraqlTokenType("equals");
  IElementType FALSE_KEYWORD = new GraqlTokenType("false");
  IElementType FOR_KEYWORD = new GraqlTokenType("for");
  IElementType FROM_KEYWORD = new GraqlTokenType("from");
  IElementType GET_KEYWORD = new GraqlTokenType("get");
  IElementType GREATER = new GraqlTokenType(">");
  IElementType GREATEREQ = new GraqlTokenType(">=");
  IElementType GROUP_KEYWORD = new GraqlTokenType("group");
  IElementType HAS_KEYWORD = new GraqlTokenType("has");
  IElementType ID = new GraqlTokenType("ID");
  IElementType ID_KEYWORD = new GraqlTokenType("id");
  IElementType IF_KEYWORD = new GraqlTokenType("if");
  IElementType IMPLICIT_IDENTIFIER = new GraqlTokenType("IMPLICIT_IDENTIFIER");
  IElementType INSERT_KEYWORD = new GraqlTokenType("insert");
  IElementType INTEGER = new GraqlTokenType("INTEGER");
  IElementType INT_KEYWORD = new GraqlTokenType("int");
  IElementType IN_KEYWORD = new GraqlTokenType("in");
  IElementType ISA_KEYWORD = new GraqlTokenType("isa");
  IElementType IS_ABSTRACT_KEYWORD = new GraqlTokenType("is-abstract");
  IElementType KEY_KEYWORD = new GraqlTokenType("key");
  IElementType LABEL_KEYWORD = new GraqlTokenType("label");
  IElementType LBR = new GraqlTokenType("[");
  IElementType LBRACE = new GraqlTokenType("{");
  IElementType LESS = new GraqlTokenType("<");
  IElementType LESSEQ = new GraqlTokenType("<=");
  IElementType LIMIT_KEYWORD = new GraqlTokenType("limit");
  IElementType LONG_KEYWORD = new GraqlTokenType("long");
  IElementType LPAREN = new GraqlTokenType("(");
  IElementType MATCH_KEYWORD = new GraqlTokenType("match");
  IElementType MAX_KEYWORD = new GraqlTokenType("max");
  IElementType MEAN_KEYWORD = new GraqlTokenType("mean");
  IElementType MEDIAN_KEYWORD = new GraqlTokenType("median");
  IElementType MEMBERS = new GraqlTokenType("MEMBERS");
  IElementType MEMBER_KEYWORD = new GraqlTokenType("member");
  IElementType MIN_KEYWORD = new GraqlTokenType("min");
  IElementType NEQ = new GraqlTokenType("!=");
  IElementType NOESCP_KEYWORD = new GraqlTokenType("noescp");
  IElementType NOT_KEYWORD = new GraqlTokenType("not");
  IElementType NULL_KEYWORD = new GraqlTokenType("null");
  IElementType OFFSET_KEYWORD = new GraqlTokenType("offset");
  IElementType OF_KEYWORD = new GraqlTokenType("of");
  IElementType ORDER_KEYWORD = new GraqlTokenType("order");
  IElementType OR_KEYWORD = new GraqlTokenType("or");
  IElementType PATHS_KEYWORD = new GraqlTokenType("paths");
  IElementType PATH_KEYWORD = new GraqlTokenType("path");
  IElementType PERIOD = new GraqlTokenType(".");
  IElementType PLAYS_KEYWORD = new GraqlTokenType("plays");
  IElementType RBR = new GraqlTokenType("]");
  IElementType RBRACE = new GraqlTokenType("}");
  IElementType REAL = new GraqlTokenType("REAL");
  IElementType REGEX = new GraqlTokenType("REGEX");
  IElementType REGEX_KEYWORD = new GraqlTokenType("regex");
  IElementType RELATES_KEYWORD = new GraqlTokenType("relates");
  IElementType RELATIONSHIP_KEYWORD = new GraqlTokenType("relationship");
  IElementType ROLE_KEYWORD = new GraqlTokenType("role");
  IElementType RPAREN = new GraqlTokenType(")");
  IElementType RULE_KEYWORD = new GraqlTokenType("rule");
  IElementType SEMICOLON = new GraqlTokenType(";");
  IElementType SINGLE_LINE_COMMENT = new GraqlTokenType("single_line_comment");
  IElementType SIZE = new GraqlTokenType("SIZE");
  IElementType SIZE_KEYWORD = new GraqlTokenType("size");
  IElementType STD_KEYWORD = new GraqlTokenType("std");
  IElementType STRING_KEYWORD = new GraqlTokenType("string");
  IElementType STRING_LITERAL = new GraqlTokenType("STRING_LITERAL");
  IElementType SUB_KEYWORD = new GraqlTokenType("sub");
  IElementType SUM_KEYWORD = new GraqlTokenType("sum");
  IElementType THEN_KEYWORD = new GraqlTokenType("then");
  IElementType TO_KEYWORD = new GraqlTokenType("to");
  IElementType TRUE_KEYWORD = new GraqlTokenType("true");
  IElementType UNDEFINE_KEYWORD = new GraqlTokenType("undefine");
  IElementType VAL_KEYWORD = new GraqlTokenType("val");
  IElementType VARIABLE = new GraqlTokenType("VARIABLE");
  IElementType VIA_KEYWORD = new GraqlTokenType("via");
  IElementType WHEN_KEYWORD = new GraqlTokenType("when");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ACCESSOR) {
        return new GraqlAccessorImpl(node);
      }
      else if (type == AGGREGATE) {
        return new GraqlAggregateImpl(node);
      }
      else if (type == AGGREGATE_QUERY) {
        return new GraqlAggregateQueryImpl(node);
      }
      else if (type == AND_BOOL) {
        return new GraqlAndBoolImpl(node);
      }
      else if (type == AND_PATTERN) {
        return new GraqlAndPatternImpl(node);
      }
      else if (type == ARGUMENT) {
        return new GraqlArgumentImpl(node);
      }
      else if (type == BLOCK) {
        return new GraqlBlockImpl(node);
      }
      else if (type == BLOCK_CONTENTS) {
        return new GraqlBlockContentsImpl(node);
      }
      else if (type == BOOL) {
        return new GraqlBoolImpl(node);
      }
      else if (type == CASTING) {
        return new GraqlCastingImpl(node);
      }
      else if (type == CLUSTER) {
        return new GraqlClusterImpl(node);
      }
      else if (type == CLUSTER_PARAM) {
        return new GraqlClusterParamImpl(node);
      }
      else if (type == COMPUTE_METHOD) {
        return new GraqlComputeMethodImpl(node);
      }
      else if (type == COMPUTE_QUERY) {
        return new GraqlComputeQueryImpl(node);
      }
      else if (type == COUNT) {
        return new GraqlCountImpl(node);
      }
      else if (type == DEFINE_QUERY) {
        return new GraqlDefineQueryImpl(node);
      }
      else if (type == DEGREES) {
        return new GraqlDegreesImpl(node);
      }
      else if (type == DELETE_QUERY) {
        return new GraqlDeleteQueryImpl(node);
      }
      else if (type == DOUBLE_) {
        return new GraqlDouble_Impl(node);
      }
      else if (type == ELSE_IF_PARTIAL) {
        return new GraqlElseIfPartialImpl(node);
      }
      else if (type == ELSE_PARTIAL) {
        return new GraqlElsePartialImpl(node);
      }
      else if (type == ESCAPED_EXPRESSION) {
        return new GraqlEscapedExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new GraqlExpressionImpl(node);
      }
      else if (type == FOR_EACH_STATEMENT) {
        return new GraqlForEachStatementImpl(node);
      }
      else if (type == FOR_IN_STATEMENT) {
        return new GraqlForInStatementImpl(node);
      }
      else if (type == GET_QUERY) {
        return new GraqlGetQueryImpl(node);
      }
      else if (type == GROUP_BOOL) {
        return new GraqlGroupBoolImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new GraqlIdentifierImpl(node);
      }
      else if (type == ID_MACRO) {
        return new GraqlIdMacroImpl(node);
      }
      else if (type == IF_PARTIAL) {
        return new GraqlIfPartialImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new GraqlIfStatementImpl(node);
      }
      else if (type == INSERT_QUERY) {
        return new GraqlInsertQueryImpl(node);
      }
      else if (type == INT_) {
        return new GraqlInt_Impl(node);
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
      else if (type == LABEL_OR_VAR) {
        return new GraqlLabelOrVarImpl(node);
      }
      else if (type == LIST) {
        return new GraqlListImpl(node);
      }
      else if (type == MACRO_EQUALS) {
        return new GraqlMacroEqualsImpl(node);
      }
      else if (type == MACRO_NOESCP) {
        return new GraqlMacroNoescpImpl(node);
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
      else if (type == MAX) {
        return new GraqlMaxImpl(node);
      }
      else if (type == MEAN) {
        return new GraqlMeanImpl(node);
      }
      else if (type == MEDIAN) {
        return new GraqlMedianImpl(node);
      }
      else if (type == MIN) {
        return new GraqlMinImpl(node);
      }
      else if (type == NAMED_AGG) {
        return new GraqlNamedAggImpl(node);
      }
      else if (type == NIL) {
        return new GraqlNilImpl(node);
      }
      else if (type == NOT_BOOL) {
        return new GraqlNotBoolImpl(node);
      }
      else if (type == NUMBER) {
        return new GraqlNumberImpl(node);
      }
      else if (type == OF_LIST) {
        return new GraqlOfListImpl(node);
      }
      else if (type == OR_BOOL) {
        return new GraqlOrBoolImpl(node);
      }
      else if (type == OR_PATTERN) {
        return new GraqlOrPatternImpl(node);
      }
      else if (type == PATH) {
        return new GraqlPathImpl(node);
      }
      else if (type == PATHS) {
        return new GraqlPathsImpl(node);
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
      else if (type == STATEMENT) {
        return new GraqlStatementImpl(node);
      }
      else if (type == STD) {
        return new GraqlStdImpl(node);
      }
      else if (type == SUM) {
        return new GraqlSumImpl(node);
      }
      else if (type == UNDEFINE_QUERY) {
        return new GraqlUndefineQueryImpl(node);
      }
      else if (type == UNTYPED_EXPRESSION) {
        return new GraqlUntypedExpressionImpl(node);
      }
      else if (type == VALUE) {
        return new GraqlValueImpl(node);
      }
      else if (type == VALUE_OR_VAR) {
        return new GraqlValueOrVarImpl(node);
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
