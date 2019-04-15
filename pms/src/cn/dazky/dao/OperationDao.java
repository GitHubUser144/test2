package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Operation;

public interface OperationDao {
	/**
	 * ��ѯ�˵�����Ϣ���е���������
	 * @return
	 */
	public List<Operation> selectAllOperations();
	
	/**
	 * ����id��ѯ�˵�����Ϣ
	 * @param �˵�����Ϣid
	 * @return һ���˵�����Ϣ����
	 */
	public Operation selectOperationById(int id);
	
	/**
	 * ����idɾ���˵�����Ϣ
	 * @param �˵�����Ϣid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteOperationById(int id);
	
	/**
	 * ���һ���˵�����Ϣ
	 * @param �˵�����Ϣ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addOperation(Operation operation);
	
	/**
	 * ����һ���˵�����Ϣ������
	 * @param �˵�����Ϣ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateOperation(Operation operation);
}
