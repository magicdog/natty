package com.hipu.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 * @author Joe Stelmach
 */
public class JodaWalkerState {

	private static final int TWO_DIGIT_YEAR_CENTURY_THRESHOLD = 20;
	private static final String MONTH = "month";
	private static final String DAY = "day";
	private static final String NAMED_DAY = "named_day";
	private static final String YEAR = "year";
	private static final String WEEK = "week";
	private static final String HOUR = "hour";
	private static final String MINUTE = "minute";
	private static final String SECOND = "second";
	private static final String AM = "am";
	private static final String PM = "pm";
	private static final String DIR_LEFT = "<";
	private static final String DIR_RIGHT = ">";
	private static final String SEEK_PREFIX = "by_";
	private static final String SEEK_BY_DAY = "by_day";
	private static final String SEEK_BY_WEEK = "by_week";
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String GMT = "GMT";
	private static final String VEVENT = "VEVENT";
	private static final String SUMMARY = "SUMMARY";
	private static final String HOLIDAY_ICS_FILE = "/holidays.ics";
	private static final String SEASON_ICS_FILE = "/seasons.ics";
	private static final Logger _logger = Logger
			.getLogger("com.hipu.date");

	private DateTime _dateTime;
	private int _currentYear;
	private boolean _firstDateInvocationInGroup = true;
	private boolean _timeGivenInGroup = false;
	private DateGroup _dateGroup;
	// shelton
	private boolean _dateGivenGroup = false;
	private String span = "";
	private DateTime _dafaultDate = null;
	private DateTime _initialDate = null;

	/**
	 * Creates a new WalkerState representing the start of the next hour from
	 * the current time
	 */
	public JodaWalkerState() {
		resetCalendar();
		_dateGroup = new DateGroup();
	}

//	public void setDefaultTimeZone(final TimeZone zone) {
//		if (zone != null) {
//			_defaultTimeZone = DateTimeZone.forTimeZone(zone);
//			_dafaultDate = _dafaultDate.withZone(_defaultTimeZone);
//		}
//		resetCalendar();
//	}

	// shelton : add base date
	public void setDefaultDate(DateTime date) {
		_dafaultDate = date;
		resetCalendar();
	}

/**
   * seeks to a specified day of the week in the past or future.
   * 
   * @param direction the direction to seek: two possibilities 
   *    '<' go backward 
   *    '>' go forward
   *    
   * @param seekType the type of seek to perform (by_day or by_week)
   *     by_day means we seek to the very next occurrence of the given day
   *     by_week means we seek to the first occurrence of the given day week in the
   *     next (or previous,) week (or multiple of next or previous week depending
   *     on the seek amount.)
   *     
   * @param seekAmount the amount to seek.  Must be guaranteed to parse as an integer
   *     
   * @param dayOfWeek the day of the week to seek to, represented as an integer from 
   *     1 to 7 (1 being Sunday, 7 being Saturday.) Must be guaranteed to parse as an Integer
   */
	public void seekToDayOfWeek(String direction, String seekType,
			String seekAmount, String dayOfWeek) {
		int dayOfWeekInt = Integer.parseInt(dayOfWeek);
		int seekAmountInt = Integer.parseInt(seekAmount);
		assert (direction.equals(DIR_LEFT) || direction.equals(DIR_RIGHT));
		assert (seekType.equals(SEEK_BY_DAY) || seekType.equals(SEEK_BY_WEEK));
		if (dayOfWeekInt < 1 || dayOfWeekInt > 7)
			return;

		markDateInvocation();

		int sign = direction.equals(DIR_RIGHT) ? 1 : -1;
		if (seekType.equals(SEEK_BY_WEEK)) {
			// set our calendar to this weeks requested day of the week,
			// then add or subtract the week(s)
			_dateTime = _dateTime.withDayOfWeek(dayOfWeekInt);
			_dateTime = _dateTime.plusDays(seekAmountInt * 7 * sign);
		}

		else if (seekType.equals(SEEK_BY_DAY)) {
			// find the closest day
			do {
				_dateTime = _dateTime.plusDays(sign);
			} while (_dateTime.getDayOfWeek() != dayOfWeekInt);

			// now add/subtract any additional days
			if (seekAmountInt > 0) {
				_dateTime = _dateTime.plusWeeks((seekAmountInt - 1) * sign);
			}
		}
//		System.out.println("seekToDayOfWeek"+ _dateTime.toDate());
	}

