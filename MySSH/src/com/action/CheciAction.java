package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Checi;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CheciService;

public class CheciAction extends ActionSupport implements ModelDriven<Checi>{
	private Checi checi;
	private CheciService service;
	
	public void setCheci(Checi checi) {
		this.checi = checi;
	}

	public void setService(CheciService service) {
		this.service = service;
	}

	public Checi getModel() {
		return checi;
	}
	
	public String showCheci(){
		ServletActionContext.getRequest().setAttribute("list", service.getAllCheci());
		return "showCheci";
	}

}
