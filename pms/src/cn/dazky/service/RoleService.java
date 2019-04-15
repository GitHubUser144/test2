package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Role;

public interface RoleService {
	/**
	 * 获得所有role对象
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * 根据id删除role
	 * @param id
	 * @return
	 */
	public boolean dropRoleById(int id);
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role);
	
	/**
	 * 角色授权
	 * @param id
	 * @param menus
	 * @return
	 */
	public boolean grant(int id,String menus);
}
