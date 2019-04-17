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
			//����ȫ�ֵ��ѵ�¼��user����
			ServletActionContext.getRequest().getSession().setAttribute("user", u);
			//��ȡ���û���Ӧ�Ĳ˵���
			ServletActionContext.getRequest().setAttribute("menus",service.selectMenusByUid(u.getUserId()));
			try {
				logService.addLog(new Log(u.getUserName(),TimeUtil.getTime(),
						null,"��¼",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
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
					"����û�"+user.getUserName(),"���",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
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
					"ɾ���û�"+user.getUserId(),"ɾ��",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
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
					"�����û�"+user.getUserId(),"����",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
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