	/**
	 * Seeks to the given day within the current month
	 * 
	 * @param dayOfMonth
	 *            the day of the month to seek to, represented as an integer
	 *            from 1 to 31. Must be guaranteed to parse as an Integer. If
	 *            this day is beyond the last day of the current month, the
	 *            actual last day of the month will be used.
	 */
	public void seekToDayOfMonth(String dayOfMonth) {
		int dayOfMonthInt = Integer.parseInt(dayOfMonth);
		if (dayOfMonthInt < 1 || dayOfMonthInt > 31)
			return;

		markDateInvocation();

		dayOfMonthInt = Math.min(dayOfMonthInt, _dateTime.dayOfMonth()
                .getMaximumValue());
		_dateTime = _dateTime.withDayOfMonth(dayOfMonthInt);
//		System.out.println("seekToDayOfMonth"+ _dateTime.toDate());

	}

	/**
	 * Seeks to the given day within the current year
	 * 
	 * @param dayOfYear
	 *            the day of the year to seek to, represented as an integer from
	 *            1 to 366. Must be guaranteed to parse as an Integer. If this
	 *            day is beyond the last day of the current year, the actual
	 *            last day of the year will be used.
	 */
	public void seekToDayOfYear(String dayOfYear) {
		int dayOfYearInt = Integer.parseInt(dayOfYear);
		if (dayOfYearInt < 1 || dayOfYearInt > 366)
			return;

		markDateInvocation();

		dayOfYearInt = Math.min(dayOfYearInt, _dateTime.dayOfYear()
                .getMaximumValue());
		_dateTime = _dateTime.withDayOfYear(dayOfYearInt);
//		System.out.println("seekToDayOfYear"+ _dateTime.toDate());
	}

