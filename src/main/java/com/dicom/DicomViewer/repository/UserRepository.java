/**
 * Interface UserRepository
 * Provides the mechanism for storage, retrieval, search, update operation on objects.
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/*Package Statements*/
package com.dicom.DicomViewer.repository;


/* import statements */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.dicom.DicomViewer.domain.User;
/**
 * @Repository is a Spring annotation that indicates that the decorated class is a repository
 *
 */
@Repository
/**
 * @interface UserRepository
 *
 */
public interface UserRepository extends JpaRepository<User,String>{
	User findByUsernameAndPassword(String username,String password); //fetch admin username and password from database
	/**
	 * The @Query annotation declares finder queries directly on repository methods.
	 * @param username
	 * @return User
	 */
	@Query("select u from User u where u.username = :username")
	public User getUserByUserName(@Param("username") String username);//fetch admin based on username
	/**
	 * @Transactional annotation is written at the service level,used to combine 
	 * more than one writes on a database as a single atomic operation.
	 * @Modifying annotation is used to enhance the @Query annotation
	 * @param password
	 * @param username
	 * @return int
	 */
	@Transactional
	@Modifying
	@Query("update User u set u.password = :password where u.username=:username")//update admin password wrt username
	public int setUserByUserName(@Param("password") String password,@Param("username") String username);

	
	
}

	
	


