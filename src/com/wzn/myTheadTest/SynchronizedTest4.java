package com.wzn.myTheadTest;

import com.wzn.myThead.StaticSynchronized;

public class SynchronizedTest4 {
	public static void main(String[] args) {
		StaticSynchronized staticSynchronized1 = new StaticSynchronized();
		StaticSynchronized staticSynchronized2 = new StaticSynchronized();
		// 设置线程的名称 
		staticSynchronized1.setName("线程一");
		staticSynchronized2.setName("二线程");
		// 启动线程    静态同步方法的锁对象是相同的类对象  所以形成同步线程
		staticSynchronized1.start();
		staticSynchronized2.start();
	}
}
