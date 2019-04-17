package cn.dazky.entity;

/**
 * userµƒÕÿ’π¿‡
 * @author Mr.chen
 *
 */
public class Ex_User{
	private String roleName;
	private User user;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ex_User(String roleName, User user) {
		super();
		this.roleName = roleName;
		this.user = user;
	}
	
	
}
