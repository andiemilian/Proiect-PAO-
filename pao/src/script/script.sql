

CREATE DATABASE `paodb`;

CREATE TABLE `painting` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` float(10) DEFAULT NULL,
  `numberofOwners` int DEFAULT NULL,
  `yearofCreation` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `typeOfpaint` varchar(30) DEFAULT NULL,

  PRIMARY KEY (`id`)
);

CREATE TABLE `sculpture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` float(10) DEFAULT NULL,
  `numberofOwners` int DEFAULT NULL,
  `yearofCreation` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `material` varchar(30) DEFAULT NULL,

  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `actionHouse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `actionMaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `yearsofActivity` int DEFAULT NULL,
  `numberOfActionsAttended` int DEFAULT NULL,

  PRIMARY KEY (`id`)
);

CREATE TABLE `bid` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `actionHouseId` int DEFAULT NULL,
  `actionMasterId` int DEFAULT NULL,
  `paintingId` int DEFAULT NULL,
  `sculptureId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `actionHouseId` (`actionHouseId`),
  KEY `actionMasterId` (`actionMasterId`),
  KEY `paintingId` (`paintingId`),
  KEY `sculptureId` (`sculptureId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`actionHouseId`) REFERENCES `actionHouse` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`actionMasterId`) REFERENCES `actionMaster` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_4` FOREIGN KEY (`paintingId`) REFERENCES `painting` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_5` FOREIGN KEY (`sculptureId`) REFERENCES `sculpture` (`id`) ON DELETE CASCADE
);
