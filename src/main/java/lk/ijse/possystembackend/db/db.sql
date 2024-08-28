create database pos;

use pos;

create table customer(
    Id VARCHAR(50) primary key,
    Name VARCHAR(255),
    Address VARCHAR(255),
    Tel VARCHAR(10),
    NIC VARCHAR(12)
);

select * from customer;

create table item(
    itemId VARCHAR(50) primary key,
    itemName VARCHAR(255),
    itemUnitPrice DOUBLE,
    itemQty DOUBLE
);