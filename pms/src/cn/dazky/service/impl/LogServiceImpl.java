package cn.dazky.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.LogDao;
import cn.dazky.entity.Log;
import cn.dazky.service.LogService;
@Service
public class LogServiceImpl implements LogService {
	@Resource(name="logDaoImpl")
	private LogDao dao;
	@Override
	public List<Log> getAllLogs() {
		
		return dao.selectAllLogs();
	}

	@Override
	public boolean dropLogByIds(String ids) {
		String[] str=ids.split(",");
		for(String sss:str) {
			if(!dao.deleteLogById(Integer.parseInt(sss)))
					return false;
		}
		return true;
	}

	@Override
	public boolean addLog(Log log) {
		
		return dao.addLog(log);
	}

	@Override
	public boolean updateLog(Log log) {
		
		return dao.updateLog(log);
	}

}
