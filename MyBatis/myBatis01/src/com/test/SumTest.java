package com.test;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;
import com.bean.UserQueryVo;
import com.mapper.UserMapper;

public class SumTest {

	public static void main(String[] aStrings) throws IOException{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user=userMapper.findUserById(1);
		System.out.println(user);
		List<UserQueryVo> list=userMapper.findUser(new UserQueryVo());
		System.out.println(list);
	}
} 
