package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Menu;

public interface MenuDao {
	/**
	 * 查询菜单信息表中的所有数据
	 * @return
	 */
	public List<Menu> selectAllMenus();
	
	/**
	 * 根据id查询菜单信息
	 * @param 菜单信息id
	 * @return 一个菜单信息对象
	 */
	public Menu selectMenuById(int id);
	
	/**
	 * 根据id删除菜单信息
	 * @param 菜单信息id
	 * @return 是否删除成功
	 */
	public boolean deleteMenuById(int id);
	
	/**
	 * 添加一个菜单信息
	 * @param 菜单信息对象
	 * @return 是否添加成功
	 */
	public boolean addMenu(Menu menu);
	
	/**
	 * 更新一个菜单信息的数据
	 * @param 菜单信息对象
	 * @return 是否修改成功
	 */
	public boolean updateMenu(Menu menu);
}
