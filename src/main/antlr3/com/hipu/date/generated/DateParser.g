parser grammar DateParser;

options {
  tokenVocab=DateLexer;
  output=AST;
}

import NumericRules;

tokens {
  INT;
  MONTH_OF_YEAR;
  DAY_OF_MONTH;
  DAY_OF_WEEK;
  DAY_OF_YEAR;
  YEAR_OF;
  DATE_TIME;
  DATE_TIME_ALTERNATIVE;
  EXPLICIT_DATE;
  RELATIVE_DATE;
  SEEK;
  DIRECTION;
  SEEK_BY;
  EXPLICIT_SEEK;
  SPAN;
  EXPLICIT_TIME;
  RELATIVE_TIME;
  HOURS_OF_DAY;
  MINUTES_OF_HOUR;
  SECONDS_OF_MINUTE;
  AM_PM;
  ZONE;
  ZONE_OFFSET;
  RECURRENCE;
  HOLIDAY;
  SEASON;
}

@header {
  package com.hipu.date.generated;
}

@members {
  private java.util.logging.Logger _logger = java.util.logging.Logger.getLogger("com.hipu.date");
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException re) {
    String message = getErrorHeader(re);
    try { message += getErrorMessage(re, tokenNames); } catch(Exception e) {}
    _logger.fine(message);
  }
}

parse
  : empty ((recurrence)=>recurrence | date_time_alternative)
  ;
//  
recurrence
  : date_time_alternative
  ;
  
empty
  :
  ;

// date and time, support 2012-3-4 (at, comma, -, /) 10:34
// time and date, support 10:34 (on,of,comma) 2012-3-4
//     DATE_TIME
//        |
//     date time
date_time
  :
    (
    (date)=>date (date_time_separator explicit_time)?|
      explicit_time (time_date_separator date)? 
    ) -> ^(DATE_TIME date? explicit_time?)
  | relative_time -> ^(DATE_TIME relative_time)
  ;
  
date_time_separator
  : WHITE_SPACE? (AT WHITE_SPACE)?
  | WHITE_SPACE? COMMA WHITE_SPACE? (AT WHITE_SPACE)?
  | T
  | WHITE_SPACE? SLASH WHITE_SPACE?
  | WHITE_SPACE? DASH WHITE_SPACE?
  ;

time_date_separator
  : WHITE_SPACE ((ON | OF) WHITE_SPACE)?
  | COMMA WHITE_SPACE? ((ON | OF) WHITE_SPACE)?
  ;

date
  : formal_date
  | relaxed_date
  | relative_date
  ;
  

date_time_alternative
    :  date_time -> ^(DATE_TIME_ALTERNATIVE date_time)
  ;
  
// ********** relaxed date rules **********
// relaxed date with a spelled-out or abbreviated month, these monthes must be chinese yiyue, 1yue or jan.
relaxed_date
  : 
      // The 31st of April in the year 2008
      // RFC822 style: Fri, 21 Nov 1997 | 97, day month year
  relaxed_day_of_month  formal_date_separator (OF WHITE_SPACE)?  relaxed_month  relaxed_year_prefix relaxed_year
      -> ^(EXPLICIT_DATE relaxed_month relaxed_day_of_month  relaxed_year)
  | relaxed_day_of_month  DAY? formal_date_separator?  crelaxed_month  formal_date_separator? relaxed_year YEAR?
      -> ^(EXPLICIT_DATE  crelaxed_month relaxed_day_of_month  relaxed_year)
      // eryue 21, 1997 
  | crelaxed_month formal_date_separator? relaxed_day_of_month DAY? formal_date_separator? relaxed_year YEAR?
      -> ^(EXPLICIT_DATE crelaxed_month relaxed_day_of_month  relaxed_year)
      // Jan 21, 1997   Sun, Nov 21,month day year
  | relaxed_month formal_date_separator relaxed_day_of_month  relaxed_year_prefix relaxed_year
      -> ^(EXPLICIT_DATE relaxed_month  relaxed_day_of_month  relaxed_year)
      //2012nian 8yue 9,year month day
  | formal_year WHITE_SPACE* YEAR (SLASH|WHITE_SPACE)* (relaxed_month|crelaxed_month) (SLASH|WHITE_SPACE)*  relaxed_day_of_month WHITE_SPACE* DAY? 
      -> ^(EXPLICIT_DATE relaxed_month? crelaxed_month? relaxed_day_of_month  formal_year)
  ;
  
//1yue yiyue
crelaxed_month
  : ( formal_month_of_year | cformal_month_of_year )  WHITE_SPACE? MONTH
    ->formal_month_of_year? cformal_month_of_year?
  ;

