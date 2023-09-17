// Generated from src/main/antlr/TypeQL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TypeQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, MATCH=6, GET=7, DEFINE=8, UNDEFINE=9, 
		INSERT=10, DELETE=11, COMPUTE=12, THING=13, ENTITY=14, ATTRIBUTE=15, RELATION=16, 
		ROLE=17, RULE=18, OFFSET=19, LIMIT=20, SORT=21, ORDER_=22, ASC=23, DESC=24, 
		TYPE=25, ABSTRACT=26, SUB_=27, SUB=28, SUBX=29, OWNS=30, REGEX=31, AS=32, 
		PLAYS=33, RELATES=34, WHEN=35, THEN=36, ANNOTATION_KEY=37, ANNOTATION_UNIQUE=38, 
		IID=39, ISA_=40, ISA=41, ISAX=42, HAS=43, VALUE=44, IS=45, OR=46, NOT=47, 
		EQ=48, NEQ=49, GT=50, GTE=51, LT=52, LTE=53, LIKE=54, CONTAINS=55, ASSIGN=56, 
		ADD=57, SUBTRACT=58, DIVIDE=59, MULTIPLY=60, POWER=61, MODULO=62, PAREN_OPEN=63, 
		PAREN_CLOSE=64, EXPR_FUNC_NAME=65, GROUP=66, COUNT=67, MAX=68, MIN=69, 
		MEAN=70, MEDIAN=71, STD=72, SUM=73, LONG=74, DOUBLE=75, STRING=76, BOOLEAN=77, 
		DATETIME=78, BOOLEAN_=79, TRUE=80, FALSE=81, STRING_=82, LONG_=83, DOUBLE_=84, 
		DATE_=85, DATETIME_=86, VAR_CONCEPT_=87, VAR_CONCEPT_ANONYMOUS_=88, VAR_CONCEPT_NAMED_=89, 
		VAR_VALUE_=90, IID_=91, LABEL_=92, LABEL_SCOPED_=93, COMMENT=94, WS=95, 
		UNRECOGNISED=96;
	public static final int
		RULE_eof_query = 0, RULE_eof_queries = 1, RULE_eof_pattern = 2, RULE_eof_patterns = 3, 
		RULE_eof_definables = 4, RULE_eof_variable = 5, RULE_eof_label = 6, RULE_eof_schema_rule = 7, 
		RULE_query = 8, RULE_query_define = 9, RULE_query_undefine = 10, RULE_query_insert = 11, 
		RULE_query_update = 12, RULE_query_delete = 13, RULE_query_match = 14, 
		RULE_query_match_aggregate = 15, RULE_query_match_group = 16, RULE_query_match_group_agg = 17, 
		RULE_modifiers = 18, RULE_filter = 19, RULE_sort = 20, RULE_var_order = 21, 
		RULE_offset = 22, RULE_limit = 23, RULE_match_aggregate = 24, RULE_aggregate_method = 25, 
		RULE_match_group = 26, RULE_definables = 27, RULE_definable = 28, RULE_patterns = 29, 
		RULE_pattern = 30, RULE_pattern_conjunction = 31, RULE_pattern_disjunction = 32, 
		RULE_pattern_negation = 33, RULE_pattern_variable = 34, RULE_variable_concept = 35, 
		RULE_variable_type = 36, RULE_type_constraint = 37, RULE_annotations_owns = 38, 
		RULE_variable_value = 39, RULE_variable_things = 40, RULE_variable_thing_any = 41, 
		RULE_variable_thing = 42, RULE_variable_relation = 43, RULE_variable_attribute = 44, 
		RULE_relation = 45, RULE_role_player = 46, RULE_player = 47, RULE_attributes = 48, 
		RULE_attribute = 49, RULE_predicate = 50, RULE_predicate_equality = 51, 
		RULE_predicate_substring = 52, RULE_predicate_value = 53, RULE_expression = 54, 
		RULE_expression_base = 55, RULE_expression_function = 56, RULE_expression_function_name = 57, 
		RULE_expression_arguments = 58, RULE_schema_rule = 59, RULE_type_any = 60, 
		RULE_type_scoped = 61, RULE_type = 62, RULE_label_any = 63, RULE_label_scoped = 64, 
		RULE_label = 65, RULE_type_native = 66, RULE_value_type = 67, RULE_value = 68, 
		RULE_signed_long = 69, RULE_signed_double = 70, RULE_sign = 71, RULE_unreserved = 72;
	private static String[] makeRuleNames() {
		return new String[] {
			"eof_query", "eof_queries", "eof_pattern", "eof_patterns", "eof_definables", 
			"eof_variable", "eof_label", "eof_schema_rule", "query", "query_define", 
			"query_undefine", "query_insert", "query_update", "query_delete", "query_match", 
			"query_match_aggregate", "query_match_group", "query_match_group_agg", 
			"modifiers", "filter", "sort", "var_order", "offset", "limit", "match_aggregate", 
			"aggregate_method", "match_group", "definables", "definable", "patterns", 
			"pattern", "pattern_conjunction", "pattern_disjunction", "pattern_negation", 
			"pattern_variable", "variable_concept", "variable_type", "type_constraint", 
			"annotations_owns", "variable_value", "variable_things", "variable_thing_any", 
			"variable_thing", "variable_relation", "variable_attribute", "relation", 
			"role_player", "player", "attributes", "attribute", "predicate", "predicate_equality", 
			"predicate_substring", "predicate_value", "expression", "expression_base", 
			"expression_function", "expression_function_name", "expression_arguments", 
			"schema_rule", "type_any", "type_scoped", "type", "label_any", "label_scoped", 
			"label", "type_native", "value_type", "value", "signed_long", "signed_double", 
			"sign", "unreserved"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'{'", "'}'", "':'", "'match'", "'get'", "'define'", 
			"'undefine'", "'insert'", "'delete'", "'compute'", "'thing'", "'entity'", 
			"'attribute'", "'relation'", "'role'", "'rule'", "'offset'", "'limit'", 
			"'sort'", null, "'asc'", "'desc'", "'type'", "'abstract'", null, "'sub'", 
			"'sub!'", "'owns'", "'regex'", "'as'", "'plays'", "'relates'", "'when'", 
			"'then'", "'@key'", "'@unique'", "'iid'", null, "'isa'", "'isa!'", "'has'", 
			"'value'", "'is'", "'or'", "'not'", "'=='", "'!='", "'>'", "'>='", "'<'", 
			"'<='", "'like'", "'contains'", "'='", "'+'", "'-'", "'/'", "'*'", "'^'", 
			"'%'", "'('", "')'", null, "'group'", "'count'", "'max'", "'min'", "'mean'", 
			"'median'", "'std'", "'sum'", "'long'", "'double'", "'string'", "'boolean'", 
			"'datetime'", null, "'true'", "'false'", null, null, null, null, null, 
			null, "'$_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "MATCH", "GET", "DEFINE", "UNDEFINE", 
			"INSERT", "DELETE", "COMPUTE", "THING", "ENTITY", "ATTRIBUTE", "RELATION", 
			"ROLE", "RULE", "OFFSET", "LIMIT", "SORT", "ORDER_", "ASC", "DESC", "TYPE", 
			"ABSTRACT", "SUB_", "SUB", "SUBX", "OWNS", "REGEX", "AS", "PLAYS", "RELATES", 
			"WHEN", "THEN", "ANNOTATION_KEY", "ANNOTATION_UNIQUE", "IID", "ISA_", 
			"ISA", "ISAX", "HAS", "VALUE", "IS", "OR", "NOT", "EQ", "NEQ", "GT", 
			"GTE", "LT", "LTE", "LIKE", "CONTAINS", "ASSIGN", "ADD", "SUBTRACT", 
			"DIVIDE", "MULTIPLY", "POWER", "MODULO", "PAREN_OPEN", "PAREN_CLOSE", 
			"EXPR_FUNC_NAME", "GROUP", "COUNT", "MAX", "MIN", "MEAN", "MEDIAN", "STD", 
			"SUM", "LONG", "DOUBLE", "STRING", "BOOLEAN", "DATETIME", "BOOLEAN_", 
			"TRUE", "FALSE", "STRING_", "LONG_", "DOUBLE_", "DATE_", "DATETIME_", 
			"VAR_CONCEPT_", "VAR_CONCEPT_ANONYMOUS_", "VAR_CONCEPT_NAMED_", "VAR_VALUE_", 
			"IID_", "LABEL_", "LABEL_SCOPED_", "COMMENT", "WS", "UNRECOGNISED"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TypeQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TypeQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_queryContext extends ParserRuleContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_query; }
	}

	public final Eof_queryContext eof_query() throws RecognitionException {
		Eof_queryContext _localctx = new Eof_queryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eof_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			query();
			setState(147);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_queriesContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public Eof_queriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_queries; }
	}

	public final Eof_queriesContext eof_queries() throws RecognitionException {
		Eof_queriesContext _localctx = new Eof_queriesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eof_queries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				query();
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1856L) != 0) );
			setState(154);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_patternContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_pattern; }
	}

	public final Eof_patternContext eof_pattern() throws RecognitionException {
		Eof_patternContext _localctx = new Eof_patternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eof_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			pattern();
			setState(157);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_patternsContext extends ParserRuleContext {
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_patternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_patterns; }
	}

	public final Eof_patternsContext eof_patterns() throws RecognitionException {
		Eof_patternsContext _localctx = new Eof_patternsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eof_patterns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			patterns();
			setState(160);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_definablesContext extends ParserRuleContext {
		public DefinablesContext definables() {
			return getRuleContext(DefinablesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_definablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_definables; }
	}

	public final Eof_definablesContext eof_definables() throws RecognitionException {
		Eof_definablesContext _localctx = new Eof_definablesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eof_definables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			definables();
			setState(163);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_variableContext extends ParserRuleContext {
		public Pattern_variableContext pattern_variable() {
			return getRuleContext(Pattern_variableContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_variable; }
	}

	public final Eof_variableContext eof_variable() throws RecognitionException {
		Eof_variableContext _localctx = new Eof_variableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_eof_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			pattern_variable();
			setState(166);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_labelContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_label; }
	}

	public final Eof_labelContext eof_label() throws RecognitionException {
		Eof_labelContext _localctx = new Eof_labelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eof_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			label();
			setState(169);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eof_schema_ruleContext extends ParserRuleContext {
		public Schema_ruleContext schema_rule() {
			return getRuleContext(Schema_ruleContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypeQLParser.EOF, 0); }
		public Eof_schema_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eof_schema_rule; }
	}

	public final Eof_schema_ruleContext eof_schema_rule() throws RecognitionException {
		Eof_schema_ruleContext _localctx = new Eof_schema_ruleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_eof_schema_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			schema_rule();
			setState(172);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends ParserRuleContext {
		public Query_defineContext query_define() {
			return getRuleContext(Query_defineContext.class,0);
		}
		public Query_undefineContext query_undefine() {
			return getRuleContext(Query_undefineContext.class,0);
		}
		public Query_insertContext query_insert() {
			return getRuleContext(Query_insertContext.class,0);
		}
		public Query_updateContext query_update() {
			return getRuleContext(Query_updateContext.class,0);
		}
		public Query_deleteContext query_delete() {
			return getRuleContext(Query_deleteContext.class,0);
		}
		public Query_matchContext query_match() {
			return getRuleContext(Query_matchContext.class,0);
		}
		public Query_match_aggregateContext query_match_aggregate() {
			return getRuleContext(Query_match_aggregateContext.class,0);
		}
		public Query_match_groupContext query_match_group() {
			return getRuleContext(Query_match_groupContext.class,0);
		}
		public Query_match_group_aggContext query_match_group_agg() {
			return getRuleContext(Query_match_group_aggContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_query);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				query_define();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				query_undefine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				query_insert();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				query_update();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				query_delete();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				query_match();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
				query_match_aggregate();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(181);
				query_match_group();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(182);
				query_match_group_agg();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_defineContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(TypeQLParser.DEFINE, 0); }
		public DefinablesContext definables() {
			return getRuleContext(DefinablesContext.class,0);
		}
		public Query_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_define; }
	}

	public final Query_defineContext query_define() throws RecognitionException {
		Query_defineContext _localctx = new Query_defineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_query_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(DEFINE);
			setState(186);
			definables();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_undefineContext extends ParserRuleContext {
		public TerminalNode UNDEFINE() { return getToken(TypeQLParser.UNDEFINE, 0); }
		public DefinablesContext definables() {
			return getRuleContext(DefinablesContext.class,0);
		}
		public Query_undefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_undefine; }
	}

	public final Query_undefineContext query_undefine() throws RecognitionException {
		Query_undefineContext _localctx = new Query_undefineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_query_undefine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(UNDEFINE);
			setState(189);
			definables();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_insertContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(TypeQLParser.MATCH, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(TypeQLParser.INSERT, 0); }
		public Variable_thingsContext variable_things() {
			return getRuleContext(Variable_thingsContext.class,0);
		}
		public Query_insertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_insert; }
	}

	public final Query_insertContext query_insert() throws RecognitionException {
		Query_insertContext _localctx = new Query_insertContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_query_insert);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(MATCH);
				setState(192);
				patterns();
				setState(193);
				match(INSERT);
				setState(194);
				variable_things();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(INSERT);
				setState(197);
				variable_things();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_updateContext extends ParserRuleContext {
		public Query_deleteContext query_delete() {
			return getRuleContext(Query_deleteContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(TypeQLParser.INSERT, 0); }
		public Variable_thingsContext variable_things() {
			return getRuleContext(Variable_thingsContext.class,0);
		}
		public Query_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_update; }
	}

	public final Query_updateContext query_update() throws RecognitionException {
		Query_updateContext _localctx = new Query_updateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_query_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			query_delete();
			setState(201);
			match(INSERT);
			setState(202);
			variable_things();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_deleteContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(TypeQLParser.MATCH, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(TypeQLParser.DELETE, 0); }
		public Variable_thingsContext variable_things() {
			return getRuleContext(Variable_thingsContext.class,0);
		}
		public Query_deleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_delete; }
	}

	public final Query_deleteContext query_delete() throws RecognitionException {
		Query_deleteContext _localctx = new Query_deleteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_query_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(MATCH);
			setState(205);
			patterns();
			setState(206);
			match(DELETE);
			setState(207);
			variable_things();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_matchContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(TypeQLParser.MATCH, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public Query_matchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_match; }
	}

	public final Query_matchContext query_match() throws RecognitionException {
		Query_matchContext _localctx = new Query_matchContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_query_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(MATCH);
			setState(210);
			patterns();
			{
			setState(211);
			modifiers();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_match_aggregateContext extends ParserRuleContext {
		public Query_matchContext query_match() {
			return getRuleContext(Query_matchContext.class,0);
		}
		public Match_aggregateContext match_aggregate() {
			return getRuleContext(Match_aggregateContext.class,0);
		}
		public Query_match_aggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_match_aggregate; }
	}

	public final Query_match_aggregateContext query_match_aggregate() throws RecognitionException {
		Query_match_aggregateContext _localctx = new Query_match_aggregateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_query_match_aggregate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			query_match();
			setState(214);
			match_aggregate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_match_groupContext extends ParserRuleContext {
		public Query_matchContext query_match() {
			return getRuleContext(Query_matchContext.class,0);
		}
		public Match_groupContext match_group() {
			return getRuleContext(Match_groupContext.class,0);
		}
		public Query_match_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_match_group; }
	}

	public final Query_match_groupContext query_match_group() throws RecognitionException {
		Query_match_groupContext _localctx = new Query_match_groupContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_query_match_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			query_match();
			setState(217);
			match_group();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_match_group_aggContext extends ParserRuleContext {
		public Query_matchContext query_match() {
			return getRuleContext(Query_matchContext.class,0);
		}
		public Match_groupContext match_group() {
			return getRuleContext(Match_groupContext.class,0);
		}
		public Match_aggregateContext match_aggregate() {
			return getRuleContext(Match_aggregateContext.class,0);
		}
		public Query_match_group_aggContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_match_group_agg; }
	}

	public final Query_match_group_aggContext query_match_group_agg() throws RecognitionException {
		Query_match_group_aggContext _localctx = new Query_match_group_aggContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_query_match_group_agg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			query_match();
			setState(220);
			match_group();
			setState(221);
			match_aggregate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifiersContext extends ParserRuleContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public SortContext sort() {
			return getRuleContext(SortContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GET) {
				{
				setState(223);
				filter();
				setState(224);
				match(T__0);
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(228);
				sort();
				setState(229);
				match(T__0);
				}
			}

			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OFFSET) {
				{
				setState(233);
				offset();
				setState(234);
				match(T__0);
				}
			}

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(238);
				limit();
				setState(239);
				match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(TypeQLParser.GET, 0); }
		public List<TerminalNode> VAR_CONCEPT_() { return getTokens(TypeQLParser.VAR_CONCEPT_); }
		public TerminalNode VAR_CONCEPT_(int i) {
			return getToken(TypeQLParser.VAR_CONCEPT_, i);
		}
		public List<TerminalNode> VAR_VALUE_() { return getTokens(TypeQLParser.VAR_VALUE_); }
		public TerminalNode VAR_VALUE_(int i) {
			return getToken(TypeQLParser.VAR_VALUE_, i);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(GET);
			setState(244);
			_la = _input.LA(1);
			if ( !(_la==VAR_CONCEPT_ || _la==VAR_VALUE_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(245);
				match(T__1);
				setState(246);
				_la = _input.LA(1);
				if ( !(_la==VAR_CONCEPT_ || _la==VAR_VALUE_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SortContext extends ParserRuleContext {
		public TerminalNode SORT() { return getToken(TypeQLParser.SORT, 0); }
		public List<Var_orderContext> var_order() {
			return getRuleContexts(Var_orderContext.class);
		}
		public Var_orderContext var_order(int i) {
			return getRuleContext(Var_orderContext.class,i);
		}
		public SortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort; }
	}

	public final SortContext sort() throws RecognitionException {
		SortContext _localctx = new SortContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sort);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(SORT);
			setState(253);
			var_order();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(254);
				match(T__1);
				setState(255);
				var_order();
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_orderContext extends ParserRuleContext {
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public TerminalNode ORDER_() { return getToken(TypeQLParser.ORDER_, 0); }
		public Var_orderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_order; }
	}

	public final Var_orderContext var_order() throws RecognitionException {
		Var_orderContext _localctx = new Var_orderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==VAR_CONCEPT_ || _la==VAR_VALUE_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(262);
				match(ORDER_);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OffsetContext extends ParserRuleContext {
		public TerminalNode OFFSET() { return getToken(TypeQLParser.OFFSET, 0); }
		public TerminalNode LONG_() { return getToken(TypeQLParser.LONG_, 0); }
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(OFFSET);
			setState(266);
			match(LONG_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LimitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(TypeQLParser.LIMIT, 0); }
		public TerminalNode LONG_() { return getToken(TypeQLParser.LONG_, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(LIMIT);
			setState(269);
			match(LONG_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Match_aggregateContext extends ParserRuleContext {
		public Aggregate_methodContext aggregate_method() {
			return getRuleContext(Aggregate_methodContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public Match_aggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_aggregate; }
	}

	public final Match_aggregateContext match_aggregate() throws RecognitionException {
		Match_aggregateContext _localctx = new Match_aggregateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_match_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			aggregate_method();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR_CONCEPT_ || _la==VAR_VALUE_) {
				{
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==VAR_CONCEPT_ || _la==VAR_VALUE_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(275);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Aggregate_methodContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(TypeQLParser.COUNT, 0); }
		public TerminalNode MAX() { return getToken(TypeQLParser.MAX, 0); }
		public TerminalNode MEAN() { return getToken(TypeQLParser.MEAN, 0); }
		public TerminalNode MEDIAN() { return getToken(TypeQLParser.MEDIAN, 0); }
		public TerminalNode MIN() { return getToken(TypeQLParser.MIN, 0); }
		public TerminalNode STD() { return getToken(TypeQLParser.STD, 0); }
		public TerminalNode SUM() { return getToken(TypeQLParser.SUM, 0); }
		public Aggregate_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_method; }
	}

	public final Aggregate_methodContext aggregate_method() throws RecognitionException {
		Aggregate_methodContext _localctx = new Aggregate_methodContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_aggregate_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Match_groupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(TypeQLParser.GROUP, 0); }
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public Match_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_group; }
	}

	public final Match_groupContext match_group() throws RecognitionException {
		Match_groupContext _localctx = new Match_groupContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_match_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(GROUP);
			setState(280);
			_la = _input.LA(1);
			if ( !(_la==VAR_CONCEPT_ || _la==VAR_VALUE_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(281);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinablesContext extends ParserRuleContext {
		public List<DefinableContext> definable() {
			return getRuleContexts(DefinableContext.class);
		}
		public DefinableContext definable(int i) {
			return getRuleContext(DefinableContext.class,i);
		}
		public DefinablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definables; }
	}

	public final DefinablesContext definables() throws RecognitionException {
		DefinablesContext _localctx = new DefinablesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_definables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(283);
				definable();
				setState(284);
				match(T__0);
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36046389209194624L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 406847999L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinableContext extends ParserRuleContext {
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public Schema_ruleContext schema_rule() {
			return getRuleContext(Schema_ruleContext.class,0);
		}
		public DefinableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definable; }
	}

	public final DefinableContext definable() throws RecognitionException {
		DefinableContext _localctx = new DefinableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_definable);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				variable_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				schema_rule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternsContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(294);
					pattern();
					setState(295);
					match(T__0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(299); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public Pattern_variableContext pattern_variable() {
			return getRuleContext(Pattern_variableContext.class,0);
		}
		public Pattern_conjunctionContext pattern_conjunction() {
			return getRuleContext(Pattern_conjunctionContext.class,0);
		}
		public Pattern_disjunctionContext pattern_disjunction() {
			return getRuleContext(Pattern_disjunctionContext.class,0);
		}
		public Pattern_negationContext pattern_negation() {
			return getRuleContext(Pattern_negationContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pattern);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				pattern_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				pattern_conjunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				pattern_disjunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				pattern_negation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_conjunctionContext extends ParserRuleContext {
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public Pattern_conjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_conjunction; }
	}

	public final Pattern_conjunctionContext pattern_conjunction() throws RecognitionException {
		Pattern_conjunctionContext _localctx = new Pattern_conjunctionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pattern_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(T__2);
			setState(308);
			patterns();
			setState(309);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_disjunctionContext extends ParserRuleContext {
		public List<PatternsContext> patterns() {
			return getRuleContexts(PatternsContext.class);
		}
		public PatternsContext patterns(int i) {
			return getRuleContext(PatternsContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TypeQLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TypeQLParser.OR, i);
		}
		public Pattern_disjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_disjunction; }
	}

	public final Pattern_disjunctionContext pattern_disjunction() throws RecognitionException {
		Pattern_disjunctionContext _localctx = new Pattern_disjunctionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pattern_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(T__2);
			setState(312);
			patterns();
			setState(313);
			match(T__3);
			setState(319); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(314);
				match(OR);
				setState(315);
				match(T__2);
				setState(316);
				patterns();
				setState(317);
				match(T__3);
				}
				}
				setState(321); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_negationContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(TypeQLParser.NOT, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public Pattern_negationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_negation; }
	}

	public final Pattern_negationContext pattern_negation() throws RecognitionException {
		Pattern_negationContext _localctx = new Pattern_negationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pattern_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(NOT);
			setState(324);
			match(T__2);
			setState(325);
			patterns();
			setState(326);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_variableContext extends ParserRuleContext {
		public Variable_conceptContext variable_concept() {
			return getRuleContext(Variable_conceptContext.class,0);
		}
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public Variable_thing_anyContext variable_thing_any() {
			return getRuleContext(Variable_thing_anyContext.class,0);
		}
		public Variable_valueContext variable_value() {
			return getRuleContext(Variable_valueContext.class,0);
		}
		public Pattern_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_variable; }
	}

	public final Pattern_variableContext pattern_variable() throws RecognitionException {
		Pattern_variableContext _localctx = new Pattern_variableContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_pattern_variable);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				variable_concept();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				variable_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				variable_thing_any();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				variable_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_conceptContext extends ParserRuleContext {
		public List<TerminalNode> VAR_CONCEPT_() { return getTokens(TypeQLParser.VAR_CONCEPT_); }
		public TerminalNode VAR_CONCEPT_(int i) {
			return getToken(TypeQLParser.VAR_CONCEPT_, i);
		}
		public TerminalNode IS() { return getToken(TypeQLParser.IS, 0); }
		public Variable_conceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_concept; }
	}

	public final Variable_conceptContext variable_concept() throws RecognitionException {
		Variable_conceptContext _localctx = new Variable_conceptContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_variable_concept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(VAR_CONCEPT_);
			setState(335);
			match(IS);
			setState(336);
			match(VAR_CONCEPT_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_typeContext extends ParserRuleContext {
		public Type_anyContext type_any() {
			return getRuleContext(Type_anyContext.class,0);
		}
		public List<Type_constraintContext> type_constraint() {
			return getRuleContexts(Type_constraintContext.class);
		}
		public Type_constraintContext type_constraint(int i) {
			return getRuleContext(Type_constraintContext.class,i);
		}
		public Variable_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_type; }
	}

	public final Variable_typeContext variable_type() throws RecognitionException {
		Variable_typeContext _localctx = new Variable_typeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variable_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			type_any();
			setState(339);
			type_constraint();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(340);
				match(T__1);
				setState(341);
				type_constraint();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_constraintContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(TypeQLParser.ABSTRACT, 0); }
		public TerminalNode SUB_() { return getToken(TypeQLParser.SUB_, 0); }
		public Type_anyContext type_any() {
			return getRuleContext(Type_anyContext.class,0);
		}
		public TerminalNode OWNS() { return getToken(TypeQLParser.OWNS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Annotations_ownsContext annotations_owns() {
			return getRuleContext(Annotations_ownsContext.class,0);
		}
		public TerminalNode AS() { return getToken(TypeQLParser.AS, 0); }
		public TerminalNode RELATES() { return getToken(TypeQLParser.RELATES, 0); }
		public TerminalNode PLAYS() { return getToken(TypeQLParser.PLAYS, 0); }
		public Type_scopedContext type_scoped() {
			return getRuleContext(Type_scopedContext.class,0);
		}
		public TerminalNode VALUE() { return getToken(TypeQLParser.VALUE, 0); }
		public Value_typeContext value_type() {
			return getRuleContext(Value_typeContext.class,0);
		}
		public TerminalNode REGEX() { return getToken(TypeQLParser.REGEX, 0); }
		public TerminalNode STRING_() { return getToken(TypeQLParser.STRING_, 0); }
		public TerminalNode TYPE() { return getToken(TypeQLParser.TYPE, 0); }
		public Label_anyContext label_any() {
			return getRuleContext(Label_anyContext.class,0);
		}
		public Type_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_constraint; }
	}

	public final Type_constraintContext type_constraint() throws RecognitionException {
		Type_constraintContext _localctx = new Type_constraintContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_type_constraint);
		int _la;
		try {
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(ABSTRACT);
				}
				break;
			case SUB_:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				match(SUB_);
				setState(349);
				type_any();
				}
				break;
			case OWNS:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(OWNS);
				setState(351);
				type();
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(352);
					match(AS);
					setState(353);
					type();
					}
				}

				setState(356);
				annotations_owns();
				}
				break;
			case RELATES:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				match(RELATES);
				setState(359);
				type();
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(360);
					match(AS);
					setState(361);
					type();
					}
				}

				}
				break;
			case PLAYS:
				enterOuterAlt(_localctx, 5);
				{
				setState(364);
				match(PLAYS);
				setState(365);
				type_scoped();
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(366);
					match(AS);
					setState(367);
					type();
					}
				}

				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(370);
				match(VALUE);
				setState(371);
				value_type();
				}
				break;
			case REGEX:
				enterOuterAlt(_localctx, 7);
				{
				setState(372);
				match(REGEX);
				setState(373);
				match(STRING_);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 8);
				{
				setState(374);
				match(TYPE);
				setState(375);
				label_any();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Annotations_ownsContext extends ParserRuleContext {
		public TerminalNode ANNOTATION_KEY() { return getToken(TypeQLParser.ANNOTATION_KEY, 0); }
		public TerminalNode ANNOTATION_UNIQUE() { return getToken(TypeQLParser.ANNOTATION_UNIQUE, 0); }
		public Annotations_ownsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotations_owns; }
	}

	public final Annotations_ownsContext annotations_owns() throws RecognitionException {
		Annotations_ownsContext _localctx = new Annotations_ownsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_annotations_owns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ANNOTATION_KEY) {
				{
				setState(378);
				match(ANNOTATION_KEY);
				}
			}

			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ANNOTATION_UNIQUE) {
				{
				setState(381);
				match(ANNOTATION_UNIQUE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_valueContext extends ParserRuleContext {
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public TerminalNode ASSIGN() { return getToken(TypeQLParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Variable_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_value; }
	}

	public final Variable_valueContext variable_value() throws RecognitionException {
		Variable_valueContext _localctx = new Variable_valueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variable_value);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				match(VAR_VALUE_);
				setState(385);
				match(ASSIGN);
				setState(386);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(VAR_VALUE_);
				setState(388);
				predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_thingsContext extends ParserRuleContext {
		public List<Variable_thing_anyContext> variable_thing_any() {
			return getRuleContexts(Variable_thing_anyContext.class);
		}
		public Variable_thing_anyContext variable_thing_any(int i) {
			return getRuleContext(Variable_thing_anyContext.class,i);
		}
		public Variable_thingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_things; }
	}

	public final Variable_thingsContext variable_things() throws RecognitionException {
		Variable_thingsContext _localctx = new Variable_thingsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_variable_things);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(391);
				variable_thing_any();
				setState(392);
				match(T__0);
				}
				}
				setState(396); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & 1084479277055L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_thing_anyContext extends ParserRuleContext {
		public Variable_thingContext variable_thing() {
			return getRuleContext(Variable_thingContext.class,0);
		}
		public Variable_relationContext variable_relation() {
			return getRuleContext(Variable_relationContext.class,0);
		}
		public Variable_attributeContext variable_attribute() {
			return getRuleContext(Variable_attributeContext.class,0);
		}
		public Variable_thing_anyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_thing_any; }
	}

	public final Variable_thing_anyContext variable_thing_any() throws RecognitionException {
		Variable_thing_anyContext _localctx = new Variable_thing_anyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variable_thing_any);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				variable_thing();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				variable_relation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				variable_attribute();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_thingContext extends ParserRuleContext {
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode ISA_() { return getToken(TypeQLParser.ISA_, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode IID() { return getToken(TypeQLParser.IID, 0); }
		public TerminalNode IID_() { return getToken(TypeQLParser.IID_, 0); }
		public Variable_thingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_thing; }
	}

	public final Variable_thingContext variable_thing() throws RecognitionException {
		Variable_thingContext _localctx = new Variable_thingContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variable_thing);
		int _la;
		try {
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(VAR_CONCEPT_);
				setState(404);
				match(ISA_);
				setState(405);
				type();
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(406);
					match(T__1);
					setState(407);
					attributes();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(VAR_CONCEPT_);
				setState(411);
				match(IID);
				setState(412);
				match(IID_);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(413);
					match(T__1);
					setState(414);
					attributes();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(417);
				match(VAR_CONCEPT_);
				setState(418);
				attributes();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_relationContext extends ParserRuleContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode ISA_() { return getToken(TypeQLParser.ISA_, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public Variable_relationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_relation; }
	}

	public final Variable_relationContext variable_relation() throws RecognitionException {
		Variable_relationContext _localctx = new Variable_relationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variable_relation);
		int _la;
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR_CONCEPT_) {
					{
					setState(421);
					match(VAR_CONCEPT_);
					}
				}

				setState(424);
				relation();
				setState(425);
				match(ISA_);
				setState(426);
				type();
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(427);
					match(T__1);
					setState(428);
					attributes();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR_CONCEPT_) {
					{
					setState(431);
					match(VAR_CONCEPT_);
					}
				}

				setState(434);
				relation();
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HAS) {
					{
					setState(435);
					attributes();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_attributeContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode ISA_() { return getToken(TypeQLParser.ISA_, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public Variable_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_attribute; }
	}

	public final Variable_attributeContext variable_attribute() throws RecognitionException {
		Variable_attributeContext _localctx = new Variable_attributeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_variable_attribute);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR_CONCEPT_) {
					{
					setState(440);
					match(VAR_CONCEPT_);
					}
				}

				setState(443);
				predicate();
				setState(444);
				match(ISA_);
				setState(445);
				type();
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(446);
					match(T__1);
					setState(447);
					attributes();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR_CONCEPT_) {
					{
					setState(450);
					match(VAR_CONCEPT_);
					}
				}

				setState(453);
				predicate();
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HAS) {
					{
					setState(454);
					attributes();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationContext extends ParserRuleContext {
		public TerminalNode PAREN_OPEN() { return getToken(TypeQLParser.PAREN_OPEN, 0); }
		public List<Role_playerContext> role_player() {
			return getRuleContexts(Role_playerContext.class);
		}
		public Role_playerContext role_player(int i) {
			return getRuleContext(Role_playerContext.class,i);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(TypeQLParser.PAREN_CLOSE, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(PAREN_OPEN);
			setState(460);
			role_player();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(461);
				match(T__1);
				setState(462);
				role_player();
				}
				}
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(468);
			match(PAREN_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Role_playerContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PlayerContext player() {
			return getRuleContext(PlayerContext.class,0);
		}
		public Role_playerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_player; }
	}

	public final Role_playerContext role_player() throws RecognitionException {
		Role_playerContext _localctx = new Role_playerContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_role_player);
		try {
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				type();
				setState(471);
				match(T__4);
				setState(472);
				player();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				player();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlayerContext extends ParserRuleContext {
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public PlayerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_player; }
	}

	public final PlayerContext player() throws RecognitionException {
		PlayerContext _localctx = new PlayerContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_player);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(VAR_CONCEPT_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributesContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			attribute();
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(480);
				match(T__1);
				setState(481);
				attribute();
				}
				}
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode HAS() { return getToken(TypeQLParser.HAS, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_attribute);
		try {
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				match(HAS);
				setState(488);
				label();
				setState(492);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR_CONCEPT_:
					{
					setState(489);
					match(VAR_CONCEPT_);
					}
					break;
				case VAR_VALUE_:
					{
					setState(490);
					match(VAR_VALUE_);
					}
					break;
				case EQ:
				case NEQ:
				case GT:
				case GTE:
				case LT:
				case LTE:
				case LIKE:
				case CONTAINS:
				case ASSIGN:
				case ADD:
				case SUBTRACT:
				case BOOLEAN_:
				case STRING_:
				case LONG_:
				case DOUBLE_:
				case DATE_:
				case DATETIME_:
					{
					setState(491);
					predicate();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				match(HAS);
				setState(495);
				match(VAR_CONCEPT_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Predicate_equalityContext predicate_equality() {
			return getRuleContext(Predicate_equalityContext.class,0);
		}
		public Predicate_valueContext predicate_value() {
			return getRuleContext(Predicate_valueContext.class,0);
		}
		public Predicate_substringContext predicate_substring() {
			return getRuleContext(Predicate_substringContext.class,0);
		}
		public TerminalNode STRING_() { return getToken(TypeQLParser.STRING_, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_predicate);
		try {
			setState(505);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUBTRACT:
			case BOOLEAN_:
			case STRING_:
			case LONG_:
			case DOUBLE_:
			case DATE_:
			case DATETIME_:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				value();
				}
				break;
			case EQ:
			case NEQ:
			case GT:
			case GTE:
			case LT:
			case LTE:
			case ASSIGN:
				enterOuterAlt(_localctx, 2);
				{
				setState(499);
				predicate_equality();
				setState(500);
				predicate_value();
				}
				break;
			case LIKE:
			case CONTAINS:
				enterOuterAlt(_localctx, 3);
				{
				setState(502);
				predicate_substring();
				setState(503);
				match(STRING_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Predicate_equalityContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(TypeQLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TypeQLParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(TypeQLParser.GT, 0); }
		public TerminalNode GTE() { return getToken(TypeQLParser.GTE, 0); }
		public TerminalNode LT() { return getToken(TypeQLParser.LT, 0); }
		public TerminalNode LTE() { return getToken(TypeQLParser.LTE, 0); }
		public TerminalNode ASSIGN() { return getToken(TypeQLParser.ASSIGN, 0); }
		public Predicate_equalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_equality; }
	}

	public final Predicate_equalityContext predicate_equality() throws RecognitionException {
		Predicate_equalityContext _localctx = new Predicate_equalityContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_predicate_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 89790517570699264L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Predicate_substringContext extends ParserRuleContext {
		public TerminalNode CONTAINS() { return getToken(TypeQLParser.CONTAINS, 0); }
		public TerminalNode LIKE() { return getToken(TypeQLParser.LIKE, 0); }
		public Predicate_substringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_substring; }
	}

	public final Predicate_substringContext predicate_substring() throws RecognitionException {
		Predicate_substringContext _localctx = new Predicate_substringContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_predicate_substring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_la = _input.LA(1);
			if ( !(_la==LIKE || _la==CONTAINS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Predicate_valueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public Predicate_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_value; }
	}

	public final Predicate_valueContext predicate_value() throws RecognitionException {
		Predicate_valueContext _localctx = new Predicate_valueContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_predicate_value);
		try {
			setState(514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUBTRACT:
			case BOOLEAN_:
			case STRING_:
			case LONG_:
			case DOUBLE_:
			case DATE_:
			case DATETIME_:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				value();
				}
				break;
			case VAR_CONCEPT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				match(VAR_CONCEPT_);
				}
				break;
			case VAR_VALUE_:
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				match(VAR_VALUE_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression_baseContext expression_base() {
			return getRuleContext(Expression_baseContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode POWER() { return getToken(TypeQLParser.POWER, 0); }
		public TerminalNode MULTIPLY() { return getToken(TypeQLParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(TypeQLParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(TypeQLParser.MODULO, 0); }
		public TerminalNode ADD() { return getToken(TypeQLParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(TypeQLParser.SUBTRACT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 108;
		enterRecursionRule(_localctx, 108, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(517);
			expression_base();
			}
			_ctx.stop = _input.LT(-1);
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(528);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(519);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(520);
						match(POWER);
						setState(521);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(522);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(523);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6341068275337658368L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(524);
						expression(4);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(525);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(526);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(527);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_baseContext extends ParserRuleContext {
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TerminalNode VAR_VALUE_() { return getToken(TypeQLParser.VAR_VALUE_, 0); }
		public Expression_functionContext expression_function() {
			return getRuleContext(Expression_functionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode PAREN_OPEN() { return getToken(TypeQLParser.PAREN_OPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(TypeQLParser.PAREN_CLOSE, 0); }
		public Expression_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_base; }
	}

	public final Expression_baseContext expression_base() throws RecognitionException {
		Expression_baseContext _localctx = new Expression_baseContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_expression_base);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_CONCEPT_:
				enterOuterAlt(_localctx, 1);
				{
				setState(533);
				match(VAR_CONCEPT_);
				}
				break;
			case VAR_VALUE_:
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				match(VAR_VALUE_);
				}
				break;
			case EXPR_FUNC_NAME:
			case MAX:
			case MIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(535);
				expression_function();
				}
				break;
			case ADD:
			case SUBTRACT:
			case BOOLEAN_:
			case STRING_:
			case LONG_:
			case DOUBLE_:
			case DATE_:
			case DATETIME_:
				enterOuterAlt(_localctx, 4);
				{
				setState(536);
				value();
				}
				break;
			case PAREN_OPEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(537);
				match(PAREN_OPEN);
				setState(538);
				expression(0);
				setState(539);
				match(PAREN_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_functionContext extends ParserRuleContext {
		public Expression_function_nameContext expression_function_name() {
			return getRuleContext(Expression_function_nameContext.class,0);
		}
		public TerminalNode PAREN_OPEN() { return getToken(TypeQLParser.PAREN_OPEN, 0); }
		public TerminalNode PAREN_CLOSE() { return getToken(TypeQLParser.PAREN_CLOSE, 0); }
		public Expression_argumentsContext expression_arguments() {
			return getRuleContext(Expression_argumentsContext.class,0);
		}
		public Expression_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_function; }
	}

	public final Expression_functionContext expression_function() throws RecognitionException {
		Expression_functionContext _localctx = new Expression_functionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_expression_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			expression_function_name();
			setState(544);
			match(PAREN_OPEN);
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 10708064579L) != 0)) {
				{
				setState(545);
				expression_arguments();
				}
			}

			setState(548);
			match(PAREN_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_function_nameContext extends ParserRuleContext {
		public TerminalNode EXPR_FUNC_NAME() { return getToken(TypeQLParser.EXPR_FUNC_NAME, 0); }
		public TerminalNode MAX() { return getToken(TypeQLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(TypeQLParser.MIN, 0); }
		public Expression_function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_function_name; }
	}

	public final Expression_function_nameContext expression_function_name() throws RecognitionException {
		Expression_function_nameContext _localctx = new Expression_function_nameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_expression_function_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 25L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_argumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_arguments; }
	}

	public final Expression_argumentsContext expression_arguments() throws RecognitionException {
		Expression_argumentsContext _localctx = new Expression_argumentsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_expression_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			expression(0);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(553);
				match(T__1);
				setState(554);
				expression(0);
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Schema_ruleContext extends ParserRuleContext {
		public TerminalNode RULE() { return getToken(TypeQLParser.RULE, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(TypeQLParser.WHEN, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TypeQLParser.THEN, 0); }
		public Variable_thing_anyContext variable_thing_any() {
			return getRuleContext(Variable_thing_anyContext.class,0);
		}
		public Schema_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_rule; }
	}

	public final Schema_ruleContext schema_rule() throws RecognitionException {
		Schema_ruleContext _localctx = new Schema_ruleContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_schema_rule);
		try {
			setState(575);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(560);
				match(RULE);
				setState(561);
				label();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(562);
				match(RULE);
				setState(563);
				label();
				setState(564);
				match(T__4);
				setState(565);
				match(WHEN);
				setState(566);
				match(T__2);
				setState(567);
				patterns();
				setState(568);
				match(T__3);
				setState(569);
				match(THEN);
				setState(570);
				match(T__2);
				setState(571);
				variable_thing_any();
				setState(572);
				match(T__0);
				setState(573);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_anyContext extends ParserRuleContext {
		public Type_scopedContext type_scoped() {
			return getRuleContext(Type_scopedContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public Type_anyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_any; }
	}

	public final Type_anyContext type_any() throws RecognitionException {
		Type_anyContext _localctx = new Type_anyContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_type_any);
		try {
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				type_scoped();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				match(VAR_CONCEPT_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_scopedContext extends ParserRuleContext {
		public Label_scopedContext label_scoped() {
			return getRuleContext(Label_scopedContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public Type_scopedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_scoped; }
	}

	public final Type_scopedContext type_scoped() throws RecognitionException {
		Type_scopedContext _localctx = new Type_scopedContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_type_scoped);
		try {
			setState(584);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LABEL_SCOPED_:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				label_scoped();
				}
				break;
			case VAR_CONCEPT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				match(VAR_CONCEPT_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode VAR_CONCEPT_() { return getToken(TypeQLParser.VAR_CONCEPT_, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_type);
		try {
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GET:
			case THING:
			case ENTITY:
			case ATTRIBUTE:
			case RELATION:
			case ROLE:
			case RULE:
			case OFFSET:
			case LIMIT:
			case SORT:
			case VALUE:
			case CONTAINS:
			case EXPR_FUNC_NAME:
			case GROUP:
			case COUNT:
			case MAX:
			case MIN:
			case MEAN:
			case MEDIAN:
			case STD:
			case SUM:
			case LABEL_:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				label();
				}
				break;
			case VAR_CONCEPT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				match(VAR_CONCEPT_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Label_anyContext extends ParserRuleContext {
		public Label_scopedContext label_scoped() {
			return getRuleContext(Label_scopedContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Label_anyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_any; }
	}

	public final Label_anyContext label_any() throws RecognitionException {
		Label_anyContext _localctx = new Label_anyContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_label_any);
		try {
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LABEL_SCOPED_:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				label_scoped();
				}
				break;
			case GET:
			case THING:
			case ENTITY:
			case ATTRIBUTE:
			case RELATION:
			case ROLE:
			case RULE:
			case OFFSET:
			case LIMIT:
			case SORT:
			case VALUE:
			case CONTAINS:
			case EXPR_FUNC_NAME:
			case GROUP:
			case COUNT:
			case MAX:
			case MIN:
			case MEAN:
			case MEDIAN:
			case STD:
			case SUM:
			case LABEL_:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				label();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Label_scopedContext extends ParserRuleContext {
		public TerminalNode LABEL_SCOPED_() { return getToken(TypeQLParser.LABEL_SCOPED_, 0); }
		public Label_scopedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_scoped; }
	}

	public final Label_scopedContext label_scoped() throws RecognitionException {
		Label_scopedContext _localctx = new Label_scopedContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_label_scoped);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			match(LABEL_SCOPED_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode LABEL_() { return getToken(TypeQLParser.LABEL_, 0); }
		public Type_nativeContext type_native() {
			return getRuleContext(Type_nativeContext.class,0);
		}
		public UnreservedContext unreserved() {
			return getRuleContext(UnreservedContext.class,0);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_label);
		try {
			setState(599);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LABEL_:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				match(LABEL_);
				}
				break;
			case THING:
			case ENTITY:
			case ATTRIBUTE:
			case RELATION:
			case ROLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(597);
				type_native();
				}
				break;
			case GET:
			case RULE:
			case OFFSET:
			case LIMIT:
			case SORT:
			case VALUE:
			case CONTAINS:
			case EXPR_FUNC_NAME:
			case GROUP:
			case COUNT:
			case MAX:
			case MIN:
			case MEAN:
			case MEDIAN:
			case STD:
			case SUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(598);
				unreserved();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_nativeContext extends ParserRuleContext {
		public TerminalNode THING() { return getToken(TypeQLParser.THING, 0); }
		public TerminalNode ENTITY() { return getToken(TypeQLParser.ENTITY, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(TypeQLParser.ATTRIBUTE, 0); }
		public TerminalNode RELATION() { return getToken(TypeQLParser.RELATION, 0); }
		public TerminalNode ROLE() { return getToken(TypeQLParser.ROLE, 0); }
		public Type_nativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_native; }
	}

	public final Type_nativeContext type_native() throws RecognitionException {
		Type_nativeContext _localctx = new Type_nativeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_type_native);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 253952L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_typeContext extends ParserRuleContext {
		public TerminalNode LONG() { return getToken(TypeQLParser.LONG, 0); }
		public TerminalNode DOUBLE() { return getToken(TypeQLParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(TypeQLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(TypeQLParser.BOOLEAN, 0); }
		public TerminalNode DATETIME() { return getToken(TypeQLParser.DATETIME, 0); }
		public Value_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_type; }
	}

	public final Value_typeContext value_type() throws RecognitionException {
		Value_typeContext _localctx = new Value_typeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_value_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING_() { return getToken(TypeQLParser.STRING_, 0); }
		public TerminalNode BOOLEAN_() { return getToken(TypeQLParser.BOOLEAN_, 0); }
		public TerminalNode DATE_() { return getToken(TypeQLParser.DATE_, 0); }
		public TerminalNode DATETIME_() { return getToken(TypeQLParser.DATETIME_, 0); }
		public Signed_longContext signed_long() {
			return getRuleContext(Signed_longContext.class,0);
		}
		public Signed_doubleContext signed_double() {
			return getRuleContext(Signed_doubleContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_value);
		try {
			setState(611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				match(STRING_);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(606);
				match(BOOLEAN_);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(607);
				match(DATE_);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(608);
				match(DATETIME_);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(609);
				signed_long();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(610);
				signed_double();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_longContext extends ParserRuleContext {
		public TerminalNode LONG_() { return getToken(TypeQLParser.LONG_, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public Signed_longContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_long; }
	}

	public final Signed_longContext signed_long() throws RecognitionException {
		Signed_longContext _localctx = new Signed_longContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_signed_long);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUBTRACT) {
				{
				setState(613);
				sign();
				}
			}

			setState(616);
			match(LONG_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_doubleContext extends ParserRuleContext {
		public TerminalNode DOUBLE_() { return getToken(TypeQLParser.DOUBLE_, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public Signed_doubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_double; }
	}

	public final Signed_doubleContext signed_double() throws RecognitionException {
		Signed_doubleContext _localctx = new Signed_doubleContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_signed_double);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUBTRACT) {
				{
				setState(618);
				sign();
				}
			}

			setState(621);
			match(DOUBLE_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(TypeQLParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(TypeQLParser.SUBTRACT, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUBTRACT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnreservedContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(TypeQLParser.VALUE, 0); }
		public TerminalNode EXPR_FUNC_NAME() { return getToken(TypeQLParser.EXPR_FUNC_NAME, 0); }
		public TerminalNode MIN() { return getToken(TypeQLParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(TypeQLParser.MAX, 0); }
		public TerminalNode MEDIAN() { return getToken(TypeQLParser.MEDIAN, 0); }
		public TerminalNode MEAN() { return getToken(TypeQLParser.MEAN, 0); }
		public TerminalNode STD() { return getToken(TypeQLParser.STD, 0); }
		public TerminalNode SUM() { return getToken(TypeQLParser.SUM, 0); }
		public TerminalNode COUNT() { return getToken(TypeQLParser.COUNT, 0); }
		public TerminalNode GET() { return getToken(TypeQLParser.GET, 0); }
		public TerminalNode SORT() { return getToken(TypeQLParser.SORT, 0); }
		public TerminalNode LIMIT() { return getToken(TypeQLParser.LIMIT, 0); }
		public TerminalNode OFFSET() { return getToken(TypeQLParser.OFFSET, 0); }
		public TerminalNode GROUP() { return getToken(TypeQLParser.GROUP, 0); }
		public TerminalNode CONTAINS() { return getToken(TypeQLParser.CONTAINS, 0); }
		public TerminalNode RULE() { return getToken(TypeQLParser.RULE, 0); }
		public UnreservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unreserved; }
	}

	public final UnreservedContext unreserved() throws RecognitionException {
		UnreservedContext _localctx = new UnreservedContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_unreserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 36046389208940672L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 511L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 54:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001`\u0274\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0004\u0001\u0097\b\u0001\u000b\u0001\f\u0001\u0098\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00b8\b\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00c7\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00e3\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00e8\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00ed\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00f2\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00f8\b\u0013\n\u0013\f\u0013\u00fb\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0101\b\u0014\n\u0014\f\u0014"+
		"\u0104\t\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u0108\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0112\b\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0004\u001b\u011f\b\u001b\u000b\u001b\f"+
		"\u001b\u0120\u0001\u001c\u0001\u001c\u0003\u001c\u0125\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0004\u001d\u012a\b\u001d\u000b\u001d\f\u001d"+
		"\u012b\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0132"+
		"\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0004 \u0140\b \u000b \f "+
		"\u0141\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u014d\b\"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$"+
		"\u0001$\u0005$\u0157\b$\n$\f$\u015a\t$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0003%\u0163\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u016b\b%\u0001%\u0001%\u0001%\u0001%\u0003%\u0171\b%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0003%\u0179\b%\u0001&\u0003&\u017c\b&\u0001"+
		"&\u0003&\u017f\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0186"+
		"\b\'\u0001(\u0001(\u0001(\u0004(\u018b\b(\u000b(\f(\u018c\u0001)\u0001"+
		")\u0001)\u0003)\u0192\b)\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u0199"+
		"\b*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u01a0\b*\u0001*\u0001*\u0003"+
		"*\u01a4\b*\u0001+\u0003+\u01a7\b+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003"+
		"+\u01ae\b+\u0001+\u0003+\u01b1\b+\u0001+\u0001+\u0003+\u01b5\b+\u0003"+
		"+\u01b7\b+\u0001,\u0003,\u01ba\b,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003"+
		",\u01c1\b,\u0001,\u0003,\u01c4\b,\u0001,\u0001,\u0003,\u01c8\b,\u0003"+
		",\u01ca\b,\u0001-\u0001-\u0001-\u0001-\u0005-\u01d0\b-\n-\f-\u01d3\t-"+
		"\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u01dc\b.\u0001"+
		"/\u0001/\u00010\u00010\u00010\u00050\u01e3\b0\n0\f0\u01e6\t0\u00011\u0001"+
		"1\u00011\u00011\u00011\u00031\u01ed\b1\u00011\u00011\u00031\u01f1\b1\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u01fa\b2\u00013\u0001"+
		"3\u00014\u00014\u00015\u00015\u00015\u00035\u0203\b5\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0005"+
		"6\u0211\b6\n6\f6\u0214\t6\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00037\u021e\b7\u00018\u00018\u00018\u00038\u0223\b8\u00018\u0001"+
		"8\u00019\u00019\u0001:\u0001:\u0001:\u0005:\u022c\b:\n:\f:\u022f\t:\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0003;\u0240\b;\u0001<\u0001<\u0001<\u0003"+
		"<\u0245\b<\u0001=\u0001=\u0003=\u0249\b=\u0001>\u0001>\u0003>\u024d\b"+
		">\u0001?\u0001?\u0003?\u0251\b?\u0001@\u0001@\u0001A\u0001A\u0001A\u0003"+
		"A\u0258\bA\u0001B\u0001B\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0003D\u0264\bD\u0001E\u0003E\u0267\bE\u0001E\u0001E\u0001F\u0003"+
		"F\u026c\bF\u0001F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001H\u0000\u0001"+
		"lI\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0000\n\u0002\u0000WWZZ\u0001"+
		"\u0000CI\u0002\u00000588\u0001\u000067\u0002\u0000;<>>\u0001\u00009:\u0002"+
		"\u0000AADE\u0001\u0000\r\u0011\u0001\u0000JN\u0005\u0000\u0007\u0007\u0012"+
		"\u0015,,77AI\u0287\u0000\u0092\u0001\u0000\u0000\u0000\u0002\u0096\u0001"+
		"\u0000\u0000\u0000\u0004\u009c\u0001\u0000\u0000\u0000\u0006\u009f\u0001"+
		"\u0000\u0000\u0000\b\u00a2\u0001\u0000\u0000\u0000\n\u00a5\u0001\u0000"+
		"\u0000\u0000\f\u00a8\u0001\u0000\u0000\u0000\u000e\u00ab\u0001\u0000\u0000"+
		"\u0000\u0010\u00b7\u0001\u0000\u0000\u0000\u0012\u00b9\u0001\u0000\u0000"+
		"\u0000\u0014\u00bc\u0001\u0000\u0000\u0000\u0016\u00c6\u0001\u0000\u0000"+
		"\u0000\u0018\u00c8\u0001\u0000\u0000\u0000\u001a\u00cc\u0001\u0000\u0000"+
		"\u0000\u001c\u00d1\u0001\u0000\u0000\u0000\u001e\u00d5\u0001\u0000\u0000"+
		"\u0000 \u00d8\u0001\u0000\u0000\u0000\"\u00db\u0001\u0000\u0000\u0000"+
		"$\u00e2\u0001\u0000\u0000\u0000&\u00f3\u0001\u0000\u0000\u0000(\u00fc"+
		"\u0001\u0000\u0000\u0000*\u0105\u0001\u0000\u0000\u0000,\u0109\u0001\u0000"+
		"\u0000\u0000.\u010c\u0001\u0000\u0000\u00000\u010f\u0001\u0000\u0000\u0000"+
		"2\u0115\u0001\u0000\u0000\u00004\u0117\u0001\u0000\u0000\u00006\u011e"+
		"\u0001\u0000\u0000\u00008\u0124\u0001\u0000\u0000\u0000:\u0129\u0001\u0000"+
		"\u0000\u0000<\u0131\u0001\u0000\u0000\u0000>\u0133\u0001\u0000\u0000\u0000"+
		"@\u0137\u0001\u0000\u0000\u0000B\u0143\u0001\u0000\u0000\u0000D\u014c"+
		"\u0001\u0000\u0000\u0000F\u014e\u0001\u0000\u0000\u0000H\u0152\u0001\u0000"+
		"\u0000\u0000J\u0178\u0001\u0000\u0000\u0000L\u017b\u0001\u0000\u0000\u0000"+
		"N\u0185\u0001\u0000\u0000\u0000P\u018a\u0001\u0000\u0000\u0000R\u0191"+
		"\u0001\u0000\u0000\u0000T\u01a3\u0001\u0000\u0000\u0000V\u01b6\u0001\u0000"+
		"\u0000\u0000X\u01c9\u0001\u0000\u0000\u0000Z\u01cb\u0001\u0000\u0000\u0000"+
		"\\\u01db\u0001\u0000\u0000\u0000^\u01dd\u0001\u0000\u0000\u0000`\u01df"+
		"\u0001\u0000\u0000\u0000b\u01f0\u0001\u0000\u0000\u0000d\u01f9\u0001\u0000"+
		"\u0000\u0000f\u01fb\u0001\u0000\u0000\u0000h\u01fd\u0001\u0000\u0000\u0000"+
		"j\u0202\u0001\u0000\u0000\u0000l\u0204\u0001\u0000\u0000\u0000n\u021d"+
		"\u0001\u0000\u0000\u0000p\u021f\u0001\u0000\u0000\u0000r\u0226\u0001\u0000"+
		"\u0000\u0000t\u0228\u0001\u0000\u0000\u0000v\u023f\u0001\u0000\u0000\u0000"+
		"x\u0244\u0001\u0000\u0000\u0000z\u0248\u0001\u0000\u0000\u0000|\u024c"+
		"\u0001\u0000\u0000\u0000~\u0250\u0001\u0000\u0000\u0000\u0080\u0252\u0001"+
		"\u0000\u0000\u0000\u0082\u0257\u0001\u0000\u0000\u0000\u0084\u0259\u0001"+
		"\u0000\u0000\u0000\u0086\u025b\u0001\u0000\u0000\u0000\u0088\u0263\u0001"+
		"\u0000\u0000\u0000\u008a\u0266\u0001\u0000\u0000\u0000\u008c\u026b\u0001"+
		"\u0000\u0000\u0000\u008e\u026f\u0001\u0000\u0000\u0000\u0090\u0271\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0003\u0010\b\u0000\u0093\u0094\u0005\u0000"+
		"\u0000\u0001\u0094\u0001\u0001\u0000\u0000\u0000\u0095\u0097\u0003\u0010"+
		"\b\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0000\u0000"+
		"\u0001\u009b\u0003\u0001\u0000\u0000\u0000\u009c\u009d\u0003<\u001e\u0000"+
		"\u009d\u009e\u0005\u0000\u0000\u0001\u009e\u0005\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0003:\u001d\u0000\u00a0\u00a1\u0005\u0000\u0000\u0001\u00a1"+
		"\u0007\u0001\u0000\u0000\u0000\u00a2\u00a3\u00036\u001b\u0000\u00a3\u00a4"+
		"\u0005\u0000\u0000\u0001\u00a4\t\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003"+
		"D\"\u0000\u00a6\u00a7\u0005\u0000\u0000\u0001\u00a7\u000b\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0003\u0082A\u0000\u00a9\u00aa\u0005\u0000\u0000"+
		"\u0001\u00aa\r\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003v;\u0000\u00ac"+
		"\u00ad\u0005\u0000\u0000\u0001\u00ad\u000f\u0001\u0000\u0000\u0000\u00ae"+
		"\u00b8\u0003\u0012\t\u0000\u00af\u00b8\u0003\u0014\n\u0000\u00b0\u00b8"+
		"\u0003\u0016\u000b\u0000\u00b1\u00b8\u0003\u0018\f\u0000\u00b2\u00b8\u0003"+
		"\u001a\r\u0000\u00b3\u00b8\u0003\u001c\u000e\u0000\u00b4\u00b8\u0003\u001e"+
		"\u000f\u0000\u00b5\u00b8\u0003 \u0010\u0000\u00b6\u00b8\u0003\"\u0011"+
		"\u0000\u00b7\u00ae\u0001\u0000\u0000\u0000\u00b7\u00af\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b0\u0001\u0000\u0000\u0000\u00b7\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b2\u0001\u0000\u0000\u0000\u00b7\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u0011\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00bb\u00036\u001b\u0000"+
		"\u00bb\u0013\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\t\u0000\u0000\u00bd"+
		"\u00be\u00036\u001b\u0000\u00be\u0015\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0005\u0006\u0000\u0000\u00c0\u00c1\u0003:\u001d\u0000\u00c1\u00c2\u0005"+
		"\n\u0000\u0000\u00c2\u00c3\u0003P(\u0000\u00c3\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0005\n\u0000\u0000\u00c5\u00c7\u0003P(\u0000\u00c6"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7"+
		"\u0017\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003\u001a\r\u0000\u00c9\u00ca"+
		"\u0005\n\u0000\u0000\u00ca\u00cb\u0003P(\u0000\u00cb\u0019\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0005\u0006\u0000\u0000\u00cd\u00ce\u0003:\u001d"+
		"\u0000\u00ce\u00cf\u0005\u000b\u0000\u0000\u00cf\u00d0\u0003P(\u0000\u00d0"+
		"\u001b\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0006\u0000\u0000\u00d2"+
		"\u00d3\u0003:\u001d\u0000\u00d3\u00d4\u0003$\u0012\u0000\u00d4\u001d\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0003\u001c\u000e\u0000\u00d6\u00d7\u0003"+
		"0\u0018\u0000\u00d7\u001f\u0001\u0000\u0000\u0000\u00d8\u00d9\u0003\u001c"+
		"\u000e\u0000\u00d9\u00da\u00034\u001a\u0000\u00da!\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0003\u001c\u000e\u0000\u00dc\u00dd\u00034\u001a\u0000\u00dd"+
		"\u00de\u00030\u0018\u0000\u00de#\u0001\u0000\u0000\u0000\u00df\u00e0\u0003"+
		"&\u0013\u0000\u00e0\u00e1\u0005\u0001\u0000\u0000\u00e1\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e2\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e7\u0001\u0000\u0000\u0000\u00e4\u00e5\u0003(\u0014"+
		"\u0000\u00e5\u00e6\u0005\u0001\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e8\u00ec\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003,\u0016\u0000"+
		"\u00ea\u00eb\u0005\u0001\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ec\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ed\u00f1\u0001\u0000\u0000\u0000\u00ee\u00ef\u0003.\u0017\u0000\u00ef"+
		"\u00f0\u0005\u0001\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2"+
		"%\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u0007\u0000\u0000\u00f4\u00f9"+
		"\u0007\u0000\u0000\u0000\u00f5\u00f6\u0005\u0002\u0000\u0000\u00f6\u00f8"+
		"\u0007\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fb"+
		"\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fa\'\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005\u0015\u0000\u0000\u00fd\u0102\u0003"+
		"*\u0015\u0000\u00fe\u00ff\u0005\u0002\u0000\u0000\u00ff\u0101\u0003*\u0015"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000"+
		"\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000"+
		"\u0000\u0103)\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0105\u0107\u0007\u0000\u0000\u0000\u0106\u0108\u0005\u0016\u0000\u0000"+
		"\u0107\u0106\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000"+
		"\u0108+\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u0013\u0000\u0000\u010a"+
		"\u010b\u0005S\u0000\u0000\u010b-\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		"\u0014\u0000\u0000\u010d\u010e\u0005S\u0000\u0000\u010e/\u0001\u0000\u0000"+
		"\u0000\u010f\u0111\u00032\u0019\u0000\u0110\u0112\u0007\u0000\u0000\u0000"+
		"\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u0001\u0000\u0000"+
		"\u01141\u0001\u0000\u0000\u0000\u0115\u0116\u0007\u0001\u0000\u0000\u0116"+
		"3\u0001\u0000\u0000\u0000\u0117\u0118\u0005B\u0000\u0000\u0118\u0119\u0007"+
		"\u0000\u0000\u0000\u0119\u011a\u0005\u0001\u0000\u0000\u011a5\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u00038\u001c\u0000\u011c\u011d\u0005\u0001\u0000"+
		"\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u011b\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000"+
		"\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u01217\u0001\u0000\u0000\u0000"+
		"\u0122\u0125\u0003H$\u0000\u0123\u0125\u0003v;\u0000\u0124\u0122\u0001"+
		"\u0000\u0000\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u01259\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0003<\u001e\u0000\u0127\u0128\u0005\u0001\u0000"+
		"\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0126\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c;\u0001\u0000\u0000\u0000"+
		"\u012d\u0132\u0003D\"\u0000\u012e\u0132\u0003>\u001f\u0000\u012f\u0132"+
		"\u0003@ \u0000\u0130\u0132\u0003B!\u0000\u0131\u012d\u0001\u0000\u0000"+
		"\u0000\u0131\u012e\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000"+
		"\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132=\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0005\u0003\u0000\u0000\u0134\u0135\u0003:\u001d\u0000\u0135"+
		"\u0136\u0005\u0004\u0000\u0000\u0136?\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0005\u0003\u0000\u0000\u0138\u0139\u0003:\u001d\u0000\u0139\u013f\u0005"+
		"\u0004\u0000\u0000\u013a\u013b\u0005.\u0000\u0000\u013b\u013c\u0005\u0003"+
		"\u0000\u0000\u013c\u013d\u0003:\u001d\u0000\u013d\u013e\u0005\u0004\u0000"+
		"\u0000\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u013a\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142A\u0001\u0000\u0000\u0000"+
		"\u0143\u0144\u0005/\u0000\u0000\u0144\u0145\u0005\u0003\u0000\u0000\u0145"+
		"\u0146\u0003:\u001d\u0000\u0146\u0147\u0005\u0004\u0000\u0000\u0147C\u0001"+
		"\u0000\u0000\u0000\u0148\u014d\u0003F#\u0000\u0149\u014d\u0003H$\u0000"+
		"\u014a\u014d\u0003R)\u0000\u014b\u014d\u0003N\'\u0000\u014c\u0148\u0001"+
		"\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014c\u014a\u0001"+
		"\u0000\u0000\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014dE\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0005W\u0000\u0000\u014f\u0150\u0005-\u0000\u0000"+
		"\u0150\u0151\u0005W\u0000\u0000\u0151G\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0003x<\u0000\u0153\u0158\u0003J%\u0000\u0154\u0155\u0005\u0002\u0000"+
		"\u0000\u0155\u0157\u0003J%\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0157"+
		"\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158"+
		"\u0159\u0001\u0000\u0000\u0000\u0159I\u0001\u0000\u0000\u0000\u015a\u0158"+
		"\u0001\u0000\u0000\u0000\u015b\u0179\u0005\u001a\u0000\u0000\u015c\u015d"+
		"\u0005\u001b\u0000\u0000\u015d\u0179\u0003x<\u0000\u015e\u015f\u0005\u001e"+
		"\u0000\u0000\u015f\u0162\u0003|>\u0000\u0160\u0161\u0005 \u0000\u0000"+
		"\u0161\u0163\u0003|>\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165"+
		"\u0003L&\u0000\u0165\u0179\u0001\u0000\u0000\u0000\u0166\u0167\u0005\""+
		"\u0000\u0000\u0167\u016a\u0003|>\u0000\u0168\u0169\u0005 \u0000\u0000"+
		"\u0169\u016b\u0003|>\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016a\u016b"+
		"\u0001\u0000\u0000\u0000\u016b\u0179\u0001\u0000\u0000\u0000\u016c\u016d"+
		"\u0005!\u0000\u0000\u016d\u0170\u0003z=\u0000\u016e\u016f\u0005 \u0000"+
		"\u0000\u016f\u0171\u0003|>\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170"+
		"\u0171\u0001\u0000\u0000\u0000\u0171\u0179\u0001\u0000\u0000\u0000\u0172"+
		"\u0173\u0005,\u0000\u0000\u0173\u0179\u0003\u0086C\u0000\u0174\u0175\u0005"+
		"\u001f\u0000\u0000\u0175\u0179\u0005R\u0000\u0000\u0176\u0177\u0005\u0019"+
		"\u0000\u0000\u0177\u0179\u0003~?\u0000\u0178\u015b\u0001\u0000\u0000\u0000"+
		"\u0178\u015c\u0001\u0000\u0000\u0000\u0178\u015e\u0001\u0000\u0000\u0000"+
		"\u0178\u0166\u0001\u0000\u0000\u0000\u0178\u016c\u0001\u0000\u0000\u0000"+
		"\u0178\u0172\u0001\u0000\u0000\u0000\u0178\u0174\u0001\u0000\u0000\u0000"+
		"\u0178\u0176\u0001\u0000\u0000\u0000\u0179K\u0001\u0000\u0000\u0000\u017a"+
		"\u017c\u0005%\u0000\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017b\u017c"+
		"\u0001\u0000\u0000\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017f"+
		"\u0005&\u0000\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017e\u017f\u0001"+
		"\u0000\u0000\u0000\u017fM\u0001\u0000\u0000\u0000\u0180\u0181\u0005Z\u0000"+
		"\u0000\u0181\u0182\u00058\u0000\u0000\u0182\u0186\u0003l6\u0000\u0183"+
		"\u0184\u0005Z\u0000\u0000\u0184\u0186\u0003d2\u0000\u0185\u0180\u0001"+
		"\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186O\u0001\u0000"+
		"\u0000\u0000\u0187\u0188\u0003R)\u0000\u0188\u0189\u0005\u0001\u0000\u0000"+
		"\u0189\u018b\u0001\u0000\u0000\u0000\u018a\u0187\u0001\u0000\u0000\u0000"+
		"\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018a\u0001\u0000\u0000\u0000"+
		"\u018c\u018d\u0001\u0000\u0000\u0000\u018dQ\u0001\u0000\u0000\u0000\u018e"+
		"\u0192\u0003T*\u0000\u018f\u0192\u0003V+\u0000\u0190\u0192\u0003X,\u0000"+
		"\u0191\u018e\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000"+
		"\u0191\u0190\u0001\u0000\u0000\u0000\u0192S\u0001\u0000\u0000\u0000\u0193"+
		"\u0194\u0005W\u0000\u0000\u0194\u0195\u0005(\u0000\u0000\u0195\u0198\u0003"+
		"|>\u0000\u0196\u0197\u0005\u0002\u0000\u0000\u0197\u0199\u0003`0\u0000"+
		"\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000"+
		"\u0199\u01a4\u0001\u0000\u0000\u0000\u019a\u019b\u0005W\u0000\u0000\u019b"+
		"\u019c\u0005\'\u0000\u0000\u019c\u019f\u0005[\u0000\u0000\u019d\u019e"+
		"\u0005\u0002\u0000\u0000\u019e\u01a0\u0003`0\u0000\u019f\u019d\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a2\u0005W\u0000\u0000\u01a2\u01a4\u0003`0\u0000"+
		"\u01a3\u0193\u0001\u0000\u0000\u0000\u01a3\u019a\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a4U\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a7\u0005W\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a6\u01a7"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0003Z-\u0000\u01a9\u01aa\u0005(\u0000\u0000\u01aa\u01ad\u0003|>\u0000"+
		"\u01ab\u01ac\u0005\u0002\u0000\u0000\u01ac\u01ae\u0003`0\u0000\u01ad\u01ab"+
		"\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01b7"+
		"\u0001\u0000\u0000\u0000\u01af\u01b1\u0005W\u0000\u0000\u01b0\u01af\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b4\u0003Z-\u0000\u01b3\u01b5\u0003`0\u0000"+
		"\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b7\u0001\u0000\u0000\u0000\u01b6\u01a6\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b0\u0001\u0000\u0000\u0000\u01b7W\u0001\u0000\u0000\u0000\u01b8"+
		"\u01ba\u0005W\u0000\u0000\u01b9\u01b8\u0001\u0000\u0000\u0000\u01b9\u01ba"+
		"\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01bc"+
		"\u0003d2\u0000\u01bc\u01bd\u0005(\u0000\u0000\u01bd\u01c0\u0003|>\u0000"+
		"\u01be\u01bf\u0005\u0002\u0000\u0000\u01bf\u01c1\u0003`0\u0000\u01c0\u01be"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01ca"+
		"\u0001\u0000\u0000\u0000\u01c2\u01c4\u0005W\u0000\u0000\u01c3\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c7\u0003d2\u0000\u01c6\u01c8\u0003`0\u0000"+
		"\u01c7\u01c6\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000"+
		"\u01c8\u01ca\u0001\u0000\u0000\u0000\u01c9\u01b9\u0001\u0000\u0000\u0000"+
		"\u01c9\u01c3\u0001\u0000\u0000\u0000\u01caY\u0001\u0000\u0000\u0000\u01cb"+
		"\u01cc\u0005?\u0000\u0000\u01cc\u01d1\u0003\\.\u0000\u01cd\u01ce\u0005"+
		"\u0002\u0000\u0000\u01ce\u01d0\u0003\\.\u0000\u01cf\u01cd\u0001\u0000"+
		"\u0000\u0000\u01d0\u01d3\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005@\u0000"+
		"\u0000\u01d5[\u0001\u0000\u0000\u0000\u01d6\u01d7\u0003|>\u0000\u01d7"+
		"\u01d8\u0005\u0005\u0000\u0000\u01d8\u01d9\u0003^/\u0000\u01d9\u01dc\u0001"+
		"\u0000\u0000\u0000\u01da\u01dc\u0003^/\u0000\u01db\u01d6\u0001\u0000\u0000"+
		"\u0000\u01db\u01da\u0001\u0000\u0000\u0000\u01dc]\u0001\u0000\u0000\u0000"+
		"\u01dd\u01de\u0005W\u0000\u0000\u01de_\u0001\u0000\u0000\u0000\u01df\u01e4"+
		"\u0003b1\u0000\u01e0\u01e1\u0005\u0002\u0000\u0000\u01e1\u01e3\u0003b"+
		"1\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e5a\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e8\u0005+\u0000\u0000\u01e8\u01ec\u0003\u0082A\u0000\u01e9\u01ed"+
		"\u0005W\u0000\u0000\u01ea\u01ed\u0005Z\u0000\u0000\u01eb\u01ed\u0003d"+
		"2\u0000\u01ec\u01e9\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ed\u01f1\u0001\u0000\u0000"+
		"\u0000\u01ee\u01ef\u0005+\u0000\u0000\u01ef\u01f1\u0005W\u0000\u0000\u01f0"+
		"\u01e7\u0001\u0000\u0000\u0000\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f1"+
		"c\u0001\u0000\u0000\u0000\u01f2\u01fa\u0003\u0088D\u0000\u01f3\u01f4\u0003"+
		"f3\u0000\u01f4\u01f5\u0003j5\u0000\u01f5\u01fa\u0001\u0000\u0000\u0000"+
		"\u01f6\u01f7\u0003h4\u0000\u01f7\u01f8\u0005R\u0000\u0000\u01f8\u01fa"+
		"\u0001\u0000\u0000\u0000\u01f9\u01f2\u0001\u0000\u0000\u0000\u01f9\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f9\u01f6\u0001\u0000\u0000\u0000\u01fae\u0001"+
		"\u0000\u0000\u0000\u01fb\u01fc\u0007\u0002\u0000\u0000\u01fcg\u0001\u0000"+
		"\u0000\u0000\u01fd\u01fe\u0007\u0003\u0000\u0000\u01fei\u0001\u0000\u0000"+
		"\u0000\u01ff\u0203\u0003\u0088D\u0000\u0200\u0203\u0005W\u0000\u0000\u0201"+
		"\u0203\u0005Z\u0000\u0000\u0202\u01ff\u0001\u0000\u0000\u0000\u0202\u0200"+
		"\u0001\u0000\u0000\u0000\u0202\u0201\u0001\u0000\u0000\u0000\u0203k\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\u00066\uffff\uffff\u0000\u0205\u0206\u0003"+
		"n7\u0000\u0206\u0212\u0001\u0000\u0000\u0000\u0207\u0208\n\u0004\u0000"+
		"\u0000\u0208\u0209\u0005=\u0000\u0000\u0209\u0211\u0003l6\u0004\u020a"+
		"\u020b\n\u0003\u0000\u0000\u020b\u020c\u0007\u0004\u0000\u0000\u020c\u0211"+
		"\u0003l6\u0004\u020d\u020e\n\u0002\u0000\u0000\u020e\u020f\u0007\u0005"+
		"\u0000\u0000\u020f\u0211\u0003l6\u0003\u0210\u0207\u0001\u0000\u0000\u0000"+
		"\u0210\u020a\u0001\u0000\u0000\u0000\u0210\u020d\u0001\u0000\u0000\u0000"+
		"\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000"+
		"\u0212\u0213\u0001\u0000\u0000\u0000\u0213m\u0001\u0000\u0000\u0000\u0214"+
		"\u0212\u0001\u0000\u0000\u0000\u0215\u021e\u0005W\u0000\u0000\u0216\u021e"+
		"\u0005Z\u0000\u0000\u0217\u021e\u0003p8\u0000\u0218\u021e\u0003\u0088"+
		"D\u0000\u0219\u021a\u0005?\u0000\u0000\u021a\u021b\u0003l6\u0000\u021b"+
		"\u021c\u0005@\u0000\u0000\u021c\u021e\u0001\u0000\u0000\u0000\u021d\u0215"+
		"\u0001\u0000\u0000\u0000\u021d\u0216\u0001\u0000\u0000\u0000\u021d\u0217"+
		"\u0001\u0000\u0000\u0000\u021d\u0218\u0001\u0000\u0000\u0000\u021d\u0219"+
		"\u0001\u0000\u0000\u0000\u021eo\u0001\u0000\u0000\u0000\u021f\u0220\u0003"+
		"r9\u0000\u0220\u0222\u0005?\u0000\u0000\u0221\u0223\u0003t:\u0000\u0222"+
		"\u0221\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000\u0000\u0000\u0223"+
		"\u0224\u0001\u0000\u0000\u0000\u0224\u0225\u0005@\u0000\u0000\u0225q\u0001"+
		"\u0000\u0000\u0000\u0226\u0227\u0007\u0006\u0000\u0000\u0227s\u0001\u0000"+
		"\u0000\u0000\u0228\u022d\u0003l6\u0000\u0229\u022a\u0005\u0002\u0000\u0000"+
		"\u022a\u022c\u0003l6\u0000\u022b\u0229\u0001\u0000\u0000\u0000\u022c\u022f"+
		"\u0001\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022d\u022e"+
		"\u0001\u0000\u0000\u0000\u022eu\u0001\u0000\u0000\u0000\u022f\u022d\u0001"+
		"\u0000\u0000\u0000\u0230\u0231\u0005\u0012\u0000\u0000\u0231\u0240\u0003"+
		"\u0082A\u0000\u0232\u0233\u0005\u0012\u0000\u0000\u0233\u0234\u0003\u0082"+
		"A\u0000\u0234\u0235\u0005\u0005\u0000\u0000\u0235\u0236\u0005#\u0000\u0000"+
		"\u0236\u0237\u0005\u0003\u0000\u0000\u0237\u0238\u0003:\u001d\u0000\u0238"+
		"\u0239\u0005\u0004\u0000\u0000\u0239\u023a\u0005$\u0000\u0000\u023a\u023b"+
		"\u0005\u0003\u0000\u0000\u023b\u023c\u0003R)\u0000\u023c\u023d\u0005\u0001"+
		"\u0000\u0000\u023d\u023e\u0005\u0004\u0000\u0000\u023e\u0240\u0001\u0000"+
		"\u0000\u0000\u023f\u0230\u0001\u0000\u0000\u0000\u023f\u0232\u0001\u0000"+
		"\u0000\u0000\u0240w\u0001\u0000\u0000\u0000\u0241\u0245\u0003z=\u0000"+
		"\u0242\u0245\u0003|>\u0000\u0243\u0245\u0005W\u0000\u0000\u0244\u0241"+
		"\u0001\u0000\u0000\u0000\u0244\u0242\u0001\u0000\u0000\u0000\u0244\u0243"+
		"\u0001\u0000\u0000\u0000\u0245y\u0001\u0000\u0000\u0000\u0246\u0249\u0003"+
		"\u0080@\u0000\u0247\u0249\u0005W\u0000\u0000\u0248\u0246\u0001\u0000\u0000"+
		"\u0000\u0248\u0247\u0001\u0000\u0000\u0000\u0249{\u0001\u0000\u0000\u0000"+
		"\u024a\u024d\u0003\u0082A\u0000\u024b\u024d\u0005W\u0000\u0000\u024c\u024a"+
		"\u0001\u0000\u0000\u0000\u024c\u024b\u0001\u0000\u0000\u0000\u024d}\u0001"+
		"\u0000\u0000\u0000\u024e\u0251\u0003\u0080@\u0000\u024f\u0251\u0003\u0082"+
		"A\u0000\u0250\u024e\u0001\u0000\u0000\u0000\u0250\u024f\u0001\u0000\u0000"+
		"\u0000\u0251\u007f\u0001\u0000\u0000\u0000\u0252\u0253\u0005]\u0000\u0000"+
		"\u0253\u0081\u0001\u0000\u0000\u0000\u0254\u0258\u0005\\\u0000\u0000\u0255"+
		"\u0258\u0003\u0084B\u0000\u0256\u0258\u0003\u0090H\u0000\u0257\u0254\u0001"+
		"\u0000\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000\u0257\u0256\u0001"+
		"\u0000\u0000\u0000\u0258\u0083\u0001\u0000\u0000\u0000\u0259\u025a\u0007"+
		"\u0007\u0000\u0000\u025a\u0085\u0001\u0000\u0000\u0000\u025b\u025c\u0007"+
		"\b\u0000\u0000\u025c\u0087\u0001\u0000\u0000\u0000\u025d\u0264\u0005R"+
		"\u0000\u0000\u025e\u0264\u0005O\u0000\u0000\u025f\u0264\u0005U\u0000\u0000"+
		"\u0260\u0264\u0005V\u0000\u0000\u0261\u0264\u0003\u008aE\u0000\u0262\u0264"+
		"\u0003\u008cF\u0000\u0263\u025d\u0001\u0000\u0000\u0000\u0263\u025e\u0001"+
		"\u0000\u0000\u0000\u0263\u025f\u0001\u0000\u0000\u0000\u0263\u0260\u0001"+
		"\u0000\u0000\u0000\u0263\u0261\u0001\u0000\u0000\u0000\u0263\u0262\u0001"+
		"\u0000\u0000\u0000\u0264\u0089\u0001\u0000\u0000\u0000\u0265\u0267\u0003"+
		"\u008eG\u0000\u0266\u0265\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000"+
		"\u0000\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268\u0269\u0005S\u0000"+
		"\u0000\u0269\u008b\u0001\u0000\u0000\u0000\u026a\u026c\u0003\u008eG\u0000"+
		"\u026b\u026a\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000\u0000"+
		"\u026c\u026d\u0001\u0000\u0000\u0000\u026d\u026e\u0005T\u0000\u0000\u026e"+
		"\u008d\u0001\u0000\u0000\u0000\u026f\u0270\u0007\u0005\u0000\u0000\u0270"+
		"\u008f\u0001\u0000\u0000\u0000\u0271\u0272\u0007\t\u0000\u0000\u0272\u0091"+
		"\u0001\u0000\u0000\u0000=\u0098\u00b7\u00c6\u00e2\u00e7\u00ec\u00f1\u00f9"+
		"\u0102\u0107\u0111\u0120\u0124\u012b\u0131\u0141\u014c\u0158\u0162\u016a"+
		"\u0170\u0178\u017b\u017e\u0185\u018c\u0191\u0198\u019f\u01a3\u01a6\u01ad"+
		"\u01b0\u01b4\u01b6\u01b9\u01c0\u01c3\u01c7\u01c9\u01d1\u01db\u01e4\u01ec"+
		"\u01f0\u01f9\u0202\u0210\u0212\u021d\u0222\u022d\u023f\u0244\u0248\u024c"+
		"\u0250\u0257\u0263\u0266\u026b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}