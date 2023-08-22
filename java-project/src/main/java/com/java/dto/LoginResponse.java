package com.java.dto;

public class LoginResponse {
	
	private Boolean login;
	private UserDetail userDetail;
	
	public Boolean isLogin() {
		return login;
	}
	
	public void setLogin(Boolean login) {
		this.login = login;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	

}
