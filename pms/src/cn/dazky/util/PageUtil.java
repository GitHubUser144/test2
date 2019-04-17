package cn.dazky.util;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
@Component("pageUtil")
public class PageUtil extends HibernateDaoSupport {
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public List<?> Pagination(Class<?> clazz, Integer limit, Integer page) {
		int offset = (page - 1) * limit;
		String hql="from "+clazz.getSimpleName();
		Query query=this.getSessionFactory().openSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.list();
	}
	
}
