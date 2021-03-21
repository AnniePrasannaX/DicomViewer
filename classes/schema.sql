CREATE TABLE IF NOT EXISTS sample.credentials (
  username VARCHAR(64) PRIMARY KEY,
  password VARCHAR(64));
  
DROP TABLE IF EXISTS sample.patient_details;
CREATE TABLE IF NOT EXISTS sample.patient_details(
  patient_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  patient_name VARCHAR(64),
  patient_gender VARCHAR(64),
  patient_birthdate VARCHAR(64),
  modality VARCHAR(64),
  physician_name VARCHAR(64),
  study_date VARCHAR(64),
  study_time VARCHAR(64),
  study_description VARCHAR(64),
  study_id VARCHAR(64),
  upload_time BIGINT,
  dicom_image MEDIUMBLOB);


