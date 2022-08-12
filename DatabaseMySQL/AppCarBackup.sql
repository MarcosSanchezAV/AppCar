CREATE DATABASE  IF NOT EXISTS `appcars` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `appcars`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: appcars
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_car` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `img` mediumtext,
  `type_car` varchar(45) NOT NULL,
  `available` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (2,'Chevrolet Tracker',4000,'https://cdn.motor1.com/images/mgl/jllY7k/s3/chevrolet-seeker-2.jpg','SUV',1),(3,'Nissan Kicks',3800,'https://cdn.motor1.com/images/mgl/JqLkM/s1/lanzamiento-nissan-kicks-sense-entrada-a-gama.jpg','SUV',1),(4,'Lamborghini Urus',9000,'https://img.automexico.com/2021/03/25/VleRj3I8/2-23be.jpg','SUV',1),(5,'Kia Seltos',4200,'https://www.kia.com/content/dam/kwcms/mx/es/images/showroom/2022/seltos/360/exterior/white-blackroof/WhiteAndBlack_0009.png','SUV',1),(6,'Mazda CX-30',4000,'https://www.elcarrocolombiano.com/wp-content/uploads/2020/02/20200206-MAZDA-CX-30-COLOMBIA-PRECIO-VERSIONES-CARACTERISTICAS-01A.jpg','SUV',1),(7,'Tesla Model 3',6200,'https://www.hibridosyelectricos.com/media/hibridos/images/2022/04/07/2022040714200420715.jpg','electric',1),(8,'Chevrolet Bolt EV',5700,'https://www.elcarrocolombiano.com/wp-content/uploads/2021/02/20210214-CHEVROLET-BOLT-2022-PORTADA.jpg','electric',1),(9,'Nissan Leaf',5500,'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/2018_Nissan_Leaf_Tekna_Front.jpg/1200px-2018_Nissan_Leaf_Tekna_Front.jpg','electric',1),(10,'Porsche Taycan',10200,'https://img.remediosdigitales.com/942760/porsche-taycan-4s-mexico_/1366_2000.jpeg','electric',1),(11,'Audi E-Tron',8700,'https://www.diariomotor.com/imagenes/2018/09/audi-e-tron-2018-28.jpg','electric',1),(12,'Ford F-150',7000,'https://img.remediosdigitales.com/292621/ford-f-150-2021-013/1366_2000.jpg','pickup',1),(13,'RAM 1500',7200,'https://img.remediosdigitales.com/0f16b8/ram-1500-10th-anniversary-edition-2022_1-1-/1366_2000.jpg','pickup',1),(14,'Chevrolet Silverado',7200,'https://img.remediosdigitales.com/59f922/2019-chevrolet-silverado-trailboss-1-1/840_560.jpg','pickup',1),(15,'GMC Sierra',7000,'https://www.gmc.com.mx/content/dam/gmc/na/mx/es/index/trucks/sierra-225-2022/gallery/01-images/2022-gmc-sierra-gal-01.jpg?imwidth=650','pickup',1),(16,'Toyota Tacoma',7700,'https://acnews.blob.core.windows.net/imgnews/large/NAZ_553a572bd5144eb9bc30671369b0cc83.jpg','pickup',1),(18,'Mazda 3',3200,'https://www.mazdausa.com/siteassets/vehicles/2022/mazda3-sedan/build-and-price/trims/ext.-360s/2.0/blue/e360-my22-mazda3-sedan-fwd-2--deepcrystalblue-000.jpg','sedan',1),(19,'Hyundai Elantra',3000,'https://img.automexico.com/2021/12/14/uWyVbJOA/hyundai-elantra-es-uno-de-los-sedanes-que-nos-ofre-0825.jpg','sedan',1),(20,'Nissan Sentra',3200,'https://upload.wikimedia.org/wikipedia/commons/3/3b/2020_Nissan_Sentra_SV%2C_front_10.22.20.jpg','sedan',1),(21,'Toyota Corolla',3000,'https://cdn.motor1.com/images/mgl/MB3LX/s1/lanzamiento-toyota-corolla-gr-sport.webp','sedan',1),(22,'Volkswagen Jetta',2700,'https://img.remediosdigitales.com/f8e25b/volkswagen-jetta-2022-precio-mexico_/1366_2000.jpg','sedan',1),(23,'Rolls Royce Phantom',14500,'https://cdn.motor1.com/images/mgl/MkWKMX/s1/one-off-rolls-royce-phantom-orchid.jpg','deluxe',1),(24,'Mercedes Clase S',12000,'https://img.remediosdigitales.com/49a909/mercedes-benz-clase-s-2021-precio-mexico_/840_560.jpeg','deluxe',1),(25,'Bentley Continental GT',13700,'https://motor.elpais.com/wp-content/uploads/2021/03/Continental-GT-Speed-25.jpg','deluxe',1),(26,'Maserati Quattroporte',11500,'https://maserati.scene7.com/is/image/maserati/maserati/international/ownership/update-2021/quattroporte-accessories/169/QP_hero_desktop.jpg?$1920x2000$&fit=constrain','deluxe',1),(27,'Lincoln Navigator',13500,'https://img.remediosdigitales.com/f23cb7/na1/840_560.jpg','deluxe',1),(28,'Ford Mustang GT',12500,'https://fotos.perfil.com/2020/04/06/ford-mustang-gt-50-935793.jpg','sport',1),(29,'Lamborghini Aventador',17500,'https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2019/model_detail/aventador/svj/2021/03_19/aventador_svj_s2.jpg','sport',1),(30,'Pagani Zonda',20000,'https://img.remediosdigitales.com/936064/pagani-zonda-riviera-subasta-201962878-1574935772_1/1366_2000.jpg','sport',1),(31,'Bugatti Veyron',18500,'https://upload.wikimedia.org/wikipedia/commons/c/c9/Bugatti_Veyron_16.4_%E2%80%93_Frontansicht_%281%29%2C_5._April_2012%2C_D%C3%BCsseldorf.jpg','sport',1),(32,'Audi R8',12500,'https://cdn.autobild.es/sites/navi.axelspringer.es/public/media/image/2021/05/rivales-audi-r8-2329767.jpg','sport',1);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_car` int NOT NULL,
  `date_start` varchar(45) NOT NULL,
  `date_end` varchar(45) NOT NULL,
  `delivered` tinyint(1) DEFAULT '0',
  `days` int NOT NULL,
  `amount` double NOT NULL,
  `name_user` varchar(45) NOT NULL,
  `email_user` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_car` (`id_car`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_car`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,16,'2022-08-05','2022-08-07',1,2,15400,'Marcos','marcos@gmail.com'),(2,7,'2022-08-06','2022-08-06',1,4,24800,'Daniel','daniel@outlook.com'),(3,2,'2022-08-10','2022-08-10',1,3,12000,'marcos','marcos@outlook.com'),(4,4,'2022-08-10','2022-08-10',1,2,18000,'Carlos','carlos@gmail.com'),(5,4,'2022-08-10','2022-08-12',1,2,18000,'Carlos','carlos2@gmail.com'),(6,12,'2022-08-10','2022-08-17',1,7,49000,'El lolo','lolo@lolo.com'),(7,12,'2022-08-10','2022-08-16',1,6,42000,'lolo2','lolo2@gmail.com'),(8,2,'2022-08-10','2022-08-11',1,1,4000,'Diego','diego@gmail.com'),(9,2,'2022-08-10','2022-08-12',1,2,8000,'diego2','diego2@gmail.com'),(10,2,'2022-08-10','2022-08-13',1,3,12000,'diego3','diego3@gmail.com'),(11,4,'2022-08-10','2022-08-11',1,1,9000,'Rene','rene@gmail.com'),(12,11,'2022-08-10','2022-08-14',1,4,34800,'rene2','rene2@gmail.com'),(13,7,'2022-08-10','2022-08-11',1,1,6200,'rene3','rene3@gmail.com'),(14,7,'2022-08-10','2022-08-12',1,2,12400,'rene3','rene3@gmail.com'),(15,7,'2022-08-10','2022-08-11',1,1,6200,'as','asd@gmail.com'),(16,7,'2022-08-10','2022-08-11',1,1,6200,'el chavo','chavo@gmail.com'),(17,12,'2022-08-10','2022-08-13',1,3,21000,'Marcos','marcos@gmail.com'),(18,30,'2022-08-11','2022-08-17',1,6,120000,'marcos','marcos2@gmail.com'),(19,4,'2022-08-11','2022-08-13',1,2,18000,'rene','rene@gmail.com'),(20,31,'2022-08-11','2022-08-14',1,3,55500,'Don Huayra','huayra@gmail.com'),(21,31,'2022-08-11','2022-08-12',1,1,18500,'',''),(22,31,'2022-08-11','2022-08-22',1,11,203500,'El Bicho','bicho@gmail.com'),(23,3,'2022-08-12','2022-08-13',1,1,3800,'Rene','rene@gmail.com'),(24,2,'2022-08-12','2022-08-13',1,1,4000,'Daniel','daniel@outlook.com'),(25,2,'2022-08-12','2022-08-13',1,1,4000,'Rene','rene@gmail.com');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-12  5:08:44
