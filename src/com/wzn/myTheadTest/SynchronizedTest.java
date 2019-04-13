package com.wzn.myTheadTest;

import com.wzn.myThead.SynchronizedBlock2;

public class SynchronizedTest {
	public static void main(String[] args) {
		//创建同步代码块的类
//		SynchronizedBlock block = new SynchronizedBlock();
		SynchronizedBlock2 block = new SynchronizedBlock2();
		//创建两条线程	
		Thread thread1 = new Thread("【线程A】"){
			//重写run方法
			public void run() {
				//block.show1();
				synchronized (Object.class) {   //所有的同步代码块锁定的对象必须是通同一个
					for (int i = 0; i < 100; i++) {
						System.out.println("第一个同步代码块：");
					}
				}
			}
		};
		
		Thread thread2 = new Thread("【线程B】"){
			//重写run方法
			public void run() {
				//block.show2();
				synchronized (Object.class) {   //所有的同步代码块锁定的对象必须是通同一个
					for (int i = 0; i < 100; i++) {
						System.out.println("第二个同步代码块：");
					}
				}
			}
		};
		//启动线程
		thread1.start();
		thread2.start();
	}
}