// english spelled month name
relaxed_month
  : JANUARY   -> ^(MONTH_OF_YEAR INT["1"])
  | FEBRUARY  -> ^(MONTH_OF_YEAR INT["2"])
  | MARCH    -> ^(MONTH_OF_YEAR INT["3"])
  | APRIL      -> ^(MONTH_OF_YEAR INT["4"])
  | MAY       -> ^(MONTH_OF_YEAR INT["5"])
  | JUNE      -> ^(MONTH_OF_YEAR INT["6"])
  | JULY      -> ^(MONTH_OF_YEAR INT["7"])
  | AUGUST    -> ^(MONTH_OF_YEAR INT["8"])
  | SEPTEMBER -> ^(MONTH_OF_YEAR INT["9"])
  | OCTOBER   -> ^(MONTH_OF_YEAR INT["10"])
  | NOVEMBER  -> ^(MONTH_OF_YEAR INT["11"])
  | DECEMBER  -> ^(MONTH_OF_YEAR INT["12"])
  ;
  
relaxed_day_of_month
  : spelled_or_int_01_to_31_optional_prefix
      -> ^(DAY_OF_MONTH spelled_or_int_01_to_31_optional_prefix)
      
  | spelled_first_to_thirty_first
      -> ^(DAY_OF_MONTH spelled_first_to_thirty_first)
  ;
  
// TODO expand these to 366
relaxed_day_of_year
  : spelled_or_int_01_to_31_optional_prefix
      -> ^(DAY_OF_YEAR spelled_or_int_01_to_31_optional_prefix)
      
  | spelled_first_to_thirty_first
      -> ^(DAY_OF_YEAR spelled_first_to_thirty_first)
  ;
 
// 99 or 1987
relaxed_year
  : SINGLE_QUOTE? int_00_to_99_mandatory_prefix
      -> ^(YEAR_OF int_00_to_99_mandatory_prefix)
      
  | int_four_digits
      -> ^(YEAR_OF int_four_digits)
  ;
  
relaxed_year_prefix
  : 
    WHITE_SPACE? DASH DASH WHITE_SPACE?
  | WHITE_SPACE? SLASH WHITE_SPACE?
  | WHITE_SPACE? DOT WHITE_SPACE?
  | WHITE_SPACE? COMMA WHITE_SPACE?
  | WHITE_SPACE
  | IN WHITE_SPACE THE WHITE_SPACE YEAR WHITE_SPACE
  ; 
  
// ********** formal date rules **********
//

//              EXPLICIT_DATE
//                    |
//    MONTH_OF_YEAR     DAY_OF_MONTH    YEAR_OF
formal_date
  :
  //20100312
   formal_201x_year  explicit_formal_month_of_year  explicit_formal_day_of_month 
     -> ^(EXPLICIT_DATE explicit_formal_month_of_year explicit_formal_day_of_month ^(DAY_OF_WEEK INT["8"])  formal_201x_year)
     
  // year last: 1/02/1980. 4 digit year is acceptable 
  | expand_formal_day_of_month formal_date_separator formal_day_of_month formal_date_separator formal_year_four_digits
      -> ^(EXPLICIT_DATE expand_formal_day_of_month formal_day_of_month ^(DAY_OF_WEEK INT["9"]) formal_year_four_digits)
      
  // year first: 1979-02-28, 80/01/02, etc.
  | formal_year formal_date_separator expand_formal_day_of_month formal_date_separator formal_day_of_month
      -> ^(EXPLICIT_DATE expand_formal_day_of_month formal_day_of_month ^(DAY_OF_WEEK INT["8"])  formal_year)
	  
	// year last: 1/er/1980  2 or 4 digit year is acceptable 
  | formal_day_of_month formal_date_separator cformal_month_of_year formal_date_separator formal_year
      -> ^(EXPLICIT_DATE cformal_month_of_year formal_day_of_month formal_year)
  ;
  
formal_month_of_year
  : int_01_to_12_optional_prefix -> ^(MONTH_OF_YEAR int_01_to_12_optional_prefix)
  ;
explicit_formal_month_of_year
  : explicit_int_01_to_12_optional_prefix -> ^(MONTH_OF_YEAR explicit_int_01_to_12_optional_prefix)
  ;
  
cformal_month_of_year
  : cint_1_to_12  -> ^(MONTH_OF_YEAR cint_1_to_12)
  ;

expand_formal_day_of_month
  : int_0_to_99_mandatory_prefix -> ^(MONTH_OF_YEAR int_0_to_99_mandatory_prefix)
  ;

formal_day_of_month
  : int_0_to_99_mandatory_prefix -> ^(DAY_OF_MONTH int_0_to_99_mandatory_prefix)
  ;
explicit_formal_day_of_month
  : explicit_int_01_to_31_optional_prefix -> ^(DAY_OF_MONTH explicit_int_01_to_31_optional_prefix)
  ;
  
