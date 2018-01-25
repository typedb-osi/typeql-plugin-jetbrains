// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.intellij.lang.graql.psi.GraqlTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GraqlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == AGGREGATE_EXPRESSION) {
      r = AggregateExpression(b, 0);
    }
    else if (t == AGGREGATE_TYPE) {
      r = AggregateType(b, 0);
    }
    else if (t == AGGREGATE_TYPE_EXPR) {
      r = AggregateTypeExpr(b, 0);
    }
    else if (t == AGGREGATE_TYPE_WITH_VAR) {
      r = AggregateTypeWithVar(b, 0);
    }
    else if (t == ATTRIBUTE_EXPRESSION) {
      r = AttributeExpression(b, 0);
    }
    else if (t == COMMIT_EXPRESSION) {
      r = CommitExpression(b, 0);
    }
    else if (t == COMPUTE_EXPRESSION) {
      r = ComputeExpression(b, 0);
    }
    else if (t == DATATYPE_EXPRESSION) {
      r = DatatypeExpression(b, 0);
    }
    else if (t == DEFINE_EXPRESSION) {
      r = DefineExpression(b, 0);
    }
    else if (t == DELETE_EXPRESSION) {
      r = DeleteExpression(b, 0);
    }
    else if (t == ENTITY_EXPRESSION) {
      r = EntityExpression(b, 0);
    }
    else if (t == ENTITY_SUB_EXPRESSIONS) {
      r = EntitySubExpressions(b, 0);
    }
    else if (t == EQUALITY_EXPRESSION) {
      r = EqualityExpression(b, 0);
    }
    else if (t == EXPRESSION) {
      r = Expression(b, 0);
    }
    else if (t == HAS_EXPRESSION) {
      r = HasExpression(b, 0);
    }
    else if (t == HAS_VALUE_EXPRESSION) {
      r = HasValueExpression(b, 0);
    }
    else if (t == INSERT_EXPRESSION) {
      r = InsertExpression(b, 0);
    }
    else if (t == ISA_EXPRESSION) {
      r = IsaExpression(b, 0);
    }
    else if (t == KEY_EXPRESSION) {
      r = KeyExpression(b, 0);
    }
    else if (t == LABEL_EXPRESSION) {
      r = LabelExpression(b, 0);
    }
    else if (t == LITERAL) {
      r = Literal(b, 0);
    }
    else if (t == MATCH_EXPRESSION) {
      r = MatchExpression(b, 0);
    }
    else if (t == PLAYS_EXPRESSION) {
      r = PlaysExpression(b, 0);
    }
    else if (t == RELATES_EXPRESSION) {
      r = RelatesExpression(b, 0);
    }
    else if (t == RELATION) {
      r = Relation(b, 0);
    }
    else if (t == RELATION_EXPRESSION) {
      r = RelationExpression(b, 0);
    }
    else if (t == RELATION_FIELD) {
      r = RelationField(b, 0);
    }
    else if (t == RELATION_LIST) {
      r = RelationList(b, 0);
    }
    else if (t == RELATION_STATEMENT) {
      r = RelationStatement(b, 0);
    }
    else if (t == RELATIONSHIP_EXPRESSION) {
      r = RelationshipExpression(b, 0);
    }
    else if (t == ROLE_EXPRESSION) {
      r = RoleExpression(b, 0);
    }
    else if (t == RULE_EXPRESSION) {
      r = RuleExpression(b, 0);
    }
    else if (t == SUB_EXPRESSION) {
      r = SubExpression(b, 0);
    }
    else if (t == SUB_EXPRESSIONS) {
      r = SubExpressions(b, 0);
    }
    else if (t == VAR) {
      r = Var(b, 0);
    }
    else if (t == VAR_FIELD) {
      r = VarField(b, 0);
    }
    else if (t == VAR_LIST) {
      r = VarList(b, 0);
    }
    else if (t == WHEN_THEN_EXPRESSION) {
      r = WhenThenExpression(b, 0);
    }
    else if (t == IDENTIFIER_EXPR) {
      r = identifier_expr(b, 0);
    }
    else if (t == LITERAL_EXPR) {
      r = literal_expr(b, 0);
    }
    else if (t == THING_EXPR) {
      r = thing_expr(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return GraqlFile(b, l + 1);
  }

  /* ********************************************************** */
  // aggregate AggregateTypeExpr semicolon?
  public static boolean AggregateExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateExpression")) return false;
    if (!nextTokenIs(b, AGGREGATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AGGREGATE);
    r = r && AggregateTypeExpr(b, l + 1);
    r = r && AggregateExpression_2(b, l + 1);
    exit_section_(b, m, AGGREGATE_EXPRESSION, r);
    return r;
  }

  // semicolon?
  private static boolean AggregateExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateExpression_2")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // ask | count
  public static boolean AggregateType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateType")) return false;
    if (!nextTokenIs(b, "<aggregate type>", ASK, COUNT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AGGREGATE_TYPE, "<aggregate type>");
    r = consumeToken(b, ASK);
    if (!r) r = consumeToken(b, COUNT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AggregateType | AggregateTypeWithVar | LPAREN? AggregateTypeWithVar* RPAREN?
  public static boolean AggregateTypeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AGGREGATE_TYPE_EXPR, "<aggregate type expr>");
    r = AggregateType(b, l + 1);
    if (!r) r = AggregateTypeWithVar(b, l + 1);
    if (!r) r = AggregateTypeExpr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN? AggregateTypeWithVar* RPAREN?
  private static boolean AggregateTypeExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeExpr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AggregateTypeExpr_2_0(b, l + 1);
    r = r && AggregateTypeExpr_2_1(b, l + 1);
    r = r && AggregateTypeExpr_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN?
  private static boolean AggregateTypeExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeExpr_2_0")) return false;
    consumeToken(b, LPAREN);
    return true;
  }

  // AggregateTypeWithVar*
  private static boolean AggregateTypeExpr_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeExpr_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!AggregateTypeWithVar(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AggregateTypeExpr_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // RPAREN?
  private static boolean AggregateTypeExpr_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeExpr_2_2")) return false;
    consumeToken(b, RPAREN);
    return true;
  }

  /* ********************************************************** */
  // (sum | max | min | mean | median | group) VarField? (as identifier_expr comma?)?
  public static boolean AggregateTypeWithVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AGGREGATE_TYPE_WITH_VAR, "<aggregate type with var>");
    r = AggregateTypeWithVar_0(b, l + 1);
    r = r && AggregateTypeWithVar_1(b, l + 1);
    r = r && AggregateTypeWithVar_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // sum | max | min | mean | median | group
  private static boolean AggregateTypeWithVar_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUM);
    if (!r) r = consumeToken(b, MAX);
    if (!r) r = consumeToken(b, MIN);
    if (!r) r = consumeToken(b, MEAN);
    if (!r) r = consumeToken(b, MEDIAN);
    if (!r) r = consumeToken(b, GROUP);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarField?
  private static boolean AggregateTypeWithVar_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar_1")) return false;
    VarField(b, l + 1);
    return true;
  }

  // (as identifier_expr comma?)?
  private static boolean AggregateTypeWithVar_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar_2")) return false;
    AggregateTypeWithVar_2_0(b, l + 1);
    return true;
  }

  // as identifier_expr comma?
  private static boolean AggregateTypeWithVar_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && identifier_expr(b, l + 1);
    r = r && AggregateTypeWithVar_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean AggregateTypeWithVar_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AggregateTypeWithVar_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (identifier_expr | attribute) comma? DatatypeExpression
  public static boolean AttributeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_EXPRESSION, "<attribute expression>");
    r = AttributeExpression_0(b, l + 1);
    r = r && AttributeExpression_1(b, l + 1);
    r = r && DatatypeExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier_expr | attribute
  private static boolean AttributeExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_expr(b, l + 1);
    if (!r) r = consumeToken(b, ATTRIBUTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean AttributeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeExpression_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // commit
  public static boolean CommitExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommitExpression")) return false;
    if (!nextTokenIs(b, COMMIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMIT);
    exit_section_(b, m, COMMIT_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // compute (mean | count | cluster | max | min | std) (in | of) (identifier_expr comma?)* (in identifier_expr)? semicolon? member? semicolon?
  public static boolean ComputeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression")) return false;
    if (!nextTokenIs(b, COMPUTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPUTE);
    r = r && ComputeExpression_1(b, l + 1);
    r = r && ComputeExpression_2(b, l + 1);
    r = r && ComputeExpression_3(b, l + 1);
    r = r && ComputeExpression_4(b, l + 1);
    r = r && ComputeExpression_5(b, l + 1);
    r = r && ComputeExpression_6(b, l + 1);
    r = r && ComputeExpression_7(b, l + 1);
    exit_section_(b, m, COMPUTE_EXPRESSION, r);
    return r;
  }

  // mean | count | cluster | max | min | std
  private static boolean ComputeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MEAN);
    if (!r) r = consumeToken(b, COUNT);
    if (!r) r = consumeToken(b, CLUSTER);
    if (!r) r = consumeToken(b, MAX);
    if (!r) r = consumeToken(b, MIN);
    if (!r) r = consumeToken(b, STD);
    exit_section_(b, m, null, r);
    return r;
  }

  // in | of
  private static boolean ComputeExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier_expr comma?)*
  private static boolean ComputeExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ComputeExpression_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ComputeExpression_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // identifier_expr comma?
  private static boolean ComputeExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_expr(b, l + 1);
    r = r && ComputeExpression_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean ComputeExpression_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_3_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // (in identifier_expr)?
  private static boolean ComputeExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_4")) return false;
    ComputeExpression_4_0(b, l + 1);
    return true;
  }

  // in identifier_expr
  private static boolean ComputeExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semicolon?
  private static boolean ComputeExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_5")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  // member?
  private static boolean ComputeExpression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_6")) return false;
    consumeToken(b, MEMBER);
    return true;
  }

  // semicolon?
  private static boolean ComputeExpression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComputeExpression_7")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // datatype Literal
  public static boolean DatatypeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DatatypeExpression")) return false;
    if (!nextTokenIs(b, DATATYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATATYPE);
    r = r && Literal(b, l + 1);
    exit_section_(b, m, DATATYPE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // define (Statements*) | (id literal_expr Expression) semicolon?
  public static boolean DefineExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression")) return false;
    if (!nextTokenIs(b, "<define expression>", DEFINE, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_EXPRESSION, "<define expression>");
    r = DefineExpression_0(b, l + 1);
    if (!r) r = DefineExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // define (Statements*)
  private static boolean DefineExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE);
    r = r && DefineExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statements*
  private static boolean DefineExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DefineExpression_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (id literal_expr Expression) semicolon?
  private static boolean DefineExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DefineExpression_1_0(b, l + 1);
    r = r && DefineExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id literal_expr Expression
  private static boolean DefineExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && literal_expr(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semicolon?
  private static boolean DefineExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineExpression_1_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // delete VarField semicolon?
  public static boolean DeleteExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteExpression")) return false;
    if (!nextTokenIs(b, DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DELETE);
    r = r && VarField(b, l + 1);
    r = r && DeleteExpression_2(b, l + 1);
    exit_section_(b, m, DELETE_EXPRESSION, r);
    return r;
  }

  // semicolon?
  private static boolean DeleteExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteExpression_2")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // entity comma? EntitySubExpressions*
  public static boolean EntityExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EntityExpression")) return false;
    if (!nextTokenIs(b, ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY);
    r = r && EntityExpression_1(b, l + 1);
    r = r && EntityExpression_2(b, l + 1);
    exit_section_(b, m, ENTITY_EXPRESSION, r);
    return r;
  }

  // comma?
  private static boolean EntityExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EntityExpression_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // EntitySubExpressions*
  private static boolean EntityExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EntityExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!EntitySubExpressions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EntityExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // RelatesExpression
  public static boolean EntitySubExpressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EntitySubExpressions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_SUB_EXPRESSIONS, "<entity sub expressions>");
    r = RelatesExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VarField not_equal VarField semicolon
  public static boolean EqualityExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqualityExpression")) return false;
    if (!nextTokenIs(b, "<equality expression>", LPAREN, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUALITY_EXPRESSION, "<equality expression>");
    r = VarField(b, l + 1);
    r = r && consumeToken(b, NOT_EQUAL);
    r = r && VarField(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SubExpression
  //     | IsaExpression
  //     | KeyExpression
  //     | PlaysExpression
  //     | RelatesExpression
  //     | HasValueExpression
  //     | HasExpression
  //     | CommitExpression
  //     | RelationExpression
  //     | RuleExpression
  //     | LabelExpression
  //     | AttributeExpression
  //     | EqualityExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = SubExpression(b, l + 1);
    if (!r) r = IsaExpression(b, l + 1);
    if (!r) r = KeyExpression(b, l + 1);
    if (!r) r = PlaysExpression(b, l + 1);
    if (!r) r = RelatesExpression(b, l + 1);
    if (!r) r = HasValueExpression(b, l + 1);
    if (!r) r = HasExpression(b, l + 1);
    if (!r) r = CommitExpression(b, l + 1);
    if (!r) r = RelationExpression(b, l + 1);
    if (!r) r = RuleExpression(b, l + 1);
    if (!r) r = LabelExpression(b, l + 1);
    if (!r) r = AttributeExpression(b, l + 1);
    if (!r) r = EqualityExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (DefineExpression | InsertExpression | MatchExpression | ComputeExpression | DeleteExpression | AggregateExpression)*
  static boolean GraqlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraqlFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GraqlFile_0(b, l + 1);
    r = r && GraqlFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean GraqlFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraqlFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DefineExpression | InsertExpression | MatchExpression | ComputeExpression | DeleteExpression | AggregateExpression)*
  private static boolean GraqlFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraqlFile_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!GraqlFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GraqlFile_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DefineExpression | InsertExpression | MatchExpression | ComputeExpression | DeleteExpression | AggregateExpression
  private static boolean GraqlFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraqlFile_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DefineExpression(b, l + 1);
    if (!r) r = InsertExpression(b, l + 1);
    if (!r) r = MatchExpression(b, l + 1);
    if (!r) r = ComputeExpression(b, l + 1);
    if (!r) r = DeleteExpression(b, l + 1);
    if (!r) r = AggregateExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VarField | identifier_expr)? has identifier_expr
  public static boolean HasExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HAS_EXPRESSION, "<has expression>");
    r = HasExpression_0(b, l + 1);
    r = r && consumeToken(b, HAS);
    r = r && identifier_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VarField | identifier_expr)?
  private static boolean HasExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasExpression_0")) return false;
    HasExpression_0_0(b, l + 1);
    return true;
  }

  // VarField | identifier_expr
  private static boolean HasExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VarField | identifier_expr)? has identifier_expr (VarField | literal_expr) (as VarField)?
  public static boolean HasValueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HAS_VALUE_EXPRESSION, "<has value expression>");
    r = HasValueExpression_0(b, l + 1);
    r = r && consumeToken(b, HAS);
    r = r && identifier_expr(b, l + 1);
    r = r && HasValueExpression_3(b, l + 1);
    r = r && HasValueExpression_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VarField | identifier_expr)?
  private static boolean HasValueExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression_0")) return false;
    HasValueExpression_0_0(b, l + 1);
    return true;
  }

  // VarField | identifier_expr
  private static boolean HasValueExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarField | literal_expr
  private static boolean HasValueExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (as VarField)?
  private static boolean HasValueExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression_4")) return false;
    HasValueExpression_4_0(b, l + 1);
    return true;
  }

  // as VarField
  private static boolean HasValueExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HasValueExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && VarField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // insert Statements*
  public static boolean InsertExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InsertExpression")) return false;
    if (!nextTokenIs(b, INSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSERT);
    r = r && InsertExpression_1(b, l + 1);
    exit_section_(b, m, INSERT_EXPRESSION, r);
    return r;
  }

  // Statements*
  private static boolean InsertExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InsertExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InsertExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (VarField | RelationField | identifier_expr)? isa (VarField | RelationField | identifier_expr) comma? HasValueExpression? semicolon?
  public static boolean IsaExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISA_EXPRESSION, "<isa expression>");
    r = IsaExpression_0(b, l + 1);
    r = r && consumeToken(b, ISA);
    r = r && IsaExpression_2(b, l + 1);
    r = r && IsaExpression_3(b, l + 1);
    r = r && IsaExpression_4(b, l + 1);
    r = r && IsaExpression_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VarField | RelationField | identifier_expr)?
  private static boolean IsaExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_0")) return false;
    IsaExpression_0_0(b, l + 1);
    return true;
  }

  // VarField | RelationField | identifier_expr
  private static boolean IsaExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = RelationField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarField | RelationField | identifier_expr
  private static boolean IsaExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = RelationField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean IsaExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // HasValueExpression?
  private static boolean IsaExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_4")) return false;
    HasValueExpression(b, l + 1);
    return true;
  }

  // semicolon?
  private static boolean IsaExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IsaExpression_5")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // identifier_expr? key identifier_expr
  public static boolean KeyExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_EXPRESSION, "<key expression>");
    r = KeyExpression_0(b, l + 1);
    r = r && consumeToken(b, KEY);
    r = r && identifier_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier_expr?
  private static boolean KeyExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyExpression_0")) return false;
    identifier_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (VarField | RelationField | identifier_expr) label string_literal
  public static boolean LabelExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabelExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL_EXPRESSION, "<label expression>");
    r = LabelExpression_0(b, l + 1);
    r = r && consumeTokens(b, 0, LABEL, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarField | RelationField | identifier_expr
  private static boolean LabelExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabelExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = RelationField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'string'
  //     | 'boolean'
  //     | 'double'
  //     | 'long'
  //     | 'date'
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, DATE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // match (Statements | InsertExpression)* get? VarField? semicolon?
  public static boolean MatchExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && MatchExpression_1(b, l + 1);
    r = r && MatchExpression_2(b, l + 1);
    r = r && MatchExpression_3(b, l + 1);
    r = r && MatchExpression_4(b, l + 1);
    exit_section_(b, m, MATCH_EXPRESSION, r);
    return r;
  }

  // (Statements | InsertExpression)*
  private static boolean MatchExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MatchExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MatchExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // Statements | InsertExpression
  private static boolean MatchExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statements(b, l + 1);
    if (!r) r = InsertExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // get?
  private static boolean MatchExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_2")) return false;
    consumeToken(b, GET);
    return true;
  }

  // VarField?
  private static boolean MatchExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_3")) return false;
    VarField(b, l + 1);
    return true;
  }

  // semicolon?
  private static boolean MatchExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_4")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // (VarField | identifier_expr)? plays identifier_expr
  public static boolean PlaysExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlaysExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLAYS_EXPRESSION, "<plays expression>");
    r = PlaysExpression_0(b, l + 1);
    r = r && consumeToken(b, PLAYS);
    r = r && identifier_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VarField | identifier_expr)?
  private static boolean PlaysExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlaysExpression_0")) return false;
    PlaysExpression_0_0(b, l + 1);
    return true;
  }

  // VarField | identifier_expr
  private static boolean PlaysExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlaysExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VarField | identifier_expr)? relates (VarField | RelationField | identifier_expr)
  public static boolean RelatesExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelatesExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATES_EXPRESSION, "<relates expression>");
    r = RelatesExpression_0(b, l + 1);
    r = r && consumeToken(b, RELATES);
    r = r && RelatesExpression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VarField | identifier_expr)?
  private static boolean RelatesExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelatesExpression_0")) return false;
    RelatesExpression_0_0(b, l + 1);
    return true;
  }

  // VarField | identifier_expr
  private static boolean RelatesExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelatesExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarField | RelationField | identifier_expr
  private static boolean RelatesExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelatesExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = RelationField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier_expr colon (VARIABLE comma?)*
  public static boolean Relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Relation")) return false;
    if (!nextTokenIs(b, "<relation>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATION, "<relation>");
    r = identifier_expr(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Relation_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VARIABLE comma?)*
  private static boolean Relation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Relation_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Relation_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Relation_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // VARIABLE comma?
  private static boolean Relation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Relation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    r = r && Relation_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean Relation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Relation_2_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // Var RelationField
  public static boolean RelationExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationExpression")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    r = r && RelationField(b, l + 1);
    exit_section_(b, m, RELATION_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN RelationList* RPAREN
  public static boolean RelationField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationField")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && RelationField_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, RELATION_FIELD, r);
    return r;
  }

  // RelationList*
  private static boolean RelationField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationField_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RelationList(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RelationField_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // Relation comma?
  public static boolean RelationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationList")) return false;
    if (!nextTokenIs(b, "<relation list>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATION_LIST, "<relation list>");
    r = Relation(b, l + 1);
    r = r && RelationList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // comma?
  private static boolean RelationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationList_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (LPAREN RelationList* RPAREN) semicolon
  public static boolean RelationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationStatement")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RelationStatement_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RELATION_STATEMENT, r);
    return r;
  }

  // LPAREN RelationList* RPAREN
  private static boolean RelationStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && RelationStatement_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // RelationList*
  private static boolean RelationStatement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationStatement_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RelationList(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RelationStatement_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // relationship comma? RelatesExpression*
  public static boolean RelationshipExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipExpression")) return false;
    if (!nextTokenIs(b, RELATIONSHIP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RELATIONSHIP);
    r = r && RelationshipExpression_1(b, l + 1);
    r = r && RelationshipExpression_2(b, l + 1);
    exit_section_(b, m, RELATIONSHIP_EXPRESSION, r);
    return r;
  }

  // comma?
  private static boolean RelationshipExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipExpression_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // RelatesExpression*
  private static boolean RelationshipExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RelatesExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RelationshipExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // role
  public static boolean RoleExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RoleExpression")) return false;
    if (!nextTokenIs(b, ROLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROLE);
    exit_section_(b, m, ROLE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // rule comma? WhenThenExpression
  public static boolean RuleExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleExpression")) return false;
    if (!nextTokenIs(b, RULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE);
    r = r && RuleExpression_1(b, l + 1);
    r = r && WhenThenExpression(b, l + 1);
    exit_section_(b, m, RULE_EXPRESSION, r);
    return r;
  }

  // comma?
  private static boolean RuleExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleExpression_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> Expression (comma | semicolon)?
  static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statements_0(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && Statements_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean Statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comma | semicolon)?
  private static boolean Statements_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_2")) return false;
    Statements_2_0(b, l + 1);
    return true;
  }

  // comma | semicolon
  private static boolean Statements_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VarField | RelationField | identifier_expr) "is-abstract"? sub ((thing_expr comma? DatatypeExpression?) | SubExpressions*)
  public static boolean SubExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUB_EXPRESSION, "<sub expression>");
    r = SubExpression_0(b, l + 1);
    r = r && SubExpression_1(b, l + 1);
    r = r && consumeToken(b, SUB);
    r = r && SubExpression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarField | RelationField | identifier_expr
  private static boolean SubExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarField(b, l + 1);
    if (!r) r = RelationField(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "is-abstract"?
  private static boolean SubExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_1")) return false;
    consumeToken(b, IS_ABSTRACT);
    return true;
  }

  // (thing_expr comma? DatatypeExpression?) | SubExpressions*
  private static boolean SubExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SubExpression_3_0(b, l + 1);
    if (!r) r = SubExpression_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // thing_expr comma? DatatypeExpression?
  private static boolean SubExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = thing_expr(b, l + 1);
    r = r && SubExpression_3_0_1(b, l + 1);
    r = r && SubExpression_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean SubExpression_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_3_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // DatatypeExpression?
  private static boolean SubExpression_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_3_0_2")) return false;
    DatatypeExpression(b, l + 1);
    return true;
  }

  // SubExpressions*
  private static boolean SubExpression_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpression_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SubExpressions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SubExpression_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // EntityExpression
  //     | AttributeExpression
  //     | RelationshipExpression
  //     | RoleExpression
  public static boolean SubExpressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubExpressions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUB_EXPRESSIONS, "<sub expressions>");
    r = EntityExpression(b, l + 1);
    if (!r) r = AttributeExpression(b, l + 1);
    if (!r) r = RelationshipExpression(b, l + 1);
    if (!r) r = RoleExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE
  public static boolean Var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var")) return false;
    if (!nextTokenIs(b, "<variable>", VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR, "<variable>");
    r = consumeToken(b, VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var | (LPAREN VarList* RPAREN)
  public static boolean VarField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarField")) return false;
    if (!nextTokenIs(b, "<var field>", LPAREN, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_FIELD, "<var field>");
    r = Var(b, l + 1);
    if (!r) r = VarField_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN VarList* RPAREN
  private static boolean VarField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarField_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && VarField_1_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarList*
  private static boolean VarField_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarField_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!VarList(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarField_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // Var comma?
  public static boolean VarList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarList")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    r = r && VarList_1(b, l + 1);
    exit_section_(b, m, VAR_LIST, r);
    return r;
  }

  // comma?
  private static boolean VarList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarList_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // when LBRACE (RelationStatement | IsaExpression)* RBRACE comma? then LBRACE (RelationStatement | IsaExpression)* RBRACE
  public static boolean WhenThenExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression")) return false;
    if (!nextTokenIs(b, WHEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHEN, LBRACE);
    r = r && WhenThenExpression_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && WhenThenExpression_4(b, l + 1);
    r = r && consumeTokens(b, 0, THEN, LBRACE);
    r = r && WhenThenExpression_7(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, WHEN_THEN_EXPRESSION, r);
    return r;
  }

  // (RelationStatement | IsaExpression)*
  private static boolean WhenThenExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!WhenThenExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WhenThenExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // RelationStatement | IsaExpression
  private static boolean WhenThenExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RelationStatement(b, l + 1);
    if (!r) r = IsaExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean WhenThenExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // (RelationStatement | IsaExpression)*
  private static boolean WhenThenExpression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression_7")) return false;
    int c = current_position_(b);
    while (true) {
      if (!WhenThenExpression_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "WhenThenExpression_7", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // RelationStatement | IsaExpression
  private static boolean WhenThenExpression_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenThenExpression_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RelationStatement(b, l + 1);
    if (!r) r = IsaExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier | string_literal
  public static boolean identifier_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_expr")) return false;
    if (!nextTokenIs(b, "<identifier expr>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_EXPR, "<identifier expr>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number_literal | string_literal
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    if (!nextTokenIs(b, "<literal expr>", NUMBER_LITERAL, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, NUMBER_LITERAL);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // entity | identifier_expr | relationship | role | attribute
  public static boolean thing_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thing_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, THING_EXPR, "<thing expr>");
    r = consumeToken(b, ENTITY);
    if (!r) r = identifier_expr(b, l + 1);
    if (!r) r = consumeToken(b, RELATIONSHIP);
    if (!r) r = consumeToken(b, ROLE);
    if (!r) r = consumeToken(b, ATTRIBUTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
