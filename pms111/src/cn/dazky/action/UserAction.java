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
import cn.dazky.entity.User;
import cn.dazky.service.LogService;
import cn.dazky.service.UserService;
import cn.dazky.util.IpUtil;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "login_ok";	}
		return "login_fail";
	}
	public String add() {
		service.register(user);
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"添加用户"+user.getUserName(),"添加",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	public String delete() {
		if(service.dropUserById(user.getUserId()))
			WriterUtil.write(ServletActionContext.getResponse(), "1");
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"删除用户"+user.getUserId(),"删除",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String update() {
		service.updateUser(user);
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"更新用户"+user.getUserId(),"更新",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private JSONObject jsondata;
	public JSONObject getJsondata() {
		return jsondata;
	}
	public void setJsondata(JSONObject jsondata) {
		this.jsondata = jsondata;
	}
	public String json() {
		ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		List<?> users=service.getAllUsers();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",users.size());
		map.put("data",users);
		jsondata = JSONObject.fromObject(map);
		return "Users";
	}
}
