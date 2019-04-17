package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Operation;

public interface OperationService {
	/**
	 * 获取所有的Operation数据
	 * @return
	 */
	public List<Operation> getAllOperations();
	
	/**
	 * 根据menuId获取对应的operation数据
	 * @param menuId
	 * @return
	 */
	public List<Operation> getOperationsByMenuId(int menuId);
}
