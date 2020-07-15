package com.sierra.dao.upload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierra.entity.upload.ContenTable;

@Repository
public interface FileUploadRepository extends JpaRepository<ContenTable, Integer> {
}
