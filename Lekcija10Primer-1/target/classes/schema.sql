/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vlada
 * Created: 26.10.2018.
 */

CREATE TABLE todo (
  id bigint AUTO_INCREMENT PRIMARY KEY ,
  owner VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  completed BOOLEAN NOT NULL DEFAULT false
);