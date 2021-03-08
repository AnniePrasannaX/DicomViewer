/**
 * Class User
 * stores value got from database
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package Statement*/
package com.dicom.DicomViewer.domain;

/* import statements*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@Entity annotation defines that a class can be mapped to a table.
 *@Table's name attribute is the actual table name.
 */
@Entity
@Table(name="credentials")

/**
 * @class User
 *
 */
public class User {

	/**
	 * @Id annotation specifies the primary key of an entity
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;
	private String password;
	
	/**
	 * Explicit default constructor
	 */
	public User() {
	}
	
	/**
	 * Parameterized constructor
	 * @param username
	 * @param password
	 */
	public User(String username,String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Getters and Setters
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
