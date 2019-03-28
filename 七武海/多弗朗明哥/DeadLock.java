package com.demo;

public class DeadLock {
	
	public static Integer a = 1;
	public static Integer b = 100;

	public static void main(String[] args) {
		
		
	
		new Thread(()->{
			System.out.println("111");
			synchronized (a) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("222");
				synchronized (b) {
					a += b;
					System.out.println("333");
				}
			}
			System.out.println(a);
		}).start();
		

		new Thread(()->{
			System.out.println("444");
			synchronized (b) {
				System.out.println("555");
				synchronized (a) {
					b -= a;
					System.out.println("666");
				}
			}
		}).start();
		
	}
	
	

}
