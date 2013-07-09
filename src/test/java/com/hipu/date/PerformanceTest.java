package com.hipu.date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
	private Parser parser;
	
	private List<String> contents;
	
	public PerformanceTest() {
		// TODO Auto-generated constructor stub
		contents = new ArrayList<String>();
		parser = new Parser();
	}
	
	void test() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(PerformanceTest.class.getResourceAsStream("/text.txt")));
			String line = "";
			while ( (line=reader.readLine()) != null) {
				contents.add(line);
			}
			long start = System.currentTimeMillis();
			int i = 0;
			int min = 999999;
			int max = 0;
			int length = contents.size();
			while (i++ < 50000) {
				line = contents.get(i%length);
				long begin = System.currentTimeMillis();
				parser.parse(line);
				int diff = (int) (System.currentTimeMillis() - begin);
				min = diff < min ? diff : min;
				max = diff > max ? diff : max;
			}
			long  total = System.currentTimeMillis() - start;
			System.out.println("line count: "+i+ " total time: "+total + " min: "+min+" max: "+max + " average: "+(1.0*total)/i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		PerformanceTest pt = new PerformanceTest();
		pt.test();
	}
}
