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
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train` (
  `train_no` int NOT NULL AUTO_INCREMENT COMMENT '기차번호',
  `train_name` varchar(255) NOT NULL COMMENT '기차명',
  `tour_area` varchar(255) DEFAULT NULL COMMENT '순회지역',
  `start_time` time(4) DEFAULT NULL COMMENT '출발시간대',
  PRIMARY KEY (`train_no`),
  UNIQUE KEY `train_PK` (`train_no`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` (train_name, tour_area, start_time) VALUES ('KTX1001','서울','08:00:00.000000'),('KTX1002','서울','11:00:00.000000'),('KTX1003','서울','15:00:00.000000'),('KTX1004','서울','19:00:00.000000'),('KTX2020','부산','08:00:00.000000'),('KTX2022','부산','11:00:00.000000'),('KTX2024','부산','15:00:00.000000'),('KTX2026','부산','19:00:00.000000'),('GTX12','수서','06:00:00.000000'),('GTX13','수서','10:30:00.000000'),('GTX14','수서','13:00:00.000000'),('GTX15','수서','16:00:00.000000'),('GTX38','동탄','06:00:00.000000'),('GTX37','동탄','10:30:00.000000'),('GTX36','동탄','13:00:00.000000'),('GTX35','동탄','16:00:00.000000'),('SRT103','대구','07:00:00.000000'),('SRT106','대구','09:50:00.000000'),('SRT109','대구','14:30:00.000000'),('SRT112','대구','18:00:00.000000'),('SRT446','서울','07:00:00.000000'),('SRT448','서울','09:50:00.000000'),('SRT450','서울','14:30:00.000000'),('SRT452','서울','18:00:00.000000'),('무궁화호5','인천','07:00:00.000000'),('무궁화호6','인천','13:00:00.000000'),('무궁화호7','인천','17:00:00.000000'),('무궁화호8','인천','19:00:00.000000'),('무궁화호64','울산','07:00:00.000000'),('무궁화호67','울산','13:00:00.000000'),('무궁화호70','울산','17:00:00.000000'),('무궁화호73','울산','19:00:00.000000');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-26 14:43:00
