package com.login.model;

public class UserResponseModel {
	private String userName;
	public boolean isInstructor;

	
	

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