	/**
	 * 
	 * @param year
	 */
	public void seekToYear(String year) {
		int yearInt = Integer.parseInt(year);
		if (yearInt <= 0 || yearInt > 9999)
			return;

		markDateInvocation();

		_dateTime = _dateTime.withYear(getFullYear(yearInt));
//		System.out.println("seekToYear"+ _dateTime.toDate());
	}

/**
   * seeks to a particular month
   * 
   * @param direction the direction to seek: two possibilities 
   *    '<' go backward 
   *    '>' go forward
   *    
   * @param seekAmount the amount to seek.  Must be guaranteed to parse as an integer
   *     
   * @param month the month to seek to.  Must be guaranteed to parse as an integer
   *     between 1 and 12 
   */
	public void seekToMonth(String direction, String seekAmount, String month) {

		int seekAmountInt = Integer.parseInt(seekAmount);
		int monthInt = Integer.parseInt(month);
		assert (direction.equals(DIR_LEFT) || direction.equals(DIR_RIGHT));
		if (monthInt < 1 || monthInt > 12)
			return;

		markDateInvocation();

		// set the day to the first of month. This step is necessary because if
		// we seek to the
		// current day of a month whose number of days is less than the current
		// day, we will
		// pushed into the next month.
		_dateTime = _dateTime.withDayOfMonth(1);

		// seek to the appropriate year
		if (seekAmountInt > 0) {
			int currentMonth = _dateTime.getMonthOfYear();
			int sign = direction.equals(DIR_RIGHT) ? 1 : -1;
			int numYearsToShift = seekAmountInt
					+ (currentMonth <= monthInt ? sign > 0 ? -1 : 0
							: sign > 0 ? 0 : -1);

			_dateTime = _dateTime.plusYears(numYearsToShift * sign);
		}

		// now set the month
		_dateTime = _dateTime.withMonthOfYear(monthInt);
//		System.out.println("seekToMonth"+_dateTime.toDate());

	}

/**
   * seeks by a span of time (weeks, months, etc)
   * 
   * @param direction the direction to seek: two possibilities 
   *    '<' go backward 
   *    '>' go forward
   *    
   * @param seekAmount the amount to seek.  Must be guaranteed to parse as an integer
   *     
   * @param span
   * 
   * updated by shelton
   * span == 'named_day' means today,yesterday,tomorrow and now, 
   */
	public void seekBySpan(String direction, String seekAmount, String span) {
		if (span.startsWith(SEEK_PREFIX))
			span = span.substring(3);
		int seekAmountInt = Integer.parseInt(seekAmount);
		assert (direction.equals(DIR_LEFT) || direction.equals(DIR_RIGHT));
		assert (span.equals(DAY) || span.equals(WEEK) || span.equals(MONTH)
				|| span.equals(YEAR) || span.equals(HOUR)
				|| span.equals(MINUTE) || span.equals(SECOND) || span
					.equals(NAMED_DAY));

		boolean isDateSeek = span.equals(DAY) || span.equals(WEEK)
				|| span.equals(MONTH) || span.equals(YEAR)
				|| span.equals(NAMED_DAY);
		if (isDateSeek)
			markDateInvocation();
		else
			markTimeInvocation();
		this._dateGivenGroup = true;
		if (span.equals(NAMED_DAY))
			this.span = NAMED_DAY;

		int sign = direction.equals(DIR_RIGHT) ? 1 : -1;
		
		if (span.equals(DAY) || span.equals(NAMED_DAY)) {
			_dateTime = _dateTime.plusDays(seekAmountInt * sign);
		} else if (span.equals(WEEK)) {
			_dateTime = _dateTime.plusWeeks(seekAmountInt * sign);
		} else if (span.equals(MONTH)) {
			_dateTime = _dateTime.plusMonths(seekAmountInt * sign);
		} else if (span.equals(YEAR)) {
			_dateTime = _dateTime.plusYears(seekAmountInt * sign);
		} else if (span.equals(HOUR)) {
			_dateTime = _dateTime.plusHours(seekAmountInt * sign);
		} else if (span.equals(MINUTE)) {
			_dateTime = _dateTime.plusMinutes(seekAmountInt * sign);
		} else if (span.equals(SECOND)) {
			_dateTime = _dateTime.plusSeconds(seekAmountInt * sign);
		} 
//		System.out.println("seekBySpan"+ _dateTime.toDate());
	}

	/**
	 * 
	 * @param index
	 * @param dayOfWeek
	 */
	public void setDayOfWeekIndex(String index, String dayOfWeek) {
		int indexInt = Integer.parseInt(index);
		if  ( !(indexInt > 0 && indexInt < 6) )
			return;

		int dayOfWeekInt = Integer.parseInt(dayOfWeek);
		if ( !(dayOfWeekInt >= 1 && dayOfWeekInt <= 7) )
			return;

		markDateInvocation();

		// seek to the first day of the current month
		_dateTime = _dateTime.withDayOfMonth(1);

		// if we already passed the day we're looking for, we add a week
		if (_dateTime.getDayOfWeek() > dayOfWeekInt) {
			_dateTime = _dateTime.plusWeeks(1);
		}

		// now move to the requested day within the week
		_dateTime = _dateTime.withDayOfWeek(dayOfWeekInt);
		int currentMonth = _dateTime.getMonthOfYear();

		// add weeks for our requested index
		_dateTime = _dateTime.plusWeeks(indexInt-1);

		// if we bled into the next month, push back a week
		if (currentMonth != _dateTime.getMonthOfYear()) {
			_dateTime = _dateTime.plusWeeks(-1);
		}
//		System.out.println("setDayOfWeekIndex"+_dateTime.toDate());
	}

