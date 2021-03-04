/**
 * Class PasswordResponse
 * To provide jsonResponse for password change
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package statement*/
package com.dicom.DicomViewer.response;

/**
 * @class PasswordResponse
 */
public class PasswordResponse {
	
	private String message;

	/**
	 * Parameterized Constructor
	 * @param message
	 */
	public PasswordResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * Getter and Setter method
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}

