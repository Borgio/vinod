package com.vk.thread;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author vinod
 * 
 *         https://mishrabagish.wordpress.com/2012/06/21/using-countdownlatch-in
 *         -java-concurrent-programming/
 *
 */
public class CountDownLatchExample {

	public class MyTask implements Callable<String> {

		private String name;
		private CountDownLatch latch;

		public MyTask(String name, CountDownLatch latch) {
			super();
			this.name = name;
			this.latch = latch;
		}

		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName() + "=====In method");
			System.out.println(Thread.currentThread().getName() + "=====Waitinglatch to open");
			latch.await();
			System.out.println(Thread.currentThread().getName() + "=====Latchpen now");
			char[] chars = name.toCharArray();
			Arrays.sort(chars);
			StringBuilder builder = new StringBuilder();
			for (char c : chars)
				builder.append(c);

			System.out.println(Thread.currentThread().getName() + "=====Completedexecution ");
			return builder.toString();
		}

	}

	public static void main(String[] args) {

		CountDownLatchExample example = new CountDownLatchExample();
		CountDownLatch latch = new CountDownLatch(2);
		MyTask task1 = example.new MyTask("java", latch);
		MyTask task2 = example.new MyTask("concurrent", latch);
		ExecutorService service = Executors.newFixedThreadPool(2);
		System.out.println(Thread.currentThread().getName() + "=====submitting1");
		Future<String> future1 = service.submit(task1);

		System.out.println(Thread.currentThread().getName() + "=====Submitted 1...calling latch count down 1");
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + "=====submitting2");
		Future<String> future2 = service.submit(task2);

		System.out.println(Thread.currentThread().getName() + "=====Submitted 2...calling latch count down 2");
		latch.countDown();
		try {
			System.out.println(Thread.currentThread().getName() + "===Result1=" + future1.get());
			System.out.println(Thread.currentThread().getName() + "===Result1=" + future2.get());
			System.out.println("OOPSecutionException Exception");
		} catch (Exception e) {
			System.out.println("OOPSterruptedException Exception");
		}

	}

}