	/**
		 * 
		 * @param month
		 *            the month to set. Must be guaranteed to parse as an integer
		 *            between 1 and 12
		 * 
		 * @param dayOfMonth
		 *            the day of month to set. Must be guaranteed to parse as an
		 *            integer between 1 and 31
		 * 
		 * @param dayOfWeek
		 *            the day of the week. This is optional and will only be used
		 *            when no year is given. If the current year's month and day
		 *            does not fall on the given day of week, we walk backwards in 1
		 *            year iterations until we find the first such date. If given,
		 *            must be guaranteed to parse as an integer between 1 and 7.
		 * 
		 * @param year
		 *            the year to set (optional). If present, must be guaranteed to
		 *            parse as an integer between 0 and 9999
		 */
	public void setExplicitDate(String month, String dayOfMonth,
			String dayOfWeek, String year) {
		boolean hasDate = false;
		int monthInt = Integer.parseInt(month);
		int dayOfMonthInt = Integer.parseInt(dayOfMonth);
		int yearInt = (year == null)? DateTime.now().getYear() : Integer.parseInt(year);
		if (!(monthInt > 0 && monthInt <= 31) || !(dayOfMonthInt > 0 && dayOfMonthInt <= 31) 
				|| !(yearInt > 0 && yearInt < 9999))
			return;
		
		//ignore 2-3-4
		if (monthInt<10 && dayOfMonthInt<10 && yearInt<10)
			return;
		
		if (monthInt <= 12 && dayOfMonthInt <= new DateTime(yearInt, monthInt, 1, 0, 0).dayOfMonth().getMaximumValue()) {
			markDateInvocation();
			// normal date 1988-1-6 or 88-1-6 or 1-6-1988
//			_dateTime = _dateTime.withDayOfMonth(dayOfMonthInt).withMonthOfYear(monthInt).withYear(getFullYear(yearInt));
			_dateTime = _dateTime.withDate(getFullYear(yearInt), monthInt, dayOfMonthInt);
			hasDate = true;
		}
		if (dayOfWeek != null) {
			//if dayOfWeek==8, means year first mode(1988-1-6 or 88-1-6), if the year only has two numbers,
			//we should continue to judge.
			//for example: 04-1-12, we will compare 04 year 1 month 12 day and 12 year 04 month 1 day. 
			if (dayOfWeek.equals("8")) {
				int newMonth = yearInt;
				int newYear = getFullYear(dayOfMonthInt);
				if (newMonth <= 12 && monthInt <= new DateTime(newYear, newMonth, 1, 0, 0, 0).dayOfMonth().getMaximumValue()) {
					markDateInvocation();
                    DateTime newDateTime = _dateTime.withDate(newYear, newMonth, monthInt);
					if (!hasDate) {
//						_dateTime = _dateTime.withDayOfMonth(monthInt).withMonthOfYear(newMonth).withYear(newYear);
						_dateTime = newDateTime;
					} else {
                        long millis = newDateTime.getMillis();
                        long nowMillis = System.currentTimeMillis();
                        if (Math.abs(nowMillis - millis)
                                < Math.abs(nowMillis - _dateTime.getMillis()))
                            _dateTime = newDateTime;
                    }
				}
			} else if (dayOfWeek.equals("9")) {
				//if dayOfWeek==9, means year last mode(1-6-1988), in this mode, we should continue to judge.
				//for example: 1-6-1988, we will compare 1988 year 1 month 6 day and 1988 year 6 month 1 day. 
				int newMonth = dayOfMonthInt;
				int newDay = monthInt;
				if (newMonth <= 12 && monthInt <= new DateTime(yearInt, newMonth, 1, 0, 0, 0).dayOfMonth().getMaximumValue()) {
					markDateInvocation();
                    if (!hasDate) {
//						_dateTime = _dateTime.withDayOfMonth(newDay).withMonthOfYear(newMonth).withYear(getFullYear(yearInt));
                        _dateTime =  _dateTime.withDate(getFullYear(yearInt), newMonth, newDay);
					} else {
                        DateTime newDateTime = _dateTime.withDayOfMonth(newDay).withMonthOfYear(newMonth);
                        long millis = newDateTime.getMillis();
                        long nowMillis = System.currentTimeMillis();
                        if (Math.abs(nowMillis - millis)
                                < Math.abs(nowMillis - _dateTime.getMillis()))
                            _dateTime = newDateTime;
                    }
				}
			}
		}
		}

