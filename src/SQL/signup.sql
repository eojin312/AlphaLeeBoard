create database alphaleeboard;

use alphaleeboard;


create table alphaleeuser(
alno int not null auto_increment primary key,
id varchar(20) not null unique,
pwd varchar(20) not null,
email varchar(20) not null
);