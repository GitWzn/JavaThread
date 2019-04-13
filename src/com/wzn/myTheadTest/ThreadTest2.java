package com.wzn.myTheadTest;

import com.wzn.myThead.MyRunnable;

public class ThreadTest2 {
	public static void main(String[] args) {
		/*
		 * 创建实现线程接口类的对象 MyRunnable myRunnable = new MyRunnable(); //启动线程
		 * 如果是实现Runnable接口的线程类，必须通过Thread对象来启动 new Thread(myRunnable).start();
		 * System.out.println("hhhhh"); System.out.println("wwwww");
		 */
		
		// 守护线程，它是给我们的普通线程提供辅助作用的线程。
		// 在获取线程的名称是，系统给我们的名称我们可能很难去辨认出是哪个，我们可以通过自己去给线程去名称
		// 方法一： 可以通过Thread的setName方法
		// 方法二： 可以给Thread的构造方法中传参数
		Thread threadA = new Thread("【这是守护线程】") { // 给构造方法传参数则可以设置线程的名称
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("Thread: " + getName());
					// 当线程在执行某个功能的时候，我们希望等待指定时间，时间到了之后再继续执行
					try { // 相当于休眠 、延时
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		//加入线程的线程测试
		Thread joinThread = new Thread("加入线程") {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread: " + getName());
					// 当线程在执行某个功能的时候，我们希望等待指定时间，时间到了之后再继续执行
					try { // 相当于休眠 、延时
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		};
		// 普通的线程，就是我们创建出现，实现一些功能地线程类
		// 使用匿名内部类去实现多线程 使得代码简洁 凡是类中需要重写方法时，都可以使用匿名内部类去实现，先大括号中重写函数
		MyRunnable myRunnable = new MyRunnable() {
			public void run() { // 在Runnable中不能直接使用Thread的getName方法
								// 应该先获取Thread当前的线程的对象 currentThread() 是Thread的方法
				for (int i = 0; i < 10; i++) {
					if(i == 5) {
						joinThread.start();
						try {
							//使用join()方法使joinThread线程编程加入线程，就是将当joinThread所在线程的CPU的权限给了加入线程，
							//此时当前线程没有CPU权限，当加入线程执行完后把CPU权限给回当前线程                                
							joinThread.join();   
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Runnable: " + Thread.currentThread().getName());
					// 当线程在执行某个功能的时候，我们希望等待指定时间，时间到了之后再继续执行
					try { // 相当于休眠 、延时
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread threadB = new Thread(myRunnable, "【这是线程B】");
		// 方法二通过Thread的setName方法去给线程起名
		// threadB.setName("【这是线程B】");
		// 将线程A设置为守护线程
		// 守护线程：在程序中，当我们所有的普通线程都运行结束之后，守护线程会自动结束     比如JVM的垃圾回收机制，这就是一个守护线程
		threadA.setDaemon(true);
		// 驱动线程
		threadA.start();
		threadB.start();
		System.out.println("ffffff");
		System.out.println("wwwww");
	}
}
