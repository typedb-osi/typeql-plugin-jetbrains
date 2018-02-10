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
    if (t == AGGREGATE) {
      r = aggregate(b, 0);
    }
    else if (t == AGGREGATE_QUERY) {
      r = aggregateQuery(b, 0);
    }
    else if (t == AND_PATTERN) {
      r = andPattern(b, 0);
    }
    else if (t == ARGUMENT) {
      r = argument(b, 0);
    }
    else if (t == CASTING) {
      r = casting(b, 0);
    }
    else if (t == CLUSTER_PARAM) {
      r = clusterParam(b, 0);
    }
    else if (t == DEFINE_QUERY) {
      r = defineQuery(b, 0);
    }
    else if (t == DELETE_QUERY) {
      r = deleteQuery(b, 0);
    }
    else if (t == GET_QUERY) {
      r = getQuery(b, 0);
    }
    else if (t == ID) {
      r = id(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = identifier(b, 0);
    }
    else if (t == IN_LIST) {
      r = inList(b, 0);
    }
    else if (t == INSERT_QUERY) {
      r = insertQuery(b, 0);
    }
    else if (t == LABEL) {
      r = label(b, 0);
    }
    else if (t == LABEL_LIST) {
      r = labelList(b, 0);
    }
    else if (t == MATCH_PART) {
      r = matchPart(b, 0);
    }
    else if (t == NAMED_AGG) {
      r = namedAgg(b, 0);
    }
    else if (t == OF_LIST) {
      r = ofList(b, 0);
    }
    else if (t == OR_PATTERN) {
      r = orPattern(b, 0);
    }
    else if (t == PATTERN) {
      r = pattern(b, 0);
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
    else if (t == UNDEFINE_QUERY) {
      r = undefineQuery(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else if (t == VALUE_OR_VAR) {
      r = valueOrVar(b, 0);
    }
    else if (t == VAR_PATTERN) {
      r = varPattern(b, 0);
    }
    else if (t == VAR_PATTERNS) {
      r = varPatterns(b, 0);
    }
    else if (t == VARIABLE) {
      r = variable(b, 0);
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
  // identifier argument*      // customAgg
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

  // identifier argument*
  private static boolean aggregate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
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
  // matchPart 'aggregate' aggregate ';'
  public static boolean aggregateQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aggregateQuery")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && consumeToken(b, AGGREGATE);
    r = r && aggregate(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, AGGREGATE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // '{' patterns '}'
  public static boolean andPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andPattern")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && patterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, AND_PATTERN, r);
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
  // variable (':' VARIABLE)?
  //     | variable VARIABLE
  public static boolean casting(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASTING, "<casting>");
    r = casting_0(b, l + 1);
    if (!r) r = casting_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variable (':' VARIABLE)?
  private static boolean casting_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
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

  // variable VARIABLE
  private static boolean casting_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casting_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
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
  // DEFINE varPatterns
  public static boolean defineQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defineQuery")) return false;
    if (!nextTokenIs(b, DEFINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE);
    r = r && varPatterns(b, l + 1);
    exit_section_(b, m, DEFINE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // matchPart 'delete' variables? ';'
  public static boolean deleteQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deleteQuery")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && consumeToken(b, DELETE);
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
  // matchPart ('get' (VARIABLE (',' VARIABLE)*)? ';')?
  public static boolean getQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = matchPart(b, l + 1);
    r = r && getQuery_1(b, l + 1);
    exit_section_(b, m, GET_QUERY, r);
    return r;
  }

  // ('get' (VARIABLE (',' VARIABLE)*)? ';')?
  private static boolean getQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1")) return false;
    getQuery_1_0(b, l + 1);
    return true;
  }

  // 'get' (VARIABLE (',' VARIABLE)*)? ';'
  private static boolean getQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getQuery_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GET);
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
  // identifier
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<id>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID | STRING
  //     | MIN | MAX| MEDIAN | MEAN | STD | SUM | COUNT | PATH | CLUSTER
  //     | DEGREES | MEMBERS | SIZE | ENTITY
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MIN);
    if (!r) r = consumeToken(b, MAX);
    if (!r) r = consumeToken(b, MEDIAN);
    if (!r) r = consumeToken(b, MEAN);
    if (!r) r = consumeToken(b, STD);
    if (!r) r = consumeToken(b, SUM);
    if (!r) r = consumeToken(b, COUNT);
    if (!r) r = consumeToken(b, PATH);
    if (!r) r = consumeToken(b, CLUSTER);
    if (!r) r = consumeToken(b, DEGREES);
    if (!r) r = consumeToken(b, MEMBERS);
    if (!r) r = consumeToken(b, SIZE);
    if (!r) r = consumeToken(b, ENTITY);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // matchPart? INSERT varPatterns
  public static boolean insertQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery")) return false;
    if (!nextTokenIs(b, "<insert query>", INSERT, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSERT_QUERY, "<insert query>");
    r = insertQuery_0(b, l + 1);
    r = r && consumeToken(b, INSERT);
    r = r && varPatterns(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // matchPart?
  private static boolean insertQuery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertQuery_0")) return false;
    matchPart(b, l + 1);
    return true;
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
  // MATCH patterns           // matchBase
  //     (limit INTEGER              ';')?    // matchLimit
  //     (offset INTEGER             ';')?    // matchOffset
  //     (order by VARIABLE ORDER_SORT? ';')?
  public static boolean matchPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && patterns(b, l + 1);
    r = r && matchPart_2(b, l + 1);
    r = r && matchPart_3(b, l + 1);
    r = r && matchPart_4(b, l + 1);
    exit_section_(b, m, MATCH_PART, r);
    return r;
  }

  // (limit INTEGER              ';')?
  private static boolean matchPart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_2")) return false;
    matchPart_2_0(b, l + 1);
    return true;
  }

  // limit INTEGER              ';'
  private static boolean matchPart_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LIMIT, INTEGER, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (offset INTEGER             ';')?
  private static boolean matchPart_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_3")) return false;
    matchPart_3_0(b, l + 1);
    return true;
  }

  // offset INTEGER             ';'
  private static boolean matchPart_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OFFSET, INTEGER, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (order by VARIABLE ORDER_SORT? ';')?
  private static boolean matchPart_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_4")) return false;
    matchPart_4_0(b, l + 1);
    return true;
  }

  // order by VARIABLE ORDER_SORT? ';'
  private static boolean matchPart_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ORDER, BY, VARIABLE);
    r = r && matchPart_4_0_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // ORDER_SORT?
  private static boolean matchPart_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchPart_4_0_3")) return false;
    consumeToken(b, ORDER_SORT);
    return true;
  }

  /* ********************************************************** */
  // aggregate 'as' identifier
  public static boolean namedAgg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedAgg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_AGG, "<named agg>");
    r = aggregate(b, l + 1);
    r = r && consumeToken(b, AS);
    r = r && identifier(b, l + 1);
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
  // (varPattern|andPattern) 'or' (varPattern|andPattern)
  public static boolean orPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OR_PATTERN, "<or pattern>");
    r = orPattern_0(b, l + 1);
    r = r && consumeToken(b, OR);
    r = r && orPattern_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // varPattern|andPattern
  private static boolean orPattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orPattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern(b, l + 1);
    if (!r) r = andPattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // varPattern|andPattern
  private static boolean orPattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orPattern_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern(b, l + 1);
    if (!r) r = andPattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // varPattern  // varPatternCase
  //     | orPattern         // orPattern
  //     | andPattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = varPattern(b, l + 1);
    if (!r) r = orPattern(b, l + 1);
    if (!r) r = andPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (pattern ';')+
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

  // pattern ';'
  private static boolean patterns_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patterns_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '='? value                // predicateEq
  //     | '='? VARIABLE                      // predicateVariable
  //     | '!=' valueOrVar                   // predicateNeq
  //     | '>' valueOrVar                    // predicateGt
  //     | '>=' valueOrVar                   // predicateGte
  //     | '<' valueOrVar                    // predicateLt
  //     | '<=' valueOrVar                   // predicateLte
  //     | 'contains' (STRING | VARIABLE)    // predicateContains
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

  // '='? value
  private static boolean predicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate_0_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '='?
  private static boolean predicate_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0_0")) return false;
    consumeToken(b, "=");
    return true;
  }

  // '='? VARIABLE
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate_1_0(b, l + 1);
    r = r && consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  // '='?
  private static boolean predicate_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1_0")) return false;
    consumeToken(b, "=");
    return true;
  }

  // '!=' valueOrVar
  private static boolean predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!=");
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>' valueOrVar
  private static boolean predicate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GTHAN);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>=' valueOrVar
  private static boolean predicate_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GTHANEQ);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' valueOrVar
  private static boolean predicate_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LTHAN);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<=' valueOrVar
  private static boolean predicate_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LTHANEQ);
    r = r && valueOrVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'contains' (STRING | VARIABLE)
  private static boolean predicate_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTAINS);
    r = r && predicate_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING | VARIABLE
  private static boolean predicate_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_7_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, VARIABLE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'isa' variable             // isa
  //     | 'sub' variable                    // sub
  //     | 'relates' variable                // relates
  //     | 'plays' variable                  // plays
  //     | 'id' id                           // propId
  //     | 'label' label                     // propLabel
  //     | 'val' predicate                   // propValue
  //     | 'when' '{' patterns '}'           // propWhen
  //     | 'then' '{' varPatterns '}'        // propThen
  //     | 'has' label predicate             // propHas
  //     | 'has' variable                    // propResource
  //     | 'key' variable                    // propKey
  //     | '(' casting (',' casting)* ')'    // propRel
  //     | 'is-abstract'                     // isAbstract
  //     | 'datatype' DATATYPE               // propDatatype
  //     | 'regex' REGEX                     // propRegex
  //     | '!=' variable
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
    if (!r) r = consumeToken(b, IS_ABSTRACT);
    if (!r) r = parseTokens(b, 0, DATATYPE, DATATYPE);
    if (!r) r = property_15(b, l + 1);
    if (!r) r = property_16(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'isa' variable
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ISA);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'sub' variable
  private static boolean property_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'relates' variable
  private static boolean property_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RELATES);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'plays' variable
  private static boolean property_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAYS);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'id' id
  private static boolean property_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "id");
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'label' label
  private static boolean property_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LABEL);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'val' predicate
  private static boolean property_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAL);
    r = r && predicate(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'when' '{' patterns '}'
  private static boolean property_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHEN, LBRACE);
    r = r && patterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'then' '{' varPatterns '}'
  private static boolean property_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, THEN, LBRACE);
    r = r && varPatterns(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'has' label predicate
  private static boolean property_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS);
    r = r && label(b, l + 1);
    r = r && predicate(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'has' variable
  private static boolean property_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'key' variable
  private static boolean property_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEY);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' casting (',' casting)* ')'
  private static boolean property_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && casting(b, l + 1);
    r = r && property_12_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' casting)*
  private static boolean property_12_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_12_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!property_12_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "property_12_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' casting
  private static boolean property_12_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_12_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && casting(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'regex' REGEX
  private static boolean property_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "regex");
    r = r && consumeToken(b, REGEX);
    exit_section_(b, m, null, r);
    return r;
  }

  // '!=' variable
  private static boolean property_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!=");
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // getQuery | insertQuery | defineQuery | undefineQuery | deleteQuery | aggregateQuery
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY, "<query>");
    r = getQuery(b, l + 1);
    if (!r) r = insertQuery(b, l + 1);
    if (!r) r = defineQuery(b, l + 1);
    if (!r) r = undefineQuery(b, l + 1);
    if (!r) r = deleteQuery(b, l + 1);
    if (!r) r = aggregateQuery(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNDEFINE varPatterns
  public static boolean undefineQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefineQuery")) return false;
    if (!nextTokenIs(b, UNDEFINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDEFINE);
    r = r && varPatterns(b, l + 1);
    exit_section_(b, m, UNDEFINE_QUERY, r);
    return r;
  }

  /* ********************************************************** */
  // STRING   // valueString
  //    | INTEGER  // valueInteger
  //    | REAL     // valueReal
  //    | BOOLEAN  // valueBoolean
  //    | DATE     // valueDate
  //    | DATETIME
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = consumeToken(b, DATETIME);
    exit_section_(b, l, m, r, false, null);
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
  // variable? property (','? property)*
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

  // variable?
  private static boolean varPattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_0")) return false;
    variable(b, l + 1);
    return true;
  }

  // (','? property)*
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

  // ','? property
  private static boolean varPattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern_2_0_0(b, l + 1);
    r = r && property(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean varPattern_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPattern_2_0_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (varPattern ';')+
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

  // varPattern ';'
  private static boolean varPatterns_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varPatterns_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varPattern(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // label | VARIABLE
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = label(b, l + 1);
    if (!r) r = consumeToken(b, VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
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

}
