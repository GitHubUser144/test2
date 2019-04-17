package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Log;

public interface LogService {
	/**
	 * �������log����
	 * @return
	 */
	public List<Log> getAllLogs();
	
	/**
	 * ����idɾ��Log
	 * @param id
	 * @return
	 */
	public boolean dropLogByIds(String ids);
	
	/**
	 * ���
	 * @param Log
	 * @return
	 */
	public boolean addLog(Log log);
	
	/**
	 * ����
	 * @param Log
	 * @return
	 */
	public boolean updateLog(Log log);
}
