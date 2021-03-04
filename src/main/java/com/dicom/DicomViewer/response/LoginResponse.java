/**
 * Class LoginResponse
 * To provide jsonResponse for login
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package statement*/
package com.dicom.DicomViewer.response;

/**
 * @class LoginResponse
 *
 */
public class LoginResponse {
	private String status;
	private String message;
	/**
	 * Parameterized Constructor
	 * @param status
	 * @param message
	 */
	public LoginResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	/**
	 * Getter and setter methods
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
