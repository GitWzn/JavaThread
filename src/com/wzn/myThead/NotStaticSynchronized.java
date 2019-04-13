package com.wzn.myThead;

/**
 * 非静态同步方法的锁对象是this，因为this是不同的对象，所以会形成异步的线程 
 * @author 吴宗宁
 */
public class NotStaticSynchronized extends Thread{
	//非静态同步方法
	public synchronized void show() {
		System.out.println("世界上最帅的男人~" + Thread.currentThread().getName());
	}
	
	@Override    //继承线程类后重写run()方法
	public void run(){   //每一个线程java都会自动的给该线程起一个名字   getName是Thread的方法    Runnable不能使用
		for (int i = 0; i < 10; i++) {
			show();
		}
	}
}	
