package com.wzn.myTheadTest;

import com.wzn.myThead.NotStaticSynchronized;

public class SynchronizedTest2 {
	public static void main(String[] args) {
		NotStaticSynchronized notStaticSynchronized1 = new NotStaticSynchronized();
		//创建两条线程	
		Thread thread1 = new Thread("【线程A】"){
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					notStaticSynchronized1.show();
				}
			}
		};
		
		Thread thread2 = new Thread("【线程B】"){
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					notStaticSynchronized1.show();
				}
			}
		};
		//启动线程
		thread1.start();
		thread2.start();
	}
}
