package com.wzn.producerconsumerModel;

//面包消费者
public class BreadConsumer extends Thread{
	// 创建桌子变量
	public BreadDesk breadDesk;

	public BreadConsumer(BreadDesk breadDesk) {
		this.breadDesk = breadDesk;
	}

	@Override // 线程的任务
	public void run() {
		while (true) { // 一直去买面包，当面包数量没了的时候买面包的线程会休眠
			breadDesk.Bread_out();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
