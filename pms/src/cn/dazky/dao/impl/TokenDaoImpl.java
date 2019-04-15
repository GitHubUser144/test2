package cn.dazky.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.dazky.dao.TokenDao;
import cn.dazky.entity.Token;
@Repository("tokenDaoImpl")
public class TokenDaoImpl extends HibernateDaoSupport implements TokenDao {
	@Resource(name="sessionFactory")
	private void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Token> selectAllTokens() {
		return (List<Token>) super.getHibernateTemplate().find("from Token");
	}

	@Override
	public Token selectTokenById(int id) {
		return super.getHibernateTemplate().get(Token.class, id);
	}

	@Override
	public boolean deleteTokenById(int id) {
		try {
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Token.class, id));
		}catch(Exception e) {
			System.err.println("标记信息删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean addToken(Token token) {
		try {
			super.getHibernateTemplate().save(token);
		}catch(Exception e) {
			System.err.println("标记信息添加失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateToken(Token token) {
		try {
			super.getHibernateTemplate().update(token);;
		}catch(Exception e) {
			System.err.println("标记信息修改失败");
			return false;
		}
		return true;
	}
}
