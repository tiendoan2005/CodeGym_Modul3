
-- findAll Products

delimiter //
create procedure sp_get_products()
begin
	select * from test_bm;
end //
delimiter ;

call sp_get_products

-- add products

Delimiter //
create procedure sp_insert_product(
in _name varchar(225),
in _price decimal (10,2)
)
begin
insert into test_bm(name, price) values (_name, _price);
end //
delimiter ;

-- find by id

delimiter //
create procedure sp_find_product_by_id(
in _id int
)
begin
select * from test_bm where id = _id;
end//
delimiter ;

-- update product
delimiter //
create procedure sp_update_product(
in _id int,
in _name varchar(225),
in _price decimal (10,2)
)
begin
update test_bm
set name = _name, price = _price 
where id = _id;
end //
delimiter ;

-- insert order
delimiter //
create procedure sp_insert_orders(
in _order_date datetime,
in _total_price decimal(10,2),
out _order_id int
)
begin
insert into orders (order_date, total_price) values (_order_date, _total_price);
set _order_id = (select id from orders order by  id desc limit 1);
end //
delimiter ;

-- insert order_detail
delimiter //
create procedure sp_insert_order_detail(
in _order_id int,
in _product_id int,
in _quantity int 
)
begin
insert into order_detail(order_id, product_id, quantity) values (_order_id, _product_id, _quantity);
end //
delimiter ;

-- get counter
delimiter //
create procedure sp_get_counters(
inout counter int,
in inc int
)
begin
set counter = counter + inc;
end //
delimiter ;

set @C = -1;

call sp_get_counters(@C, 2); -- 1
call sp_get_counters(@C, 4); -- 5
call sp_get_counters(@C, 20); -- 25

select @C;

-- search by name and price
delimiter //
create procedure sp_find_product_by_name_and_price(
in _name varchar(250),
in _price_from int,
in _price_to int
)
begin
if _price_from = -1 then set _price_from = NULL; end if;
if _price_to = -1 then set _price_to = NULL; end if;
select * from test_bm
where (name like concat(_name, "%") or _name is null)
	and (price >= _price_from or _price_from is null)
    and (price <= _price_to or _price_to is null);
end //
delimiter ;

select * from test_bm;
call sp_find_product_by_name_and_price('S', 1200, null);