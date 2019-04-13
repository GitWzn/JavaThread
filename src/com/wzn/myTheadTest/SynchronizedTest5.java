package com.wzn.myTheadTest;

import com.wzn.myThead.TwoThreadSignaling;

public class SynchronizedTest5 {
	public static void main(String[] args) {
		//创建锁定的对象
		TwoThreadSignaling block = new TwoThreadSignaling();
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
		//启动线程
		thread1.start();
		thread2.start();
	}
}
