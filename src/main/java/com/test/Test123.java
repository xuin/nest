package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Test123 {
	public static void main(String[] args) {
		
		AtomicInteger aabb= new AtomicInteger();
		
		System.out.println("--"+aabb.incrementAndGet());
		
		final Uuu u =new Uuu();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					u.init();
				}
			}).start();
		}
	}
}
class Uuu{
	private volatile Boolean flag;
	public void init(){
		if(flag == null){
			System.out.println(1);
			flag = true;
		}
	}
}
