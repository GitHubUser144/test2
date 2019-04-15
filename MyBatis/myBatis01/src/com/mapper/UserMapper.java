package com.mapper;

import java.io.IOException;
import java.util.List;

import com.bean.User;
import com.bean.UserQueryVo;

public interface UserMapper {
	/**
	 * ��ѯ�����û�
	 * @return
	 * @throws IOException
	 */
	public List<UserQueryVo> findUser(UserQueryVo userQueryVo) throws IOException;
	/**
	 * ����id��ѯ�����û�
	 * @param id
	 * @return
	 * @throws IOException
	 */
	
	public User findUserById(int id) throws IOException;
	/**
	 * ����û�
	 * @param user
	 * @throws IOException
	 */
	public void addUser(User user) throws IOException; 
	
	/**
	 * �����û�����
	 * @return
	 * @throws IOException
	 */
	public void updateUser(User user) throws IOException; 
	
	/**
	 * ɾ���û�����
	 * @param id
	 * @throws IOException
	 */
	public void deleteUser(int id) throws IOException; 
}

