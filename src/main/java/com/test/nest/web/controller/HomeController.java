package com.test.nest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nest.TestHessian;

@Controller
public class HomeController {
	@Autowired
	private TestHessian testHessian;
	
	@ResponseBody
	@RequestMapping("/")
	public String index(){
		return "test";
	}
}
