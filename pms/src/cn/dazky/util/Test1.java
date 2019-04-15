package cn.dazky.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

import cn.dazky.entity.User;

public class Test1 {
	@Test
	public void addUser(){
	 try {
		System.out.println(InetAddress.getLocalHost().toString());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
			
			
	}	
}
