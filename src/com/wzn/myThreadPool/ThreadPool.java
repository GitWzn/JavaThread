package com.wzn.myThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		//创建线程池，定义只能一次性运行四个线程任务
		//Executors是生产线程池的工厂
		//executorService 是线程池操作的服务类
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		//提交15个线程任务
		for (int i = 0; i < 15; i++) {
			executorService.execute(new MyThread("线程" + i));
		}
		//关闭线程池
		executorService.shutdown();
	}
}
