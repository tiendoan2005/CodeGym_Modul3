create database QLBH;
use QLBH;
CREATE TABLE Customer (
    cID INT PRIMARY KEY,
    cName VARCHAR(30) DEFAULT 'Name',
    cAge INT,
    CHECK (cAge BETWEEN 0 AND 100)
);

CREATE TABLE Orders (
    oID INT PRIMARY KEY,
    cID INT NOT NULL,
    oDate DATE,
    oTotalprice DECIMAL(10 , 2 ),
    FOREIGN KEY (cID)
        REFERENCES Customer (cID)
);

CREATE TABLE Product (
    pID INT PRIMARY KEY,
    pName VARCHAR(30),
    pPrice DECIMAL(10 , 2 )
);

CREATE TABLE OrderDetail (
    oID INT,
    pID INT,
    odQTY INT,
    PRIMARY KEY (oID , pID),
    FOREIGN KEY (oID)
        REFERENCES Orders (oID),
    FOREIGN KEY (pID)
        REFERENCES Product (pID)
);
