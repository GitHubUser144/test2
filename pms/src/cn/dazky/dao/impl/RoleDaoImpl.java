package cn.dazky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.RoleDao;
import cn.dazky.entity.Role;
@Repository("roleDaoImpl")
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> selectAllRoles() {
		return (List<Role>) this.getHibernateTemplate().find("from Role");
	}

	@Override
	public Role selectRoleById(int id) {
		return this.getHibernateTemplate().get(Role.class, id);
	}

	@Override
	public boolean deleteRoleById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Role.class, id));
		}catch(Exception e) {
			System.err.println("角色信息删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean addRole(Role role) {
		try {
			super.getHibernateTemplate().save(role);
		}catch(Exception e) {
			System.err.println("角色信息添加失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRole(Role role) {
		try {
			super.getHibernateTemplate().update(role);;
		}catch(Exception e) {
			System.err.println("角色信息修改失败");
			return false;
		}
		return true;
	}
}
