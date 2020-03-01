-- Create database

CREATE DATABASE  IF NOT EXISTS `employee_tracker`;
USE `employee_tracker`;

-- Create table `user` for application users

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create a typical admin user

INSERT INTO user (`username`, `password`) VALUES ("admin", "admin");