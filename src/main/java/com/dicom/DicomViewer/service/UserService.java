/**
 * Class UserService
 * Used to write business logic in a different layer
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package statement*/
package com.dicom.DicomViewer.service;

/* import statements*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dicom.DicomViewer.domain.User;
import com.dicom.DicomViewer.repository.UserRepository;

/**
 * @Service annotation is used with classes that provide some business functionalities
 *
 */
@Service

/**
 * @class UserService
 *
 */
public class UserService {
	
	@Autowired
	private UserRepository repo;        //UserRepository instance
	User user;                          //User instance
	
	/**
	 * Method login to find user by username and password
	 * @param username
	 * @param password
	 * @return User
	 */
	public User login(String username,String password) {
		
		user=repo.findByUsernameAndPassword(username,password);
		return user;
	}
	/**
	 * Method change to get user by username
	 * @param username
	 * @return User
	 */
	public User change(String username) {
		user=repo.getUserByUserName(username);
		return user;
	}
	
	/**
	 * Method update to update user password
	 * @param password
	 * @param username
	 * @return int
	 */
	public int update(String password,String username) {
		int chng=repo.setUserByUserName(password, username);
		user=repo.save(user);
		return 1;
     }
}
