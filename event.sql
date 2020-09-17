-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
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
INSERT INTO `event` VALUES (1,'Bowling 1','9/14/2020','09:00 PM','60 min','Deck 8','8','10','nigel','Athletic','4'),(2,'Bowling 2','9/14/2020','09:00 PM','60 min','Deck 8','10','10','vratant','Athletic','5'),(3,'Movie 1','9/14/2020','09:00 PM','120 min','Deck 3','21','25','parakh','Show','15'),(4,'Movie 2','9/14/2020','09:00 PM','120 min','Deck 3','45','50','amey','Show','40'),(5,'Extreme Zipline','9/14/2020','09:00 PM','30 min','Deck15','14','15','kavya','Athletic','10'),(6,'Skycourse Ropes','9/14/2020','09:00 PM','30 min','Deck 14','6','8','naman','Athletic','5'),(7,'Ice Skating','9/14/2020','09:00 PM','60 min','Deck 9','32','35','vikram','Athletic','32'),(8,'Go Karting','9/14/2020','09:00 PM','60 min','Deck 12','18','20','ram','Athletic','18'),(9,'Broadway Show','9/14/2020','09:00 PM','120 min','Deck 5','90','100','shyam','Show','80'),(10,'Planetarium','9/14/2020','09:00 PM','60 min','Deck 7','82','100','akash','Show','75');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-14 21:32:18