	/**
	 * Sets the the time of day
	 * 
	 * @param hours
	 *            the hours to set. Must be guaranteed to parse as an integer
	 *            between 0 and 23
	 * 
	 * @param minutes
	 *            the minutes to set. Must be guaranteed to parse as an integer
	 *            between 0 and 59
	 * 
	 * @param seconds
	 *            the optional seconds to set. Must be guaranteed to parse as an
	 *            integer between 0 and 59
	 * 
	 * @param amPm
	 *            the meridian indicator to use. Must be either 'am' or 'pm'
	 * 
	 * @param zoneString
	 *            the time zone to use in one of two formats: - zoneinfo format
	 *            (America/New_York, America/Los_Angeles, etc) - GMT offset
	 *            (+05:00, -0500, +5, etc)
	 */
	public void setExplicitTime(String hours, String minutes, String seconds,
			String amPm, String zoneString) {
		int hoursInt = Integer.parseInt(hours);
		int minutesInt = Integer.parseInt(minutes);
		if ( !(amPm == null || amPm.equals(AM) || amPm.equals(PM)) )
			return;
		if (hoursInt < 0 || hoursInt > 23)
			return;
		if (minutesInt < 0 || minutesInt >= 60)
			return;

		markTimeInvocation();

		// reset milliseconds to 0
		_dateTime = _dateTime.withMillisOfSecond(0);

		
		_dateTime = _dateTime.withHourOfDay(hoursInt);

		// hours greater than 12 are in 24-hour time
		if (hoursInt <= 12) {
			int amPmInt = amPm == null ? (hoursInt >= 12 ? 1 : 0) : amPm
					.equals(PM) ? 1 : 0;
			_dateTime = _dateTime.withField(DateTimeFieldType.halfdayOfDay(),
					amPmInt);

			// calendar is whacky at 12 o'clock (must use 0)
			if (hoursInt == 12)
				hoursInt = 0;
			_dateTime = _dateTime.withField(DateTimeFieldType.hourOfHalfday(), hoursInt);
			
		}

		if (seconds != null) {
			int secondsInt = Integer.parseInt(seconds);
			if (secondsInt >= 0 && secondsInt < 60)
				_dateTime = _dateTime.withSecondOfMinute(secondsInt);
		} else {
			_dateTime = _dateTime.withSecondOfMinute(0);
		}
//		System.out.println(_dateTime);
		_dateTime = _dateTime.withMinuteOfHour(minutesInt);

		// if no explicit zone is given, we use our own
		TimeZone zone = null;
		if (zoneString != null) {
			if (zoneString.startsWith(PLUS) || zoneString.startsWith(MINUS)) {
				zoneString = GMT + zoneString;
			}
			zone = TimeZone.getTimeZone(zoneString);
			
		}
		_dateTime = _dateTime.withZoneRetainFields(zone != null ? DateTimeZone
				.forTimeZone(zone) : (_dafaultDate == null ? null
				: _dafaultDate.getZone()));
	}

	/**
	 * Seeks forward or backwards to a particular holiday based on the current
	 * date
	 * 
	 * @param holidayString
	 *            The holiday to seek to
	 * @param direction
	 *            The direction to seek
	 * @param seekAmount
	 *            The number of years to seek
	 */
	public void seekToHoliday(String holidayString, String direction,
			String seekAmount) {
//		Holiday holiday = Holiday.valueOf(holidayString);
//		assert (holiday != null);
//
//		seekToIcsEvent(HOLIDAY_ICS_FILE, holiday.getSummary(), direction,
//				seekAmount);
	}

