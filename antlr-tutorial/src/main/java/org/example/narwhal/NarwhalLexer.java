// Generated from java-escape by ANTLR 4.11.1
package org.example.narwhal;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NarwhalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, REPEAT=12, IF=13, FUNCTION=14, READREAL=15, READINT=16, 
		PRINT=17, STRING=18, ID=19, INT=20, REAL=21, NEWLINE=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "REPEAT", "IF", "FUNCTION", "READREAL", "READINT", "PRINT", 
			"STRING", "ID", "INT", "REAL", "NEWLINE", "WS"
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


	public NarwhalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Narwhal.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 22:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u0097\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011p\b\u0011\n\u0011\f\u0011"+
		"s\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012x\b\u0012\u000b"+
		"\u0012\f\u0012y\u0001\u0013\u0004\u0013}\b\u0013\u000b\u0013\f\u0013~"+
		"\u0001\u0014\u0004\u0014\u0082\b\u0014\u000b\u0014\f\u0014\u0083\u0001"+
		"\u0014\u0001\u0014\u0004\u0014\u0088\b\u0014\u000b\u0014\f\u0014\u0089"+
		"\u0001\u0015\u0003\u0015\u008d\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0004\u0016\u0092\b\u0016\u000b\u0016\f\u0016\u0093\u0001\u0016\u0001"+
		"\u0016\u0000\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017\u0001\u0000\u0003\u0002\u0000\"\"\\\\\u0002"+
		"\u0000AZaz\u0002\u0000\t\t  \u009d\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u00031\u0001"+
		"\u0000\u0000\u0000\u00054\u0001\u0000\u0000\u0000\u00076\u0001\u0000\u0000"+
		"\u0000\t8\u0001\u0000\u0000\u0000\u000b:\u0001\u0000\u0000\u0000\r<\u0001"+
		"\u0000\u0000\u0000\u000f>\u0001\u0000\u0000\u0000\u0011@\u0001\u0000\u0000"+
		"\u0000\u0013B\u0001\u0000\u0000\u0000\u0015D\u0001\u0000\u0000\u0000\u0017"+
		"G\u0001\u0000\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bQ\u0001"+
		"\u0000\u0000\u0000\u001dV\u0001\u0000\u0000\u0000\u001f_\u0001\u0000\u0000"+
		"\u0000!g\u0001\u0000\u0000\u0000#m\u0001\u0000\u0000\u0000%w\u0001\u0000"+
		"\u0000\u0000\'|\u0001\u0000\u0000\u0000)\u0081\u0001\u0000\u0000\u0000"+
		"+\u008c\u0001\u0000\u0000\u0000-\u0091\u0001\u0000\u0000\u0000/0\u0005"+
		"=\u0000\u00000\u0002\u0001\u0000\u0000\u000012\u0005(\u0000\u000023\u0005"+
		")\u0000\u00003\u0004\u0001\u0000\u0000\u000045\u0005{\u0000\u00005\u0006"+
		"\u0001\u0000\u0000\u000067\u0005}\u0000\u00007\b\u0001\u0000\u0000\u0000"+
		"89\u0005(\u0000\u00009\n\u0001\u0000\u0000\u0000:;\u0005)\u0000\u0000"+
		";\f\u0001\u0000\u0000\u0000<=\u0005+\u0000\u0000=\u000e\u0001\u0000\u0000"+
		"\u0000>?\u0005-\u0000\u0000?\u0010\u0001\u0000\u0000\u0000@A\u0005*\u0000"+
		"\u0000A\u0012\u0001\u0000\u0000\u0000BC\u0005/\u0000\u0000C\u0014\u0001"+
		"\u0000\u0000\u0000DE\u0005=\u0000\u0000EF\u0005=\u0000\u0000F\u0016\u0001"+
		"\u0000\u0000\u0000GH\u0005r\u0000\u0000HI\u0005e\u0000\u0000IJ\u0005p"+
		"\u0000\u0000JK\u0005e\u0000\u0000KL\u0005a\u0000\u0000LM\u0005t\u0000"+
		"\u0000M\u0018\u0001\u0000\u0000\u0000NO\u0005i\u0000\u0000OP\u0005f\u0000"+
		"\u0000P\u001a\u0001\u0000\u0000\u0000QR\u0005f\u0000\u0000RS\u0005u\u0000"+
		"\u0000ST\u0005n\u0000\u0000TU\u0005c\u0000\u0000U\u001c\u0001\u0000\u0000"+
		"\u0000VW\u0005r\u0000\u0000WX\u0005e\u0000\u0000XY\u0005a\u0000\u0000"+
		"YZ\u0005d\u0000\u0000Z[\u0005R\u0000\u0000[\\\u0005e\u0000\u0000\\]\u0005"+
		"a\u0000\u0000]^\u0005l\u0000\u0000^\u001e\u0001\u0000\u0000\u0000_`\u0005"+
		"r\u0000\u0000`a\u0005e\u0000\u0000ab\u0005a\u0000\u0000bc\u0005d\u0000"+
		"\u0000cd\u0005I\u0000\u0000de\u0005n\u0000\u0000ef\u0005t\u0000\u0000"+
		"f \u0001\u0000\u0000\u0000gh\u0005p\u0000\u0000hi\u0005r\u0000\u0000i"+
		"j\u0005i\u0000\u0000jk\u0005n\u0000\u0000kl\u0005t\u0000\u0000l\"\u0001"+
		"\u0000\u0000\u0000mq\u0005\"\u0000\u0000np\b\u0000\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000tu\u0005\"\u0000\u0000u$\u0001\u0000\u0000\u0000vx\u0007\u0001\u0000"+
		"\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z&\u0001\u0000\u0000\u0000{}\u0002"+
		"09\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f(\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u000209\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0005.\u0000\u0000\u0086\u0088\u000209\u0000\u0087\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a*\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0005\r\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005\n\u0000\u0000\u008f,\u0001\u0000\u0000\u0000\u0090"+
		"\u0092\u0007\u0002\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0006\u0016\u0000\u0000\u0096.\u0001\u0000\u0000\u0000\b\u0000"+
		"qy~\u0083\u0089\u008c\u0093\u0001\u0001\u0016\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}