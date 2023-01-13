// Generated from java-escape by ANTLR 4.11.1
package org.example.narwhal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NarwhalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, REPEAT=12, IF=13, FUNCTION=14, READREAL=15, READINT=16, 
		PRINT=17, STRING=18, ID=19, INT=20, REAL=21, NEWLINE=22, WS=23;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_stat = 2, RULE_value = 3, RULE_expression = 4, 
		RULE_term = 5, RULE_factor = 6, RULE_lp = 7, RULE_rp = 8, RULE_add = 9, 
		RULE_sub = 10, RULE_mul = 11, RULE_div = 12, RULE_function = 13, RULE_equal = 14, 
		RULE_blockif = 15, RULE_repetitions = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "block", "stat", "value", "expression", "term", "factor", "lp", 
			"rp", "add", "sub", "mul", "div", "function", "equal", "blockif", "repetitions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'()'", "'{'", "'}'", "'('", "')'", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'repeat'", "'if'", "'func'", "'readReal'", "'readInt'", 
			"'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"REPEAT", "IF", "FUNCTION", "READREAL", "READINT", "PRINT", "STRING", 
			"ID", "INT", "REAL", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NarwhalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(NarwhalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(NarwhalParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4976640L) != 0) {
				{
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case REPEAT:
				case IF:
				case READREAL:
				case READINT:
				case PRINT:
				case ID:
					{
					setState(34);
					stat();
					}
					break;
				case FUNCTION:
					{
					setState(35);
					function();
					}
					break;
				case NEWLINE:
					break;
				default:
					break;
				}
				{
				setState(38);
				match(NEWLINE);
				}
				}
				}
				setState(43);
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
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(NarwhalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(NarwhalParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4960256L) != 0) {
				{
				{
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 765952L) != 0) {
					{
					setState(44);
					stat();
					}
				}

				setState(47);
				match(NEWLINE);
				}
				}
				setState(52);
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
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends StatContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public CallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StatContext {
		public TerminalNode PRINT() { return getToken(NarwhalParser.PRINT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatContext extends StatContext {
		public TerminalNode REPEAT() { return getToken(NarwhalParser.REPEAT, 0); }
		public RepetitionsContext repetitions() {
			return getRuleContext(RepetitionsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepeatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitRepeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAssignContext extends StatContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprAssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitExprAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitExprAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadIntContext extends StatContext {
		public TerminalNode READINT() { return getToken(NarwhalParser.READINT, 0); }
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public ReadIntContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterReadInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitReadInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitReadInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadRealContext extends StatContext {
		public TerminalNode READREAL() { return getToken(NarwhalParser.READREAL, 0); }
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public ReadRealContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterReadReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitReadReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitReadReal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends StatContext {
		public TerminalNode IF() { return getToken(NarwhalParser.IF, 0); }
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public BlockifContext blockif() {
			return getRuleContext(BlockifContext.class,0);
		}
		public IfContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StatContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(PRINT);
				setState(54);
				value();
				}
				break;
			case 2:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(ID);
				setState(56);
				match(T__0);
				setState(57);
				value();
				}
				break;
			case 3:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(ID);
				setState(59);
				match(T__0);
				setState(60);
				expression();
				}
				break;
			case 4:
				_localctx = new ReadIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(READINT);
				setState(62);
				match(ID);
				}
				break;
			case 5:
				_localctx = new ReadRealContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				match(READREAL);
				setState(64);
				match(ID);
				}
				break;
			case 6:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				match(ID);
				setState(66);
				match(T__1);
				}
				break;
			case 7:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
				match(IF);
				setState(68);
				equal();
				setState(69);
				match(T__2);
				setState(70);
				blockif();
				setState(71);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new RepeatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				match(REPEAT);
				setState(74);
				repetitions();
				setState(75);
				match(T__2);
				setState(76);
				block();
				setState(77);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public TerminalNode STRING() { return getToken(NarwhalParser.STRING, 0); }
		public TerminalNode INT() { return getToken(NarwhalParser.INT, 0); }
		public TerminalNode REAL() { return getToken(NarwhalParser.REAL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0) ) {
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public List<SubContext> sub() {
			return getRuleContexts(SubContext.class);
		}
		public SubContext sub(int i) {
			return getRuleContext(SubContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			term();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__7) {
				{
				{
				setState(86);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(84);
					add();
					}
					break;
				case T__7:
					{
					setState(85);
					sub();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(88);
				term();
				}
				}
				setState(94);
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
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulContext> mul() {
			return getRuleContexts(MulContext.class);
		}
		public MulContext mul(int i) {
			return getRuleContext(MulContext.class,i);
		}
		public List<DivContext> div() {
			return getRuleContexts(DivContext.class);
		}
		public DivContext div(int i) {
			return getRuleContext(DivContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			factor();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				{
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(96);
					mul();
					}
					break;
				case T__9:
					{
					setState(97);
					div();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100);
				factor();
				}
				}
				setState(106);
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
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExContext extends FactorContext {
		public LpContext lp() {
			return getRuleContext(LpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ExContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitEx(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealContext extends FactorContext {
		public TerminalNode REAL() { return getToken(NarwhalParser.REAL, 0); }
		public RealContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends FactorContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public IdContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends FactorContext {
		public TerminalNode INT() { return getToken(NarwhalParser.INT, 0); }
		public IntContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new ExContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				lp();
				setState(108);
				expression();
				setState(109);
				rp();
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(INT);
				}
				break;
			case REAL:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(REAL);
				}
				break;
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(ID);
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
	public static class LpContext extends ParserRuleContext {
		public LpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterLp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitLp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitLp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LpContext lp() throws RecognitionException {
		LpContext _localctx = new LpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__4);
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
	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		RpContext _localctx = new RpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__5);
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
	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__6);
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
	public static class SubContext extends ParserRuleContext {
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__7);
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
	public static class MulContext extends ParserRuleContext {
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		MulContext _localctx = new MulContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mul);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__8);
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
	public static class DivContext extends ParserRuleContext {
		public DivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_div; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivContext div() throws RecognitionException {
		DivContext _localctx = new DivContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_div);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__9);
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(NarwhalParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(FUNCTION);
			setState(129);
			match(ID);
			setState(130);
			match(T__1);
			setState(131);
			match(T__2);
			setState(132);
			block();
			setState(133);
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
	public static class EqualContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public TerminalNode INT() { return getToken(NarwhalParser.INT, 0); }
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_equal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ID);
			setState(136);
			match(T__10);
			setState(137);
			match(INT);
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
	public static class BlockifContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterBlockif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitBlockif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitBlockif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockifContext blockif() throws RecognitionException {
		BlockifContext _localctx = new BlockifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			block();
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
	public static class RepetitionsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NarwhalParser.ID, 0); }
		public RepetitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).enterRepetitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NarwhalListener ) ((NarwhalListener)listener).exitRepetitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NarwhalVisitor ) return ((NarwhalVisitor<? extends T>)visitor).visitRepetitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepetitionsContext repetitions() throws RecognitionException {
		RepetitionsContext _localctx = new RepetitionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_repetitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u0090\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0003\u0000%\b"+
		"\u0000\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001"+
		"\u0001\u0003\u0001.\b\u0001\u0001\u0001\u0005\u00011\b\u0001\n\u0001\f"+
		"\u00014\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002P\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004W\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004[\b\u0004\n\u0004\f\u0004^\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005g\b\u0005\n\u0005\f\u0005j\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006s\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0001\u0001\u0000\u0012"+
		"\u0015\u0091\u0000)\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000"+
		"\u0004O\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bS\u0001"+
		"\u0000\u0000\u0000\n_\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000\u0000"+
		"\u000et\u0001\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012x"+
		"\u0001\u0000\u0000\u0000\u0014z\u0001\u0000\u0000\u0000\u0016|\u0001\u0000"+
		"\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u0080\u0001\u0000\u0000"+
		"\u0000\u001c\u0087\u0001\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000"+
		"\u0000 \u008d\u0001\u0000\u0000\u0000\"%\u0003\u0004\u0002\u0000#%\u0003"+
		"\u001a\r\u0000$\"\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000$%"+
		"\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0005\u0016\u0000"+
		"\u0000\'$\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*\u0001\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000,.\u0003\u0004\u0002\u0000-,\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0005\u0016"+
		"\u0000\u00000-\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000056\u0005\u0011\u0000\u00006P\u0003\u0006"+
		"\u0003\u000078\u0005\u0013\u0000\u000089\u0005\u0001\u0000\u00009P\u0003"+
		"\u0006\u0003\u0000:;\u0005\u0013\u0000\u0000;<\u0005\u0001\u0000\u0000"+
		"<P\u0003\b\u0004\u0000=>\u0005\u0010\u0000\u0000>P\u0005\u0013\u0000\u0000"+
		"?@\u0005\u000f\u0000\u0000@P\u0005\u0013\u0000\u0000AB\u0005\u0013\u0000"+
		"\u0000BP\u0005\u0002\u0000\u0000CD\u0005\r\u0000\u0000DE\u0003\u001c\u000e"+
		"\u0000EF\u0005\u0003\u0000\u0000FG\u0003\u001e\u000f\u0000GH\u0005\u0004"+
		"\u0000\u0000HP\u0001\u0000\u0000\u0000IJ\u0005\f\u0000\u0000JK\u0003 "+
		"\u0010\u0000KL\u0005\u0003\u0000\u0000LM\u0003\u0002\u0001\u0000MN\u0005"+
		"\u0004\u0000\u0000NP\u0001\u0000\u0000\u0000O5\u0001\u0000\u0000\u0000"+
		"O7\u0001\u0000\u0000\u0000O:\u0001\u0000\u0000\u0000O=\u0001\u0000\u0000"+
		"\u0000O?\u0001\u0000\u0000\u0000OA\u0001\u0000\u0000\u0000OC\u0001\u0000"+
		"\u0000\u0000OI\u0001\u0000\u0000\u0000P\u0005\u0001\u0000\u0000\u0000"+
		"QR\u0007\u0000\u0000\u0000R\u0007\u0001\u0000\u0000\u0000S\\\u0003\n\u0005"+
		"\u0000TW\u0003\u0012\t\u0000UW\u0003\u0014\n\u0000VT\u0001\u0000\u0000"+
		"\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0003\n\u0005"+
		"\u0000Y[\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000[^\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\t"+
		"\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_h\u0003\f\u0006\u0000"+
		"`c\u0003\u0016\u000b\u0000ac\u0003\u0018\f\u0000b`\u0001\u0000\u0000\u0000"+
		"ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0003\f\u0006\u0000"+
		"eg\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u000b\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0003\u000e\u0007\u0000"+
		"lm\u0003\b\u0004\u0000mn\u0003\u0010\b\u0000ns\u0001\u0000\u0000\u0000"+
		"os\u0005\u0014\u0000\u0000ps\u0005\u0015\u0000\u0000qs\u0005\u0013\u0000"+
		"\u0000rk\u0001\u0000\u0000\u0000ro\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rq\u0001\u0000\u0000\u0000s\r\u0001\u0000\u0000\u0000tu\u0005"+
		"\u0005\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vw\u0005\u0006\u0000"+
		"\u0000w\u0011\u0001\u0000\u0000\u0000xy\u0005\u0007\u0000\u0000y\u0013"+
		"\u0001\u0000\u0000\u0000z{\u0005\b\u0000\u0000{\u0015\u0001\u0000\u0000"+
		"\u0000|}\u0005\t\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\n\u0000\u0000\u007f\u0019\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u000e"+
		"\u0000\u0000\u0081\u0082\u0005\u0013\u0000\u0000\u0082\u0083\u0005\u0002"+
		"\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u0085\u0003\u0002"+
		"\u0001\u0000\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u001b\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u0013\u0000\u0000\u0088\u0089\u0005\u000b"+
		"\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a\u001d\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0003\u0002\u0001\u0000\u008c\u001f\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u0013\u0000\u0000\u008e!\u0001\u0000\u0000"+
		"\u0000\n$)-2OV\\bhr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}