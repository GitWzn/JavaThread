package com.wzn.myThead;

//两条线程进行通信    效果类似：1 2 1 2 1 2 1 2.....
//wait()和notify和notifyAll都是Object类的方法
public class TwoThreadSignaling {
	//两条线程进行通信，首先知道当前线程是哪个，当一条线程执行结束了，就叫醒正在等待的另一条线程
	//做有个标记  来确认当前线程是哪条
	int flag = 1;
	public void show1() {  //这是线程1
		//同步代码块
		synchronized (this) {
			if(flag != 1) { //如果标记不等1，则当前执行的线程是线程2，所以线程一进入休眠
				try {  
					this.wait();  //等待其他线程交出CUP执行权，可能抢到CPU的执行权，当wait方法没有参数的时候，线程想要醒来，必须得由唤醒的方法才能执行
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//线程执行到这里的时候说明当前是线程一在执行
			System.out.println("世界上最帅男人~");
			//执行完线程任务之后叫醒线程2，同时修改标记
			flag = 2;
			this.notify();  //交出CPU的执行权
		}
	}
	
	public void show2() {
		synchronized (this) {
			if(flag != 2) { //如果标记不等2，则当前执行的线程是线程1，所以线程一进入休眠
				try {
					this.wait();  //当wait方法没有参数的时候，线程想要醒来，必须得由唤醒的方法才能执行
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//线程执行到这里的时候说明当前是线程2在执行
			System.out.println("是我~");
			//执行完线程任务之后叫醒线程1，同时修改标记
			flag = 1;
			this.notify();
		}
	}
}
