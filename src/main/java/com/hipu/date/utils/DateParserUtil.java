package com.hipu.date.utils;

import com.hipu.date.DateGroup;
import com.hipu.date.ParseLocation;
import com.hipu.date.Parser;
import org.joda.time.DateTime;

import java.util.*;


class Position {
	public int start;
	public int end;
}

public class DateParserUtil {
	
	private Position position = new Position();
	
	private Parser parser;
	
	public DateParserUtil() {
//		 DateTimeFormatter format = new DateTimeFormatterBuilder()
//		    .appendYear(0, 9999).appendLiteral('-').appendMonthOfYear(0).appendLiteral('-').appendDayOfMonth(0)
//		    .appendLiteral(' ').appendHourOfDay(0).appendLiteral(':').appendMinuteOfHour(0).toFormatter();
//		this.parser = new Parser(DateTime.parse("2012-5-19 00:00",format));
		this.parser = new Parser();
	}
	
	public Map<String, Object> parse(String text, DateTime dateTime) {
		List<DateGroup> dataGroup = parser.parse(text, dateTime);
		
		Map<String, List<Position>> positions = new HashMap<String, List<Position>>();
		Position positon = null;
		List<Position> lposition = null;
		List<String> dates = null;
		
		Map<String, Object>  results = new HashMap<String, Object>();
		
		for (DateGroup dg : dataGroup) {
			String syntax = dg.getSyntaxTree().toStringTree();
			results.put("syntax", syntax);
			
			for (String key : dg.getParseLocations().keySet()) {
				lposition = new ArrayList<Position>();
				for ( ParseLocation pl: dg.getParseLocations().get(key)) {
					positon = new Position();
					positon.start = pl.getStart();
					positon.end = pl.getEnd();
					lposition.add(positon);
				}
				positions.put(key, lposition);
			}
			results.put("structure", positions);

			dates = new ArrayList<String>();
			for (Date d : dg.getDates()) {
				dates.add(d.toString());
			}
			results.put("dates", dates);
		}
		if (results.size() == 0) {
			results.put("errors", "could not parse input");
		}
		return results;
	}
	
	public static void main(String args[]) {
		DateParserUtil dp = new DateParserUtil();
        System.out.println(((List<Date>)(dp.parse("2013 年 4 月 19 日, 1:37 下午 - Picturepan2", null).get("dates"))).get(0));
	}
}
