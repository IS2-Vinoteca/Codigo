-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: is2-bbdd-vinoteca
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
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `producto` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `incidencia` varchar(45) DEFAULT NULL,
  `detalles_incidencia` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'2024-04-01','Vino tinto',5,25.99,'Resuelta',NULL),(2,'2024-04-02','Vino blanco',3,19.99,'Abierta','Rotura en el embalaje'),(3,'2024-04-03','Cerveza artesanal',10,8.49,'Resuelta',NULL),(4,'2024-04-04','Whisky escocés',2,39.99,'Abierta','Entrega tardía'),(5,'2024-04-05','Ron añejo',4,29.99,'Resuelta',NULL),(6,'2024-04-06','Ginebra premium',1,49.99,'Resuelta',NULL),(7,'2024-04-07','Tequila reposado',3,34.99,'Resuelta',NULL),(8,'2024-04-08','Vodka de lujo',6,21.99,'Abierta','Botella rota'),(9,'2024-04-09','Licor de café',2,14.99,'Resuelta',NULL),(10,'2024-04-10','Champagne brut',1,59.99,'Abierta','prueba2'),(11,'2024-04-01','La Faraona Bierzo (Corullon) 2010',5,3119.08,'Resuelta',NULL),(12,'2024-04-02','Unico 1965',3,2884.04,'Abierta','Rotura en el embalaje'),(13,'2024-04-03','Termanthia 2004',10,2814.16,'Resuelta',NULL),(14,'2024-04-04','L\'Ermita Velles Vinyes Priorat 2010',2,2750.00,'Abierta','Entrega tardía'),(15,'2024-04-05','L\'Ermita Velles Vinyes Priorat 2011',4,2750.00,'Resuelta',NULL),(16,'2024-04-06','Unico 1968',1,2087.25,'Abierta','prueba'),(17,'2024-04-07','Pingus 2005',3,1785.96,'Resuelta',NULL),(18,'2024-04-08','Pingus 1996',6,1746.94,'Abierta','Botella rota'),(19,'2024-04-09','Pingus 1999',2,1715.18,'Resuelta',''),(20,'2024-04-10','L\'Ermita Velles Vinyes Priorat 2014',1,1660.00,'Resuelta',NULL);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-20 17:49:58