	/**
	 * Seeks to the given holiday within the given year
	 * 
	 * @param holidayString
	 * @param yearString
	 */
	public void seekToHolidayYear(String holidayString, String yearString) {
//		Holiday holiday = Holiday.valueOf(holidayString);
//		assert (holiday != null);
//
//		seekToIcsEventYear(HOLIDAY_ICS_FILE, yearString, holiday.getSummary());
	}

	/**
	 * Seeks forward or backwards to a particular season based on the current
	 * date
	 * 
	 * @param seasonString
	 *            The season to seek to
	 * @param direction
	 *            The direction to seek
	 * @param seekAmount
	 *            The number of years to seek
	 */
	public void seekToSeason(String seasonString, String direction,
			String seekAmount) {
//		Season season = Season.valueOf(seasonString);
//		assert (season != null);
//
//		seekToIcsEvent(SEASON_ICS_FILE, season.getSummary(), direction,
//				seekAmount);
	}

	/**
	 * Seeks to the given season within the given year
	 * 
	 * @param seasonString
	 * @param yearString
	 */
	public void seekToSeasonYear(String seasonString, String yearString) {
//		Season season = Season.valueOf(seasonString);
//		assert (season != null);
//
//		seekToIcsEventYear(SEASON_ICS_FILE, yearString, season.getSummary());
	}

	/**
   * 
   */
	public void setRecurring() {
		_dateGroup.setRecurring(true);
	}

	/**
	 * update by shelton:
	 * 
	 */
	public void captureDateTime() {
		Date date =_dateTime.toDate();
//				_dateTime.withZone(DateTimeZone.forID("+08:00")).toDate();
		boolean onlyNamedDate = this.span.equals(NAMED_DAY)
				&& !this._timeGivenInGroup;
		boolean onlyTime = this._timeGivenInGroup && !this._dateGivenGroup;
		if (_dateGroup.isRecurring()) {
			_dateGroup.setRecurringUntil(date);
		} else if (!(onlyNamedDate || onlyTime) && verifyDate(_dateTime)) {
			_dateGroup.addDate(date);
		}
		_firstDateInvocationInGroup = true;
	}

	public boolean verifyDate(DateTime date) {
		// judge wheather is initial date
		if ( _initialDate == _dateTime ) return false;
		return _dateTime.getYear() >= 1900 && _dateTime.getYear() <= DateTime.now().getYear();
	}
	/**
	 * @return the list of date times found
	 */
	public DateGroup getDateGroup() {
		return _dateGroup;
	}

	/**
	 * Clears any date/times that have been captured
	 */
	public void clearDateGroup() {
		_dateGroup = new DateGroup();
	}

	// shelton

