// Generated from H:/Workspace/antlr-tutorial/src/main/antlr4\SqlBase.g4 by ANTLR 4.10.1
package org.example.sql;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, LETTER=13, ID=14, KEY=15, VALUE=16, TARGET=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "LETTER", "ID", "KEY", "VALUE", "TARGET", "WS"
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


	public SqlBaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0012\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0004\fe\b\f\u000b"+
		"\f\f\ff\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011z\b"+
		"\u0011\u000b\u0011\f\u0011{\u0001\u0011\u0001\u0011\u0000\u0000\u0012"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012\u0001\u0000\u0002\u0002\u0000A"+
		"Zaz\u0003\u0000\t\n\r\r  \u0080\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0001%\u0001\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u0005"+
		".\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t<\u0001\u0000"+
		"\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rH\u0001\u0000\u0000\u0000"+
		"\u000fM\u0001\u0000\u0000\u0000\u0011S\u0001\u0000\u0000\u0000\u0013W"+
		"\u0001\u0000\u0000\u0000\u0015]\u0001\u0000\u0000\u0000\u0017a\u0001\u0000"+
		"\u0000\u0000\u0019d\u0001\u0000\u0000\u0000\u001bh\u0001\u0000\u0000\u0000"+
		"\u001dl\u0001\u0000\u0000\u0000\u001fp\u0001\u0000\u0000\u0000!t\u0001"+
		"\u0000\u0000\u0000#y\u0001\u0000\u0000\u0000%&\u0005s\u0000\u0000&\'\u0005"+
		"e\u0000\u0000\'(\u0005l\u0000\u0000()\u0005e\u0000\u0000)*\u0005c\u0000"+
		"\u0000*+\u0005t\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005;\u0000"+
		"\u0000-\u0004\u0001\u0000\u0000\u0000./\u0005d\u0000\u0000/0\u0005e\u0000"+
		"\u000001\u0005l\u0000\u000012\u0005e\u0000\u000023\u0005t\u0000\u0000"+
		"34\u0005e\u0000\u00004\u0006\u0001\u0000\u0000\u000056\u0005u\u0000\u0000"+
		"67\u0005p\u0000\u000078\u0005d\u0000\u000089\u0005a\u0000\u00009:\u0005"+
		"t\u0000\u0000:;\u0005e\u0000\u0000;\b\u0001\u0000\u0000\u0000<=\u0005"+
		"i\u0000\u0000=>\u0005n\u0000\u0000>?\u0005s\u0000\u0000?@\u0005e\u0000"+
		"\u0000@A\u0005r\u0000\u0000AB\u0005t\u0000\u0000B\n\u0001\u0000\u0000"+
		"\u0000CD\u0005i\u0000\u0000DE\u0005n\u0000\u0000EF\u0005t\u0000\u0000"+
		"FG\u0005o\u0000\u0000G\f\u0001\u0000\u0000\u0000HI\u0005f\u0000\u0000"+
		"IJ\u0005r\u0000\u0000JK\u0005o\u0000\u0000KL\u0005m\u0000\u0000L\u000e"+
		"\u0001\u0000\u0000\u0000MN\u0005w\u0000\u0000NO\u0005h\u0000\u0000OP\u0005"+
		"e\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005e\u0000\u0000R\u0010\u0001\u0000"+
		"\u0000\u0000ST\u0005k\u0000\u0000TU\u0005e\u0000\u0000UV\u0005y\u0000"+
		"\u0000V\u0012\u0001\u0000\u0000\u0000WX\u0005v\u0000\u0000XY\u0005a\u0000"+
		"\u0000YZ\u0005l\u0000\u0000Z[\u0005u\u0000\u0000[\\\u0005e\u0000\u0000"+
		"\\\u0014\u0001\u0000\u0000\u0000]^\u0005a\u0000\u0000^_\u0005l\u0000\u0000"+
		"_`\u0005l\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005=\u0000\u0000"+
		"b\u0018\u0001\u0000\u0000\u0000ce\u0007\u0000\u0000\u0000dc\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000g\u001a\u0001\u0000\u0000\u0000hi\u0003\u0019\f\u0000"+
		"ij\u0005\\\u0000\u0000jk\u0005*\u0000\u0000k\u001c\u0001\u0000\u0000\u0000"+
		"lm\u0005(\u0000\u0000mn\u0003\u0019\f\u0000no\u0005)\u0000\u0000o\u001e"+
		"\u0001\u0000\u0000\u0000pq\u0005{\u0000\u0000qr\u0003\u0019\f\u0000rs"+
		"\u0005}\u0000\u0000s \u0001\u0000\u0000\u0000tu\u0005[\u0000\u0000uv\u0003"+
		"\u0019\f\u0000vw\u0005]\u0000\u0000w\"\u0001\u0000\u0000\u0000xz\u0007"+
		"\u0001\u0000\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0006\u0011\u0000\u0000~$\u0001\u0000\u0000\u0000\u0003\u0000"+
		"f{\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}