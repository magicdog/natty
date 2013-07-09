package com.hipu.date;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPerformance extends AbstractTest {

	private final static int NUM_OF_THREADS = 50;
	private final static int JOIN_TIMEOUT = 20000; // 2 seconds
	private static List<String> contents;

	private AtomicInteger numOfCorrectResults = new AtomicInteger();

	public ConcurrentPerformance() {
		initCalendarAndParser();
		contents = new ArrayList<String>();
	}

	public void testManyThreads() throws Exception {
		Thread[] threads = new Thread[NUM_OF_THREADS];
		BufferedReader reader = new BufferedReader(new InputStreamReader(PerformanceTest.class.getResourceAsStream("/text.txt")));
		String line = "";
		while ( (line=reader.readLine()) != null) {
			contents.add(line);
		}
		int length = contents.size();
		int dateCountPerThread = length / NUM_OF_THREADS;
		int timePerThread = 50000/NUM_OF_THREADS;
		int start = 0;
		int end = dateCountPerThread;
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			threads[i] = new Thread(new Tester(timePerThread,contents.subList(start, end)));
			start = end;
			end += dateCountPerThread;
		}
		long beginTime = System.currentTimeMillis();
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join(JOIN_TIMEOUT);
		}
		long  total = System.currentTimeMillis() - beginTime;
		System.out.println(" total time: "+total +" average: "+(1.0*total)/50000);
		//Assert.assertEquals(NUM_OF_THREADS, numOfCorrectResults.get());
	}

	private class Tester implements Runnable {

		private List<String> dates;
		private int PollTime;

		public Tester(int timePerThread, List<String> dates) throws Exception {
			this.dates = dates;
			this.PollTime = timePerThread;
		}

		public void run() {
			long start = System.currentTimeMillis();
			int count = dates.size();
			for (int i=0; i<this.PollTime;i++) {
				_parser.parse(dates.get(i%count));
			}
			System.out.println(System.currentTimeMillis()-start);
			numOfCorrectResults.incrementAndGet();
		}
	}
	
	public static void main(String args[]) {
		ConcurrentPerformance cp = new ConcurrentPerformance();
		try {
			cp.testManyThreads();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
