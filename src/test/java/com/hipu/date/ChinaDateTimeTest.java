package com.hipu.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Runs the parser through the various datetime formats 
 * 
 */
public class ChinaDateTimeTest extends AbstractTest {
  @BeforeClass
  public static void oneTime() {
    Locale.setDefault(Locale.US);
    TimeZone.setDefault(TimeZone.getTimeZone("US/Eastern"));
    initCalendarAndParser();
  }
  
  @Test
  public void testSpecific() throws Exception {
    Date reference = DateFormat.getDateTimeInstance(DateFormat.SHORT, 
        DateFormat.SHORT).parse("5/19/2012 12:00 am");
    CalendarSource.setBaseDate(reference);
    
    validateDateTime("1年前", 5, 19, 2011, 0, 0, 0);
    validateDateTime("12月前", 5, 19, 2011, 0, 0, 0);
    validateDateTime("1 月前 ", 4, 19, 2012, 0, 0, 0);
    validateDateTime("30 日前", 4, 19, 2012, 0, 0, 0);
    validateNullDateTime("2332");
    validateDateTime("2012 年 7 月 23 日 14:05 ", 7, 23, 2012, 14,     5, 0);
    validateDateTime("1小时前", 5, 18, 2012, 23, 0, 0);
    validateDateTime("1分钟前", 5, 18, 2012, 23, 59, 0);
    validateDateTime("49 分钟前", 5, 18, 2012, 23, 11, 0);
   validateDateTime("八月 -   6 - 2012 ", 8, 6, 2012, 0, 0, 0);
    validateDateTime("23分 钟前  ", 5, 18, 2012, 23, 37, 0);
    validateDateTime("十一月 - 30 - 2011", 11, 30, 2011, 0, 0, 0);
    validateDateTime("星期五, 18 五月 2012", 5, 18, 2012, 0, 0, 0);
    validateNullDateTime("今天");
    validateNullDateTime("明天");
    validateDateTime("昨天 12:02", 5, 18, 2012, 12, 2, 0);
    validateDateTime("2013年4月10日04:44", 4, 10, 2013, 4, 44, 0);
    validateDateTime("2013-04-10 05:47", 4, 10, 2013, 5, 47, 0);
    validateDateTime("今天13:25", 5, 19, 2012, 13, 25, 0);
    validateNullDateTime("4月5日 22:54");
    validateDateTime("Thu Aug 16, 2012 12:16", 8, 16, 2012, 12, 16, 0);
    validateNullDateTime("139530117");
    validateNullDateTime("Mailbox 已获得约1200万美元投资，其用户也已超过100亿，且排队等候邀请的用户还有逾130万位。虽然 Mailbox 现在仅支持 iOS");
    validateNullDateTime("长株潭报4月10日讯（记者 欧亚琦）昨日，记者从株洲市住房与城乡建设局了解到，长2.7公里，宽31米的长庆大道今年将全面建成通车，该大道将会进一步拉动醴陵长庆示范区发展。");
    validateDateTime("2013-04-11 11:33:00　来源：网络　", 4, 11, 2013, 11, 33, 0);
    validateNullDateTime(" Transistor《水晶剑》的发行日期不详，07073苹果站会持续关注游戏动态，敬请关注。");
    validateNullDateTime(" 04-09");
    validateNullDateTime("画面：3D写实 大小：15.80");
    validateNullDateTime("Copyright 2002-2011 07073.com, All Rights Reserved");
    validateDateTime("　4月8日，晨光在群英村显得十分灿烂。群英村曾是1964年5月6日“远学大寨。", 5, 6, 1964, 0, 0, 0);
    validateDateTime("Thursday, April 11, 2013", 4, 11, 2013, 0, 0, 0);
    validateNullDateTime("湘腾琴岛营销中心3月30日开放 预计4月开盘");
    validateNullDateTime("术维护电话：84662193 业务咨询电话：84662665 新闻热线：84662664 经营许可证号：湘ICP证010022 ");
    validateNullDateTime("今年2月份长沙楼市的“成绩单”日前发布，长沙市房产研究中心权威发布《2013年1-2月长沙市房产交易情况通报》（以下简称“《通报》”）显示，1-2月长沙楼市");
    validateNullDateTime("12月9日河西看房");
    validateDateTime("2012-5-6 14时56分", 5, 6, 2012, 14,56, 0);
    validateDateTime("时间：2013-1-19 12：12:11", 1, 19, 2013, 12, 12, 11);
    validateNullDateTime("销毁违法车２３５５辆");
    validateDateTime("来源:265g.com发表时间:2013-04-11评论 4条 265G微博", 4, 11, 2013, 0, 0, 0);
    validateDateTime("今日09:00天尊传奇(酷玩吧)", 5, 19, 2012, 9, 0, 0);  //增加今日支持
    validateDateTime("2013.2.3", 2, 3, 2013, 0, 0, 0);  //增加对.连接符支持
    validateNullDateTime("2216.61 -2.94 -0.13% 158.67亿"); 
    validateDateTime("2013-04-11 10:01:38", 4, 11, 2013, 10, 01, 38);
    validateDateTime("。但是，2008年1月17日和2008年9月28日，国家标准化委员会先后两次下发修改单", 1, 17, 2008, 0, 0, 0);
    validateNullDateTime("人民网海南视窗博鳌4月6日电（记者吉羽）4月6日上午，博鳌亚洲论坛2013年年会“博鳌乐城杯”桥牌名人赛在博鳌金海岸酒店博鳌厅举行。赛事吸引了大批各界政商名流参赛。");
    validateNullDateTime("联赛无等级比赛于4月6日结束，经过两天的比赛，海关一队获第一名，成均");
    validateDateTime("2013-04-29   至  2013-05-01", 4,29 , 2013, 0, 0, 0);
    validateDateTime("：2013年4月29日至5月1日       ", 4,29 , 2013, 0, 0, 0);
    validateNullDateTime("童装2013年春夏新品发布会暨招商会将于11月6日至8日隆重召开，");
    validateNullDateTime("（春季）于4月5日在位于香港尖沙咀弥敦");
    validateDateTime("于2013年5月16-18日在中国西", 5,16 , 2013, 0, 0, 0);
    validateDateTime("4 12 2012, 17:50 ", 12,4 , 2012, 17, 50, 0);
    validateDateTime("将于2012年4月16日（周二）早上8：30在市少年路桥牌协会活动中心准时开赛。", 4, 16, 2012, 8,30, 0);//增加上午等支持
    validateNullDateTime("（转自：人民网海南视窗）4月6日上午11时30分，博鳌亚洲论坛2013年年会“博鳌乐城杯”桥牌名人赛圆满落幕。");
    validateDateTime("JULY（7月15）, 2011 at 15:50 AM", 7, 15, 2011, 15, 50, 0);
   validateDateTime("7月9, 2011 english updated at 15:50 AM", 7, 9, 2011, 15, 50, 0);
   validateDateTime("15:50 7月9号, 2011", 7, 9, 2011, 15, 50, 0);
   validateDateTime("10:00 a.m. at beijing time (utc), April 8th, 2013", 4, 8, 2013, 6, 0, 0);
    validateDateTime("10:00 a.m. +08:00, April 8th, 2013", 4, 7, 2013, 22, 0, 0);
    validateDateTime("98-5-9",5, 9, 1998, 0, 0, 0);
    validateDateTime("13-04-16 08:38:50",4, 16, 2013, 8, 38, 50);
    validateDateTime("前天 08:38:50",5, 17, 2012, 8, 38, 50);
    validateDateTime("2013年march7日|08:47:22 pm",3, 7, 2013, 20, 47, 22);
    validateDateTime("星期二, 02月 16th, 2013",2, 16, 2013, 0, 0, 0);
    validateDateTime("2013/04/16 11:31 KST",4, 16, 2013, 7, 31, 0);
    validateDateTime(" April（4月）2, 2013 at 11:15 AMPosted b",4, 2, 2013, 11, 15, 0);
    validateDateTime(" 2013.4.16 11:39",4, 16, 2013, 11, 39, 0);
    validateDateTime(" 2013年April7日|08:47:22 pm",4, 7, 2013, 20, 47, 22);
    validateDateTime(" 2 二, 2013",2, 2, 2013,  0, 0, 0);
    validateDateTime("6 April 2013 Updated at 15:40 CEST",4, 6, 2013,  15, 40, 0);
    validateDateTime("1小时20分钟之前",5, 18, 2012,  23, 0, 0);
    validateNullDateTime("1844年5月-1926年6月");
    validateDateTime("半小时前",5, 18, 2012,  23, 30, 0);
//  http://www.milk.com.hk/content/fancl%E3%80%8C%E9%9B%B6%E8%B2%A0%E6%93%94%E3%80%8D  日期无语
    validateDateTime("04.08.13",4, 8, 2013,  0, 0, 0);
    validateDateTime("11.08.12",11, 8, 2012,  0, 0, 0);
    validateDateTime("98.08.12",8, 12, 1998,  0, 0, 0);
    validateDateTime("2013 年 4 月 19 日, 1:37 下午 - Picturepan2",4, 19, 2013,  13, 37, 0);
    validateNullDateTime("03-08 14:12:07 |");
    validateNullDateTime("http://trends.com.cn/fashion/match/mix/2012-12/434545.shtml");
    validateDateTime("http://news.jschina.com.cn/system/2012/12/05/015452014.shtml",12, 5, 2012,  0, 0, 0);
    validateDateTime("http://ndnews.oeeee.com/html/20121006/05/6675.html",10, 6, 2012,  0, 0, 0);
    validateDateTime("ttp://news.ynet.com/1183/2012/12/05/349@388295.htm",12, 5, 2012,  0,0, 0);
    validateNullDateTime("http://www.zaobao.com/zg/zg121205_003.shtml");
    validateNullDateTime("http://news.163.com/12/1205/16/8HVMRVI00001124J.html");
    validateDateTime("http://games.sina.com.cn/t/n/2012-10-19/1634662211.shtml",10, 19, 2012,  0, 0, 0);
    validateDateTime("Apr 22nd , 2013",4, 22, 2013,  0, 0, 0);
    validateDateTime("1/15/2012",1, 15, 2012,  0, 0, 0);
    validateDateTime("15/1/2012",1, 15, 2012,  0, 0, 0);
    validateDateTime("发表于09/04/2012 14:09 标签",9, 4, 2012,  14, 9, 0);
    validateDateTime("Rosicky 发表于15/1/2012 09:13 标签: iOS511",1, 15, 2012,  9,13, 0);
    validateDateTime("  2012-12-05 07:00:17  来源：       东北网",12, 5, 2012,  7, 0, 17);
    validateDateTime("Jun. 6, 2012, 10:01 PM",6, 6, 2012,  22, 1, 0);
    validateDateTime("06-06-2012 | 12:48 PM",6, 6, 2012,  12, 48, 0);
    validateDateTime("11:00 AM Tuesday June 5, 2012",6, 5, 2012, 11, 0, 0);
    validateDateTime("Jun 7th 2012 at 2:07AM",6, 7, 2012,  2, 7, 0);
    validateDateTime("JUNE 6, 2012 AT 4:31 PM PT",6, 6, 2012,  19, 31, 0);
    validateDateTime("2013-04-01 05:02:01",4, 1, 2013,  5, 2, 1);
    validateDateTime("2012-11-07 22:05:12     Xinhua       Web Editor: liuranran",11, 7, 2012,  22, 5, 12);
    validateDateTime("Owen Williams Contact Author 10 November 2012 Updated at 18:07 CET 15",11, 10, 2012,  18, 7, 0);
    validateDateTime("By Bruce Sterling Email Author November 11, 2012 | 5:07 am | ",11, 11, 2012,  5, 7, 0);
    validateNullDateTime("14-15-1988");
    validateDateTime("2-20-12",2, 20, 2012,  0, 0, 0);
    validateDateTime("2012年8月1号",8, 1, 2012,  0, 0, 0);
    validateNullDateTime("/2011101201");
    validateNullDateTime("20130420120425.");
    validateNullDateTime("04.18 10:48");
    validateNullDateTime("50-10-3050");
    validateNullDateTime("400-41-02-5");
    validateNullDateTime("2013-2-30");
    validateNullDateTime("2013-22-3");
    validateNullDateTime("23434-22-3");
    validateNullDateTime("23-12-121");
    validateDateTime("April 3, '98 and 2013.",4, 3, 1998,  0, 0, 0);
    validateDateTime("April 3, 98 and 2013-3-4",4, 3, 1998,  0, 0, 0);
    validateNullDateTime("96, 2:1 in June 1998 and 2:1 in");
    validateNullDateTime("10:00, Apr 20,");
    validateNullDateTime("13-21 15:17:51");
    validateNullDateTime("may 2013");
  }
  @Test
  public void testEnglish() throws Exception {
	    Date reference = DateFormat.getDateTimeInstance(DateFormat.SHORT, 
	        DateFormat.SHORT).parse("5/19/2012 12:00 am");
	    CalendarSource.setBaseDate(reference);
//	    validateDateTime("账号限量发放中DEC 8TH , 2010", 12, 8, 2010, 0, 0, 0);
//	    validateDateTime("APRIL 11, 2013", 4, 11, 2013, 0, 0, 0);
//	    validateDateTime("ruda died at the age of sixty-nine, supposedly of prostate cancer, just twelve days after the violent September 11, 1973, military coup launched ", 9, 11, 1973, 0, 0, 0);
//	    validateDateTime("twelve days ", 5, 16, 2013, 0, 0, 0); // 禁止对12 days的支持
  }
  
