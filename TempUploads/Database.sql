CREATE DATABASE  IF NOT EXISTS `fmsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fmsdb`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fmsdb
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event_detail`
--

DROP TABLE IF EXISTS `event_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_detail` (
  `event_id` varchar(255) NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_detail`
--

LOCK TABLES `event_detail` WRITE;
/*!40000 ALTER TABLE `event_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_summary`
--

DROP TABLE IF EXISTS `event_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_type` varchar(255) DEFAULT NULL,
  `base_location` varchar(255) DEFAULT NULL,
  `beneficiary_name` varchar(255) DEFAULT NULL,
  `catagory` varchar(255) DEFAULT NULL,
  `council_name` varchar(255) DEFAULT NULL,
  `event_id` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_description` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `lives_impact` int(11) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `overall_vol_hrs` int(11) DEFAULT NULL,
  `poc_id` varchar(255) DEFAULT NULL,
  `poc_name` varchar(255) DEFAULT NULL,
  `poc_contact` int(11) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_travel_hrs` int(11) DEFAULT NULL,
  `total_vol_hrs` int(11) DEFAULT NULL,
  `total_vol_no` int(11) DEFAULT NULL,
  `venue_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_summary`
--

LOCK TABLES `event_summary` WRITE;
/*!40000 ALTER TABLE `event_summary` DISABLE KEYS */;
INSERT INTO `event_summary` VALUES (1,'1','Singapore','KWONG WAI SHIU HOSPITAL','Essentials or relief','Outreach Singapore','EVNT00047261','2017-12-31 00:00:00','Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!\n\nFriends and family welcome!','Bags of Joy Distribution',800,'DEC',130,'890765','reenu',2333444,'Donation or Distribution','Approved',42,88,21,'705, Serangoon Road, Singapore, Singapore, Singapore-328127'),(2,'3','Chennai','Kamarajar Illam,Tambaram','Multiple Subjects','Chennai BFS Outreach','EVNT00046103','2017-12-31 00:00:00','Teach various subjects to the students in Kamarajar Illam','Be a Teacher @ Kamarajar Illam',30,'DEC',42,'456789','minu',4444444,'Be a Teacher','Approved',14,28,14,'Gandhi Rd, Ranganathapuram, Tambaram, Tambaram, , , India-600045'),(3,'3','United Kingdom','St. Edward’s CE Voluntary Aided Primary School','Other Community Programs','Outreach UK','EVNT00046385','2017-12-31 00:00:00','The school is hosting a Christmas Fayre to raise money to refurbish their swimming pool that is used by the children in the local community. Volunteers needed to set up, run and pack up the stalls. Can make it a fun day with your family.','1st Dec PM-Christmas fair to save a school swimming pool',0,'DEC',24,'890766','chinnu',4555555,'Community Program','Approved',0,24,4,'Havering Drive, Havering Drive, , , Romford-RM1 4BT'),(4,'4','Pune','Gurukulam','Other Subject','Pune QEA LBG Outreach','EVNT00046530','2017-12-31 00:00:00','There is a lack of co-ordination in between the students and no friendly relation to each other.  Through good talk, learning game we will improve co-ordination in between the students.','Improve in Co-ordination',20,'DEC',5,'97666','rani',888888,'Be a Teacher','Approved',0,5,2,'Krantiveer Chapekar Smarak Samitee, Opposite Ram Mandir, Chinchwad Gaon, Pune, Maharashtra, India-411033'),(5,'4','Pune','Gurukulam','Other Subject','Pune QEA LBG Outreach','EVNT00046531','2017-12-31 00:00:00','There is a lack of co-ordination in between the students and no friendly relation to each other.  Through good talk, learning game we will improve co-ordination in between the students.','Improve in Co-ordination',2,'DEC',4,'456789','revathy',678988,'Be a Teacher','Approved',0,4,2,'Krantiveer Chapekar Smarak Samitee, Opposite Ram Mandir, Chinchwad Gaon, Pune, Maharashtra, India-411033'),(6,'4','Chennai','ADW Primary school chitlapakkam','English','Chennai BPS Outreach','EVNT00046588','2017-12-31 00:00:00','BAT','BAT',2,'DEC',4,'234567','rahul',6778888,'Be a Teacher','Approved',0,4,2,'Chitlapakkam, , , India-600064'),(7,'3','Coimbatore','Panchayat Union Primary School, Keeranatham Puthupalayam','Multiple Subjects','Coimbatore Outreach','EVNT00046611','2017-12-31 00:00:00','Teaches English Grammar','TEACHING',22,'DEC',12,'123455','anu',9087666,'Be a Teacher','Approved',2,10,5,'Keeranatham Puthupalayam, Coimbatore, Tamil nadu, India-641035'),(8,'5','Chennai','Panchayat Union Primary School, Amman Nagar','English','Chennai RCG Outreach','EVNT00047114','2017-12-31 00:00:00','To teach \'english\' (mainly spellings) to \'D\' Category students of 4th std students (A and B section).','Be a Teacher',1,'DEC',9,'984224','anju',9876555,'Be a Teacher','Approved',9,6,6,'Amman Nagar, Trisulam, Chennai, Tamil Nadu, India-600043');
/*!40000 ALTER TABLE `event_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_question`
--

DROP TABLE IF EXISTS `feedback_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_question` (
  `question_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `feedback_type` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_question`
--

LOCK TABLES `feedback_question` WRITE;
/*!40000 ALTER TABLE `feedback_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_master` (
  `user_id` varchar(45) CHARACTER SET latin1 NOT NULL,
  `first_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `email_address` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES ('654321','george','john','georgejohn@yopmail.com');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_access`
--

DROP TABLE IF EXISTS `user_role_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role_access` (
  `associate_id` varchar(255) NOT NULL,
  `account_expired` bit(1) DEFAULT NULL,
  `account_locked` bit(1) DEFAULT NULL,
  `credentials_expired` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`associate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_access`
--

LOCK TABLES `user_role_access` WRITE;
/*!40000 ALTER TABLE `user_role_access` DISABLE KEYS */;
INSERT INTO `user_role_access` VALUES ('123455',_binary '',_binary '',_binary '','123455@cognizant.com',_binary '','$2a$10$gaVj8UYXRZlqM1tQMzKQM.oGdJ/GLu.1iX6WB7eKOazJyFBd/2XXa','ROLE_POC'),('234567',_binary '',_binary '',_binary '','234567@cognizant.com',_binary '','$2a$10$oVq0ATtvQsyY9gC5wyn5F.Fnwaeruc.vE13SMNDKWamY8LI.ojHz2','ROLE_POC'),('456789',_binary '',_binary '',_binary '','456789@cognizant.com',_binary '','$2a$10$3Bny.hNOJPRVwKXzb6.zTOGomraPehdz7wXGMElEE0tWOkFWCuMV6','ROLE_POC'),('654321',_binary '',_binary '',_binary '','654321@cognizant.com',_binary '','$2a$10$AbtK1ltQ/v1KVUqmnzwliucF3qsMwCOz7CBYpJX69.d2szqg10Vki','ROLE_PMO'),('78999',_binary '',_binary '',_binary '','78999@cognizant.com',_binary '','$2a$10$TcQdXAT6mhdnRdqQVsrhnurwBJNHFss1KAy2.dBdn4PvQmTepi9qG','ROLE_PMO'),('890765',_binary '',_binary '',_binary '','890765@cognizant.com',_binary '','$2a$10$jtrG4Kjg4WeRjtqWbLMLx.meeUpMiZy6D821fHgrXedqmZb3AcZ/O','ROLE_POC'),('890766',_binary '',_binary '',_binary '','890766@cognizant.com',_binary '','$2a$10$rORk85DWhgcPedWs4H2KPO/3BrlJ6wEzaXjawhiUnnIhy45RihrNi','ROLE_POC'),('97666',_binary '',_binary '',_binary '','97666@cognizant.com',_binary '','$2a$10$izvgW52qfrOai/vxFhwp5urWV4AN5T12iB94y/VNYej0iuRPxr5tS','ROLE_POC'),('984224',_binary '',_binary '',_binary '','984224@cognizant.com',_binary '','$2a$10$ltGIOYFmCmdQ22OuyJgX3OTfJkxyJ0iFWsMOddB28wGH5QyaNcec.','ROLE_POC');
/*!40000 ALTER TABLE `user_role_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_attended`
--

DROP TABLE IF EXISTS `vol_event_attended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vol_event_attended` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `base_location` varchar(255) DEFAULT NULL,
  `beneficiary_name` varchar(255) DEFAULT NULL,
  `council_name` varchar(255) DEFAULT NULL,
  `email_status` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_attended`
--

LOCK TABLES `vol_event_attended` WRITE;
/*!40000 ALTER TABLE `vol_event_attended` DISABLE KEYS */;
/*!40000 ALTER TABLE `vol_event_attended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_not_attended`
--

DROP TABLE IF EXISTS `vol_event_not_attended`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vol_event_not_attended` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `base_location` varchar(255) DEFAULT NULL,
  `beneficiary_name` varchar(255) DEFAULT NULL,
  `council_name` varchar(255) DEFAULT NULL,
  `email_status` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_not_attended`
--

LOCK TABLES `vol_event_not_attended` WRITE;
/*!40000 ALTER TABLE `vol_event_not_attended` DISABLE KEYS */;
INSERT INTO `vol_event_not_attended` VALUES ('567892','EVNT00047261','Singapore','KWONG WAI SHIU HOSPITAL',NULL,'I',NULL,'2018-12-15 00:00:00','Bags of Joy Distribution',NULL);
/*!40000 ALTER TABLE `vol_event_not_attended` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol_event_unregistered`
--

DROP TABLE IF EXISTS `vol_event_unregistered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vol_event_unregistered` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `base_location` varchar(255) DEFAULT NULL,
  `beneficiary_name` varchar(255) DEFAULT NULL,
  `council_name` varchar(255) DEFAULT NULL,
  `email_status` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vol_event_unregistered`
--

LOCK TABLES `vol_event_unregistered` WRITE;
/*!40000 ALTER TABLE `vol_event_unregistered` DISABLE KEYS */;
INSERT INTO `vol_event_unregistered` VALUES ('567892','EVNT00046103','Singapore','KWONG WAI SHIU HOSPITAL',NULL,'I',NULL,'2018-12-15 00:00:00','Bags of Joy Distribution',NULL);
/*!40000 ALTER TABLE `vol_event_unregistered` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback`
--

DROP TABLE IF EXISTS `volunteer_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_feedback` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `answer1` varchar(255) DEFAULT NULL,
  `answer2` varchar(255) DEFAULT NULL,
  `score` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback`
--

LOCK TABLES `volunteer_feedback` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `volunteer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback_nonpart`
--

DROP TABLE IF EXISTS `volunteer_feedback_nonpart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_feedback_nonpart` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `choice` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback_nonpart`
--

LOCK TABLES `volunteer_feedback_nonpart` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback_nonpart` DISABLE KEYS */;
/*!40000 ALTER TABLE `volunteer_feedback_nonpart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_feedback_unreg`
--

DROP TABLE IF EXISTS `volunteer_feedback_unreg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_feedback_unreg` (
  `employee_id` varchar(255) NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `choice` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_feedback_unreg`
--

LOCK TABLES `volunteer_feedback_unreg` WRITE;
/*!40000 ALTER TABLE `volunteer_feedback_unreg` DISABLE KEYS */;
/*!40000 ALTER TABLE `volunteer_feedback_unreg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fmsdb'
--

--
-- Dumping routines for database 'fmsdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-28 15:23:49
