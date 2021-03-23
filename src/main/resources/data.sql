INSERT INTO sample.credentials (username,password)
SELECT * FROM (SELECT 'admin','12345') AS tmp
WHERE NOT EXISTS (
        SELECT username FROM sample.credentials WHERE username='admin'
        )LIMIT 1;
        
       
         
   

