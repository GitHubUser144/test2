package cn.dazky.entity;

import java.io.Serializable;
import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("log")
public class Log implements Serializable{
	
	private int logId;                   //����������ID 
	private String userName;             //������
	private String createTime;           //ʱ��
	private String content;              //��ϸ����
	private String operation;            //�������ͣ���ɾ�ģ�
	private String ip;                   //IP
	private String module;               //����ģ��

	public Log(String userName, String createTime, String content, String operation, String ip,
			String module) {
		super();
		this.userName = userName;
		this.createTime = createTime;
		this.content = content;
		this.operation = operation;
		this.ip = ip;
		this.module = module;
	}
	public Log() {
		super();
	}
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", userName=" + userName + ", createTime=" + createTime + ", content=" + content
				+ ", operation=" + operation + ", ip=" + ip + ", module=" + module + "]";
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	
	
	
	
	
}
