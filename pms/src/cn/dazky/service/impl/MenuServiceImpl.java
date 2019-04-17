package cn.dazky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dazky.dao.MenuDao;
import cn.dazky.entity.Menu;
import cn.dazky.entity.User;
import cn.dazky.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	@Resource(name="menuDaoImpl")
	private MenuDao dao;
	
	@Override
	public List<Menu> getAllMenus(){
		return dao.selectAllMenus();
	}

	@Override
	public boolean dropMenuByIds(String ids) {
		String[] str=ids.split(",");
		for(String sss:str) {
			if(!dao.deleteMenuById(Integer.parseInt(sss)))
					return false;
		}
		return true;
	}

	@Override
	public boolean addMenu(Menu menu) {
		
		return dao.addMenu(menu);
	}
	
	public boolean updateMenu(Menu menu) {
		
		return dao.updateMenu(menu);
	}
}
