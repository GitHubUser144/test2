package cn.dazky.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("menu")
public class Menu implements Serializable{

	private int menuId;
	private String menuName;
	private String menuUrl;
	private int parentId;
	private String menuDescription;
	private String status;
	private String iconCls;
	private int seq;

	/*
	 * private Set<Operation> operations=new HashSet<Operation>(0);
	 * 
	 * 
	 * public Set<Operation> getOperations() { return operations; } public void
	 * setOperations(Set<Operation> operations) { this.operations = operations; }
	 */
	public Menu(int menuId, String menuName, String menuUrl, int parentId, String menuDescription, String status,
			String iconCls, int seq) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
		this.menuDescription = menuDescription;
		this.status = status;
		this.iconCls = iconCls;
		this.seq = seq;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", parentId=" + parentId
				+ ", menuDescription=" + menuDescription + ", status=" + status + ", iconCls=" + iconCls + ", seq=" + seq
				+"]";
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
