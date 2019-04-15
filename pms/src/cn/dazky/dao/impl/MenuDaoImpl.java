package cn.dazky.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.MenuDao;
import cn.dazky.entity.Menu;
@Repository("menuDaoImpl")
public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {
	@Resource(name="sessionFactory")
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> selectAllMenus() {
		return (List<Menu>) super.getHibernateTemplate().find("from Menu");
	}

	@Override
	public Menu selectMenuById(int id) {
		return super.getHibernateTemplate().get(Menu.class, id);
	}

	@Override
	public boolean deleteMenuById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Menu.class, id));
		}catch(Exception e) {
			System.err.println("�˵���Ϣɾ��ʧ��");
			return false;
		}
		return true;
	}

	@Override
	public boolean addMenu(Menu menu) {
		try {
			super.getHibernateTemplate().save(menu);
		}catch(Exception e) {
			System.err.println("�˵���Ϣ���ʧ��");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		try {
			super.getHibernateTemplate().update(menu);;
		}catch(Exception e) {
			System.err.println("�˵���Ϣ�޸�ʧ��");
			return false;
		}
		return true;
	}
}
