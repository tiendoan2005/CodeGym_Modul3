create database QLSV_ADD_DATA;
use QLSV_ADD_DATA;

create table Class(
ClassID int not null auto_increment primary key,
ClassName varchar(60) not null,
StartDate datetime,
Status Bit
);

create table Student(
StudentID int not null auto_increment primary key,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20),
Status Bit,
ClassID int not null
);

create table Subject(
SubID int not null auto_increment primary key,
SubName varchar(30) not null,
Credit tinyint not null default 1 ,check (Credit >= 1),
Status Bit default 1
);

create table Mark(
MarkID int not null auto_increment primary key,
SubID int not null,
StudentID int not null,
Mark float default 1 check (Mark between 0 and 100 ),
ExamTimes tinyint default 1
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
 (2, 'C', 6, 1),
 (3, 'HDJ', 5, 1),
 (4, 'RDBMS', 10, 1);
 
 INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
 (1, 2, 10, 2),
 (2, 1, 12, 1);
