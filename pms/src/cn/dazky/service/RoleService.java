package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Role;

public interface RoleService {
	/**
	 * �������role����
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * ����idɾ��role
	 * @param id
	 * @return
	 */
	public boolean dropRoleById(int id);
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * ���½�ɫ
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role);
	
	/**
	 * ��ɫ��Ȩ
	 * @param id
	 * @param menus
	 * @return
	 */
	public boolean grant(int id,String menus);
}
