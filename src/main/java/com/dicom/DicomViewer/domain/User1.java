package com.dicom.DicomViewer.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity // This tells Hibernate to make a table out of this class

@Table(name = "patient_details")
public class User1 {
	@Id // specifies the primary key of an entity
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "patient_id")
	private String patient_id;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "patient_gender")
	private String patient_gender;
	@Column(name = "patient_birthdate")
	private String patient_birthdate;
	@Column(name = "modality")
	private String modality;
	@Column(name = "physician_name")
	private String physician_name;
	@Column(name = "study_date")
	private String study_date;
	@Column(name = "study_time")
	private String study_time;
	@Column(name = "study_description")
	private String study_description;
	@Column(name = "study_id")
	private String study_id;
	@Column(name="upload_time")
	private long upload_time;
	@Column(name="dicom_image")
	private String dicom_image;

	public User1() {
		
	}

	public User1(String patient_id, String patient_name, String patient_gender, String patient_birthdate,
			String modality, String physician_name, String study_date, String study_time, String study_description,
			String study_id, long upload_time, String dicom_image) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_gender = patient_gender;
		this.patient_birthdate = patient_birthdate;
		this.modality = modality;
		this.physician_name = physician_name;
		this.study_date = study_date;
		this.study_time = study_time;
		this.study_description = study_description;
		this.study_id = study_id;
		this.upload_time = upload_time;
		this.dicom_image = dicom_image;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_gender() {
		return patient_gender;
	}

	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}

	public String getPatient_birthdate() {
		return patient_birthdate;
	}

	public void setPatient_birthdate(String patient_birthdate) {
		this.patient_birthdate = patient_birthdate;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getPhysician_name() {
		return physician_name;
	}

	public void setPhysician_name(String physician_name) {
		this.physician_name = physician_name;
	}

	public String getStudy_date() {
		return study_date;
	}

	public void setStudy_date(String study_date) {
		this.study_date = study_date;
	}

	public String getStudy_time() {
		return study_time;
	}

	public void setStudy_time(String study_time) {
		this.study_time = study_time;
	}

	public String getStudy_description() {
		return study_description;
	}

	public void setStudy_description(String study_description) {
		this.study_description = study_description;
	}

	public String getStudy_id() {
		return study_id;
	}

	public void setStudy_id(String study_id) {
		this.study_id = study_id;
	}

	public long getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(long upload_time) {
		this.upload_time = upload_time;
	}

	public String getDicom_image() {
		return dicom_image;
	}

	public void setDicom_image(String dicom_image) {
		this.dicom_image = dicom_image;
	}
	
	

	}