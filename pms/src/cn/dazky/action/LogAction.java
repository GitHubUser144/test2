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
import cn.dazky.service.LogService;
import cn.dazky.util.PageUtil;
import cn.dazky.util.WriterUtil;
import net.sf.json.JSONObject;
@Controller
@Scope("prototype")
public class LogAction extends ActionSupport implements ModelDriven<Log> {
	@Resource(name="log")
	private Log log;
	@Resource(name="logServiceImpl")
	private LogService service;
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
	public Log getModel() {
		return log;
	}
	private JSONObject jsondata;
	public JSONObject getJsondata() {
		return jsondata;
	}
	public void setJsondata(JSONObject jsondata) {
		this.jsondata = jsondata;
	}
	public String json() {
		List<?> logs=pageUtil.Pagination(Log.class, limit, page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",service.getAllLogs().size());
		map.put("data",logs);
		jsondata = JSONObject.fromObject(map);
		System.out.println("json数据"+jsondata);
		return "Logs";
	}
	public String delete() {
//		System.out.println("准备删除的Role"+role);
		String logIds=ServletActionContext.getRequest().getParameter("logIds");
		System.out.println("准备删除的所有id"+logIds);
		if(service.dropLogByIds(logIds))
			WriterUtil.write(ServletActionContext.getResponse(), "1");
		else 
			WriterUtil.write(ServletActionContext.getResponse(), "-1");
		
		return null;
	}
}
