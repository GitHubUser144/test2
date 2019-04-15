package com.mapper;

import java.io.IOException;
import java.util.List;

import com.bean.User;
import com.bean.UserQueryVo;

public interface UserMapper {
	/**
	 * 查询所有用户
	 * @return
	 * @throws IOException
	 */
	public List<UserQueryVo> findUser(UserQueryVo userQueryVo) throws IOException;
	/**
	 * 根据id查询单个用户
	 * @param id
	 * @return
	 * @throws IOException
	 */
	
	public User findUserById(int id) throws IOException;
	/**
	 * 添加用户
	 * @param user
	 * @throws IOException
	 */
	public void addUser(User user) throws IOException; 
	
	/**
	 * 更新用户数据
	 * @return
	 * @throws IOException
	 */
	public void updateUser(User user) throws IOException; 
	
	/**
	 * 删除用户数据
	 * @param id
	 * @throws IOException
	 */
	public void deleteUser(int id) throws IOException; 
}

