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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ID_MACRO) {
      r = ID_MACRO(b, 0);
    }
    else if (t == MACRO_EQUALS) {
      r = MACRO_EQUALS(b, 0);
    }
    else if (t == MACRO_NOESCP) {
      r = MACRO_NOESCP(b, 0);
    }
    else if (t == ACCESSOR) {
      r = accessor(b, 0);
    }
    else if (t == AGGREGATE) {
      r = aggregate(b, 0);
    }
    else if (t == AGGREGATE_QUERY) {
      r = aggregateQuery(b, 0);
    }
    else if (t == AND_BOOL) {
      r = andBool(b, 0);
    }
    else if (t == ARGUMENT) {
      r = argument(b, 0);
    }
    else if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == BLOCK_CONTENTS) {
      r = blockContents(b, 0);
    }
    else if (t == BOOL) {
      r = bool(b, 0);
    }
    else if (t == CASTING) {
      r = casting(b, 0);
    }
    else if (t == CLUSTER) {
      r = cluster(b, 0);
    }
    else if (t == CLUSTER_PARAM) {
      r = clusterParam(b, 0);
    }
    else if (t == COMPUTE_METHOD) {
      r = computeMethod(b, 0);
    }
    else if (t == COMPUTE_QUERY) {
      r = computeQuery(b, 0);
    }
    else if (t == COUNT) {
      r = count(b, 0);
    }
    else if (t == DEFINE_QUERY) {
      r = defineQuery(b, 0);
    }
    else if (t == DEGREES) {
      r = degrees(b, 0);
    }
    else if (t == DELETE_QUERY) {
      r = deleteQuery(b, 0);
    }
    else if (t == DOUBLE_) {
      r = double_(b, 0);
    }
    else if (t == ELSE_IF_PARTIAL) {
      r = elseIfPartial(b, 0);
    }
    else if (t == ELSE_PARTIAL) {
      r = elsePartial(b, 0);
    }
    else if (t == ESCAPED_EXPRESSION) {
      r = escapedExpression(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == FOR_EACH_STATEMENT) {
      r = forEachStatement(b, 0);
    }
    else if (t == FOR_IN_STATEMENT) {
      r = forInStatement(b, 0);
    }
    else if (t == GET_QUERY) {
      r = getQuery(b, 0);
    }
    else if (t == GROUP_BOOL) {
      r = groupBool(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = identifier(b, 0);
    }
    else if (t == IF_PARTIAL) {
      r = ifPartial(b, 0);
    }
    else if (t == IF_STATEMENT) {
      r = ifStatement(b, 0);
    }
    else if (t == IN_LIST) {
      r = inList(b, 0);
    }
    else if (t == INSERT_QUERY) {
      r = insertQuery(b, 0);
    }
    else if (t == INT_) {
      r = int_(b, 0);
    }
    else if (t == LABEL) {
      r = label(b, 0);
    }
    else if (t == LABEL_LIST) {
      r = labelList(b, 0);
    }
    else if (t == LABEL_OR_VAR) {
      r = labelOrVar(b, 0);
    }
    else if (t == LIST) {
      r = list(b, 0);
    }
    else if (t == MATCH_LIMIT) {
      r = matchLimit(b, 0);
    }
    else if (t == MATCH_LIMIT_OFFSET) {
      r = matchLimitOffset(b, 0);
    }
    else if (t == MATCH_OFFSET) {
      r = matchOffset(b, 0);
    }
    else if (t == MATCH_OFFSET_LIMIT) {
      r = matchOffsetLimit(b, 0);
    }
    else if (t == MATCH_ORDER_BY) {
      r = matchOrderBy(b, 0);
    }
    else if (t == MATCH_PART) {
      r = matchPart(b, 0);
    }
    else if (t == MAX) {
      r = max(b, 0);
    }
    else if (t == MEAN) {
      r = mean(b, 0);
    }
    else if (t == MEDIAN) {
      r = median(b, 0);
    }
    else if (t == MIN) {
      r = min(b, 0);
    }
    else if (t == NAMED_AGG) {
      r = namedAgg(b, 0);
    }
    else if (t == NIL) {
      r = nil(b, 0);
    }
    else if (t == NOT_BOOL) {
      r = notBool(b, 0);
    }
    else if (t == NUMBER) {
      r = number(b, 0);
    }
    else if (t == OF_LIST) {
      r = ofList(b, 0);
    }
    else if (t == OR_BOOL) {
      r = orBool(b, 0);
    }
    else if (t == PATH) {
      r = path(b, 0);
    }
    else if (t == PATHS) {
      r = paths(b, 0);
    }
    else if (t == PATTERN) {
      r = pattern(b, 0, -1);
    }
    else if (t == PATTERNS) {
      r = patterns(b, 0);
    }
    else if (t == PREDICATE) {
      r = predicate(b, 0);
    }
    else if (t == PROPERTY) {
      r = property(b, 0);
    }
    else if (t == QUERY) {
      r = query(b, 0);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == STD) {
      r = std(b, 0);
    }
    else if (t == SUM) {
      r = sum(b, 0);
    }
    else if (t == UNDEFINE_QUERY) {
      r = undefineQuery(b, 0);
    }
    else if (t == UNTYPED_EXPRESSION) {
      r = untypedExpression(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else if (t == VALUE_OR_VAR) {
      r = valueOrVar(b, 0);
    }
    else if (t == VAR_PATTERNS) {
      r = varPatterns(b, 0);
    }
    else if (t == VARIABLES) {
      r = variables(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return GraqlFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(AND_PATTERN, OR_PATTERN, PATTERN, VAR_PATTERN),
  };

  /* ********************************************************** */
  // !<<eof>> (query)*
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

  // (query)*
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

  // (query)
  private static boolean GraqlFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraqlFile_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AT (MACRO_NOESCP|ID|int_keyword|long_keyword|double_keyword|boolean_keyword|date_keyword)
  public static boolean ID_MACRO(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ID_MACRO")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && ID_MACRO_1(b, l + 1);
    exit_section_(b, m, ID_MACRO, r);
    return r;
  }

  // MACRO_NOESCP|ID|int_keyword|long_keyword|double_keyword|boolean_keyword|date_keyword
  private static boolean ID_MACRO_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ID_MACRO_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MACRO_NOESCP(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, INT_KEYWORD);
    if (!r) r = consumeToken(b, LONG_KEYWORD);
    if (!r) r = consumeToken(b, DOUBLE_KEYWORD);
    if (!r) r = consumeToken(b, BOOLEAN_KEYWORD);
    if (!r) r = consumeToken(b, DATE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AT equals_keyword LPAREN expression? (',' expression)* RPAREN accessor?
  public static boolean MACRO_EQUALS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_EQUALS")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, EQUALS_KEYWORD, LPAREN);
    r = r && MACRO_EQUALS_3(b, l + 1);
    r = r && MACRO_EQUALS_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && MACRO_EQUALS_6(b, l + 1);
    exit_section_(b, m, MACRO_EQUALS, r);
    return r;
  }

  // expression?
  private static boolean MACRO_EQUALS_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_EQUALS_3")) return false;
    expression(b, l + 1);
    return true;
  }

  // (',' expression)*
  private static boolean MACRO_EQUALS_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_EQUALS_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MACRO_EQUALS_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MACRO_EQUALS_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean MACRO_EQUALS_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_EQUALS_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // accessor?
  private static boolean MACRO_EQUALS_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_EQUALS_6")) return false;
    accessor(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AT noescp_keyword LPAREN expression? (',' expression)* RPAREN accessor? identifier?
  public static boolean MACRO_NOESCP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, NOESCP_KEYWORD, LPAREN);
    r = r && MACRO_NOESCP_3(b, l + 1);
    r = r && MACRO_NOESCP_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && MACRO_NOESCP_6(b, l + 1);
    r = r && MACRO_NOESCP_7(b, l + 1);
    exit_section_(b, m, MACRO_NOESCP, r);
    return r;
  }

  // expression?
  private static boolean MACRO_NOESCP_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP_3")) return false;
    expression(b, l + 1);
    return true;
  }

  // (',' expression)*
  private static boolean MACRO_NOESCP_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MACRO_NOESCP_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MACRO_NOESCP_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean MACRO_NOESCP_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // accessor?
  private static boolean MACRO_NOESCP_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP_6")) return false;
    accessor(b, l + 1);
    return true;
  }

  // identifier?
  private static boolean MACRO_NOESCP_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_NOESCP_7")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // period identifier     //mapAccessor
  //     | LBR int_ RBR
  public static boolean accessor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "accessor")) return false;
    if (!nextTokenIs(b, "<accessor>", LBR, PERIOD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESSOR, "<accessor>");
    r = accessor_0(b, l + 1);
    if (!r) r = accessor_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // period identifier
  private static boolean accessor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "accessor_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERIOD);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBR int_ RBR
  private static boolean accessor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "accessor_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBR);
    r = r && int_(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // labelOrVar argument*      // customAgg
  //     | '(' namedAgg (',' namedAgg)* ')'
  public static boolean aggregate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AGGREGATE, "<aggregate>");
    r = aggregate_0(b, l + 1);
    if (!r) r = aggregate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // labelOrVar argument*
  private static boolean aggregate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labelOrVar(b, l + 1);
    r = r && aggregate_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument*
  private static boolean aggregate_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "aggregate_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '(' namedAgg (',' namedAgg)* ')'
  private static boolean aggregate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && namedAgg(b, l + 1);
    r = r && aggregate_1_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' namedAgg)*
  private static boolean aggregate_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!aggregate_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "aggregate_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' namedAgg
  private static boolean aggregate_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && namedAgg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // matchPart aggregate_keyword aggregate ';'
  public static boolean aggregateQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregateQuery")) return false;
    if (!nextTokenIs(b, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && consumeToken(b, AGGREGATE_KEYWORD);
    r = r && aggregate(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, AGGREGATE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // groupBool and_keyword groupBool
  public static boolean andBool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andBool")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = groupBool(b, l + 1);
    r = r && consumeToken(b, AND_KEYWORD);
    r = r && groupBool(b, l + 1);
    exit_section_(b, m, AND_BOOL, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE  // variableArgument
  //     | aggregate
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = consumeToken(b, VARIABLE);
    if (!r) r = aggregate(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE blockContents RBRACE ';'?
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && blockContents(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && block_3(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // ';'?
  private static boolean block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_3")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // (statement | escapedExpression | query | patterns)*
  public static boolean blockContents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockContents")) return false;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_CONTENTS, "<block contents>");
    int c = current_position_(b);
    while (true) {
      if (!blockContents_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockContents", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // statement | escapedExpression | query | patterns
  private static boolean blockContents_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockContents_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = escapedExpression(b, l + 1);
    if (!r) r = query(b, l + 1);
    if (!r) r = patterns(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression EQ expression           //eqExpression
  //     | expression NEQ expression             //NEQExpression
  //     | number GREATER number                 //greaterExpression
  //     | number GREATEREQ number               //greaterEqExpression
  //     | number LESS number                    //lessExpression
  //     | number LESSEQ number                  //lessEqExpression
  //     | untypedExpression                     //booleanExpression
  //     | (true_keyword|false_keyword)                          //booleanConstant
  //     | orBool
  //     | andBool
  //     | notBool
  //     | groupBool
  public static boolean bool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL, "<bool>");
    r = bool_0(b, l + 1);
    if (!r) r = bool_1(b, l + 1);
    if (!r) r = bool_2(b, l + 1);
    if (!r) r = bool_3(b, l + 1);
    if (!r) r = bool_4(b, l + 1);
    if (!r) r = bool_5(b, l + 1);
    if (!r) r = untypedExpression(b, l + 1);
    if (!r) r = bool_7(b, l + 1);
    if (!r) r = orBool(b, l + 1);
    if (!r) r = andBool(b, l + 1);
    if (!r) r = notBool(b, l + 1);
    if (!r) r = groupBool(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression EQ expression
  private static boolean bool_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression NEQ expression
  private static boolean bool_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, NEQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number GREATER number
  private static boolean bool_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number(b, l + 1);
    r = r && consumeToken(b, GREATER);
    r = r && number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number GREATEREQ number
  private static boolean bool_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number(b, l + 1);
    r = r && consumeToken(b, GREATEREQ);
    r = r && number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number LESS number
  private static boolean bool_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number(b, l + 1);
    r = r && consumeToken(b, LESS);
    r = r && number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number LESSEQ number
  private static boolean bool_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number(b, l + 1);
    r = r && consumeToken(b, LESSEQ);
    r = r && number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // true_keyword|false_keyword
  private static boolean bool_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // labelOrVar (':' VARIABLE)?
  //     | labelOrVar VARIABLE
  public static boolean casting(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASTING, "<casting>");
    r = casting_0(b, l + 1);
    if (!r) r = casting_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // labelOrVar (':' VARIABLE)?
  private static boolean casting_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labelOrVar(b, l + 1);
    r = r && casting_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' VARIABLE)?
  private static boolean casting_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_0_1")) return false;
    casting_0_1_0(b, l + 1);
    return true;
  }

  // ':' VARIABLE
  private static boolean casting_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  // labelOrVar VARIABLE
  private static boolean casting_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labelOrVar(b, l + 1);
    r = r && consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // cluster_keyword (of_keyword identifier    )?                    (in_keyword inList)? ';' clusterParam*
  public static boolean cluster(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster")) return false;
    if (!nextTokenIs(b, CLUSTER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLUSTER_KEYWORD);
    r = r && cluster_1(b, l + 1);
    r = r && cluster_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && cluster_4(b, l + 1);
    exit_section_(b, m, CLUSTER, r);
    return r;
  }

  // (of_keyword identifier    )?
  private static boolean cluster_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster_1")) return false;
    cluster_1_0(b, l + 1);
    return true;
  }

  // of_keyword identifier
  private static boolean cluster_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF_KEYWORD);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean cluster_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster_2")) return false;
    cluster_2_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean cluster_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // clusterParam*
  private static boolean cluster_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cluster_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!clusterParam(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cluster_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // MEMBERS ';'    // clusterMembers
  //    | SIZE INTEGER ';'
  public static boolean clusterParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clusterParam")) return false;
    if (!nextTokenIs(b, "<cluster param>", MEMBERS, SIZE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLUSTER_PARAM, "<cluster param>");
    r = parseTokens(b, 0, MEMBERS, SEMICOLON);
    if (!r) r = parseTokens(b, 0, SIZE, INTEGER, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // min | max | median | mean | std | sum | count | path | paths | cluster | degrees
  public static boolean computeMethod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computeMethod")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPUTE_METHOD, "<compute method>");
    r = min(b, l + 1);
    if (!r) r = max(b, l + 1);
    if (!r) r = median(b, l + 1);
    if (!r) r = mean(b, l + 1);
    if (!r) r = std(b, l + 1);
    if (!r) r = sum(b, l + 1);
    if (!r) r = count(b, l + 1);
    if (!r) r = path(b, l + 1);
    if (!r) r = paths(b, l + 1);
    if (!r) r = cluster(b, l + 1);
    if (!r) r = degrees(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // compute_keyword computeMethod
  public static boolean computeQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computeQuery")) return false;
    if (!nextTokenIs(b, COMPUTE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPUTE_KEYWORD);
    r = r && computeMethod(b, l + 1);
    exit_section_(b, m, COMPUTE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // count_keyword                                                     (in_keyword inList)? ';'
  public static boolean count(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count")) return false;
    if (!nextTokenIs(b, COUNT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT_KEYWORD);
    r = r && count_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, COUNT, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean count_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_1")) return false;
    count_1_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean count_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // define_keyword varPatterns
  public static boolean defineQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defineQuery")) return false;
    if (!nextTokenIs(b, DEFINE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE_KEYWORD);
    r = r && varPatterns(b, l + 1);
    exit_section_(b, m, DEFINE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // degrees_keyword (of_keyword ofList)?                            (in_keyword inList)? ';'
  public static boolean degrees(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "degrees")) return false;
    if (!nextTokenIs(b, DEGREES_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEGREES_KEYWORD);
    r = r && degrees_1(b, l + 1);
    r = r && degrees_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DEGREES, r);
    return r;
  }

  // (of_keyword ofList)?
  private static boolean degrees_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "degrees_1")) return false;
    degrees_1_0(b, l + 1);
    return true;
  }

  // of_keyword ofList
  private static boolean degrees_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "degrees_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean degrees_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "degrees_2")) return false;
    degrees_2_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean degrees_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "degrees_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // matchPart delete_keyword variables? ';'
  public static boolean deleteQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deleteQuery")) return false;
    if (!nextTokenIs(b, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && consumeToken(b, DELETE_KEYWORD);
    r = r && deleteQuery_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DELETE_QUERY, r);
    return r;
  }

  // variables?
  private static boolean deleteQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deleteQuery_2")) return false;
    variables(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // untypedExpression | DOUBLE
  public static boolean double_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "double_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE_, "<double>");
    r = untypedExpression(b, l + 1);
    if (!r) r = consumeToken(b, DOUBLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // elseif_keyword LPAREN bool RPAREN do_keyword block
  public static boolean elseIfPartial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseIfPartial")) return false;
    if (!nextTokenIs(b, ELSEIF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSEIF_KEYWORD, LPAREN);
    r = r && bool(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, DO_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_IF_PARTIAL, r);
    return r;
  }

  /* ********************************************************** */
  // else_keyword block
  public static boolean elsePartial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elsePartial")) return false;
    if (!nextTokenIs(b, ELSE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_PARTIAL, r);
    return r;
  }

  /* ********************************************************** */
  // untypedExpression
  public static boolean escapedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escapedExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ESCAPED_EXPRESSION, "<escaped expression>");
    r = untypedExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // untypedExpression | nil | STRING_LITERAL | number | (true_keyword|false_keyword)
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = untypedExpression(b, l + 1);
    if (!r) r = nil(b, l + 1);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = number(b, l + 1);
    if (!r) r = expression_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // true_keyword|false_keyword
  private static boolean expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // for_keyword LPAREN escapedExpression RPAREN do_keyword block
  public static boolean forEachStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forEachStatement")) return false;
    if (!nextTokenIs(b, FOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR_KEYWORD, LPAREN);
    r = r && escapedExpression(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, DO_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, FOR_EACH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // for_keyword LPAREN identifier in_keyword escapedExpression RPAREN do_keyword block
  public static boolean forInStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forInStatement")) return false;
    if (!nextTokenIs(b, FOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR_KEYWORD, LPAREN);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, IN_KEYWORD);
    r = r && escapedExpression(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, DO_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, FOR_IN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // matchPart (get_keyword (VARIABLE (',' VARIABLE)*)? ';')?
  public static boolean getQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery")) return false;
    if (!nextTokenIs(b, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && getQuery_1(b, l + 1);
    exit_section_(b, m, GET_QUERY, r);
    return r;
  }

  // (get_keyword (VARIABLE (',' VARIABLE)*)? ';')?
  private static boolean getQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1")) return false;
    getQuery_1_0(b, l + 1);
    return true;
  }

  // get_keyword (VARIABLE (',' VARIABLE)*)? ';'
  private static boolean getQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GET_KEYWORD);
    r = r && getQuery_1_0_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (VARIABLE (',' VARIABLE)*)?
  private static boolean getQuery_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0_1")) return false;
    getQuery_1_0_1_0(b, l + 1);
    return true;
  }

  // VARIABLE (',' VARIABLE)*
  private static boolean getQuery_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    r = r && getQuery_1_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' VARIABLE)*
  private static boolean getQuery_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!getQuery_1_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "getQuery_1_0_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' VARIABLE
  private static boolean getQuery_1_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN bool RPAREN
  public static boolean groupBool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupBool")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && bool(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, GROUP_BOOL, r);
    return r;
  }

  /* ********************************************************** */
  // ID | STRING_LITERAL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, "<identifier>", ID, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if_keyword LPAREN bool RPAREN do_keyword block
  public static boolean ifPartial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifPartial")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LPAREN);
    r = r && bool(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, DO_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, IF_PARTIAL, r);
    return r;
  }

  /* ********************************************************** */
  // ifPartial elseIfPartial* elsePartial?
  public static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifPartial(b, l + 1);
    r = r && ifStatement_1(b, l + 1);
    r = r && ifStatement_2(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // elseIfPartial*
  private static boolean ifStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!elseIfPartial(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifStatement_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // elsePartial?
  private static boolean ifStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_2")) return false;
    elsePartial(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // labelList
  public static boolean inList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IN_LIST, "<in list>");
    r = labelList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // matchPart? insert_keyword varPatterns? (labelOrVar? blockContents?)
  public static boolean insertQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery")) return false;
    if (!nextTokenIs(b, "<insert query>", INSERT_KEYWORD, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSERT_QUERY, "<insert query>");
    r = insertQuery_0(b, l + 1);
    r = r && consumeToken(b, INSERT_KEYWORD);
    r = r && insertQuery_2(b, l + 1);
    r = r && insertQuery_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // matchPart?
  private static boolean insertQuery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_0")) return false;
    matchPart(b, l + 1);
    return true;
  }

  // varPatterns?
  private static boolean insertQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_2")) return false;
    varPatterns(b, l + 1);
    return true;
  }

  // labelOrVar? blockContents?
  private static boolean insertQuery_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = insertQuery_3_0(b, l + 1);
    r = r && insertQuery_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // labelOrVar?
  private static boolean insertQuery_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_3_0")) return false;
    labelOrVar(b, l + 1);
    return true;
  }

  // blockContents?
  private static boolean insertQuery_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_3_1")) return false;
    blockContents(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // untypedExpression | INTEGER
  public static boolean int_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_, "<int>");
    r = untypedExpression(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier | IMPLICIT_IDENTIFIER
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL, "<label>");
    r = identifier(b, l + 1);
    if (!r) r = consumeToken(b, IMPLICIT_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // label (',' label)*
  public static boolean labelList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL_LIST, "<label list>");
    r = label(b, l + 1);
    r = r && labelList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' label)*
  private static boolean labelList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!labelList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "labelList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' label
  private static boolean labelList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // label | VARIABLE
  //     | min_keyword | max_keyword | median_keyword | mean_keyword | std_keyword | sum_keyword | count_keyword
  //     | path_keyword | cluster_keyword | date_keyword | degrees_keyword | member_keyword | size_keyword
  //     | entity_keyword | relationship_keyword | rule_keyword | role_keyword | attribute_keyword
  public static boolean labelOrVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labelOrVar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL_OR_VAR, "<label or var>");
    r = label(b, l + 1);
    if (!r) r = consumeToken(b, VARIABLE);
    if (!r) r = consumeToken(b, MIN_KEYWORD);
    if (!r) r = consumeToken(b, MAX_KEYWORD);
    if (!r) r = consumeToken(b, MEDIAN_KEYWORD);
    if (!r) r = consumeToken(b, MEAN_KEYWORD);
    if (!r) r = consumeToken(b, STD_KEYWORD);
    if (!r) r = consumeToken(b, SUM_KEYWORD);
    if (!r) r = consumeToken(b, COUNT_KEYWORD);
    if (!r) r = consumeToken(b, PATH_KEYWORD);
    if (!r) r = consumeToken(b, CLUSTER_KEYWORD);
    if (!r) r = consumeToken(b, DATE_KEYWORD);
    if (!r) r = consumeToken(b, DEGREES_KEYWORD);
    if (!r) r = consumeToken(b, MEMBER_KEYWORD);
    if (!r) r = consumeToken(b, SIZE_KEYWORD);
    if (!r) r = consumeToken(b, ENTITY_KEYWORD);
    if (!r) r = consumeToken(b, RELATIONSHIP_KEYWORD);
    if (!r) r = consumeToken(b, RULE_KEYWORD);
    if (!r) r = consumeToken(b, ROLE_KEYWORD);
    if (!r) r = consumeToken(b, ATTRIBUTE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // untypedExpression
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST, "<list>");
    r = untypedExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // limit_keyword INTEGER ';'
  public static boolean matchLimit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchLimit")) return false;
    if (!nextTokenIs(b, LIMIT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LIMIT_KEYWORD, INTEGER, SEMICOLON);
    exit_section_(b, m, MATCH_LIMIT, r);
    return r;
  }

  /* ********************************************************** */
  // matchLimit matchOffset?
  public static boolean matchLimitOffset(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchLimitOffset")) return false;
    if (!nextTokenIs(b, LIMIT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchLimit(b, l + 1);
    r = r && matchLimitOffset_1(b, l + 1);
    exit_section_(b, m, MATCH_LIMIT_OFFSET, r);
    return r;
  }

  // matchOffset?
  private static boolean matchLimitOffset_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchLimitOffset_1")) return false;
    matchOffset(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // offset_keyword INTEGER ';'
  public static boolean matchOffset(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOffset")) return false;
    if (!nextTokenIs(b, OFFSET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OFFSET_KEYWORD, INTEGER, SEMICOLON);
    exit_section_(b, m, MATCH_OFFSET, r);
    return r;
  }

  /* ********************************************************** */
  // matchOffset matchLimit?
  public static boolean matchOffsetLimit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOffsetLimit")) return false;
    if (!nextTokenIs(b, OFFSET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchOffset(b, l + 1);
    r = r && matchOffsetLimit_1(b, l + 1);
    exit_section_(b, m, MATCH_OFFSET_LIMIT, r);
    return r;
  }

  // matchLimit?
  private static boolean matchOffsetLimit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOffsetLimit_1")) return false;
    matchLimit(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // order_keyword by_keyword VARIABLE (asc_keyword|desc_keyword)? ';'
  public static boolean matchOrderBy(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOrderBy")) return false;
    if (!nextTokenIs(b, ORDER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ORDER_KEYWORD, BY_KEYWORD, VARIABLE);
    r = r && matchOrderBy_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MATCH_ORDER_BY, r);
    return r;
  }

  // (asc_keyword|desc_keyword)?
  private static boolean matchOrderBy_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOrderBy_3")) return false;
    matchOrderBy_3_0(b, l + 1);
    return true;
  }

  // asc_keyword|desc_keyword
  private static boolean matchOrderBy_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchOrderBy_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASC_KEYWORD);
    if (!r) r = consumeToken(b, DESC_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // match_keyword patterns (matchLimitOffset|matchOffsetLimit)? matchOrderBy? blockContents?
  public static boolean matchPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart")) return false;
    if (!nextTokenIs(b, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH_KEYWORD);
    r = r && patterns(b, l + 1);
    r = r && matchPart_2(b, l + 1);
    r = r && matchPart_3(b, l + 1);
    r = r && matchPart_4(b, l + 1);
    exit_section_(b, m, MATCH_PART, r);
    return r;
  }

  // (matchLimitOffset|matchOffsetLimit)?
  private static boolean matchPart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_2")) return false;
    matchPart_2_0(b, l + 1);
    return true;
  }

  // matchLimitOffset|matchOffsetLimit
  private static boolean matchPart_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchLimitOffset(b, l + 1);
    if (!r) r = matchOffsetLimit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // matchOrderBy?
  private static boolean matchPart_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_3")) return false;
    matchOrderBy(b, l + 1);
    return true;
  }

  // blockContents?
  private static boolean matchPart_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_4")) return false;
    blockContents(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // max_keyword         of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean max(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max")) return false;
    if (!nextTokenIs(b, MAX_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MAX_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && max_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MAX, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean max_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_3")) return false;
    max_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean max_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // mean_keyword       of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean mean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mean")) return false;
    if (!nextTokenIs(b, MEAN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MEAN_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && mean_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MEAN, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean mean_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mean_3")) return false;
    mean_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean mean_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mean_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // median_keyword   of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean median(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "median")) return false;
    if (!nextTokenIs(b, MEDIAN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MEDIAN_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && median_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MEDIAN, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean median_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "median_3")) return false;
    median_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean median_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "median_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // min_keyword         of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean min(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min")) return false;
    if (!nextTokenIs(b, MIN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MIN_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && min_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MIN, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean min_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_3")) return false;
    min_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean min_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // aggregate as_keyword identifier
  public static boolean namedAgg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedAgg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_AGG, "<named agg>");
    r = aggregate(b, l + 1);
    r = r && consumeToken(b, AS_KEYWORD);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // null_keyword
  public static boolean nil(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nil")) return false;
    if (!nextTokenIs(b, NULL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL_KEYWORD);
    exit_section_(b, m, NIL, r);
    return r;
  }

  /* ********************************************************** */
  // not_keyword groupBool
  public static boolean notBool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notBool")) return false;
    if (!nextTokenIs(b, NOT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT_KEYWORD);
    r = r && groupBool(b, l + 1);
    exit_section_(b, m, NOT_BOOL, r);
    return r;
  }

  /* ********************************************************** */
  // untypedExpression | int_ | double_
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = untypedExpression(b, l + 1);
    if (!r) r = int_(b, l + 1);
    if (!r) r = double_(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // labelList
  public static boolean ofList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ofList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OF_LIST, "<of list>");
    r = labelList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // groupBool or_keyword groupBool
  public static boolean orBool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orBool")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = groupBool(b, l + 1);
    r = r && consumeToken(b, OR_KEYWORD);
    r = r && groupBool(b, l + 1);
    exit_section_(b, m, OR_BOOL, r);
    return r;
  }

  /* ********************************************************** */
  // path_keyword       from_keyword identifier to_keyword identifier   (in_keyword inList)? ';'
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    if (!nextTokenIs(b, PATH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PATH_KEYWORD, FROM_KEYWORD);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, TO_KEYWORD);
    r = r && identifier(b, l + 1);
    r = r && path_5(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, PATH, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean path_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_5")) return false;
    path_5_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean path_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paths_keyword     from_keyword identifier to_keyword identifier   (in_keyword inList)? ';'
  public static boolean paths(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paths")) return false;
    if (!nextTokenIs(b, PATHS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PATHS_KEYWORD, FROM_KEYWORD);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, TO_KEYWORD);
    r = r && identifier(b, l + 1);
    r = r && paths_5(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, PATHS, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean paths_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paths_5")) return false;
    paths_5_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean paths_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paths_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (pattern (','|';')?)+
  public static boolean patterns(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patterns")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERNS, "<patterns>");
    r = patterns_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!patterns_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "patterns", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // pattern (','|';')?
  private static boolean patterns_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patterns_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1, -1);
    r = r && patterns_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (','|';')?
  private static boolean patterns_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patterns_0_1")) return false;
    patterns_0_1_0(b, l + 1);
    return true;
  }

  // ','|';'
  private static boolean patterns_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patterns_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQ? value                // predicateEq
  //     | EQ? VARIABLE                     // predicateVariable
  //     | NEQ valueOrVar                   // predicateNeq
  //     | '>' valueOrVar                    // predicateGt
  //     | '>=' valueOrVar                   // predicateGte
  //     | '<' valueOrVar                    // predicateLt
  //     | '<=' valueOrVar                   // predicateLte
  //     | contains_keyword (STRING_LITERAL | VARIABLE)    // predicateContains
  //     | REGEX
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE, "<predicate>");
    r = predicate_0(b, l + 1);
    if (!r) r = predicate_1(b, l + 1);
    if (!r) r = predicate_2(b, l + 1);
    if (!r) r = predicate_3(b, l + 1);
    if (!r) r = predicate_4(b, l + 1);
    if (!r) r = predicate_5(b, l + 1);
    if (!r) r = predicate_6(b, l + 1);
    if (!r) r = predicate_7(b, l + 1);
    if (!r) r = consumeToken(b, REGEX);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EQ? value
  private static boolean predicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate_0_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ?
  private static boolean predicate_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0_0")) return false;
    consumeToken(b, EQ);
    return true;
  }

  // EQ? VARIABLE
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate_1_0(b, l + 1);
    r = r && consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ?
  private static boolean predicate_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1_0")) return false;
    consumeToken(b, EQ);
    return true;
  }

  // NEQ valueOrVar
  private static boolean predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEQ);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>' valueOrVar
  private static boolean predicate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GREATER);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>=' valueOrVar
  private static boolean predicate_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GREATEREQ);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' valueOrVar
  private static boolean predicate_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<=' valueOrVar
  private static boolean predicate_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESSEQ);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // contains_keyword (STRING_LITERAL | VARIABLE)
  private static boolean predicate_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTAINS_KEYWORD);
    r = r && predicate_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_LITERAL | VARIABLE
  private static boolean predicate_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_7_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // isa_keyword labelOrVar             // isa
  //     | isa_keyword escapedExpression           // isa
  //     | sub_keyword labelOrVar                    // sub
  //     | relates_keyword labelOrVar                // relates
  //     | plays_keyword labelOrVar                  // plays
  //     | id_keyword identifier                   // propId
  //     | label_keyword label                     // propLabel
  //     | when_keyword LBRACE patterns RBRACE     // propWhen
  //     | then_keyword LBRACE varPatterns RBRACE  // propThen
  //     | has_keyword label escapedExpression     // propHas
  //     | has_keyword label predicate             // propHas
  //     | has_keyword labelOrVar                    // propResource
  //     | has_keyword property                    // propHasProp?
  //     | key_keyword labelOrVar                    // propKey
  //     | '(' casting (',' casting)* ')'    // propRel
  //     | is_abstract_keyword                     // isAbstract
  //     | datatype_keyword (long_keyword|double_keyword|string_keyword|boolean_keyword|date_keyword)  // propDatatype
  //     | regex_keyword REGEX                     // propRegex
  //     | NEQ labelOrVar                     // propNeq
  //     | ';'
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = property_1(b, l + 1);
    if (!r) r = property_2(b, l + 1);
    if (!r) r = property_3(b, l + 1);
    if (!r) r = property_4(b, l + 1);
    if (!r) r = property_5(b, l + 1);
    if (!r) r = property_6(b, l + 1);
    if (!r) r = property_7(b, l + 1);
    if (!r) r = property_8(b, l + 1);
    if (!r) r = property_9(b, l + 1);
    if (!r) r = property_10(b, l + 1);
    if (!r) r = property_11(b, l + 1);
    if (!r) r = property_12(b, l + 1);
    if (!r) r = property_13(b, l + 1);
    if (!r) r = property_14(b, l + 1);
    if (!r) r = consumeToken(b, IS_ABSTRACT_KEYWORD);
    if (!r) r = property_16(b, l + 1);
    if (!r) r = parseTokens(b, 0, REGEX_KEYWORD, REGEX);
    if (!r) r = property_18(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // isa_keyword labelOrVar
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ISA_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // isa_keyword escapedExpression
  private static boolean property_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ISA_KEYWORD);
    r = r && escapedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sub_keyword labelOrVar
  private static boolean property_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // relates_keyword labelOrVar
  private static boolean property_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RELATES_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // plays_keyword labelOrVar
  private static boolean property_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAYS_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id_keyword identifier
  private static boolean property_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID_KEYWORD);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label_keyword label
  private static boolean property_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LABEL_KEYWORD);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // when_keyword LBRACE patterns RBRACE
  private static boolean property_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHEN_KEYWORD, LBRACE);
    r = r && patterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // then_keyword LBRACE varPatterns RBRACE
  private static boolean property_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, THEN_KEYWORD, LBRACE);
    r = r && varPatterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // has_keyword label escapedExpression
  private static boolean property_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS_KEYWORD);
    r = r && label(b, l + 1);
    r = r && escapedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // has_keyword label predicate
  private static boolean property_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS_KEYWORD);
    r = r && label(b, l + 1);
    r = r && predicate(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // has_keyword labelOrVar
  private static boolean property_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // has_keyword property
  private static boolean property_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS_KEYWORD);
    r = r && property(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // key_keyword labelOrVar
  private static boolean property_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEY_KEYWORD);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' casting (',' casting)* ')'
  private static boolean property_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && casting(b, l + 1);
    r = r && property_14_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' casting)*
  private static boolean property_14_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_14_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!property_14_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "property_14_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' casting
  private static boolean property_14_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_14_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && casting(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // datatype_keyword (long_keyword|double_keyword|string_keyword|boolean_keyword|date_keyword)
  private static boolean property_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATATYPE_KEYWORD);
    r = r && property_16_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // long_keyword|double_keyword|string_keyword|boolean_keyword|date_keyword
  private static boolean property_16_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_16_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LONG_KEYWORD);
    if (!r) r = consumeToken(b, DOUBLE_KEYWORD);
    if (!r) r = consumeToken(b, STRING_KEYWORD);
    if (!r) r = consumeToken(b, BOOLEAN_KEYWORD);
    if (!r) r = consumeToken(b, DATE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEQ labelOrVar
  private static boolean property_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEQ);
    r = r && labelOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (deleteQuery | aggregateQuery | getQuery | insertQuery | defineQuery | undefineQuery | computeQuery | statement) commit_keyword?
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY, "<query>");
    r = query_0(b, l + 1);
    r = r && query_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // deleteQuery | aggregateQuery | getQuery | insertQuery | defineQuery | undefineQuery | computeQuery | statement
  private static boolean query_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deleteQuery(b, l + 1);
    if (!r) r = aggregateQuery(b, l + 1);
    if (!r) r = getQuery(b, l + 1);
    if (!r) r = insertQuery(b, l + 1);
    if (!r) r = defineQuery(b, l + 1);
    if (!r) r = undefineQuery(b, l + 1);
    if (!r) r = computeQuery(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // commit_keyword?
  private static boolean query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_1")) return false;
    consumeToken(b, COMMIT_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // forInStatement
  //     | forEachStatement
  //     | ifStatement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    if (!nextTokenIs(b, "<statement>", FOR_KEYWORD, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = forInStatement(b, l + 1);
    if (!r) r = forEachStatement(b, l + 1);
    if (!r) r = ifStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // std_keyword         of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean std(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std")) return false;
    if (!nextTokenIs(b, STD_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STD_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && std_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, STD, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean std_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_3")) return false;
    std_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean std_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sum_keyword         of_keyword ofList                               (in_keyword inList)? ';'
  public static boolean sum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sum")) return false;
    if (!nextTokenIs(b, SUM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SUM_KEYWORD, OF_KEYWORD);
    r = r && ofList(b, l + 1);
    r = r && sum_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SUM, r);
    return r;
  }

  // (in_keyword inList)?
  private static boolean sum_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sum_3")) return false;
    sum_3_0(b, l + 1);
    return true;
  }

  // in_keyword inList
  private static boolean sum_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sum_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN_KEYWORD);
    r = r && inList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // undefine_keyword varPatterns
  public static boolean undefineQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefineQuery")) return false;
    if (!nextTokenIs(b, UNDEFINE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDEFINE_KEYWORD);
    r = r && varPatterns(b, l + 1);
    exit_section_(b, m, UNDEFINE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // '<' identifier accessor* '>'                      //idExpression
  //     | MACRO_NOESCP
  //     | MACRO_EQUALS
  //     | ID_MACRO LPAREN expression? (',' expression)* RPAREN accessor?    //macroExpression
  //     | identifier
  public static boolean untypedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNTYPED_EXPRESSION, "<untyped expression>");
    r = untypedExpression_0(b, l + 1);
    if (!r) r = MACRO_NOESCP(b, l + 1);
    if (!r) r = MACRO_EQUALS(b, l + 1);
    if (!r) r = untypedExpression_3(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '<' identifier accessor* '>'
  private static boolean untypedExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && identifier(b, l + 1);
    r = r && untypedExpression_0_2(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // accessor*
  private static boolean untypedExpression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!accessor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "untypedExpression_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ID_MACRO LPAREN expression? (',' expression)* RPAREN accessor?
  private static boolean untypedExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ID_MACRO(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && untypedExpression_3_2(b, l + 1);
    r = r && untypedExpression_3_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && untypedExpression_3_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean untypedExpression_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_3_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // (',' expression)*
  private static boolean untypedExpression_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_3_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!untypedExpression_3_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "untypedExpression_3_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean untypedExpression_3_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_3_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // accessor?
  private static boolean untypedExpression_3_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untypedExpression_3_5")) return false;
    accessor(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL   // valueString
  //    | INTEGER  // valueInteger
  //    | REAL     // valueReal
  //    | (true_keyword|false_keyword)  // valueBoolean
  //    | DATE     // valueDate
  //    | DATETIME
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = value_3(b, l + 1);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = consumeToken(b, DATETIME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // true_keyword|false_keyword
  private static boolean value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE // valueVariable
  //     | value
  public static boolean valueOrVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueOrVar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_OR_VAR, "<value or var>");
    r = consumeToken(b, VARIABLE);
    if (!r) r = value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (varPattern ';'?)+
  public static boolean varPatterns(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPatterns")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_PATTERNS, "<var patterns>");
    r = varPatterns_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!varPatterns_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varPatterns", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // varPattern ';'?
  private static boolean varPatterns_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPatterns_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern(b, l + 1);
    r = r && varPatterns_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean varPatterns_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPatterns_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // VARIABLE (',' VARIABLE)*
  public static boolean variables(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    r = r && variables_1(b, l + 1);
    exit_section_(b, m, VARIABLES, r);
    return r;
  }

  // (',' VARIABLE)*
  private static boolean variables_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!variables_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variables_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' VARIABLE
  private static boolean variables_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: pattern
  // Operator priority table:
  // 0: ATOM(varPattern)
  // 1: BINARY(orPattern)
  // 2: ATOM(andPattern)
  public static boolean pattern(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    addVariant(b, "<pattern>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<pattern>");
    r = varPattern(b, l + 1);
    if (!r) r = andPattern(b, l + 1);
    p = r;
    r = r && pattern_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean pattern_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && consumeTokenSmart(b, OR_KEYWORD)) {
        r = pattern(b, l, 1);
        exit_section_(b, l, m, OR_PATTERN, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // labelOrVar? property (','? (property|statement))*
  public static boolean varPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_PATTERN, "<var pattern>");
    r = varPattern_0(b, l + 1);
    r = r && property(b, l + 1);
    r = r && varPattern_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // labelOrVar?
  private static boolean varPattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_0")) return false;
    labelOrVar(b, l + 1);
    return true;
  }

  // (','? (property|statement))*
  private static boolean varPattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!varPattern_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varPattern_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ','? (property|statement)
  private static boolean varPattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern_2_0_0(b, l + 1);
    r = r && varPattern_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean varPattern_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2_0_0")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // property|statement
  private static boolean varPattern_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACE patterns RBRACE
  public static boolean andPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andPattern")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACE);
    r = r && patterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, AND_PATTERN, r);
    return r;
  }

}
