package com.Spring_Cloud_Gateway.Entity;

public class UserModel   {
	
	private int id;
    private String login;
    private String token;
    
	public UserModel(int id, String login, String token) {
		this.id = id;
		this.login = login;
		this.token = token;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
