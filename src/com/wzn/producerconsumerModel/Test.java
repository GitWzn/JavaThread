package com.wzn.producerconsumerModel;

public class Test {
	public static void main(String[] args) {
		//创建一张桌子
		BreadDesk breadDesk = new BreadDesk();
		//生产者
		BreadProducer breadProducer = new BreadProducer(breadDesk);
		//消费者
		BreadConsumer breadConsumer = new BreadConsumer(breadDesk);
		//启动线程
		breadProducer.start();
		breadConsumer.start();
	}
}
