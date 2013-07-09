lexer grammar DateLexer;

@header { package com.hipu.date.generated; }


//insert these members and methods to the generaed code
@members {
  private java.util.logging.Logger _logger = java.util.logging.Logger.getLogger("com.hipu.date");
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException re) {
    String message = getErrorHeader(re);
    try { message += getErrorMessage(re, tokenNames); } catch(Exception e) {}
    _logger.fine(message);
  }
}

// ********** date rules ********** 

JANUARY   : 'january'   's'?  | 'jan' DOT?  ;
FEBRUARY  : 'february'  's'?  | 'feb' DOT?  ;
MARCH     : 'march'     'es'? | 'mar' DOT?  ;
APRIL     : 'april'     's'?  | 'apr' DOT?  ;
MAY       : 'may'       's'?  ;
JUNE      : 'june'      's'?  | 'jun' DOT?  ;
JULY      : 'july'      's'?  | 'jul' DOT?  ;
AUGUST    : 'august'    's'?  | 'aug' DOT?  ;
SEPTEMBER : 'september' 's'?  | 'sep' DOT? | 'sept' DOT?;
OCTOBER   : 'october'   's'?  | 'oct' DOT?  ;
NOVEMBER  : 'november'  's'?  | 'nov' DOT?  ;
DECEMBER  : 'december'  's'?  | 'dec' DOT?  ;

//xingqiyi \u661f\u671f\u4e00 zhouyi \u5468\u4e00
//xignqier \u661f\u671f\u4e8c zhouer \u5468\u4e8c
//xingqisan \u661f\u671f\u4e09zhousan \u5468\u4e09
//xingqisi \u661f\u671f\u56db zhuosi \u5468\u56db
//xingqiwu \u661f\u671f\u4e94 zhouwu \u5468\u4e94
//xignqiliu \u661f\u671f\u516d zhouliu \u5468\u516d
//xignqitian \u661f\u671f\u5929 zhoutian \u5468\u5929 zhouri \u5468\u65e5

SUNDAY    : 'sunday'    's'?  | 'sun' DOT?  | 'suns' DOT? | '\u661f\u671f\u5929'| '\u5468\u5929' | '\u5468\u65e5';
MONDAY    : 'monday'    's'?  | 'mon' DOT?  | 'mons' DOT? | '\u661f\u671f\u4e00'| '\u5468\u4e00';
TUESDAY   : 'tuesday'   's'?  | 'tues' DOT? | 'tue' DOT?  | '\u661f\u671f\u4e8c'| '\u5468\u4e8c';
WEDNESDAY : 'wednesday' 's'?  | 'wed' DOT?  | 'weds' DOT? | '\u661f\u671f\u4e09'| '\u5468\u4e09';
THURSDAY  : 'thursday'  's'?  | 'thur' DOT? | 'thu' DOT?   | 'thus' DOT? | 'thurs' DOT? | '\u661f\u671f\u56db'| '\u5468\u56db';
FRIDAY    : 'friday'    's'?  | 'fri' DOT?  | 'fris' DOT? | '\u661f\u671f\u4e94'| '\u5468\u4e94';
SATURDAY  : 'saturday'  's'?  | 'sat' DOT?  | 'sats' DOT?  | 'weekend'  | '\u661f\u671f\u516d'| '\u5468\u516d';

