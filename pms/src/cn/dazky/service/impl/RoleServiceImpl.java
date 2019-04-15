package cn.dazky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.RoleDao;
import cn.dazky.entity.Role;
import cn.dazky.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Resource(name="roleDaoImpl")
	private RoleDao dao;
	public List<Role> getAllRoles(){
		return dao.selectAllRoles();
	}
	
	public boolean dropRoleById(int id) {
		return dao.deleteRoleById(id);
	}
	
	public boolean addRole(Role role) {
		return dao.addRole(role);
	}
	
	public boolean updateRole(Role role) {
		return dao.updateRole(role);
	}
	
	public boolean grant(int id,String menus) {
		Role role=dao.selectRoleById(id);
		role.setMenuIds(menus);
		return dao.updateRole(role);
	}
}
