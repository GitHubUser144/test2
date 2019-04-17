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
	public boolean dropRoleByIds(String ids);
	
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
	public boolean grant(int id,String menus,String operations);
	
	/**
	 * 根据角色id查询一个角色
	 * @param id
	 * @return
	 */
	public Role findRoleById(int id);
	/**
	 * 根据登录的用户返回一个对应的角色对象
	 * @param userId
	 * @return
	 */
	public Role findRoleByUserId(int userId);
	
	/**
	 * 根据按钮生成应该展开的菜单
	 * @param operations
	 * @return
	 */
	public String GenerateMenuIdsByOperations(String operations);
}