//xiaoshi \u5c0f\u65f6 dian \u70b9
HALF_HOUR : '\u534a\u5c0f\u65f6' | 'half hour' | 'half an hour';
CHOUR   : '\u70b9'  | '\u65f6';
HOUR   : 'hour'   | 'hours'   | 'hr' DOT?    | 'hrs' DOT? | '\u5c0f' '\u65f6';
//miao zhong : \u79d2\u949f
SECONDS : 's'     | 'seconds' | 'sec'   |'secs' | '\u79d2' '\u949f'?;
//fenzhong \u5206\u949f
MINUTE : 'minute' | 'minutes' | 'min' DOT?   | 'mins' DOT?| '\u5206' WHITE_SPACE? '\u949f'?;
//tian \u5929 ri \u65e5 hao \u53f7
DAY    : 'day'    | 'days'    | '\u5929' | '\u65e5' | '\u53f7';
//xingqi \u661f\u671f   zhou \u5468
WEEK   : 'week'   | 'weeks'   | 'wks' DOT?  | '\u661f\u671f'       | '\u5468';
//geyuefen \u4e2a\u6708\u4efd 
MONTH  : 'month'  | 'months'  | '\u4e2a'? '\u6708' '\u4efd'?;
//nianfen \u5e74\u4efd
YEAR   : 'year'   | 'year' SINGLE_QUOTE? 's' | 'yrs' DOT? | '\u5e74' '\u4efd'?;
//jintian \u4eca\u5929 jinri \u4eca\u65e5
TODAY     : 'today' | '\u4eca\u5929' | '\u4eca\u65e5';
//mingtian \u660e\u5929
TOMORROW  : 'tomorow'   | 'tomorrow'   | 'tommorow' | 'tommorrow' | '\u660e\u5929';
//zuotian \u6628\u5929
YESTERDAY : 'yesterday' | '\u6628\u5929';
//qiantian \u524d\u5929
BEFORE_YESTERDAY  : '\u524d\u5929';
//jinwan jintianwanshang
TONIGHT   : 'tonight' | '\u4eca\u665a' | TODAY? '\u665a\u4e0a';  

// ********** recurrence rules **********

//EVERY : 'every';
//UNTIL : 'until';

// ********** time rules ********** 
//zai:\u5728
AT        : 'at' | '@' | '\u5728';
//zhihou\u4e4b\u540e
//CAFTER    : '\u4e4b'? '\u540e';
AFTER     : 'after';
//guoqude \u8fc7\u53bb\u7684
PAST      : 'past' | '\u8fc7\u53bb' '\u7684'?;
AM : 'am' | 'a.m' DOT? | 'a';
PM : 'pm' | 'p.m' DOT? | 'p';
T  : 't';

MILITARY_HOUR_SUFFIX : 'h';	

MIDNIGHT  : 'midnight' | 'mid-night';
//xiawu \u4e0b\u5348
NOON      : 'noon'     | 'afternoon' | 'after-noon' | '\u4e0b\u5348';
//shangwu \u4e0a\u5348 zaoshang \u65e9\u4e0a lingchen \u51cc\u6668
MORNING   : 'morning'   | '\u4e0a\u5348' | '\u65e9\u4e0a' | '\u51cc\u6668';

EVENING   : 'evening' | 'eve';
//wanshang  \u665a\u4e0a
NIGHT     : 'night'   | '\u665a\u4e0a'; 

UTC  : 'utc'  | 'gmt'  | 'z';
EST  : 'est'  | 'edt'  | 'et';
PST  : 'pst'  | 'pdt'  | 'pt';
CST  : 'cst'  | 'cdt'  | 'ct';
MST  : 'mst'  | 'mdt'  | 'mt';
AKST : 'akst' | 'akdt' | 'akt';
HAST : 'hast' | 'hadt' | 'hat' | 'hst';
KST  : 'kst';

// ********* numeric rules **********

/*
yi \u4e00
er \u4e8c
san  \u4e09
si \u56db
wu \u4e94
liu \u516d
qi \u4e03
ba \u516b
jiu \u4e5d
shi \u5341

*/

CINT_1 :  '\u4e00';
CINT_2 :  '\u4e8c';
CINT_3 :  '\u4e09';
CINT_4 :  '\u56db';
CINT_5 :  '\u4e94';
CINT_6 :  '\u516d';
CINT_7 :  '\u4e03';
CINT_8 :  '\u516b';
CINT_9 :  '\u4e5d';
CINT_10 : '\u5341';

