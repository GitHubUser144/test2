package cn.dazky.service;

import java.util.List;

import cn.dazky.entity.Menu;

public interface MenuService {
	/**
	 * ��ȡ���в˵�
	 * @return
	 */
	public List<?> getAllMenus();
	
	/**
	 * ����idɾ���˵�
	 * @param id
	 * @return
	 */
	public boolean dropMenuById(int id);
	
	/**
	 * ��Ӳ˵�
	 * @param menu
	 * @return
	 */
	public boolean addMenu(Menu menu);
	
	/**
	 * ���²˵�����(��Ȩ)
	 * @param menu
	 * @return
	 */
	public boolean updateMenu(Menu menu);
	
}
