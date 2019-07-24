CREATE DATABASE IF NOT EXISTS `messenger`;

CREATE USER 'javaapp'@'%' IDENTIFIED BY '1q2w3e';
GRANT ALL ON messenger.* TO 'javaapp'@'%';
FLUSH PRIVILEGES;

USE messenger;

create table users (
	id bigint auto_increment,
	name varchar(60) not null, 
	password varchar(120) not null,
	session_id varchar(260),
	primary key (id)
) ENGINE=INNODB;