INT_00 : '00';
INT_01 : '01';
INT_02 : '02';
INT_03 : '03';
INT_04 : '04';
INT_05 : '05';
INT_06 : '06';
INT_07 : '07';
INT_08 : '08';
INT_09 : '09';
INT_0  : '0' ;
INT_1 : '1';
INT_2 : '2';
INT_3 : '3';
INT_4 : '4';
INT_5 : '5';
INT_6 : '6';
INT_7 : '7';
INT_8 : '8';
INT_9 : '9';
INT_10 :  '10';
INT_11 :  '11';
INT_12 :  '12';
INT_13 :  '13';
INT_14 :  '14';
INT_15 :  '15';
INT_16 :  '16';
INT_17 :  '17';
INT_18 :  '18';
INT_19 :  '19';
INT_20 :  '20';
INT_21 :  '21';
INT_22 :  '22';
INT_23 :  '23';
INT_24 :  '24';
INT_25 :  '25';
INT_26 :  '26';
INT_27 :  '27';
INT_28 :  '28';
INT_29 :  '29';
INT_30 :  '30';
INT_31 :  '31';
INT_32 :  '32';
INT_33 :  '33';
INT_34 :  '34';
INT_35 :  '35';
INT_36 :  '36';
INT_37 :  '37';
INT_38 :  '38';
INT_39 :  '39';
INT_40 :  '40';
INT_41 :  '41';
INT_42 :  '42';
INT_43 :  '43';
INT_44 :  '44';
INT_45 :  '45';
INT_46 :  '46';
INT_47 :  '47';
INT_48 :  '48';
INT_49 :  '49';
INT_50 :  '50';
INT_51 :  '51';
INT_52 :  '52';
INT_53 :  '53';
INT_54 :  '54';
INT_55 :  '55';
INT_56 :  '56';
INT_57 :  '57';
INT_58 :  '58';
INT_59 :  '59';
INT_60 :  '60';
INT_61 :  '61';
INT_62 :  '62';
INT_63 :  '63';
INT_64 :  '64';
INT_65 :  '65';
INT_66 :  '66';
INT_67 :  '67';
INT_68 :  '68';
INT_69 :  '69';
INT_70 :  '70';
INT_71 :  '71';
INT_72 :  '72';
INT_73 :  '73';
INT_74 :  '74';
INT_75 :  '75';
INT_76 :  '76';
INT_77 :  '77';
INT_78 :  '78';
INT_79 :  '79';
INT_80 :  '80';
INT_81 :  '81';
INT_82 :  '82';
INT_83 :  '83';
INT_84 :  '84';
INT_85 :  '85';
INT_86 :  '86';
INT_87 :  '87';
INT_88 :  '88';
INT_89 :  '89';
INT_90 :  '90';
INT_91 :  '91';
INT_92 :  '92';
INT_93 :  '93';
INT_94 :  '94';
INT_95 :  '95';
INT_96 :  '96';
INT_97 :  '97';
INT_98 :  '98';
INT_99 :  '99';

ONE       : 'one';
TWO       : 'two';
THREE     : 'three';
FOUR      : 'four';
FIVE      : 'five';
SIX       : 'six';
SEVEN     : 'seven';
EIGHT     : 'eight';
NINE      : 'nine';
TEN       : 'ten';
ELEVEN    : 'eleven';
TWELVE    : 'twelve';
THIRTEEN  : 'thirteen';
FOURTEEN  : 'fourteen';
FIFTEEN   : 'fifteen';
SIXTEEN   : 'sixteen';
SEVENTEEN : 'seventeen';
EIGHTEEN  : 'eighteen' | 'eightteen';
NINETEEN  : 'nineteen';
TWENTY    : 'twenty';
THIRTY    : 'thirty';

FIRST          : 'first';
SECOND         : 'second' | 'seconds' | 'sec' | 'secs';
THIRD          : 'third';
FOURTH         : 'fourth';
FIFTH          : 'fifth';
SIXTH          : 'sixth';
SEVENTH        : 'seventh';
EIGHTH         : 'eighth';
NINTH          : 'ninth';
TENTH          : 'tenth';
ELEVENTH       : 'eleventh';
TWELFTH        : 'twelfth';
THIRTEENTH     : 'thirteenth';
FOURTEENTH     : 'fourteenth';
FIFTEENTH      : 'fifteenth';
SIXTEENTH      : 'sixteenth';
SEVENTEENTH    : 'seventeenth';
EIGHTEENTH     : 'eighteenth';
NINETEENTH     : 'nineteenth';
TWENTIETH      : 'twentieth';
THIRTIETH      : 'thirtieth';

// ********** suffixes **********
ST : 'st';
ND : 'nd';
RD : 'rd';
TH : 'th';
   
