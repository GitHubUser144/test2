package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Ex_User;
import cn.dazky.entity.User;

public interface UserDao {
	/**
	 * ��ѯ�û����е���������
	 * 
	 * @return
	 */
	public List<?> selectAllUsers();

	/**
	 * ����id��ѯ�û�
	 * 
	 * @param �û�id
	 * @return һ���û�����
	 */
	public User selectUserById(int id);

	/**
	 * ����idɾ���û�
	 * 
	 * @param �û�id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteUserById(int id);

	/**
	 * ���һ���û�
	 * 
	 * @param �û�����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addUser(User user);

	/**
	 * ����һ���û�������
	 * 
	 * @param �û�����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateUser(User user);
	
	/**
	 * ��user�����ʾһ��roleName�ֶ�
	 * @return
	 */
	public List<Ex_User> selectEx_Users();
}
