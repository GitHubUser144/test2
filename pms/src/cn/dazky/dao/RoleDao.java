package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Role;

public interface RoleDao {
	/**
	 * ��ѯ��ɫ��Ϣ���е���������
	 * @return
	 */
	public List<Role> selectAllRoles();
	
	/**
	 * ����id��ѯ��ɫ��Ϣ
	 * @param ��ɫ��Ϣid
	 * @return һ����ɫ��Ϣ����
	 */
	public Role selectRoleById(int id);
	
	/**
	 * ����idɾ����ɫ��Ϣ
	 * @param ��ɫ��Ϣid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteRoleById(int id);
	
	/**
	 * ���һ����ɫ��Ϣ
	 * @param ��ɫ��Ϣ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addRole(Role role);
	
	/**
	 * ����һ����ɫ��Ϣ������
	 * @param ��ɫ��Ϣ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateRole(Role role);
}
