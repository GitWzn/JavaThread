package com.wzn.producerconsumerModel;

//面包生产者
public class BreadProducer extends Thread {
	// 创建一张桌子对象 使我们在执行程序的过程都是同一张桌子
	private BreadDesk breadDesk;

	public BreadProducer(BreadDesk breadDesk) {
		this.breadDesk = breadDesk;
	}

	@Override // 线程的任务
	public void run() {
		while(true) {   //一直去生产面包，当面包数量到了的时候制作面包的线程会休眠
			breadDesk.bread_In();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
