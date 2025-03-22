create database demo_1;
use demo_1;

CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(20) UNIQUE NOT NULL,
    productName VARCHAR(100) NOT NULL,
    productPrice DECIMAL(10,2) NOT NULL,
    productAmount INT NOT NULL,
    productDescription TEXT,
    productStatus varchar(20) NOT NULL
);
INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)  
VALUES  
('P001', 'iPhone 15 Pro', 1199.99, 50, 'Smartphone cao cấp của Apple', 'Available'),  
('P002', 'Samsung Galaxy S23 Ultra', 1099.99, 30, 'Flagship của Samsung với bút S-Pen', 'Available'),  
('P003', 'MacBook Air M2', 1299.99, 20, 'Laptop mỏng nhẹ của Apple với chip M2', 'Available'),  
('P004', 'Dell XPS 15', 1499.99, 15, 'Laptop Windows mạnh mẽ với màn hình OLED', 'Available'),  
('P005', 'Sony WH-1000XM5', 399.99, 40, 'Tai nghe chống ồn tốt nhất của Sony', 'Available'),  
('P006', 'Apple Watch Series 9', 499.99, 25, 'Đồng hồ thông minh của Apple', 'Available'),  
('P007', 'iPad Pro 12.9', 1399.99, 10, 'Máy tính bảng mạnh mẽ của Apple', 'Out of Stock'),  
('P008', 'Logitech MX Master 3S', 99.99, 60, 'Chuột không dây cao cấp cho dân văn phòng', 'Available'),  
('P009', 'Nintendo Switch OLED', 349.99, 35, 'Máy chơi game cầm tay của Nintendo', 'Available'),  
('P010', 'Razer BlackWidow V4', 179.99, 20, 'Bàn phím cơ chơi game của Razer', 'Available');  

select*from Products;

-- Tạo unique index trên bảng products
alter table products
add unique index idx_productCode (productCode);

select productcode from products;

-- Tạo composite index trên bảng Products(sử dụng 2 cột)
ALTER TABLE Products ADD INDEX idx_productName_price (productName, productPrice);

drop index idx_productName_price on products;
EXPLAIN SELECT * FROM Products WHERE productName = 'iPhone 15 Pro' AND productPrice = 1199.99;


-- Tạo view
create view v_products as
select productCode, productName, productPrice, productStatus from products;

select* from v_products;

-- Sửa view 
update v_products
set productName = 'SamSung'
where productCode = 'P001';

-- Xóa view
drop view v_products;

-- Tạo store procedure lấy tất cả thông tin từ bảng products
DELIMITER //
create procedure All_information()
begin
	select * from products;
end //

DELIMITER ;
call All_information();

-- Tạo 1 store procedure thêm 1 sảng phẩm
DELIMITER //
Create procedure AddProduct(
In p_productCode varchar(20),
In p_productName varchar(100),
In p_productPrice decimal(10,2),
In p_productAmount int,
In p_productDescription text,
In p_productStatus varchar(20)
)
Begin
	insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    values(p_productCode, p_productName,p_productPrice, p_productAmount, p_productDescription, p_productStatus);
END //

DELIMITER ;
call AddProduct('P011', 'Asus ROG Zephyrus G14', 1899.99, 12, 'Laptop gaming siêu mạnh mẽ', 'Available');


-- Tạo store product để chỉnh sửa thông tin theo id
DROP PROCEDURE IF EXISTS EditProduct;

DELIMITER //
Create procedure EditProduct(
IN p_id INT,
In p_productCode varchar(20),
In p_productName varchar(100),
In p_productPrice decimal(10,2),
In p_productAmount int,
In p_productDescription text,
In p_productStatus varchar(20)
)
begin
 Update products
 set productCode = p_productCode, 
	productName = p_productName,
    productPrice = p_productPrice,
    productAmount = p_productAmount,
    productDescription = p_productDescription,
    productStatus = p_productStatus
where id = p_id;

End //
DELIMITER ;

call EditProduct(3, 'P003', 'MacBook Air M3', 1399.99, 25, 'Laptop Apple với chip M3', 'Available');

-- Tạo 1 store procedure xóa sản phẩm theo id
DELIMITER //
Create procedure DeleteProduct(
In p_id int
)
Begin
	Delete from products where id = p_id;
END //
DELIMITER ;

call DeleteProduct(11);
SELECT * FROM Products WHERE id = 10;
