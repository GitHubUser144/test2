package cn.dazky.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dazky.entity.Operation;
@Controller
@Scope("prototype")
public class OperationAction extends ActionSupport implements ModelDriven<Operation> {
	@Resource(name="operation")
	private Operation operation;
	public Operation getModel() {
		return operation;
	}
}
