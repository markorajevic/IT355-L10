/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vlada
 * Created: 03.11.2018.
 */
/*
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('vlada', 'user', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('admin', 'admin', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('student', 'student', 0);*/

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('vlada', '$2a$04$j/SRLDkHICk0JH.xO.GnBuRg6dsurq/GNHTieL.XxNU8ozBWnDOX.', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('admin', '$2a$04$74kmEHHIgu8C0qYZtD38AeXc9azlmgabuPa0c9/ZS/u6CHlaRP3uK', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('student', '$2a$04$h17KNRS1qW19Q9puIwpi/OV0xE/Eirvd.aYVDNz/ay.gzDhhU.3ou', 0);

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('vlada', 'USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('student', 'USER');

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('admin', 'USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('admin', 'ADMIN');




