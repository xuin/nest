package com.test.nest;

import java.util.Vector;

public class Test3 {
	static volatile int b = 0;

	public static void main(String[] args) {
		Vector<Thread> threads = new Vector<Thread>();
		for (int i = 0; i < 10000; i++) {
			Thread tt = new Thread(i+"") {
				@Override
				public void run() {
					b=Integer.parseInt(getName());
				}
			};
			threads.add(tt);
			tt.start();
		}
		for (Thread iThread : threads) {
			try {
				// 等待所有线程执行完毕
				iThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("主线执行。" + b);
	}

}
