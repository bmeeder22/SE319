// Generated from XML.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XML extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VISA=1, MASTERCARD=2, AMERICAN_EXPRESS=3, DINERS_CLUB=4, DISCOVER=5, JCB=6, 
		BAD_ELEMENT_NAME=7, EMAIL_ELEMENT=8, DATE_ELEMENT=9, PHONE_ELEMENT=10, 
		CREDIT_CARD_ELEMENT=11, OTHER_ELEMENT=12, DONOTHING=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "DIGIT", "NEWLINE", "DASH", "SPACE", "UNDERSCORE", "PERIOD", 
		"SPECIALCHAR", "ALT_XML", "START_TOKEN", "END_TOKEN", "DATE_NAME", "EMAIL_NAME", 
		"PHONE_NAME", "CREDIT_CARD_NAME", "ELEMENT_NAME", "EMAIL_CONTENTS", "LOCAL_PART", 
		"DOMAIN_PART", "DATE_CONTENTS", "DAY", "MONTH", "YEAR", "PHONE_CONTENTS", 
		"CREDIT_CARD_CONTENTS", "ELEVEN_DIGIT", "TWELVE_DIGIT", "THIRTEEN_DIGIT", 
		"FOURTEEN_DIGIT", "FIFTEEN_DIGIT", "VISA", "MASTERCARD", "AMERICAN_EXPRESS", 
		"DINERS_CLUB", "DISCOVER", "JCB", "OTHER_CONTENTS", "BAD_ELEMENT_NAME", 
		"EMAIL_ELEMENT", "DATE_ELEMENT", "PHONE_ELEMENT", "CREDIT_CARD_ELEMENT", 
		"OTHER_ELEMENT", "DONOTHING"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VISA", "MASTERCARD", "AMERICAN_EXPRESS", "DINERS_CLUB", "DISCOVER", 
		"JCB", "BAD_ELEMENT_NAME", "EMAIL_ELEMENT", "DATE_ELEMENT", "PHONE_ELEMENT", 
		"CREDIT_CARD_ELEMENT", "OTHER_ELEMENT", "DONOTHING"
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


	public XML(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XML.g4"; }

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
		case 37:
			BAD_ELEMENT_NAME_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			EMAIL_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			DATE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			PHONE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			CREDIT_CARD_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			OTHER_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			DONOTHING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void BAD_ELEMENT_NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

				System.out.println("Bad Element Name: " + getText() + " - cannot contain 'XML' or a variation of it.");

			break;
		}
	}
	private void EMAIL_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

					System.out.println("Email found: " + getText()); 
			break;
		case 2:

					System.out.println("Bad email element format: " + getText());
				
			break;
		}
	}
	private void DATE_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 System.out.println("Date found: " + getText()); 
			break;
		case 4:

					System.out.println("Bad date element format: " + getText());
				
			break;
		}
	}
	private void PHONE_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 System.out.println("Phone number found: " + getText()); 
			break;
		case 6:

					System.out.println("Bad phone element format: " + getText());
				
			break;
		}
	}
	private void CREDIT_CARD_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 System.out.println("Credit card found: " + getText()); 
			break;
		case 8:

					System.out.println("Bad credit card element format: " + getText());
				
			break;
		}
	}
	private void OTHER_ELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			 System.out.println("Custom element found: " + getText()); 
			break;
		}
	}
	private void DONOTHING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17\u0246\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\6\21\u0098\n\21\r\21\16\21\u0099\3\21\3\21\3\21\3\21\3\21\7\21\u00a1"+
		"\n\21\f\21\16\21\u00a4\13\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\6\23\u00ad"+
		"\n\23\r\23\16\23\u00ae\3\23\3\23\3\23\3\23\6\23\u00b5\n\23\r\23\16\23"+
		"\u00b6\7\23\u00b9\n\23\f\23\16\23\u00bc\13\23\3\24\3\24\3\24\3\24\6\24"+
		"\u00c2\n\24\r\24\16\24\u00c3\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u00d2\n\26\3\27\3\27\3\27\3\27\5\27\u00d8\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00e2\n\30\3\31\7\31\u00e5"+
		"\n\31\f\31\16\31\u00e8\13\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u00f2\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00fa\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0107\n\32\3\33\7\33"+
		"\u010a\n\33\f\33\16\33\u010d\13\33\3\33\3\33\7\33\u0111\n\33\f\33\16\33"+
		"\u0114\13\33\3\33\3\33\7\33\u0118\n\33\f\33\16\33\u011b\13\33\3\33\3\33"+
		"\7\33\u011f\n\33\f\33\16\33\u0122\13\33\3\33\3\33\7\33\u0126\n\33\f\33"+
		"\16\33\u0129\13\33\3\33\3\33\7\33\u012d\n\33\f\33\16\33\u0130\13\33\3"+
		"\33\3\33\7\33\u0134\n\33\f\33\16\33\u0137\13\33\3\33\3\33\7\33\u013b\n"+
		"\33\f\33\16\33\u013e\13\33\3\33\3\33\7\33\u0142\n\33\f\33\16\33\u0145"+
		"\13\33\3\33\3\33\7\33\u0149\n\33\f\33\16\33\u014c\13\33\3\33\3\33\7\33"+
		"\u0150\n\33\f\33\16\33\u0153\13\33\3\33\3\33\3\34\3\34\7\34\u0159\n\34"+
		"\f\34\16\34\u015c\13\34\3\34\3\34\3\35\3\35\7\35\u0162\n\35\f\35\16\35"+
		"\u0165\13\35\3\35\3\35\3\36\3\36\7\36\u016b\n\36\f\36\16\36\u016e\13\36"+
		"\3\36\3\36\3\37\3\37\7\37\u0174\n\37\f\37\16\37\u0177\13\37\3\37\3\37"+
		"\3 \3 \3 \5 \u017e\n \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\5"+
		"#\u018e\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u019a\n$\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\5%\u01a4\n%\3%\3%\3%\3%\3%\5%\u01ab\n%\3&\3&\3&\3&\7&\u01b1\n"+
		"&\f&\16&\u01b4\13&\3\'\3\'\7\'\u01b8\n\'\f\'\16\'\u01bb\13\'\3\'\3\'\7"+
		"\'\u01bf\n\'\f\'\16\'\u01c2\13\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\7(\u01d6\n(\f(\16(\u01d9\13(\3(\3(\3(\3(\3(\3(\3("+
		"\5(\u01e2\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u01f3\n)"+
		"\f)\16)\u01f6\13)\3)\3)\3)\3)\3)\3)\3)\5)\u01ff\n)\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0210\n*\f*\16*\u0213\13*\3*\3*\3*\3*\3*"+
		"\3*\3*\5*\u021c\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u022d"+
		"\n+\f+\16+\u0230\13+\3+\3+\3+\3+\3+\3+\3+\5+\u0239\n+\3,\3,\3,\3,\3,\3"+
		"-\6-\u0241\n-\r-\16-\u0242\3-\3-\7\u01c0\u01d7\u01f4\u0211\u022e\2.\3"+
		"\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!"+
		"\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\3A\4C\5E\6G\7I"+
		"\bK\2M\tO\nQ\13S\fU\rW\16Y\17\3\2\33\4\2C\\c|\3\2\62;\t\2##&&(/<=??aa"+
		"\u0080\u0080\4\2ZZzz\4\2OOoo\4\2NNnn\4\2FFff\4\2CCcc\4\2VVvv\4\2GGgg\4"+
		"\2KKkk\4\2RRrr\4\2JJjj\4\2QQqq\4\2PPpp\4\2EEee\4\2TTtt\3\2\63;\3\2\63"+
		"\64\3\2\62\63\3\2\62\64\3\2\63\67\4\2\66\6699\3\2\62\67\4\288::\u026a"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2"+
		"\2\17g\3\2\2\2\21i\3\2\2\2\23k\3\2\2\2\25o\3\2\2\2\27s\3\2\2\2\31y\3\2"+
		"\2\2\33~\3\2\2\2\35\u0084\3\2\2\2\37\u008a\3\2\2\2!\u0097\3\2\2\2#\u00a5"+
		"\3\2\2\2%\u00ac\3\2\2\2\'\u00c1\3\2\2\2)\u00c5\3\2\2\2+\u00d1\3\2\2\2"+
		"-\u00d7\3\2\2\2/\u00d9\3\2\2\2\61\u00e6\3\2\2\2\63\u0106\3\2\2\2\65\u010b"+
		"\3\2\2\2\67\u0156\3\2\2\29\u015f\3\2\2\2;\u0168\3\2\2\2=\u0171\3\2\2\2"+
		"?\u017a\3\2\2\2A\u017f\3\2\2\2C\u0183\3\2\2\2E\u0187\3\2\2\2G\u0199\3"+
		"\2\2\2I\u01aa\3\2\2\2K\u01b2\3\2\2\2M\u01b5\3\2\2\2O\u01e1\3\2\2\2Q\u01fe"+
		"\3\2\2\2S\u021b\3\2\2\2U\u0238\3\2\2\2W\u023a\3\2\2\2Y\u0240\3\2\2\2["+
		"\\\t\2\2\2\\\4\3\2\2\2]^\t\3\2\2^\6\3\2\2\2_`\7\f\2\2`\b\3\2\2\2ab\7/"+
		"\2\2b\n\3\2\2\2cd\7\"\2\2d\f\3\2\2\2ef\7a\2\2f\16\3\2\2\2gh\7\60\2\2h"+
		"\20\3\2\2\2ij\t\4\2\2j\22\3\2\2\2kl\t\5\2\2lm\t\6\2\2mn\t\7\2\2n\24\3"+
		"\2\2\2op\7>\2\2pq\5!\21\2qr\7@\2\2r\26\3\2\2\2st\7>\2\2tu\7\61\2\2uv\3"+
		"\2\2\2vw\5!\21\2wx\7@\2\2x\30\3\2\2\2yz\t\b\2\2z{\t\t\2\2{|\t\n\2\2|}"+
		"\t\13\2\2}\32\3\2\2\2~\177\t\13\2\2\177\u0080\t\6\2\2\u0080\u0081\t\t"+
		"\2\2\u0081\u0082\t\f\2\2\u0082\u0083\t\7\2\2\u0083\34\3\2\2\2\u0084\u0085"+
		"\t\r\2\2\u0085\u0086\t\16\2\2\u0086\u0087\t\17\2\2\u0087\u0088\t\20\2"+
		"\2\u0088\u0089\t\13\2\2\u0089\36\3\2\2\2\u008a\u008b\t\21\2\2\u008b\u008c"+
		"\t\22\2\2\u008c\u008d\t\13\2\2\u008d\u008e\t\b\2\2\u008e\u008f\t\f\2\2"+
		"\u008f\u0090\t\n\2\2\u0090\u0091\t\21\2\2\u0091\u0092\t\t\2\2\u0092\u0093"+
		"\t\22\2\2\u0093\u0094\t\b\2\2\u0094 \3\2\2\2\u0095\u0098\5\3\2\2\u0096"+
		"\u0098\5\r\7\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a2\3\2\2\2\u009b"+
		"\u00a1\5\3\2\2\u009c\u00a1\5\5\3\2\u009d\u00a1\5\t\5\2\u009e\u00a1\5\r"+
		"\7\2\u009f\u00a1\5\17\b\2\u00a0\u009b\3\2\2\2\u00a0\u009c\3\2\2\2\u00a0"+
		"\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\"\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\5%\23\2\u00a6\u00a7\7B\2\2\u00a7\u00a8\5\'\24\2\u00a8"+
		"$\3\2\2\2\u00a9\u00ad\5\3\2\2\u00aa\u00ad\5\5\3\2\u00ab\u00ad\5\21\t\2"+
		"\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ba\3\2\2\2\u00b0"+
		"\u00b4\5\17\b\2\u00b1\u00b5\5\3\2\2\u00b2\u00b5\5\5\3\2\u00b3\u00b5\5"+
		"\21\t\2\u00b4\u00b1\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b0\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb&\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c2\5\3\2\2"+
		"\u00be\u00c2\5\5\3\2\u00bf\u00c2\5\t\5\2\u00c0\u00c2\5\17\b\2\u00c1\u00bd"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4(\3\2\2\2"+
		"\u00c5\u00c6\5+\26\2\u00c6\u00c7\7\61\2\2\u00c7\u00c8\5-\27\2\u00c8\u00c9"+
		"\7\61\2\2\u00c9\u00ca\5/\30\2\u00ca*\3\2\2\2\u00cb\u00cc\7\62\2\2\u00cc"+
		"\u00d2\t\23\2\2\u00cd\u00ce\t\24\2\2\u00ce\u00d2\5\5\3\2\u00cf\u00d0\7"+
		"\65\2\2\u00d0\u00d2\t\25\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2,\3\2\2\2\u00d3\u00d4\7\62\2\2\u00d4\u00d8\t\23\2"+
		"\2\u00d5\u00d6\7\63\2\2\u00d6\u00d8\t\26\2\2\u00d7\u00d3\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8.\3\2\2\2\u00d9\u00e1\7\64\2\2\u00da\u00db\7\62\2"+
		"\2\u00db\u00dc\5\5\3\2\u00dc\u00dd\5\5\3\2\u00dd\u00e2\3\2\2\2\u00de\u00df"+
		"\7\63\2\2\u00df\u00e0\7\62\2\2\u00e0\u00e2\7\62\2\2\u00e1\u00da\3\2\2"+
		"\2\u00e1\u00de\3\2\2\2\u00e2\60\3\2\2\2\u00e3\u00e5\7*\2\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\5\5\3\2\u00ea\u00eb\5\5"+
		"\3\2\u00eb\u00f1\5\5\3\2\u00ec\u00ed\7+\2\2\u00ed\u00f2\7\"\2\2\u00ee"+
		"\u00f2\5\t\5\2\u00ef\u00f2\5\17\b\2\u00f0\u00f2\5\13\6\2\u00f1\u00ec\3"+
		"\2\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\5\5\3\2\u00f4\u00f5\5\5\3\2\u00f5\u00f9\5\5"+
		"\3\2\u00f6\u00fa\5\t\5\2\u00f7\u00fa\5\17\b\2\u00f8\u00fa\5\13\6\2\u00f9"+
		"\u00f6\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fc\5\5\3\2\u00fc\u00fd\5\5\3\2\u00fd\u00fe\5\5\3\2\u00fe"+
		"\u00ff\5\5\3\2\u00ff\62\3\2\2\2\u0100\u0107\5? \2\u0101\u0107\5A!\2\u0102"+
		"\u0107\5C\"\2\u0103\u0107\5E#\2\u0104\u0107\5G$\2\u0105\u0107\5I%\2\u0106"+
		"\u0100\3\2\2\2\u0106\u0101\3\2\2\2\u0106\u0102\3\2\2\2\u0106\u0103\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107\64\3\2\2\2\u0108\u010a"+
		"\5\t\5\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0112\5\5"+
		"\3\2\u010f\u0111\5\t\5\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0119\5\5\3\2\u0116\u0118\5\t\5\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u0120\5\5\3\2\u011d\u011f\5\t\5\2\u011e"+
		"\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0127\5\5\3\2\u0124"+
		"\u0126\5\t\5\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012e\5\5\3\2\u012b\u012d\5\t\5\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0135\5\5\3\2\u0132\u0134\5\t\5\2\u0133\u0132\3\2"+
		"\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013c\5\5\3\2\u0139\u013b\5\t"+
		"\5\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0143\5\5"+
		"\3\2\u0140\u0142\5\t\5\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0143\3\2"+
		"\2\2\u0146\u014a\5\5\3\2\u0147\u0149\5\t\5\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014d\u0151\5\5\3\2\u014e\u0150\5\t\5\2\u014f"+
		"\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\5\5\3\2\u0155"+
		"\66\3\2\2\2\u0156\u015a\5\65\33\2\u0157\u0159\5\t\5\2\u0158\u0157\3\2"+
		"\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015d\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\5\5\3\2\u015e8\3\2\2\2"+
		"\u015f\u0163\5\67\34\2\u0160\u0162\5\t\5\2\u0161\u0160\3\2\2\2\u0162\u0165"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0167\5\5\3\2\u0167:\3\2\2\2\u0168\u016c\59\35\2"+
		"\u0169\u016b\5\t\5\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0170\5\5\3\2\u0170<\3\2\2\2\u0171\u0175\5;\36\2\u0172\u0174\5\t\5\2"+
		"\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176"+
		"\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\5\5\3\2\u0179"+
		">\3\2\2\2\u017a\u017d\7\66\2\2\u017b\u017e\5\67\34\2\u017c\u017e\5=\37"+
		"\2\u017d\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017e@\3\2\2\2\u017f\u0180"+
		"\7\67\2\2\u0180\u0181\t\27\2\2\u0181\u0182\5;\36\2\u0182B\3\2\2\2\u0183"+
		"\u0184\7\65\2\2\u0184\u0185\t\30\2\2\u0185\u0186\59\35\2\u0186D\3\2\2"+
		"\2\u0187\u018d\7\65\2\2\u0188\u0189\7\62\2\2\u0189\u018a\t\31\2\2\u018a"+
		"\u018e\5\65\33\2\u018b\u018c\t\32\2\2\u018c\u018e\5\67\34\2\u018d\u0188"+
		"\3\2\2\2\u018d\u018b\3\2\2\2\u018eF\3\2\2\2\u018f\u0190\78\2\2\u0190\u0191"+
		"\7\62\2\2\u0191\u0192\7\63\2\2\u0192\u0193\7\63\2\2\u0193\u0194\3\2\2"+
		"\2\u0194\u019a\5\67\34\2\u0195\u0196\78\2\2\u0196\u0197\7\67\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\5;\36\2\u0199\u018f\3\2\2\2\u0199\u0195\3\2"+
		"\2\2\u019aH\3\2\2\2\u019b\u019c\7\64\2\2\u019c\u019d\7\63\2\2\u019d\u019e"+
		"\7\65\2\2\u019e\u01a4\7\63\2\2\u019f\u01a0\7\63\2\2\u01a0\u01a1\7:\2\2"+
		"\u01a1\u01a2\7\62\2\2\u01a2\u01a4\7\62\2\2\u01a3\u019b\3\2\2\2\u01a3\u019f"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01ab\5\65\33\2\u01a6\u01a7\7\65\2"+
		"\2\u01a7\u01a8\7\67\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\5;\36\2\u01aa"+
		"\u01a3\3\2\2\2\u01aa\u01a6\3\2\2\2\u01abJ\3\2\2\2\u01ac\u01b1\5\3\2\2"+
		"\u01ad\u01b1\5\5\3\2\u01ae\u01b1\5\21\t\2\u01af\u01b1\5\13\6\2\u01b0\u01ac"+
		"\3\2\2\2\u01b0\u01ad\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1"+
		"\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3L\3\2\2\2"+
		"\u01b4\u01b2\3\2\2\2\u01b5\u01b9\7>\2\2\u01b6\u01b8\7\61\2\2\u01b7\u01b6"+
		"\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01c0\5\23\n\2\u01bd\u01bf\13"+
		"\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c4\5\7"+
		"\4\2\u01c4\u01c5\b\'\2\2\u01c5N\3\2\2\2\u01c6\u01c7\7>\2\2\u01c7\u01c8"+
		"\5\33\16\2\u01c8\u01c9\7@\2\2\u01c9\u01ca\5#\22\2\u01ca\u01cb\7>\2\2\u01cb"+
		"\u01cc\7\61\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\5\33\16\2\u01ce\u01cf"+
		"\7@\2\2\u01cf\u01d0\b(\3\2\u01d0\u01e2\3\2\2\2\u01d1\u01d2\7>\2\2\u01d2"+
		"\u01d3\5\33\16\2\u01d3\u01d7\7@\2\2\u01d4\u01d6\13\2\2\2\u01d5\u01d4\3"+
		"\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8"+
		"\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01db\7>\2\2\u01db\u01dc\7\61"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\5\33\16\2\u01de\u01df\7@\2\2\u01df"+
		"\u01e0\b(\4\2\u01e0\u01e2\3\2\2\2\u01e1\u01c6\3\2\2\2\u01e1\u01d1\3\2"+
		"\2\2\u01e2P\3\2\2\2\u01e3\u01e4\7>\2\2\u01e4\u01e5\5\31\r\2\u01e5\u01e6"+
		"\7@\2\2\u01e6\u01e7\5)\25\2\u01e7\u01e8\7>\2\2\u01e8\u01e9\7\61\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\5\31\r\2\u01eb\u01ec\7@\2\2\u01ec\u01ed\b)"+
		"\5\2\u01ed\u01ff\3\2\2\2\u01ee\u01ef\7>\2\2\u01ef\u01f0\5\31\r\2\u01f0"+
		"\u01f4\7@\2\2\u01f1\u01f3\13\2\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2"+
		"\2\2\u01f4\u01f5\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f7\u01f8\7>\2\2\u01f8\u01f9\7\61\2\2\u01f9\u01fa\3\2"+
		"\2\2\u01fa\u01fb\5\31\r\2\u01fb\u01fc\7@\2\2\u01fc\u01fd\b)\6\2\u01fd"+
		"\u01ff\3\2\2\2\u01fe\u01e3\3\2\2\2\u01fe\u01ee\3\2\2\2\u01ffR\3\2\2\2"+
		"\u0200\u0201\7>\2\2\u0201\u0202\5\35\17\2\u0202\u0203\7@\2\2\u0203\u0204"+
		"\5\61\31\2\u0204\u0205\7>\2\2\u0205\u0206\7\61\2\2\u0206\u0207\3\2\2\2"+
		"\u0207\u0208\5\35\17\2\u0208\u0209\7@\2\2\u0209\u020a\b*\7\2\u020a\u021c"+
		"\3\2\2\2\u020b\u020c\7>\2\2\u020c\u020d\5\35\17\2\u020d\u0211\7@\2\2\u020e"+
		"\u0210\13\2\2\2\u020f\u020e\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u0212\3"+
		"\2\2\2\u0211\u020f\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u0211\3\2\2\2\u0214"+
		"\u0215\7>\2\2\u0215\u0216\7\61\2\2\u0216\u0217\3\2\2\2\u0217\u0218\5\35"+
		"\17\2\u0218\u0219\7@\2\2\u0219\u021a\b*\b\2\u021a\u021c\3\2\2\2\u021b"+
		"\u0200\3\2\2\2\u021b\u020b\3\2\2\2\u021cT\3\2\2\2\u021d\u021e\7>\2\2\u021e"+
		"\u021f\5\37\20\2\u021f\u0220\7@\2\2\u0220\u0221\5\63\32\2\u0221\u0222"+
		"\7>\2\2\u0222\u0223\7\61\2\2\u0223\u0224\3\2\2\2\u0224\u0225\5\37\20\2"+
		"\u0225\u0226\7@\2\2\u0226\u0227\b+\t\2\u0227\u0239\3\2\2\2\u0228\u0229"+
		"\7>\2\2\u0229\u022a\5\37\20\2\u022a\u022e\7@\2\2\u022b\u022d\13\2\2\2"+
		"\u022c\u022b\3\2\2\2\u022d\u0230\3\2\2\2\u022e\u022f\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022f\u0231\3\2\2\2\u0230\u022e\3\2\2\2\u0231\u0232\7>\2\2\u0232"+
		"\u0233\7\61\2\2\u0233\u0234\3\2\2\2\u0234\u0235\5\37\20\2\u0235\u0236"+
		"\7@\2\2\u0236\u0237\b+\n\2\u0237\u0239\3\2\2\2\u0238\u021d\3\2\2\2\u0238"+
		"\u0228\3\2\2\2\u0239V\3\2\2\2\u023a\u023b\5\25\13\2\u023b\u023c\5K&\2"+
		"\u023c\u023d\5\27\f\2\u023d\u023e\b,\13\2\u023eX\3\2\2\2\u023f\u0241\5"+
		"\7\4\2\u0240\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240\3\2\2\2\u0242"+
		"\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0245\b-\f\2\u0245Z\3\2\2\2\66"+
		"\2\u0097\u0099\u00a0\u00a2\u00ac\u00ae\u00b4\u00b6\u00ba\u00c1\u00c3\u00d1"+
		"\u00d7\u00e1\u00e6\u00f1\u00f9\u0106\u010b\u0112\u0119\u0120\u0127\u012e"+
		"\u0135\u013c\u0143\u014a\u0151\u015a\u0163\u016c\u0175\u017d\u018d\u0199"+
		"\u01a3\u01aa\u01b0\u01b2\u01b9\u01c0\u01d7\u01e1\u01f4\u01fe\u0211\u021b"+
		"\u022e\u0238\u0242\r\3\'\2\3(\3\3(\4\3)\5\3)\6\3*\7\3*\b\3+\t\3+\n\3,"+
		"\13\3-\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}