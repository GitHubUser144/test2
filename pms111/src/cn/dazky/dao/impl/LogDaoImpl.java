package cn.dazky.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.LogDao;
import cn.dazky.entity.Log;
@Repository("logDaoImpl")
public class LogDaoImpl extends HibernateDaoSupport implements LogDao {
	@Resource(name="sessionFactory")
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Log> selectAllLogs() {
		return (List<Log>) super.getHibernateTemplate().find("from Log");
	}

	@Override
	public Log selectLogById(int id) {
		return super.getHibernateTemplate().get(Log.class, id);
	}

	@Override
	public boolean deleteLogById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Log.class, id));
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("日志信息删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean addLog(Log log) {
		try {
			super.getHibernateTemplate().save(log);
		}catch(Exception e) {
			System.err.println("日志信息添加失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateLog(Log log) {
		try {
			super.getHibernateTemplate().update(log);;
		}catch(Exception e) {
			System.err.println("日志信息信息修改失败");
			return false;
		}
		return true;
	}
}
