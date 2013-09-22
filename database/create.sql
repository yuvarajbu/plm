create database plm;
create user 'plm_user'@'localhost' identified by 'plm_password';
grant all on plm.* to 'plm_user'@'localhost';

use plm;

drop table User;
create table User(
id int auto_increment primary key,
name varchar(50) not null,
password varchar(50) not null
);
