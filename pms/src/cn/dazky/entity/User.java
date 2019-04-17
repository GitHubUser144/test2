package cn.dazky.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("user")
public class User implements Serializable{
	private int userId;
	private String userName;
	private String password;
	private int userType;
	private int roleId;
	private String userDescription;
	/*
	 * private Set<Token> tokens=new HashSet<Token>(0);
	 * 
	 * public Set<Token> getTokens() { return tokens; }
	 * 
	 * public void setTokens(Set<Token> tokens) { this.tokens = tokens; }
	 */

	public User() {}
	
	public User(int page, int rows, String start, String end, int userId, String userName, String password,
			int userType, int roleId, String userDescription) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.roleId = roleId;
		this.userDescription = userDescription;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ ", roleId=" + roleId + ", userDescription=" + userDescription + "]";
	}

	
	
}