formal_year
  : formal_year_four_digits
  | int_0_to_99_mandatory_prefix -> ^(YEAR_OF int_0_to_99_mandatory_prefix)
  ;
  
formal_year_four_digits
  : int_four_digits -> ^(YEAR_OF int_four_digits)
  ; 

formal_201x_year
  : int_201x_digits -> ^(YEAR_OF int_201x_digits)
  ;
  
formal_date_separator
  : WHITE_SPACE? DASH WHITE_SPACE?
  | WHITE_SPACE? SLASH WHITE_SPACE?
  | WHITE_SPACE? DOT WHITE_SPACE?
  | WHITE_SPACE
  | WHITE_SPACE? COMMA WHITE_SPACE?
  ;
  
// ********** relative date rules **********
//                  RELATIVE_DATE
//                        |
//                      SEEK
//                        |
//              DIRECTION  SEEK_BY INT  SPAN
relative_date
  :
  // 1 day ago
  spelled_or_int_optional_prefix WHITE_SPACE? relative_target WHITE_SPACE? relative_date_suffix 
      -> ^(RELATIVE_DATE ^(SEEK relative_date_suffix? spelled_or_int_optional_prefix relative_target?))
      
  // today, tomorrow
  | named_relative_date 
  ;
  
//explicit_relative_month
//  : relaxed_month
//  | MONTH -> SPAN["month"]
//  ;
  
relative_target
  : relaxed_month
  | relative_date_span
  ;
  
relative_date_suffix
  : AGO -> DIRECTION["<"] SEEK_BY["by_day"]
  | CAGO -> DIRECTION["<"] SEEK_BY["by_day"]
  ;
  
relative_time_suffix
  :  AGO 
      -> DIRECTION["<"] SEEK_BY["by_day"]
  | CAGO 
      -> DIRECTION["<"] SEEK_BY["by_day"]
  ;
  
relative_time_suffix_anchor
  : named_relative_time 
  | explicit_time
    -> ^(EXPLICIT_SEEK explicit_time)
  ;
  
relative_date_span
  : DAY   -> SPAN["day"]
  | WEEK  -> SPAN["week"]
  | MONTH -> SPAN["month"]
  | YEAR  -> SPAN["year"]
  ;

// zuotian qiantian  
named_relative_date
  : (TODAY | NOW) -> ^(RELATIVE_DATE ^(SEEK DIRECTION[">"] SEEK_BY["by_day"] INT["0"] SPAN["named_day"]))
  | TOMORROW      -> ^(RELATIVE_DATE ^(SEEK DIRECTION[">"] SEEK_BY["by_day"] INT["1"] SPAN["named_day"]))
  | YESTERDAY     -> ^(RELATIVE_DATE ^(SEEK DIRECTION["<"] SEEK_BY["by_day"] INT["1"] SPAN["named_day"]))
  | BEFORE_YESTERDAY    -> ^(RELATIVE_DATE ^(SEEK DIRECTION["<"] SEEK_BY["by_day"] INT["2"] SPAN["named_day"]))
  ;
  
named_relative_time
  : NOW -> ^(RELATIVE_DATE ^(SEEK DIRECTION[">"] SEEK_BY["by_day"] INT["0"] SPAN["named_day"]))
  ;
  
prefix
  : implicit_prefix
  ;
  
implicit_prefix
  : THIS -> DIRECTION[">"] SEEK_BY["by_day"] INT["0"]
  ;
  
relative_date_prefix
  : (THIS WHITE_SPACE)? LAST     -> DIRECTION["<"] SEEK_BY["by_week"] INT["1"]
  ;
  
relative_time_target
  : relative_time_span
  ;
  
relative_time_span
  : HOUR   -> SPAN["hour"]
  | MINUTE -> SPAN["minute"]
  | SECONDS -> SPAN["second"]
  ;

// ********** time rules **********
//                RELATIVE_TIME
//                      |
//                    SEEK
//                      |
//            DIRECTION SEEK_BY INT SPAN

relative_time
  // 10 hours ago, 20 minutes before noon
  // shelton : spelled_or_int_optional_prefix WHITE_SPACE relative_time_target WHITE_SPACE relative_time_suffix ->
  //           spelled_or_int_optional_prefix WHITE_SPACE? relative_time_target WHITE_SPACE? relative_time_suffix
  : 
  //1 hours 30 minutes ago
    spelled_or_int_optional_prefix WHITE_SPACE? HOUR WHITE_SPACE? minutes WHITE_SPACE? MINUTE WHITE_SPACE? relative_time_suffix 
    -> ^(RELATIVE_TIME ^(SEEK relative_time_suffix? spelled_or_int_optional_prefix SPAN["hour"]))
   
  | HALF_HOUR  relative_time_suffix
    -> ^(RELATIVE_TIME ^(SEEK relative_time_suffix? INT["30"] SPAN["minute"]))
  | spelled_or_int_optional_prefix WHITE_SPACE? relative_time_target WHITE_SPACE? relative_time_suffix 
    -> ^(RELATIVE_TIME ^(SEEK relative_time_suffix? spelled_or_int_optional_prefix relative_time_target))
    
  // next hour, last minute
  | prefix WHITE_SPACE relative_time_target
    -> ^(RELATIVE_TIME ^(SEEK prefix relative_time_target))
  ;

