/**
 * Class UploadResponse
 * To provide jsonResponse for file upload
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package statement*/
package com.dicom.DicomViewer.response;

/**
 * @class UploadResponse
 *
 */
public class UploadResponse {
	
	private String message;

	/**
	 * Parameterized constructor
	 * @param message
	 */
	public UploadResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * Getter and setter methods
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	};
	
	
	

}
