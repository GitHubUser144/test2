package cn.dazky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.RoleDao;
import cn.dazky.dao.UserDao;
import cn.dazky.entity.Role;
import cn.dazky.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource(name = "roleDaoImpl")
	private RoleDao dao;
	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	public List<Role> getAllRoles() {
		return dao.selectAllRoles();
	}

	public boolean dropRoleByIds(String ids) {
		String[] str = ids.split(",");
		for (String sss : str) {
			if (!dao.deleteRoleById(Integer.parseInt(sss)))
				return false;
		}
		return true;
	}

	public boolean addRole(Role role) {
		return dao.addRole(role);
	}

	public boolean updateRole(Role role) {
		return dao.updateRole(role);
	}

	public boolean grant(int id, String menus, String operations) {
		Role role = dao.selectRoleById(id);
		role.setMenuIds(menus);
		role.setOperationIds(operations);
		return dao.updateRole(role);
	}

	@Override
	public Role findRoleById(int id) {
		return dao.selectRoleById(id);
	}

	@Override
	public Role findRoleByUserId(int userId) {
		return dao.selectRoleById(userDao.selectUserById(userId).getRoleId());
	}

	@Override
	public String GenerateMenuIdsByOperations(String operations) {
		String menus = "1,2,4,27,8,17";
		if (operations.contains("10000") || operations.contains("10001") || operations.contains("10002")
				|| operations.contains("10014"))
			menus += ",5";
		if (operations.contains("10003") || operations.contains("10004") || operations.contains("10005"))
			menus += ",6";
		if(operations.contains("10006")||operations.contains("10007")||operations.contains("10008")||operations.contains("10009"))
			menus+=",7";
		if(operations.contains("10011")||operations.contains("10012")||operations.contains("10013")||operations.contains("10015"))
			menus+=",26";
		return menus;
	}
}
