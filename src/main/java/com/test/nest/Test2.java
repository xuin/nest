package com.test.nest;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

public class Test2 {
	public static void main(String[] args) throws MalformedURLException {
		 String url = "http://localhost:8088/test";
		 HessianProxyFactory factory = new HessianProxyFactory();
		 factory.setReadTimeout(1000);
		 TestHessian basic = (TestHessian) factory.create(TestHessian.class,
		 url);
		 System.out.println(basic.sayHi("dd"));
		 System.out.println(new Test2());
	}
}
