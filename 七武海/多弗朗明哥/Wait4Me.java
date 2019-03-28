package com.demo;

/**
 * construction super()
 * Thread
 * extends
 * join() - waiting for me.
 * 主线程、子线程
 * 线程独立
 * 
 * @author cdyangzaiju
 * @date 2019年3月28日
 */
public class Wait4Me {

	public static void main(String[] args) {
		
		String mainThreadName = Thread.currentThread().getName();
		
		System.out.println(mainThreadName + ", thread started.");
		
		HiThread ht = new HiThread();
		ht.start();
		
		try {
			ht.join();//等我忙完
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(mainThreadName + ", thread ended.");
		
	}
}

// create thread
class HiThread extends Thread {
	
	public HiThread() {
		super("hi hi hi ");
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + ", thread started.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(threadName + ", thread ended.");
		
	}
	
}
