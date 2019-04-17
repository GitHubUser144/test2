package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Role;

public interface RoleDao {
	/**
	 * 查询角色信息表中的所有数据
	 * @return
	 */
	public List<Role> selectAllRoles();
	
	/**
	 * 根据id查询角色信息
	 * @param 角色信息id
	 * @return 一个角色信息对象
	 */
	public Role selectRoleById(int id);
	
	/**
	 * 根据id删除角色信息
	 * @param 角色信息id
	 * @return 是否删除成功
	 */
	public boolean deleteRoleById(int id);
	
	/**
	 * 添加一个角色信息
	 * @param 角色信息对象
	 * @return 是否添加成功
	 */
	public boolean addRole(Role role);
	
	/**
	 * 更新一个角色信息的数据
	 * @param 角色信息对象
	 * @return 是否修改成功
	 */
	public boolean updateRole(Role role);
}
