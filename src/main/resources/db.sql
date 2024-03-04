USE `test`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teachersbd
-- ------------------------------------------------------
-- Server version	8.0.31

ALTER DATABASE test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

--
-- Table structure for table `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `patronymic` varchar(45) NOT NULL,
  `faculty` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `senuority` int NOT NULL,
  PRIMARY KEY (`id`)
) 

--
-- Dumping data for table `teachers`
--
