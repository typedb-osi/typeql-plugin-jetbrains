// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.psi.impl.*;

public interface GraqlTokenTypes {

  IElementType AGGREGATE_EXPRESSION = new GraqlElementType("AGGREGATE_EXPRESSION");
  IElementType AGGREGATE_TYPE = new GraqlElementType("AGGREGATE_TYPE");
  IElementType AGGREGATE_TYPE_EXPR = new GraqlElementType("AGGREGATE_TYPE_EXPR");
  IElementType AGGREGATE_TYPE_WITH_VAR = new GraqlElementType("AGGREGATE_TYPE_WITH_VAR");
  IElementType ATTRIBUTE_EXPRESSION = new GraqlElementType("ATTRIBUTE_EXPRESSION");
  IElementType COMMIT_EXPRESSION = new GraqlElementType("COMMIT_EXPRESSION");
  IElementType COMPUTE_EXPRESSION = new GraqlElementType("COMPUTE_EXPRESSION");
  IElementType DATATYPE_EXPRESSION = new GraqlElementType("DATATYPE_EXPRESSION");
  IElementType DEFINE_EXPRESSION = new GraqlElementType("DEFINE_EXPRESSION");
  IElementType DELETE_EXPRESSION = new GraqlElementType("DELETE_EXPRESSION");
  IElementType ENTITY_EXPRESSION = new GraqlElementType("ENTITY_EXPRESSION");
  IElementType ENTITY_SUB_EXPRESSIONS = new GraqlElementType("ENTITY_SUB_EXPRESSIONS");
  IElementType EQUALITY_EXPRESSION = new GraqlElementType("EQUALITY_EXPRESSION");
  IElementType EXPRESSION = new GraqlElementType("EXPRESSION");
  IElementType HAS_EXPRESSION = new GraqlElementType("HAS_EXPRESSION");
  IElementType HAS_VALUE_EXPRESSION = new GraqlElementType("HAS_VALUE_EXPRESSION");
  IElementType IDENTIFIER_EXPR = new GraqlElementType("IDENTIFIER_EXPR");
  IElementType INSERT_EXPRESSION = new GraqlElementType("INSERT_EXPRESSION");
  IElementType ISA_EXPRESSION = new GraqlElementType("ISA_EXPRESSION");
  IElementType KEY_EXPRESSION = new GraqlElementType("KEY_EXPRESSION");
  IElementType LABEL_EXPRESSION = new GraqlElementType("LABEL_EXPRESSION");
  IElementType LITERAL = new GraqlElementType("LITERAL");
  IElementType LITERAL_EXPR = new GraqlElementType("LITERAL_EXPR");
  IElementType MATCH_EXPRESSION = new GraqlElementType("MATCH_EXPRESSION");
  IElementType PLAYS_EXPRESSION = new GraqlElementType("PLAYS_EXPRESSION");
  IElementType RELATES_EXPRESSION = new GraqlElementType("RELATES_EXPRESSION");
  IElementType RELATION = new GraqlElementType("RELATION");
  IElementType RELATIONSHIP_EXPRESSION = new GraqlElementType("RELATIONSHIP_EXPRESSION");
  IElementType RELATION_EXPRESSION = new GraqlElementType("RELATION_EXPRESSION");
  IElementType RELATION_FIELD = new GraqlElementType("RELATION_FIELD");
  IElementType RELATION_LIST = new GraqlElementType("RELATION_LIST");
  IElementType RELATION_STATEMENT = new GraqlElementType("RELATION_STATEMENT");
  IElementType ROLE_EXPRESSION = new GraqlElementType("ROLE_EXPRESSION");
  IElementType RULE_EXPRESSION = new GraqlElementType("RULE_EXPRESSION");
  IElementType SUB_EXPRESSION = new GraqlElementType("SUB_EXPRESSION");
  IElementType SUB_EXPRESSIONS = new GraqlElementType("SUB_EXPRESSIONS");
  IElementType THING_EXPR = new GraqlElementType("THING_EXPR");
  IElementType VAR = new GraqlElementType("VAR");
  IElementType VAR_FIELD = new GraqlElementType("VAR_FIELD");
  IElementType VAR_LIST = new GraqlElementType("VAR_LIST");
  IElementType WHEN_THEN_EXPRESSION = new GraqlElementType("WHEN_THEN_EXPRESSION");

