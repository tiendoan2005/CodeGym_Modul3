create database QuanLyDiemThi;
use quanlydiemthi;

create table HocSinh(
MaHS varchar(20) primary key,
TenHS varchar(50),
NgaySinh datetime,
Lop varchar(20),
GT varchar(20)
);

create table MonHoc(
MaMH varchar(20) primary key,
TenMH varchar(50)
);

create table BangDiem(
MaHS varchar(20),
MaMH varchar(50),
primary key(MaHS, MaMH),
DiemThi int,
NgayKT datetime,
Foreign key (MaHS) references HocSinh(MaHS),
Foreign key (MaMH) references MonHoc(MaMH)
);

create table GiaoVien(
MaGV varchar(20) primary key,
TenGV varchar(20),
SDT varchar(10)
);

ALTER TABLE MonHoc
ADD column MaGV varchar(20);

alter table MonHoc
Add constraint FK_MaGV foreign key (MaGV) references GiaoVien(MaGV);