	/**
	 * Resets the calendar
	 */
	private void resetCalendar() {
		_dateTime = DateTime.now();
		if (_dafaultDate != null) {
			_dateTime =_dafaultDate;
		}
		_initialDate = _dateTime;
		_currentYear = _dateTime.getYear();
	}
//
//	private void seekToIcsEvent(String icsFileName, String eventSummary,
//			String direction, String seekAmount) {
//		int seekAmountInt = Integer.parseInt(seekAmount);
//		assert (direction.equals(DIR_LEFT) || direction.equals(DIR_RIGHT));
//		assert (seekAmountInt >= 0);
//
//		markDateInvocation();
//
//		// get the current year
//		DateTime cal = _dateTime;
//		cal.withZone(_defaultTimeZone);
//		int currentYear = cal.getYear();
//
//		// look up a suitable period of occurrences
//		boolean forwards = direction.equals(DIR_RIGHT);
//		int startYear = forwards ? currentYear : currentYear - seekAmountInt
//				- 1;
//		int endYear = forwards ? currentYear + seekAmountInt + 1 : currentYear;
//		Map<Integer, Date> dates = getDatesFromIcs(icsFileName, eventSummary,
//				startYear, endYear);
//
//		// grab the right one
//		boolean hasPassed = cal.isAfter(dates.get(currentYear).getTime());
//		int targetYear = currentYear
//				+ (forwards ? seekAmountInt + (hasPassed ? 0 : -1)
//						: (seekAmountInt - (hasPassed ? 1 : 0)) * -1);
//
//		cal.withZone(_dateTime.getZone());
//		cal.toDate().setTime(dates.get(targetYear).getTime());
//		_dateTime.set(Calendar.YEAR, cal.get(Calendar.YEAR));
//		_dateTime.set(Calendar.MONTH, cal.get(Calendar.MONTH));
//		_dateTime.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
//	}

//	private void seekToIcsEventYear(String icsFileName, String yearString,
//			String eventSummary) {
//		int yearInt = Integer.parseInt(yearString);
//		assert (yearInt >= 0);
//
//		markDateInvocation();
//
//		int year = getFullYear(yearInt);
//		Map<Integer, Date> dates = getDatesFromIcs(icsFileName, eventSummary,
//				year, year);
//		Date date = dates.get(year
//				- (eventSummary.equals(Holiday.NEW_YEARS_EVE.getSummary()) ? 1
//						: 0));
//
//		if (date != null) {
//			Calendar cal = getCalendar();
//			cal.setTimeZone(_dateTime.getTimeZone());
//			cal.setTime(date);
//			_dateTime.set(Calendar.YEAR, cal.get(Calendar.YEAR));
//			_dateTime.set(Calendar.MONTH, cal.get(Calendar.MONTH));
//			_dateTime
//					.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
//		}
//	}

	/**
	 * ensures that the first invocation of a date seeking rule is captured
	 */
	private void markDateInvocation() {
		// shelton : there is a date info
		this._dateGivenGroup = true;
		if (_firstDateInvocationInGroup) {
			// if a time has been given within the current date group,
			// we capture the current time before resetting the calendar
			if (_timeGivenInGroup) {
				int hours = _dateTime.getHourOfDay();
				int minutes = _dateTime.getMinuteOfHour();
				int seconds = _dateTime.getSecondOfMinute();
				resetCalendar();
				_dateTime = _dateTime.withHourOfDay(hours);
				_dateTime = _dateTime.withMinuteOfHour(minutes);
				_dateTime = _dateTime.withSecondOfMinute(seconds);
			} else {
				resetCalendar();
			}
			_firstDateInvocationInGroup = false;
		}
	}

	/**
   * 
   */
	private void markTimeInvocation() {
		_timeGivenInGroup = true;
		_dateGroup.setIsTimeInferred(false);
	}

//	private Map<Integer, Date> getDatesFromIcs(String icsFileName,
//			String eventSummary, int startYear, int endYear) {
//		IcsSearcher searcher = new IcsSearcher(icsFileName, _defaultTimeZone.toTimeZone());
//		return searcher.findDates(startYear, endYear, eventSummary);
//	}

	private int getFullYear(Integer year) {
		int result = year;

		if (year.toString().length() <= 2) {
			int century = (year > ((_currentYear - 2000) + TWO_DIGIT_YEAR_CENTURY_THRESHOLD)) ? 1900
					: 2000;
			result = year + century;
		}

		return result;
	}

	/**
	 * @return the current calendar
	 */
//	protected GregorianCalendar getCalendar() {
//		return CalendarSource.getCurrentCalendar();
//	}
	
	public static void main(String args[]) {
		JodaWalkerState state  = new JodaWalkerState();
		state.seekBySpan(">", "2", "by_hour");
		state.seekBySpan(">", "2", "by_minute");
		state.seekBySpan(">", "2", "by_second");
		state.seekBySpan("<", "2", "by_second");
		
//		state.setDayOfWeekIndex("4","5");
//		
//		state.seekToDayOfMonth("23");
//		state.seekToDayOfWeek(">", "by_week", "3", "3");
//		state.seekToDayOfYear("35");
//		state.seekToMonth(">", "2", "3");
//		state.seekToYear("89");
//		state.setExplicitDate("3", "14", "1", "2012");
//		state.setExplicitTime("3", "1", "34", "pm", null);
	}
}