  IElementType AGGREGATE = new GraqlTokenType("aggregate");
  IElementType AS = new GraqlTokenType("as");
  IElementType ASK = new GraqlTokenType("ask");
  IElementType ATTRIBUTE = new GraqlTokenType("attribute");
  IElementType BOOLEAN = new GraqlTokenType("boolean");
  IElementType CLUSTER = new GraqlTokenType("cluster");
  IElementType COLON = new GraqlTokenType(":");
  IElementType COMMA = new GraqlTokenType(",");
  IElementType COMMIT = new GraqlTokenType("commit");
  IElementType COMPUTE = new GraqlTokenType("compute");
  IElementType COUNT = new GraqlTokenType("count");
  IElementType DATATYPE = new GraqlTokenType("datatype");
  IElementType DATE = new GraqlTokenType("date");
  IElementType DEFINE = new GraqlTokenType("define");
  IElementType DELETE = new GraqlTokenType("delete");
  IElementType DOUBLE = new GraqlTokenType("double");
  IElementType ENTITY = new GraqlTokenType("entity");
  IElementType GET = new GraqlTokenType("get");
  IElementType GROUP = new GraqlTokenType("group");
  IElementType HAS = new GraqlTokenType("has");
  IElementType ID = new GraqlTokenType("id");
  IElementType IDENTIFIER = new GraqlTokenType("identifier");
  IElementType IN = new GraqlTokenType("in");
  IElementType INSERT = new GraqlTokenType("insert");
  IElementType ISA = new GraqlTokenType("isa");
  IElementType IS_ABSTRACT = new GraqlTokenType("is-abstract");
  IElementType KEY = new GraqlTokenType("key");
  IElementType LABEL = new GraqlTokenType("label");
  IElementType LBRACE = new GraqlTokenType("{");
  IElementType LONG = new GraqlTokenType("long");
  IElementType LPAREN = new GraqlTokenType("(");
  IElementType MATCH = new GraqlTokenType("match");
  IElementType MAX = new GraqlTokenType("max");
  IElementType MEAN = new GraqlTokenType("mean");
  IElementType MEDIAN = new GraqlTokenType("median");
  IElementType MEMBER = new GraqlTokenType("member");
  IElementType MIN = new GraqlTokenType("min");
  IElementType NOT_EQUAL = new GraqlTokenType("!=");
  IElementType NUMBER_LITERAL = new GraqlTokenType("number_literal");
  IElementType OF = new GraqlTokenType("of");
  IElementType PLAYS = new GraqlTokenType("plays");
  IElementType RBRACE = new GraqlTokenType("}");
  IElementType RELATES = new GraqlTokenType("relates");
  IElementType RELATIONSHIP = new GraqlTokenType("relationship");
  IElementType ROLE = new GraqlTokenType("role");
  IElementType RPAREN = new GraqlTokenType(")");
  IElementType RULE = new GraqlTokenType("rule");
  IElementType SEMICOLON = new GraqlTokenType(";");
  IElementType SINGLE_LINE_COMMENT = new GraqlTokenType("single_line_comment");
  IElementType STD = new GraqlTokenType("std");
  IElementType STRING = new GraqlTokenType("string");
  IElementType STRING_LITERAL = new GraqlTokenType("string_literal");
  IElementType SUB = new GraqlTokenType("sub");
  IElementType SUM = new GraqlTokenType("sum");
  IElementType THEN = new GraqlTokenType("then");
  IElementType VARIABLE = new GraqlTokenType("VARIABLE");
  IElementType VIA = new GraqlTokenType("via");
  IElementType WHEN = new GraqlTokenType("when");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == AGGREGATE_EXPRESSION) {
        return new GraqlAggregateExpressionImpl(node);
      }
      else if (type == AGGREGATE_TYPE) {
        return new GraqlAggregateTypeImpl(node);
      }
      else if (type == AGGREGATE_TYPE_EXPR) {
        return new GraqlAggregateTypeExprImpl(node);
      }
      else if (type == AGGREGATE_TYPE_WITH_VAR) {
        return new GraqlAggregateTypeWithVarImpl(node);
      }
      else if (type == ATTRIBUTE_EXPRESSION) {
        return new GraqlAttributeExpressionImpl(node);
      }
      else if (type == COMMIT_EXPRESSION) {
        return new GraqlCommitExpressionImpl(node);
      }
      else if (type == COMPUTE_EXPRESSION) {
        return new GraqlComputeExpressionImpl(node);
      }
      else if (type == DATATYPE_EXPRESSION) {
        return new GraqlDatatypeExpressionImpl(node);
      }
      else if (type == DEFINE_EXPRESSION) {
        return new GraqlDefineExpressionImpl(node);
      }
      else if (type == DELETE_EXPRESSION) {
        return new GraqlDeleteExpressionImpl(node);
      }
      else if (type == ENTITY_EXPRESSION) {
        return new GraqlEntityExpressionImpl(node);
      }
      else if (type == ENTITY_SUB_EXPRESSIONS) {
        return new GraqlEntitySubExpressionsImpl(node);
      }
      else if (type == EQUALITY_EXPRESSION) {
        return new GraqlEqualityExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new GraqlExpressionImpl(node);
      }
      else if (type == HAS_EXPRESSION) {
        return new GraqlHasExpressionImpl(node);
      }
      else if (type == HAS_VALUE_EXPRESSION) {
        return new GraqlHasValueExpressionImpl(node);
      }
      else if (type == IDENTIFIER_EXPR) {
        return new GraqlIdentifierExprImpl(node);
      }
      else if (type == INSERT_EXPRESSION) {
        return new GraqlInsertExpressionImpl(node);
      }
      else if (type == ISA_EXPRESSION) {
        return new GraqlIsaExpressionImpl(node);
      }
      else if (type == KEY_EXPRESSION) {
        return new GraqlKeyExpressionImpl(node);
      }
      else if (type == LABEL_EXPRESSION) {
        return new GraqlLabelExpressionImpl(node);
      }
      else if (type == LITERAL) {
        return new GraqlLiteralImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new GraqlLiteralExprImpl(node);
      }
      else if (type == MATCH_EXPRESSION) {
        return new GraqlMatchExpressionImpl(node);
      }
      else if (type == PLAYS_EXPRESSION) {
        return new GraqlPlaysExpressionImpl(node);
      }
      else if (type == RELATES_EXPRESSION) {
        return new GraqlRelatesExpressionImpl(node);
      }
      else if (type == RELATION) {
        return new GraqlRelationImpl(node);
      }
      else if (type == RELATIONSHIP_EXPRESSION) {
        return new GraqlRelationshipExpressionImpl(node);
      }
      else if (type == RELATION_EXPRESSION) {
        return new GraqlRelationExpressionImpl(node);
      }
      else if (type == RELATION_FIELD) {
        return new GraqlRelationFieldImpl(node);
      }
      else if (type == RELATION_LIST) {
        return new GraqlRelationListImpl(node);
      }
      else if (type == RELATION_STATEMENT) {
        return new GraqlRelationStatementImpl(node);
      }
      else if (type == ROLE_EXPRESSION) {
        return new GraqlRoleExpressionImpl(node);
      }
      else if (type == RULE_EXPRESSION) {
        return new GraqlRuleExpressionImpl(node);
      }
      else if (type == SUB_EXPRESSION) {
        return new GraqlSubExpressionImpl(node);
      }
      else if (type == SUB_EXPRESSIONS) {
        return new GraqlSubExpressionsImpl(node);
      }
      else if (type == THING_EXPR) {
        return new GraqlThingExprImpl(node);
      }
      else if (type == VAR) {
        return new GraqlVarImpl(node);
      }
      else if (type == VAR_FIELD) {
        return new GraqlVarFieldImpl(node);
      }
      else if (type == VAR_LIST) {
        return new GraqlVarListImpl(node);
      }
      else if (type == WHEN_THEN_EXPRESSION) {
        return new GraqlWhenThenExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
