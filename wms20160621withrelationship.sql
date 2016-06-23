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
-- Table structure for table `alarm_set`
--

DROP TABLE IF EXISTS `alarm_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alarm_set` (
  `alarm_set_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kpi_id` varchar(20) DEFAULT NULL,
  `kpi_name` varchar(50) DEFAULT NULL,
  `alarm_level` varchar(30) DEFAULT NULL,
  `max_value` varchar(100) DEFAULT NULL,
  `min_value` varchar(100) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`alarm_set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarm_set`
--

LOCK TABLES `alarm_set` WRITE;
/*!40000 ALTER TABLE `alarm_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `alarm_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerer`
--

DROP TABLE IF EXISTS `answerer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerer` (
  `answerer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer_person` varchar(50) DEFAULT NULL,
  `answer_phone` varchar(20) DEFAULT NULL,
  `answer_identify_id` varchar(20) DEFAULT NULL,
  `answer_pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`answerer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerer`
--

LOCK TABLES `answerer` WRITE;
/*!40000 ALTER TABLE `answerer` DISABLE KEYS */;
INSERT INTO `answerer` VALUES (1,NULL,NULL,NULL,NULL),(2,'asdf','15825283821','afsd',NULL),(3,'阿斯蒂芬','15828281838','订单',NULL);
/*!40000 ALTER TABLE `answerer` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (-3,'\0','\0','','Denver','US','80210','CO','\0','two_roles_user@appfuse.org','','Two Roles','User','$2a$10$bH/ssqW8OhkTlIso9/yakubYODUOmh.6m5HEJvcBq3t3VdBh7ebqO','Not a female kitty.','','two_roles_user',2,'http://raibledesigns.com'),(-2,'\0','\0','','Denver','US','80210','CO','\0','matt@raibledesigns.com','','Matt','Raible','$2a$10$bH/ssqW8OhkTlIso9/yakubYODUOmh.6m5HEJvcBq3t3VdBh7ebqO','Not a female kitty.','','admin',1,'http://raibledesigns.com'),(-1,'\0','\0','','Denver','US','80210','CO','\0','matt_raible@yahoo.com','','Tomcat','User','$2a$10$CnQVJ9bsWBjMpeSKrrdDEeuIptZxXrwtI6CZ/OgtNxhIgpKxXeT9y','A male kitty.','','user',1,'http://tomcat.apache.org');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approval_proj`
--

DROP TABLE IF EXISTS `approval_proj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `approval_proj` (
  `approval_proj_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `proj_name` varchar(50) DEFAULT NULL,
  `proj_material` varchar(500) DEFAULT NULL,
  `proj_procedure` varchar(500) DEFAULT NULL,
  `time_limit` varchar(50) DEFAULT NULL,
  `charge_standard` varchar(50) DEFAULT NULL,
  `connect_person` varchar(50) DEFAULT NULL,
  `connect_phone` varchar(20) DEFAULT NULL,
  `place_name` varchar(50) DEFAULT NULL,
  `place_address` varchar(255) DEFAULT NULL,
  `traffic_way` varchar(255) DEFAULT NULL,
  `office_hour` varchar(255) DEFAULT NULL,
  `statis_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`approval_proj_id`),
  KEY `FK_jr22` (`party_id`),
  CONSTRAINT `FK_jr22` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approval_proj`
--

LOCK TABLES `approval_proj` WRITE;
/*!40000 ALTER TABLE `approval_proj` DISABLE KEYS */;
/*!40000 ALTER TABLE `approval_proj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cp_charge`
--

DROP TABLE IF EXISTS `cp_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cp_charge` (
  `cp_charge_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cp_title` varchar(50) DEFAULT NULL,
  `oper_type` bigint(20) DEFAULT NULL,
  `account_type` bigint(20) DEFAULT NULL,
  `party_id` bigint(20) DEFAULT NULL,
  `io_type` int(11) DEFAULT NULL,
  `balance` decimal(16,2) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `relate_party_id` bigint(20) DEFAULT NULL,
  `oper_people` varchar(30) DEFAULT NULL,
  `relate_account_type` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cp_charge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cp_charge`
--

LOCK TABLES `cp_charge` WRITE;
/*!40000 ALTER TABLE `cp_charge` DISABLE KEYS */;
INSERT INTO `cp_charge` VALUES (2,'快点看看我i',22,26,570,1,3500.00,'2322三大gas的gas的gas大苏打we范德萨gas',151,'黄晓明',26,'2016-03-16 21:32:32',2,NULL,NULL),(3,'ask的法律框架',22,26,2,1,3500.00,'啊但是gas地方撒旦',570,'黄晓明',26,'2016-03-16 21:35:29',2,NULL,NULL),(4,'ask的法律框架',23,26,570,-1,3500.00,'啊但是gas地方撒旦',2,'黄晓明',26,'2016-03-16 21:35:29',2,NULL,NULL),(5,'苏打粉',22,26,570,1,2400.00,'电饭锅感冒还没发货',157,'黄晓明',26,'2016-03-16 23:10:57',2,NULL,NULL);
/*!40000 ALTER TABLE `cp_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cp_dtl`
--

DROP TABLE IF EXISTS `cp_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cp_dtl` (
  `cp_dtl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `be_party_date` varchar(20) DEFAULT NULL,
  `positive_date` varchar(20) DEFAULT NULL,
  `be_party_zhibu` varchar(50) DEFAULT NULL,
  `be_here_date` varchar(20) DEFAULT NULL,
  `out_of_zhibu` varchar(50) DEFAULT NULL,
  `party_status` varchar(100) DEFAULT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  `work_group` varchar(100) DEFAULT NULL,
  `work_status` varchar(100) DEFAULT NULL,
  `household_address` varchar(100) DEFAULT NULL,
  `flow_out_date` varchar(20) DEFAULT NULL,
  `flow_out_info` varchar(100) DEFAULT NULL,
  `is_have_flow_card` varchar(20) DEFAULT NULL,
  `flow_card_num` varchar(20) DEFAULT NULL,
  `flow_in_group` varchar(50) DEFAULT NULL,
  `flow_in_group_person` varchar(50) DEFAULT NULL,
  `flow_in_group_phone` varchar(20) DEFAULT NULL,
  `party_group_type` varchar(20) DEFAULT NULL,
  `out_country_date` varchar(20) DEFAULT NULL,
  `out_country_reason` varchar(255) DEFAULT NULL,
  `out_country_connect` varchar(255) DEFAULT NULL,
  `out_country_dangji` varchar(20) DEFAULT NULL,
  `out_country_backdate` varchar(20) DEFAULT NULL,
  `out_country_backlife` varchar(255) DEFAULT NULL,
  `r_title1` varchar(20) DEFAULT NULL,
  `r_title2` varchar(20) DEFAULT NULL,
  `r_title3` varchar(20) DEFAULT NULL,
  `r_title4` varchar(20) DEFAULT NULL,
  `r_title5` varchar(20) DEFAULT NULL,
  `r_title6` varchar(20) DEFAULT NULL,
  `r_name1` varchar(20) DEFAULT NULL,
  `r_name2` varchar(20) DEFAULT NULL,
  `r_name3` varchar(20) DEFAULT NULL,
  `r_name4` varchar(20) DEFAULT NULL,
  `r_name5` varchar(20) DEFAULT NULL,
  `r_name6` varchar(20) DEFAULT NULL,
  `r_age1` varchar(20) DEFAULT NULL,
  `r_age2` varchar(20) DEFAULT NULL,
  `r_age3` varchar(20) DEFAULT NULL,
  `r_age4` varchar(20) DEFAULT NULL,
  `r_age5` varchar(20) DEFAULT NULL,
  `r_age6` varchar(20) DEFAULT NULL,
  `r_social1` varchar(20) DEFAULT NULL,
  `r_social2` varchar(20) DEFAULT NULL,
  `r_social3` varchar(20) DEFAULT NULL,
  `r_social4` varchar(20) DEFAULT NULL,
  `r_social5` varchar(20) DEFAULT NULL,
  `r_social6` varchar(20) DEFAULT NULL,
  `r_worke_company1` varchar(50) DEFAULT NULL,
  `r_worke_company2` varchar(50) DEFAULT NULL,
  `r_worke_company3` varchar(50) DEFAULT NULL,
  `r_worke_company4` varchar(50) DEFAULT NULL,
  `r_worke_company5` varchar(50) DEFAULT NULL,
  `r_worke_company6` varchar(50) DEFAULT NULL,
  `r_worke_satus1` varchar(50) DEFAULT NULL,
  `r_worke_satus2` varchar(50) DEFAULT NULL,
  `r_worke_satus3` varchar(50) DEFAULT NULL,
  `r_worke_satus4` varchar(50) DEFAULT NULL,
  `r_worke_satus5` varchar(50) DEFAULT NULL,
  `r_worke_satus6` varchar(50) DEFAULT NULL,
  `rdzys` varchar(10) DEFAULT NULL,
  `rdsqs` varchar(10) DEFAULT NULL,
  `zzsccl` varchar(10) DEFAULT NULL,
  `zzsqs` varchar(10) DEFAULT NULL,
  `pykccl` varchar(10) DEFAULT NULL,
  `other_cl` varchar(50) DEFAULT NULL,
  `keep_unit` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cp_dtl_id`),
  KEY `FK_jr23` (`party_id`),
  CONSTRAINT `FK_jr23` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cp_dtl`
--

LOCK TABLES `cp_dtl` WRITE;
/*!40000 ALTER TABLE `cp_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `cp_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cp_positive`
--

DROP TABLE IF EXISTS `cp_positive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cp_positive` (
  `cp_positive_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `first_apply_time` varchar(30) DEFAULT NULL,
  `be_positive_time` varchar(30) DEFAULT NULL,
  `con_people1` varchar(30) DEFAULT NULL,
  `con_people2` varchar(30) DEFAULT NULL,
  `fzdx_num` varchar(30) DEFAULT NULL,
  `fzdx_positive_num` varchar(30) DEFAULT NULL,
  `ybdy_num` varchar(30) DEFAULT NULL,
  `yndy_positive_num` varchar(30) DEFAULT NULL,
  `zsdy_num` varchar(30) DEFAULT NULL,
  `zsdy_positive_num` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cp_positive_id`),
  KEY `FK_jr24` (`party_id`),
  CONSTRAINT `FK_jr24` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cp_positive`
--

LOCK TABLES `cp_positive` WRITE;
/*!40000 ALTER TABLE `cp_positive` DISABLE KEYS */;
/*!40000 ALTER TABLE `cp_positive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dq_hui`
--

DROP TABLE IF EXISTS `dq_hui`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dq_hui` (
  `hui_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `zhibu_party_id` bigint(20) DEFAULT NULL,
  `hui_type` varchar(20) DEFAULT NULL,
  `hui_time` datetime DEFAULT NULL,
  `hui_address` varchar(100) DEFAULT NULL,
  `hui_master` varchar(20) DEFAULT NULL,
  `hui_recorder` varchar(20) DEFAULT NULL,
  `num_should` int(11) DEFAULT NULL,
  `num_real` int(11) DEFAULT NULL,
  `num_party` int(11) DEFAULT NULL,
  `num_absent` int(11) DEFAULT NULL,
  `num_absent_party` int(11) DEFAULT NULL,
  `name_come_in` varchar(255) DEFAULT NULL,
  `name_site_in` varchar(255) DEFAULT NULL,
  `name_absent` varchar(255) DEFAULT NULL,
  `hui_content` text,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`hui_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dq_hui`
--

LOCK TABLES `dq_hui` WRITE;
/*!40000 ALTER TABLE `dq_hui` DISABLE KEYS */;
INSERT INTO `dq_hui` VALUES (1,'西黎岗村支部大会',2,'20','2016-03-05 00:00:00','西黎岗村会议室','董玉阵','王喜峰',36,36,36,36,36,'王铁群   张林青   马书亭  闫留宾    董付太 董巧妮  董付成  李新库  李付民    董玉阵  董云飞  王喜锋   王付宽   马国营  马书亭 王新伟  孙秀恩  董全营 翟翠娥孬  孙秀恩  谷俊平   王孟臣  王付良  杨根义  杨银生   董青林   王西安   贾','董根来 董全营 李爱玲 王怀臣 翟翠娥','张彦青  徐军霞  王化三  董玉山','一、为深入学习贯彻习近平总书记系列讲话精神，推动全面从严治党向基层延伸，巩固拓展党的群众路线教育活动和\'三严三实”专题教育成果，进一步解决党员队伍在思想、组织、作风、纪律等方面存在的问题，保持发展党的先进性和纯洁性，党中央决定，2016年在全体党员中开展“学党章党规，学习近平讲话，做合格党员教育。\r\n二、开展”两学一做“学习教育，基础在学，关键在做。要把党的思想建设放在首位，以尊崇党章、遂守党规为基本要求，以用习近平总书记系列重要讲话精神武装全党为根本任务，教育引导党员自觉按照党员标准规划言行，进一步坚定信念，提高党性、觉悟，进一步增强政治意识，树立清风正气，严守政治纪律，政治规矩。\r\n三、做合格党员，做讲政治、有信念，讲规矩、有纪律；讲道德、有品行；讲奉献、有作为的合格党员。密切联系群众，全心全意为人民服务。','2016-03-07 15:22:19',10,NULL,NULL);
/*!40000 ALTER TABLE `dq_hui` ENABLE KEYS */;
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
  `enum_attached1` varchar(30) DEFAULT NULL,
  `enum_attached2` varchar(30) DEFAULT NULL,
  `enum_attached3` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`enum_id`),
  KEY `FK_jr8` (`enum_type_id`),
  CONSTRAINT `FK_jr8` FOREIGN KEY (`enum_type_id`) REFERENCES `enumeration_type` (`enum_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumeration`
--

LOCK TABLES `enumeration` WRITE;
/*!40000 ALTER TABLE `enumeration` DISABLE KEYS */;
INSERT INTO `enumeration` VALUES (1,1,'default_price',0,'默认价格',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,'day_price',1,'日价格','rjg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,2,'',1,'已参保','ycb',NULL,NULL,NULL,'2016-03-03 11:55:25',NULL,-2,NULL),(4,2,'',2,'未参保','wcb',NULL,NULL,NULL,'2016-03-03 11:55:33',NULL,-2,NULL),(5,2,'',3,'已领取','ylq',NULL,NULL,NULL,'2016-03-03 11:55:40',NULL,-2,NULL),(6,6,'1110',1,'带病返乡','dbfx',NULL,NULL,NULL,'2016-03-03 11:59:13',NULL,-2,NULL),(7,6,'1080',2,'参战人员','czry',NULL,NULL,NULL,'2016-03-03 11:59:30',NULL,-2,NULL),(8,6,'200',3,'艾滋病单亲','azbdq',NULL,NULL,NULL,'2016-03-03 11:59:40',NULL,-2,NULL),(9,6,'600',4,'社会孤儿','shge',NULL,NULL,NULL,'2016-03-03 11:59:49',NULL,-2,NULL),(10,6,'1950',5,'老复员军人','lfyjr',NULL,NULL,NULL,'2016-03-03 11:59:58',NULL,-2,NULL),(11,6,'300',6,'退职工','tzg',NULL,NULL,NULL,'2016-03-03 12:00:11',NULL,-2,NULL),(12,5,'119',1,'一类','yl',NULL,NULL,NULL,'2016-03-03 12:00:39',NULL,-2,NULL),(13,5,'99',2,'二类','el',NULL,NULL,NULL,'2016-03-03 12:00:52',NULL,-2,NULL),(14,5,'79',3,'三类','sl',NULL,NULL,NULL,'2016-03-03 12:01:02',NULL,-2,NULL),(15,5,'260',4,'城镇低保','czdb',NULL,NULL,NULL,'2016-03-03 12:01:12',NULL,-2,NULL),(16,4,'800',1,'集中供养','jzgy',NULL,NULL,NULL,'2016-03-03 12:01:36',NULL,-2,NULL),(17,4,'555',2,'分散供养','fsgy',NULL,NULL,NULL,'2016-03-03 12:01:45',NULL,-2,NULL),(18,7,'',1,'党小组会','dxzh',NULL,NULL,NULL,'2016-03-07 11:10:48',NULL,10,NULL),(19,7,'',2,'支委会','zwh',NULL,NULL,NULL,'2016-03-07 11:10:59',NULL,10,NULL),(20,7,'',3,'支部大会','zbdh',NULL,NULL,NULL,'2016-03-07 11:11:05',NULL,10,NULL),(21,7,'',4,'党课','dk',NULL,NULL,NULL,'2016-03-07 11:11:14',NULL,10,NULL),(22,8,'',1,'收纳党费','sndf',NULL,NULL,NULL,'2016-03-16 11:02:49','2016-03-16 11:11:28',-2,-2),(23,8,'',2,'上缴党费','sjdf',NULL,NULL,NULL,'2016-03-16 11:11:18',NULL,-2,NULL),(24,8,'',3,'上级拨入','sjbr',NULL,NULL,NULL,'2016-03-16 11:13:09',NULL,-2,NULL),(25,8,'',4,'下拨','xb',NULL,NULL,NULL,'2016-03-16 11:13:19',NULL,-2,NULL),(26,9,'',1,'党费账户','dfzh',NULL,NULL,NULL,'2016-03-16 11:13:37',NULL,-2,NULL),(27,9,'',2,'拨款账户','bkzh',NULL,NULL,NULL,'2016-03-16 11:13:46',NULL,-2,NULL),(28,10,'',1,'汉族','hz',NULL,NULL,NULL,'2016-03-25 23:28:25','2016-03-25 23:28:43',2,2),(29,10,'',NULL,'回族','hz',NULL,NULL,NULL,'2016-03-25 23:28:34',NULL,2,NULL),(30,11,'',1,'未婚','wh',NULL,NULL,NULL,'2016-03-25 23:28:55',NULL,2,NULL),(31,11,'',2,'已婚','yh',NULL,NULL,NULL,'2016-03-25 23:29:02',NULL,2,NULL),(32,11,'',3,'离异','ly',NULL,NULL,NULL,'2016-03-25 23:29:10',NULL,2,NULL),(33,11,'',4,'丧偶','so',NULL,NULL,NULL,'2016-03-25 23:29:16',NULL,2,NULL),(34,12,'',1,'初中','cz',NULL,NULL,NULL,'2016-03-25 23:29:24',NULL,2,NULL),(35,12,'',2,'高中','gz',NULL,NULL,NULL,'2016-03-25 23:29:30',NULL,2,NULL),(36,12,'',3,'大专','dz',NULL,NULL,NULL,'2016-03-25 23:29:37',NULL,2,NULL),(37,12,'',4,'大学本科','dxbk',NULL,NULL,NULL,'2016-03-25 23:29:44',NULL,2,NULL),(38,12,'',5,'研究生硕士','yjsss',NULL,NULL,NULL,'2016-03-25 23:29:58',NULL,2,NULL),(39,12,'',6,'研究生博士','yjsbs',NULL,NULL,NULL,'2016-03-25 23:30:05',NULL,2,NULL),(40,12,'',7,'小学','xx',NULL,NULL,NULL,'2016-03-25 23:30:14',NULL,2,NULL),(41,13,'',1,'在岗职工','zgzg',NULL,NULL,NULL,'2016-03-25 23:31:26',NULL,2,NULL),(42,13,'',2,'农牧渔民','nmym',NULL,NULL,NULL,'2016-03-25 23:31:34',NULL,2,NULL),(43,13,'',3,'军人、武警','jr、wj',NULL,NULL,NULL,'2016-03-25 23:31:42',NULL,2,NULL),(44,13,'',4,'学生','xs',NULL,NULL,NULL,'2016-03-25 23:31:48',NULL,2,NULL),(45,13,'',5,'离退休人员','ltxry',NULL,NULL,NULL,'2016-03-25 23:31:54','2016-03-25 23:31:59',2,2),(46,13,'',6,'个体工商户从业人员','gtgshcyry',NULL,NULL,NULL,'2016-03-25 23:32:07',NULL,2,NULL),(47,13,'',7,'其他','qt',NULL,NULL,NULL,'2016-03-25 23:32:14',NULL,2,NULL),(48,14,'',1,'土地问题','tdwt',NULL,NULL,NULL,'2016-03-27 14:01:19',NULL,2,NULL),(49,14,'',2,'补偿问题','bcwt',NULL,NULL,NULL,'2016-03-27 14:01:29',NULL,2,NULL),(50,14,'',3,'干部问题','gbwt',NULL,NULL,NULL,'2016-03-27 14:01:37',NULL,2,NULL),(51,14,'',4,'城建问题','cjwt',NULL,NULL,NULL,'2016-03-27 14:01:47',NULL,2,NULL),(52,14,'',5,'待遇问题','dywt',NULL,NULL,NULL,'2016-03-27 14:01:55',NULL,2,NULL),(53,14,'',6,'涉法涉诉','sfss',NULL,NULL,NULL,'2016-03-27 14:02:09',NULL,2,NULL),(54,15,'',1,'阳光组工作站走访','ygzgzzzf',NULL,NULL,NULL,'2016-03-27 14:02:29',NULL,2,NULL),(55,15,'',2,'市委组织部转办','swzzbzb',NULL,NULL,NULL,'2016-03-27 14:02:50',NULL,2,NULL),(56,15,'',3,'来电','ld',NULL,NULL,NULL,'2016-03-27 14:02:59',NULL,2,NULL),(57,15,'',4,'来信','lx',NULL,NULL,NULL,'2016-03-27 14:03:04',NULL,2,NULL),(58,16,'1',1,'党章','dz',NULL,NULL,NULL,'2016-06-04 16:03:50',NULL,-2,NULL),(59,16,'2',2,'党规','dg',NULL,NULL,NULL,'2016-06-04 16:03:56',NULL,-2,NULL),(60,16,'3',3,'党规','dg',NULL,NULL,NULL,'2016-06-04 16:04:03',NULL,-2,NULL),(61,16,'4',4,'领导讲话','ldjh',NULL,NULL,NULL,'2016-06-04 16:04:09',NULL,-2,NULL),(62,16,'5',5,'党的理论','ddll',NULL,NULL,NULL,'2016-06-04 16:04:45',NULL,-2,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumeration_type`
--

LOCK TABLES `enumeration_type` WRITE;
/*!40000 ALTER TABLE `enumeration_type` DISABLE KEYS */;
INSERT INTO `enumeration_type` VALUES (1,NULL,NULL,'商品价格类型',NULL,NULL,NULL,NULL),(2,NULL,NULL,'养老保险状态','2016-03-03 11:54:54',NULL,-2,NULL),(3,NULL,NULL,'民政类型','2016-03-03 11:56:26',NULL,-2,NULL),(4,3,NULL,'五保','2016-03-03 11:56:47',NULL,-2,NULL),(5,3,NULL,'低保','2016-03-03 11:56:56',NULL,-2,NULL),(6,3,NULL,'优抚类型','2016-03-03 11:57:04',NULL,-2,NULL),(7,NULL,NULL,'三会会议类型','2016-03-07 11:10:34',NULL,10,NULL),(8,NULL,NULL,'党费操作类型','2016-03-16 11:02:20',NULL,-2,NULL),(9,NULL,NULL,'党委账户类型','2016-03-16 11:02:32',NULL,-2,NULL),(10,NULL,NULL,'民族','2016-03-25 22:52:04',NULL,2,NULL),(11,NULL,NULL,'婚姻状况','2016-03-25 22:52:19',NULL,2,NULL),(12,NULL,NULL,'学历','2016-03-25 22:52:43',NULL,2,NULL),(13,NULL,NULL,'职业类型','2016-03-25 22:52:58',NULL,2,NULL),(14,NULL,NULL,'举报问题类型','2016-03-27 14:00:11',NULL,2,NULL),(15,NULL,NULL,'举报途径','2016-03-27 14:00:23',NULL,2,NULL),(16,NULL,NULL,'试题类型','2016-06-04 16:03:34',NULL,-2,NULL);
/*!40000 ALTER TABLE `enumeration_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examination` (
  `examination_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paper_id` bigint(20) DEFAULT NULL,
  `answerer_id` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`examination_id`),
  KEY `FK_jr29` (`paper_id`),
  KEY `FK_jr30` (`answerer_id`),
  CONSTRAINT `FK_jr29` FOREIGN KEY (`paper_id`) REFERENCES `test_paper` (`paper_id`),
  CONSTRAINT `FK_jr30` FOREIGN KEY (`answerer_id`) REFERENCES `answerer` (`answerer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES (1,10,2,'2016-06-05 15:29:15','2016-06-05 19:51:54'),(2,11,2,'2016-06-05 19:13:01','2016-06-05 19:49:21'),(3,12,2,'2016-06-05 19:52:13','2016-06-05 19:52:24'),(4,13,2,'2016-06-05 20:25:58','2016-06-05 21:08:13'),(5,14,2,'2016-06-05 21:12:16','2016-06-05 21:13:42'),(6,15,2,'2016-06-05 21:15:53','2016-06-05 21:18:14'),(7,16,2,'2016-06-05 21:18:20','2016-06-05 21:20:14'),(8,17,2,'2016-06-05 21:20:20','2016-06-05 21:21:12'),(9,18,2,'2016-06-05 21:21:28','2016-06-05 21:22:29'),(10,19,2,'2016-06-05 21:22:36','2016-06-05 21:23:18'),(11,20,2,'2016-06-05 21:23:29','2016-06-05 21:24:16'),(12,21,2,'2016-06-05 21:24:27','2016-06-05 21:25:18'),(13,22,2,'2016-06-05 21:25:29','2016-06-05 21:32:04'),(14,23,2,'2016-06-05 21:32:14','2016-06-05 21:36:20'),(15,24,3,'2016-06-05 21:36:48','2016-06-05 21:38:27'),(16,25,3,'2016-06-05 21:48:44','2016-06-05 21:49:05');
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
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
-- Table structure for table `geo`
--

DROP TABLE IF EXISTS `geo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geo` (
  `geo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `geo_type` varchar(20) DEFAULT NULL,
  `geo_name` varchar(50) DEFAULT NULL,
  `geo_name_pinyin` varchar(50) DEFAULT NULL,
  `geo_point` varchar(50) DEFAULT NULL,
  `parent_geo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`geo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geo`
--

LOCK TABLES `geo` WRITE;
/*!40000 ALTER TABLE `geo` DISABLE KEYS */;
/*!40000 ALTER TABLE `geo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monite_site`
--

DROP TABLE IF EXISTS `monite_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monite_site` (
  `site_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `sit_name` varchar(50) DEFAULT NULL,
  `con_people` varchar(30) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `geopoint` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monite_site`
--

LOCK TABLES `monite_site` WRITE;
/*!40000 ALTER TABLE `monite_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `monite_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor_data`
--

DROP TABLE IF EXISTS `monitor_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitor_data` (
  `monitor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `site_id` bigint(20) DEFAULT NULL,
  `时间` datetime DEFAULT NULL,
  `k1` decimal(20,8) DEFAULT NULL,
  `k2` decimal(20,8) DEFAULT NULL,
  `k3` decimal(20,8) DEFAULT NULL,
  `k4` decimal(20,8) DEFAULT NULL,
  `k5` decimal(20,8) DEFAULT NULL,
  `k6` decimal(20,8) DEFAULT NULL,
  `k7` decimal(20,8) DEFAULT NULL,
  `k8` decimal(20,8) DEFAULT NULL,
  `k9` decimal(20,8) DEFAULT NULL,
  `k10` decimal(20,8) DEFAULT NULL,
  `k11` decimal(20,8) DEFAULT NULL,
  `k12` decimal(20,8) DEFAULT NULL,
  `k13` decimal(20,8) DEFAULT NULL,
  `k14` decimal(20,8) DEFAULT NULL,
  `k15` decimal(20,8) DEFAULT NULL,
  `k16` decimal(20,8) DEFAULT NULL,
  `k17` decimal(20,8) DEFAULT NULL,
  `k18` decimal(20,8) DEFAULT NULL,
  `k19` decimal(20,8) DEFAULT NULL,
  `k20` decimal(20,8) DEFAULT NULL,
  PRIMARY KEY (`monitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor_data`
--

LOCK TABLES `monitor_data` WRITE;
/*!40000 ALTER TABLE `monitor_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitor_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper_question`
--

DROP TABLE IF EXISTS `paper_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper_question` (
  `paper_question_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) DEFAULT NULL,
  `paper_id` bigint(20) DEFAULT NULL,
  `answer` varchar(30) DEFAULT NULL,
  `answer_time` datetime DEFAULT NULL,
  PRIMARY KEY (`paper_question_id`),
  KEY `FK_jr26` (`question_id`),
  KEY `FK_jr27` (`paper_id`),
  CONSTRAINT `FK_jr26` FOREIGN KEY (`question_id`) REFERENCES `test_question` (`question_id`),
  CONSTRAINT `FK_jr27` FOREIGN KEY (`paper_id`) REFERENCES `test_paper` (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_question`
--

LOCK TABLES `paper_question` WRITE;
/*!40000 ALTER TABLE `paper_question` DISABLE KEYS */;
INSERT INTO `paper_question` VALUES (19,1,10,'A','2016-06-05 19:51:48'),(20,2,10,'B','2016-06-05 19:51:50'),(21,3,10,'D','2016-06-05 18:09:37'),(22,1,11,'C','2016-06-05 19:49:18'),(23,2,11,'D','2016-06-05 19:49:13'),(24,3,11,'C','2016-06-05 19:43:59'),(25,1,12,'A','2016-06-05 19:52:21'),(26,2,12,'C','2016-06-05 19:52:19'),(27,3,12,'C','2016-06-05 19:52:17'),(28,1,13,'B','2016-06-05 21:08:05'),(29,2,13,'A','2016-06-05 21:08:07'),(30,3,13,'C','2016-06-05 21:08:09'),(31,2,22,NULL,NULL),(32,3,22,NULL,NULL),(33,5,22,NULL,NULL),(34,6,22,NULL,NULL),(35,8,22,'C','2016-06-05 21:31:45'),(36,10,22,'A','2016-06-05 21:31:45'),(37,12,22,'B','2016-06-05 21:32:01'),(38,1,23,'B','2016-06-05 21:32:45'),(39,2,23,'A','2016-06-05 21:32:46'),(40,3,23,'A','2016-06-05 21:32:47'),(41,4,23,'A','2016-06-05 21:32:50'),(42,6,23,'B','2016-06-05 21:32:53'),(43,7,23,'B','2016-06-05 21:32:56'),(44,8,23,'C','2016-06-05 21:32:59'),(45,10,23,'B','2016-06-05 21:33:01'),(46,11,23,'B','2016-06-05 21:33:00'),(47,12,23,'B','2016-06-05 21:33:03'),(53,1,24,'B','2016-06-05 21:36:55'),(54,3,24,'A','2016-06-05 21:36:54'),(55,4,24,'A','2016-06-05 21:36:55'),(56,5,24,'A','2016-06-05 21:36:59'),(57,6,24,'A','2016-06-05 21:37:00'),(58,7,24,'A','2016-06-05 21:38:15'),(59,8,24,'D','2016-06-05 21:38:16'),(60,9,24,'C','2016-06-05 21:38:21'),(61,11,24,'D','2016-06-05 21:38:20'),(62,12,24,'B','2016-06-05 21:38:23'),(68,2,25,'B','2016-06-05 21:48:45'),(69,3,25,'B','2016-06-05 21:48:47'),(70,4,25,'A','2016-06-05 21:48:50'),(71,5,25,'A','2016-06-05 21:48:51'),(72,6,25,'C','2016-06-05 21:48:54'),(73,7,25,NULL,NULL),(74,8,25,'C','2016-06-05 21:48:56'),(75,10,25,'D','2016-06-05 21:48:59'),(76,11,25,'C','2016-06-05 21:49:00'),(77,12,25,'C','2016-06-05 21:49:02');
/*!40000 ALTER TABLE `paper_question` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES (1,'party_group',0,'集团总部','2015-08-08 17:48:43',NULL,-2,NULL);
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
  `address` mediumtext,
  `phone` varchar(20) DEFAULT NULL,
  `company_type` varchar(20) DEFAULT NULL,
  `geoid` bigint(20) DEFAULT NULL,
  `geopoint` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pg_id`),
  KEY `FK_jr3` (`party_id`),
  CONSTRAINT `FK_jr3` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_group`
--

LOCK TABLES `party_group` WRITE;
/*!40000 ALTER TABLE `party_group` DISABLE KEYS */;
INSERT INTO `party_group` VALUES (1,1,'大同环保局','dthbj',10,'','',NULL,NULL,NULL,NULL,'2016-06-19 08:51:16',NULL,-2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship_type`
--

LOCK TABLES `party_relationship_type` WRITE;
/*!40000 ALTER TABLE `party_relationship_type` DISABLE KEYS */;
INSERT INTO `party_relationship_type` VALUES (1,NULL,NULL,'组织结构关系','组织结构上下级关系','1','1',NULL,NULL,NULL,NULL),(2,NULL,NULL,'供货商客户关系','供货商客户关系','1','1',NULL,NULL,NULL,NULL),(3,NULL,NULL,'归属行政机构','党委支部与行政机构关系','1','2','2016-02-24 15:44:41',NULL,-2,NULL),(4,NULL,NULL,'党委支部上下级关系','党委支部上下级关系','2','2','2016-02-27 00:31:10',NULL,-2,NULL),(5,NULL,NULL,'行政单位和行政区划归属关系','行政单位和行政区划归属关系','1','6','2016-03-07 16:10:09',NULL,10,NULL),(6,NULL,NULL,'行政单位上下级关系','行政单位上下级关系','6','6','2016-03-07 16:10:48',NULL,10,NULL);
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
  `role_attached1` varchar(50) DEFAULT NULL,
  `role_attached2` varchar(50) DEFAULT NULL,
  `role_attached3` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `FK_jr4` (`role_type_id`),
  KEY `FK_jr6` (`party_id`),
  CONSTRAINT `FK_jr4` FOREIGN KEY (`role_type_id`) REFERENCES `role_type` (`role_type_id`),
  CONSTRAINT `FK_jr6` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
INSERT INTO `party_role` VALUES (1,1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_user`
--

LOCK TABLES `party_user` WRITE;
/*!40000 ALTER TABLE `party_user` DISABLE KEYS */;
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
  `birthday` varchar(20) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `household` varchar(150) DEFAULT NULL,
  `marriage` varchar(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `education_schoole` varchar(100) DEFAULT NULL,
  `education_speciality` varchar(100) DEFAULT NULL,
  `family_address` varchar(255) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `weixin` varchar(50) DEFAULT NULL,
  `work_date` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FK_jr7` (`party_id`),
  CONSTRAINT `FK_jr7` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petition`
--

DROP TABLE IF EXISTS `petition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petition` (
  `petition_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `report_people` varchar(50) DEFAULT NULL,
  `report_dep` varchar(50) DEFAULT NULL,
  `report_status` varchar(50) DEFAULT NULL,
  `report_p_connect` varchar(50) DEFAULT NULL,
  `report_p_num` varchar(20) DEFAULT NULL,
  `report_memo` varchar(255) DEFAULT NULL,
  `report_type` varchar(10) DEFAULT NULL,
  `reported_people` varchar(50) DEFAULT NULL,
  `reported_dep` varchar(50) DEFAULT NULL,
  `reported_status` varchar(50) DEFAULT NULL,
  `reported_memo` varchar(255) DEFAULT NULL,
  `report_method` varchar(10) DEFAULT NULL,
  `accept_name` varchar(30) DEFAULT NULL,
  `accept_time` datetime DEFAULT NULL,
  `expect_end_time` datetime DEFAULT NULL,
  `real_end_time` datetime DEFAULT NULL,
  `report_content` text,
  `accept_content` varchar(255) DEFAULT NULL,
  `leader_content` varchar(255) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `process_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`petition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petition`
--

LOCK TABLES `petition` WRITE;
/*!40000 ALTER TABLE `petition` DISABLE KEYS */;
INSERT INTO `petition` VALUES (1,'索罗斯地方','个人如果个人','耍大刀','使得公司的','3','风格广泛','50','局长','某哥局','一把手','取得乃关系','54','黄晓明','2016-03-27 00:00:00','2016-03-31 00:00:00',NULL,'双方的规范化改革符合afsdgsdagdsgg\r\nasgdasdfsdafasdgasdgasdf\r\n阿萨德gas的gas的','大家圣诞节的发放凯撒浪费阿萨德fag热额发','领导已经审批通过了',6,573,'2016-03-27 00:00:00',2,'2016-04-04 00:34:18',4),(2,'很让人','打扫方','斯蒂芬','2123343','3','ssf','51','某来','政治局','常委','撒反对撒','54','黄晓明','2016-04-04 00:00:00','2016-04-08 00:00:00',NULL,'啊公司的所发生的方法sad发放','四大神兽斯蒂芬','方法是',6,573,'2016-04-04 00:35:59',2,'2016-04-04 00:36:45',4);
/*!40000 ALTER TABLE `petition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petition_flow`
--

DROP TABLE IF EXISTS `petition_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petition_flow` (
  `petition_flow_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `petition_id` bigint(20) DEFAULT NULL,
  `party_id` bigint(20) DEFAULT NULL,
  `svc_id` bigint(20) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`petition_flow_id`),
  KEY `FK_jr25` (`petition_id`),
  CONSTRAINT `FK_jr25` FOREIGN KEY (`petition_id`) REFERENCES `petition` (`petition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petition_flow`
--

LOCK TABLES `petition_flow` WRITE;
/*!40000 ALTER TABLE `petition_flow` DISABLE KEYS */;
INSERT INTO `petition_flow` VALUES (1,1,570,3,'接收受理','2016-03-27 15:52:27',2),(2,1,573,4,'领导已经审批通过了','2016-04-03 22:48:45',2),(3,1,573,5,'处理','2016-04-04 00:20:59',4),(4,1,573,5,'各地萨芬撒反对','2016-04-04 00:21:48',4),(5,1,573,6,'结案','2016-04-04 00:34:19',4),(6,2,570,3,'接收受理','2016-04-04 00:35:59',2),(7,2,573,4,'方法是','2016-04-04 00:36:12',2),(8,2,573,5,'规范地方所得税法','2016-04-04 00:36:30',4),(9,2,573,5,'分公司电话突然很突然好','2016-04-04 00:36:36',4),(10,2,573,6,'结案','2016-04-04 00:36:46',4);
/*!40000 ALTER TABLE `petition_flow` ENABLE KEYS */;
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
-- Table structure for table `question_option`
--

DROP TABLE IF EXISTS `question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_option` (
  `question_option_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`question_option_id`),
  KEY `FK_jr28` (`question_id`),
  CONSTRAINT `FK_jr28` FOREIGN KEY (`question_id`) REFERENCES `test_question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_option`
--

LOCK TABLES `question_option` WRITE;
/*!40000 ALTER TABLE `question_option` DISABLE KEYS */;
INSERT INTO `question_option` VALUES (1,NULL,NULL,'10.1'),(2,NULL,NULL,'10.3'),(3,NULL,NULL,'10.4'),(4,NULL,NULL,'10.2'),(5,1,'A','444'),(6,1,'B','4222'),(7,1,'C','111'),(8,1,'D','555'),(9,2,'A','71'),(10,2,'B','81'),(11,2,'C','91'),(12,2,'D','101'),(13,3,'A','分违法违规'),(14,3,'B','s\'ge\'w\'w'),(15,3,'C','分阿斯达岁的哥哥'),(16,3,'D','阿萨德gas的手法十分大方'),(17,4,'A','阿格瓦发电示范'),(18,4,'B','阿发送到公司法定gasgas点噶'),(19,4,'C','个发撒旦发射点发生'),(20,4,'D','该文附twee我认为'),(21,5,'A','阿萨德发射点发斯蒂芬'),(22,5,'B','公布热啊告诉对方噶地方gas的 '),(23,5,'C','剪个头发肌肤恢复后'),(24,5,'D','就try调节人体与家人团圆节'),(25,6,'A','如同有人提议'),(26,6,'B','房改房等纷纷赶到后'),(27,6,'C','他人与人'),(28,6,'D','ityrggf'),(29,7,'A','你还要通过决议投否决'),(30,7,'B','教育厅副研究员'),(31,7,'C','】也可投入金额计入'),(32,7,'D','通过人工如果让他'),(33,8,'A','体液调节人体'),(34,8,'B','今天人推进教育'),(35,8,'C','双方的非官方'),(36,8,'D','阿凡达fee威风威风威风'),(37,9,'A','uyuyuyuy'),(38,9,'B','东风公司法定公司法定个'),(39,9,'C','搞不好南非工会经费的'),(40,9,'D','后他儿童和'),(41,10,'A','爱的时光'),(42,10,'B','fa\'s\'d'),(43,10,'C','跟第三方的撒手'),(44,10,'D','耳热厄尔热'),(45,11,'A','阿斯达芙'),(46,11,'B','阿萨德发达省份 '),(47,11,'C','撒旦撒发电示范'),(48,11,'D','add各位万股'),(49,12,'A','阿分公司的公司的公司'),(50,12,'B','人个二个人哥哥'),(51,12,'C','大事发生大幅度撒'),(52,12,'D','大gas的个发撒旦');
/*!40000 ALTER TABLE `question_option` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (-2,'系统用户','ROLE_USER'),(-1,'系统管理员','ROLE_ADMIN'),(1,'一级管理员','ROLE_CP_ADMIN'),(2,'一级操作员','ROLE_CP_USER'),(3,'二级操作员','ROLE_SS_USER'),(4,'三级操作员','ROLE_VI_USER');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_type`
--

LOCK TABLES `role_type` WRITE;
/*!40000 ALTER TABLE `role_type` DISABLE KEYS */;
INSERT INTO `role_type` VALUES (1,NULL,NULL,'组织构架成员',NULL,NULL,NULL,NULL),(2,NULL,NULL,'被监控企业','2016-06-19 18:20:52',NULL,-2,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_item`
--

LOCK TABLES `status_item` WRITE;
/*!40000 ALTER TABLE `status_item` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_type`
--

LOCK TABLES `status_type` WRITE;
/*!40000 ALTER TABLE `status_type` DISABLE KEYS */;
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
-- Table structure for table `tb_care_people`
--

DROP TABLE IF EXISTS `tb_care_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_care_people` (
  `people_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_id` bigint(20) DEFAULT NULL,
  `people_name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `party_type` varchar(20) DEFAULT NULL,
  `party_status` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `pension_insurance` varchar(30) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`people_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_care_people`
--

LOCK TABLES `tb_care_people` WRITE;
/*!40000 ALTER TABLE `tb_care_people` DISABLE KEYS */;
INSERT INTO `tb_care_people` VALUES (1,18,'wangxiaoer','男','汉','党员','正常','','','2','','已参保',NULL,NULL,NULL,NULL),(2,1,'西门吹雪碧','男','汉','党员','正常','','3212','','','已参保',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_care_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_people_care`
--

DROP TABLE IF EXISTS `tb_people_care`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_people_care` (
  `care_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `people_id` bigint(20) DEFAULT NULL,
  `enum_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`care_id`),
  KEY `FK_jr17` (`people_id`),
  KEY `FK_jr18` (`enum_id`),
  CONSTRAINT `FK_jr17` FOREIGN KEY (`people_id`) REFERENCES `tb_care_people` (`people_id`),
  CONSTRAINT `FK_jr18` FOREIGN KEY (`enum_id`) REFERENCES `enumeration` (`enum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_people_care`
--

LOCK TABLES `tb_people_care` WRITE;
/*!40000 ALTER TABLE `tb_people_care` DISABLE KEYS */;
INSERT INTO `tb_people_care` VALUES (2,1,15,'2016-03-04 12:39:47',-2),(3,1,10,'2016-03-04 12:39:52',-2),(4,2,16,'2016-03-07 00:09:40',10),(5,2,17,'2016-03-07 00:09:45',10);
/*!40000 ALTER TABLE `tb_people_care` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_provide`
--

DROP TABLE IF EXISTS `tb_provide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_provide` (
  `provide_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_id` bigint(20) DEFAULT NULL,
  `provide_name` varchar(50) DEFAULT NULL,
  `provide_date` datetime DEFAULT NULL,
  `provide_sum` decimal(18,2) DEFAULT NULL,
  `valid_flag` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`provide_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_provide`
--

LOCK TABLES `tb_provide` WRITE;
/*!40000 ALTER TABLE `tb_provide` DISABLE KEYS */;
INSERT INTO `tb_provide` VALUES (4,1,'尉氏县--2016年03月--五保/集中供养/800','2016-03-07 00:00:00',800.00,1,'2016-03-07 00:17:44',10,'2016-03-07 01:18:30',10);
/*!40000 ALTER TABLE `tb_provide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_provide_dtl`
--

DROP TABLE IF EXISTS `tb_provide_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_provide_dtl` (
  `provide_dtl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `people_id` bigint(20) DEFAULT NULL,
  `enum_id` bigint(20) DEFAULT NULL,
  `provide_id` bigint(20) DEFAULT NULL,
  `provide_money` decimal(20,2) DEFAULT NULL,
  `valid_flag` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`provide_dtl_id`),
  KEY `FK_jr19` (`people_id`),
  KEY `FK_jr20` (`enum_id`),
  KEY `FK_jr21` (`provide_id`),
  CONSTRAINT `FK_jr19` FOREIGN KEY (`people_id`) REFERENCES `tb_care_people` (`people_id`),
  CONSTRAINT `FK_jr20` FOREIGN KEY (`enum_id`) REFERENCES `enumeration` (`enum_id`),
  CONSTRAINT `FK_jr21` FOREIGN KEY (`provide_id`) REFERENCES `tb_provide` (`provide_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_provide_dtl`
--

LOCK TABLES `tb_provide_dtl` WRITE;
/*!40000 ALTER TABLE `tb_provide_dtl` DISABLE KEYS */;
INSERT INTO `tb_provide_dtl` VALUES (1,2,16,4,800.00,1,'2016-03-07 12:17:44',10,'2016-03-07 01:18:30',10);
/*!40000 ALTER TABLE `tb_provide_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_paper`
--

DROP TABLE IF EXISTS `test_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_paper` (
  `paper_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `purpose_type` varchar(20) DEFAULT NULL,
  `paper_name` varchar(50) DEFAULT NULL,
  `paper_type` varchar(50) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `generate_time` datetime DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='每次考试生成一条记录\n如果要弄试卷模版也生成一条记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_paper`
--

LOCK TABLES `test_paper` WRITE;
/*!40000 ALTER TABLE `test_paper` DISABLE KEYS */;
INSERT INTO `test_paper` VALUES (10,'','党识考试20160605','自动',0,'2016-06-05 15:29:15','自动生成试卷'),(11,'','党识考试20160605','自动',33,'2016-06-05 19:13:01','自动生成试卷'),(12,'','党识考试20160605','自动',0,'2016-06-05 19:52:12','自动生成试卷'),(13,'','党识考试20160605','自动',0,'2016-06-05 20:25:58','自动生成试卷'),(14,'','党识考试20160605','自动',NULL,'2016-06-05 21:12:15','自动生成试卷'),(15,'','党识考试20160605','自动',NULL,'2016-06-05 21:15:53','自动生成试卷'),(16,'','党识考试20160605','自动',NULL,'2016-06-05 21:18:20','自动生成试卷'),(17,'','党识考试20160605','自动',NULL,'2016-06-05 21:20:19','自动生成试卷'),(18,'','党识考试20160605','自动',NULL,'2016-06-05 21:21:28','自动生成试卷'),(19,'','党识考试20160605','自动',NULL,'2016-06-05 21:22:36','自动生成试卷'),(20,'','党识考试20160605','自动',NULL,'2016-06-05 21:23:29','自动生成试卷'),(21,'','党识考试20160605','自动',NULL,'2016-06-05 21:24:26','自动生成试卷'),(22,'','党识考试20160605','自动',0,'2016-06-05 21:25:28','自动生成试卷'),(23,'','党识考试20160605','自动',20,'2016-06-05 21:32:13','自动生成试卷'),(24,'','党识考试20160605','自动',20,'2016-06-05 21:36:48','自动生成试卷'),(25,'','党识考试20160605','自动',40,'2016-06-05 21:48:43','自动生成试卷');
/*!40000 ALTER TABLE `test_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_question`
--

DROP TABLE IF EXISTS `test_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_question` (
  `question_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_type` bigint(20) DEFAULT NULL,
  `question_level` bigint(20) DEFAULT NULL,
  `question_title` text,
  `right_answer` varchar(30) DEFAULT NULL,
  `analysis` text,
  `create_time` datetime DEFAULT NULL,
  `create_use` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_question`
--

LOCK TABLES `test_question` WRITE;
/*!40000 ALTER TABLE `test_question` DISABLE KEYS */;
INSERT INTO `test_question` VALUES (1,62,2,'中国国庆日','C','阿双方的发生的发生','2016-05-29 17:57:10',-2,'2016-06-04 16:11:10',-2),(2,62,NULL,'建军节','A, D','','2016-05-29 18:43:53',-2,'2016-06-04 16:11:00',-2),(3,61,NULL,'该文认为vgww','A','','2016-06-04 16:10:49',-2,NULL,NULL),(4,60,NULL,'什么事啊你','A','','2016-06-05 21:09:27',-2,NULL,NULL),(5,58,NULL,'asdgasdg隔阂和探讨如何讨好让他人挺好','D','','2016-06-05 21:09:42',-2,NULL,NULL),(6,58,NULL,'发射点发人后天就要','C','','2016-06-05 21:09:55',-2,NULL,NULL),(7,60,NULL,'大概后天海关统计','C','','2016-06-05 21:10:08',-2,NULL,NULL),(8,58,NULL,'同一个好痛好痛人','B','','2016-06-05 21:10:20',-2,'2016-06-05 21:10:29',-2),(9,60,NULL,'阿斯蒂芬他和她已经让天空今天人','B','','2016-06-05 21:10:48',-2,NULL,NULL),(10,58,NULL,'个让他人个','D','','2016-06-05 21:11:04',-2,'2016-06-05 21:48:10',-2),(11,58,NULL,'亚泰集团','B','','2016-06-05 21:11:15',-2,'2016-06-05 21:48:15',-2),(12,58,NULL,'辐射范围额服务范围','C','','2016-06-05 21:11:28',-2,'2016-06-05 21:48:19',-2);
/*!40000 ALTER TABLE `test_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_dhbz`
--

DROP TABLE IF EXISTS `tz_dhbz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_dhbz` (
  `dhbz_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `zdzzsh_time` varchar(20) DEFAULT NULL,
  `zdzzhy_name` varchar(255) DEFAULT NULL,
  `hbgb_num` varchar(20) DEFAULT NULL,
  `bdfs` varchar(255) DEFAULT NULL,
  `pyjjfz_num` varchar(20) DEFAULT NULL,
  `pyjjfz_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dhbz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_dhbz`
--

LOCK TABLES `tz_dhbz` WRITE;
/*!40000 ALTER TABLE `tz_dhbz` DISABLE KEYS */;
INSERT INTO `tz_dhbz` VALUES (1,'2016-03',151,'2016-03-14 00:16:28',12,NULL,NULL,'2016-2-3','哇咔咔','12','很好的方式哦','44','张晓而 王大话 李牛叉');
/*!40000 ALTER TABLE `tz_dhbz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_dyzth`
--

DROP TABLE IF EXISTS `tz_dyzth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_dyzth` (
  `dyzth_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `hy_date` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`dyzth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_dyzth`
--

LOCK TABLES `tz_dyzth` WRITE;
/*!40000 ALTER TABLE `tz_dyzth` DISABLE KEYS */;
INSERT INTO `tz_dyzth` VALUES (1,'2016-03',1,'2016-03-13 20:35:42',10,'2016-03-13 20:35:49',10,NULL,'asdf','gedsafasdg\r\nwgegdsagfwg\r\ngeadsg'),(2,'2016-03',151,'2016-03-14 00:15:43',12,NULL,NULL,NULL,'尉氏县的神马地方呢','卡哥会来风急死啊烦');
/*!40000 ALTER TABLE `tz_dyzth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_fwqz`
--

DROP TABLE IF EXISTS `tz_fwqz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_fwqz` (
  `fwqz_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `jjsjkn_num` varchar(20) DEFAULT NULL,
  `jjsjkn_problem` varchar(255) DEFAULT NULL,
  `jsjcss_num` varchar(20) DEFAULT NULL,
  `jsjcss_dtl` varchar(255) DEFAULT NULL,
  `bmfuxx_is_show` varchar(20) DEFAULT NULL,
  `bmfuxx_show_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fwqz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_fwqz`
--

LOCK TABLES `tz_fwqz` WRITE;
/*!40000 ALTER TABLE `tz_fwqz` DISABLE KEYS */;
INSERT INTO `tz_fwqz` VALUES (1,'2016-03',151,'2016-03-14 00:18:23',12,NULL,NULL,'22','阿萨德嘎的撒发生 偷鸡摸狗的情况','啊伤','没啥设施adsasdg','s','asdfwfwwaf');
/*!40000 ALTER TABLE `tz_fwqz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_gfmz`
--

DROP TABLE IF EXISTS `tz_gfmz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_gfmz` (
  `gfmz_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `sylhgk_times` varchar(20) DEFAULT NULL,
  `sylhgk_dtl` varchar(255) DEFAULT NULL,
  `dyzhfwz_times` varchar(20) DEFAULT NULL,
  `dyzhfwz_dtl` varchar(255) DEFAULT NULL,
  `szgs_num` varchar(20) DEFAULT NULL,
  `szgs_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gfmz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_gfmz`
--

LOCK TABLES `tz_gfmz` WRITE;
/*!40000 ALTER TABLE `tz_gfmz` DISABLE KEYS */;
INSERT INTO `tz_gfmz` VALUES (1,'2016-03',151,'2016-03-14 00:18:45',12,NULL,NULL,'11','adsf','32','sadfga','12','adsf');
/*!40000 ALTER TABLE `tz_gfmz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_hjmd`
--

DROP TABLE IF EXISTS `tz_hjmd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_hjmd` (
  `hjmd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `zfqz_times` varchar(20) DEFAULT NULL,
  `zfqz_person_num` varchar(20) DEFAULT NULL,
  `hjmdjf_num` varchar(20) DEFAULT NULL,
  `hjmdjf_dtl` varchar(255) DEFAULT NULL,
  `jjlsylwt_num` varchar(20) DEFAULT NULL,
  `jjlsylwt_dtl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hjmd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_hjmd`
--

LOCK TABLES `tz_hjmd` WRITE;
/*!40000 ALTER TABLE `tz_hjmd` DISABLE KEYS */;
INSERT INTO `tz_hjmd` VALUES (1,'2016-03',151,'2016-03-14 00:18:34',12,NULL,NULL,'33','12','231','23','22','adggdsagasdg');
/*!40000 ALTER TABLE `tz_hjmd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tz_ztjj`
--

DROP TABLE IF EXISTS `tz_ztjj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tz_ztjj` (
  `ztjj_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tz_date` varchar(20) DEFAULT NULL,
  `group_party_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by_user` bigint(20) DEFAULT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `last_updated_by_user` bigint(20) DEFAULT NULL,
  `zdcjfzgh_name` varchar(50) DEFAULT NULL,
  `zdcjfzgh_status` varchar(255) DEFAULT NULL,
  `xtzjxm_type` varchar(255) DEFAULT NULL,
  `xtzjxm_purpose` varchar(255) DEFAULT NULL,
  `pyzfns_name` varchar(255) DEFAULT NULL,
  `pyzfns_skill` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ztjj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tz_ztjj`
--

LOCK TABLES `tz_ztjj` WRITE;
/*!40000 ALTER TABLE `tz_ztjj` DISABLE KEYS */;
INSERT INTO `tz_ztjj` VALUES (1,'2016-03',151,'2016-03-14 00:16:55',12,'2016-03-14 01:30:31',12,'adf','进展情况良好','的风味千','很多的哟on国土哦啊的萨芬 阿萨德卡死了的价格拉动及司法 无法卡视角道格拉斯德国','李二','撒地方看看拉萨等级分为');
/*!40000 ALTER TABLE `tz_ztjj` ENABLE KEYS */;
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
INSERT INTO `user_role` VALUES (-1,-2),(-2,-1),(-3,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village_info`
--

DROP TABLE IF EXISTS `village_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village_info` (
  `village_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_id` bigint(20) DEFAULT NULL,
  `village_type` varchar(30) DEFAULT NULL,
  `people_num` int(11) DEFAULT NULL,
  `party_num` int(11) DEFAULT NULL,
  `leader_num` int(11) DEFAULT NULL,
  `person_income` varchar(20) DEFAULT NULL,
  `group_income` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`village_info_id`),
  KEY `FK_jr16` (`party_id`),
  CONSTRAINT `FK_jr16` FOREIGN KEY (`party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village_info`
--

LOCK TABLES `village_info` WRITE;
/*!40000 ALTER TABLE `village_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `village_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-21 21:37:44
