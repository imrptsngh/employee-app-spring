-- Create database

CREATE DATABASE  IF NOT EXISTS `employee_tracker`;
USE `employee_tracker`;



-- Create table `user` for application users

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Create typical a admin user

INSERT INTO users VALUES ("admin", "{bcrypt}$2y$04$741tCVkaJo8uTzjdemJs5eWyDyCBN/uBdtEw3WX1QO3LjifX0O8Xu", 1);



-- Create table `authorities`

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Insert data in table `authorities`
INSERT INTO `authorities` VALUES ('admin', 'ROLE_EMPLOYEE');
