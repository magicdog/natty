package com.hipu.date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

public class LongTextPerformanceTest {
	
	private String filePath ;
	
	private String url;
	
	Parser prser = new Parser();
	
	public LongTextPerformanceTest(String filePath) {
		this.filePath = filePath;
	}
	
	public void test() {
		File file = new File(this.filePath);
		StringBuilder sb = new StringBuilder();
		long startTime = System.currentTimeMillis();
		long pageStartTime=startTime;
		long count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			File resultfile = new File("output");
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultfile));
			String line;
			int state = 0;
			long diff  = 0;
			while ( (line = reader.readLine()) != null ) {
				if (line.length() == 0)
					continue;
				if (line.contains("@@start@@")) {
					state = 1;
					url = reader.readLine();
					System.out.println("parse: "+ url);
				}
				if (state == 1 && line.contains("content:")) {
					state = 2;
					continue;
				}
				if (line.contains("@@end@@")) {
					
					pageStartTime = System.currentTimeMillis();
					List<DateGroup> ls = this.prser.parse(sb.toString());
					long pageDiff = System.currentTimeMillis() - pageStartTime;
					if (pageDiff>3000) {
						writer.write("overtime: "+url+"  "+ls.size() + " process time: "+pageDiff+"\n");
					}
					
					if (ls != null && ls.size() > 20) {
						writer.write("overnumb: "+url+"  "+ls.size() +"\n");
					}
					for (DateGroup dg : ls) {
						for (Date date: dg.getDates()) {
							System.out.println(date);
						}
					}
					count++;
					diff = System.currentTimeMillis()-startTime;
					System.out.println("total time: "+diff+" url count: "+count+" avarage: "+(1.0*diff)/count);
					
//					System.out.println(sb.toString());
					sb.delete(0, sb.capacity());
					state = 0;
				}
				if (state == 2)
					sb.append(line);
			}
			String summary = "total time: "+diff+" url count: "+count+" avarage: "+(1.0*diff)/count;
			writer.write(summary);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not find " + this.filePath);
		} catch (IOException e) {
			System.out.println("can not read more");
		}
	}
	public static void main(String args[]) {
		String filePath = LongTextPerformanceTest.class.getResource("/longtext").getPath();
//		if (args.length != 1) {
//			System.err.println("usage LongTextPerformanceTest file");
//			return;
//		}
			
		LongTextPerformanceTest ltp = new LongTextPerformanceTest(filePath);
//		LongTextPerformanceTest ltp = new LongTextPerformanceTest(args[0]);
		ltp.test();
	}
}
