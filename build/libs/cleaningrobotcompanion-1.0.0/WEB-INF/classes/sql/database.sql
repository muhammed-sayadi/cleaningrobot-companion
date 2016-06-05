-- Creating the database

DROP DATABASE IF EXISTS cleaningrobot;
CREATE DATABASE IF NOT EXISTS cleaningrobot
  DEFAULT CHARSET utf8
  DEFAULT COLLATE utf8_general_ci
;

USE cleaningrobot;

-- Creating tables

DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User
(
  Id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(25) NOT NULL,
  phone VARCHAR(25),

  PRIMARY KEY (Id),
  INDEX User (firstName)
)
  ENGINE = INNODB
;

DROP TABLE IF EXISTS Robot;
CREATE TABLE IF NOT EXISTS Robot
(
  Sn BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  model VARCHAR(50) NOT NULL,
  nickname VARCHAR(50),
  userId BIGINT NOT NULL,
  purchaseDate VARCHAR(20),
  batteryLevel DOUBLE,
  waterStatus ENUM
     (
       'Clean',
       'Needs emptying'
     )
  ,
  dustLevel DOUBLE,

  PRIMARY KEY (Sn),
  FOREIGN KEY (userId)
  REFERENCES User (Id)
    ON  UPDATE CASCADE
    ON DELETE CASCADE
)

  ENGINE = INNODB
;

DROP TABLE IF EXISTS Base;
CREATE TABLE IF NOT EXISTS Base
(
  Sn BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  robotSn BIGINT NOT NULL,
  purchaseDate VARCHAR(20),
  localMap BLOB,
  cleanWaterLevel DOUBLE,
  dirtyWaterLevel DOUBLE,
  dustLevel DOUBLE,

  PRIMARY KEY (Sn),
  FOREIGN KEY (robotSn)
  REFERENCES Robot (Sn)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)

  ENGINE = INNODB
;

DROP TABLE IF EXISTS Task;
CREATE TABLE IF NOT EXISTS Task
(
  Id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  robotSn BIGINT NOT NULL,
  dueDate VARCHAR(20),
  startingTime VARCHAR(20),
  operation ENUM
     (
       'Cleaning',
       'Vacuuming'
     )
  ,

  PRIMARY KEY (Id),
  FOREIGN KEY (robotSn)
  REFERENCES Robot (Sn)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)

  ENGINE = INNODB
;

DROP TABLE IF EXISTS Report;
CREATE TABLE IF NOT EXISTS Report
(
  Id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  robotSn BIGINT NOT NULL,
  startTime VARCHAR(20),
  finishTime VARCHAR(20),
  completionMap BLOB,
  operation ENUM
     (
       'Cleaning',
       'Vacuuming'
     )
  ,

  PRIMARY KEY (Id),
  FOREIGN KEY (robotSn)
  REFERENCES Robot (Sn)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)

  ENGINE = INNODB
;
