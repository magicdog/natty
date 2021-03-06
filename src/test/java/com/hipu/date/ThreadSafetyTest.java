package com.hipu.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.TimeZone;

import org.junit.Assert;

import org.junit.Test;
import org.junit.BeforeClass;

public class ThreadSafetyTest extends AbstractTest {

  private final static int NUM_OF_THREADS = 50;
  private final static int JOIN_TIMEOUT = 2000; // 2 seconds
  private static DateFormat dateFormat;

  private AtomicInteger numOfCorrectResults = new AtomicInteger();

  @BeforeClass
  public static void oneTime() {
    Locale.setDefault(Locale.US);
    TimeZone.setDefault(TimeZone.getTimeZone("US/Eastern"));
    dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US);
    initCalendarAndParser();
  }

  @Test
  public void testManyThreads() throws Exception {
    Thread[] threads = new Thread[NUM_OF_THREADS];
    for (int i = 0; i < NUM_OF_THREADS; i++) {
      threads[i] = new Thread(new Tester(i));
    }
    for (Thread thread : threads) {
      thread.start();
    }
    for (Thread thread : threads) {
      thread.join(JOIN_TIMEOUT);
    }
    Assert.assertEquals(NUM_OF_THREADS, numOfCorrectResults.get());
  }

  private class Tester implements Runnable {

    private String  baseDate;
    private int baseMinute;

    public Tester(int baseMinute) throws Exception {
      baseDate = String.format("3/3/2011 1:%02d am", baseMinute);
      this.baseMinute = baseMinute;
    }

    public void run() {
      try {
        Thread.sleep(100);
      } catch (Exception e) { }
      Date parsed = _parser.parse(baseDate).get(0).getDates().get(0);
      validateThread(parsed, this.baseMinute);
      System.out.println(parsed);
      numOfCorrectResults.incrementAndGet();
    }
  }

  // We need this method, because validateDate and validateTime are not thread safe.
  private synchronized void validateThread(Date date, int baseMinute) {
    validateDate(date, 3, 3, 2011);
    validateTime(date, 1, baseMinute, 0);
  }
}
