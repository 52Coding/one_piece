package com.demo;

import java.util.concurrent.CountDownLatch;

public class CountDown4Fun {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch cdl = new CountDownLatch(2);
		
		new Thread(() -> {
			System.out.println("thread1 start.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			cdl.countDown();
			System.out.println("thread1 end.");
		}).start();
		
		new Thread(() -> {
			System.out.println("thread2 start.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			cdl.countDown();
			System.out.println("thread2 end.");
		}).start();
		
		cdl.await();
		
		System.out.println("hi...");

	}

}
