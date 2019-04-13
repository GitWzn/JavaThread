package com.wzn.myThead;

//实现多线程的应用，方法二是实现Runnable接口类
public class MyRunnable implements Runnable{
	@Override    //重写run()方法
	public void run() {
		System.out.println("如果帅是一种错,我宁愿一错再错~");
	}

}
