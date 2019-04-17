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

import cn.dazky.entity.Log;
import cn.dazky.entity.Menu;
import cn.dazky.entity.User;
import cn.dazky.service.LogService;
import cn.dazky.service.MenuService;
import cn.dazky.util.IpUtil;
import cn.dazky.util.PageUtil;
import cn.dazky.util.TimeUtil;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONObject;
@Controller
@Scope("prototype")
public class MenuAction extends ActionSupport implements ModelDriven<Menu> {
	@Resource(name="menu")
	private Menu menu;
	@Resource(name="menuServiceImpl")
	private MenuService service;
	@Resource(name="logServiceImpl")
	private LogService logService;
	@Resource(name="pageUtil")
	private PageUtil pageUtil;
	private Integer page;
	private Integer limit;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
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
		List<?> menus=pageUtil.Pagination(Menu.class, limit, page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",service.getAllMenus().size());
		map.put("data",menus);
		jsondata = JSONObject.fromObject(map);
		System.out.println("json数据"+jsondata);
		return "Menus";
	}
	public String delete() {
//		System.out.println("准备删除的Role"+role);
		if(service.dropMenuByIds(ServletActionContext.getRequest().getParameter("menuIds")))
			WriterUtil.write(ServletActionContext.getResponse(), "1");
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"删除菜单"+menu.getMenuId(),"删除",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String add() {
//		System.out.println(menu);
		service.addMenu(menu);
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"添加菜单"+menu.getMenuId(),"添加",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String update() {
		service.updateMenu(menu);
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"更新菜单"+menu.getMenuId(),"更新",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
