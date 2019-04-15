package cn.dazky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.UserDao;
import cn.dazky.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

	@Override
	public User selectUserById(int id) {
		return super.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public boolean deleteUserById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(User.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("用户删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean addUser(User user) {
		try {
			super.getHibernateTemplate().execute(new HibernateCallback<User>() {

				@Override
				public User doInHibernate(Session session) throws HibernateException {
					session.save(user);
					return null;
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("用户添加失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			super.getHibernateTemplate().update(user);
			;
		} catch (Exception e) {
			System.err.println("用户信息修改失败");
			return false;
		}
		return true;
	}
}