  @Test
  public void testRelative() throws Exception {
    Date reference = DateFormat.getDateTimeInstance(DateFormat.SHORT, 
        DateFormat.SHORT).parse("2/24/2011 12:00 am");
    CalendarSource.setBaseDate(reference);
    
   // validateDateTime("seven years ago at 3pm", 2, 24, 2004, 15, 0, 0);
//    validateDateTime("next wed. at 5pm", 3, 2, 2011, 17, 0, 0);
//    validateDateTime("3 days after next wed at 6a", 3, 5, 2011, 6, 0, 0);
//    validateDateTime("8pm on the sunday after next wed", 3, 6, 2011, 20, 0, 0);
//    validateDateTime("two days after today @ 6p", 2, 26, 2011, 18, 0, 0);
//    validateDateTime("two days from today @ 6p", 2, 26, 2011, 18, 0, 0);
//    validateDateTime("11:59 on 3 sundays after next wed", 3, 20, 2011, 11, 59, 0);
//    validateDateTime("the day after next 6pm", 2, 26, 2011, 18, 0, 0);
//    validateDateTime("the week after next 2a", 3, 10, 2011, 2, 0, 0);
//    validateDateTime("the month after next 0700", 4, 24, 2011, 7, 0, 0);
//    validateDateTime("the year after next @ midnight", 2, 24, 2013, 0, 0, 0);
//    validateDateTime("every Sunday", 3, 9, 2011, 19, 0, 0);
//    validateDateTime("the 28th of the month after next in the morning", 4, 28, 2011, 8, 0, 0);
//    validateDateTime("this morning", 2, 24, 2011, 8, 0, 0);
//    validateDateTime("this afternoon", 2, 24, 2011, 12, 0, 0);
//    validateDateTime("this evening", 2, 24, 2011, 19, 0, 0);
//    validateDateTime("today evening", 2, 24, 2011, 19, 0, 0);
//    validateDateTime("tomorrow evening", 2, 25, 2011, 19, 0, 0);
//    validateDateTime("friday evening", 2, 25, 2011, 19, 0, 0);
//    validateDateTime("monday 6 i	n the morning", 2, 28, 2011, 6, 0, 0);
//    validateDateTime("monday 4 in the afternoon", 2, 28, 2011, 16, 0, 0);
//    validateDateTime("monday 9 in the evening", 2, 28, 2011, 21, 0, 0);
//    validateDateTime("tomorrow @ noon", 2, 25, 2011, 12, 0, 0);
//    //shelton
//    //12 am == 0  12 pm == 24
//    validateDateTime("1 hour ago", 2, 23, 2011, 23, 0, 0);
//    validateDateTime("April 8, 2013", 4, 8, 2013, 0, 0, 0);
//    //validateDateTime("7 April 2013 update 21:44", 4, 7, 2013, 21, 44, 0);
//    validateDateTime("JUNE 6, 2012 在 4:31 PM", 6, 6, 2012, 16, 31, 0);
//    validateDateTime("04/08/2013 at 12:10 AM", 4, 8, 2013, 0, 10, 0);
  }
  
