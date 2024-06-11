-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `itemId` int NOT NULL AUTO_INCREMENT,
  `bussinessManId` varchar(45) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `itemType` varchar(45) NOT NULL,
  `itemPrice` int NOT NULL,
  `itemCount` int NOT NULL,
  `itemManufacturingDate` date DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `Item_BussinessManId_FK_idx` (`bussinessManId`),
  CONSTRAINT `Item_BussinessManId_FK` FOREIGN KEY (`bussinessManId`) REFERENCES `bussinessman` (`bussinessManId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (89,'1000','노트북','전자제품',1000000,10,'2023-01-15'),(90,'1000','스마트폰','전자제품',800000,15,'2023-02-20'),(91,'1000','키보드','주변기기',50000,20,'2023-03-10'),(92,'1000','마우스','주변기기',20000,30,'2023-04-05'),(93,'1000','헤드셋','주변기기',60000,25,'2023-05-12'),(94,'1000','컴퓨터 모니터','주변기기',300000,12,'2023-06-18'),(95,'1000','프린터','주변기기',150000,8,'2023-07-25'),(96,'1000','USB 메모리','주변기기',20000,50,'2023-08-30'),(97,'1000','노트북 가방','액세서리',50000,20,'2023-09-05'),(98,'1000','마우스 패드','액세서리',10000,40,'2023-10-10'),(99,'1000','볼펜','문구',1000,100,'2023-11-15'),(100,'1000','다이어리','문구',20000,30,'2023-12-20'),(101,'1000','데스크 램프','가구',30000,15,'2024-01-25'),(102,'1000','사무용 의자','가구',200000,10,'2024-02-28'),(103,'1000','서랍장','가구',150000,8,'2024-03-05'),(104,'1000','책상','가구',100000,12,'2024-04-10'),(105,'1000','휴지통','가구',5000,20,'2024-05-15'),(106,'1000','수납 박스','가구',30000,25,'2024-06-20'),(107,'1000','빔 프로젝터','전자제품',500000,5,'2024-07-25'),(109,'1000','노트북','전자제품',1000000,10,'2023-01-15'),(110,'1000','스마트폰','전자제품',800000,15,'2023-02-20'),(111,'1000','키보드','주변기기',50000,20,'2023-03-10'),(112,'1000','마우스','주변기기',20000,30,'2023-04-05'),(113,'1000','헤드셋','주변기기',60000,25,'2023-05-12'),(114,'1000','컴퓨터 모니터','주변기기',300000,12,'2023-06-18'),(115,'1000','프린터','주변기기',150000,8,'2023-07-25'),(116,'1000','USB 메모리','주변기기',20000,50,'2023-08-30'),(117,'1000','노트북 가방','액세서리',50000,20,'2023-09-05'),(118,'1000','마우스 패드','액세서리',10000,40,'2023-10-10'),(119,'1000','볼펜','문구',1000,100,'2023-11-15'),(120,'1000','다이어리','문구',20000,30,'2023-12-20'),(121,'1000','데스크 램프','가구',30000,15,'2024-01-25'),(122,'1000','사무용 의자','가구',200000,10,'2024-02-28'),(123,'1000','서랍장','가구',150000,8,'2024-03-05'),(124,'1000','책상','가구',100000,12,'2024-04-10'),(125,'1000','휴지통','가구',5000,20,'2024-05-15'),(126,'1000','수납 박스','가구',30000,25,'2024-06-20'),(127,'1000','빔 프로젝터','전자제품',500000,5,'2024-07-25'),(129,'1000','iPhone 12','Phone',1000000,10,'2023-05-15'),(130,'1000','Galaxy S20','Phone',900000,8,'2023-06-20'),(131,'1000','MacBook Pro 2022','Laptop',2000000,5,'2023-07-10'),(132,'1000','AirPods Pro','Earphones',250000,15,'2023-08-05'),(133,'1000','iPad Air','Tablet',800000,12,'2023-09-15'),(134,'1000','Samsung Odyssey G9','Monitor',1500000,3,'2023-10-20'),(135,'1000','Canon EOS R5','Camera',3000000,7,'2023-11-25'),(136,'1000','Sony WH-1000XM4','Headphones',350000,10,'2023-12-01'),(137,'1000','DJI Mavic Air 2','Drone',1200000,6,'2024-01-10'),(138,'1000','Nintendo Switch','Game Console',400000,9,'2024-02-15'),(139,'1001','Samsung Galaxy Note 20','Phone',1100000,10,'2023-05-15'),(140,'1001','MacBook Air','Laptop',1500000,8,'2023-06-20'),(141,'1001','Sony WH-1000XM4','Headphones',350000,5,'2023-07-10'),(142,'1001','iPad Pro','Tablet',1200000,15,'2023-08-05'),(143,'1001','LG C1 OLED','TV',2000000,12,'2023-09-15'),(144,'1001','Canon EOS R6','Camera',2500000,3,'2023-10-20'),(145,'1001','DJI Mini 2','Drone',800000,7,'2023-11-25'),(146,'1001','Nintendo Switch OLED','Game Console',450000,10,'2023-12-01'),(147,'1001','Bose QuietComfort 45','Headphones',400000,6,'2024-01-10'),(148,'1001','GoPro Hero 10','Action Camera',900000,9,'2024-02-15'),(149,'1001','Xiaomi Mi 11','Phone',800000,10,'2024-03-20'),(150,'1001','Microsoft Surface Pro 8','Tablet',1800000,8,'2024-04-05'),(151,'1001','Sony A7 IV','Camera',3000000,5,'2024-05-10'),(152,'1001','JBL Flip 6','Bluetooth Speaker',200000,12,'2024-06-15'),(153,'1001','Apple Watch Series 7','Smartwatch',500000,15,'2024-07-20'),(154,'1001','Samsung Odyssey Neo G9','Monitor',2500000,3,'2024-08-25'),(155,'1001','Logitech G Pro X Superlight','Gaming Mouse',150000,7,'2024-09-01'),(156,'1001','Google Pixel 6 Pro','Phone',1000000,10,'2024-10-10'),(157,'1001','Bose SoundLink Flex','Portable Speaker',250000,6,'2024-11-15'),(158,'1001','Canon EOS RP','Mirrorless Camera',1200000,9,'2024-12-20'),(159,'1000','테스트아이템','의류',1000,1000,'2024-05-02'),(160,'1000','쿠키','가전',20,20,'2024-04-11');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-03 17:24:28
