package com.olive.integration.routingsystem.properties;

public class SftpPropertiesMap {
	private String host;
	private int port;
	private String user;
	private String pass;
	private String path;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String username) {
		this.user = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String password) {
		this.pass = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "SftpPropertiesMap [host=" + host + ", port=" + port + ", user=" + user + ", pass=" + pass + "]";
	}
}
