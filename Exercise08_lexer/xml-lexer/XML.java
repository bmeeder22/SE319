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
		"LETTER", "DIGIT", "NEWLINE", "CARRIAGER", "DASH", "SPACE", "UNDERSCORE", 
		"PERIOD", "SPECIALCHAR", "ALT_XML", "START_TOKEN", "END_TOKEN", "DATE_NAME", 
		"EMAIL_NAME", "PHONE_NAME", "CREDIT_CARD_NAME", "ELEMENT_NAME", "EMAIL_CONTENTS", 
		"LOCAL_PART", "DOMAIN_PART", "DATE_CONTENTS", "DAY", "MONTH", "YEAR", 
		"PHONE_CONTENTS", "CREDIT_CARD_CONTENTS", "ELEVEN_DIGIT", "TWELVE_DIGIT", 
		"THIRTEEN_DIGIT", "FOURTEEN_DIGIT", "FIFTEEN_DIGIT", "VISA", "MASTERCARD", 
		"AMERICAN_EXPRESS", "DINERS_CLUB", "DISCOVER", "JCB", "OTHER_CONTENTS", 
		"BAD_ELEMENT_NAME", "EMAIL_ELEMENT", "DATE_ELEMENT", "PHONE_ELEMENT", 
		"CREDIT_CARD_ELEMENT", "OTHER_ELEMENT", "DONOTHING"
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
		case 38:
			BAD_ELEMENT_NAME_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			EMAIL_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			DATE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			PHONE_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			CREDIT_CARD_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			OTHER_ELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17\u024b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\6\22\u009c\n\22\r\22\16\22\u009d\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u00a5\n\22\f\22\16\22\u00a8\13\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\6\24\u00b1\n\24\r\24\16\24\u00b2\3\24\3\24\3\24\3\24\6"+
		"\24\u00b9\n\24\r\24\16\24\u00ba\7\24\u00bd\n\24\f\24\16\24\u00c0\13\24"+
		"\3\25\3\25\3\25\3\25\6\25\u00c6\n\25\r\25\16\25\u00c7\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00d6\n\27\3\30\3\30"+
		"\3\30\3\30\5\30\u00dc\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u00e6\n\31\3\32\7\32\u00e9\n\32\f\32\16\32\u00ec\13\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u00f6\n\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00fe\n\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u010b\n\33\3\34\7\34\u010e\n\34\f\34\16\34\u0111\13\34\3\34\3\34"+
		"\7\34\u0115\n\34\f\34\16\34\u0118\13\34\3\34\3\34\7\34\u011c\n\34\f\34"+
		"\16\34\u011f\13\34\3\34\3\34\7\34\u0123\n\34\f\34\16\34\u0126\13\34\3"+
		"\34\3\34\7\34\u012a\n\34\f\34\16\34\u012d\13\34\3\34\3\34\7\34\u0131\n"+
		"\34\f\34\16\34\u0134\13\34\3\34\3\34\7\34\u0138\n\34\f\34\16\34\u013b"+
		"\13\34\3\34\3\34\7\34\u013f\n\34\f\34\16\34\u0142\13\34\3\34\3\34\7\34"+
		"\u0146\n\34\f\34\16\34\u0149\13\34\3\34\3\34\7\34\u014d\n\34\f\34\16\34"+
		"\u0150\13\34\3\34\3\34\7\34\u0154\n\34\f\34\16\34\u0157\13\34\3\34\3\34"+
		"\3\35\3\35\7\35\u015d\n\35\f\35\16\35\u0160\13\35\3\35\3\35\3\36\3\36"+
		"\7\36\u0166\n\36\f\36\16\36\u0169\13\36\3\36\3\36\3\37\3\37\7\37\u016f"+
		"\n\37\f\37\16\37\u0172\13\37\3\37\3\37\3 \3 \7 \u0178\n \f \16 \u017b"+
		"\13 \3 \3 \3!\3!\3!\5!\u0182\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\5$\u0192\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u019e\n%\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\5&\u01a8\n&\3&\3&\3&\3&\3&\5&\u01af\n&\3\'\3\'\3\'\3"+
		"\'\7\'\u01b5\n\'\f\'\16\'\u01b8\13\'\3(\3(\7(\u01bc\n(\f(\16(\u01bf\13"+
		"(\3(\3(\7(\u01c3\n(\f(\16(\u01c6\13(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\7)\u01da\n)\f)\16)\u01dd\13)\3)\3)\3)\3)\3)\3)\3"+
		")\5)\u01e6\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u01f7\n"+
		"*\f*\16*\u01fa\13*\3*\3*\3*\3*\3*\3*\3*\5*\u0203\n*\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u0214\n+\f+\16+\u0217\13+\3+\3+\3+\3+\3"+
		"+\3+\3+\5+\u0220\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0231"+
		"\n,\f,\16,\u0234\13,\3,\3,\3,\3,\3,\3,\3,\5,\u023d\n,\3-\3-\3-\3-\3-\3"+
		".\3.\6.\u0246\n.\r.\16.\u0247\3.\3.\7\u01c4\u01db\u01f8\u0215\u0232\2"+
		"/\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37"+
		"\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\3C\4E\5G"+
		"\6I\7K\bM\2O\tQ\nS\13U\fW\rY\16[\17\3\2\33\4\2C\\c|\3\2\62;\t\2##&&(/"+
		"<=??aa\u0080\u0080\4\2ZZzz\4\2OOoo\4\2NNnn\4\2FFff\4\2CCcc\4\2VVvv\4\2"+
		"GGgg\4\2KKkk\4\2RRrr\4\2JJjj\4\2QQqq\4\2PPpp\4\2EEee\4\2TTtt\3\2\63;\3"+
		"\2\63\64\3\2\62\63\3\2\62\64\3\2\63\67\4\2\66\6699\3\2\62\67\4\288::\u026f"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2"+
		"\2\17i\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27s\3\2\2\2\31w\3\2"+
		"\2\2\33}\3\2\2\2\35\u0082\3\2\2\2\37\u0088\3\2\2\2!\u008e\3\2\2\2#\u009b"+
		"\3\2\2\2%\u00a9\3\2\2\2\'\u00b0\3\2\2\2)\u00c5\3\2\2\2+\u00c9\3\2\2\2"+
		"-\u00d5\3\2\2\2/\u00db\3\2\2\2\61\u00dd\3\2\2\2\63\u00ea\3\2\2\2\65\u010a"+
		"\3\2\2\2\67\u010f\3\2\2\29\u015a\3\2\2\2;\u0163\3\2\2\2=\u016c\3\2\2\2"+
		"?\u0175\3\2\2\2A\u017e\3\2\2\2C\u0183\3\2\2\2E\u0187\3\2\2\2G\u018b\3"+
		"\2\2\2I\u019d\3\2\2\2K\u01ae\3\2\2\2M\u01b6\3\2\2\2O\u01b9\3\2\2\2Q\u01e5"+
		"\3\2\2\2S\u0202\3\2\2\2U\u021f\3\2\2\2W\u023c\3\2\2\2Y\u023e\3\2\2\2["+
		"\u0245\3\2\2\2]^\t\2\2\2^\4\3\2\2\2_`\t\3\2\2`\6\3\2\2\2ab\7\f\2\2b\b"+
		"\3\2\2\2cd\7\17\2\2d\n\3\2\2\2ef\7/\2\2f\f\3\2\2\2gh\7\"\2\2h\16\3\2\2"+
		"\2ij\7a\2\2j\20\3\2\2\2kl\7\60\2\2l\22\3\2\2\2mn\t\4\2\2n\24\3\2\2\2o"+
		"p\t\5\2\2pq\t\6\2\2qr\t\7\2\2r\26\3\2\2\2st\7>\2\2tu\5#\22\2uv\7@\2\2"+
		"v\30\3\2\2\2wx\7>\2\2xy\7\61\2\2yz\3\2\2\2z{\5#\22\2{|\7@\2\2|\32\3\2"+
		"\2\2}~\t\b\2\2~\177\t\t\2\2\177\u0080\t\n\2\2\u0080\u0081\t\13\2\2\u0081"+
		"\34\3\2\2\2\u0082\u0083\t\13\2\2\u0083\u0084\t\6\2\2\u0084\u0085\t\t\2"+
		"\2\u0085\u0086\t\f\2\2\u0086\u0087\t\7\2\2\u0087\36\3\2\2\2\u0088\u0089"+
		"\t\r\2\2\u0089\u008a\t\16\2\2\u008a\u008b\t\17\2\2\u008b\u008c\t\20\2"+
		"\2\u008c\u008d\t\13\2\2\u008d \3\2\2\2\u008e\u008f\t\21\2\2\u008f\u0090"+
		"\t\22\2\2\u0090\u0091\t\13\2\2\u0091\u0092\t\b\2\2\u0092\u0093\t\f\2\2"+
		"\u0093\u0094\t\n\2\2\u0094\u0095\t\21\2\2\u0095\u0096\t\t\2\2\u0096\u0097"+
		"\t\22\2\2\u0097\u0098\t\b\2\2\u0098\"\3\2\2\2\u0099\u009c\5\3\2\2\u009a"+
		"\u009c\5\17\b\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a6\3\2\2\2\u009f"+
		"\u00a5\5\3\2\2\u00a0\u00a5\5\5\3\2\u00a1\u00a5\5\13\6\2\u00a2\u00a5\5"+
		"\17\b\2\u00a3\u00a5\5\21\t\2\u00a4\u009f\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7$\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9\u00aa\5\'\24\2\u00aa\u00ab\7B\2\2\u00ab\u00ac\5)\25\2\u00ac"+
		"&\3\2\2\2\u00ad\u00b1\5\3\2\2\u00ae\u00b1\5\5\3\2\u00af\u00b1\5\23\n\2"+
		"\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00be\3\2\2\2\u00b4"+
		"\u00b8\5\21\t\2\u00b5\u00b9\5\3\2\2\u00b6\u00b9\5\5\3\2\u00b7\u00b9\5"+
		"\23\n\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2"+
		"\2\2\u00bc\u00b4\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf(\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c6\5\3\2\2"+
		"\u00c2\u00c6\5\5\3\2\u00c3\u00c6\5\13\6\2\u00c4\u00c6\5\21\t\2\u00c5\u00c1"+
		"\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8*\3\2\2\2"+
		"\u00c9\u00ca\5-\27\2\u00ca\u00cb\7\61\2\2\u00cb\u00cc\5/\30\2\u00cc\u00cd"+
		"\7\61\2\2\u00cd\u00ce\5\61\31\2\u00ce,\3\2\2\2\u00cf\u00d0\7\62\2\2\u00d0"+
		"\u00d6\t\23\2\2\u00d1\u00d2\t\24\2\2\u00d2\u00d6\5\5\3\2\u00d3\u00d4\7"+
		"\65\2\2\u00d4\u00d6\t\25\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7\62\2\2\u00d8\u00dc\t\23\2"+
		"\2\u00d9\u00da\7\63\2\2\u00da\u00dc\t\26\2\2\u00db\u00d7\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\60\3\2\2\2\u00dd\u00e5\7\64\2\2\u00de\u00df\7\62"+
		"\2\2\u00df\u00e0\5\5\3\2\u00e0\u00e1\5\5\3\2\u00e1\u00e6\3\2\2\2\u00e2"+
		"\u00e3\7\63\2\2\u00e3\u00e4\7\62\2\2\u00e4\u00e6\7\62\2\2\u00e5\u00de"+
		"\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\62\3\2\2\2\u00e7\u00e9\7*\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\5\5\3\2\u00ee"+
		"\u00ef\5\5\3\2\u00ef\u00f5\5\5\3\2\u00f0\u00f1\7+\2\2\u00f1\u00f6\7\""+
		"\2\2\u00f2\u00f6\5\13\6\2\u00f3\u00f6\5\21\t\2\u00f4\u00f6\5\r\7\2\u00f5"+
		"\u00f0\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\5\5\3\2\u00f8\u00f9\5\5\3\2\u00f9"+
		"\u00fd\5\5\3\2\u00fa\u00fe\5\13\6\2\u00fb\u00fe\5\21\t\2\u00fc\u00fe\5"+
		"\r\7\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\5\5\3\2\u0100\u0101\5\5\3\2\u0101\u0102\5\5"+
		"\3\2\u0102\u0103\5\5\3\2\u0103\64\3\2\2\2\u0104\u010b\5A!\2\u0105\u010b"+
		"\5C\"\2\u0106\u010b\5E#\2\u0107\u010b\5G$\2\u0108\u010b\5I%\2\u0109\u010b"+
		"\5K&\2\u010a\u0104\3\2\2\2\u010a\u0105\3\2\2\2\u010a\u0106\3\2\2\2\u010a"+
		"\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\66\3\2\2"+
		"\2\u010c\u010e\5\13\6\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0112\u0116\5\5\3\2\u0113\u0115\5\13\6\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2"+
		"\2\2\u0118\u0116\3\2\2\2\u0119\u011d\5\5\3\2\u011a\u011c\5\13\6\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0124\5\5\3\2\u0121"+
		"\u0123\5\13\6\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3"+
		"\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u012b\5\5\3\2\u0128\u012a\5\13\6\2\u0129\u0128\3\2\2\2\u012a\u012d\3"+
		"\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012e\u0132\5\5\3\2\u012f\u0131\5\13\6\2\u0130\u012f\3"+
		"\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0139\5\5\3\2\u0136\u0138\5\13"+
		"\6\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u0140\5\5"+
		"\3\2\u013d\u013f\5\13\6\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0143\u0147\5\5\3\2\u0144\u0146\5\13\6\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u014a\u014e\5\5\3\2\u014b\u014d\5\13\6\2\u014c"+
		"\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0155\5\5\3\2\u0152"+
		"\u0154\5\13\6\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3"+
		"\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0159\5\5\3\2\u01598\3\2\2\2\u015a\u015e\5\67\34\2\u015b\u015d\5\13\6"+
		"\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f"+
		"\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\5\5\3\2\u0162"+
		":\3\2\2\2\u0163\u0167\59\35\2\u0164\u0166\5\13\6\2\u0165\u0164\3\2\2\2"+
		"\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\5\5\3\2\u016b<\3\2\2\2\u016c"+
		"\u0170\5;\36\2\u016d\u016f\5\13\6\2\u016e\u016d\3\2\2\2\u016f\u0172\3"+
		"\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0174\5\5\3\2\u0174>\3\2\2\2\u0175\u0179\5=\37\2"+
		"\u0176\u0178\5\13\6\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c"+
		"\u017d\5\5\3\2\u017d@\3\2\2\2\u017e\u0181\7\66\2\2\u017f\u0182\59\35\2"+
		"\u0180\u0182\5? \2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182B\3\2"+
		"\2\2\u0183\u0184\7\67\2\2\u0184\u0185\t\27\2\2\u0185\u0186\5=\37\2\u0186"+
		"D\3\2\2\2\u0187\u0188\7\65\2\2\u0188\u0189\t\30\2\2\u0189\u018a\5;\36"+
		"\2\u018aF\3\2\2\2\u018b\u0191\7\65\2\2\u018c\u018d\7\62\2\2\u018d\u018e"+
		"\t\31\2\2\u018e\u0192\5\67\34\2\u018f\u0190\t\32\2\2\u0190\u0192\59\35"+
		"\2\u0191\u018c\3\2\2\2\u0191\u018f\3\2\2\2\u0192H\3\2\2\2\u0193\u0194"+
		"\78\2\2\u0194\u0195\7\62\2\2\u0195\u0196\7\63\2\2\u0196\u0197\7\63\2\2"+
		"\u0197\u0198\3\2\2\2\u0198\u019e\59\35\2\u0199\u019a\78\2\2\u019a\u019b"+
		"\7\67\2\2\u019b\u019c\3\2\2\2\u019c\u019e\5=\37\2\u019d\u0193\3\2\2\2"+
		"\u019d\u0199\3\2\2\2\u019eJ\3\2\2\2\u019f\u01a0\7\64\2\2\u01a0\u01a1\7"+
		"\63\2\2\u01a1\u01a2\7\65\2\2\u01a2\u01a8\7\63\2\2\u01a3\u01a4\7\63\2\2"+
		"\u01a4\u01a5\7:\2\2\u01a5\u01a6\7\62\2\2\u01a6\u01a8\7\62\2\2\u01a7\u019f"+
		"\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01af\5\67\34\2"+
		"\u01aa\u01ab\7\65\2\2\u01ab\u01ac\7\67\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af"+
		"\5=\37\2\u01ae\u01a7\3\2\2\2\u01ae\u01aa\3\2\2\2\u01afL\3\2\2\2\u01b0"+
		"\u01b5\5\3\2\2\u01b1\u01b5\5\5\3\2\u01b2\u01b5\5\23\n\2\u01b3\u01b5\5"+
		"\r\7\2\u01b4\u01b0\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7N\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01bd\7>\2\2\u01ba\u01bc"+
		"\7\61\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2"+
		"\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c4"+
		"\5\25\13\2\u01c1\u01c3\13\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2"+
		"\2\u01c4\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4"+
		"\3\2\2\2\u01c7\u01c8\5\7\4\2\u01c8\u01c9\b(\2\2\u01c9P\3\2\2\2\u01ca\u01cb"+
		"\7>\2\2\u01cb\u01cc\5\35\17\2\u01cc\u01cd\7@\2\2\u01cd\u01ce\5%\23\2\u01ce"+
		"\u01cf\7>\2\2\u01cf\u01d0\7\61\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\5\35"+
		"\17\2\u01d2\u01d3\7@\2\2\u01d3\u01d4\b)\3\2\u01d4\u01e6\3\2\2\2\u01d5"+
		"\u01d6\7>\2\2\u01d6\u01d7\5\35\17\2\u01d7\u01db\7@\2\2\u01d8\u01da\13"+
		"\2\2\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01dc\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7>"+
		"\2\2\u01df\u01e0\7\61\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\5\35\17\2\u01e2"+
		"\u01e3\7@\2\2\u01e3\u01e4\b)\4\2\u01e4\u01e6\3\2\2\2\u01e5\u01ca\3\2\2"+
		"\2\u01e5\u01d5\3\2\2\2\u01e6R\3\2\2\2\u01e7\u01e8\7>\2\2\u01e8\u01e9\5"+
		"\33\16\2\u01e9\u01ea\7@\2\2\u01ea\u01eb\5+\26\2\u01eb\u01ec\7>\2\2\u01ec"+
		"\u01ed\7\61\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\5\33\16\2\u01ef\u01f0"+
		"\7@\2\2\u01f0\u01f1\b*\5\2\u01f1\u0203\3\2\2\2\u01f2\u01f3\7>\2\2\u01f3"+
		"\u01f4\5\33\16\2\u01f4\u01f8\7@\2\2\u01f5\u01f7\13\2\2\2\u01f6\u01f5\3"+
		"\2\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9"+
		"\u01fb\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\7>\2\2\u01fc\u01fd\7\61"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\5\33\16\2\u01ff\u0200\7@\2\2\u0200"+
		"\u0201\b*\6\2\u0201\u0203\3\2\2\2\u0202\u01e7\3\2\2\2\u0202\u01f2\3\2"+
		"\2\2\u0203T\3\2\2\2\u0204\u0205\7>\2\2\u0205\u0206\5\37\20\2\u0206\u0207"+
		"\7@\2\2\u0207\u0208\5\63\32\2\u0208\u0209\7>\2\2\u0209\u020a\7\61\2\2"+
		"\u020a\u020b\3\2\2\2\u020b\u020c\5\37\20\2\u020c\u020d\7@\2\2\u020d\u020e"+
		"\b+\7\2\u020e\u0220\3\2\2\2\u020f\u0210\7>\2\2\u0210\u0211\5\37\20\2\u0211"+
		"\u0215\7@\2\2\u0212\u0214\13\2\2\2\u0213\u0212\3\2\2\2\u0214\u0217\3\2"+
		"\2\2\u0215\u0216\3\2\2\2\u0215\u0213\3\2\2\2\u0216\u0218\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0218\u0219\7>\2\2\u0219\u021a\7\61\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021c\5\37\20\2\u021c\u021d\7@\2\2\u021d\u021e\b+\b\2\u021e"+
		"\u0220\3\2\2\2\u021f\u0204\3\2\2\2\u021f\u020f\3\2\2\2\u0220V\3\2\2\2"+
		"\u0221\u0222\7>\2\2\u0222\u0223\5!\21\2\u0223\u0224\7@\2\2\u0224\u0225"+
		"\5\65\33\2\u0225\u0226\7>\2\2\u0226\u0227\7\61\2\2\u0227\u0228\3\2\2\2"+
		"\u0228\u0229\5!\21\2\u0229\u022a\7@\2\2\u022a\u022b\b,\t\2\u022b\u023d"+
		"\3\2\2\2\u022c\u022d\7>\2\2\u022d\u022e\5!\21\2\u022e\u0232\7@\2\2\u022f"+
		"\u0231\13\2\2\2\u0230\u022f\3\2\2\2\u0231\u0234\3\2\2\2\u0232\u0233\3"+
		"\2\2\2\u0232\u0230\3\2\2\2\u0233\u0235\3\2\2\2\u0234\u0232\3\2\2\2\u0235"+
		"\u0236\7>\2\2\u0236\u0237\7\61\2\2\u0237\u0238\3\2\2\2\u0238\u0239\5!"+
		"\21\2\u0239\u023a\7@\2\2\u023a\u023b\b,\n\2\u023b\u023d\3\2\2\2\u023c"+
		"\u0221\3\2\2\2\u023c\u022c\3\2\2\2\u023dX\3\2\2\2\u023e\u023f\5\27\f\2"+
		"\u023f\u0240\5M\'\2\u0240\u0241\5\31\r\2\u0241\u0242\b-\13\2\u0242Z\3"+
		"\2\2\2\u0243\u0246\5\7\4\2\u0244\u0246\5\t\5\2\u0245\u0243\3\2\2\2\u0245"+
		"\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2"+
		"\2\2\u0248\u0249\3\2\2\2\u0249\u024a\b.\f\2\u024a\\\3\2\2\2\67\2\u009b"+
		"\u009d\u00a4\u00a6\u00b0\u00b2\u00b8\u00ba\u00be\u00c5\u00c7\u00d5\u00db"+
		"\u00e5\u00ea\u00f5\u00fd\u010a\u010f\u0116\u011d\u0124\u012b\u0132\u0139"+
		"\u0140\u0147\u014e\u0155\u015e\u0167\u0170\u0179\u0181\u0191\u019d\u01a7"+
		"\u01ae\u01b4\u01b6\u01bd\u01c4\u01db\u01e5\u01f8\u0202\u0215\u021f\u0232"+
		"\u023c\u0245\u0247\r\3(\2\3)\3\3)\4\3*\5\3*\6\3+\7\3+\b\3,\t\3,\n\3-\13"+
		"\3.\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}