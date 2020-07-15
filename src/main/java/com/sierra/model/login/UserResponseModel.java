package com.sierra.model.login;

public class UserResponseModel {
	private String userName;
	public boolean isInstructor;
	private boolean isAdmin;

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isInstructor() {
		return isInstructor;
	}

	public void setInstructor(boolean isInstructor) {
		this.isInstructor = isInstructor;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
