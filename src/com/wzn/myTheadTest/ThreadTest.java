package com.wzn.myTheadTest;

import com.wzn.myThead.MultithreadingApply;

/**
 * 在程序启动后至少启动了垃圾回收线程和主线程这两个线程
 * @author 吴宗宁
 */
public class ThreadTest {
	public static void main(String[] args) {
		//创建继承线程类的对象
		MultithreadingApply myThread = new MultithreadingApply();
		//启动线程
		myThread.start();
		System.out.println("hhhhh");
		System.out.println("wwwww");
	}
}
