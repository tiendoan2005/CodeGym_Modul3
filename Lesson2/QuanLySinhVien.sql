create database QuanLySinhVien;
use QuanLySinhVien;

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

