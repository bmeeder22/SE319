lexer grammar XML;

//define fragments

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment NEWLINE: '\n';
fragment CARRIAGER: '\r';
fragment DASH: '-';
fragment SPACE: ' ';
fragment UNDERSCORE: '_';
fragment PERIOD: '.';
fragment SPECIALCHAR: [-_~!$&'()*+,;=:];
fragment ALT_XML: ('X' | 'x') ('M' | 'm') ('L' | 'l');

fragment START_TOKEN: '<' ELEMENT_NAME '>';
fragment END_TOKEN: '</' ELEMENT_NAME '>';

fragment DATE_NAME: ('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e');
fragment EMAIL_NAME: ('E' | 'e') ('M' | 'm') ('A' | 'a') ('I' | 'i') ('L' | 'l');
fragment PHONE_NAME: ('P' | 'p') ('H' | 'h') ('O' | 'o') ('N' | 'n') ('E' | 'e');
fragment CREDIT_CARD_NAME: ('C' | 'c') ('R' | 'r') ('E' | 'e') ('D' | 'd') ('I' | 'i') ('T' | 't') ('C' | 'c') ('A' | 'a') ('R' | 'r') ('D' | 'd');

//Element Name

fragment ELEMENT_NAME: (LETTER | UNDERSCORE)+ (LETTER | DIGIT | DASH | UNDERSCORE | PERIOD)*;

//Email Element

fragment EMAIL_CONTENTS: LOCAL_PART '@' DOMAIN_PART;

fragment LOCAL_PART: (LETTER | DIGIT | SPECIALCHAR)+ (PERIOD (LETTER | DIGIT | SPECIALCHAR)+)*;
fragment DOMAIN_PART: (LETTER | DIGIT | DASH | PERIOD)+;

//Date Element
fragment DATE_CONTENTS: DAY '/' MONTH '/' YEAR;

fragment DAY: ('0' [1-9]) | ([1-2] DIGIT) | ('3' [0-1]);
fragment MONTH: ('0' [1-9]) | ('1' [0-2]);
fragment YEAR: '2' (('0' DIGIT DIGIT) | ('1' '0' '0'));

//Phone Element
fragment PHONE_CONTENTS: ('(')* DIGIT DIGIT DIGIT (') ' | DASH | PERIOD | SPACE) DIGIT DIGIT DIGIT (DASH | PERIOD | SPACE) DIGIT DIGIT DIGIT DIGIT;

//Creditcard Element
fragment CREDIT_CARD_CONTENTS: (VISA | MASTERCARD | AMERICAN_EXPRESS | DINERS_CLUB | DISCOVER | JCB);

fragment ELEVEN_DIGIT: DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT DASH* DIGIT;
fragment TWELVE_DIGIT: ELEVEN_DIGIT DASH* DIGIT;
fragment THIRTEEN_DIGIT: TWELVE_DIGIT DASH* DIGIT;
fragment FOURTEEN_DIGIT: THIRTEEN_DIGIT DASH* DIGIT;
fragment FIFTEEN_DIGIT: FOURTEEN_DIGIT DASH* DIGIT;

VISA: '4' (TWELVE_DIGIT | FIFTEEN_DIGIT);
MASTERCARD: '5' [1-5] FOURTEEN_DIGIT;
AMERICAN_EXPRESS: '3' ('4' | '7') THIRTEEN_DIGIT;
DINERS_CLUB: '3' (('0' [0-5] ELEVEN_DIGIT) | (('6' | '8') TWELVE_DIGIT));
DISCOVER: ('6011' TWELVE_DIGIT) | ('65' FOURTEEN_DIGIT);
JCB: (('2131' | '1800') ELEVEN_DIGIT) | ('35' FOURTEEN_DIGIT);

//Other Element

fragment OTHER_CONTENTS: (LETTER | DIGIT | SPECIALCHAR | SPACE)*;

//---------------------------ELEMENT RULES-----------------------------

BAD_ELEMENT_NAME: '<' ('/')* ALT_XML .*? NEWLINE {
	System.out.println("Bad Element Name: " + getText() + " - cannot contain 'XML' or a variation of it.");
};

EMAIL_ELEMENT:
	('<' EMAIL_NAME '>' EMAIL_CONTENTS '</' EMAIL_NAME '>' {
		System.out.println("Email found: " + getText()); }
	|'<' EMAIL_NAME '>' .*? '</' EMAIL_NAME '>' {
		System.out.println("Bad email element format: " + getText());
	}
	)
;

DATE_ELEMENT: 
	('<' DATE_NAME '>' DATE_CONTENTS '</' DATE_NAME '>' { System.out.println("Date found: " + getText()); }
	|'<' DATE_NAME '>' .*? '</' DATE_NAME '>' {
		System.out.println("Bad date element format: " + getText());
	}
	)
;

PHONE_ELEMENT: 
	('<' PHONE_NAME '>' PHONE_CONTENTS '</' PHONE_NAME '>' { System.out.println("Phone number found: " + getText()); }
	|'<' PHONE_NAME '>' .*? '</' PHONE_NAME '>' {
		System.out.println("Bad phone element format: " + getText());
	}
	)
;

CREDIT_CARD_ELEMENT: 
	('<' CREDIT_CARD_NAME '>' CREDIT_CARD_CONTENTS '</' CREDIT_CARD_NAME '>' { System.out.println("Credit card found: " + getText()); }
	|'<' CREDIT_CARD_NAME '>' .*? '</' CREDIT_CARD_NAME '>' {
		System.out.println("Bad credit card element format: " + getText());
	}
	)
;

OTHER_ELEMENT: START_TOKEN OTHER_CONTENTS END_TOKEN
	{ System.out.println("Custom element found: " + getText()); } ;

DONOTHING: (NEWLINE | CARRIAGER)+
	{ skip(); };

//define rules