// ********** common rules **********
//maohao \uff1a
COLON : ':' | '\uff1a';
//douhao \uff0c
COMMA : ',' | '\uff0c';
//
DASH  : '-';
SLASH : '/' | '|';
DOT   : '.';
PLUS  : '+';
SINGLE_QUOTE : '\'';

LEFT_PARENTHESIS : '(' | '\uff08';
RIGHT_PARENTHESIS: ')' | '\uff09';

FOR       : 'for';
IN        : 'in';
AN        : 'an';
THE       : 'the';
//OR        : 'or';
//AND       : 'and';
//TO        : 'to';
THROUGH   : 'through';
ON        : 'on';
OF        : 'of';
THIS      : 'this';
//THAT      : 'that';
LAST      : 'last' | 'final';
NEXT      : 'next';
COMING    : 'coming';
UPCOMING  : 'upcoming';
FROM      : 'from';
NOW       : 'now';
//zhiqian \u4e4b\u524d
CAGO      : '\u4e4b'? '\u524d';
AGO       : 'ago';
BEFORE    : 'before';
BEGINNING : 'beginning' | 'begining';
START     : 'start';
END       : 'end';

WHITE_SPACE
  : (DOT | SPACE)+
  ;
  
// ********** holiday specific **********
// shelton : do not need these hpliday
//FOOL         : 'fool' | 'fools' | 'fool' SINGLE_QUOTE 's';
//BLACK        : 'black';
//CHRISTMAS    : ('christmas' | 'xmas' | 'x-mas') 'es'?;
//COLUMBUS     : 'columbus';
//EARTH        : 'earth';
//EASTER       : 'easter';
//FATHER       : 'father' | 'fathers' | 'father' SINGLE_QUOTE 's';
//FLAG         : 'flag';
//GOOD         : 'good';
//GROUNDHOG    : GROUND WHITE_SPACE? HOG SINGLE_QUOTE? 's'?;
//HALLOWEEN    : ('halloween' | 'haloween') 's'?;
//INAUGURATION : 'inauguration' | 'inaugaration';
//INDEPENDENCE : 'independence' | 'independance';
//KWANZAA      : ('kwanza' 'a'?) 's'?;
//LABOR        : 'labor';
//MLK          : 'mlk' | 'martin' WHITE_SPACE 'luther' WHITE_SPACE 'king' SINGLE_QUOTE? 's'? ('jr' DOT? SINGLE_QUOTE? 's'?)?;
//MEMORIAL     : 'memorial';
//MOTHER       : 'mother' SINGLE_QUOTE? 's'?;
//NEW          : 'new';
//PALM         : 'palm';
//PATRIOT      : 'patriot' SINGLE_QUOTE? 's'?;
//PRESIDENT    : 'president' SINGLE_QUOTE? 's'?;
//PATRICK      : ('patrick' | 'patty' | 'paddy') SINGLE_QUOTE? 's'?;
//SAINT        : 'saint';
//TAX          : 'tax';
//THANKSGIVING : 'thanksgiving' 's'?;
//ELECTION     : 'election';
//VALENTINE    : 'valentine' SINGLE_QUOTE? 's'?;
//VETERAN      : 'veteran' SINGLE_QUOTE? 's'?;
//fragment GROUND : 'ground';
//fragment HOG    : 'hog';

// ********** season specific **********
// shelton : do not need these season
//chuntian \u6625\u5929    de\u7684
//xiatian  \u590f\u5929
//qiutian \u79cb\u5929
//dongtian \u51ac\u5929
//WINTER : 'winter' 's'?  | '\u51ac\u5929' '\u7684'?;
//FALL   : 'fall'   's'?  | '\u79cb\u5929' '\u7684'?;
//AUTUMN : 'autumn' 's'?  | '\u79cb\u5929' '\u7684'?; 
//SPRING : 'spring' 's'?  | '\u6625\u5929' '\u7684'?;
//SUMMER : 'summer' 's'?  | '\u590f\u5929' '\u7684'?;
  
UNKNOWN
  : UNKNOWN_CHAR
  ;
  
fragment UNKNOWN_CHAR
  : ~(SPACE | DOT)
  ;
  
fragment DIGIT : '0'..'9';
  
fragment SPACE : ' ' | '\t' | '\n' | '\r' | '&nasp' | '\u3000';

WORD  : 'a'..'z'+ ;
