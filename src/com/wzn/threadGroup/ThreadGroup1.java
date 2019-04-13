package com.wzn.threadGroup;

public class ThreadGroup1 {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		//获取当前线程组的名称    默认情况下线程组的是主线程组main
		String name1 = t1.getThreadGroup().getName();
		String name2 = t2.getThreadGroup().getName();
		System.out.println(name1);
		System.out.println(name2);
	}
}
