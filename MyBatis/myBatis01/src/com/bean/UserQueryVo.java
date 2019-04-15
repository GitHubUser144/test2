package com.bean;

import java.util.List;

public class UserQueryVo {
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	private Ex_User ex_User;

	public Ex_User getEx_User() {
		return ex_User;
	}

	public void setEx_User(Ex_User ex_User) {
		this.ex_User = ex_User;
	}
	
	/*
	 * 可以添加别的对象的信息
	 */
}
