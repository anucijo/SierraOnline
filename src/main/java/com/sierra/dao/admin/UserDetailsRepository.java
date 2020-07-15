package com.sierra.dao.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierra.entity.login.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {
	List<User> findByRole(String role);
}
