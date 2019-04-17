package cn.dazky.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.MenuDao;
import cn.dazky.dao.RoleDao;
import cn.dazky.dao.UserDao;
import cn.dazky.entity.Ex_User;
import cn.dazky.entity.Menu;
import cn.dazky.entity.Role;
import cn.dazky.entity.User;
import cn.dazky.service.UserService;
import cn.dazky.util.GenerateJsonData;
import cn.dazky.util.StringUtil;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDaoImpl")
	private UserDao dao;
	@Resource(name = "menuDaoImpl")
	private MenuDao menuDao;
	@Resource(name = "roleDaoImpl")
	private RoleDao roleDao;

	public User userLogin(String username, String pwd) {
		List<User> list = (List<User>) dao.selectAllUsers();
		User user = new User();
		user.setUserName(username);
		user.setPassword(pwd);
		// ����json����
		for (User u : list) {
			if (u.getUserName().equals(username) && u.getPassword().equals(pwd))
				return u;
		}
		return null;
	}

	public boolean register(User user) {
		return dao.addUser(user);
	}

	/**
	 * �����û�����ȡ���û�չ���Ĳ˵��� ���ز˵����Ӧ��id����
	 */
	public List<Menu> selectMenusByUid(int id) {
		System.out.println("��¼�ɹ���userIdΪ+"+id);
		User user = dao.selectUserById(id);// ��ȡ���û�����
		System.out.println(user);
		int roleId = user.getRoleId();// ���ݸ��û��жϸ��û���Ȩ�޼���
		Role role = roleDao.selectRoleById(roleId);// ���ݸ��û���Ȩ�޼����ȡ�����ɫ���
		System.out.println(role);
		String menuIds = role.getMenuIds();// ��������û�����ݻ�ȡ��Ӧ�����в˵�id
		System.out.println("���û��Ĳ˵���Ϊ" + menuIds);
		List<Integer> ids = StringUtil.splitByDot(menuIds);// ��ȡ���в˵�id
		List<Menu> menus = new ArrayList<Menu>();
		for (int i : ids) {
			menus.add(menuDao.selectMenuById(i));
		}
//		System.out.println(menus);
		return menus;
	}

	@Override
	public boolean checkExistMenu(List<Integer> menuIds, int menuId) {
		for (int i : menuIds) {
			if (menuId == i)
				return true;
		}
		return false;
	}

	public List<Role> getAllRoles() {
		return roleDao.selectAllRoles();
	}

	@Override
	public boolean dropUserByIds(String ids) {
		String[] str = ids.split(",");
		for (String sss : str) {
			if (!dao.deleteUserById(Integer.parseInt(sss)))
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) dao.selectAllUsers();
	}

	@Override
	public boolean updateUser(User user) {

		return dao.updateUser(user);
	}

	@Override
	public boolean modifyBaseInfo(User user) {
		User uuser = dao.selectUserById(user.getUserId());
		uuser.setPassword(user.getPassword());
		uuser.setUserName(user.getUserName());
		return dao.updateUser(uuser);
	}

	@Override
	public User getUserById(int id) {
		return dao.selectUserById(id);
	}

	@Override
	public List<Ex_User> CastData(List<User> users) {
		List<Ex_User> exusers = new ArrayList<Ex_User>();
		for (User user : users) {
			exusers.add(new Ex_User(roleDao.selectRoleById(user.getRoleId())
					.getRoleName(), user));
		}
		return exusers;
	}

}
