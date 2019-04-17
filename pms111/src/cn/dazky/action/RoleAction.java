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
import cn.dazky.entity.Role;
import cn.dazky.entity.User;
import cn.dazky.service.LogService;
import cn.dazky.service.RoleService;
import cn.dazky.util.IpUtil;
import cn.dazky.util.TimeUtil;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONObject;
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {
	@Resource(name="role")
	private Role role;
	@Resource(name="roleServiceImpl")
	private RoleService service;
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
		List<?> roles=service.getAllRoles();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",roles.size());
		map.put("data",roles);
		jsondata = JSONObject.fromObject(map);
		System.out.println("json����"+jsondata);
		return "Roles";
	}
	public String delete() {
//		System.out.println("׼��ɾ����Role"+role);
		if(service.dropRoleById(role.getRoleId())) {
			WriterUtil.write(ServletActionContext.getResponse(), "1");
			ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		}
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"ɾ����ɫ"+role.getRoleId(),"ɾ��",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
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
					"��ӽ�ɫ"+role.getRoleId(),"���",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String update() {
		service.updateRole(role);
		ServletActionContext.getRequest().getSession().setAttribute("roles", service.getAllRoles());
		try {
			User uu=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			logService.addLog(new Log(uu.getUserName(),TimeUtil.getTime(),
					"�༭��ɫ"+role.getRoleId(),"�༭",IpUtil.getIpAddr(ServletActionContext.getRequest()),null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
