package com.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.entity.ContenTable;

@Repository
public interface FileUploadRepository extends 
	JpaRepository<ContenTable, Integer> {

}
