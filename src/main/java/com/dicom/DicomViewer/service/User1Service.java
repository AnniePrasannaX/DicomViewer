package com.dicom.DicomViewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dicom.DicomViewer.domain.User1;
import com.dicom.DicomViewer.repository.User1Repository;
//import com.dicom.DicomViewer.repository.User2Repository;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class User1Service {
	@Autowired
	private User1Repository repo;
	
	public Iterable<User1> list(){
		return repo.find();
	}

	public List<User1> getAllPatients() {
		return (List<User1>) repo.findAll();
	}
	
	

	public List<User1> getSearch(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return null;
	}

	public long getCountOfEntities() {
		long count = repo.count();
		return count;
	}

}
