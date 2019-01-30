DROP TABLE IF EXISTS client;
CREATE TABLE client (
  id int NOT NULL auto_increment,
  firstName varchar(50) NOT NULL,
  lastName varchar(50) NOT NULL,
  phoneNumber varchar(12) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(50),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  id int NOT NULL auto_increment,
  firstName varchar(50) NOT NULL,
  lastName varchar(50) NOT NULL,
  phoneNumber varchar(12) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(60),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS clientBlackList;
CREATE TABLE clientBlackList (
  id int NOT NULL auto_increment,
  client_id int NOT NULL REFERENCES client(id) ON DELETE CASCADE,
  description varchar(255) NOT NULL,
  admin_id int NOT NULL REFERENCES admin(id) , 
  PRIMARY KEY (id)
);