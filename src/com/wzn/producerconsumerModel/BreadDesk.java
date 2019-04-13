package com.wzn.producerconsumerModel;

//这是面包桌子类
public class BreadDesk {
	//标记面包的数量
	int number = 0;
	//添加面包的方法
	public void bread_In() {
		//同步代码块
		synchronized (BreadDesk.class) {
			while(number == 5) {  //当面包的数量大于等于5的时候，不用再做面包
				try { //此线程休眠
					BreadDesk.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//当桌面的面包少于5个，则做面包
			number++;
			System.out.println("做了一个面包，此时桌子上有【" + number + "】个面包！");
			//叫醒所有休眠的客户线程，来抢cpu的使用权
			BreadDesk.class.notifyAll();
		}
	}
	//客户买出面包
	public void Bread_out() {
		synchronized (BreadDesk.class) {
			while(number <= 2) {   //当面包没了的时候，客户都停止买面包
				try {
					BreadDesk.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//客户买面包的时候面包一致没在减
			number--;
			System.out.println("客户在买面包，此时面包还剩【" + number + "】个！！");
			//此时唤醒厨师们的线程
			BreadDesk.class.notifyAll();
		}
	}
}
