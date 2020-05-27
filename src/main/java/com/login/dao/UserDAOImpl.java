package com.login.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exception.InvalidLoginException;
import com.login.entity.ContenTable;
import com.login.entity.User;
import com.login.model.LoginModel;
import com.login.model.SearchResponseModel;

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
	public List<User> getUserByUserNamePassword(LoginModel login) throws InvalidLoginException {
		System.out.println("Inside DAO login username"+login.getUserName()+login.getPassword());	

		Query<User> query=sessionFactory.getCurrentSession()
				.createQuery("from User where username=:userName and password=:passWord", User.class);
		query.setParameter("userName", login.getUserName());
		query.setParameter("passWord", login.getPassword());

		List<User> list=query.getResultList();
		if(null == list || list.isEmpty()) {
			throw new InvalidLoginException("Invalid login");
		}
		return list;
	}

	public List<SearchResponseModel> getVideos(String searchKeyWord) throws InvalidLoginException {
		Session session = sessionFactory.getCurrentSession();
		Query<ContenTable> query = session.createQuery("from ContenTable where name like '%"+searchKeyWord+"%'",ContenTable.class);
		List<ContenTable> contents = query.getResultList();

		List<SearchResponseModel> searchResponses = new ArrayList<>();
		
		for(ContenTable content : contents) {
			SearchResponseModel searchResponse = new SearchResponseModel();
			byte[] fileBytes = content.getFileBytes();
			String fileName = content.getName();
			// System.out.println(Arrays.toString(fileBytes));
			if (null != fileBytes && fileBytes.length > 0) {
				String base64Str = Base64.getEncoder().encodeToString(fileBytes);
				// System.out.println(base64Str);
				searchResponse.setVideoName(fileName);
				searchResponse.setVideoBytes(base64Str);
				searchResponses.add(searchResponse);
			}
		}

		if(null == searchResponses || searchResponses.isEmpty()) {
			throw new InvalidLoginException("No results");
		}
		return searchResponses;
	}


}
