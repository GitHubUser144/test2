package cn.dazky.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dazky.entity.Menu;
import cn.dazky.service.MenuService;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONObject;
@Controller
@Scope("prototype")
public class MenuAction extends ActionSupport implements ModelDriven<Menu> {
	@Resource(name="menu")
	private Menu menu;
	@Resource(name="menuServiceImpl")
	private MenuService service;
	public Menu getModel() {
		return menu;
	}
	
	private JSONObject jsondata;
	public JSONObject getJsondata() {
		return jsondata;
	}
	public void setJsondata(JSONObject jsondata) {
		this.jsondata = jsondata;
	}
	public String json() {
		List<?> menus=service.getAllMenus();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",menus.size());
		map.put("data",menus);
		jsondata = JSONObject.fromObject(map);
		System.out.println("json数据"+jsondata);
		return "Menus";
	}
	public String delete() {
//		System.out.println("准备删除的Role"+role);
		if(service.dropMenuById(menu.getMenuId()))
			WriterUtil.write(ServletActionContext.getResponse(), "1");
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		return null;
	}
	public String add() {
		System.out.println(menu);
		service.addMenu(menu);
		return null;
	}
	public String update() {
		service.updateMenu(menu);
		return null;
	}
	
}
