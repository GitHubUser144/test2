package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Menu;
import cn.dazky.entity.Role;
import cn.dazky.entity.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param 用户名
	 * @param 密码
	 * @return 登录的用户对象
	 */
	public User userLogin(String username,String pwd);
	
	/**
	 * 用户注册
	 * @param user
	 * @return 是否注册成功
	 */
	public boolean register(User user);
	
	/**
	 * 获取一个用户的菜单项
	 * @param id
	 * @return
	 */
	public List<Menu> selectMenusByUid(int id);
	
	/**
	 * 验证menuIds里面是否存在id
	 * @param menuIds
	 * @param id
	 * @return
	 */
	public boolean checkExistMenu(List<Integer> menuids,int menuId);
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public boolean dropUserById(int id);
	
	/**
	 * 获取所有user
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 更新用户数据
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

}
