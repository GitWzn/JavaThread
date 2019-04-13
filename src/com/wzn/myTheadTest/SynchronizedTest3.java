package com.wzn.myTheadTest;

import com.wzn.myThead.NotStaticSynchronized;

public class SynchronizedTest3 {
	public static void main(String[] args) {
		NotStaticSynchronized notStaticSynchronized1 = new NotStaticSynchronized();
		NotStaticSynchronized notStaticSynchronized2 = new NotStaticSynchronized();
		//启动线程    非静态同步方法的锁对象是this  不会同步线程
		notStaticSynchronized1.start();
		notStaticSynchronized2.start();
	}
}