  @Test
  public void testRange() throws Exception {
    Date reference = DateFormat.getDateInstance(DateFormat.SHORT).parse("6/12/2010");
    CalendarSource.setBaseDate(reference);
    
//    List<Date> dates = parseCollection("2009-03-10 9:00 to 11:00");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 3, 10, 2009, 9, 0, 0);
//    validateDateTime(dates.get(1), 3, 10, 2009, 11, 0, 0);
//    
//    dates = parseCollection("26 oct 10:00 am to 11:00 am");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 10, 26, 2010, 10, 0, 0);
//    validateDateTime(dates.get(1), 10, 26, 2010, 11, 0, 0);
//    
//    dates = parseCollection("16:00 nov 6 to 17:00");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 11, 6, 2010, 16, 0, 0);
//    validateDateTime(dates.get(1), 11, 6, 2010, 17, 0, 0);
//    
//    dates = parseCollection("6am dec 5 to 7am");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 12, 5, 2010, 6, 0, 0);
//    validateDateTime(dates.get(1), 12, 5, 2010, 7, 0, 0);
//    
//    dates = parseCollection("3/3 21:00 to in 5 days");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 3, 3, 2010, 21, 0, 0);
//    validateDateTime(dates.get(1), 6, 17, 2010, 21, 0, 0);
//    
//    dates = parseCollection("November 20 2 p.m. to 3 p.m");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 11, 20, 2010, 14, 0, 0);
//    validateDateTime(dates.get(1), 11, 20, 2010, 15, 0, 0);
//    
//    dates = parseCollection("November 20 2 p.m. - 3 p.m.");
//    Assert.assertEquals(2, dates.size());
//    validateDateTime(dates.get(0), 11, 20, 2010, 14, 0, 0);
//    validateDateTime(dates.get(1), 11, 20, 2010, 15, 0, 0);
  }
  
