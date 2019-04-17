package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Operation;

public interface OperationService {
	/**
	 * ��ȡ���е�Operation����
	 * @return
	 */
	public List<Operation> getAllOperations();
	
	/**
	 * ����menuId��ȡ��Ӧ��operation����
	 * @param menuId
	 * @return
	 */
	public List<Operation> getOperationsByMenuId(int menuId);
}
