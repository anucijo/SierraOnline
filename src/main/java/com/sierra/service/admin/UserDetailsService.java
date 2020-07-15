package com.sierra.service.admin;

import java.util.List;

import com.sierra.model.admin.UserModel;

public interface UserDetailsService {
	public List<UserModel>getUserDetailsByRole(String role);

}
