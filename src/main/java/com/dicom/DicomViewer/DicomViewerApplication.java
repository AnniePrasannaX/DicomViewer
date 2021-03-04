/*************************
// File: DicomViewerApplication
// Author: Annie Prasanna X
// Date: 26-02-2021
//
// Copyright (C) : 
//
// Description:
//
//
// Comments:
// 
// Revision History:
//
*************************/


/* Package statement*/
package com.dicom.DicomViewer;

/* import statements
 * for Spring Boot
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @class DicomViewerApplication
 * 
 * Mark a configuration class 
 * that declares one or more bean methods and also
 * triggers auto-configuration and component scanning
 * 
 */
@SpringBootApplication
public class DicomViewerApplication {

	/**
	 * Main method which bootstraps a spring application 
	 * as a stand-alone application
	 * @param args Unused
	 * @return Nothing
	 */
	public static void main(String[] args) {
		SpringApplication.run(DicomViewerApplication.class, args);
	}

}
