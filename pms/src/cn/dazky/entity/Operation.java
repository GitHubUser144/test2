package cn.dazky.entity;

import java.io.Serializable;


import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("operation")
public class Operation implements Serializable{
	private int operationId;  //��ťID
	private int menuId;       //������һ��ҳ��˵���ID
	private String operationName;  //��ť����
	private String menuName;

	public Operation(int operationId, int menuId, String operationName, String menuName) {
		super();
		this.operationId = operationId;
		this.menuId = menuId;
		this.operationName = operationName;
		this.menuName = menuName;
	}
	
	public Operation() {
		super();
	}

	@Override
	public String toString() {
		return "Operation [operationId=" + operationId + ", menuId=" + menuId + ", operationName=" + operationName
				+ ", menuName=" + menuName + "]";
	}

	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	
}
