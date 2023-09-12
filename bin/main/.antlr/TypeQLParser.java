// Generated from /Users/yashb/Desktop/Vaticle/typeql-plugin-jetbrains/bin/main/TypeQL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypeQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MATCH) | (1L << DEFINE) | (1L << UNDEFINE) | (1L << INSERT))) != 0) );
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
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (COUNT - 67)) | (1L << (MAX - 67)) | (1L << (MIN - 67)) | (1L << (MEAN - 67)) | (1L << (MEDIAN - 67)) | (1L << (STD - 67)) | (1L << (SUM - 67)))) != 0)) ) {
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << THING) | (1L << ENTITY) | (1L << ATTRIBUTE) | (1L << RELATION) | (1L << ROLE) | (1L << RULE) | (1L << OFFSET) | (1L << LIMIT) | (1L << SORT) | (1L << VALUE) | (1L << CONTAINS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (EXPR_FUNC_NAME - 65)) | (1L << (GROUP - 65)) | (1L << (COUNT - 65)) | (1L << (MAX - 65)) | (1L << (MIN - 65)) | (1L << (MEAN - 65)) | (1L << (MEDIAN - 65)) | (1L << (STD - 65)) | (1L << (SUM - 65)) | (1L << (VAR_CONCEPT_ - 65)) | (1L << (LABEL_ - 65)) | (1L << (LABEL_SCOPED_ - 65)))) != 0) );
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
			} while ( ((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & ((1L << (EQ - 48)) | (1L << (NEQ - 48)) | (1L << (GT - 48)) | (1L << (GTE - 48)) | (1L << (LT - 48)) | (1L << (LTE - 48)) | (1L << (LIKE - 48)) | (1L << (CONTAINS - 48)) | (1L << (ASSIGN - 48)) | (1L << (ADD - 48)) | (1L << (SUBTRACT - 48)) | (1L << (PAREN_OPEN - 48)) | (1L << (BOOLEAN_ - 48)) | (1L << (STRING_ - 48)) | (1L << (LONG_ - 48)) | (1L << (DOUBLE_ - 48)) | (1L << (DATE_ - 48)) | (1L << (DATETIME_ - 48)) | (1L << (VAR_CONCEPT_ - 48)))) != 0) );
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << ASSIGN))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIVIDE) | (1L << MULTIPLY) | (1L << MODULO))) != 0)) ) {
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
			if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (ADD - 57)) | (1L << (SUBTRACT - 57)) | (1L << (PAREN_OPEN - 57)) | (1L << (EXPR_FUNC_NAME - 57)) | (1L << (MAX - 57)) | (1L << (MIN - 57)) | (1L << (BOOLEAN_ - 57)) | (1L << (STRING_ - 57)) | (1L << (LONG_ - 57)) | (1L << (DOUBLE_ - 57)) | (1L << (DATE_ - 57)) | (1L << (DATETIME_ - 57)) | (1L << (VAR_CONCEPT_ - 57)) | (1L << (VAR_VALUE_ - 57)))) != 0)) {
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
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (EXPR_FUNC_NAME - 65)) | (1L << (MAX - 65)) | (1L << (MIN - 65)))) != 0)) ) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THING) | (1L << ENTITY) | (1L << ATTRIBUTE) | (1L << RELATION) | (1L << ROLE))) != 0)) ) {
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
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (LONG - 74)) | (1L << (DOUBLE - 74)) | (1L << (STRING - 74)) | (1L << (BOOLEAN - 74)) | (1L << (DATETIME - 74)))) != 0)) ) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << RULE) | (1L << OFFSET) | (1L << LIMIT) | (1L << SORT) | (1L << VALUE) | (1L << CONTAINS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (EXPR_FUNC_NAME - 65)) | (1L << (GROUP - 65)) | (1L << (COUNT - 65)) | (1L << (MAX - 65)) | (1L << (MIN - 65)) | (1L << (MEAN - 65)) | (1L << (MEDIAN - 65)) | (1L << (STD - 65)) | (1L << (SUM - 65)))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3b\u0276\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\2\3\3\6\3\u0099\n\3\r\3\16\3\u009a\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ba\n\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\5\24\u00e5\n\24\3\24\3\24\3\24\5\24"+
		"\u00ea\n\24\3\24\3\24\3\24\5\24\u00ef\n\24\3\24\3\24\3\24\5\24\u00f4\n"+
		"\24\3\25\3\25\3\25\3\25\7\25\u00fa\n\25\f\25\16\25\u00fd\13\25\3\26\3"+
		"\26\3\26\3\26\7\26\u0103\n\26\f\26\16\26\u0106\13\26\3\27\3\27\5\27\u010a"+
		"\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\5\32\u0114\n\32\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\6\35\u0121\n\35\r\35\16"+
		"\35\u0122\3\36\3\36\5\36\u0127\n\36\3\37\3\37\3\37\6\37\u012c\n\37\r\37"+
		"\16\37\u012d\3 \3 \3 \3 \5 \u0134\n \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\6\"\u0142\n\"\r\"\16\"\u0143\3#\3#\3#\3#\3#\3$\3$\3$\3$\5$"+
		"\u014f\n$\3%\3%\3%\3%\3&\3&\3&\3&\7&\u0159\n&\f&\16&\u015c\13&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u0165\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u016d\n"+
		"\'\3\'\3\'\3\'\3\'\5\'\u0173\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u017b\n\'"+
		"\3(\5(\u017e\n(\3(\5(\u0181\n(\3)\3)\3)\3)\3)\5)\u0188\n)\3*\3*\3*\6*"+
		"\u018d\n*\r*\16*\u018e\3+\3+\3+\5+\u0194\n+\3,\3,\3,\3,\3,\5,\u019b\n"+
		",\3,\3,\3,\3,\3,\5,\u01a2\n,\3,\3,\5,\u01a6\n,\3-\5-\u01a9\n-\3-\3-\3"+
		"-\3-\3-\5-\u01b0\n-\3-\5-\u01b3\n-\3-\3-\5-\u01b7\n-\5-\u01b9\n-\3.\5"+
		".\u01bc\n.\3.\3.\3.\3.\3.\5.\u01c3\n.\3.\5.\u01c6\n.\3.\3.\5.\u01ca\n"+
		".\5.\u01cc\n.\3/\3/\3/\3/\7/\u01d2\n/\f/\16/\u01d5\13/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\5\60\u01de\n\60\3\61\3\61\3\62\3\62\3\62\7\62\u01e5\n"+
		"\62\f\62\16\62\u01e8\13\62\3\63\3\63\3\63\3\63\3\63\5\63\u01ef\n\63\3"+
		"\63\3\63\5\63\u01f3\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u01fc"+
		"\n\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\5\67\u0205\n\67\38\38\38\38\3"+
		"8\38\38\38\38\38\38\38\78\u0213\n8\f8\168\u0216\138\39\39\39\39\39\39"+
		"\39\39\59\u0220\n9\3:\3:\3:\5:\u0225\n:\3:\3:\3;\3;\3<\3<\3<\7<\u022e"+
		"\n<\f<\16<\u0231\13<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u0242"+
		"\n=\3>\3>\3>\5>\u0247\n>\3?\3?\5?\u024b\n?\3@\3@\5@\u024f\n@\3A\3A\5A"+
		"\u0253\nA\3B\3B\3C\3C\3C\5C\u025a\nC\3D\3D\3E\3E\3F\3F\3F\3F\3F\3F\5F"+
		"\u0266\nF\3G\5G\u0269\nG\3G\3G\3H\5H\u026e\nH\3H\3H\3I\3I\3J\3J\3J\2\3"+
		"nK\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\2\f\4\2YY\\\\\3\2EK\4\2\62\67::\3\289\4\2=>@@\3\2;"+
		"<\4\2CCFG\3\2\17\23\3\2LP\7\2\t\t\24\27..99CK\2\u0289\2\u0094\3\2\2\2"+
		"\4\u0098\3\2\2\2\6\u009e\3\2\2\2\b\u00a1\3\2\2\2\n\u00a4\3\2\2\2\f\u00a7"+
		"\3\2\2\2\16\u00aa\3\2\2\2\20\u00ad\3\2\2\2\22\u00b9\3\2\2\2\24\u00bb\3"+
		"\2\2\2\26\u00be\3\2\2\2\30\u00c8\3\2\2\2\32\u00ca\3\2\2\2\34\u00ce\3\2"+
		"\2\2\36\u00d3\3\2\2\2 \u00d7\3\2\2\2\"\u00da\3\2\2\2$\u00dd\3\2\2\2&\u00e4"+
		"\3\2\2\2(\u00f5\3\2\2\2*\u00fe\3\2\2\2,\u0107\3\2\2\2.\u010b\3\2\2\2\60"+
		"\u010e\3\2\2\2\62\u0111\3\2\2\2\64\u0117\3\2\2\2\66\u0119\3\2\2\28\u0120"+
		"\3\2\2\2:\u0126\3\2\2\2<\u012b\3\2\2\2>\u0133\3\2\2\2@\u0135\3\2\2\2B"+
		"\u0139\3\2\2\2D\u0145\3\2\2\2F\u014e\3\2\2\2H\u0150\3\2\2\2J\u0154\3\2"+
		"\2\2L\u017a\3\2\2\2N\u017d\3\2\2\2P\u0187\3\2\2\2R\u018c\3\2\2\2T\u0193"+
		"\3\2\2\2V\u01a5\3\2\2\2X\u01b8\3\2\2\2Z\u01cb\3\2\2\2\\\u01cd\3\2\2\2"+
		"^\u01dd\3\2\2\2`\u01df\3\2\2\2b\u01e1\3\2\2\2d\u01f2\3\2\2\2f\u01fb\3"+
		"\2\2\2h\u01fd\3\2\2\2j\u01ff\3\2\2\2l\u0204\3\2\2\2n\u0206\3\2\2\2p\u021f"+
		"\3\2\2\2r\u0221\3\2\2\2t\u0228\3\2\2\2v\u022a\3\2\2\2x\u0241\3\2\2\2z"+
		"\u0246\3\2\2\2|\u024a\3\2\2\2~\u024e\3\2\2\2\u0080\u0252\3\2\2\2\u0082"+
		"\u0254\3\2\2\2\u0084\u0259\3\2\2\2\u0086\u025b\3\2\2\2\u0088\u025d\3\2"+
		"\2\2\u008a\u0265\3\2\2\2\u008c\u0268\3\2\2\2\u008e\u026d\3\2\2\2\u0090"+
		"\u0271\3\2\2\2\u0092\u0273\3\2\2\2\u0094\u0095\5\22\n\2\u0095\u0096\7"+
		"\2\2\3\u0096\3\3\2\2\2\u0097\u0099\5\22\n\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\7\2\2\3\u009d\5\3\2\2\2\u009e\u009f\5> \2\u009f\u00a0"+
		"\7\2\2\3\u00a0\7\3\2\2\2\u00a1\u00a2\5<\37\2\u00a2\u00a3\7\2\2\3\u00a3"+
		"\t\3\2\2\2\u00a4\u00a5\58\35\2\u00a5\u00a6\7\2\2\3\u00a6\13\3\2\2\2\u00a7"+
		"\u00a8\5F$\2\u00a8\u00a9\7\2\2\3\u00a9\r\3\2\2\2\u00aa\u00ab\5\u0084C"+
		"\2\u00ab\u00ac\7\2\2\3\u00ac\17\3\2\2\2\u00ad\u00ae\5x=\2\u00ae\u00af"+
		"\7\2\2\3\u00af\21\3\2\2\2\u00b0\u00ba\5\24\13\2\u00b1\u00ba\5\26\f\2\u00b2"+
		"\u00ba\5\30\r\2\u00b3\u00ba\5\32\16\2\u00b4\u00ba\5\34\17\2\u00b5\u00ba"+
		"\5\36\20\2\u00b6\u00ba\5 \21\2\u00b7\u00ba\5\"\22\2\u00b8\u00ba\5$\23"+
		"\2\u00b9\u00b0\3\2\2\2\u00b9\u00b1\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b3"+
		"\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00bc\7\n\2"+
		"\2\u00bc\u00bd\58\35\2\u00bd\25\3\2\2\2\u00be\u00bf\7\13\2\2\u00bf\u00c0"+
		"\58\35\2\u00c0\27\3\2\2\2\u00c1\u00c2\7\b\2\2\u00c2\u00c3\5<\37\2\u00c3"+
		"\u00c4\7\f\2\2\u00c4\u00c5\5R*\2\u00c5\u00c9\3\2\2\2\u00c6\u00c7\7\f\2"+
		"\2\u00c7\u00c9\5R*\2\u00c8\u00c1\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\31"+
		"\3\2\2\2\u00ca\u00cb\5\34\17\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\5R*\2\u00cd"+
		"\33\3\2\2\2\u00ce\u00cf\7\b\2\2\u00cf\u00d0\5<\37\2\u00d0\u00d1\7\r\2"+
		"\2\u00d1\u00d2\5R*\2\u00d2\35\3\2\2\2\u00d3\u00d4\7\b\2\2\u00d4\u00d5"+
		"\5<\37\2\u00d5\u00d6\5&\24\2\u00d6\37\3\2\2\2\u00d7\u00d8\5\36\20\2\u00d8"+
		"\u00d9\5\62\32\2\u00d9!\3\2\2\2\u00da\u00db\5\36\20\2\u00db\u00dc\5\66"+
		"\34\2\u00dc#\3\2\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\5\66\34\2\u00df"+
		"\u00e0\5\62\32\2\u00e0%\3\2\2\2\u00e1\u00e2\5(\25\2\u00e2\u00e3\7\3\2"+
		"\2\u00e3\u00e5\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e9"+
		"\3\2\2\2\u00e6\u00e7\5*\26\2\u00e7\u00e8\7\3\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e6\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ec\5."+
		"\30\2\u00ec\u00ed\7\3\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00f1\5\60\31\2\u00f1\u00f2\7"+
		"\3\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\'\3\2\2\2\u00f5\u00f6\7\t\2\2\u00f6\u00fb\t\2\2\2\u00f7\u00f8\7\4\2\2"+
		"\u00f8\u00fa\t\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc)\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\7\27\2\2\u00ff\u0104\5,\27\2\u0100\u0101\7\4\2\2\u0101\u0103\5"+
		",\27\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105+\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\t\2\2\2"+
		"\u0108\u010a\7\30\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a-\3"+
		"\2\2\2\u010b\u010c\7\25\2\2\u010c\u010d\7U\2\2\u010d/\3\2\2\2\u010e\u010f"+
		"\7\26\2\2\u010f\u0110\7U\2\2\u0110\61\3\2\2\2\u0111\u0113\5\64\33\2\u0112"+
		"\u0114\t\2\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0116\7\3\2\2\u0116\63\3\2\2\2\u0117\u0118\t\3\2\2\u0118\65"+
		"\3\2\2\2\u0119\u011a\7D\2\2\u011a\u011b\t\2\2\2\u011b\u011c\7\3\2\2\u011c"+
		"\67\3\2\2\2\u011d\u011e\5:\36\2\u011e\u011f\7\3\2\2\u011f\u0121\3\2\2"+
		"\2\u0120\u011d\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u01239\3\2\2\2\u0124\u0127\5J&\2\u0125\u0127\5x=\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0125\3\2\2\2\u0127;\3\2\2\2\u0128\u0129\5> \2\u0129\u012a"+
		"\7\3\2\2\u012a\u012c\3\2\2\2\u012b\u0128\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e=\3\2\2\2\u012f\u0134\5F$\2\u0130"+
		"\u0134\5@!\2\u0131\u0134\5B\"\2\u0132\u0134\5D#\2\u0133\u012f\3\2\2\2"+
		"\u0133\u0130\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134?\3"+
		"\2\2\2\u0135\u0136\7\5\2\2\u0136\u0137\5<\37\2\u0137\u0138\7\6\2\2\u0138"+
		"A\3\2\2\2\u0139\u013a\7\5\2\2\u013a\u013b\5<\37\2\u013b\u0141\7\6\2\2"+
		"\u013c\u013d\7\60\2\2\u013d\u013e\7\5\2\2\u013e\u013f\5<\37\2\u013f\u0140"+
		"\7\6\2\2\u0140\u0142\3\2\2\2\u0141\u013c\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144C\3\2\2\2\u0145\u0146\7\61\2\2"+
		"\u0146\u0147\7\5\2\2\u0147\u0148\5<\37\2\u0148\u0149\7\6\2\2\u0149E\3"+
		"\2\2\2\u014a\u014f\5H%\2\u014b\u014f\5J&\2\u014c\u014f\5T+\2\u014d\u014f"+
		"\5P)\2\u014e\u014a\3\2\2\2\u014e\u014b\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014d\3\2\2\2\u014fG\3\2\2\2\u0150\u0151\7Y\2\2\u0151\u0152\7/\2\2\u0152"+
		"\u0153\7Y\2\2\u0153I\3\2\2\2\u0154\u0155\5z>\2\u0155\u015a\5L\'\2\u0156"+
		"\u0157\7\4\2\2\u0157\u0159\5L\'\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2"+
		"\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015bK\3\2\2\2\u015c\u015a"+
		"\3\2\2\2\u015d\u017b\7\34\2\2\u015e\u015f\7\35\2\2\u015f\u017b\5z>\2\u0160"+
		"\u0161\7 \2\2\u0161\u0164\5~@\2\u0162\u0163\7\"\2\2\u0163\u0165\5~@\2"+
		"\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167"+
		"\5N(\2\u0167\u017b\3\2\2\2\u0168\u0169\7$\2\2\u0169\u016c\5~@\2\u016a"+
		"\u016b\7\"\2\2\u016b\u016d\5~@\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2"+
		"\2\u016d\u017b\3\2\2\2\u016e\u016f\7#\2\2\u016f\u0172\5|?\2\u0170\u0171"+
		"\7\"\2\2\u0171\u0173\5~@\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u017b\3\2\2\2\u0174\u0175\7.\2\2\u0175\u017b\5\u0088E\2\u0176\u0177\7"+
		"!\2\2\u0177\u017b\7T\2\2\u0178\u0179\7\33\2\2\u0179\u017b\5\u0080A\2\u017a"+
		"\u015d\3\2\2\2\u017a\u015e\3\2\2\2\u017a\u0160\3\2\2\2\u017a\u0168\3\2"+
		"\2\2\u017a\u016e\3\2\2\2\u017a\u0174\3\2\2\2\u017a\u0176\3\2\2\2\u017a"+
		"\u0178\3\2\2\2\u017bM\3\2\2\2\u017c\u017e\7\'\2\2\u017d\u017c\3\2\2\2"+
		"\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0181\7(\2\2\u0180\u017f"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181O\3\2\2\2\u0182\u0183\7\\\2\2\u0183"+
		"\u0184\7:\2\2\u0184\u0188\5n8\2\u0185\u0186\7\\\2\2\u0186\u0188\5f\64"+
		"\2\u0187\u0182\3\2\2\2\u0187\u0185\3\2\2\2\u0188Q\3\2\2\2\u0189\u018a"+
		"\5T+\2\u018a\u018b\7\3\2\2\u018b\u018d\3\2\2\2\u018c\u0189\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018fS\3\2\2\2"+
		"\u0190\u0194\5V,\2\u0191\u0194\5X-\2\u0192\u0194\5Z.\2\u0193\u0190\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194U\3\2\2\2\u0195\u0196"+
		"\7Y\2\2\u0196\u0197\7*\2\2\u0197\u019a\5~@\2\u0198\u0199\7\4\2\2\u0199"+
		"\u019b\5b\62\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01a6\3\2"+
		"\2\2\u019c\u019d\7Y\2\2\u019d\u019e\7)\2\2\u019e\u01a1\7]\2\2\u019f\u01a0"+
		"\7\4\2\2\u01a0\u01a2\5b\62\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a6\3\2\2\2\u01a3\u01a4\7Y\2\2\u01a4\u01a6\5b\62\2\u01a5\u0195\3\2"+
		"\2\2\u01a5\u019c\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6W\3\2\2\2\u01a7\u01a9"+
		"\7Y\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ab\5\\/\2\u01ab\u01ac\7*\2\2\u01ac\u01af\5~@\2\u01ad\u01ae\7\4\2\2"+
		"\u01ae\u01b0\5b\62\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b9"+
		"\3\2\2\2\u01b1\u01b3\7Y\2\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01b6\5\\/\2\u01b5\u01b7\5b\62\2\u01b6\u01b5\3\2"+
		"\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01a8\3\2\2\2\u01b8"+
		"\u01b2\3\2\2\2\u01b9Y\3\2\2\2\u01ba\u01bc\7Y\2\2\u01bb\u01ba\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\5f\64\2\u01be\u01bf\7*"+
		"\2\2\u01bf\u01c2\5~@\2\u01c0\u01c1\7\4\2\2\u01c1\u01c3\5b\62\2\u01c2\u01c0"+
		"\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01cc\3\2\2\2\u01c4\u01c6\7Y\2\2\u01c5"+
		"\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\5f"+
		"\64\2\u01c8\u01ca\5b\62\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01bb\3\2\2\2\u01cb\u01c5\3\2\2\2\u01cc[\3\2\2\2"+
		"\u01cd\u01ce\7A\2\2\u01ce\u01d3\5^\60\2\u01cf\u01d0\7\4\2\2\u01d0\u01d2"+
		"\5^\60\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7\7B"+
		"\2\2\u01d7]\3\2\2\2\u01d8\u01d9\5~@\2\u01d9\u01da\7\7\2\2\u01da\u01db"+
		"\5`\61\2\u01db\u01de\3\2\2\2\u01dc\u01de\5`\61\2\u01dd\u01d8\3\2\2\2\u01dd"+
		"\u01dc\3\2\2\2\u01de_\3\2\2\2\u01df\u01e0\7Y\2\2\u01e0a\3\2\2\2\u01e1"+
		"\u01e6\5d\63\2\u01e2\u01e3\7\4\2\2\u01e3\u01e5\5d\63\2\u01e4\u01e2\3\2"+
		"\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"c\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\7-\2\2\u01ea\u01ee\5\u0084C"+
		"\2\u01eb\u01ef\7Y\2\2\u01ec\u01ef\7\\\2\2\u01ed\u01ef\5f\64\2\u01ee\u01eb"+
		"\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f3\3\2\2\2\u01f0"+
		"\u01f1\7-\2\2\u01f1\u01f3\7Y\2\2\u01f2\u01e9\3\2\2\2\u01f2\u01f0\3\2\2"+
		"\2\u01f3e\3\2\2\2\u01f4\u01fc\5\u008aF\2\u01f5\u01f6\5h\65\2\u01f6\u01f7"+
		"\5l\67\2\u01f7\u01fc\3\2\2\2\u01f8\u01f9\5j\66\2\u01f9\u01fa\7T\2\2\u01fa"+
		"\u01fc\3\2\2\2\u01fb\u01f4\3\2\2\2\u01fb\u01f5\3\2\2\2\u01fb\u01f8\3\2"+
		"\2\2\u01fcg\3\2\2\2\u01fd\u01fe\t\4\2\2\u01fei\3\2\2\2\u01ff\u0200\t\5"+
		"\2\2\u0200k\3\2\2\2\u0201\u0205\5\u008aF\2\u0202\u0205\7Y\2\2\u0203\u0205"+
		"\7\\\2\2\u0204\u0201\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0203\3\2\2\2\u0205"+
		"m\3\2\2\2\u0206\u0207\b8\1\2\u0207\u0208\5p9\2\u0208\u0214\3\2\2\2\u0209"+
		"\u020a\f\6\2\2\u020a\u020b\7?\2\2\u020b\u0213\5n8\6\u020c\u020d\f\5\2"+
		"\2\u020d\u020e\t\6\2\2\u020e\u0213\5n8\6\u020f\u0210\f\4\2\2\u0210\u0211"+
		"\t\7\2\2\u0211\u0213\5n8\5\u0212\u0209\3\2\2\2\u0212\u020c\3\2\2\2\u0212"+
		"\u020f\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2"+
		"\2\2\u0215o\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u0220\7Y\2\2\u0218\u0220"+
		"\7\\\2\2\u0219\u0220\5r:\2\u021a\u0220\5\u008aF\2\u021b\u021c\7A\2\2\u021c"+
		"\u021d\5n8\2\u021d\u021e\7B\2\2\u021e\u0220\3\2\2\2\u021f\u0217\3\2\2"+
		"\2\u021f\u0218\3\2\2\2\u021f\u0219\3\2\2\2\u021f\u021a\3\2\2\2\u021f\u021b"+
		"\3\2\2\2\u0220q\3\2\2\2\u0221\u0222\5t;\2\u0222\u0224\7A\2\2\u0223\u0225"+
		"\5v<\2\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226"+
		"\u0227\7B\2\2\u0227s\3\2\2\2\u0228\u0229\t\b\2\2\u0229u\3\2\2\2\u022a"+
		"\u022f\5n8\2\u022b\u022c\7\4\2\2\u022c\u022e\5n8\2\u022d\u022b\3\2\2\2"+
		"\u022e\u0231\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230w\3"+
		"\2\2\2\u0231\u022f\3\2\2\2\u0232\u0233\7\24\2\2\u0233\u0242\5\u0084C\2"+
		"\u0234\u0235\7\24\2\2\u0235\u0236\5\u0084C\2\u0236\u0237\7\7\2\2\u0237"+
		"\u0238\7%\2\2\u0238\u0239\7\5\2\2\u0239\u023a\5<\37\2\u023a\u023b\7\6"+
		"\2\2\u023b\u023c\7&\2\2\u023c\u023d\7\5\2\2\u023d\u023e\5T+\2\u023e\u023f"+
		"\7\3\2\2\u023f\u0240\7\6\2\2\u0240\u0242\3\2\2\2\u0241\u0232\3\2\2\2\u0241"+
		"\u0234\3\2\2\2\u0242y\3\2\2\2\u0243\u0247\5|?\2\u0244\u0247\5~@\2\u0245"+
		"\u0247\7Y\2\2\u0246\u0243\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0245\3\2"+
		"\2\2\u0247{\3\2\2\2\u0248\u024b\5\u0082B\2\u0249\u024b\7Y\2\2\u024a\u0248"+
		"\3\2\2\2\u024a\u0249\3\2\2\2\u024b}\3\2\2\2\u024c\u024f\5\u0084C\2\u024d"+
		"\u024f\7Y\2\2\u024e\u024c\3\2\2\2\u024e\u024d\3\2\2\2\u024f\177\3\2\2"+
		"\2\u0250\u0253\5\u0082B\2\u0251\u0253\5\u0084C\2\u0252\u0250\3\2\2\2\u0252"+
		"\u0251\3\2\2\2\u0253\u0081\3\2\2\2\u0254\u0255\7_\2\2\u0255\u0083\3\2"+
		"\2\2\u0256\u025a\7^\2\2\u0257\u025a\5\u0086D\2\u0258\u025a\5\u0092J\2"+
		"\u0259\u0256\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u0258\3\2\2\2\u025a\u0085"+
		"\3\2\2\2\u025b\u025c\t\t\2\2\u025c\u0087\3\2\2\2\u025d\u025e\t\n\2\2\u025e"+
		"\u0089\3\2\2\2\u025f\u0266\7T\2\2\u0260\u0266\7Q\2\2\u0261\u0266\7W\2"+
		"\2\u0262\u0266\7X\2\2\u0263\u0266\5\u008cG\2\u0264\u0266\5\u008eH\2\u0265"+
		"\u025f\3\2\2\2\u0265\u0260\3\2\2\2\u0265\u0261\3\2\2\2\u0265\u0262\3\2"+
		"\2\2\u0265\u0263\3\2\2\2\u0265\u0264\3\2\2\2\u0266\u008b\3\2\2\2\u0267"+
		"\u0269\5\u0090I\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a"+
		"\3\2\2\2\u026a\u026b\7U\2\2\u026b\u008d\3\2\2\2\u026c\u026e\5\u0090I\2"+
		"\u026d\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0270"+
		"\7V\2\2\u0270\u008f\3\2\2\2\u0271\u0272\t\7\2\2\u0272\u0091\3\2\2\2\u0273"+
		"\u0274\t\13\2\2\u0274\u0093\3\2\2\2?\u009a\u00b9\u00c8\u00e4\u00e9\u00ee"+
		"\u00f3\u00fb\u0104\u0109\u0113\u0122\u0126\u012d\u0133\u0143\u014e\u015a"+
		"\u0164\u016c\u0172\u017a\u017d\u0180\u0187\u018e\u0193\u019a\u01a1\u01a5"+
		"\u01a8\u01af\u01b2\u01b6\u01b8\u01bb\u01c2\u01c5\u01c9\u01cb\u01d3\u01dd"+
		"\u01e6\u01ee\u01f2\u01fb\u0204\u0212\u0214\u021f\u0224\u022f\u0241\u0246"+
		"\u024a\u024e\u0252\u0259\u0265\u0268\u026d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}