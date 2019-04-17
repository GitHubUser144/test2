package cn.dazky.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dazky.entity.Log;
import cn.dazky.entity.Menu;
import cn.dazky.entity.Operation;
import cn.dazky.entity.Role;
import cn.dazky.entity.User;
import cn.dazky.service.LogService;
import cn.dazky.service.MenuService;
import cn.dazky.service.OperationService;
import cn.dazky.service.RoleService;
import cn.dazky.util.ButtonPermissions;
import cn.dazky.util.IpUtil;
import cn.dazky.util.PageUtil;
import cn.dazky.util.SystemServlet;
import cn.dazky.util.TimeUtil;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {
	private static final Logger logger = Logger.getLogger(SystemServlet.class);
	@Resource(name="role")
	private Role role;
	@Resource(name="roleServiceImpl")
	private RoleService service;
	@Resource(name="menuServiceImpl")
	private MenuService menuService;
	@Resource(name="operationServiceImpl")
	private OperationService operationService;
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
	public Role getModel() {
		return role;
	}
	private JSONObject jsondata;
	@Resource(name="logServiceImpl")
	private LogService logService;
	public JSONObject getJsondata() {
		return jsondata;
	}
	public void setJsondata(JSONObject jsondata) {
		this.jsondata = jsondata;
	}
	public String json() {
		List<?> roles=pageUtil.Pagination(Role.class, limit, page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",service.getAllRoles().size());
		map.put("data",roles);
		jsondata = JSONObject.fromObject(map);
//		System.out.println("json数据"+jsondata);
		return "Roles";
	}
	public String delete() {
//		System.out.println("准备删除的Role"+role);
		if(service.dropRoleByIds(ServletActionContext.getRequest().getParameter("roleIds"))) {
			WriterUtil.write(ServletActionContext.getResponse(), "1");
			ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		}
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"删除角色"+role.getRoleId(),"删除",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
			logger.info(uu.getUserName()+"删除角色成功");
		} catch (Exception e) {
			logger.info(uu.getUserName()+"删除角色失败");
			e.printStackTrace();
		}
		return null;
	}
	public String add() {
		service.addRole(role);
		ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"添加角色"+role.getRoleId(),"添加",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String update() {
		System.out.println("角色更新");
		service.updateRole(service.findRoleById(role.getRoleId()));
		ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"编辑角色"+role.getRoleId(),"编辑",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String GentrateTree() {
		System.out.println("生成树...");
		Role rolee = service.findRoleById(role.getRoleId());
		System.out.println(rolee+rolee.getMenuIds());
		String[] str = rolee.getMenuIds().split(",");
		Integer[] ints = new Integer[str.length];
		 for(int i=0;i<str.length;i++){
		        ints[i] = Integer.parseInt(str[i]);
		    }	 
//        DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
		List<Menu> menus =(List<Menu>) menuService.getAllMenus();
		System.out.println("菜单" + menus);
		JSONArray jsonArray = new JSONArray();//1级
		JSONArray jsonArray1 = new JSONArray();//2级
		int j=0;
		int x=0;
		for (int i = 0; i < menus.size(); i++) {
			if(menus.get(i).getParentId()==2){
				JSONArray jsonArray2 = new JSONArray();//按钮
				int y=0;
				System.out.println("菜单2级id" + menus.get(i).getMenuId());
				int menuId = menus.get(i).getMenuId();
				List<Operation> operations =operationService.getOperationsByMenuId(menuId);
				System.out.println(menus.get(i).getMenuName() + "对应的按钮" + operations+"长度"+operations.size());
				for(int a=0;a<operations.size();a++){
					Map<String, Object> map = new HashedMap();
				    map.put("title", operations.get(a).getOperationName());
				    map.put("value", operations.get(a).getOperationId());
				    map.put("data", "");
				    System.out.println(operations.get(a).getOperationId()+"=============="+rolee.getOperationIds());
				    map.put("checked",ButtonPermissions.judge(operations.get(a).getOperationId(), rolee.getOperationIds()));
					jsonArray2.add(y++,map);
					System.out.println("按钮中的jsonArray:"+jsonArray2);
					System.out.println(operations.get(a).getMenuName()+":"+operations.get(a).getOperationName());
				}
				
				Map<String, Object> map = new HashedMap();	
				map.put("title", menus.get(i).getMenuName());
				map.put("value", menus.get(i).getMenuId());
				map.put("data", jsonArray2);
				jsonArray1.add(x++, map);
				System.out.println("2级："+jsonArray1);
			}
		}
		for (int i = 0; i < menus.size(); i++) {
			if(menus.get(i).getParentId()==1){
				Map<String, Object> map = new HashedMap();
				map.put("title", menus.get(i).getMenuName());
				map.put("value", menus.get(i).getMenuId());
				if(menus.get(i).getMenuId()==2){
					map.put("data", jsonArray1);
				}else{
					map.put("data", "");
				}
				jsonArray.add(j++, map);
				System.out.println("1级："+jsonArray);
			}
		}
		ServletActionContext.getContext().getValueStack().set("result", jsonArray);
		return "jjj";
	}
	public String grant() {
		int roleId=Integer.parseInt(ServletActionContext.getRequest().getParameter("roleId"));
		String operations=ServletActionContext.getRequest().getParameter("operations");
		String menus=service.GenerateMenuIdsByOperations(operations);
		service.grant(roleId, menus, operations);
		Role loginRole=(Role) ServletActionContext.getRequest().getSession().getAttribute("loginRole");
		if(loginRole.getRoleId()==roleId) {
			WriterUtil.write(ServletActionContext.getResponse(), "1");
			return "relogin";
		}
		else
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		return null;
	}
}
