package com.wzn.myThead;

public class StaticSynchronized extends Thread{
	//静态同步方法
	public static synchronized void show() {
		System.out.println("世界上最帅的男人~" + Thread.currentThread().getName());
	}
	
	@Override    //继承线程类后重写run()方法
	public void run(){   //每一个线程java都会自动的给该线程起一个名字   getName是Thread的方法    Runnable不能使用
		for (int i = 0; i < 10; i++) {
			show();
		}
	}
}	
