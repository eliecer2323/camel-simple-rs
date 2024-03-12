package com.olive.integration.routingsystem.properties;

import org.apache.camel.component.salesforce.AuthenticationType;

public class SalesforcePropertiesMap {
	private AuthenticationType loginType;
	private String loginUrl;
	private String clientId;
	private String clientSecret;
	private String userName;
	private String password;
	private String refreshToken;
	
	public AuthenticationType getLoginType() {
		return loginType;
	}
	public void setLoginType(AuthenticationType loginType) {
		this.loginType = loginType;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	@Override
	public String toString() {
		return "SalesforcePropertiesMap [loginType=" + loginType + ", loginUrl=" + loginUrl + ", clientId=" + clientId
				+ ", clientSecret=" + clientSecret + ", userName=" + userName + ", password=" + password
				+ ", refreshToken=" + refreshToken + "]";
	}
}
