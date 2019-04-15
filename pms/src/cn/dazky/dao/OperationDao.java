package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Operation;

public interface OperationDao {
	/**
	 * 查询菜单项信息表中的所有数据
	 * @return
	 */
	public List<Operation> selectAllOperations();
	
	/**
	 * 根据id查询菜单项信息
	 * @param 菜单项信息id
	 * @return 一个菜单项信息对象
	 */
	public Operation selectOperationById(int id);
	
	/**
	 * 根据id删除菜单项信息
	 * @param 菜单项信息id
	 * @return 是否删除成功
	 */
	public boolean deleteOperationById(int id);
	
	/**
	 * 添加一个菜单项信息
	 * @param 菜单项信息对象
	 * @return 是否添加成功
	 */
	public boolean addOperation(Operation operation);
	
	/**
	 * 更新一个菜单项信息的数据
	 * @param 菜单项信息对象
	 * @return 是否修改成功
	 */
	public boolean updateOperation(Operation operation);
}
