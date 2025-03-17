create database CSDL_QLBH;
use CSDL_QLBH;

create table Customer
(
cID int primary key,
Name varchar(25) not null,
cAge tinyint
);

create table Orders(
oID int primary key,
cID int,
oDate datetime,
oTotalPrice int,
foreign key (cID) references Customer(cID)
);

create table Product
(
pID int primary key,
pName varchar(25),
pPrice int
);

create table OrderDetail
(
oID int,
pID int,
odQTY int,
foreign key (oID) references Orders(oID),
foreign key (pID) references Product(pID)
);

insert into Customer(cID, name, cAge)
values (1, 'Minh Quan', 10);
insert into Customer(cID, name, cAge)
values (2, 'Ngoc Oanh', 20);
insert into Customer(cID, name, cAge)
values (3, 'Hong Ha', 50);

insert into Orders(oID, cID, oDate, oTotalPrice)
values(1, 1, '2006-03-21', null);
insert into Orders(oID, cID, oDate, oTotalPrice)
values(2, 2, '2006-03-23', null);
insert into Orders(oID, cID, oDate, oTotalPrice)
values(3, 1, '2006-03-16', null);

insert into Product(pID, pName, pPrice)
values(1, 'May Giat', 3);
insert into Product(pID, pName, pPrice)
values(2, 'Tu Lanh', 5);
insert into Product(pID, pName, pPrice)
values(3, 'Dieu Hoa', 7);
insert into Product(pID, pName, pPrice)
values(4, 'Quat', 1);
insert into Product(pID, pName, pPrice)
values(5, 'Bep Dien', 2);

insert into OrderDetail(oID, pID, odQTY)
values(1,1,3);
insert into OrderDetail(oID, pID, odQTY)
values(1,3,7);
insert into OrderDetail(oID, pID, odQTY)
values(1,4,2);
insert into OrderDetail(oID, pID, odQTY)
values(2,1,1);
insert into OrderDetail(oID, pID, odQTY)
values(3,1,8);
insert into OrderDetail(oID, pID, odQTY)
values(2,5,4);
insert into OrderDetail(oID, pID, odQTY)
values(2,3,3);

-- Hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Orders;
select oID, oDate, oTotalPrice
from Orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách;
SELECT c.cID, c.Name AS CustomerName, c.cAge, 
       o.oID, o.oDate, o.oTotalPrice, 
       p.pID, p.pName AS ProductName, od.odQTY
FROM Customer c
JOIN Orders o ON c.cID = o.cID
JOIN OrderDetail od ON o.oID = od.oID
JOIN Product p ON od.pID = p.pID;

-- Hiển thị tên những khách hàng không mua sản phẩm nào;
SELECT c.cID, c.Name AS CustomerName, c.cAge
FROM Customer c
LEFT JOIN Orders o ON c.cID = o.cID
WHERE o.oID IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá 1 hóa đơn được tính bằng tổng giá bán 
-- của từng loại mặt hàng xuất hiện trong hóa đơn
-- Giá bán của từng loại ước tính = odQTY * pPrice);
Select o.oID, o.oDate, sum(od.odQTY * p.pPrice) AS TotalPrice
From orders o
Join orderdetail od ON o.oID = od.oID
join product p on od.pID = p.pID
group by o.oid, o.odate;

SELECT * FROM Customer;
SELECT * FROM Orders;
SELECT * FROM Product;
SELECT * FROM OrderDetail;