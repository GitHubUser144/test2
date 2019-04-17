package cn.dazky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.OperationDao;
import cn.dazky.entity.Operation;
import cn.dazky.service.OperationService;
@Service
public class OperationServiceImpl implements OperationService {
	@Resource(name="operationDaoImpl")
	private OperationDao dao;
	@Override
	public List<Operation> getAllOperations() {
		
		return dao.selectAllOperations();
	}
	@Override
	public List<Operation> getOperationsByMenuId(int menuId) {
		return dao.selectOperationsByMenuId(menuId);
	}
	
}
