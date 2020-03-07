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

-- Create a typical admin user

INSERT INTO users VALUES ("admin", "{bcrypt}$2y$12$mRNR6trkOmlXItEaZOrzxujQI0MzMwTwZJPpSWQGztuu4R0s6JFuu", 1),
						 ("user", "{bcrypt}$2y$12$q0DEeXmumTu3ePCwJCvwGuVprdYp7soi4/48ujjh7Ya1YV1kHtnVy" ,1);
