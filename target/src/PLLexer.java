// Generated from java-escape by ANTLR 4.11.1

import backend.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, NUMERIC=19, STRING=20, BOOLEAN=21, ID=22, COMMENT=23, WHITESPACE=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "NUMERIC", "STRING", "BOOLEAN", "ID", "COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'let'", "'='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
			"'++'", "'print('", "'for'", "'in'", "'..'", "'{'", "'}'", "'function'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "NUMERIC", "STRING", "BOOLEAN", 
			"ID", "COMMENT", "WHITESPACE"
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


	public PLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PL.g4"; }

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
		"\u0004\u0000\u0018\u00a8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0004\u0012j\b\u0012\u000b\u0012\f\u0012k\u0001"+
		"\u0012\u0001\u0012\u0005\u0012p\b\u0012\n\u0012\f\u0012s\t\u0012\u0003"+
		"\u0012u\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013{\b\u0013\n\u0013\f\u0013~\t\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u008b\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u008f\b\u0015\n\u0015\f\u0015\u0092\t\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0098\b\u0016\n\u0016"+
		"\f\u0016\u009b\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0004\u0017\u00a3\b\u0017\u000b\u0017\f\u0017"+
		"\u00a4\u0001\u0017\u0001\u0017\u0001\u0099\u0000\u0018\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018\u0001\u0000"+
		"\u0004\u0001\u0000\"\"\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000"+
		"\t\n\r\r  \u00b0\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u0003"+
		"3\u0001\u0000\u0000\u0000\u00057\u0001\u0000\u0000\u0000\u00079\u0001"+
		"\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000\u000b=\u0001\u0000\u0000"+
		"\u0000\r?\u0001\u0000\u0000\u0000\u000fA\u0001\u0000\u0000\u0000\u0011"+
		"C\u0001\u0000\u0000\u0000\u0013E\u0001\u0000\u0000\u0000\u0015H\u0001"+
		"\u0000\u0000\u0000\u0017O\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000"+
		"\u0000\u001bV\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f"+
		"[\u0001\u0000\u0000\u0000!]\u0001\u0000\u0000\u0000#f\u0001\u0000\u0000"+
		"\u0000%i\u0001\u0000\u0000\u0000\'v\u0001\u0000\u0000\u0000)\u008a\u0001"+
		"\u0000\u0000\u0000+\u008c\u0001\u0000\u0000\u0000-\u0093\u0001\u0000\u0000"+
		"\u0000/\u00a2\u0001\u0000\u0000\u000012\u0005;\u0000\u00002\u0002\u0001"+
		"\u0000\u0000\u000034\u0005l\u0000\u000045\u0005e\u0000\u000056\u0005t"+
		"\u0000\u00006\u0004\u0001\u0000\u0000\u000078\u0005=\u0000\u00008\u0006"+
		"\u0001\u0000\u0000\u00009:\u0005(\u0000\u0000:\b\u0001\u0000\u0000\u0000"+
		";<\u0005)\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005+\u0000\u0000"+
		">\f\u0001\u0000\u0000\u0000?@\u0005-\u0000\u0000@\u000e\u0001\u0000\u0000"+
		"\u0000AB\u0005*\u0000\u0000B\u0010\u0001\u0000\u0000\u0000CD\u0005/\u0000"+
		"\u0000D\u0012\u0001\u0000\u0000\u0000EF\u0005+\u0000\u0000FG\u0005+\u0000"+
		"\u0000G\u0014\u0001\u0000\u0000\u0000HI\u0005p\u0000\u0000IJ\u0005r\u0000"+
		"\u0000JK\u0005i\u0000\u0000KL\u0005n\u0000\u0000LM\u0005t\u0000\u0000"+
		"MN\u0005(\u0000\u0000N\u0016\u0001\u0000\u0000\u0000OP\u0005f\u0000\u0000"+
		"PQ\u0005o\u0000\u0000QR\u0005r\u0000\u0000R\u0018\u0001\u0000\u0000\u0000"+
		"ST\u0005i\u0000\u0000TU\u0005n\u0000\u0000U\u001a\u0001\u0000\u0000\u0000"+
		"VW\u0005.\u0000\u0000WX\u0005.\u0000\u0000X\u001c\u0001\u0000\u0000\u0000"+
		"YZ\u0005{\u0000\u0000Z\u001e\u0001\u0000\u0000\u0000[\\\u0005}\u0000\u0000"+
		"\\ \u0001\u0000\u0000\u0000]^\u0005f\u0000\u0000^_\u0005u\u0000\u0000"+
		"_`\u0005n\u0000\u0000`a\u0005c\u0000\u0000ab\u0005t\u0000\u0000bc\u0005"+
		"i\u0000\u0000cd\u0005o\u0000\u0000de\u0005n\u0000\u0000e\"\u0001\u0000"+
		"\u0000\u0000fg\u0005,\u0000\u0000g$\u0001\u0000\u0000\u0000hj\u000209"+
		"\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lt\u0001\u0000\u0000\u0000mq\u0005"+
		".\u0000\u0000np\u000209\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000ru\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tm\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u&\u0001\u0000\u0000\u0000v|\u0005\"\u0000\u0000"+
		"wx\u0005\\\u0000\u0000x{\u0005\"\u0000\u0000y{\b\u0000\u0000\u0000zw\u0001"+
		"\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\"\u0000\u0000"+
		"\u0080(\u0001\u0000\u0000\u0000\u0081\u0082\u0005t\u0000\u0000\u0082\u0083"+
		"\u0005r\u0000\u0000\u0083\u0084\u0005u\u0000\u0000\u0084\u008b\u0005e"+
		"\u0000\u0000\u0085\u0086\u0005f\u0000\u0000\u0086\u0087\u0005a\u0000\u0000"+
		"\u0087\u0088\u0005l\u0000\u0000\u0088\u0089\u0005s\u0000\u0000\u0089\u008b"+
		"\u0005e\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000\u008a\u0085\u0001"+
		"\u0000\u0000\u0000\u008b*\u0001\u0000\u0000\u0000\u008c\u0090\u0007\u0001"+
		"\u0000\u0000\u008d\u008f\u0007\u0002\u0000\u0000\u008e\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091,\u0001\u0000\u0000"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005/\u0000\u0000"+
		"\u0094\u0095\u0005*\u0000\u0000\u0095\u0099\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\t\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0005*\u0000\u0000\u009d\u009e\u0005"+
		"/\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u0016"+
		"\u0000\u0000\u00a0.\u0001\u0000\u0000\u0000\u00a1\u00a3\u0007\u0003\u0000"+
		"\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0006\u0017\u0000"+
		"\u0000\u00a70\u0001\u0000\u0000\u0000\n\u0000kqtz|\u008a\u0090\u0099\u00a4"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}