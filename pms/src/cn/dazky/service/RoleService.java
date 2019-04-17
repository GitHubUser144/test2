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
	public boolean dropRoleByIds(String ids);
	
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
	public boolean grant(int id,String menus,String operations);
	
	/**
	 * ���ݽ�ɫid��ѯһ����ɫ
	 * @param id
	 * @return
	 */
	public Role findRoleById(int id);
	/**
	 * ���ݵ�¼���û�����һ����Ӧ�Ľ�ɫ����
	 * @param userId
	 * @return
	 */
	public Role findRoleByUserId(int userId);
	
	/**
	 * ���ݰ�ť����Ӧ��չ���Ĳ˵�
	 * @param operations
	 * @return
	 */
	public String GenerateMenuIdsByOperations(String operations);
}
