package cn.dazky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}	
