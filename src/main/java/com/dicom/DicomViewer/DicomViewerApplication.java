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


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
/* import statements
 * for Spring Boot
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dicom.DicomViewer.service.User1Service;
//import com.dicom.DicomViewer.service.User2Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dicom.DicomViewer.domain.User1;



/**
 * @class DicomViewerApplication
 * 
 * Mark a configuration class 
 * that declares one or more bean methods and also
 * triggers auto-configuration and component scanning
 * 
 */
@SpringBootApplication
@ComponentScan({"com.dicom.DicomViewer"})
@EntityScan("com.dicom.DicomViewer.domain")
@EnableJpaRepositories("com.dicom.DicomViewer.repository")
public class DicomViewerApplication {

	/**
	 * Main method which bootstraps a spring application 
	 * as a stand-alone application
	 * @param args Unused
	 * @return Nothing
	 */
	public static void main(String[] args) {
		SpringApplication.run(DicomViewerApplication.class, args);
		Runtime rt = Runtime.getRuntime();
		try {
			Process ps = new ProcessBuilder("dicom_parserstorage","test.DCM").start();
			ps.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
//		@Bean
//		CommandLineRunner runner(User2Service userService) {
//			return args -> {
//				// read json and write to db
//				ObjectMapper mapper = new ObjectMapper();
//				TypeReference<List<User1>> typeReference = new TypeReference<List<User1>>(){};
//				InputStream inputStream = TypeReference.class.getResourceAsStream("patient_details.json");
//				try {
//					List<User1> users = mapper.readValue(inputStream,typeReference);
//					userService.save(users);
//					
//				} catch (IOException e){
//					e.printStackTrace();
//				}
//			};
//		
//		
//	}
}


