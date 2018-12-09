/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vlada
 * Created: 26.10.2018.
 */
DROP TABLE IF EXISTS todo;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS AUTHORITIES;

CREATE TABLE todo (
  id bigint AUTO_INCREMENT PRIMARY KEY ,
  owner VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  completed BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE USERS (
    USERNAME    VARCHAR(50)    NOT NULL,
    PASSWORD    VARCHAR(60)    NOT NULL,
    ENABLED     SMALLINT,
    PRIMARY KEY (USERNAME)
);

CREATE TABLE AUTHORITIES (
    USERNAME    VARCHAR(50)    NOT NULL,
    AUTHORITY   VARCHAR(50)    NOT NULL,
    FOREIGN KEY (USERNAME) REFERENCES USERS
);
