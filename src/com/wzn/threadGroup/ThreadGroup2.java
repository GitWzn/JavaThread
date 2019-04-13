package com.wzn.threadGroup;

public class ThreadGroup2 {
	public static void main(String[] args) {
		//自定义线程组，同时设置线程组的名称
		ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
		//创建两个线程
		Thread thread1 = new Thread(threadGroup, "线程1"){
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + "：" + i);
				}
			}
		};
		Thread thread2 = new Thread(threadGroup, "线程2"){
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + "：" + i);
				}
			}
		};
		System.out.println(thread1.getThreadGroup().getName());
		System.out.println(thread2.getThreadGroup().getName());
		//将自定义线程组里的线程都变成守护线程
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		//主线程组的线程
		for (int i = 0; i < 100; i++) {
			System.out.println("main：" + i);
		}
		thread1.start();
		thread2.start();
	}
}
 