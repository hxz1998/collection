// Generated from H:/Workspace/antlr-tutorial/src/main/antlr4\SqlBase.g4 by ANTLR 4.10.1
package org.example.sql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, LETTER=13, ID=14, KEY=15, VALUE=16, TARGET=17, 
		WS=18;
	public static final int
		RULE_selectStatement = 0, RULE_deleteStatement = 1, RULE_updateStatement = 2, 
		RULE_insertStatement = 3, RULE_fromClause = 4, RULE_whereClause = 5, RULE_selectElements = 6, 
		RULE_deleteElements = 7, RULE_updateElements = 8, RULE_insertElements = 9, 
		RULE_tableName = 10, RULE_specificElements = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "deleteStatement", "updateStatement", "insertStatement", 
			"fromClause", "whereClause", "selectElements", "deleteElements", "updateElements", 
			"insertElements", "tableName", "specificElements"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'select'", "';'", "'delete'", "'update'", "'insert'", "'into'", 
			"'from'", "'where'", "'key'", "'value'", "'all'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "LETTER", "ID", "KEY", "VALUE", "TARGET", "WS"
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
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public SelectElementsContext selectElements() {
			return getRuleContext(SelectElementsContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(T__0);
				setState(25);
				selectElements();
				setState(26);
				fromClause();
				setState(27);
				match(T__1);
				setState(28);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(T__0);
				setState(31);
				selectElements();
				setState(32);
				fromClause();
				setState(33);
				whereClause();
				setState(34);
				match(T__1);
				setState(35);
				match(EOF);
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

	public static class DeleteStatementContext extends ParserRuleContext {
		public DeleteElementsContext deleteElements() {
			return getRuleContext(DeleteElementsContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDeleteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDeleteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_deleteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			deleteElements();
			setState(41);
			fromClause();
			setState(42);
			whereClause();
			setState(43);
			match(T__1);
			setState(44);
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

	public static class UpdateStatementContext extends ParserRuleContext {
		public UpdateElementsContext updateElements() {
			return getRuleContext(UpdateElementsContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUpdateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUpdateStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUpdateStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_updateStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__3);
			setState(47);
			updateElements();
			setState(48);
			fromClause();
			setState(49);
			whereClause();
			setState(50);
			match(T__1);
			setState(51);
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

	public static class InsertStatementContext extends ParserRuleContext {
		public InsertElementsContext insertElements() {
			return getRuleContext(InsertElementsContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInsertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInsertStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInsertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__4);
			setState(54);
			insertElements();
			setState(55);
			match(T__5);
			setState(56);
			fromClause();
			setState(57);
			match(T__1);
			setState(58);
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

	public static class FromClauseContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fromClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__6);
			setState(61);
			tableName();
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

	public static class WhereClauseContext extends ParserRuleContext {
		public SpecificElementsContext specificElements() {
			return getRuleContext(SpecificElementsContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__7);
			setState(64);
			specificElements();
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

	public static class SelectElementsContext extends ParserRuleContext {
		public SelectElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectElementsContext selectElements() throws RecognitionException {
		SelectElementsContext _localctx = new SelectElementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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

	public static class DeleteElementsContext extends ParserRuleContext {
		public DeleteElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDeleteElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDeleteElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDeleteElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteElementsContext deleteElements() throws RecognitionException {
		DeleteElementsContext _localctx = new DeleteElementsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_deleteElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
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

	public static class UpdateElementsContext extends ParserRuleContext {
		public UpdateElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUpdateElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUpdateElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUpdateElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateElementsContext updateElements() throws RecognitionException {
		UpdateElementsContext _localctx = new UpdateElementsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_updateElements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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

	public static class InsertElementsContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(SqlBaseParser.VALUE, 0); }
		public InsertElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInsertElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInsertElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInsertElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertElementsContext insertElements() throws RecognitionException {
		InsertElementsContext _localctx = new InsertElementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_insertElements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(VALUE);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(SqlBaseParser.LETTER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LETTER);
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

	public static class SpecificElementsContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(SqlBaseParser.KEY, 0); }
		public TerminalNode TARGET() { return getToken(SqlBaseParser.TARGET, 0); }
		public SpecificElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSpecificElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSpecificElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSpecificElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificElementsContext specificElements() throws RecognitionException {
		SpecificElementsContext _localctx = new SpecificElementsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_specificElements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(KEY);
			setState(77);
			match(T__11);
			setState(78);
			match(TARGET);
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
		"\u0004\u0001\u0012Q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000&\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0000\u0002\u0001\u0000\t\u000b\u0001\u0000\n\u000bE\u0000%\u0001"+
		"\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004.\u0001\u0000"+
		"\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000"+
		"\n?\u0001\u0000\u0000\u0000\fB\u0001\u0000\u0000\u0000\u000eD\u0001\u0000"+
		"\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012H\u0001\u0000\u0000\u0000"+
		"\u0014J\u0001\u0000\u0000\u0000\u0016L\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0005\u0001\u0000\u0000\u0019\u001a\u0003\f\u0006\u0000\u001a\u001b\u0003"+
		"\b\u0004\u0000\u001b\u001c\u0005\u0002\u0000\u0000\u001c\u001d\u0005\u0000"+
		"\u0000\u0001\u001d&\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000"+
		"\u0000\u001f \u0003\f\u0006\u0000 !\u0003\b\u0004\u0000!\"\u0003\n\u0005"+
		"\u0000\"#\u0005\u0002\u0000\u0000#$\u0005\u0000\u0000\u0001$&\u0001\u0000"+
		"\u0000\u0000%\u0018\u0001\u0000\u0000\u0000%\u001e\u0001\u0000\u0000\u0000"+
		"&\u0001\u0001\u0000\u0000\u0000\'(\u0005\u0003\u0000\u0000()\u0003\u000e"+
		"\u0007\u0000)*\u0003\b\u0004\u0000*+\u0003\n\u0005\u0000+,\u0005\u0002"+
		"\u0000\u0000,-\u0005\u0000\u0000\u0001-\u0003\u0001\u0000\u0000\u0000"+
		"./\u0005\u0004\u0000\u0000/0\u0003\u0010\b\u000001\u0003\b\u0004\u0000"+
		"12\u0003\n\u0005\u000023\u0005\u0002\u0000\u000034\u0005\u0000\u0000\u0001"+
		"4\u0005\u0001\u0000\u0000\u000056\u0005\u0005\u0000\u000067\u0003\u0012"+
		"\t\u000078\u0005\u0006\u0000\u000089\u0003\b\u0004\u00009:\u0005\u0002"+
		"\u0000\u0000:;\u0005\u0000\u0000\u0001;\u0007\u0001\u0000\u0000\u0000"+
		"<=\u0005\u0007\u0000\u0000=>\u0003\u0014\n\u0000>\t\u0001\u0000\u0000"+
		"\u0000?@\u0005\b\u0000\u0000@A\u0003\u0016\u000b\u0000A\u000b\u0001\u0000"+
		"\u0000\u0000BC\u0007\u0000\u0000\u0000C\r\u0001\u0000\u0000\u0000DE\u0007"+
		"\u0001\u0000\u0000E\u000f\u0001\u0000\u0000\u0000FG\u0005\n\u0000\u0000"+
		"G\u0011\u0001\u0000\u0000\u0000HI\u0005\u0010\u0000\u0000I\u0013\u0001"+
		"\u0000\u0000\u0000JK\u0005\r\u0000\u0000K\u0015\u0001\u0000\u0000\u0000"+
		"LM\u0005\u000f\u0000\u0000MN\u0005\f\u0000\u0000NO\u0005\u0011\u0000\u0000"+
		"O\u0017\u0001\u0000\u0000\u0000\u0001%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}