INSERT INTO sample.credentials (username,password)
SELECT * FROM (SELECT 'admin','12345') AS tmp
WHERE NOT EXISTS (
        SELECT username FROM sample.credentials WHERE username='admin'
        )LIMIT 1;
        
 INSERT INTO sample.patient_details (patient_id,patient_name,patient_gender,patient_birthdate,modality,physician_name,study_date,study_time,study_description,study_id,upload_time,dicom_image)
SELECT * FROM (SELECT 1,'Shamla','Female','24/5/1998','Radiography','Reena','21/3/2000','12 pm','Spinalcord Examination','16734',1234455,'img1') AS tmp
WHERE NOT EXISTS  (
        SELECT patient_id FROM sample.patient_details WHERE patient_id='1'
        )LIMIT 1; 
        
INSERT INTO sample.patient_details (patient_id,patient_name,patient_gender,patient_birthdate,modality,physician_name,study_date,study_time,study_description,study_id,upload_time,dicom_image)
SELECT * FROM (SELECT 2,'Chrisa','Female','23/5/1934','CT','Jensen','2/4/2004','2 pm','Brain Tumour','16345',36473673,'img2') AS tmp
WHERE NOT EXISTS  (
        SELECT patient_id FROM sample.patient_details WHERE patient_id='2'
        )LIMIT 1; 
        
INSERT INTO sample.patient_details (patient_id,patient_name,patient_gender,patient_birthdate,modality,physician_name,study_date,study_time,study_description,study_id,upload_time,dicom_image)
SELECT * FROM (SELECT 3,'Flynn','Male','2/12/1990','Ultrasound','George','25/4/2020','8 am','Pneumothorax','16987',376343,'img3') AS tmp
WHERE NOT EXISTS  (
        SELECT patient_id FROM sample.patient_details WHERE patient_id='3'
        )LIMIT 1; 
        
INSERT INTO sample.patient_details (patient_id,patient_name,patient_gender,patient_birthdate,modality,physician_name,study_date,study_time,study_description,study_id,upload_time,dicom_image)
SELECT * FROM (SELECT 4,'Rose','Female','4/5/2000','MRI','Jensen','2/4/2007','2 pm','Skin Tumour','16312',897587,'img4') AS tmp
WHERE NOT EXISTS  (
        SELECT patient_id FROM sample.patient_details WHERE patient_id='4'
        )LIMIT 1; 
        
INSERT INTO sample.patient_details (patient_id,patient_name,patient_gender,patient_birthdate,modality,physician_name,study_date,study_time,study_description,study_id,upload_time,dicom_image)
SELECT * FROM (SELECT 5,'Sam','Male','23/5/1999','Ultrasound','Jennifer','29/4/2004','8 pm','Cancer','19876',86457465,'img5') AS tmp
WHERE NOT EXISTS  (
        SELECT patient_id FROM sample.patient_details WHERE patient_id='5'
        )LIMIT 1;      
         
   

