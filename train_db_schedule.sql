-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: train_db
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `sc_no` int NOT NULL AUTO_INCREMENT COMMENT '일정 고유 번호',
  `train_name` varchar(45) NOT NULL COMMENT '기차명',
  `departure` varchar(45) NOT NULL COMMENT '출발지',
  `arrival` varchar(45) NOT NULL COMMENT '도착지',
  `dep_time` time NOT NULL COMMENT '출발시간',
  `arrival_time` time NOT NULL COMMENT '도착시간',
  PRIMARY KEY (`sc_no`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'K01','서울','부산','08:00:00','11:00:00'),(2,'K01','서울','부산','11:00:00','15:00:00'),(3,'K01','서울','부산','15:00:00','19:00:00'),(4,'K02','부산','서울','08:00:00','11:00:00'),(5,'K02','부산','서울','11:00:00','15:00:00'),(6,'K02','부산','서울','15:00:00','19:00:00'),(7,'G01','수서','동탄','06:00:00','10:30:00'),(8,'G01','수서','동탄','10:30:00','13:00:00'),(9,'G01','수서','동탄','13:00:00','16:00:00'),(10,'G02','동탄','수서','06:00:00','10:30:00'),(11,'G02','동탄','수서','10:30:00','13:00:00'),(12,'G02','동탄','수서','13:00:00','16:00:00'),(13,'S01','대구','서울','07:00:00','09:50:00'),(14,'S01','대구','서울','09:50:00','14:30:00'),(15,'S01','대구','서울','14:30:00','17:30:00'),(17,'S02','서울','대구','07:00:00','09:50:00'),(18,'S02','서울','대구','09:50:00','14:30:00'),(19,'S02','서울','대구','14:30:00','17:30:00'),(21,'M01','인천','울산','07:00:00','13:00:00'),(22,'M01','인천','울산','13:00:00','17:00:00'),(23,'M01','인천','울산','17:00:00','19:00:00'),(24,'M02','울산','인천','07:00:00','13:00:00'),(25,'M02','울산','인천','13:00:00','17:00:00'),(26,'M02','울산','인천','17:00:00','19:00:00');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27 16:25:09
