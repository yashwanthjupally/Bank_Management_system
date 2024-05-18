create database bankmanagementSystem;
show databases;
use bankmanagementsystem;
create table signup(formno varchar(20), name varchar(20), fname varchar(20), dob varchar(20), 
				gender varchar(20), mail varchar(30), martial varchar(20), address varchar(20), 
                city varchar(20), state varchar(20), pin varchar(20));
show tables;
select * from signup;


create table AddDetails(formno varchar(20), religion varchar(20), income varchar(20), 
				education varchar(20),occupation varchar(20), pan varchar(20),
                        aadhar varchar(20),sen varchar(10), exist varchar(10));
show tables;
select * from AddDetails;


create table signup3(formno varchar(20), atype varchar(30), cardno varchar(20), 
				pin varchar(20), facility varchar(100));
                
create table login(formno varchar(20), cardno varchar(20), pin varchar(20));

show tables;
select * from signup3;
select * from login;

create table bank(pin varchar(20),date varchar(50), type varchar(20), money varchar(20));
select * from bank;