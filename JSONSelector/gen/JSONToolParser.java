// Generated from H:/Workspace/JSONSelector/antlr4\JSONTool.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JSONToolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, IDENTIFIER=5;
	public static final int
		RULE_start = 0, RULE_compareRule = 1, RULE_keyList = 2, RULE_key = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "compareRule", "keyList", "key"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compare'", "'and'", "'print'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "IDENTIFIER"
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
	public String getGrammarFileName() { return "JSONTool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSONToolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public CompareRuleContext compareRule() {
			return getRuleContext(CompareRuleContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JSONToolParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONToolVisitor ) return ((JSONToolVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			compareRule();
			setState(9);
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
	public static class CompareRuleContext extends ParserRuleContext {
		public KeyListContext keyList() {
			return getRuleContext(KeyListContext.class,0);
		}
		public CompareRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).enterCompareRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).exitCompareRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONToolVisitor ) return ((JSONToolVisitor<? extends T>)visitor).visitCompareRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareRuleContext compareRule() throws RecognitionException {
		CompareRuleContext _localctx = new CompareRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_compareRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			match(T__0);
			setState(12);
			keyList();
			setState(13);
			match(T__1);
			setState(14);
			match(T__2);
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
	public static class KeyListContext extends ParserRuleContext {
		public List<KeyContext> key() {
			return getRuleContexts(KeyContext.class);
		}
		public KeyContext key(int i) {
			return getRuleContext(KeyContext.class,i);
		}
		public KeyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).enterKeyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).exitKeyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONToolVisitor ) return ((JSONToolVisitor<? extends T>)visitor).visitKeyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyListContext keyList() throws RecognitionException {
		KeyListContext _localctx = new KeyListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			key();
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(17);
				match(T__3);
				setState(18);
				key();
				}
				}
				setState(23);
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
	public static class KeyContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JSONToolParser.IDENTIFIER, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONToolListener ) ((JSONToolListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONToolVisitor ) return ((JSONToolVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(IDENTIFIER);
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
		"\u0004\u0001\u0005\u001b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0014\b\u0002\n\u0002"+
		"\f\u0002\u0017\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000"+
		"\u0004\u0000\u0002\u0004\u0006\u0000\u0000\u0017\u0000\b\u0001\u0000\u0000"+
		"\u0000\u0002\u000b\u0001\u0000\u0000\u0000\u0004\u0010\u0001\u0000\u0000"+
		"\u0000\u0006\u0018\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000"+
		"\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000\u000b\f\u0005"+
		"\u0001\u0000\u0000\f\r\u0003\u0004\u0002\u0000\r\u000e\u0005\u0002\u0000"+
		"\u0000\u000e\u000f\u0005\u0003\u0000\u0000\u000f\u0003\u0001\u0000\u0000"+
		"\u0000\u0010\u0015\u0003\u0006\u0003\u0000\u0011\u0012\u0005\u0004\u0000"+
		"\u0000\u0012\u0014\u0003\u0006\u0003\u0000\u0013\u0011\u0001\u0000\u0000"+
		"\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0005\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0005\u0000"+
		"\u0000\u0019\u0007\u0001\u0000\u0000\u0000\u0001\u0015";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}