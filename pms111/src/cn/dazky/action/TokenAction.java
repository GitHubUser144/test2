package cn.dazky.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.dazky.entity.Token;
@Controller
@Scope("prototype")
public class TokenAction extends ActionSupport implements ModelDriven<Token> {
	@Resource(name="token")
	private Token token;
	public Token getModel() {
		return token;
	}
	
}
