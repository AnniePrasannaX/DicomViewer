package com.dicom.DicomViewer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dicom.DicomViewer.domain.User1;

@Repository
// This will be AUTO IMPLEMENTED by Spring into a Bean called
// FetchDataRepository
// CRUD refers Create, Read, Update, Delete
public interface User1Repository extends CrudRepository<User1,String> {
	@Override
	List<User1> findAll();
	
	@Query("SELECT u FROM User1 u ORDER BY patient_id")
	List<User1> find();

	@Query("SELECT p FROM User1 p WHERE p.patient_name LIKE %?1%" + "OR p.patient_id LIKE %?1%")
	public List<User1> search(String keyword);

}
