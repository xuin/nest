package com.test.redis;

public class ThreadTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());		
			}
		}).start();
		System.out.println(Thread.currentThread().getName());
	}
}