// a time with an hour, optional minutes, and optional meridian indicator
//shelton:must obey 12:23:12  12am 
//                            EXPLICIT_TIME
//                                  |
//HOURS_OF_DAY  MINUTES_OF_HOUR SECONDS_OF_MINUTE AM_PM (ZONE|ZONE_OFFSET)
explicit_time
  // 
  : hours COLON minutes (COLON seconds)? (WHITE_SPACE? (meridian_indicator | (MILITARY_HOUR_SUFFIX | HOUR)))? (WHITE_SPACE? time_zone)?
      -> ^(EXPLICIT_TIME hours minutes seconds? meridian_indicator? time_zone?)
      
  | hours WHITE_SPACE? meridian_indicator (WHITE_SPACE? time_zone)?
      -> ^(EXPLICIT_TIME hours ^(MINUTES_OF_HOUR INT["0"]) meridian_indicator time_zone?)
      
  | (c_meridian_indicator)?  hours WHITE_SPACE? CHOUR WHITE_SPACE? minutes WHITE_SPACE? MINUTE (WHITE_SPACE? seconds)?
       -> ^(EXPLICIT_TIME hours minutes seconds? c_meridian_indicator?)
       
  | (c_meridian_indicator)? WHITE_SPACE? hours COLON minutes (COLON seconds)?
      -> ^(EXPLICIT_TIME hours minutes seconds? c_meridian_indicator?)
  ;
 
// hour of the day
hours
  : int_00_to_23_optional_prefix -> ^(HOURS_OF_DAY int_00_to_23_optional_prefix)
  ;
  
// minutes of the hour
minutes
  : int_00_to_59_mandatory_prefix -> ^(MINUTES_OF_HOUR int_00_to_59_mandatory_prefix)
//  | int_1_to_9_prefix -> ^(MINUTES_OF_HOUR int_1_to_9_prefix)
  ;
  
// seconds of the minute 
seconds
  : int_00_to_59_mandatory_prefix -> ^(SECONDS_OF_MINUTE int_00_to_59_mandatory_prefix)
  ;
  
// meridian am/pm indicator
meridian_indicator
  : AM -> AM_PM["am"]
  | PM -> AM_PM["pm"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? MORNING -> AM_PM["am"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? NOON -> AM_PM["pm"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? EVENING -> AM_PM["pm"]
  | (AT WHITE_SPACE)? NIGHT -> AM_PM["pm"]
  ;

//zaoshang  morning
c_meridian_indicator
  : MORNING -> AM_PM["am"]
  | NGIHT -> AM_PM["pm"]
  | NOON  -> AM_PM["pm"]
  ;
 
// in the noon at ngiht
named_time
  : (IN WHITE_SPACE THE WHITE_SPACE)? NOON    -> ^(HOURS_OF_DAY INT["12"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["pm"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? MORNING -> ^(HOURS_OF_DAY INT["8"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["am"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? NIGHT   -> ^(HOURS_OF_DAY INT["8"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["pm"]
  | TONIGHT                                   -> ^(HOURS_OF_DAY INT["8"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["pm"]
  | (AT WHITE_SPACE)? MIDNIGHT                -> ^(HOURS_OF_DAY INT["12"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["am"]
  | (IN WHITE_SPACE THE WHITE_SPACE)? EVENING -> ^(HOURS_OF_DAY INT["7"]) ^(MINUTES_OF_HOUR INT["0"]) ^(SECONDS_OF_MINUTE INT["0"]) AM_PM["pm"]
  ;
 
// utc or  +5:0  
time_zone
  :  time_zone_offset 
  |  time_zone_abbreviation 
  ;
  
time_zone_offset
  : (PLUS | DASH) hours COLON minutes
      -> ZONE_OFFSET[$time_zone_offset.text]
  ;
      
time_zone_abbreviation
  : UTC  -> ZONE["UTC"]
  | EST  -> ZONE["America/New_York"]
  | CST  -> ZONE["America/Chicago"]
  | PST  -> ZONE["America/Los_Angeles"]
  | MST  -> ZONE["America/Denver"]
  | AKST -> ZONE["America/Anchorage"]
  | HAST -> ZONE["Pacific/Honolulu"]
  | KST  -> ZONE["KST"]
  ; 