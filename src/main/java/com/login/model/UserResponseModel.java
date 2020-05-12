package com.login.model;

public class UserResponseModel {
	private String userName;
	public boolean isValidUser;

	public boolean isValidUser() {
		return isValidUser;
	}

	public void setValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
