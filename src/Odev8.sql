CREATE TABLE employee (
                          id int,
                          name VARCHAR(50),
                          birthday DATE,
                          email VARCHAR(100)
);
UPDATE employee
SET name= 'Emre'
WHERE name='Ingunna';


UPDATE employee
SET name = 'Bağlayici'
WHERE name LIKE 'A%';


UPDATE employee
SET email= 'gmail.com'
WHERE email LIKE '%.com%';


UPDATE employee
SET birthday = '1996-10-16'
WHERE email='gmail.com';

DELETE FROM employee WHERE email='gmail.com'
DELETE FROM employee WHERE birthday>'1960-04-10';
DELETE FROM employee WHERE email LIKE '%edu%' RETURNING *;
DELETE FROM employee WHERE name LIKE '%a%' RETURNING *;
SELECT * FROM employee