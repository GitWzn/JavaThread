package com.wzn.myTheadTest;

import com.wzn.myThead.MultiThreadSignaling2;

public class SynchronizedTest7 {
	public static void main(String[] args) {
		//创建锁定的对象
		MultiThreadSignaling2 block = new MultiThreadSignaling2();
		//创建两条线程	
		new Thread("【线程A】"){
			//重写run方法
			public void run() {
				while (true) {
					try {
						block.show1();
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
						block.show2();
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
						block.show3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}
}
