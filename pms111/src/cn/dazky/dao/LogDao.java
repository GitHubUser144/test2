package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Log;

public interface LogDao {
	/**
	 * ��ѯ��־��Ϣ���е���������
	 * @return
	 */
	public List<Log> selectAllLogs();
	
	/**
	 * ����id��ѯ��־��Ϣ
	 * @param ��־��Ϣid
	 * @return һ����־��Ϣ����
	 */
	public Log selectLogById(int id);
	
	/**
	 * ����idɾ����־��Ϣ
	 * @param ��־��Ϣid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteLogById(int id);
	
	/**
	 * ���һ����־��Ϣ
	 * @param ��־��Ϣ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addLog(Log log);
	
	/**
	 * ����һ����־��Ϣ������
	 * @param ��־��Ϣ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateLog(Log log);
}
