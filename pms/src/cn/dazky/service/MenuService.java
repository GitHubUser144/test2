package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Menu;

public interface MenuService {
	/**
	 * 获取所有菜单
	 * @return
	 */
	public List<?> getAllMenus();
	
	/**
	 * 根据id删除菜单
	 * @param id
	 * @return
	 */
	public boolean dropMenuById(int id);
	
	/**
	 * 添加菜单
	 * @param menu
	 * @return
	 */
	public boolean addMenu(Menu menu);
	
	/**
	 * 更新菜单数据(授权)
	 * @param menu
	 * @return
	 */
	public boolean updateMenu(Menu menu);
	
}
