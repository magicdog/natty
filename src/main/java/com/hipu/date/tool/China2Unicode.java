package com.hipu.date.tool;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.fortuna.ical4j.model.DateTime;

public class China2Unicode {

	public China2Unicode() {

	}

	public String chinaToUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		China2Unicode cu = new China2Unicode();
		//System.out.println(cu.chinaToUnicode("在"));
		System.out.println("星期一 "+cu.chinaToUnicode("星期一"));
		System.out.println("周一 "+cu.chinaToUnicode("周一"));
		System.out.println("星期二 "+cu.chinaToUnicode("星期二"));
		System.out.println("周二 "+cu.chinaToUnicode("周二"));
		System.out.println("星期三 "+cu.chinaToUnicode("星期三"));
		System.out.println("周三 "+cu.chinaToUnicode("周三"));
		System.out.println("星期四 "+cu.chinaToUnicode("星期四"));
		System.out.println("周四 "+cu.chinaToUnicode("周四"));
		System.out.println("星期五 "+cu.chinaToUnicode("星期五"));
		System.out.println("周五 "+cu.chinaToUnicode("周五"));
		System.out.println("星期六 "+cu.chinaToUnicode("星期六"));
		System.out.println("周六 "+cu.chinaToUnicode("周六"));
		System.out.println("星期天 "+cu.chinaToUnicode("星期天"));
		System.out.println("周天 "+cu.chinaToUnicode("周天"));
		System.out.println("周日 "+cu.chinaToUnicode("周日"));
		
		System.out.println("小时 "+cu.chinaToUnicode("小时"));
		System.out.println("分钟 "+cu.chinaToUnicode("分钟"));
		System.out.println("天 "+cu.chinaToUnicode("天"));
		System.out.println("星期 "+cu.chinaToUnicode("星期"));
		System.out.println("周 "+cu.chinaToUnicode("周"));
		System.out.println("月份 "+cu.chinaToUnicode("月份"));
		System.out.println("年份 "+cu.chinaToUnicode("年份"));
		
		System.out.println("今天 "+cu.chinaToUnicode("今天"));
		System.out.println("明天 "+cu.chinaToUnicode("明天"));
		System.out.println("昨天 "+cu.chinaToUnicode("昨天"));
		System.out.println("前天 "+cu.chinaToUnicode("前天"));
		System.out.println("后天 "+cu.chinaToUnicode("后天"));
		System.out.println("今晚 "+cu.chinaToUnicode("今晚"));
		System.out.println("今天晚上 "+cu.chinaToUnicode("今天晚上"));
		System.out.println("明晚 "+cu.chinaToUnicode("明晚"));
		System.out.println("明天晚上 "+cu.chinaToUnicode("明天晚上"));
		System.out.println("昨晚 "+cu.chinaToUnicode("昨晚"));
		System.out.println("昨天晚上 "+cu.chinaToUnicode("昨天晚上"));
		System.out.println("前晚 "+cu.chinaToUnicode("前晚"));
		System.out.println("前天晚上 "+cu.chinaToUnicode("前天晚上"));
		
		System.out.println("之前 "+cu.chinaToUnicode("之前"));
		System.out.println("之后 "+cu.chinaToUnicode("之后"));
		System.out.println("过去的 "+cu.chinaToUnicode("过去的"));
		System.out.println("日 "+cu.chinaToUnicode("日"));
		
		System.out.println("， "+cu.chinaToUnicode("，"));
		System.out.println("： "+cu.chinaToUnicode("："));
		
		System.out.println("春天的 "+cu.chinaToUnicode("春天的"));
		System.out.println("夏天 "+cu.chinaToUnicode("夏天"));
		System.out.println("秋天 "+cu.chinaToUnicode("秋天"));
		System.out.println("冬天 "+cu.chinaToUnicode("冬天"));
		
		System.out.println("个 "+cu.chinaToUnicode("个"));
		
		String numbers ="零一二三四五六七八九十";
		
		int count = 12;
		for (int i=1; i<= count ;i++) {
				System.out.println("  | CINT_"+i+"\t\t-> INT[" +"\""+i+"\"]");
		}
		System.out.println("今日 "+cu.chinaToUnicode("今日"));
		System.out.println("上午 "+cu.chinaToUnicode("上午"));
		System.out.println("早上 "+cu.chinaToUnicode("早上"));
		System.out.println("（ "+cu.chinaToUnicode("（"));
		System.out.println("） "+cu.chinaToUnicode("）"));

		System.out.println("下午 "+cu.chinaToUnicode("下午"));
		System.out.println("晚上 "+cu.chinaToUnicode("晚上"));
		System.out.println("凌晨 "+cu.chinaToUnicode("凌晨"));

		System.out.println("号 "+cu.chinaToUnicode("号"));
		System.out.println("秒钟 "+cu.chinaToUnicode("秒钟"));
		System.out.println("半小时 "+cu.chinaToUnicode("半小时"));
		
		System.out.println(System.getProperty("user.home"));
		
	}
	
}
