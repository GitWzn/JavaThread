package com.wzn.myThreadPool;

public class MyThread extends Thread{
	public MyThread(String string) {

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "当前的i=" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
