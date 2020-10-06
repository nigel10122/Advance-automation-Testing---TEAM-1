-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: cruiseship
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `eventid` int NOT NULL AUTO_INCREMENT,
  `eventname` varchar(45) NOT NULL,
  `eventdate` varchar(45) NOT NULL,
  `starttime` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `numberofattendees` varchar(45) NOT NULL,
  `capacity` varchar(45) NOT NULL,
  `eventcoordinator` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `estattendees` varchar(45) NOT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Bowling 1','10/28/2020','06:00 PM','60 min','Deck 8','8','10','nigel','Athletic','4'),(2,'Bowling 2','10/28/2020','06:00 PM ','60 min ','Deck 8 ','10','10 ','Harsh Daga','Show','5'),(3,'Movie 1','10/28/2020','06:00 PM','120 min','Deck 3','21','25','Kavya Gudivada','Show','15'),(4,'Movie 2','10/28/2020','06:00 PM','120 min','Deck 3','45','50','amey','Show','40'),(5,'Extreme Zipline','10/28/2020','07:00 PM','30 min','Deck15','14','15','kavya','Athletic','10'),(6,'Skycourse Ropes','    10/28/2020','07:00 PM    ','30 min    ','Deck 14    ','    6','8    ','Amey Dhuri','Athletic','    5'),(7,'Ice Skating','10/28/2020','07:00 PM','60 min','Deck 9','32','35','vikram','Athletic','32'),(8,'Go Karting','10/28/2020','07:00 PM','60 min','Deck 12','18','20','Naman Sannan','Athletic','18'),(9,'Broadway Show','10/28/2020','08:00 PM  ','120 min  ','Deck 6  ','  90','100  ','Parakh Rajan','Show','  80'),(10,'Planetarium','10/28/2020','08:00 PM','60 min','Deck 7','82','100','Vratant Chauhan','Show','75');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `eventid` int NOT NULL AUTO_INCREMENT,
  `eventname` varchar(45) DEFAULT NULL,
  `eventdate` varchar(45) DEFAULT NULL,
  `starttime` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `numberofattendees` varchar(45) DEFAULT NULL,
  `capacity` varchar(45) DEFAULT NULL,
  `eventcoordinator` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `estattendees` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (2,'Bowling 1','10/28/2020','06:00 PM ','60 min ','Deck 8 ','8','10 ','nigel','Athletic','4','Kyle','Dsouza','kyle.dsouza@gmail.com','4653325344'),(4,'Ice Skating','10/28/2020','07:00 PM ','60 min ','Deck 9 ','32','35 ','vikram','Athletic','32','Kyle','Dsouza','kyle.dsouza@gmail.com','4653325344');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `roomnumber` varchar(45) DEFAULT NULL,
  `decknumber` varchar(45) DEFAULT NULL,
  `membership` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abhi10122','Joshi','Abhimanyu','Plmqaz@098','abhi.joshi@gmail.com','4693326534',NULL,NULL,NULL,'Coordinator'),('amey10122','Dhuri','Amey','Plmqaz@098','amey.dhuri@gmail.com','4694356920',NULL,NULL,NULL,'Coordinator'),('harsh10122','Daga','Harsh','Plmqaz@098','harsh.daga@gmail.com','4363636332',NULL,NULL,NULL,'Coordinator'),('kavya10122','Gudivada','Kavya','Plmqaz@098','kavya.gudivada@gmail.com','4315667432',NULL,NULL,NULL,'Coordinator'),('kyle10122','Dsouza','Hello','Plmqaz@098','kyle.dsouza@gmail.com','4653325344','101','1','Premium','Passenger'),('naman10122','Sannan','Naman','Plmqaz@098','naman.sannan@gmail.com','4698247892',NULL,NULL,NULL,'Coordinator'),('nigel10122','Dsouza','Nigel','Plmqaz@098','nigel.dsouza@gmail.com','4783235614',NULL,NULL,NULL,'Manager'),('parakh10122','Rajan','Parakh','Plmqaz@098','parakh.rajan','4839220311',NULL,NULL,NULL,'Coordinator'),('ram10122','Reddy','Ram','Plmqaz@098','ram.reddy@gmail.com','4692320183',NULL,NULL,NULL,'Coordinator'),('vratant10122','Chauhan','Vratant','Plmqaz@098','vratant.chauhan@gmail.com','4692341782',NULL,NULL,NULL,'Coordinator');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-05 20:38:36
