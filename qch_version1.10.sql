-- MySQL dump 10.13  Distrib 5.5.13, for Win32 (x86)
--
-- Host: localhost    Database: wms
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(15) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `credentials_expired` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `account_enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `password_hint` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1j9d9a06i600gd43uu3km82jw` (`email`),
  UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (-3,'\0','\0','','Denver','US','80210','CO','\0','two_roles_user@appfuse.org','','Two Roles','User','$2a$10$bH/ssqW8OhkTlIso9/yakubYODUOmh.6m5HEJvcBq3t3VdBh7ebqO','Not a female kitty.','','two_roles_user',1,'http://raibledesigns.com'),(-2,'\0','\0','','Denver','US','80210','CO','\0','matt@raibledesigns.com','','Matt','Raible','$2a$10$bH/ssqW8OhkTlIso9/yakubYODUOmh.6m5HEJvcBq3t3VdBh7ebqO','Not a female kitty.订单','','admin',2,'http://raibledesigns.com'),(-1,'\0','\0','','Denver','US','80210','CO','\0','matt_raible@yahoo.com','','Tomcat','User','$2a$10$CnQVJ9bsWBjMpeSKrrdDEeuIptZxXrwtI6CZ/OgtNxhIgpKxXeT9y','A male kitty.','','user',1,'http://tomcat.apache.org'),(10,'\0','\0','','','','','','\0','wf@aa.com','','','','$2a$10$0biZZWJWZBOYGPpAvjRM9e2QvuhqI.WZGPTzeeIwRoOZd1tDNjNn.','123456','','wf',1,''),(11,'\0','\0','','','','','','\0','xtf@aa.com','','','','$2a$10$AIMlcgNgKl9peBbQ3jHWjetsG1maENuUW3L6WkeCaoFIk7XQCC5Tm','123456','','xtf',0,'');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enumeration`
--

DROP TABLE IF EXISTS `enumeration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enumeration` (
  `enum_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enum_type_id` bigint(20) DEFAULT NULL,
  `enum_code` varchar(20) DEFAULT NULL,
  `sequence_id` int(11) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `pinyin_name` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`enum_id`),
  KEY `FK_jr8` (`enum_type_id`),
  CONSTRAINT `FK_jr8` FOREIGN KEY (`enum_type_id`) REFERENCES `enumeration_type` (`enum_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumeration`
--

LOCK TABLES `enumeration` WRITE;
/*!40000 ALTER TABLE `enumeration` DISABLE KEYS */;
INSERT INTO `enumeration` VALUES (1,1,'default_price',0,'默认价格',NULL,NULL,NULL,NULL,NULL),(2,1,'day_price',1,'日价格','rjg',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `enumeration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enumeration_type`
--

DROP TABLE IF EXISTS `enumeration_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enumeration_type` (
  `enum_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_type_id` bigint(20) DEFAULT NULL,
  `has_table` int(11) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`enum_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumeration_type`
--

LOCK TABLES `enumeration_type` WRITE;
/*!40000 ALTER TABLE `enumeration_type` DISABLE KEYS */;
INSERT INTO `enumeration_type` VALUES (1,NULL,NULL,'商品价格类型',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `enumeration_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility` (
  `facility_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `facility_type_id` bigint(20) DEFAULT NULL,
  `owner_party_id` bigint(20) DEFAULT NULL,
  `facility_name` varchar(100) DEFAULT NULL,
  `geo_point_id` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`facility_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,NULL,NULL,1,'总部仓库','',NULL,NULL,NULL,NULL),(2,NULL,NULL,2,'开封尉氏县冷库','','2015-09-06 15:47:59',NULL,11,NULL),(3,NULL,NULL,5,'东莞客户仓库','','2015-09-07 11:05:00',NULL,11,NULL),(4,NULL,NULL,6,'深圳客户仓库','','2015-09-07 11:05:11',NULL,11,NULL);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_transition`
--

