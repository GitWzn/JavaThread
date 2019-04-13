package com.wzn.myThead;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectLock {
	private int flag = 1;
	// 创建提个重入锁/互斥锁对象
	private ReentrantLock rl = new ReentrantLock();
	//多条线程间的通讯如果使用到重入锁，必须使用配套工具，让线程等待或唤醒
	//private Condition condition = rl.newCondition();
	private Condition condition1 = rl.newCondition();
	private Condition condition2 = rl.newCondition();
	private Condition condition3 = rl.newCondition();

	public void show1() throws InterruptedException {
		rl.lock(); //上锁  当使用的锁对象是同一个时  会形成线程同步
		while (flag != 1) { // 如果标记不等1，则当前执行的线程是线程2，所以线程一进入休眠
			//condition.await();
			condition1.await();
		}
		// 线程执行到这里的时候说明当前是线程一在执行
		System.out.println("世界上最帅男人~1");
		// 执行完线程任务之后叫醒线程2，同时修改标记
		flag = 2;
		condition2.signal();    //可以指定唤醒等待的线程
		//condition.signalAll();  //唤醒所有等待的线程
		//释放锁  放弃CPU的执行权    当没有上面的唤醒功能时不释放锁将不会执行接下来的操作  
		//当使用的是用一个对象锁时，想要同一个锁的线程执行，要么唤醒等待的线程，要么释放锁
		rl.unlock();   
	}

	public void show2() throws InterruptedException {
		rl.lock();
		while (flag != 2) { // 如果标记不等1，则当前执行的线程是线程2，所以线程一进入休眠
			//condition.await();
			condition2.await();
		}
		// 线程执行到这里的时候说明当前是线程一在执行
		System.out.println("世界上最帅男人~2");
		// 执行完线程任务之后叫醒线程2，同时修改标记
		flag = 3;
		condition3.signal();
		//condition.signalAll();
		rl.unlock();
	}

	public void show3() throws InterruptedException {
		rl.lock();
		while (flag != 3) { // 如果标记不等1，则当前执行的线程是线程2，所以线程一进入休眠
			//condition.await();
			condition3.await();
		}
		// 线程执行到这里的时候说明当前是线程一在执行
		System.out.println("世界上最帅男人~3");
		// 执行完线程任务之后叫醒线程2，同时修改标记
		flag = 1;
		condition1.signal();   
		//condition.signalAll();
		rl.unlock();
	}
}
