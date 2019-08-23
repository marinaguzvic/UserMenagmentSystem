/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.38-MariaDB : Database - token_base
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`token_base` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `token_base`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `account` */

insert  into `account`(`id`,`first_name`,`last_name`,`username`,`password`,`enabled`,`created`) values 
(1,'Test','Email','test@email.com','$2a$10$jXlure/BaO7K9WSQ8AMiOu3Ih3Am3kmmnVkWWHZEcQryZ8QPO3FgC',1,'2019-08-08 19:29:39'),
(7,'Marina','Guzvic','marina.guzvic@gmail.com','$2a$10$TBHWYHp5Pk1TV2xu5LHK9.UH2MWVnXyfpuG6oAyxvjeoJdilQpFra',1,'2019-08-13 15:19:03'),
(8,'Milos','Djordjevic','milos.djordjevic@mailinator.com','$2a$10$QDgmrV9fNWgp5J/Z29GEReA7ham0YWmsCDMkNnHd.di9fMaRzrFgq',1,'2019-08-13 15:19:04'),
(9,'Anja','Basara','anja.basara@mailinator.com','$2a$10$Nkm7MflBdYR2kwMlJyvf4OU2yNSHSh.Xle1doekVvKa73R6CHonRK',1,'2019-08-13 15:19:05'),
(10,'Jovan','Ilic','jovan.ilic@mailinator.com','$2a$10$0bDLuCw9lywjXfeOKwunoetb5/p0cdI1AGvd.AQb/Ame.n2MV4x.2',1,'2019-08-13 15:19:06'),
(11,'Lilly','Auldrin','lilly.auldrin@mailinator.com','$2a$10$1wxJOpn7eOzp4zw0TIkKH.LNaoKNp1oRRJ/rYKbckMcSfRv4CKWoe',1,'2019-08-13 15:19:07'),
(12,'Ted','Mosby','ted.mosby@mailinator.com','$2a$10$4PhLjKBjP2M7bgmkmonph.QOKAY2r4GWqbqqRo5gYnqeog9cKEdWW',0,'2019-08-11 12:02:50'),
(13,'Robin','Sherbatsky','robin.sherbatsky@mailinator.com','$2a$10$R2uC1toodY7Uv8R8aytwAuv8VJucNA9V/f3yy78aFwNcfUamW43VO',1,'2019-08-11 12:06:57'),
(14,'Marshal','Ericsen','marshal.ericsen@mailinator.com','$2a$10$FJdmlh3YxSuwoAoesC8T6u1kCDb8vMy/Bwy6n3fNWkJFXQ.P8flc2',1,'2019-08-11 12:16:15'),
(16,'Batman','Robin','batman.robin@mailinator.com','$2a$10$K1guRntG85cR8hwRtxq9KOPBrz11BCbVvrow52Kj0b3kFgNKTfCI2',1,'2019-08-13 16:40:32'),
(17,'Jovana','Ilic','jovana.ilic@mailinator.com','$2a$10$gXWXZGI02xWf6D17bGYmdey2beBOtvoXoGu0xh1J3G1eOgNV6BWE.',1,'2019-08-23 10:05:36');

/*Table structure for table `accounts_roles` */

DROP TABLE IF EXISTS `accounts_roles`;

