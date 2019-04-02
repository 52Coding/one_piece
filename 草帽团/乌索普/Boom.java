package com.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Boom {

	public static void main(String[] args) {
		"123".charAt(0);
		Math.max(15, 10);//Math.min(x, y)
		// map.containsKey(xxx)
		int[] a = {1, 3, 4};
		int[] b = new int[]{5, 3, 4};
		int c = 1;
		System.out.println(c++);
		System.out.println(c);
		System.out.println(++c);
		System.out.println(c);
		char d = "hello".toCharArray()[0];
		Byte e = 1;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(9/2);// floor
		System.out.println(10%3);
		System.out.println(e.toString());// not null
		System.out.println(String.valueOf(e));// allow null
		System.out.println(8>>2);//8->1000
		System.out.println(8<<2);//8->1000
		System.out.println(8&1);// 1000 & 0001
		System.out.println(8|1);
		System.out.println(8^8);//按位异或同则0
		int[][] f = new int[2][2];//{{1,1},{1,1}};
		f[0][0] = 100;
		System.out.println(f[0][0]);
		int[][] g = {{1,2},{3,4}};
		System.out.println(g[0][1]);
		System.out.println("hello".substring(0, "hello".length()-1));//hell
		Arrays.sort(b);
		System.out.println(b[1]);
		System.out.println(Math.abs(-5));
		
		// dict tree.
		
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.addElement(4);
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.firstElement());
		System.out.println(stack.empty());
		
		Queue<Integer> queue = new LinkedList<>();// assume rpush
		queue.offer(1);//add
		queue.offer(2);//add
		System.out.println(queue.peek());
		queue.poll();
		System.out.println(queue.peek());
		
	}

}
