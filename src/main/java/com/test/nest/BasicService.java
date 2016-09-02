package com.test.nest;

import java.util.HashMap;
import java.util.Map;

import com.caucho.hessian.server.HessianServlet;

public class BasicService extends HessianServlet implements TestHessian {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Map<String, String> sayHi(String aa) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aa", aa);
		return map;
	}
}