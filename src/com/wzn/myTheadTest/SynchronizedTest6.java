package com.wzn.myTheadTest;

import com.wzn.myThead.MultiThreadSignaling;

public class SynchronizedTest6 {
	public static void main(String[] args) {
		//创建锁定的对象
		MultiThreadSignaling block = new MultiThreadSignaling();
		//创建两条线程	
		Thread thread1 = new Thread("【线程A】"){
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					block.show1();
				}
			}
		};
		
		Thread thread2 = new Thread("【线程B】"){
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					block.show2();
				}
			}
		};
		
		Thread thread3 = new Thread("【线程C】"){
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					block.show3();
				}
			}
		};
		//启动线程
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
