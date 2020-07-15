package com.sierra.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierra.dao.admin.UserDetailsRepository;
import com.sierra.entity.login.User;
import com.sierra.model.admin.UserModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
@Autowired
UserDetailsRepository userDetailsDao;
	@Override
	public List<UserModel> getUserDetailsByRole(String role) {
		List<User> users = userDetailsDao.findByRole(role);
		List<UserModel> userModels = new ArrayList<UserModel>();
		
		/*for(User user :users) {
			UserModel userModel = new UserModel();
			userModel.setFirstName(user.getFirstName());
			userModel.setLastName(user.getLastName());
			userModel.setEmail(user.getUserName());
			userModel.setPhoneNumber(user.getPhoneNumber());
			userModels.add(userModel);
		}*/
		
		users.forEach(user->{
		UserModel userModel = new UserModel();
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setEmail(user.getUserName());
		userModel.setPhoneNumber(user.getPhoneNumber());
		userModels.add(userModel);
		});
		return userModels;
	}

}
