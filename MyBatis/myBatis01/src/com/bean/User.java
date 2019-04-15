package com.bean;

public class User {
	private int id;
	private String name;
	private String password;
	private String username;
	private String telephone;
	private String isadmin;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", username=" + username
				+ ", telephone=" + telephone + ", isadmin=" + isadmin + "]";
	}
	public User(int id, String name, String password, String username, String telephone, String isadmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.username = username;
		this.telephone = telephone;
		this.isadmin = isadmin;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

}
