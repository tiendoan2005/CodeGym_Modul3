use classicmodels;

DELIMITER //

CREATE PROCEDURE findAllCustomers1()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

call findAllCustomers1();

DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers1`//

CREATE PROCEDURE findAllCustomers1()

BEGIN

SELECT * FROM customers where customerNumber = 175;

END //
DELIMITER ;


call findAllCustomers1();

-- Tham số loại OUT;
DELIMITER //

CREATE PROCEDURE GetCustomersCountByCity(

    IN  in_city VARCHAR(50),

    OUT total INT

)

BEGIN

    SELECT COUNT(customerNumber)

    INTO total

    FROM customers

    WHERE city = in_city;

END//

DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);

SELECT @total;

-- Tham số loại INOUT;

DELIMITER //
CREATE PROCEDURE SetCounter(
INOUT counter INT,
IN inc int
)
BEGIN 
Set counter = counter + inc;
END //
DELIMITER ;

SET @counter = 1;
Call SetCounter(@counter,1);
Call SetCounter(@counter,1);
Call SetCounter(@counter,1);
Call SetCounter(@counter,5);
SELECT @counter;