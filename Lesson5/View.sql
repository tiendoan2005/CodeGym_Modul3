USE classicmodels;

-- Tạo VIEW;
CREATE view customer_views as
select customerNumber, customerName, phone
from customers; 

select * from customer_views;

-- Cập nhật VIEW;
CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone, city

FROM customers

WHERE city = 'Nantes';

-- Xóa bảng;
DROP VIEW customer_views;