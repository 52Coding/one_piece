package com.demo;

import java.util.concurrent.Semaphore;

public class SingSemaphore {

	public static void main(String[] args) {
		
		int permits = 2;
		Semaphore s = new Semaphore(permits);
		
		System.out.printf("1剩余  %d 张许可证\n", s.availablePermits());
		
		new Thread(()-> {
			System.out.println("111");
			try {
				s.acquire(2);
				System.out.printf("2剩余   %d 张许可证\n", s.availablePermits());
				Thread.sleep(3000);
				System.out.println("mission1 complete!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release(2);
			}
		}).start();
		
		new Thread(()-> {
			System.out.println("222");
			try {
				s.acquire();
				System.out.printf("3剩余   %d 张许可证\n", s.availablePermits());
				System.out.println("拿到许可证，执行...");
				Thread.sleep(3000);
				System.out.println("mission2 complete!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release();
			}
		}).start();
		
		
	}

}
