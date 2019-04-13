package com.wzn.myTheadTest;

import com.wzn.myThead.ObjectLock;

public class SynchronizedTest8 {
	public static void main(String[] args) {
		//创建锁定的对象
		ObjectLock objectLock = new ObjectLock();
		//创建两条线程	
		new Thread("【线程A】"){
			//重写run方法
			public void run() {
				while (true) {
					try {
						objectLock.show1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread("【线程B】"){
			//重写run方法
			public void run() {
				while (true) {
					try {
						objectLock.show2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread("【线程C】"){
			//重写run方法
			public void run() {
				while (true) {
					try {
						objectLock.show3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}
}
