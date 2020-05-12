package com.login.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.entity.User;
import com.login.model.LoginModel;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public String addUser(User user) {
		String userName="Invalid UserName";
		try {
			sessionFactory.getCurrentSession().save(user);
			userName=user.getUserName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userName;
	}

	@Override
	public boolean getUserByUserNamePassword(LoginModel login) {
		System.out.println("Inside DAO login username"+login.getUserName()+login.getPassword());	
		
		Query<User> query=sessionFactory.getCurrentSession()
				.createQuery("from User where username=:userName and password=:passWord", User.class);
		query.setParameter("userName", login.getUserName());
		query.setParameter("passWord", login.getPassword());

		List<User> list=query.getResultList();
		return null != list && !list.isEmpty();
	}
}
