package com.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多个线程并发执行（非串行）
 * 线程太多，调度的时间也会相应增加
 * @author cdyangzaiju
 * @date 2019年3月28日
 */
public class Creator {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FirstWay f = new FirstWay();
		new Thread(f).start();
		// f.run();
		
		SecondWay s = new SecondWay();
		FutureTask<Integer> future = new FutureTask<>(s);// FutureTask -> parent Runnable.
		new Thread(future).start();
		System.out.println(future.get());
		
	}
}

// 1. Runnable -> Thread构造函数入参
class FirstWay implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("IamFirst.");
	}
	
}

// 2. Callable & FutureTask
class SecondWay implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return 5201314;
	}
	
}



