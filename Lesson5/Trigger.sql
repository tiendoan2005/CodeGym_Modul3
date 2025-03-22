create database company;

use company;
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10 , 2 ) NOT NULL
);

-- Tạo trigger
DELIMITER //

CREATE TRIGGER update_department
before INSERT ON employees
FOR EACH ROW
BEGIN
     IF NEW.salary >= 5000 THEN
          SET new.department = 'Management';
     ELSEIF NEW.salary >= 3000 THEN
          SET new.department = 'Sales';
     ELSE
          SET new.department = 'Support';
     END IF;
END //

DELIMITER ;

insert into employees(name, department, salary)
values('John Doe', 'A', 3500),
		('Jane Smith', 'A', 2000),
		('David Johnson', 'A', 6000);
        
	select * from employees;