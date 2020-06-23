# SpringBootApplication
Simple Spring Boot Application with single Entity,get and post method.
DataBase table is currently created via workbench
CREATE TABLE user(
    id int NOT NULL auto_increment primary key,
    username varchar(50) UNIQUE NOT NULL,
    fname varchar(50) NOT NULL,
    lname varchar(50),
	  dob Date,
    email varchar(50) NOT NULL,
    password varchar(10) NOT NULL); 

Phase 2 

More unit Test Cases
DB creation from Java
Password Encoding
