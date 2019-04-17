package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Token;

public interface TokenDao {
	/**
	 * ��ѯ�����Ϣ���е���������
	 * @return
	 */
	public List<Token> selectAllTokens();
	
	/**
	 * ����id��ѯ�����Ϣ
	 * @param �����Ϣid
	 * @return һ�������Ϣ����
	 */
	public Token selectTokenById(int id);
	
	/**
	 * ����idɾ�������Ϣ
	 * @param �����Ϣid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteTokenById(int id);
	
	/**
	 * ���һ�������Ϣ
	 * @param �����Ϣ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addToken(Token token);
	
	/**
	 * ����һ�������Ϣ������
	 * @param �����Ϣ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateToken(Token token);
}
