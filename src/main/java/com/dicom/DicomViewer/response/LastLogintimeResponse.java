/**
 * Class LastLogintimeResponse
 * To provide jsonResponse for lastlogintime
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/* Package statement*/
package com.dicom.DicomViewer.response;
/**
 * 
 * @class LastLogintimeResponse
 *
 */
public class LastLogintimeResponse {
	
	private long lastLogintime;

	/**
	 * Parameterized constructor
	 * @param lastLogintime
	 */
	public LastLogintimeResponse(long lastLogintime) {
		super();
		this.lastLogintime = lastLogintime;
	}

	/**
	 * Getter and Setter methods
	 * @return long
	 */
	public long getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(long lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	
	

}
