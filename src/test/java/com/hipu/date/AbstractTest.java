package com.hipu.date;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Assert;
import org.junit.Before;

/**
 * 
 */
public abstract class AbstractTest {
  private static Calendar _calendar;
  protected static Parser _parser;


  public static void initCalendarAndParser() {
    _calendar = Calendar.getInstance();
//    Date date = new Date();
//    DateTimeFormatter format = new DateTimeFormatterBuilder()
//    .appendYear(0, 9999).appendLiteral('-').appendMonthOfYear(0).appendLiteral('-').appendDayOfMonth(0)
//    .appendLiteral(' ').appendHourOfDay(0).appendLiteral(':').appendMinuteOfHour(0).toFormatter();
//    _parser = new Parser(DateTime.parse("2012-5-19 00:00",format));
    _parser = new Parser();
    
  }

  /**
   * Resets the calendar source time before each test
   */
  @Before
  public void before() {
    CalendarSource.setBaseDate(null);
  }
  
  /**
   * Parses the given value into a collection of dates
   * 
   * @param value
   * @return
   */
  protected List<DateGroup> parseCollection(String value) {
	  DateTimeFormatter format = new DateTimeFormatterBuilder()
	    .appendYear(0, 9999).appendLiteral('-').appendMonthOfYear(0).appendLiteral('-').appendDayOfMonth(0)
	    .appendLiteral(' ').appendHourOfDay(0).appendLiteral(':').appendMinuteOfHour(0).toFormatter();
	  List<DateGroup> dg = _parser.parse(value,DateTime.parse("2012-5-19 00:00",format));
	  if (dg.size() == 0)
		  return null;
	  else 
		  return dg;
  }
  
  /**
   * Parses the given value, asserting that one and only one date is produced.
   * 
   * @param value
   * @return
   */
  protected List<DateGroup> parseSingleDate(String value) {
	 List<DateGroup> dates = parseCollection(value);
    if (dates == null) {
    	return null;
    }
    //Assert.assertEquals(1, dates.size());
    return dates;
  }
  
  /**
   * Asserts that the given string value parses down to the given 
   * month, day, and year values.
   * 
   * @param value
   * @param month
   * @param day
   * @param year
   */
  protected void validateDate(String value, int month, int day, int year) {
    List<DateGroup> date = parseSingleDate(value);
    validateDate(date.get(0).getDates().get(0), month, day, year);
  }
  
  /**
   * Asserts that the given date contains the given attributes
   * 
   * @param date
   * @param month
   * @param day
   * @param year
   */
  protected void validateDate(Date date, int month, int day, int year) {
    _calendar.setTime(date);
    Assert.assertEquals(month -1, _calendar.get(Calendar.MONTH));
    Assert.assertEquals(day, _calendar.get(Calendar.DAY_OF_MONTH));
    Assert.assertEquals(year, _calendar.get(Calendar.YEAR));
  }
  
  /**
   * 
   * Asserts that the given string value parses down to the given 
   * hours, minutes, and seconds
   * 
   * @param value
   * @param hours
   * @param minutes
   * @param seconds
   */
  protected void validateTime(String value, int hours, int minutes, int seconds) {
    List<DateGroup> date = parseSingleDate(value);
    validateTime(date.get(0).getDates().get(0), hours, minutes, seconds);
  }
  
  /**
   * 
   * Asserts that the given date contains the given time attributes
   * 
   * @param date 
   * @param hours
   * @param minutes
   * @param seconds
   */
  protected void validateTime(Date date, int hours, int minutes, int seconds) {
    _calendar.setTime(date);
    Assert.assertEquals(hours, _calendar.get(Calendar.HOUR_OF_DAY));
    Assert.assertEquals(minutes, _calendar.get(Calendar.MINUTE));
    Assert.assertEquals(seconds, _calendar.get(Calendar.SECOND));
  }
  
  /**
   * 
   * Asserts that the given string value parses down to the given 
   * month, day, year, hours, minutes, and seconds
   * 
   * @param value
   * @param month
   * @param day
   * @param year
   * @param hours
   * @param minutes
   * @param seconds
   */
  protected void validateDateTime(String value, int month, int day, int year, 
      int hours, int minutes, int seconds) {
    
    List<DateGroup> date = parseSingleDate(value);
    Assert.assertNotNull(date);
    System.out.print(value +" ( ");
    for (DateGroup dg : date) {
    	System.out.print(dg.getDates().get(0));
    }
    System.out.println(" )");
    validateDateTime(date.get(0).getDates().get(0), month, day, year, hours, minutes, seconds);
  }
  
  protected void validateNullDateTime(String value) {
	  List<DateGroup> date = parseSingleDate(value);
	  Assert.assertNull(date);
  }
  
  /**
   * Asserts that the given date contains the given attributes
   * 
   * @param date
   * @param month
   * @param day
   * @param year
   * @param hours
   * @param minutes
   * @param seconds
   */
  protected void validateDateTime(Date date, int month, int day, int year, 
      int hours, int minutes, int seconds) {

    _calendar.setTime(date);
    
    Assert.assertEquals(month -1, _calendar.get(Calendar.MONTH));
    Assert.assertEquals(day, _calendar.get(Calendar.DAY_OF_MONTH));
    Assert.assertEquals(year, _calendar.get(Calendar.YEAR));
    Assert.assertEquals(hours, _calendar.get(Calendar.HOUR_OF_DAY));
    Assert.assertEquals(minutes, _calendar.get(Calendar.MINUTE));
    Assert.assertEquals(seconds, _calendar.get(Calendar.SECOND));
  }
}
