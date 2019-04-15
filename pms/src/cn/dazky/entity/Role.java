package cn.dazky.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("role")
public class Role implements Serializable{
	private int roleId;
	private String roleName;
	private String menuIds;
	private String operationIds;
	private String roleDescription;
	
	private Set<User> users=new HashSet<User>(0);
	
	public Set<User> getUser() {
		return users;
	}
	public void setUser(Set<User> users) {
		this.users = users;
	}
	public Role(int roleId, String roleName, String menuIds, String operationIds, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.menuIds = menuIds;
		this.operationIds = operationIds;
		this.roleDescription = roleDescription;
	}
	public Role() {
		super();
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", menuIds=" + menuIds + ", operationIds="
				+ operationIds + ", roleDescription=" + roleDescription + "]";
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public String getOperationIds() {
		return operationIds;
	}
	public void setOperationIds(String operationIds) {
		this.operationIds = operationIds;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
	
}
