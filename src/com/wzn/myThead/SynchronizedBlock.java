package com.wzn.myThead;

/**
 * 使用同步代码块
 *       设置一个对象来看守我们的全部功能代码，当一个功能代码执行完毕了就告诉系统可以执行下一个功能代码了
 *	 	   就是使用一个对象来锁住我们要执行的代码，在一个功能代码没有结束的时候不让出CUP的执行权
 *		   只要锁住的是同一个对象，就能使我们设置的同步效果顺利完成
 *	  格式：
 *		synchronized(锁住同一个的对象){
 *			同步的功能代码
 *		}
 */
public class SynchronizedBlock {
	//第一个同步代码块
	public void show1() {
		//同步代码块的格式
		synchronized (this) {   //所有的同步代码块锁定的对象必须是通同一个
			System.out.println("第一个同步代码块：");
		}
	}
	//第二个同步代码块
	public void show2() {
		//同步代码块
		synchronized (this) {
			System.out.println("第二个同步代码块：");
		}
	}
}
