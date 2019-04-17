package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Log;

public interface LogService {
	/**
	 * 获得所有log对象
	 * @return
	 */
	public List<Log> getAllLogs();
	
	/**
	 * 根据id删除Log
	 * @param id
	 * @return
	 */
	public boolean dropLogById(int id);
	
	/**
	 * 添加
	 * @param Log
	 * @return
	 */
	public boolean addLog(Log log);
	
	/**
	 * 更新
	 * @param Log
	 * @return
	 */
	public boolean updateLog(Log log);
}
