package cn.dazky.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dazky.entity.Ex_User;
import cn.dazky.entity.Log;
import cn.dazky.entity.User;
import cn.dazky.service.LogService;
import cn.dazky.service.RoleService;
import cn.dazky.service.UserService;
import cn.dazky.util.IpUtil;
import cn.dazky.util.PageUtil;
import cn.dazky.util.SystemServlet;
import cn.dazky.util.TimeUtil;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONObject;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	@Resource(name="userServiceImpl")
	private UserService service;
	@Resource(name="logServiceImpl")
	private LogService logService;
	@Resource(name="roleServiceImpl")
	private RoleService roleService;
	@Resource(name="pageUtil")
	private PageUtil pageUtil;
	private Integer page;
	private Integer limit;
	private static final Logger logger = Logger.getLogger(SystemServlet.class);
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
	@Resource(name="user")
	private User user;
	public User getModel() {
		return user;
	}
	public String login() {
		User u=service.userLogin(user.getUserName(), user.getPassword());	
		
		if(u instanceof User) {
			//设置全局的已登录的user对象
			ServletActionContext.getRequest().getSession().setAttribute("user", u);
			//获取该用户对应的菜单项
			ServletActionContext.getRequest().setAttribute("menus",service.selectMenusByUid(u.getUserId()));
			try {
				logService.addLog(new Log(u.getUserName(),TimeUtil.getTime(),
						null,"登录",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
				logger.info("-----"+u.getUserName()+"登录成功\t");
				ServletActionContext.getRequest().getSession().setAttribute("loginRole", roleService.findRoleByUserId(u.getUserId()));
			} catch (Exception e) {
				logger.error("-----"+u.getUserName()+"登录失败\t");
				e.printStackTrace();
			}
			return "login_ok";	}
		return "login_fail";
	}
	public String add() {
		service.register(user);
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"添加用户"+user.getUserName(),"添加",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
			logger.info("-----"+uu.getUserName()+"添加用户"+user.getUserName()+"成功\t");
		} catch (Exception e) {
			logger.error("-----"+uu.getUserName()+"添加用户"+user.getUserName()+"失败\t");
			e.printStackTrace();
		}
		return NONE;
	}
	public String delete() {
		if(service.dropUserByIds(ServletActionContext.getRequest().getParameter("userIds")))
			WriterUtil.write(ServletActionContext.getResponse(), "1");
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"删除用户"+user.getUserId(),"删除",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
			logger.info("-----"+uu.getUserName()+"删除用户"+user.getUserName()+"成功\t");
		} catch (Exception e) {
			logger.error("-----"+uu.getUserName()+"删除用户"+user.getUserName()+"失败\t");
			e.printStackTrace();
		}
		return null;
	}
	
	public String update() {
		if(service.updateUser(user))
		ServletActionContext.getRequest().getSession().setAttribute("user", service.getUserById(user.getUserId()));
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"更新用户"+user.getUserId(),"更新",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
			logger.info("-----"+uu.getUserName()+"更新用户"+user.getUserName()+"成功\t");
		} catch (Exception e) {
			logger.error("-----"+uu.getUserName()+"更新用户"+user.getUserName()+"失败\t");
			e.printStackTrace();
		}
		return null;
	}
	
	public String quit() {
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		ServletActionContext.getRequest().getSession().invalidate();
		logger.info("-----"+uu.getUserName()+"退出登录\t");
		return "login_fail";
	}
	private JSONObject jsondata;
	public JSONObject getJsondata() {
		return jsondata;
	}
	public void setJsondata(JSONObject jsondata) {
		this.jsondata = jsondata;
	}
	public String json() {
		System.out.println("limit="+limit+"\t page="+page);
		ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		List<?> users=pageUtil.Pagination(User.class,limit,page);
		List<Ex_User> exusers=service.CastData((List<User>) users);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",service.getAllUsers().size());
		map.put("data",exusers);
		jsondata = JSONObject.fromObject(map);
		System.out.println(jsondata);
		return "Users";
	}
	
	public String password() {
		service.modifyBaseInfo(user);
		User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		logger.info("-----"+uu.getUserName()+"修改个人基本信息成功\t");
		return null;
	}
}
