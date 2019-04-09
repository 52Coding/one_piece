package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Live4What implements Cloneable {

	static {
		// first.
	}
	
	{
		// second.
	}
	
	private Live4What() {
		// default.
		// last.
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		Queue<Integer> littleQ = new LinkedList<>();// offer poll
		Deque<Integer> qq = new LinkedList<>();// double ended queue 双端
		Stack<Integer> stack = new Stack<>();// push pop
		
		Object o = new Object();
		o.equals("xxx");
		o.hashCode();
		o.toString();
		// o.wait();// current thread wait notify
		
		List<Integer> list = Arrays.asList(1, 3, 4);// list<T>
		Arrays.asList("1,2,3".split(","));
		Collections.emptyList();
		Collections.sort(list);
		
		// Future Callable Runnable ExecutorService 
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Integer> fu = es.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(3000);
				System.out.println(list);
				return list.get(0);
			}
		});
		System.out.println(fu.get(5, TimeUnit.SECONDS));
		es.submit(() -> { System.out.println("hello"); });
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("world");
				return list.get(0);
			}
		});
		es.submit(task);
		System.out.println(task.get());
		es.shutdown();
		
		list.stream().findFirst();
		System.out.println(list.stream().filter(x->x>1).map(x->++x).collect(Collectors.toList()));
		System.out.println(list.stream().filter(x->x>1).map(x->x.toString()).collect(Collectors.joining("$")));
		
		// NIO: FileChannel Buffer flip Selector
		
		// CountDownLatch
		// CyclicBarrier
		// Semaphore
		
		// ReentrantLock
		// AtomicInteger
		// ConcurrentHashMap<K, V>
		// CopyOnWriteArrayList<E>
		
		// AQS： AbstractQueuedSynchronizer
		
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * depth first search. 前序：顶、左、右
 * broad first search. 层序：自顶向下
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
