package com.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.Ex_User;
import com.bean.User;
import com.bean.UserQueryVo;
import com.mapper.UserMapper;
public class Demo {

	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper userMapper=(UserMapper) session.getMapper(UserMapper.class);
		
		
		
		
		
		
		
		
		
		
		UserQueryVo userQueryVo=new UserQueryVo();
		Ex_User ex_User=new Ex_User();
		ex_User.setIsadmin("yes");
		ex_User.setName("a");
		userQueryVo.setEx_User(ex_User);
		List<UserQueryVo> list =userMapper.findUser(null);
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i));
		
		session.close();
		
		/*userMapper.deleteUser(8);
		session.commit();
		session.close();*/
		
		
		
		
		
		
		
		
		
			
	}

}
