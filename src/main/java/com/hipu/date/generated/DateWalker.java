// $ANTLR 3.2 Sep 23, 2009 14:05:07 com/hipu/date/generated/DateWalker.g 2013-06-26 15:59:29
 package com.hipu.date.generated; 

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DateWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DOT", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "HALF_HOUR", "CHOUR", "HOUR", "SECONDS", "WHITE_SPACE", "MINUTE", "DAY", "WEEK", "MONTH", "SINGLE_QUOTE", "YEAR", "TODAY", "TOMORROW", "YESTERDAY", "BEFORE_YESTERDAY", "TONIGHT", "AT", "AFTER", "PAST", "AM", "PM", "T", "MILITARY_HOUR_SUFFIX", "MIDNIGHT", "NOON", "MORNING", "EVENING", "NIGHT", "UTC", "EST", "PST", "CST", "MST", "AKST", "HAST", "KST", "CINT_1", "CINT_2", "CINT_3", "CINT_4", "CINT_5", "CINT_6", "CINT_7", "CINT_8", "CINT_9", "CINT_10", "INT_00", "INT_01", "INT_02", "INT_03", "INT_04", "INT_05", "INT_06", "INT_07", "INT_08", "INT_09", "INT_0", "INT_1", "INT_2", "INT_3", "INT_4", "INT_5", "INT_6", "INT_7", "INT_8", "INT_9", "INT_10", "INT_11", "INT_12", "INT_13", "INT_14", "INT_15", "INT_16", "INT_17", "INT_18", "INT_19", "INT_20", "INT_21", "INT_22", "INT_23", "INT_24", "INT_25", "INT_26", "INT_27", "INT_28", "INT_29", "INT_30", "INT_31", "INT_32", "INT_33", "INT_34", "INT_35", "INT_36", "INT_37", "INT_38", "INT_39", "INT_40", "INT_41", "INT_42", "INT_43", "INT_44", "INT_45", "INT_46", "INT_47", "INT_48", "INT_49", "INT_50", "INT_51", "INT_52", "INT_53", "INT_54", "INT_55", "INT_56", "INT_57", "INT_58", "INT_59", "INT_60", "INT_61", "INT_62", "INT_63", "INT_64", "INT_65", "INT_66", "INT_67", "INT_68", "INT_69", "INT_70", "INT_71", "INT_72", "INT_73", "INT_74", "INT_75", "INT_76", "INT_77", "INT_78", "INT_79", "INT_80", "INT_81", "INT_82", "INT_83", "INT_84", "INT_85", "INT_86", "INT_87", "INT_88", "INT_89", "INT_90", "INT_91", "INT_92", "INT_93", "INT_94", "INT_95", "INT_96", "INT_97", "INT_98", "INT_99", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY", "THIRTY", "FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "SIXTH", "SEVENTH", "EIGHTH", "NINTH", "TENTH", "ELEVENTH", "TWELFTH", "THIRTEENTH", "FOURTEENTH", "FIFTEENTH", "SIXTEENTH", "SEVENTEENTH", "EIGHTEENTH", "NINETEENTH", "TWENTIETH", "THIRTIETH", "ST", "ND", "RD", "TH", "COLON", "COMMA", "DASH", "SLASH", "PLUS", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "FOR", "IN", "AN", "THE", "THROUGH", "ON", "OF", "THIS", "LAST", "NEXT", "COMING", "UPCOMING", "FROM", "NOW", "CAGO", "AGO", "BEFORE", "BEGINNING", "START", "END", "SPACE", "UNKNOWN_CHAR", "UNKNOWN", "DIGIT", "WORD", "INT", "MONTH_OF_YEAR", "DAY_OF_MONTH", "DAY_OF_WEEK", "DAY_OF_YEAR", "YEAR_OF", "DATE_TIME", "DATE_TIME_ALTERNATIVE", "EXPLICIT_DATE", "RELATIVE_DATE", "SEEK", "DIRECTION", "SEEK_BY", "EXPLICIT_SEEK", "SPAN", "EXPLICIT_TIME", "RELATIVE_TIME", "HOURS_OF_DAY", "MINUTES_OF_HOUR", "SECONDS_OF_MINUTE", "AM_PM", "ZONE", "ZONE_OFFSET", "RECURRENCE", "HOLIDAY", "SEASON", "NGIHT", "WEEK_INDEX"
    };
    public static final int DIRECTION=437;
    public static final int NINETEEN=198;
    public static final int UNKNOWN_CHAR=254;
    public static final int INT_08=78;
    public static final int INT_09=79;
    public static final int TWENTY=199;
    public static final int INT_02=72;
    public static final int INT_03=73;
    public static final int INT_00=70;
    public static final int INT_01=71;
    public static final int APRIL=8;
    public static final int INT_06=76;
    public static final int COMING=243;
    public static final int INT_07=77;
    public static final int INT_04=74;
    public static final int INT_05=75;
    public static final int NOW=246;
    public static final int EOF=-1;
    public static final int MONTH=32;
    public static final int AM_PM=446;
    public static final int EIGHTEENTH=218;
    public static final int SPAN=440;
    public static final int THIS=240;
    public static final int NOON=48;
    public static final int TOMORROW=36;
    public static final int FIFTEENTH=215;
    public static final int TODAY=35;
    public static final int NOVEMBER=15;
    public static final int MONTH_OF_YEAR=427;
    public static final int SEVENTH=207;
    public static final int T=45;
    public static final int FEBRUARY=6;
    public static final int DAY_OF_WEEK=429;
    public static final int THIRTEEN=192;
    public static final int ELEVEN=190;
    public static final int SUNDAY=17;
    public static final int SEVEN=186;
    public static final int EXPLICIT_DATE=434;
    public static final int INT=258;
    public static final int UPCOMING=244;
    public static final int SIX=185;
    public static final int BEGINNING=250;
    public static final int HOLIDAY=450;
    public static final int FIFTH=205;
    public static final int MORNING=49;
    public static final int HALF_HOUR=24;
    public static final int DAY_OF_YEAR=430;
    public static final int DECEMBER=16;
    public static final int AUGUST=12;
    public static final int SECONDS_OF_MINUTE=445;
    public static final int END=252;
    public static final int TUESDAY=19;
    public static final int EXPLICIT_SEEK=439;
    public static final int EVENING=50;
    public static final int THIRD=203;
    public static final int INT_47=127;
    public static final int INT_46=126;
    public static final int INT_45=125;
    public static final int INT_44=124;
    public static final int RD=224;
    public static final int INT_49=129;
    public static final int INT_48=128;
    public static final int THE=236;
    public static final int WHITE_SPACE=28;
    public static final int INT_42=122;
    public static final int INT_43=123;
    public static final int FRIDAY=22;
    public static final int INT_40=120;
    public static final int INT_41=121;
    public static final int AT=40;
    public static final int INT_34=114;
    public static final int INT_33=113;
    public static final int SINGLE_QUOTE=33;
    public static final int INT_36=116;
    public static final int INT_35=115;
    public static final int SLASH=229;
    public static final int INT_38=118;
    public static final int INT_37=117;
    public static final int TONIGHT=39;
    public static final int INT_39=119;
    public static final int NINTH=209;
    public static final int ZONE=447;
    public static final int TWENTIETH=220;
    public static final int PLUS=230;
    public static final int INT_30=110;
    public static final int AM=43;
    public static final int INT_31=111;
    public static final int AN=235;
    public static final int INT_32=112;
    public static final int INT_29=109;
    public static final int INT_28=108;
    public static final int INT_27=107;
    public static final int INT_26=106;
    public static final int INT_25=105;
    public static final int INT_24=104;
    public static final int INT_23=103;
    public static final int INT_22=102;
    public static final int TH=225;
    public static final int FOURTEENTH=214;
    public static final int SIXTEEN=195;
    public static final int AGO=248;
    public static final int ELEVENTH=211;
    public static final int ST=222;
    public static final int TWO=181;
    public static final int HOUR=26;
    public static final int INT_20=100;
    public static final int INT_21=101;
    public static final int JANUARY=5;
    public static final int THIRTEENTH=213;
    public static final int COLON=226;
    public static final int BEFORE_YESTERDAY=38;
    public static final int INT_16=96;
    public static final int INT_15=95;
    public static final int INT_18=98;
    public static final int INT_17=97;
    public static final int INT_12=92;
    public static final int INT_11=91;
    public static final int INT_14=94;
    public static final int INT_13=93;
    public static final int DAY_OF_MONTH=428;
    public static final int INT_19=99;
    public static final int FIFTEEN=194;
    public static final int START=251;
    public static final int NINE=188;
    public static final int THREE=182;
    public static final int FOURTEEN=193;
    public static final int INT_10=90;
    public static final int YESTERDAY=37;
    public static final int SEVENTEENTH=217;
    public static final int FIRST=201;
    public static final int INT_81=161;
    public static final int INT_80=160;
    public static final int SEPTEMBER=13;
    public static final int WEEK=31;
    public static final int INT_83=163;
    public static final int INT_82=162;
    public static final int INT_85=165;
    public static final int INT_84=164;
    public static final int WEDNESDAY=20;
    public static final int INT_87=167;
    public static final int INT_86=166;
    public static final int JULY=11;
    public static final int NINETEENTH=219;
    public static final int OCTOBER=14;
    public static final int DAY=30;
    public static final int ONE=180;
    public static final int MIDNIGHT=47;
    public static final int INT_88=168;
    public static final int MARCH=7;
    public static final int INT_89=169;
    public static final int PAST=42;
    public static final int SEVENTEEN=196;
    public static final int DATE_TIME=432;
    public static final int WORD=257;
    public static final int INT_72=152;
    public static final int INT_71=151;
    public static final int RECURRENCE=449;
    public static final int INT_70=150;
    public static final int INT_76=156;
    public static final int INT_75=155;
    public static final int INT_74=154;
    public static final int INT_73=153;
    public static final int LEFT_PARENTHESIS=231;
    public static final int MINUTES_OF_HOUR=444;
    public static final int THIRTIETH=221;
    public static final int LAST=241;
    public static final int INT_79=159;
    public static final int EIGHTEEN=197;
    public static final int INT_77=157;
    public static final int INT_78=158;
    public static final int ND=223;
    public static final int RELATIVE_DATE=435;
    public static final int INT_63=143;
    public static final int INT_62=142;
    public static final int SEASON=451;
    public static final int INT_65=145;
    public static final int FOURTH=204;
    public static final int INT_64=144;
    public static final int SECOND=202;
    public static final int CINT_2=61;
    public static final int CINT_1=60;
    public static final int INT_61=141;
    public static final int INT_60=140;
    public static final int SATURDAY=23;
    public static final int FOUR=183;
    public static final int TEN=189;
    public static final int ON=238;
    public static final int MONDAY=18;
    public static final int JUNE=10;
    public static final int OF=239;
    public static final int INT_66=146;
    public static final int INT_67=147;
    public static final int INT_68=148;
    public static final int INT_69=149;
    public static final int INT_54=134;
    public static final int INT_53=133;
    public static final int INT_52=132;
    public static final int INT_51=131;
    public static final int INT_50=130;
    public static final int THURSDAY=21;
    public static final int RELATIVE_TIME=442;
    public static final int NGIHT=452;
    public static final int DATE_TIME_ALTERNATIVE=433;
    public static final int ZONE_OFFSET=448;
    public static final int SEEK_BY=438;
    public static final int PM=44;
    public static final int CHOUR=25;
    public static final int EXPLICIT_TIME=441;
    public static final int FROM=245;
    public static final int CINT_3=62;
    public static final int CINT_4=63;
    public static final int CINT_5=64;
    public static final int INT_59=139;
    public static final int CINT_6=65;
    public static final int CINT_7=66;
    public static final int INT_57=137;
    public static final int CINT_8=67;
    public static final int INT_58=138;
    public static final int EIGHTH=208;
    public static final int CINT_9=68;
    public static final int INT_55=135;
    public static final int INT_56=136;
    public static final int HOURS_OF_DAY=443;
    public static final int KST=59;
    public static final int YEAR=34;
    public static final int TENTH=210;
    public static final int MAY=9;
    public static final int FOR=233;
    public static final int SECONDS=27;
    public static final int INT_9=89;
    public static final int INT_8=88;
    public static final int INT_7=87;
    public static final int SPACE=253;
    public static final int INT_6=86;
    public static final int INT_5=85;
    public static final int UTC=52;
    public static final int INT_4=84;
    public static final int INT_3=83;
    public static final int AKST=57;
    public static final int INT_2=82;
    public static final int MST=56;
    public static final int INT_1=81;
    public static final int EIGHT=187;
    public static final int INT_0=80;
    public static final int CST=55;
    public static final int IN=234;
    public static final int PST=54;
    public static final int RIGHT_PARENTHESIS=232;
    public static final int UNKNOWN=255;
    public static final int COMMA=227;
    public static final int FIVE=184;
    public static final int THIRTY=200;
    public static final int NEXT=242;
    public static final int DIGIT=256;
    public static final int DOT=4;
    public static final int MILITARY_HOUR_SUFFIX=46;
    public static final int EST=53;
    public static final int HAST=58;
    public static final int DASH=228;
    public static final int YEAR_OF=431;
    public static final int TWELVE=191;
    public static final int WEEK_INDEX=453;
    public static final int BEFORE=249;
    public static final int CAGO=247;
    public static final int AFTER=41;
    public static final int SIXTEENTH=216;
    public static final int SEEK=436;
    public static final int INT_90=170;
    public static final int NIGHT=51;
    public static final int CINT_10=69;
    public static final int INT_97=177;
    public static final int INT_98=178;
    public static final int INT_95=175;
    public static final int INT_96=176;
    public static final int INT_93=173;
    public static final int INT_94=174;
    public static final int INT_91=171;
    public static final int INT_92=172;
    public static final int THROUGH=237;
    public static final int TWELFTH=212;
    public static final int SIXTH=206;
    public static final int INT_99=179;
    public static final int MINUTE=29;

    // delegates
    // delegators


        public DateWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public DateWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return DateWalker.tokenNames; }
    public String getGrammarFileName() { return "com/hipu/date/generated/DateWalker.g"; }


    //  private com.hipu.date.WalkerState _walkerState = new com.hipu.date.WalkerState();
      private com.hipu.date.JodaWalkerState _walkerState = new com.hipu.date.JodaWalkerState();
      private java.util.logging.Logger _logger = java.util.logging.Logger.getLogger("com.hipu.date");
      
      public void displayRecognitionError(String[] tokenNames, RecognitionException re) {
        String message = getErrorHeader(re);
        try { message += getErrorMessage(re, tokenNames); } catch(Exception e) {}
        _logger.fine(message);
      }
      
      public void recover(IntStream input, RecognitionException re) {
        reportError(re);
        _walkerState.clearDateGroup();
      }
      
      public com.hipu.date.JodaWalkerState getState() {
        return _walkerState;
      }



    // $ANTLR start "parse"
    // com/hipu/date/generated/DateWalker.g:31:1: parse : date_time_alternative ( recurrence )? ;
    public final void parse() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:32:3: ( date_time_alternative ( recurrence )? )
            // com/hipu/date/generated/DateWalker.g:32:5: date_time_alternative ( recurrence )?
            {
            pushFollow(FOLLOW_date_time_alternative_in_parse45);
            date_time_alternative();

            state._fsp--;

            // com/hipu/date/generated/DateWalker.g:32:27: ( recurrence )?
            int alt1=2;
            switch ( input.LA(1) ) {
                case RECURRENCE:
                    {
                    alt1=1;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:32:27: recurrence
                    {
                    pushFollow(FOLLOW_recurrence_in_parse47);
                    recurrence();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "parse"


    // $ANTLR start "recurrence"
    // com/hipu/date/generated/DateWalker.g:35:1: recurrence : ^( RECURRENCE ( date_time )? ) ;
    public final void recurrence() throws RecognitionException {
         
            _walkerState.setRecurring();
          
        try {
            // com/hipu/date/generated/DateWalker.g:39:3: ( ^( RECURRENCE ( date_time )? ) )
            // com/hipu/date/generated/DateWalker.g:39:5: ^( RECURRENCE ( date_time )? )
            {
            match(input,RECURRENCE,FOLLOW_RECURRENCE_in_recurrence71); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/hipu/date/generated/DateWalker.g:39:18: ( date_time )?
                int alt2=2;
                switch ( input.LA(1) ) {
                    case DATE_TIME:
                        {
                        alt2=1;
                        }
                        break;
                }

                switch (alt2) {
                    case 1 :
                        // com/hipu/date/generated/DateWalker.g:39:18: date_time
                        {
                        pushFollow(FOLLOW_date_time_in_recurrence73);
                        date_time();

                        state._fsp--;


                        }
                        break;

                }

                 _walkerState.captureDateTime(); 

                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "recurrence"


    // $ANTLR start "date_time_alternative"
    // com/hipu/date/generated/DateWalker.g:42:1: date_time_alternative : ^( DATE_TIME_ALTERNATIVE date_time ) ;
    public final void date_time_alternative() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:43:3: ( ^( DATE_TIME_ALTERNATIVE date_time ) )
            // com/hipu/date/generated/DateWalker.g:43:5: ^( DATE_TIME_ALTERNATIVE date_time )
            {
            match(input,DATE_TIME_ALTERNATIVE,FOLLOW_DATE_TIME_ALTERNATIVE_in_date_time_alternative92); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_date_time_in_date_time_alternative94);
            date_time();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "date_time_alternative"


    // $ANTLR start "date_time"
    // com/hipu/date/generated/DateWalker.g:46:1: date_time : ^( DATE_TIME ( date )? ( time )? ) ;
    public final void date_time() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:50:3: ( ^( DATE_TIME ( date )? ( time )? ) )
            // com/hipu/date/generated/DateWalker.g:50:5: ^( DATE_TIME ( date )? ( time )? )
            {
            match(input,DATE_TIME,FOLLOW_DATE_TIME_in_date_time116); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/hipu/date/generated/DateWalker.g:50:17: ( date )?
                int alt3=2;
                switch ( input.LA(1) ) {
                    case EXPLICIT_DATE:
                    case RELATIVE_DATE:
                        {
                        alt3=1;
                        }
                        break;
                }

                switch (alt3) {
                    case 1 :
                        // com/hipu/date/generated/DateWalker.g:50:17: date
                        {
                        pushFollow(FOLLOW_date_in_date_time118);
                        date();

                        state._fsp--;


                        }
                        break;

                }

                // com/hipu/date/generated/DateWalker.g:50:23: ( time )?
                int alt4=2;
                switch ( input.LA(1) ) {
                    case EXPLICIT_TIME:
                    case RELATIVE_TIME:
                        {
                        alt4=1;
                        }
                        break;
                }

                switch (alt4) {
                    case 1 :
                        // com/hipu/date/generated/DateWalker.g:50:23: time
                        {
                        pushFollow(FOLLOW_time_in_date_time121);
                        time();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }


                _walkerState.captureDateTime(); 
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "date_time"


    // $ANTLR start "date"
    // com/hipu/date/generated/DateWalker.g:53:1: date : ( relative_date | explicit_date );
    public final void date() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:54:3: ( relative_date | explicit_date )
            int alt5=2;
            switch ( input.LA(1) ) {
            case RELATIVE_DATE:
                {
                alt5=1;
                }
                break;
            case EXPLICIT_DATE:
                {
                alt5=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:54:5: relative_date
                    {
                    pushFollow(FOLLOW_relative_date_in_date140);
                    relative_date();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // com/hipu/date/generated/DateWalker.g:55:5: explicit_date
                    {
                    pushFollow(FOLLOW_explicit_date_in_date147);
                    explicit_date();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "date"


    // $ANTLR start "relative_date"
    // com/hipu/date/generated/DateWalker.g:58:1: relative_date : ^( RELATIVE_DATE ( seek )? ( explicit_seek )* ) ;
    public final void relative_date() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:59:3: ( ^( RELATIVE_DATE ( seek )? ( explicit_seek )* ) )
            // com/hipu/date/generated/DateWalker.g:59:5: ^( RELATIVE_DATE ( seek )? ( explicit_seek )* )
            {
            match(input,RELATIVE_DATE,FOLLOW_RELATIVE_DATE_in_relative_date163); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/hipu/date/generated/DateWalker.g:59:21: ( seek )?
                int alt6=2;
                switch ( input.LA(1) ) {
                    case SEEK:
                        {
                        alt6=1;
                        }
                        break;
                }

                switch (alt6) {
                    case 1 :
                        // com/hipu/date/generated/DateWalker.g:59:21: seek
                        {
                        pushFollow(FOLLOW_seek_in_relative_date165);
                        seek();

                        state._fsp--;


                        }
                        break;

                }

                // com/hipu/date/generated/DateWalker.g:59:27: ( explicit_seek )*
                loop7:
                do {
                    int alt7=2;
                    switch ( input.LA(1) ) {
                    case EXPLICIT_SEEK:
                        {
                        alt7=1;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // com/hipu/date/generated/DateWalker.g:59:27: explicit_seek
                	    {
                	    pushFollow(FOLLOW_explicit_seek_in_relative_date168);
                	    explicit_seek();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "relative_date"


    // $ANTLR start "week_index"
    // com/hipu/date/generated/DateWalker.g:62:1: week_index : ^( WEEK_INDEX index= INT ^( DAY_OF_WEEK day= INT ) ) ;
    public final void week_index() throws RecognitionException {
        CommonTree index=null;
        CommonTree day=null;

        try {
            // com/hipu/date/generated/DateWalker.g:63:3: ( ^( WEEK_INDEX index= INT ^( DAY_OF_WEEK day= INT ) ) )
            // com/hipu/date/generated/DateWalker.g:63:5: ^( WEEK_INDEX index= INT ^( DAY_OF_WEEK day= INT ) )
            {
            match(input,WEEK_INDEX,FOLLOW_WEEK_INDEX_in_week_index186); 

            match(input, Token.DOWN, null); 
            index=(CommonTree)match(input,INT,FOLLOW_INT_in_week_index190); 
            match(input,DAY_OF_WEEK,FOLLOW_DAY_OF_WEEK_in_week_index193); 

            match(input, Token.DOWN, null); 
            day=(CommonTree)match(input,INT,FOLLOW_INT_in_week_index197); 

            match(input, Token.UP, null); 

            match(input, Token.UP, null); 
            _walkerState.setDayOfWeekIndex((index!=null?index.getText():null), (day!=null?day.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "week_index"


    // $ANTLR start "explicit_date"
    // com/hipu/date/generated/DateWalker.g:67:1: explicit_date : ^( EXPLICIT_DATE ^( MONTH_OF_YEAR month= INT ) ^( DAY_OF_MONTH dom= INT ) ( ^( DAY_OF_WEEK dow= INT ) )? ( ^( YEAR_OF year= INT ) )? ) ;
    public final void explicit_date() throws RecognitionException {
        CommonTree month=null;
        CommonTree dom=null;
        CommonTree dow=null;
        CommonTree year=null;

        try {
            // com/hipu/date/generated/DateWalker.g:68:3: ( ^( EXPLICIT_DATE ^( MONTH_OF_YEAR month= INT ) ^( DAY_OF_MONTH dom= INT ) ( ^( DAY_OF_WEEK dow= INT ) )? ( ^( YEAR_OF year= INT ) )? ) )
            // com/hipu/date/generated/DateWalker.g:68:5: ^( EXPLICIT_DATE ^( MONTH_OF_YEAR month= INT ) ^( DAY_OF_MONTH dom= INT ) ( ^( DAY_OF_WEEK dow= INT ) )? ( ^( YEAR_OF year= INT ) )? )
            {
            match(input,EXPLICIT_DATE,FOLLOW_EXPLICIT_DATE_in_explicit_date221); 

            match(input, Token.DOWN, null); 
            match(input,MONTH_OF_YEAR,FOLLOW_MONTH_OF_YEAR_in_explicit_date224); 

            match(input, Token.DOWN, null); 
            month=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_date228); 

            match(input, Token.UP, null); 
            match(input,DAY_OF_MONTH,FOLLOW_DAY_OF_MONTH_in_explicit_date232); 

            match(input, Token.DOWN, null); 
            dom=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_date236); 

            match(input, Token.UP, null); 
            // com/hipu/date/generated/DateWalker.g:69:9: ( ^( DAY_OF_WEEK dow= INT ) )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case DAY_OF_WEEK:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:69:10: ^( DAY_OF_WEEK dow= INT )
                    {
                    match(input,DAY_OF_WEEK,FOLLOW_DAY_OF_WEEK_in_explicit_date250); 

                    match(input, Token.DOWN, null); 
                    dow=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_date254); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // com/hipu/date/generated/DateWalker.g:69:35: ( ^( YEAR_OF year= INT ) )?
            int alt9=2;
            switch ( input.LA(1) ) {
                case YEAR_OF:
                    {
                    alt9=1;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:69:36: ^( YEAR_OF year= INT )
                    {
                    match(input,YEAR_OF,FOLLOW_YEAR_OF_in_explicit_date261); 

                    match(input, Token.DOWN, null); 
                    year=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_date265); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            _walkerState.setExplicitDate((month!=null?month.getText():null), (dom!=null?dom.getText():null), (dow!=null?dow.getText():null), (year!=null?year.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "explicit_date"


    // $ANTLR start "time"
    // com/hipu/date/generated/DateWalker.g:73:1: time : ( explicit_time | relative_time );
    public final void time() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:74:3: ( explicit_time | relative_time )
            int alt10=2;
            switch ( input.LA(1) ) {
            case EXPLICIT_TIME:
                {
                alt10=1;
                }
                break;
            case RELATIVE_TIME:
                {
                alt10=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:74:5: explicit_time
                    {
                    pushFollow(FOLLOW_explicit_time_in_time290);
                    explicit_time();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // com/hipu/date/generated/DateWalker.g:75:5: relative_time
                    {
                    pushFollow(FOLLOW_relative_time_in_time296);
                    relative_time();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "time"


    // $ANTLR start "explicit_time"
    // com/hipu/date/generated/DateWalker.g:78:1: explicit_time : ^( EXPLICIT_TIME ^( HOURS_OF_DAY hours= INT ) ^( MINUTES_OF_HOUR minutes= INT ) ( ^( SECONDS_OF_MINUTE seconds= INT ) )? ( AM_PM )? (zone= ZONE | zone= ZONE_OFFSET )? ) ;
    public final void explicit_time() throws RecognitionException {
        CommonTree hours=null;
        CommonTree minutes=null;
        CommonTree seconds=null;
        CommonTree zone=null;
        CommonTree AM_PM1=null;

        try {
            // com/hipu/date/generated/DateWalker.g:79:3: ( ^( EXPLICIT_TIME ^( HOURS_OF_DAY hours= INT ) ^( MINUTES_OF_HOUR minutes= INT ) ( ^( SECONDS_OF_MINUTE seconds= INT ) )? ( AM_PM )? (zone= ZONE | zone= ZONE_OFFSET )? ) )
            // com/hipu/date/generated/DateWalker.g:79:5: ^( EXPLICIT_TIME ^( HOURS_OF_DAY hours= INT ) ^( MINUTES_OF_HOUR minutes= INT ) ( ^( SECONDS_OF_MINUTE seconds= INT ) )? ( AM_PM )? (zone= ZONE | zone= ZONE_OFFSET )? )
            {
            match(input,EXPLICIT_TIME,FOLLOW_EXPLICIT_TIME_in_explicit_time312); 

            match(input, Token.DOWN, null); 
            match(input,HOURS_OF_DAY,FOLLOW_HOURS_OF_DAY_in_explicit_time315); 

            match(input, Token.DOWN, null); 
            hours=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_time319); 

            match(input, Token.UP, null); 
            match(input,MINUTES_OF_HOUR,FOLLOW_MINUTES_OF_HOUR_in_explicit_time323); 

            match(input, Token.DOWN, null); 
            minutes=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_time327); 

            match(input, Token.UP, null); 
            // com/hipu/date/generated/DateWalker.g:80:9: ( ^( SECONDS_OF_MINUTE seconds= INT ) )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case SECONDS_OF_MINUTE:
                    {
                    alt11=1;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:80:10: ^( SECONDS_OF_MINUTE seconds= INT )
                    {
                    match(input,SECONDS_OF_MINUTE,FOLLOW_SECONDS_OF_MINUTE_in_explicit_time341); 

                    match(input, Token.DOWN, null); 
                    seconds=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_time345); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // com/hipu/date/generated/DateWalker.g:80:45: ( AM_PM )?
            int alt12=2;
            switch ( input.LA(1) ) {
                case AM_PM:
                    {
                    alt12=1;
                    }
                    break;
            }

            switch (alt12) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:80:45: AM_PM
                    {
                    AM_PM1=(CommonTree)match(input,AM_PM,FOLLOW_AM_PM_in_explicit_time350); 

                    }
                    break;

            }

            // com/hipu/date/generated/DateWalker.g:80:52: (zone= ZONE | zone= ZONE_OFFSET )?
            int alt13=3;
            switch ( input.LA(1) ) {
                case ZONE:
                    {
                    alt13=1;
                    }
                    break;
                case ZONE_OFFSET:
                    {
                    alt13=2;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:80:53: zone= ZONE
                    {
                    zone=(CommonTree)match(input,ZONE,FOLLOW_ZONE_in_explicit_time356); 

                    }
                    break;
                case 2 :
                    // com/hipu/date/generated/DateWalker.g:80:65: zone= ZONE_OFFSET
                    {
                    zone=(CommonTree)match(input,ZONE_OFFSET,FOLLOW_ZONE_OFFSET_in_explicit_time362); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            _walkerState.setExplicitTime((hours!=null?hours.getText():null), (minutes!=null?minutes.getText():null), (seconds!=null?seconds.getText():null), (AM_PM1!=null?AM_PM1.getText():null), (zone!=null?zone.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "explicit_time"


    // $ANTLR start "relative_time"
    // com/hipu/date/generated/DateWalker.g:84:1: relative_time : ^( RELATIVE_TIME seek ) ;
    public final void relative_time() throws RecognitionException {
        try {
            // com/hipu/date/generated/DateWalker.g:85:3: ( ^( RELATIVE_TIME seek ) )
            // com/hipu/date/generated/DateWalker.g:85:5: ^( RELATIVE_TIME seek )
            {
            match(input,RELATIVE_TIME,FOLLOW_RELATIVE_TIME_in_relative_time387); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_seek_in_relative_time389);
            seek();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "relative_time"


    // $ANTLR start "seek"
    // com/hipu/date/generated/DateWalker.g:88:1: seek : ( ^( SEEK DIRECTION by= SEEK_BY amount= INT ^( DAY_OF_WEEK day= INT ) ( date )? ) | ^( SEEK DIRECTION SEEK_BY amount= INT ^( MONTH_OF_YEAR month= INT ) ) | ^( SEEK DIRECTION SEEK_BY ( explicit_seek | relative_date )? INT SPAN ) | ^( SEEK DIRECTION SEEK_BY INT date ) | ^( SEEK DIRECTION SEEK_BY INT HOLIDAY ) | ^( SEEK DIRECTION SEEK_BY INT SEASON ) );
    public final void seek() throws RecognitionException {
        CommonTree by=null;
        CommonTree amount=null;
        CommonTree day=null;
        CommonTree month=null;
        CommonTree DIRECTION2=null;
        CommonTree DIRECTION3=null;
        CommonTree DIRECTION4=null;
        CommonTree INT5=null;
        CommonTree SPAN6=null;
        CommonTree DIRECTION7=null;
        CommonTree INT8=null;
        CommonTree SEEK_BY9=null;
        CommonTree HOLIDAY10=null;
        CommonTree DIRECTION11=null;
        CommonTree INT12=null;
        CommonTree SEASON13=null;
        CommonTree DIRECTION14=null;
        CommonTree INT15=null;

        try {
            // com/hipu/date/generated/DateWalker.g:89:3: ( ^( SEEK DIRECTION by= SEEK_BY amount= INT ^( DAY_OF_WEEK day= INT ) ( date )? ) | ^( SEEK DIRECTION SEEK_BY amount= INT ^( MONTH_OF_YEAR month= INT ) ) | ^( SEEK DIRECTION SEEK_BY ( explicit_seek | relative_date )? INT SPAN ) | ^( SEEK DIRECTION SEEK_BY INT date ) | ^( SEEK DIRECTION SEEK_BY INT HOLIDAY ) | ^( SEEK DIRECTION SEEK_BY INT SEASON ) )
            int alt16=6;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:89:5: ^( SEEK DIRECTION by= SEEK_BY amount= INT ^( DAY_OF_WEEK day= INT ) ( date )? )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek406); 

                    match(input, Token.DOWN, null); 
                    DIRECTION2=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek408); 
                    by=(CommonTree)match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek412); 
                    amount=(CommonTree)match(input,INT,FOLLOW_INT_in_seek416); 
                    match(input,DAY_OF_WEEK,FOLLOW_DAY_OF_WEEK_in_seek419); 

                    match(input, Token.DOWN, null); 
                    day=(CommonTree)match(input,INT,FOLLOW_INT_in_seek423); 

                    match(input, Token.UP, null); 
                    // com/hipu/date/generated/DateWalker.g:89:68: ( date )?
                    int alt14=2;
                    switch ( input.LA(1) ) {
                        case EXPLICIT_DATE:
                        case RELATIVE_DATE:
                            {
                            alt14=1;
                            }
                            break;
                    }

                    switch (alt14) {
                        case 1 :
                            // com/hipu/date/generated/DateWalker.g:89:68: date
                            {
                            pushFollow(FOLLOW_date_in_seek427);
                            date();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    _walkerState.seekToDayOfWeek((DIRECTION2!=null?DIRECTION2.getText():null), (by!=null?by.getText():null), (amount!=null?amount.getText():null), (day!=null?day.getText():null));

                    }
                    break;
                case 2 :
                    // com/hipu/date/generated/DateWalker.g:92:5: ^( SEEK DIRECTION SEEK_BY amount= INT ^( MONTH_OF_YEAR month= INT ) )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek447); 

                    match(input, Token.DOWN, null); 
                    DIRECTION3=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek449); 
                    match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek451); 
                    amount=(CommonTree)match(input,INT,FOLLOW_INT_in_seek455); 
                    match(input,MONTH_OF_YEAR,FOLLOW_MONTH_OF_YEAR_in_seek458); 

                    match(input, Token.DOWN, null); 
                    month=(CommonTree)match(input,INT,FOLLOW_INT_in_seek462); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToMonth((DIRECTION3!=null?DIRECTION3.getText():null), (amount!=null?amount.getText():null), (month!=null?month.getText():null));

                    }
                    break;
                case 3 :
                    // com/hipu/date/generated/DateWalker.g:95:5: ^( SEEK DIRECTION SEEK_BY ( explicit_seek | relative_date )? INT SPAN )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek480); 

                    match(input, Token.DOWN, null); 
                    DIRECTION4=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek482); 
                    match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek484); 
                    // com/hipu/date/generated/DateWalker.g:95:30: ( explicit_seek | relative_date )?
                    int alt15=3;
                    switch ( input.LA(1) ) {
                        case EXPLICIT_SEEK:
                            {
                            alt15=1;
                            }
                            break;
                        case RELATIVE_DATE:
                            {
                            alt15=2;
                            }
                            break;
                    }

                    switch (alt15) {
                        case 1 :
                            // com/hipu/date/generated/DateWalker.g:95:31: explicit_seek
                            {
                            pushFollow(FOLLOW_explicit_seek_in_seek487);
                            explicit_seek();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // com/hipu/date/generated/DateWalker.g:95:47: relative_date
                            {
                            pushFollow(FOLLOW_relative_date_in_seek491);
                            relative_date();

                            state._fsp--;


                            }
                            break;

                    }

                    INT5=(CommonTree)match(input,INT,FOLLOW_INT_in_seek495); 
                    SPAN6=(CommonTree)match(input,SPAN,FOLLOW_SPAN_in_seek497); 

                    match(input, Token.UP, null); 
                    _walkerState.seekBySpan((DIRECTION4!=null?DIRECTION4.getText():null), (INT5!=null?INT5.getText():null), (SPAN6!=null?SPAN6.getText():null));

                    }
                    break;
                case 4 :
                    // com/hipu/date/generated/DateWalker.g:98:5: ^( SEEK DIRECTION SEEK_BY INT date )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek514); 

                    match(input, Token.DOWN, null); 
                    DIRECTION7=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek516); 
                    SEEK_BY9=(CommonTree)match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek518); 
                    INT8=(CommonTree)match(input,INT,FOLLOW_INT_in_seek520); 
                    pushFollow(FOLLOW_date_in_seek522);
                    date();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    _walkerState.seekBySpan((DIRECTION7!=null?DIRECTION7.getText():null), (INT8!=null?INT8.getText():null), (SEEK_BY9!=null?SEEK_BY9.getText():null));

                    }
                    break;
                case 5 :
                    // com/hipu/date/generated/DateWalker.g:101:5: ^( SEEK DIRECTION SEEK_BY INT HOLIDAY )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek541); 

                    match(input, Token.DOWN, null); 
                    DIRECTION11=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek543); 
                    match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek545); 
                    INT12=(CommonTree)match(input,INT,FOLLOW_INT_in_seek547); 
                    HOLIDAY10=(CommonTree)match(input,HOLIDAY,FOLLOW_HOLIDAY_in_seek549); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToHoliday((HOLIDAY10!=null?HOLIDAY10.getText():null), (DIRECTION11!=null?DIRECTION11.getText():null), (INT12!=null?INT12.getText():null));

                    }
                    break;
                case 6 :
                    // com/hipu/date/generated/DateWalker.g:104:5: ^( SEEK DIRECTION SEEK_BY INT SEASON )
                    {
                    match(input,SEEK,FOLLOW_SEEK_in_seek568); 

                    match(input, Token.DOWN, null); 
                    DIRECTION14=(CommonTree)match(input,DIRECTION,FOLLOW_DIRECTION_in_seek570); 
                    match(input,SEEK_BY,FOLLOW_SEEK_BY_in_seek572); 
                    INT15=(CommonTree)match(input,INT,FOLLOW_INT_in_seek574); 
                    SEASON13=(CommonTree)match(input,SEASON,FOLLOW_SEASON_in_seek576); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToSeason((SEASON13!=null?SEASON13.getText():null), (DIRECTION14!=null?DIRECTION14.getText():null), (INT15!=null?INT15.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "seek"


    // $ANTLR start "explicit_seek"
    // com/hipu/date/generated/DateWalker.g:108:1: explicit_seek : ( ^( EXPLICIT_SEEK ^( MONTH_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_MONTH month= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK HOLIDAY ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK SEASON ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK index= INT ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK explicit_time ) );
    public final void explicit_seek() throws RecognitionException {
        CommonTree day=null;
        CommonTree month=null;
        CommonTree year=null;
        CommonTree index=null;
        CommonTree HOLIDAY16=null;
        CommonTree SEASON17=null;

        try {
            // com/hipu/date/generated/DateWalker.g:109:3: ( ^( EXPLICIT_SEEK ^( MONTH_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_MONTH month= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK HOLIDAY ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK SEASON ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK index= INT ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK explicit_time ) )
            int alt17=9;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // com/hipu/date/generated/DateWalker.g:109:5: ^( EXPLICIT_SEEK ^( MONTH_OF_YEAR day= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek599); 

                    match(input, Token.DOWN, null); 
                    match(input,MONTH_OF_YEAR,FOLLOW_MONTH_OF_YEAR_in_explicit_seek602); 

                    match(input, Token.DOWN, null); 
                    day=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek606); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToMonth(">", "0", (day!=null?day.getText():null));

                    }
                    break;
                case 2 :
                    // com/hipu/date/generated/DateWalker.g:112:5: ^( EXPLICIT_SEEK ^( DAY_OF_MONTH month= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek626); 

                    match(input, Token.DOWN, null); 
                    match(input,DAY_OF_MONTH,FOLLOW_DAY_OF_MONTH_in_explicit_seek629); 

                    match(input, Token.DOWN, null); 
                    month=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek633); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToDayOfMonth((month!=null?month.getText():null));

                    }
                    break;
                case 3 :
                    // com/hipu/date/generated/DateWalker.g:115:5: ^( EXPLICIT_SEEK ^( DAY_OF_WEEK day= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek653); 

                    match(input, Token.DOWN, null); 
                    match(input,DAY_OF_WEEK,FOLLOW_DAY_OF_WEEK_in_explicit_seek656); 

                    match(input, Token.DOWN, null); 
                    day=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek660); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToDayOfWeek(">", "by_week", "0", (day!=null?day.getText():null));

                    }
                    break;
                case 4 :
                    // com/hipu/date/generated/DateWalker.g:118:5: ^( EXPLICIT_SEEK ^( DAY_OF_YEAR day= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek680); 

                    match(input, Token.DOWN, null); 
                    match(input,DAY_OF_YEAR,FOLLOW_DAY_OF_YEAR_in_explicit_seek683); 

                    match(input, Token.DOWN, null); 
                    day=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek687); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToDayOfYear((day!=null?day.getText():null));

                    }
                    break;
                case 5 :
                    // com/hipu/date/generated/DateWalker.g:121:5: ^( EXPLICIT_SEEK ^( YEAR_OF year= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek707); 

                    match(input, Token.DOWN, null); 
                    match(input,YEAR_OF,FOLLOW_YEAR_OF_in_explicit_seek710); 

                    match(input, Token.DOWN, null); 
                    year=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek714); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToYear((year!=null?year.getText():null));

                    }
                    break;
                case 6 :
                    // com/hipu/date/generated/DateWalker.g:124:5: ^( EXPLICIT_SEEK HOLIDAY ^( YEAR_OF year= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek734); 

                    match(input, Token.DOWN, null); 
                    HOLIDAY16=(CommonTree)match(input,HOLIDAY,FOLLOW_HOLIDAY_in_explicit_seek736); 
                    match(input,YEAR_OF,FOLLOW_YEAR_OF_in_explicit_seek739); 

                    match(input, Token.DOWN, null); 
                    year=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek743); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToHolidayYear((HOLIDAY16!=null?HOLIDAY16.getText():null), (year!=null?year.getText():null));

                    }
                    break;
                case 7 :
                    // com/hipu/date/generated/DateWalker.g:127:5: ^( EXPLICIT_SEEK SEASON ^( YEAR_OF year= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek763); 

                    match(input, Token.DOWN, null); 
                    SEASON17=(CommonTree)match(input,SEASON,FOLLOW_SEASON_in_explicit_seek765); 
                    match(input,YEAR_OF,FOLLOW_YEAR_OF_in_explicit_seek768); 

                    match(input, Token.DOWN, null); 
                    year=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek772); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.seekToSeasonYear((SEASON17!=null?SEASON17.getText():null), (year!=null?year.getText():null));

                    }
                    break;
                case 8 :
                    // com/hipu/date/generated/DateWalker.g:130:5: ^( EXPLICIT_SEEK index= INT ^( DAY_OF_WEEK day= INT ) )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek792); 

                    match(input, Token.DOWN, null); 
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek796); 
                    match(input,DAY_OF_WEEK,FOLLOW_DAY_OF_WEEK_in_explicit_seek799); 

                    match(input, Token.DOWN, null); 
                    day=(CommonTree)match(input,INT,FOLLOW_INT_in_explicit_seek803); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                    _walkerState.setDayOfWeekIndex((index!=null?index.getText():null), (day!=null?day.getText():null));

                    }
                    break;
                case 9 :
                    // com/hipu/date/generated/DateWalker.g:133:5: ^( EXPLICIT_SEEK explicit_time )
                    {
                    match(input,EXPLICIT_SEEK,FOLLOW_EXPLICIT_SEEK_in_explicit_seek823); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_explicit_time_in_explicit_seek825);
                    explicit_time();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "explicit_seek"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA16_eotS =
        "\14\uffff";
    static final String DFA16_eofS =
        "\14\uffff";
    static final String DFA16_minS =
        "\1\u01b4\1\2\1\u01b5\1\u01b6\1\u0102\1\u01ab\6\uffff";
    static final String DFA16_maxS =
        "\1\u01b4\1\2\1\u01b5\1\u01b6\1\u01b7\1\u01c3\6\uffff";
    static final String DFA16_acceptS =
        "\6\uffff\1\3\1\1\1\2\1\5\1\6\1\4";
    static final String DFA16_specialS =
        "\14\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\5\u00b0\uffff\1\6\3\uffff\1\6",
            "\1\10\1\uffff\1\7\4\uffff\2\13\4\uffff\1\6\11\uffff\1\11\1"+
            "\12",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "88:1: seek : ( ^( SEEK DIRECTION by= SEEK_BY amount= INT ^( DAY_OF_WEEK day= INT ) ( date )? ) | ^( SEEK DIRECTION SEEK_BY amount= INT ^( MONTH_OF_YEAR month= INT ) ) | ^( SEEK DIRECTION SEEK_BY ( explicit_seek | relative_date )? INT SPAN ) | ^( SEEK DIRECTION SEEK_BY INT date ) | ^( SEEK DIRECTION SEEK_BY INT HOLIDAY ) | ^( SEEK DIRECTION SEEK_BY INT SEASON ) );";
        }
    }
    static final String DFA17_eotS =
        "\14\uffff";
    static final String DFA17_eofS =
        "\14\uffff";
    static final String DFA17_minS =
        "\1\u01b7\1\2\1\u0102\11\uffff";
    static final String DFA17_maxS =
        "\1\u01b7\1\2\1\u01c3\11\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA17_specialS =
        "\14\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1",
            "\1\2",
            "\1\12\u00a8\uffff\1\3\1\4\1\5\1\6\1\7\11\uffff\1\13\10\uffff"+
            "\1\10\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "108:1: explicit_seek : ( ^( EXPLICIT_SEEK ^( MONTH_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_MONTH month= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK ^( DAY_OF_YEAR day= INT ) ) | ^( EXPLICIT_SEEK ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK HOLIDAY ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK SEASON ^( YEAR_OF year= INT ) ) | ^( EXPLICIT_SEEK index= INT ^( DAY_OF_WEEK day= INT ) ) | ^( EXPLICIT_SEEK explicit_time ) );";
        }
    }
 

    public static final BitSet FOLLOW_date_time_alternative_in_parse45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_recurrence_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECURRENCE_in_recurrence71 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_date_time_in_recurrence73 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DATE_TIME_ALTERNATIVE_in_date_time_alternative92 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_date_time_in_date_time_alternative94 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DATE_TIME_in_date_time116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_date_in_date_time118 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_time_in_date_time121 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_relative_date_in_date140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_date_in_date147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RELATIVE_DATE_in_relative_date163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_seek_in_relative_date165 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_explicit_seek_in_relative_date168 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_WEEK_INDEX_in_week_index186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_week_index190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_DAY_OF_WEEK_in_week_index193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_week_index197 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_DATE_in_explicit_date221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MONTH_OF_YEAR_in_explicit_date224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_date228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DAY_OF_MONTH_in_explicit_date232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_date236 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DAY_OF_WEEK_in_explicit_date250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_date254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_YEAR_OF_in_explicit_date261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_date265 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_explicit_time_in_time290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relative_time_in_time296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPLICIT_TIME_in_explicit_time312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HOURS_OF_DAY_in_explicit_time315 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_time319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUTES_OF_HOUR_in_explicit_time323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_time327 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SECONDS_OF_MINUTE_in_explicit_time341 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_time345 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AM_PM_in_explicit_time350 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ZONE_in_explicit_time356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ZONE_OFFSET_in_explicit_time362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RELATIVE_TIME_in_relative_time387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_seek_in_relative_time389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_DAY_OF_WEEK_in_seek419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek423 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_date_in_seek427 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_MONTH_OF_YEAR_in_seek458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek462 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L,0x0000000000000000L,0x0088000000000000L});
    public static final BitSet FOLLOW_explicit_seek_in_seek487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_relative_date_in_seek491 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek495 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_SPAN_in_seek497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000C000000000000L});
    public static final BitSet FOLLOW_date_in_seek522 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek543 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_HOLIDAY_in_seek549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEEK_in_seek568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DIRECTION_in_seek570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_SEEK_BY_in_seek572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_seek574 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEASON_in_seek576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MONTH_OF_YEAR_in_explicit_seek602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DAY_OF_MONTH_in_explicit_seek629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DAY_OF_WEEK_in_explicit_seek656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DAY_OF_YEAR_in_explicit_seek683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek687 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_YEAR_OF_in_explicit_seek710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek714 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HOLIDAY_in_explicit_seek736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_YEAR_OF_in_explicit_seek739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEASON_in_explicit_seek765 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_YEAR_OF_in_explicit_seek768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek792 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_DAY_OF_WEEK_in_explicit_seek799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_explicit_seek803 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPLICIT_SEEK_in_explicit_seek823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_explicit_time_in_explicit_seek825 = new BitSet(new long[]{0x0000000000000008L});

}