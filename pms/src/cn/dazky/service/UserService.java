package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Ex_User;
import cn.dazky.entity.Menu;
import cn.dazky.entity.Role;
import cn.dazky.entity.User;

public interface UserService {
	/**
	 * �û���¼
	 * @param �û���
	 * @param ����
	 * @return ��¼���û�����
	 */
	public User userLogin(String username,String pwd);
	
	/**
	 * �û�ע��
	 * @param user
	 * @return �Ƿ�ע��ɹ�
	 */
	public boolean register(User user);
	
	/**
	 * ��ȡһ���û��Ĳ˵���
	 * @param id
	 * @return
	 */
	public List<Menu> selectMenusByUid(int id);
	
	/**
	 * ��֤menuIds�����Ƿ����id
	 * @param menuIds
	 * @param id
	 * @return
	 */
	public boolean checkExistMenu(List<Integer> menuids,int menuId);
	
	/**
	 * ��ȡ���н�ɫ
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public boolean dropUserByIds(String ids);
	
	/**
	 * ��ȡ����user
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * �����û�����
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * �޸��û��Ļ�����Ϣ
	 * @param user
	 * @return
	 */
	public boolean modifyBaseInfo(User user);
	
	/**
	 * ����id��ȡһ��user����
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
	/**
	 * ǰ̨��ʾ���ݵ�ת��
	 * @param users
	 * @return
	 */
	public List<Ex_User> CastData(List<User> users);


}
