CREATE DATABASE IF NOT EXISTS usersmanagement;

ALTER DATABASE usersmanagement
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


USE usersmanagement;


CREATE TABLE IF NOT EXISTS tbl_user (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(255),
  login VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;
