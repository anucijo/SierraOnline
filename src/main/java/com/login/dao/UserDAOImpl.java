package com.login.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exception.InvalidLoginException;
import com.login.entity.User;
import com.login.model.LoginModel;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException {
		System.out.println("Inside DAO login username"+login.getUserName()+login.getPassword());	

		Query<User> query=sessionFactory.getCurrentSession()
				.createQuery("from User where username=:userName and password=:passWord", User.class);
		query.setParameter("userName", login.getUserName());
		query.setParameter("passWord", login.getPassword());

		List<User> list=query.getResultList();
		if(null == list || list.isEmpty()) {
			throw new InvalidLoginException("Invalid login");
		}
	}
}
