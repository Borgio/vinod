/**
 * 
 */
package com.vk.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author vinod
 * 
 * https://mishrabagish.wordpress.com/2012/12/17/explicit-vs-intrinsic-locks-in-java-ensuring-thread-scheduling-fairness/
 * 
 */
public class IncentricVsExplicitLock {
	
	public class Monitor {

	}
	
	public class IncentricLockThread implements Runnable {

		private Monitor monitor;

		public IncentricLockThread(Monitor monitor) {
			super();
			this.monitor = monitor;
		}

		public void run() {

			printMessage("Entered run method...trying to lock monitor object");
			synchronized (monitor) {
				printMessage("Locked monitor object");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printMessage("Releasing lock");
				monitor.notifyAll();
			}
			printMessage("End of run method");

		}

		private void printMessage(String msg) {
			System.out.println(Thread.currentThread().getName() + " : " + msg);
		}

	}
	
	public class ExplicitLockThread implements Runnable {

		private Lock lock;

		public ExplicitLockThread(Lock lock) {
			super();
			this.lock = lock;
		}

		public void run() {

			printMessage("Entered run method...trying to lock monitor object");
			lock.lock();
			try {
				printMessage("Locked monitor object");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				printMessage("Realising lock");
				lock.unlock();
			}
			printMessage("End of run method");

		}

		private void printMessage(String msg) {
			System.out.println(Thread.currentThread().getName() + " : " + msg);
		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("=========Intrinsic Lock Test=======");
		String[] myThreads = {"Therad ONE","Thread TWO","Thread THREE","Thread FOUR"};
		IncentricVsExplicitLock outer = new IncentricVsExplicitLock();
		Monitor monitor = outer.new Monitor();
		
		for (String threadName : myThreads) {
			new Thread(outer.new IncentricLockThread(monitor), threadName).start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("=========Explicit Lock Test=======");
		Lock lock = new ReentrantLock(true);
		for (String threadName : myThreads) {
			new Thread(outer.new ExplicitLockThread(lock), threadName).start();
		}

	}

}
