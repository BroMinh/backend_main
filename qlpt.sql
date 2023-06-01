-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlpt1
-- ------------------------------------------------------
-- Server version	5.7.38-log

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `customer_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`customer_id`,`room_id`),
  KEY `FKdfcq46u083yahna8q9v1o7bbi` (`room_id`),
  CONSTRAINT `FK3ju4advx951d1p441fkb84ftd` FOREIGN KEY (`customer_id`) REFERENCES `customertb` (`customer_id`),
  CONSTRAINT `FKdfcq46u083yahna8q9v1o7bbi` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1),(12,1),(4,2),(9,2),(2,3),(7,4);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customertb`
--

DROP TABLE IF EXISTS `customertb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customertb` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_check_in` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `customer_date_of_birth` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `customer_identity_card` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `customer_number_of_day` int(11) DEFAULT NULL,
  `customer_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `customer_check_out` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertb`
--

LOCK TABLES `customertb` WRITE;
/*!40000 ALTER TABLE `customertb` DISABLE KEYS */;
INSERT INTO `customertb` VALUES (1,'12/01/2023','05/05/1998','9353286395',1,'Harold O\'Conner','20/01/2023'),(2,'05/01/2023','29/04/1999','8310840428',1,'Domingo Walsh','19/01/2023'),(3,'07/01/2023','15/06/1998','8353293852',1,'Evan Rodriguez','30/01/2023'),(4,'04/02/2023','19/12/1999','3168367303',1,'Laurie Kirlin','19/03/2023'),(5,'18/02/2023','08/02/1996','6527849825',1,'Stephen Streich','26/05/2023'),(6,'09/02/2023','02/12/1995','9447590743',1,'Monique Robel','12/04/2023'),(7,'23/02/2023','16/11/2000','5188662066',1,'Tracey Jacobs DVM','13/03/2023'),(8,'18/03/2023','25/20/1996','1378748639',1,'Mona Waelchi','02/04/2023'),(9,'14/03/2023','29/03/1998','1504398419',1,'Jay Erdman','28/04/2023'),(10,'17/04/2023','17/06/1993','7933566563',1,'Nina Stroman','15/05/2023'),(11,'05/05/2023','31/07/1994','3801121006',1,'Alexandra Smitham I','29/05/2023'),(12,'04/06/2021','03/12/2000','0935111435',133,'Milan Ajack','15/10/2021');
/*!40000 ALTER TABLE `customertb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_category` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `room_price` double DEFAULT NULL,
  `room_status` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'Cao cấp, giường đôi','P101',900000,'Sẵn sàng'),(2,'Cao cấp, giường đơn','P102',450000,'Đã thuê'),(3,'Thường, giường đôi','P103',500000,'Chưa sẵn sàng'),(4,'Thường, giường đơn','P104',250000,'Đã thuê'),(5,'Cao cấp, giường đơn','P105',450000,'Đã thuê'),(6,'Thường, giường đôi','P106',500000,'Sẵn sàng');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertb`
--

DROP TABLE IF EXISTS `usertb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertb` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `user_image` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_pass` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertb`
--

LOCK TABLES `usertb` WRITE;
/*!40000 ALTER TABLE `usertb` DISABLE KEYS */;
INSERT INTO `usertb` VALUES (1,'abc@gmail.com','picture1.jpg','abc','123456'),(2,'xyz@gmail.com','picture2.jpg','xyz','123456'),(3,'fsdfs','fdsf','dsaf','123213');
/*!40000 ALTER TABLE `usertb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-02  5:34:58