DROP TABLE IF EXISTS `facility_transition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_transition` (
  `facility_transition_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `facility_id` bigint(20) DEFAULT NULL,
  `in_out_type` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `num` decimal(13,2) DEFAULT NULL,
  `uom_id` bigint(20) DEFAULT NULL,
  `tran_date` date DEFAULT NULL,
  `biz_type` int(11) DEFAULT NULL,
  `biz_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`facility_transition_id`),
  KEY `FK_jr11` (`facility_id`),
  CONSTRAINT `FK_jr11` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`facility_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_transition`
--

LOCK TABLES `facility_transition` WRITE;
/*!40000 ALTER TABLE `facility_transition` DISABLE KEYS */;
INSERT INTO `facility_transition` VALUES (1,2,1,2,23.00,NULL,NULL,2,NULL,'2015-09-11 14:18:32',NULL,11,NULL),(2,2,-1,2,2.00,NULL,NULL,2,NULL,'2015-09-11 14:18:48',NULL,11,NULL),(3,2,1,1,23.00,NULL,'2015-09-11',2,NULL,'2015-09-11 14:21:33',NULL,11,NULL),(4,2,-1,1,11.50,NULL,'2015-09-21',1,30,'2015-09-21 16:01:54',NULL,11,NULL),(5,2,-1,1,11.50,NULL,'2015-09-21',1,31,'2015-09-21 16:01:54',NULL,11,NULL),(6,2,-1,2,10.50,NULL,'2015-09-21',1,32,'2015-09-21 16:01:54',NULL,11,NULL),(7,2,-1,2,10.50,NULL,'2015-09-21',1,33,'2015-09-21 16:01:54',NULL,11,NULL),(8,2,1,1,122.00,NULL,'2015-10-10',2,NULL,'2015-10-10 10:30:34',NULL,11,NULL),(9,2,1,2,21.00,NULL,'2015-10-10',2,NULL,'2015-10-10 10:30:40',NULL,11,NULL);
/*!40000 ALTER TABLE `facility_transition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party` (
  `party_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_type_id` varchar(20) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES (1,'party_group',0,'集团总部','2015-08-08 17:48:43',NULL,-2,NULL),(2,'party_group',0,'七彩虹河南中部','2015-08-08 18:33:34',NULL,-2,NULL),(3,'person',0,'王菲','2015-08-25 15:27:27',NULL,-2,NULL),(4,'party_group',0,'客户组','2015-09-03 23:33:36',NULL,-2,NULL),(5,'party_group',0,'东莞市场','2015-09-03 23:34:24',NULL,-2,NULL),(6,'party_group',0,'深圳市场','2015-09-03 23:34:44',NULL,-2,NULL),(7,'person',0,'谢霆锋','2015-09-05 19:45:04',NULL,10,NULL);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_group`
--

DROP TABLE IF EXISTS `party_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_group` (
  `pg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  `pinyin_name` varchar(50) DEFAULT NULL,
  `num_employees` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pg_id`),
  KEY `FK_jr3` (`party_id`),
  CONSTRAINT `FK_jr3` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_group`
--

LOCK TABLES `party_group` WRITE;
/*!40000 ALTER TABLE `party_group` DISABLE KEYS */;
INSERT INTO `party_group` VALUES (1,1,'集团总部',NULL,NULL,'中国中南海','',NULL,NULL,NULL,NULL),(2,2,'七彩虹河南中部',NULL,100,'尉氏县叮叮咚咚','123114',NULL,NULL,NULL,NULL),(3,4,'客户组','khz',NULL,'全国各地','',NULL,'2015-09-04 00:38:51',NULL,-2),(4,5,'东莞市场',NULL,NULL,'广州东莞市','',NULL,NULL,NULL,NULL),(5,6,'深圳市场',NULL,NULL,'深圳市','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `party_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_relationship`
--

DROP TABLE IF EXISTS `party_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_relationship` (
  `party_relationship_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_relationship_type_id` bigint(20) DEFAULT NULL,
  `party_id_from` bigint(20) DEFAULT NULL,
  `party_id_to` bigint(20) DEFAULT NULL,
  `role_type_id_from` bigint(20) DEFAULT NULL,
  `role_type_id_to` bigint(20) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `thru_date` date DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`party_relationship_id`),
  KEY `FK_jr9` (`party_relationship_type_id`),
  CONSTRAINT `FK_jr9` FOREIGN KEY (`party_relationship_type_id`) REFERENCES `party_relationship_type` (`party_relationship_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
INSERT INTO `party_relationship` VALUES (1,1,1,2,1,1,'2015-08-08',NULL,0,'2015-08-08 18:33:35',NULL,-2,NULL),(2,1,1,3,1,1,'2015-08-25',NULL,0,'2015-08-25 15:27:27',NULL,-2,NULL),(3,1,1,4,1,1,'2015-09-03',NULL,0,'2015-09-03 23:33:37',NULL,-2,NULL),(4,1,3,5,1,1,'2015-09-03',NULL,0,'2015-09-03 23:34:24',NULL,-2,NULL),(5,1,4,6,1,1,'2015-09-03',NULL,0,'2015-09-03 23:34:44',NULL,-2,NULL),(8,2,2,5,1,1,'2015-09-05',NULL,0,'2015-09-05 16:29:25',NULL,-2,NULL),(9,2,2,6,1,1,'2015-09-05',NULL,0,'2015-09-05 16:34:51',NULL,-2,NULL),(10,1,2,7,1,1,'2015-09-05',NULL,0,'2015-09-05 19:45:04',NULL,10,NULL);
/*!40000 ALTER TABLE `party_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_relationship_type`
--

DROP TABLE IF EXISTS `party_relationship_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_relationship_type` (
  `party_relationship_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `has_table` int(11) DEFAULT NULL,
  `party_relationship_name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role_type_valid_from` varchar(100) DEFAULT NULL,
  `role_type_valid_to` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`party_relationship_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship_type`
--

LOCK TABLES `party_relationship_type` WRITE;
/*!40000 ALTER TABLE `party_relationship_type` DISABLE KEYS */;
INSERT INTO `party_relationship_type` VALUES (1,NULL,NULL,'组织结构关系','组织结构上下级关系','1','1',NULL,NULL,NULL,NULL),(2,NULL,NULL,'供货商客户关系','供货商客户关系','1','1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `party_relationship_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_role`
--

DROP TABLE IF EXISTS `party_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_role` (
  `pr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `role_type_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `FK_jr4` (`role_type_id`),
  KEY `FK_jr6` (`party_id`),
  CONSTRAINT `FK_jr4` FOREIGN KEY (`role_type_id`) REFERENCES `role_type` (`role_type_id`),
  CONSTRAINT `FK_jr6` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
INSERT INTO `party_role` VALUES (1,1,1,'2015-08-08 17:48:43',NULL,-2,NULL),(2,2,1,'2015-08-08 18:33:35',NULL,-2,NULL),(3,3,1,'2015-08-25 15:27:27',NULL,-2,NULL),(4,4,1,'2015-09-03 23:33:37',NULL,-2,NULL),(5,5,1,'2015-09-03 23:34:24',NULL,-2,NULL),(6,6,1,'2015-09-03 23:34:44',NULL,-2,NULL),(7,7,1,'2015-09-05 19:45:04',NULL,10,NULL);
/*!40000 ALTER TABLE `party_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_user`
--

DROP TABLE IF EXISTS `party_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_user` (
  `party_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`party_user`),
  KEY `FK_jr5` (`party_id`),
  CONSTRAINT `FK_jr5` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_user`
--

LOCK TABLES `party_user` WRITE;
/*!40000 ALTER TABLE `party_user` DISABLE KEYS */;
INSERT INTO `party_user` VALUES (1,3,10,NULL,NULL,NULL,NULL),(2,7,11,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `party_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pinyin_name` varchar(50) DEFAULT NULL,
  `personal_title` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `card_id` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FK_jr7` (`party_id`),
  CONSTRAINT `FK_jr7` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,3,'王菲','wf','','2','423','12',NULL,'2015-09-04 00:41:19',NULL,-2),(2,7,'谢霆锋','xtf','','','','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `price_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `party_id` bigint(20) DEFAULT NULL,
  `from_date` datetime DEFAULT NULL,
  `thru_date` datetime DEFAULT NULL,
  `price_type` varchar(30) DEFAULT NULL,
  `price` decimal(18,3) DEFAULT NULL,
  `price_uom_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`price_id`),
  KEY `FK_jr10` (`product_id`),
  CONSTRAINT `FK_jr10` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,1,NULL,NULL,NULL,'1',203.000,NULL,'2015-08-29 14:22:20','2015-09-26 17:59:25',-2,11),(2,2,NULL,NULL,NULL,'1',120.000,NULL,'2015-08-29 14:22:45','2015-09-04 00:46:49',-2,-2),(3,1,5,'2015-08-31 00:00:00',NULL,'2',204.000,NULL,'2015-09-05 23:37:53',NULL,11,NULL),(4,2,6,'2015-09-01 00:00:00',NULL,'2',130.000,NULL,'2015-09-05 23:38:35',NULL,11,NULL),(5,1,5,'2015-10-06 00:00:00',NULL,'2',123.000,NULL,'2015-10-10 10:20:59',NULL,11,NULL);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `pinyin_name` varchar(50) DEFAULT NULL,
  `weight` decimal(18,2) DEFAULT NULL,
  `stand_uom_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'芥兰','jl',21.00,1,NULL,NULL,NULL,NULL),(2,'奶白菜','nbc',40.00,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reap_dtl`
--

DROP TABLE IF EXISTS `reap_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reap_dtl` (
  `reap_dtl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reap_party_id` bigint(20) DEFAULT NULL,
  `reap_for_party_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `num` decimal(13,2) DEFAULT NULL,
  `uom_id` bigint(20) DEFAULT NULL,
  `reap_date` date DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`reap_dtl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reap_dtl`
--

LOCK TABLES `reap_dtl` WRITE;
/*!40000 ALTER TABLE `reap_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `reap_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (-2,'Default role for all Users','ROLE_USER'),(-1,'Administrator role (can edit Users)','ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_type`
--

DROP TABLE IF EXISTS `role_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_type` (
  `role_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `has_table` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_type`
--

LOCK TABLES `role_type` WRITE;
/*!40000 ALTER TABLE `role_type` DISABLE KEYS */;
INSERT INTO `role_type` VALUES (1,NULL,NULL,'组织构架成员',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_plan`
--

DROP TABLE IF EXISTS `sale_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_plan` (
  `sale_plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `facility_id` bigint(20) DEFAULT NULL,
  `plan_name` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sale_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_plan`
--

LOCK TABLES `sale_plan` WRITE;
/*!40000 ALTER TABLE `sale_plan` DISABLE KEYS */;
INSERT INTO `sale_plan` VALUES (7,2,'','2015-09-03','',2,'2015-09-07 11:17:32','2015-09-07 18:15:02',11,11),(8,2,'','2015-09-11','12',2,'2015-09-11 14:22:27','2015-09-21 15:52:55',11,11),(9,2,'','2015-09-22','',2,'2015-09-21 15:32:36','2015-09-21 15:49:49',11,11),(10,2,'','2015-09-23','ssdf',2,'2015-09-21 15:54:03','2015-09-21 15:55:04',11,11),(11,2,'','2015-09-24','',2,'2015-09-21 15:57:37','2015-09-21 15:57:59',11,11),(12,2,'','2015-09-25','',2,'2015-09-21 16:01:54','2015-09-21 16:02:10',11,11);
/*!40000 ALTER TABLE `sale_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_plan_dtl`
--

DROP TABLE IF EXISTS `sale_plan_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_plan_dtl` (
  `sale_plan_dtl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sale_plan_id` bigint(20) DEFAULT NULL,
  `facility_id_from` bigint(20) DEFAULT NULL,
  `facility_id_to` bigint(20) DEFAULT NULL,
  `to_sequence_id` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `num` decimal(13,2) DEFAULT NULL,
  `uom_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sale_plan_dtl_id`),
  KEY `FK_jr14` (`sale_plan_id`),
  CONSTRAINT `FK_jr14` FOREIGN KEY (`sale_plan_id`) REFERENCES `sale_plan` (`sale_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_plan_dtl`
--

LOCK TABLES `sale_plan_dtl` WRITE;
/*!40000 ALTER TABLE `sale_plan_dtl` DISABLE KEYS */;
INSERT INTO `sale_plan_dtl` VALUES (1,7,2,3,0,1,12.00,NULL,'2015-09-07 11:17:32','2015-09-07 16:16:38',11,11),(2,7,2,4,1,1,0.00,NULL,'2015-09-07 11:17:32',NULL,11,NULL),(3,7,2,3,0,2,20.00,NULL,'2015-09-07 11:17:32','2015-09-07 16:16:17',11,11),(4,7,2,4,1,2,0.00,NULL,'2015-09-07 11:17:32',NULL,11,NULL),(5,8,2,3,0,1,1.00,NULL,'2015-09-11 14:22:27','2015-09-11 14:26:19',11,11),(6,8,2,4,1,1,22.00,NULL,'2015-09-11 14:22:27','2015-09-11 14:26:09',11,11),(7,8,2,3,0,2,10.50,NULL,'2015-09-11 14:22:27',NULL,11,NULL),(8,8,2,4,1,2,10.50,NULL,'2015-09-11 14:22:27',NULL,11,NULL),(9,9,2,3,0,1,11.00,NULL,'2015-09-21 15:32:36','2015-09-21 15:34:31',11,11),(10,9,2,4,1,1,12.00,NULL,'2015-09-21 15:32:36','2015-09-21 15:34:25',11,11),(11,9,2,3,0,2,1.00,NULL,'2015-09-21 15:32:36','2015-09-21 15:34:04',11,11),(12,9,2,4,1,2,20.00,NULL,'2015-09-21 15:32:36','2015-09-21 15:33:59',11,11),(13,10,2,3,0,1,15.00,NULL,'2015-09-21 15:54:03','2015-09-21 15:54:26',11,11),(14,10,2,4,1,1,8.00,NULL,'2015-09-21 15:54:03','2015-09-21 15:54:44',11,11),(15,10,2,3,0,2,2.00,NULL,'2015-09-21 15:54:03','2015-09-21 15:54:11',11,11),(16,10,2,4,1,2,19.00,NULL,'2015-09-21 15:54:03','2015-09-21 15:54:20',11,11),(17,11,2,3,0,1,11.50,NULL,'2015-09-21 15:57:37',NULL,11,NULL),(18,11,2,4,1,1,11.50,NULL,'2015-09-21 15:57:37',NULL,11,NULL),(19,11,2,3,0,2,10.50,NULL,'2015-09-21 15:57:37',NULL,11,NULL),(20,11,2,4,1,2,10.50,NULL,'2015-09-21 15:57:37',NULL,11,NULL),(21,12,2,3,0,1,11.50,NULL,'2015-09-21 16:01:54',NULL,11,NULL),(22,12,2,4,1,1,11.50,NULL,'2015-09-21 16:01:54',NULL,11,NULL),(23,12,2,3,0,2,10.50,NULL,'2015-09-21 16:01:54',NULL,11,NULL),(24,12,2,4,1,2,10.50,NULL,'2015-09-21 16:01:54',NULL,11,NULL);
/*!40000 ALTER TABLE `sale_plan_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship_car`
--

DROP TABLE IF EXISTS `ship_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ship_car` (
  `ship_car_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_card_id` varchar(30) DEFAULT NULL,
  `con_name` varchar(30) DEFAULT NULL,
  `con_phone` varchar(20) DEFAULT NULL,
  `type_name` varchar(30) DEFAULT NULL,
  `load_weight` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ship_car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship_car`
--

LOCK TABLES `ship_car` WRITE;
/*!40000 ALTER TABLE `ship_car` DISABLE KEYS */;
INSERT INTO `ship_car` VALUES (1,'豫N FK111','贷款的可','1213123','123','1110'),(2,'豫A FK111','复苏','钱23','32','323223');
/*!40000 ALTER TABLE `ship_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `shipment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sale_plan_id` bigint(20) DEFAULT NULL,
  `ship_car_id` bigint(20) DEFAULT NULL,
  `facility_id_from` bigint(20) DEFAULT NULL,
  `facility_id_to` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `num` decimal(13,2) DEFAULT NULL,
  `uom_id` bigint(20) DEFAULT NULL,
  `ship_date` date DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`shipment_id`),
  KEY `FK_jr13` (`sale_plan_id`),
  KEY `FK_jr15` (`ship_car_id`),
  CONSTRAINT `FK_jr13` FOREIGN KEY (`sale_plan_id`) REFERENCES `sale_plan` (`sale_plan_id`),
  CONSTRAINT `FK_jr15` FOREIGN KEY (`ship_car_id`) REFERENCES `ship_car` (`ship_car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,7,NULL,2,3,1,12.00,NULL,'2015-09-08','2015-09-07 11:17:32','2015-09-07 16:16:38',11,11),(2,7,2,2,4,1,12.00,NULL,'2015-09-08','2015-09-07 11:17:32','2015-09-07 17:53:25',11,11),(3,7,NULL,2,3,2,23.00,NULL,'2015-09-08','2015-09-07 11:17:32','2015-09-07 17:26:24',11,11),(4,7,NULL,2,4,2,13.00,NULL,'2015-09-08','2015-09-07 11:17:32','2015-09-07 17:26:30',11,11),(5,8,NULL,2,3,1,1.00,NULL,'2015-09-21','2015-09-11 14:22:27','2015-09-11 14:26:19',11,11),(6,8,NULL,2,4,1,22.00,NULL,'2015-09-21','2015-09-11 14:22:27','2015-09-11 14:26:09',11,11),(7,8,NULL,2,3,2,10.50,NULL,'2015-09-21','2015-09-11 14:22:27',NULL,11,NULL),(8,8,NULL,2,4,2,10.50,NULL,'2015-09-21','2015-09-11 14:22:27',NULL,11,NULL),(9,9,1,2,3,1,11.00,NULL,'2015-09-21','2015-09-21 15:32:36','2015-09-21 15:49:38',11,11),(10,9,1,2,4,1,12.00,NULL,'2015-09-21','2015-09-21 15:32:36','2015-09-21 15:49:46',11,11),(11,9,1,2,3,2,1.00,NULL,'2015-09-21','2015-09-21 15:32:36','2015-09-21 15:49:41',11,11),(12,9,1,2,4,2,20.00,NULL,'2015-09-21','2015-09-21 15:32:36','2015-09-21 15:49:44',11,11),(16,10,NULL,2,3,1,15.00,NULL,'2015-09-21','2015-09-21 15:54:03','2015-09-21 15:54:26',11,11),(17,10,NULL,2,4,1,8.00,NULL,'2015-09-21','2015-09-21 15:54:03','2015-09-21 15:54:44',11,11),(18,10,NULL,2,3,2,2.00,NULL,'2015-09-21','2015-09-21 15:54:03','2015-09-21 15:54:11',11,11),(19,10,NULL,2,4,2,19.00,NULL,'2015-09-21','2015-09-21 15:54:03','2015-09-21 15:54:20',11,11),(23,11,NULL,2,3,1,11.50,NULL,'2015-09-21','2015-09-21 15:57:37',NULL,11,NULL),(24,11,NULL,2,4,1,11.50,NULL,'2015-09-21','2015-09-21 15:57:37',NULL,11,NULL),(25,11,NULL,2,3,2,10.50,NULL,'2015-09-21','2015-09-21 15:57:37',NULL,11,NULL),(26,11,NULL,2,4,2,10.50,NULL,'2015-09-21','2015-09-21 15:57:37',NULL,11,NULL),(30,12,NULL,2,3,1,11.50,NULL,'2015-09-21','2015-09-21 16:01:54',NULL,11,NULL),(31,12,NULL,2,4,1,11.50,NULL,'2015-09-21','2015-09-21 16:01:54',NULL,11,NULL),(32,12,NULL,2,3,2,10.50,NULL,'2015-09-21','2015-09-21 16:01:54',NULL,11,NULL),(33,12,NULL,2,4,2,10.50,NULL,'2015-09-21','2015-09-21 16:01:54',NULL,11,NULL);
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_item`
--

DROP TABLE IF EXISTS `status_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_item` (
  `status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_type_id` bigint(20) DEFAULT NULL,
  `status_code` varchar(20) DEFAULT NULL,
  `sequence_id` int(11) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`status_id`),
  KEY `FK_jr2` (`status_type_id`),
  CONSTRAINT `FK_jr2` FOREIGN KEY (`status_type_id`) REFERENCES `status_type` (`status_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_item`
--

LOCK TABLES `status_item` WRITE;
/*!40000 ALTER TABLE `status_item` DISABLE KEYS */;
INSERT INTO `status_item` VALUES (1,1,'',NULL,'未出库','2015-09-06 11:55:12',NULL,11,NULL),(2,1,'',NULL,'已出库','2015-09-06 11:55:23',NULL,11,NULL);
/*!40000 ALTER TABLE `status_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_type`
--

DROP TABLE IF EXISTS `status_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_type` (
  `status_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `has_table` int(11) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `sequence_id` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`status_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_type`
--

LOCK TABLES `status_type` WRITE;
/*!40000 ALTER TABLE `status_type` DISABLE KEYS */;
INSERT INTO `status_type` VALUES (1,NULL,NULL,'出库计划状态',NULL,'2015-09-06 11:54:48',NULL,11,NULL);
/*!40000 ALTER TABLE `status_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_valid_change`
--

DROP TABLE IF EXISTS `status_valid_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_valid_change` (
  `svc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_id_from` bigint(20) DEFAULT NULL,
  `status_id_to` bigint(20) DEFAULT NULL,
  `condition_expression` varchar(30) DEFAULT NULL,
  `transition_name` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`svc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_valid_change`
--

LOCK TABLES `status_valid_change` WRITE;
/*!40000 ALTER TABLE `status_valid_change` DISABLE KEYS */;
/*!40000 ALTER TABLE `status_valid_change` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom`
--

DROP TABLE IF EXISTS `uom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom` (
  `uom_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uom_type_id` bigint(20) DEFAULT NULL,
  `abbreviation` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `pinyin_name` varchar(50) DEFAULT NULL,
  `sequence_id` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uom_id`),
  KEY `FK_jr1` (`uom_type_id`),
  CONSTRAINT `FK_jr1` FOREIGN KEY (`uom_type_id`) REFERENCES `uom_type` (`uom_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom`
--

LOCK TABLES `uom` WRITE;
/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
INSERT INTO `uom` VALUES (1,1,'Kg','千克','qk',NULL,NULL,NULL,NULL,NULL),(2,1,'g','克',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom_conversion`
--

DROP TABLE IF EXISTS `uom_conversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom_conversion` (
  `uom_conversion_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uom_id_from` bigint(20) DEFAULT NULL,
  `uom_id_to` bigint(20) DEFAULT NULL,
  `conversion_factor` double DEFAULT NULL,
  `rounding_mode` varchar(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uom_conversion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom_conversion`
--

LOCK TABLES `uom_conversion` WRITE;
/*!40000 ALTER TABLE `uom_conversion` DISABLE KEYS */;
INSERT INTO `uom_conversion` VALUES (1,1,2,1000,'',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `uom_conversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom_type`
--

DROP TABLE IF EXISTS `uom_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom_type` (
  `uom_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `has_table` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uom_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom_type`
--

LOCK TABLES `uom_type` WRITE;
/*!40000 ALTER TABLE `uom_type` DISABLE KEYS */;
INSERT INTO `uom_type` VALUES (1,NULL,NULL,'重量',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `uom_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (-3,-2),(-1,-2),(-3,-1),(-2,-1),(10,-1),(11,-1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-10 10:46:39