CREATE TABLE `accounts_roles` (
  `account_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`account_id`,`role_id`),
  KEY `role_acc_fk` (`role_id`),
  CONSTRAINT `account_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `role_acc_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `accounts_roles` */

insert  into `accounts_roles`(`account_id`,`role_id`) values 
(1,1),
(7,4),
(8,1),
(9,1),
(10,1),
(11,2),
(12,2),
(13,2),
(14,2),
(17,6);

/*Table structure for table `action_privilege` */

DROP TABLE IF EXISTS `action_privilege`;

CREATE TABLE `action_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `action_privilege` */

insert  into `action_privilege`(`id`,`name`) values 
(1,'CREATE_PRIVILEGE'),
(2,'UPDATE_PRIVILEGE'),
(3,'READ_PRIVILEGE'),
(4,'DELETE_PRIVILEGE'),
(5,'ANY_PRIVILEGE');

/*Table structure for table `email_verification_token` */

DROP TABLE IF EXISTS `email_verification_token`;

CREATE TABLE `email_verification_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(64) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `account_token` (`account_id`),
  CONSTRAINT `account_token` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `email_verification_token` */

insert  into `email_verification_token`(`id`,`token`,`account_id`,`expiry_date`) values 
(1,'4d4ffbce-9766-41d9-b8a3-264e31e518e0',7,'2019-08-11 12:29:06'),
(2,'49dc6647-dbb5-430c-a44f-74a1a789679e',8,'2019-08-11 20:44:06'),
(3,'bd6b96a8-5c11-41c2-8639-f71dbbfd835f',9,'2019-08-12 11:39:50'),
(4,'da8dc370-76f5-426c-97eb-2ef570ce9b16',10,'2019-08-12 11:47:00'),
(5,'48ba68d2-17f4-466f-b26d-f4b07da38870',11,'2019-08-12 11:57:37'),
(6,'aa615edc-fa17-4438-96e9-fa4c6422a90b',12,'2019-08-12 12:02:50'),
(7,'28a46945-204e-4a12-b832-146a4cf4d77e',13,'2019-08-12 12:06:57'),
(8,'d25ce1ee-aac4-4d3a-95f8-a913ed4eadbf',14,'2019-08-12 12:16:15'),
(9,'7378d281-0439-41b2-8480-0028cc2582de',14,'2019-08-12 12:16:17'),
(10,'481f5d82-2ace-49be-aed4-29f1426cdc30',13,'2019-08-13 08:26:06'),
(11,'7c180961-5d58-47f3-846c-cfd6a6726237',13,'2019-08-13 08:27:13'),
(12,'3b592298-466c-4db7-9dd6-c8d436ed862a',16,'2019-08-14 16:40:33'),
(13,'54334e42-0dca-4712-b677-014a54bce29b',16,'2019-08-14 16:40:36'),
(14,'582c07c8-9585-4bc9-a1ae-51e208f59bb0',17,'2019-08-15 06:48:21'),
(15,'93b5396c-24b4-4f28-8d66-b6282b80f6f0',17,'2019-08-15 06:48:24');

/*Table structure for table `object_privilege` */

DROP TABLE IF EXISTS `object_privilege`;

CREATE TABLE `object_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `action_fk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `object_privilege` */

insert  into `object_privilege`(`id`,`name`) values 
(8,'ANY'),
(2,'DOCUMENT'),
(1,'DOCUMENTS'),
(5,'GENERAL'),
(3,'TEMPLATE'),
(4,'TEMPLATES'),
(6,'USER'),
(7,'USERS');

/*Table structure for table `password_reset_token` */

DROP TABLE IF EXISTS `password_reset_token`;

CREATE TABLE `password_reset_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(64) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `password_reset_token` */

insert  into `password_reset_token`(`id`,`token`,`account_id`,`expiry_date`) values 
(1,'cb8ddb3e-6ee5-4b7b-bdb6-e6fe0d001be2',14,'2019-08-13 17:06:35'),
(2,'8430a944-c954-4bdd-b11f-1c6be8e2ddaf',13,'2019-08-14 11:33:19');

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persistent_logins` */

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_id` bigint(20) DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `if_created` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `object_fk` (`object_id`),
  KEY `action_fk` (`action_id`),
  CONSTRAINT `action_fk` FOREIGN KEY (`action_id`) REFERENCES `action_privilege` (`id`),
  CONSTRAINT `object_fk` FOREIGN KEY (`object_id`) REFERENCES `object_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `privilege` */

insert  into `privilege`(`id`,`action_id`,`object_id`,`if_created`) values 
(4,1,2,1),
(5,1,2,0),
(6,3,1,0),
(7,3,2,0),
(8,4,2,0),
(9,3,1,0),
(10,1,3,0),
(11,3,3,0),
(12,1,6,0),
(13,3,7,0),
(14,5,8,0),
(15,2,6,0),
(16,4,6,0),
(17,3,6,0),
(18,3,5,0),
(19,2,3,1),
(20,1,3,0),
(21,4,3,1),
(22,3,3,0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `success_landing_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`success_landing_url`) values 
(1,'ROLE_USER','/home'),
(2,'ROLE_ADMIN','/console'),
(3,'ROLE_EDITOR','/home'),
(4,'ROLE_USER_ADMIN','/users'),
(5,'ROLE_IT','/home'),
(6,'ROLE_TEMPLATE_MAKER','/home');

/*Table structure for table `roles_privileges` */

DROP TABLE IF EXISTS `roles_privileges`;

CREATE TABLE `roles_privileges` (
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`),
  KEY `privilege_fk` (`privilege_id`),
  CONSTRAINT `privilege_fk` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `roles_privileges` */

insert  into `roles_privileges`(`role_id`,`privilege_id`) values 
(1,6),
(1,9),
(1,18),
(2,14),
(2,18),
(3,6),
(3,7),
(3,9),
(3,11),
(3,13),
(3,18),
(4,12),
(4,13),
(4,15),
(4,16),
(4,17),
(4,18),
(5,15),
(5,18),
(6,19),
(6,20),
(6,21),
(6,22);

/*Table structure for table `url_action_object_mapping` */

DROP TABLE IF EXISTS `url_action_object_mapping`;

CREATE TABLE `url_action_object_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_id` bigint(20) DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `object_fk_` (`object_id`),
  KEY `action_fk_` (`action_id`),
  CONSTRAINT `action_fk_` FOREIGN KEY (`action_id`) REFERENCES `action_privilege` (`id`),
  CONSTRAINT `object_fk_` FOREIGN KEY (`object_id`) REFERENCES `object_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `url_action_object_mapping` */

insert  into `url_action_object_mapping`(`id`,`action_id`,`object_id`,`url`,`method`) values 
(1,3,1,'/documents','GET'),
(2,3,2,'/templates/{id}/documents/{id}','GET'),
(3,1,2,'/templates/{id}/documents/add','GET'),
(4,1,2,'/templates/{id}/documents','POST'),
(5,2,2,'/templates/{id}/documents/{id}','POST'),
(6,4,2,'/templates/{id}/documents/{id}/delete','POST'),
(7,3,5,'/home','GET'),
(8,3,5,'/index','GET'),
(9,3,4,'/templates','GET'),
(10,3,3,'/templates/{id}','GET'),
(11,1,3,'/templates/add','GET'),
(12,1,3,'/templates','POST'),
(13,2,3,'/templates/{id}','POST'),
(14,4,3,'/templates/{id}/delete','POST'),
(15,2,3,'/templates/{id}/add-item','POST'),
(16,2,3,'/templates/{id}/delete-item/{id}','POST'),
(17,1,3,'/templates/add-item','POST'),
(18,1,3,'/templates/delete-item/{id}','POST'),
(19,3,7,'/users','GET'),
(20,1,6,'/users/add','GET'),
(21,1,6,'/users','POST'),
(22,3,6,'/users/{id}','GET'),
(23,2,6,'/users/{id}','POST'),
(24,4,6,'/users/{id}/delete','POST');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
