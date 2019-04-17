package cn.dazky.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.OperationDao;
import cn.dazky.entity.Operation;
@Repository("operationDaoImpl")
public class OperationDaoImpl extends HibernateDaoSupport implements OperationDao {
	@Resource(name="sessionFactory")
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> selectAllOperations() {
		return (List<Operation>) super.getHibernateTemplate().find("from Operation");
	}

	@Override
	public Operation selectOperationById(int id) {
		return super.getHibernateTemplate().get(Operation.class, id);
	}

	@Override
	public boolean deleteOperationById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Operation.class, id));
		}catch(Exception e) {
			System.err.println("菜单项信息删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean addOperation(Operation operation) {
		try {
			super.getHibernateTemplate().save(operation);
		}catch(Exception e) {
			System.err.println("菜单项信息添加失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOperation(Operation operation) {
		try {
			super.getHibernateTemplate().update(operation);;
		}catch(Exception e) {
			System.err.println("菜单项信息修改失败");
			return false;
		}
		return true;
	}
	@Override
	public List<Operation> selectOperationsByMenuId(int menuId) {
		return (List<Operation>) super.getHibernateTemplate().find("from Operation where menuId="+menuId);
	}
}
