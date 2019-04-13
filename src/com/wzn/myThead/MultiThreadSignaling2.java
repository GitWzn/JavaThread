package com.wzn.myThead;

//两条线程进行通信    效果类似：1 2 1 2 1 2 1 2.....
public class MultiThreadSignaling2 extends Object {
	// 两条线程进行通信，首先知道当前线程是哪个，当一条线程执行结束了，就叫醒正在等待的另一条线程
	// 做有个标记 来确认当前线程是哪条
	int flag = 1;

	public void show1() throws InterruptedException { // 这是线程1
		// 同步代码块
		synchronized (Thread.class) {
			// 不管是两条线程还是多条线程，都推荐使用while来做循环判断处理。
			while (flag != 1) { // 如果标记不等1，则当前执行的线程是线程2，所以线程一进入休眠
				// 使用哪一个对象锁 就使用哪一个对象锁来调用wait()和notifyAll()方法
				Thread.class.wait(); // 当wait方法没有参数的时候，线程想要醒来，必须得由唤醒的方法才能执行
			}
			// 线程执行到这里的时候说明当前是线程一在执行
			System.out.println("世界上最帅男人~");
			// 执行完线程任务之后叫醒线程2，同时修改标记
			flag = 2;
			Thread.class.notifyAll();
		}
	}

	public void show2() throws InterruptedException {
		synchronized (Thread.class) {
			while (flag != 2) { // 如果标记不等2，则当前执行的线程是线程1，所以线程一进入休眠
				Thread.class.wait(); // 当wait方法没有参数的时候，线程想要醒来，必须得由唤醒的方法才能执行
			}
			// 线程执行到这里的时候说明当前是线程2在执行
			System.out.println("是我~");
			// 执行完线程任务之后叫醒线程1，同时修改标记
			flag = 3;
			Thread.class.notifyAll();
		}
	}

	public void show3() throws InterruptedException {
		synchronized (Thread.class) { // 对象锁可以是任意的 但是其余的锁对象必须一致 否知报错
			while (flag != 3) { // 如果标记不等2，则当前执行的线程是线程1，所以线程一进入休眠
				Thread.class.wait(); // 当wait方法没有参数的时候，线程想要醒来，必须得由唤醒的方法才能执行
			}
			// 线程执行到这里的时候说明当前是线程2在执行
			System.out.println("就是我，咋地~");
			// 执行完线程任务之后叫醒线程1，同时修改标记
			flag = 1;
			Thread.class.notifyAll();
		}
	}
}
