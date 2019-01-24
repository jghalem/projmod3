drop database projeto3;

create database projeto3;

show databases;

use projeto3;

create table tb_cliente(
cod int primary key auto_increment,
nome varchar(30) not null,
email varchar(30) not null,
sexo char not null
);

insert into tb_cliente values(null,'anderson','anderson@gmail.com','m');