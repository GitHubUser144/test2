package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Menu;

public interface MenuDao {
	/**
	 * ��ѯ�˵���Ϣ���е���������
	 * @return
	 */
	public List<Menu> selectAllMenus();
	
	/**
	 * ����id��ѯ�˵���Ϣ
	 * @param �˵���Ϣid
	 * @return һ���˵���Ϣ����
	 */
	public Menu selectMenuById(int id);
	
	/**
	 * ����idɾ���˵���Ϣ
	 * @param �˵���Ϣid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteMenuById(int id);
	
	/**
	 * ���һ���˵���Ϣ
	 * @param �˵���Ϣ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addMenu(Menu menu);
	
	/**
	 * ����һ���˵���Ϣ������
	 * @param �˵���Ϣ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateMenu(Menu menu);
}