  @Test
  public void testList() throws Exception {
    Date reference = DateFormat.getDateInstance(DateFormat.SHORT).parse("05/19/2012");
    CalendarSource.setBaseDate(reference);
    
//    List<Date> dates = parseCollection("June 25th at 9am and July 2nd at 10am and August 16th at 11am");
//    Assert.assertEquals(3, dates.size());
//    validateDateTime(dates.get(0), 6, 25, 2012, 9, 0, 0);
//    validateDateTime(dates.get(1), 7, 2, 2012, 10, 0, 0);
//    validateDateTime(dates.get(2), 8, 16, 2012, 11, 0, 0);
//    
//    dates = parseCollection("June 25th at 10am and July 2nd and August 16th");
//    Assert.assertEquals(3, dates.size());
//    validateDateTime(dates.get(0), 6, 25, 2012, 10, 0, 0);
//    validateDateTime(dates.get(1), 7, 2, 2012, 10, 0, 0);
//    validateDateTime(dates.get(2), 8, 16, 2012, 10, 0, 0);
//    
//    dates = parseCollection("June 25th and July 2nd at 10am and August 16th");
//    Assert.assertEquals(3, dates.size());
//    validateDateTime(dates.get(0), 6, 25, 2012, 0, 0, 0);
//    validateDateTime(dates.get(1), 7, 2, 2012, 10, 0, 0);
//    validateDateTime(dates.get(2), 8, 16, 2012, 10, 0, 0);
//    
//    dates = parseCollection("June 25th and July 2nd and August 16th at 10am");
//    Assert.assertEquals(3, dates.size());
//    validateDateTime(dates.get(0), 6, 25, 2012, 0, 0, 0);
//    validateDateTime(dates.get(1), 7, 2, 2012, 0, 0, 0);
//    validateDateTime(dates.get(2), 8, 16, 2012, 10, 0, 0);
    
  }
}
