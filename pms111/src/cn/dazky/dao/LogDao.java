package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Log;

public interface LogDao {
	/**
	 * 查询日志信息表中的所有数据
	 * @return
	 */
	public List<Log> selectAllLogs();
	
	/**
	 * 根据id查询日志信息
	 * @param 日志信息id
	 * @return 一个日志信息对象
	 */
	public Log selectLogById(int id);
	
	/**
	 * 根据id删除日志信息
	 * @param 日志信息id
	 * @return 是否删除成功
	 */
	public boolean deleteLogById(int id);
	
	/**
	 * 添加一个日志信息
	 * @param 日志信息对象
	 * @return 是否添加成功
	 */
	public boolean addLog(Log log);
	
	/**
	 * 更新一个日志信息的数据
	 * @param 日志信息对象
	 * @return 是否修改成功
	 */
	public boolean updateLog(Log log);
}
