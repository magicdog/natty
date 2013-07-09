package com.joestelmach.natty.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.joestelmach.natty.Parser;


public class DateParserServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(DateParserServlet.class);

    public DateParserServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        //String url = req.getParameter("url").trim();
        String res = "parse"; 
        resp.setHeader("Cache-control", "max-age=10");
        resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(res);
		resp.getWriter().close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getParameter("value");
		System.out.println(url);
		DateParser parser = new DateParser();
		
//        String res = "{'syntax':'(DATE_TIME_ALTERNATIVE (DATE_TIME (EXPLICIT_DATE (MONTH_OF_YEAR 05) (DAY_OF_MONTH 16) (YEAR_OF 2013))))'," +
//        		"'structure':{'formal_date':[{'start':0,'end':10}],'formal_day_of_month':[{'start':8,'end':10}],'date_time_alternative':[{'start':0,'end':10}],'date':[{'start':0,'end':10}],'formal_month_of_year':[{'start':5,'end':7}]}," +
//        		"'dates':['Thu May 16 08:38:57 UTC 2013']}"; 
		String res = parser.result(url);
        resp.setHeader("Cache-control", "max-age=10");
        resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(res);
		resp.getWriter().close();
	}
    
    
}
