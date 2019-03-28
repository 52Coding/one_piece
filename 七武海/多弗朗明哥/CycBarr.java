package com.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycBarr {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		// 聚能环
		CyclicBarrier cyc = new CyclicBarrier(2 , ()-> {
			System.out.println("走完一圈");
		});
		

		new Thread(() -> {
			System.out.println("111-1");
			try {
				Thread.sleep(3000);
				cyc.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("111-2");
		}).start();
		
		new Thread(() -> {
			System.out.println("222-1");
			try {
				Thread.sleep(3000);
				cyc.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("222-2");
		}).start();
		
		new Thread(() -> {
			System.out.println("333-1");
			try {
				Thread.sleep(6000);
				cyc.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("333-2");
		}).start();
		
		new Thread(() -> {
			System.out.println("444-1");
			try {
				Thread.sleep(6000);
				cyc.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("444-2");
		}).start();
		
		
	}

}
