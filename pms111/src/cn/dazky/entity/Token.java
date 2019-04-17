package cn.dazky.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@SuppressWarnings("serial")
@Component("token")
public class Token  implements Serializable{
	
	private int tokenId;          // ����ID
	private int userId;           // �û�ID
	private String userAgent;         // �����(md5��ʽ)
	private String token;             // TOKENֵ(md5(username+md5(useragent)))
	private String createTime;        // ����ʱ��
	private String expireTime;        // ����ʱ��

	public Token(int tokenId, int userId, String userAgent, String token, String createTime, String expireTime) {
		super();
		this.tokenId = tokenId;
		this.userId = userId;
		this.userAgent = userAgent;
		this.token = token;
		this.createTime = createTime;
		this.expireTime = expireTime;
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public Token() {
		super();
	}

	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", userId=" + userId + ", userAgent=" + userAgent + ", token=" + token
				+ ", createTime=" + createTime + ", expireTime=" + expireTime +"]";
	}
	
	
}