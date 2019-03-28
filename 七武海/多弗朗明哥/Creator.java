package com.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
		FutureTask<Integer> futureTask = new FutureTask<>(s);// FutureTask -> parent Runnable.
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
		
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Integer> temp = es.submit(s);// submit callable
		System.out.println(temp.get());
		
		es.submit(futureTask);// submit futureTask
		System.out.println(futureTask.get());
		
		es.shutdown();
		
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
		Thread.sleep(3000);
		return 5201314;
	}
	
}



