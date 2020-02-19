CREATE DATABASE  IF NOT EXISTS `outreachfeedbackdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `outreachfeedbackdb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: outreachfeedbackdb
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event_summary`
--

DROP TABLE IF EXISTS `event_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_summary` (
  `event_id` varchar(50) DEFAULT NULL,
  `poc_id` varchar(100) DEFAULT NULL,
  `poc_name` varchar(1000) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_summary`
--

LOCK TABLES `event_summary` WRITE;
/*!40000 ALTER TABLE `event_summary` DISABLE KEYS */;
INSERT INTO `event_summary` VALUES ('EVENT001','432000','Vishal',1),('EVENT001','432001','Raj',2),('EVENT002','432003','Nate',3);
/*!40000 ALTER TABLE `event_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_access`
--

DROP TABLE IF EXISTS `user_role_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role_access` (
  `associate_id` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  `account_expired` bit(1) DEFAULT NULL,
  `account_locked` bit(1) DEFAULT NULL,
  `credentials_expired` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`associate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_access`
--

LOCK TABLES `user_role_access` WRITE;
/*!40000 ALTER TABLE `user_role_access` DISABLE KEYS */;
INSERT INTO `user_role_access` VALUES ('111','ROLE_ADMIN','','','','admin@admin.com','','{bcrypt}$2a$10$muesQx4/8Hn9AOXzjvzHHesESK.LP8/gWSNc6yqkCU6rHfT64XQfO'),('222','ROLE_POC','','','','poc@poc.com','','{bcrypt}$2a$10$lWGSUzkNhrbCOUgI/Ki.Gugry5YSW.Pi84JbJ.wveyUKnzg18lfR6'),('333','ROLE_PMO','','','','pmo@pmo.com','','{bcrypt}$2a$10$5zZ0gi/TRgzEld7IuilV5OFe83C1dTFPnL3uJ2BSU8j7sVQj2P.8S'),('432000','ROLE_ADMIN','','','','432000@cognizant.com','','{bcrypt}$2a$10$J8u6jN9zWFfQLt8SJIhPyOSRaedl4nU/WCwpUepK9GobcD1oHuHHO'),('432001','ROLE_POC','','','','432001@cognizant.com','','{bcrypt}$2a$10$i3Js2U02GDr4ejBXqlWpDefnAS2N8K2mKysxwQ/Z2wm6bqRtJP4re'),('432003','ROLE_POC','','','','432003@cognizant.com','','{bcrypt}$2a$10$XmLV3txscJqxZct.BAh6/uTS2XgV5Xzsp1EvHQ2Zar.eO5EopkfVi');
/*!40000 ALTER TABLE `user_role_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_attended`
--

DROP TABLE IF EXISTS `vol_event_attended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vol_event_attended` (
  `event_id` varchar(50) NOT NULL,
  `base_location` varchar(100) DEFAULT NULL,
  `beneficiary_name` varchar(200) DEFAULT NULL,
  `event_name` varchar(200) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `employee_id` varchar(50) NOT NULL,
  `employee_name` varchar(200) DEFAULT NULL,
  `email_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_attended`
--

LOCK TABLES `vol_event_attended` WRITE;
/*!40000 ALTER TABLE `vol_event_attended` DISABLE KEYS */;
INSERT INTO `vol_event_attended` VALUES ('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','605991',NULL,'I'),('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','605992',NULL,'I'),('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','605995',NULL,'I'),('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','605996',NULL,'I'),('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','605999',NULL,'I'),('EVENT001','Singapore','KWONG WAI SHIU HOSPITAL','Bags of Joy Distribution','2018-12-15','606000',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','605993',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','605994',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','605997',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','605998',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','606001',NULL,'I'),('EVENT002','Nagpur','NAGPUR HOSPITAL','Plastic Distribution','2018-11-15','606002',NULL,'I');
/*!40000 ALTER TABLE `vol_event_attended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_not_attended`
--

DROP TABLE IF EXISTS `vol_event_not_attended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vol_event_not_attended` (
  `event_id` varchar(50) NOT NULL,
  `base_location` varchar(100) DEFAULT NULL,
  `beneficiary_name` varchar(200) DEFAULT NULL,
  `event_name` varchar(200) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `employee_id` varchar(10) NOT NULL,
  `employee_name` varchar(200) DEFAULT NULL,
  `email_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_not_attended`
--

LOCK TABLES `vol_event_not_attended` WRITE;
/*!40000 ALTER TABLE `vol_event_not_attended` DISABLE KEYS */;
INSERT INTO `vol_event_not_attended` VALUES ('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532001',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532002',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532003',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532004',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532005',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','532006',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532007',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532008',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532009',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532010',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532011',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532012',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','532013',NULL,'I');
/*!40000 ALTER TABLE `vol_event_not_attended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_unregistered`
--

DROP TABLE IF EXISTS `vol_event_unregistered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vol_event_unregistered` (
  `event_id` varchar(50) NOT NULL,
  `base_location` varchar(100) DEFAULT NULL,
  `beneficiary_name` varchar(200) DEFAULT NULL,
  `event_name` varchar(200) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `employee_id` varchar(10) NOT NULL,
  `employee_name` varchar(200) DEFAULT NULL,
  `email_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_unregistered`
--

LOCK TABLES `vol_event_unregistered` WRITE;
/*!40000 ALTER TABLE `vol_event_unregistered` DISABLE KEYS */;
INSERT INTO `vol_event_unregistered` VALUES ('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632001',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632002',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632003',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632004',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632005',NULL,'I'),('EVENT001','BASE 001','EVENT BENEFICIARY 001','EVENT TEST 001','2018-12-15','632006',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632007',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632008',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632009',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632010',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632011',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632012',NULL,'I'),('EVENT002','BASE 002','EVENT BENEFICIARY 002','EVENT TEST 002','2018-11-15','632013',NULL,'I');
/*!40000 ALTER TABLE `vol_event_unregistered` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback`
--

DROP TABLE IF EXISTS `volunteer_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteer_feedback` (
  `event_id` varchar(100) NOT NULL,
  `employee_id` varchar(10) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `answer1` varchar(1000) DEFAULT NULL,
  `answer2` varchar(1000) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback`
--

LOCK TABLES `volunteer_feedback` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback` DISABLE KEYS */;
INSERT INTO `volunteer_feedback` VALUES ('EVENT001','605991',4,'Test','Test','I'),('EVENT002','605993',4,'TEST','TEST','P');
/*!40000 ALTER TABLE `volunteer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback_nonpart`
--

DROP TABLE IF EXISTS `volunteer_feedback_nonpart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteer_feedback_nonpart` (
  `event_id` varchar(25) NOT NULL,
  `employee_id` varchar(25) NOT NULL,
  `choice` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback_nonpart`
--

LOCK TABLES `volunteer_feedback_nonpart` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback_nonpart` DISABLE KEYS */;
INSERT INTO `volunteer_feedback_nonpart` VALUES ('EVENT001','532001','Did not recieve information about event','I');
/*!40000 ALTER TABLE `volunteer_feedback_nonpart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback_unreg`
--

DROP TABLE IF EXISTS `volunteer_feedback_unreg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteer_feedback_unreg` (
  `event_id` varchar(25) NOT NULL,
  `employee_id` varchar(25) NOT NULL,
  `choice` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback_unreg`
--

LOCK TABLES `volunteer_feedback_unreg` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback_unreg` DISABLE KEYS */;
INSERT INTO `volunteer_feedback_unreg` VALUES ('EVENT001','632001','Unexpected personal commitment','I');
/*!40000 ALTER TABLE `volunteer_feedback_unreg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-05 18:13:22
