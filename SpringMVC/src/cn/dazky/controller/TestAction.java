package cn.dazky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestAction {
	@RequestMapping("/hello_ok")
	public String hello() {
		System.out.println("---hello---");
		return "ok";
	}
	@RequestMapping("/fail")
	public String dsadsadsadsadbuiefbeuib() {
		System.out.println("---fail---");
		return "fail";
	}
	@RequestMapping(value="/testParam",method=RequestMethod.GET)
	public String testParam() {
		System.out.println("---testParam---");
		return "ok";
	}
}	
