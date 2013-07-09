package com.joestelmach.natty.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.ParseLocation;
import com.joestelmach.natty.Parser;


class Position {
	public int start;
	public int end;
}

public class DateParser {
	
	private Position position = new Position();
	
	private Parser parser;
	
	public DateParser() {
//		 DateTimeFormatter format = new DateTimeFormatterBuilder()
//		    .appendYear(0, 9999).appendLiteral('-').appendMonthOfYear(0).appendLiteral('-').appendDayOfMonth(0)
//		    .appendLiteral(' ').appendHourOfDay(0).appendLiteral(':').appendMinuteOfHour(0).toFormatter();
//		this.parser = new Parser(DateTime.parse("2012-5-19 00:00",format));
		this.parser = new Parser();
	}
	
	public String result(String date) {
		List<DateGroup> dataGroup = parser.parse(date);
		
		Map<String, List<Position>> positions = new HashMap<String, List<Position>>();
		Position positon = null;
		List<Position> lposition = null;
		List<String> dates = null;
		
		Map<String, Object>  results = new HashMap<String, Object>();;
		
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
//			System.out.println(JSON.toJSONString(results));
			
			dates = new ArrayList<String>();
			for (Date d : dg.getDates()) {
				dates.add(d.toString());
			}
			results.put("dates", dates);
//			results.put("dates", JSON.toJSONString(dates));
		}
//		System.out.println(((JSONObject)JSON.toJSON(results)).toJSONString());
		if (results.size() == 0) {
			results.put("errors", "could not parse input");
		}
		return JSON.toJSONString(results);
	}
	
	public static void main(String args[]) {
		DateParser dp = new DateParser();
		dp.result("2012-3-6");
	}
}
