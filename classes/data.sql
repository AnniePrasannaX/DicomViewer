INSERT INTO sample.credentials (username,password)
SELECT * FROM (SELECT 'admin','12345') AS tmp
WHERE NOT EXISTS (
        SELECT username FROM sample.credentials WHERE username='admin'
        )LIMIT 1;
<<<<<<< HEAD
=======
        
        
   
>>>>>>> dca3f51cc007f3c5ba1ba98fff4da7eb97f3cecd

