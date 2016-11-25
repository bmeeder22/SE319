// Generated from JSON.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSON extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VISA=1, MASTERCARD=2, AMERICAN_EXPRESS=3, DINERS_CLUB=4, DISCOVER=5, JCB=6, 
		TOKEN_START=7, TOKEN_END=8, BAD_ELEMENT_NAME=9, EMAIL_ELEMENT=10, DATE_ELEMENT=11, 
		PHONE_ELEMENT=12, CREDIT_CARD_ELEMENT=13, OTHER_ELEMENT=14, DONOTHING=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "DIGIT", "NEWLINE", "CARRIAGER", "DASH", "SPACE", "UNDERSCORE", 
		"PERIOD", "COMMA", "SEPARATOR", "SPECIALCHAR", "ALT_XML", "DATE_NAME", 
		"EMAIL_NAME", "PHONE_NAME", "CREDIT_CARD_NAME", "ELEMENT_NAME", "EMAIL_CONTENTS", 
		"LOCAL_PART", "DOMAIN_PART", "DATE_CONTENTS", "DAY", "MONTH", "YEAR", 
		"PHONE_CONTENTS", "CREDIT_CARD_CONTENTS", "ELEVEN_DIGIT", "TWELVE_DIGIT", 
		"THIRTEEN_DIGIT", "FOURTEEN_DIGIT", "FIFTEEN_DIGIT", "VISA", "MASTERCARD", 
		"AMERICAN_EXPRESS", "DINERS_CLUB", "DISCOVER", "JCB", "OTHER_CONTENTS", 
		"TOKEN_START", "TOKEN_END", "BAD_ELEMENT_NAME", "EMAIL_ELEMENT", "DATE_ELEMENT", 
		"PHONE_ELEMENT", "CREDIT_CARD_ELEMENT", "OTHER_ELEMENT", "DONOTHING"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VISA", "MASTERCARD", "AMERICAN_EXPRESS", "DINERS_CLUB", "DISCOVER", 
		"JCB", "TOKEN_START", "TOKEN_END", "BAD_ELEMENT_NAME", "EMAIL_ELEMENT", 
		"DATE_ELEMENT", "PHONE_ELEMENT", "CREDIT_CARD_ELEMENT", "OTHER_ELEMENT", 
		"DONOTHING"
	};
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


	public JSON(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 38:
			TOKEN_START_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			TOKEN_END_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			BAD_ELEMENT_NAME_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			EMAIL_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			DATE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			PHONE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
			CREDIT_CARD_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			OTHER_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			DONOTHING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TOKEN_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

				System.out.println("---------------Start Token---------------");

			break;
		}
	}
	private void TOKEN_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

				System.out.println("----------------End Token----------------");

			break;
		}
	}
	private void BAD_ELEMENT_NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

				System.out.println("Bad Element Name: " + getText() + " - cannot contain 'XML' or a variation of it.");

			break;
		}
	}
	private void EMAIL_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:

					System.out.println("Email found: " + getText()); 
			break;
		case 4:

					System.out.println("Bad email element format: " + getText());
				
			break;
		}
	}
	private void DATE_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:

					System.out.println("Date found: " + getText()); 
			break;
		case 6:

					System.out.println("Bad date element format: " + getText());
				
			break;
		}
	}
	private void PHONE_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:

					System.out.println("Phone number found: " + getText()); 
			break;
		case 8:

					System.out.println("Bad phone element format: " + getText());
				
			break;
		}
	}
	private void CREDIT_CARD_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:

					System.out.println("Credit card found: " + getText()); 
			break;
		case 10:

					System.out.println("Bad credit card element format: " + getText());
				
			break;
		}
	}
	private void OTHER_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:

					System.out.println("Custom element found: " + getText()); 
			break;
		case 12:

					System.out.println("Bad custom element format: " + getText());
				
			break;
		}
	}
	private void DONOTHING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u028d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\7\13u\n\13\f\13\16\13x\13"+
		"\13\3\13\3\13\7\13|\n\13\f\13\16\13\177\13\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\6\22\u00a5\n\22\r\22\16\22\u00a6\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u00ae\n\22\f\22\16\22\u00b1\13\22\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\6\24\u00ba\n\24\r\24\16\24\u00bb\3\24\3\24\3\24\3\24\6\24\u00c2\n"+
		"\24\r\24\16\24\u00c3\7\24\u00c6\n\24\f\24\16\24\u00c9\13\24\3\25\3\25"+
		"\3\25\3\25\6\25\u00cf\n\25\r\25\16\25\u00d0\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00df\n\27\3\30\3\30\3\30\3\30"+
		"\5\30\u00e5\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00ef\n"+
		"\31\3\32\7\32\u00f2\n\32\f\32\16\32\u00f5\13\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u00fc\n\32\f\32\16\32\u00ff\13\32\3\32\3\32\3\32\5\32\u0104\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u010c\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0119\n\33\3\34\7\34\u011c\n"+
		"\34\f\34\16\34\u011f\13\34\3\34\3\34\7\34\u0123\n\34\f\34\16\34\u0126"+
		"\13\34\3\34\3\34\7\34\u012a\n\34\f\34\16\34\u012d\13\34\3\34\3\34\7\34"+
		"\u0131\n\34\f\34\16\34\u0134\13\34\3\34\3\34\7\34\u0138\n\34\f\34\16\34"+
		"\u013b\13\34\3\34\3\34\7\34\u013f\n\34\f\34\16\34\u0142\13\34\3\34\3\34"+
		"\7\34\u0146\n\34\f\34\16\34\u0149\13\34\3\34\3\34\7\34\u014d\n\34\f\34"+
		"\16\34\u0150\13\34\3\34\3\34\7\34\u0154\n\34\f\34\16\34\u0157\13\34\3"+
		"\34\3\34\7\34\u015b\n\34\f\34\16\34\u015e\13\34\3\34\3\34\7\34\u0162\n"+
		"\34\f\34\16\34\u0165\13\34\3\34\3\34\3\35\3\35\7\35\u016b\n\35\f\35\16"+
		"\35\u016e\13\35\3\35\3\35\3\36\3\36\7\36\u0174\n\36\f\36\16\36\u0177\13"+
		"\36\3\36\3\36\3\37\3\37\7\37\u017d\n\37\f\37\16\37\u0180\13\37\3\37\3"+
		"\37\3 \3 \7 \u0186\n \f \16 \u0189\13 \3 \3 \3!\3!\3!\5!\u0190\n!\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\5$\u01a0\n$\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\5%\u01ac\n%\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01b6\n&\3&\3&"+
		"\3&\3&\3&\5&\u01bd\n&\3\'\3\'\3\'\3\'\7\'\u01c3\n\'\f\'\16\'\u01c6\13"+
		"\'\3(\3(\7(\u01ca\n(\f(\16(\u01cd\13(\3(\7(\u01d0\n(\f(\16(\u01d3\13("+
		"\3(\3(\3)\7)\u01d8\n)\f)\16)\u01db\13)\3)\7)\u01de\n)\f)\16)\u01e1\13"+
		")\3)\3)\7)\u01e5\n)\f)\16)\u01e8\13)\3)\7)\u01eb\n)\f)\16)\u01ee\13)\3"+
		")\3)\3*\3*\7*\u01f4\n*\f*\16*\u01f7\13*\3*\3*\7*\u01fb\n*\f*\16*\u01fe"+
		"\13*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u0212\n"+
		"+\f+\16+\u0215\13+\3+\3+\3+\5+\u021a\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\7,\u022b\n,\f,\16,\u022e\13,\3,\3,\3,\5,\u0233\n,\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0244\n-\f-\16-\u0247\13-"+
		"\3-\3-\3-\5-\u024c\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7."+
		"\u025d\n.\f.\16.\u0260\13.\3.\3.\3.\5.\u0265\n.\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\7/\u0272\n/\f/\16/\u0275\13/\3/\3/\3/\3/\7/\u027b\n/\f/\16"+
		"/\u027e\13/\3/\3/\3/\5/\u0283\n/\3\60\3\60\3\60\6\60\u0288\n\60\r\60\16"+
		"\60\u0289\3\60\3\60\b\u01fc\u0213\u022c\u0245\u025e\u027c\2\61\3\2\5\2"+
		"\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%"+
		"\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\3C\4E\5G\6I\7K\bM"+
		"\2O\tQ\nS\13U\fW\rY\16[\17]\20_\21\3\2\33\4\2C\\c|\3\2\62;\t\2##&&(/<"+
		"=??aa\u0080\u0080\4\2ZZzz\4\2OOoo\4\2NNnn\4\2FFff\4\2CCcc\4\2VVvv\4\2"+
		"GGgg\4\2KKkk\4\2RRrr\4\2JJjj\4\2QQqq\4\2PPpp\4\2EEee\4\2TTtt\3\2\63;\3"+
		"\2\63\64\3\2\62\63\3\2\62\64\3\2\63\67\4\2\66\6699\3\2\62\67\4\288::\u02be"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3\2\2\2\tg\3\2\2\2"+
		"\13i\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23q\3\2\2\2\25v\3\2\2"+
		"\2\27\u0080\3\2\2\2\31\u0082\3\2\2\2\33\u0086\3\2\2\2\35\u008b\3\2\2\2"+
		"\37\u0091\3\2\2\2!\u0097\3\2\2\2#\u00a4\3\2\2\2%\u00b2\3\2\2\2\'\u00b9"+
		"\3\2\2\2)\u00ce\3\2\2\2+\u00d2\3\2\2\2-\u00de\3\2\2\2/\u00e4\3\2\2\2\61"+
		"\u00e6\3\2\2\2\63\u00f3\3\2\2\2\65\u0118\3\2\2\2\67\u011d\3\2\2\29\u0168"+
		"\3\2\2\2;\u0171\3\2\2\2=\u017a\3\2\2\2?\u0183\3\2\2\2A\u018c\3\2\2\2C"+
		"\u0191\3\2\2\2E\u0195\3\2\2\2G\u0199\3\2\2\2I\u01ab\3\2\2\2K\u01bc\3\2"+
		"\2\2M\u01c4\3\2\2\2O\u01c7\3\2\2\2Q\u01d9\3\2\2\2S\u01f1\3\2\2\2U\u0219"+
		"\3\2\2\2W\u0232\3\2\2\2Y\u024b\3\2\2\2[\u0264\3\2\2\2]\u0282\3\2\2\2_"+
		"\u0287\3\2\2\2ab\t\2\2\2b\4\3\2\2\2cd\t\3\2\2d\6\3\2\2\2ef\7\f\2\2f\b"+
		"\3\2\2\2gh\7\17\2\2h\n\3\2\2\2ij\7/\2\2j\f\3\2\2\2kl\7\"\2\2l\16\3\2\2"+
		"\2mn\7a\2\2n\20\3\2\2\2op\7\60\2\2p\22\3\2\2\2qr\7.\2\2r\24\3\2\2\2su"+
		"\7\"\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y"+
		"}\7<\2\2z|\7\"\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\26\3\2"+
		"\2\2\177}\3\2\2\2\u0080\u0081\t\4\2\2\u0081\30\3\2\2\2\u0082\u0083\t\5"+
		"\2\2\u0083\u0084\t\6\2\2\u0084\u0085\t\7\2\2\u0085\32\3\2\2\2\u0086\u0087"+
		"\t\b\2\2\u0087\u0088\t\t\2\2\u0088\u0089\t\n\2\2\u0089\u008a\t\13\2\2"+
		"\u008a\34\3\2\2\2\u008b\u008c\t\13\2\2\u008c\u008d\t\6\2\2\u008d\u008e"+
		"\t\t\2\2\u008e\u008f\t\f\2\2\u008f\u0090\t\7\2\2\u0090\36\3\2\2\2\u0091"+
		"\u0092\t\r\2\2\u0092\u0093\t\16\2\2\u0093\u0094\t\17\2\2\u0094\u0095\t"+
		"\20\2\2\u0095\u0096\t\13\2\2\u0096 \3\2\2\2\u0097\u0098\t\21\2\2\u0098"+
		"\u0099\t\22\2\2\u0099\u009a\t\13\2\2\u009a\u009b\t\b\2\2\u009b\u009c\t"+
		"\f\2\2\u009c\u009d\t\n\2\2\u009d\u009e\t\21\2\2\u009e\u009f\t\t\2\2\u009f"+
		"\u00a0\t\22\2\2\u00a0\u00a1\t\b\2\2\u00a1\"\3\2\2\2\u00a2\u00a5\5\3\2"+
		"\2\u00a3\u00a5\5\17\b\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00af\3\2"+
		"\2\2\u00a8\u00ae\5\3\2\2\u00a9\u00ae\5\5\3\2\u00aa\u00ae\5\13\6\2\u00ab"+
		"\u00ae\5\17\b\2\u00ac\u00ae\5\21\t\2\u00ad\u00a8\3\2\2\2\u00ad\u00a9\3"+
		"\2\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0$\3\2\2\2"+
		"\u00b1\u00af\3\2\2\2\u00b2\u00b3\5\'\24\2\u00b3\u00b4\7B\2\2\u00b4\u00b5"+
		"\5)\25\2\u00b5&\3\2\2\2\u00b6\u00ba\5\3\2\2\u00b7\u00ba\5\5\3\2\u00b8"+
		"\u00ba\5\27\f\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3"+
		"\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00c7\3\2\2\2\u00bd\u00c1\5\21\t\2\u00be\u00c2\5\3\2\2\u00bf\u00c2\5"+
		"\5\3\2\u00c0\u00c2\5\27\f\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8(\3\2\2\2\u00c9\u00c7\3\2\2\2"+
		"\u00ca\u00cf\5\3\2\2\u00cb\u00cf\5\5\3\2\u00cc\u00cf\5\13\6\2\u00cd\u00cf"+
		"\5\21\t\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2"+
		"\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1*\3\2\2\2\u00d2\u00d3\5-\27\2\u00d3\u00d4\7\61\2\2\u00d4"+
		"\u00d5\5/\30\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\5\61\31\2\u00d7,\3\2\2"+
		"\2\u00d8\u00d9\7\62\2\2\u00d9\u00df\t\23\2\2\u00da\u00db\t\24\2\2\u00db"+
		"\u00df\5\5\3\2\u00dc\u00dd\7\65\2\2\u00dd\u00df\t\25\2\2\u00de\u00d8\3"+
		"\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df.\3\2\2\2\u00e0\u00e1"+
		"\7\62\2\2\u00e1\u00e5\t\23\2\2\u00e2\u00e3\7\63\2\2\u00e3\u00e5\t\26\2"+
		"\2\u00e4\u00e0\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\60\3\2\2\2\u00e6\u00ee"+
		"\7\64\2\2\u00e7\u00e8\7\62\2\2\u00e8\u00e9\5\5\3\2\u00e9\u00ea\5\5\3\2"+
		"\u00ea\u00ef\3\2\2\2\u00eb\u00ec\7\63\2\2\u00ec\u00ed\7\62\2\2\u00ed\u00ef"+
		"\7\62\2\2\u00ee\u00e7\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ef\62\3\2\2\2\u00f0"+
		"\u00f2\7*\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\5\5\3\2\u00f7\u00f8\5\5\3\2\u00f8\u0103\5\5\3\2\u00f9\u00fd\7+"+
		"\2\2\u00fa\u00fc\5\r\7\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0104\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u0100\u0104\5\13\6\2\u0101\u0104\5\21\t\2\u0102\u0104\5\r\7\2\u0103"+
		"\u00f9\3\2\2\2\u0103\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0106\5\5\3\2\u0106\u0107\5\5\3\2\u0107"+
		"\u010b\5\5\3\2\u0108\u010c\5\13\6\2\u0109\u010c\5\21\t\2\u010a\u010c\5"+
		"\r\7\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010e\5\5\3\2\u010e\u010f\5\5\3\2\u010f\u0110\5\5"+
		"\3\2\u0110\u0111\5\5\3\2\u0111\64\3\2\2\2\u0112\u0119\5A!\2\u0113\u0119"+
		"\5C\"\2\u0114\u0119\5E#\2\u0115\u0119\5G$\2\u0116\u0119\5I%\2\u0117\u0119"+
		"\5K&\2\u0118\u0112\3\2\2\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118"+
		"\u0115\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\66\3\2\2"+
		"\2\u011a\u011c\5\13\6\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u0120\u0124\5\5\3\2\u0121\u0123\5\13\6\2\u0122\u0121\3\2\2\2\u0123"+
		"\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0127\u012b\5\5\3\2\u0128\u012a\5\13\6\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0132\5\5\3\2\u012f"+
		"\u0131\5\13\6\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3"+
		"\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u0139\5\5\3\2\u0136\u0138\5\13\6\2\u0137\u0136\3\2\2\2\u0138\u013b\3"+
		"\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u0140\5\5\3\2\u013d\u013f\5\13\6\2\u013e\u013d\3"+
		"\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0147\5\5\3\2\u0144\u0146\5\13"+
		"\6\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014e\5\5"+
		"\3\2\u014b\u014d\5\13\6\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0151\u0155\5\5\3\2\u0152\u0154\5\13\6\2\u0153\u0152\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0158\u015c\5\5\3\2\u0159\u015b\5\13\6\2\u015a"+
		"\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0163\5\5\3\2\u0160"+
		"\u0162\5\13\6\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3"+
		"\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0163\3\2\2\2\u0166"+
		"\u0167\5\5\3\2\u01678\3\2\2\2\u0168\u016c\5\67\34\2\u0169\u016b\5\13\6"+
		"\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\5\5\3\2\u0170"+
		":\3\2\2\2\u0171\u0175\59\35\2\u0172\u0174\5\13\6\2\u0173\u0172\3\2\2\2"+
		"\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178"+
		"\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\5\5\3\2\u0179<\3\2\2\2\u017a"+
		"\u017e\5;\36\2\u017b\u017d\5\13\6\2\u017c\u017b\3\2\2\2\u017d\u0180\3"+
		"\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0181\u0182\5\5\3\2\u0182>\3\2\2\2\u0183\u0187\5=\37\2"+
		"\u0184\u0186\5\13\6\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a"+
		"\u018b\5\5\3\2\u018b@\3\2\2\2\u018c\u018f\7\66\2\2\u018d\u0190\59\35\2"+
		"\u018e\u0190\5? \2\u018f\u018d\3\2\2\2\u018f\u018e\3\2\2\2\u0190B\3\2"+
		"\2\2\u0191\u0192\7\67\2\2\u0192\u0193\t\27\2\2\u0193\u0194\5=\37\2\u0194"+
		"D\3\2\2\2\u0195\u0196\7\65\2\2\u0196\u0197\t\30\2\2\u0197\u0198\5;\36"+
		"\2\u0198F\3\2\2\2\u0199\u019f\7\65\2\2\u019a\u019b\7\62\2\2\u019b\u019c"+
		"\t\31\2\2\u019c\u01a0\5\67\34\2\u019d\u019e\t\32\2\2\u019e\u01a0\59\35"+
		"\2\u019f\u019a\3\2\2\2\u019f\u019d\3\2\2\2\u01a0H\3\2\2\2\u01a1\u01a2"+
		"\78\2\2\u01a2\u01a3\7\62\2\2\u01a3\u01a4\7\63\2\2\u01a4\u01a5\7\63\2\2"+
		"\u01a5\u01a6\3\2\2\2\u01a6\u01ac\59\35\2\u01a7\u01a8\78\2\2\u01a8\u01a9"+
		"\7\67\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\5=\37\2\u01ab\u01a1\3\2\2\2"+
		"\u01ab\u01a7\3\2\2\2\u01acJ\3\2\2\2\u01ad\u01ae\7\64\2\2\u01ae\u01af\7"+
		"\63\2\2\u01af\u01b0\7\65\2\2\u01b0\u01b6\7\63\2\2\u01b1\u01b2\7\63\2\2"+
		"\u01b2\u01b3\7:\2\2\u01b3\u01b4\7\62\2\2\u01b4\u01b6\7\62\2\2\u01b5\u01ad"+
		"\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01bd\5\67\34\2"+
		"\u01b8\u01b9\7\65\2\2\u01b9\u01ba\7\67\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd"+
		"\5=\37\2\u01bc\u01b5\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bdL\3\2\2\2\u01be"+
		"\u01c3\5\3\2\2\u01bf\u01c3\5\5\3\2\u01c0\u01c3\5\27\f\2\u01c1\u01c3\5"+
		"\r\7\2\u01c2\u01be\3\2\2\2\u01c2\u01bf\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2"+
		"\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5N\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01cb\7}\2\2\u01c8\u01ca"+
		"\5\r\7\2\u01c9\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01d1\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d0\5\7"+
		"\4\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d5\b("+
		"\2\2\u01d5P\3\2\2\2\u01d6\u01d8\5\r\7\2\u01d7\u01d6\3\2\2\2\u01d8\u01db"+
		"\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01df\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01dc\u01de\5\7\4\2\u01dd\u01dc\3\2\2\2\u01de\u01e1\3\2"+
		"\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1"+
		"\u01df\3\2\2\2\u01e2\u01e6\7\177\2\2\u01e3\u01e5\5\r\7\2\u01e4\u01e3\3"+
		"\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01ec\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01eb\5\7\4\2\u01ea\u01e9\3\2"+
		"\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ef\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f0\b)\3\2\u01f0R\3\2\2\2\u01f1"+
		"\u01f5\7>\2\2\u01f2\u01f4\7\61\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f7\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7"+
		"\u01f5\3\2\2\2\u01f8\u01fc\5\31\r\2\u01f9\u01fb\13\2\2\2\u01fa\u01f9\3"+
		"\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd"+
		"\u01ff\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0200\5\7\4\2\u0200\u0201\b*"+
		"\4\2\u0201T\3\2\2\2\u0202\u0203\7$\2\2\u0203\u0204\5\35\17\2\u0204\u0205"+
		"\7$\2\2\u0205\u0206\5\25\13\2\u0206\u0207\7$\2\2\u0207\u0208\5%\23\2\u0208"+
		"\u0209\7$\2\2\u0209\u020a\b+\5\2\u020a\u021a\3\2\2\2\u020b\u020c\7$\2"+
		"\2\u020c\u020d\5\35\17\2\u020d\u020e\7$\2\2\u020e\u020f\5\25\13\2\u020f"+
		"\u0213\7$\2\2\u0210\u0212\13\2\2\2\u0211\u0210\3\2\2\2\u0212\u0215\3\2"+
		"\2\2\u0213\u0214\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0216\3\2\2\2\u0215"+
		"\u0213\3\2\2\2\u0216\u0217\7$\2\2\u0217\u0218\b+\6\2\u0218\u021a\3\2\2"+
		"\2\u0219\u0202\3\2\2\2\u0219\u020b\3\2\2\2\u021aV\3\2\2\2\u021b\u021c"+
		"\7$\2\2\u021c\u021d\5\33\16\2\u021d\u021e\7$\2\2\u021e\u021f\5\25\13\2"+
		"\u021f\u0220\7$\2\2\u0220\u0221\5+\26\2\u0221\u0222\7$\2\2\u0222\u0223"+
		"\b,\7\2\u0223\u0233\3\2\2\2\u0224\u0225\7$\2\2\u0225\u0226\5\33\16\2\u0226"+
		"\u0227\7$\2\2\u0227\u0228\5\25\13\2\u0228\u022c\7$\2\2\u0229\u022b\13"+
		"\2\2\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022d\3\2\2\2\u022c"+
		"\u022a\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0230\7$"+
		"\2\2\u0230\u0231\b,\b\2\u0231\u0233\3\2\2\2\u0232\u021b\3\2\2\2\u0232"+
		"\u0224\3\2\2\2\u0233X\3\2\2\2\u0234\u0235\7$\2\2\u0235\u0236\5\37\20\2"+
		"\u0236\u0237\7$\2\2\u0237\u0238\5\25\13\2\u0238\u0239\7$\2\2\u0239\u023a"+
		"\5\63\32\2\u023a\u023b\7$\2\2\u023b\u023c\b-\t\2\u023c\u024c\3\2\2\2\u023d"+
		"\u023e\7$\2\2\u023e\u023f\5\37\20\2\u023f\u0240\7$\2\2\u0240\u0241\5\25"+
		"\13\2\u0241\u0245\7$\2\2\u0242\u0244\13\2\2\2\u0243\u0242\3\2\2\2\u0244"+
		"\u0247\3\2\2\2\u0245\u0246\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0248\3\2"+
		"\2\2\u0247\u0245\3\2\2\2\u0248\u0249\7$\2\2\u0249\u024a\b-\n\2\u024a\u024c"+
		"\3\2\2\2\u024b\u0234\3\2\2\2\u024b\u023d\3\2\2\2\u024cZ\3\2\2\2\u024d"+
		"\u024e\7$\2\2\u024e\u024f\5!\21\2\u024f\u0250\7$\2\2\u0250\u0251\5\25"+
		"\13\2\u0251\u0252\7$\2\2\u0252\u0253\5\65\33\2\u0253\u0254\7$\2\2\u0254"+
		"\u0255\b.\13\2\u0255\u0265\3\2\2\2\u0256\u0257\7$\2\2\u0257\u0258\5!\21"+
		"\2\u0258\u0259\7$\2\2\u0259\u025a\5\25\13\2\u025a\u025e\7$\2\2\u025b\u025d"+
		"\13\2\2\2\u025c\u025b\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025f\3\2\2\2"+
		"\u025e\u025c\3\2\2\2\u025f\u0261\3\2\2\2\u0260\u025e\3\2\2\2\u0261\u0262"+
		"\7$\2\2\u0262\u0263\b.\f\2\u0263\u0265\3\2\2\2\u0264\u024d\3\2\2\2\u0264"+
		"\u0256\3\2\2\2\u0265\\\3\2\2\2\u0266\u0267\7$\2\2\u0267\u0268\5#\22\2"+
		"\u0268\u0269\7$\2\2\u0269\u026a\5\25\13\2\u026a\u026b\7$\2\2\u026b\u026c"+
		"\5M\'\2\u026c\u026d\7$\2\2\u026d\u026e\b/\r\2\u026e\u0283\3\2\2\2\u026f"+
		"\u0273\7$\2\2\u0270\u0272\5#\22\2\u0271\u0270\3\2\2\2\u0272\u0275\3\2"+
		"\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0276\u0277\7$\2\2\u0277\u0278\5\25\13\2\u0278\u027c\7"+
		"$\2\2\u0279\u027b\13\2\2\2\u027a\u0279\3\2\2\2\u027b\u027e\3\2\2\2\u027c"+
		"\u027d\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u027f\3\2\2\2\u027e\u027c\3\2"+
		"\2\2\u027f\u0280\7$\2\2\u0280\u0281\b/\16\2\u0281\u0283\3\2\2\2\u0282"+
		"\u0266\3\2\2\2\u0282\u026f\3\2\2\2\u0283^\3\2\2\2\u0284\u0288\5\7\4\2"+
		"\u0285\u0288\5\t\5\2\u0286\u0288\5\23\n\2\u0287\u0284\3\2\2\2\u0287\u0285"+
		"\3\2\2\2\u0287\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u0287\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\b\60\17\2\u028c`\3\2\2"+
		"\2C\2v}\u00a4\u00a6\u00ad\u00af\u00b9\u00bb\u00c1\u00c3\u00c7\u00ce\u00d0"+
		"\u00de\u00e4\u00ee\u00f3\u00fd\u0103\u010b\u0118\u011d\u0124\u012b\u0132"+
		"\u0139\u0140\u0147\u014e\u0155\u015c\u0163\u016c\u0175\u017e\u0187\u018f"+
		"\u019f\u01ab\u01b5\u01bc\u01c2\u01c4\u01cb\u01d1\u01d9\u01df\u01e6\u01ec"+
		"\u01f5\u01fc\u0213\u0219\u022c\u0232\u0245\u024b\u025e\u0264\u0273\u027c"+
		"\u0282\u0287\u0289\20\3(\2\3)\3\3*\4\3+\5\3+\6\3,\7\3,\b\3-\t\3-\n\3."+
		"\13\3.\f\3/\r\3/\16\3\60\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}