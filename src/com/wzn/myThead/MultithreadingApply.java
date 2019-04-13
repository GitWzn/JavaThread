package com.wzn.myThead;

//要实现多线程的应用，方法一是继承Thread线程类
public class MultithreadingApply extends Thread{
	@Override    //继承线程类后重写run()方法
	public void run(){   //每一个线程java都会自动的给该线程起一个名字   getName是Thread的方法    Runnable不能使用
		System.out.println("世界上最帅的男人~" + getName());
	}
}
