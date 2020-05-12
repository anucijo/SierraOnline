package com.login.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	private String userName;

	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String role;
	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
