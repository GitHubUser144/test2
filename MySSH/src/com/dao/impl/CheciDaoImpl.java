package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bean.Checi;
import com.dao.CheciDao;
import com.util.HibernateUtil;

public class CheciDaoImpl extends HibernateDaoSupport  implements CheciDao{

	public List<Checi> selectAllCheci() {
		return (List<Checi>) this.getHibernateTemplate().find("from Checi");
	}
	
}
