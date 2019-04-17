package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Ex_User;
import cn.dazky.entity.User;

public interface UserDao {
	/**
	 * 查询用户表中的所有数据
	 * 
	 * @return
	 */
	public List<?> selectAllUsers();

	/**
	 * 根据id查询用户
	 * 
	 * @param 用户id
	 * @return 一个用户对象
	 */
	public User selectUserById(int id);

	/**
	 * 根据id删除用户
	 * 
	 * @param 用户id
	 * @return 是否删除成功
	 */
	public boolean deleteUserById(int id);

	/**
	 * 添加一个用户
	 * 
	 * @param 用户对象
	 * @return 是否添加成功
	 */
	public boolean addUser(User user);

	/**
	 * 更新一个用户的数据
	 * 
	 * @param 用户对象
	 * @return 是否修改成功
	 */
	public boolean updateUser(User user);
	
	/**
	 * 比user表多显示一个roleName字段
	 * @return
	 */
	public List<Ex_User> selectEx_Users();
}
