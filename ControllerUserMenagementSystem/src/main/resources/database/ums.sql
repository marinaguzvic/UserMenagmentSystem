/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.38-MariaDB : Database - ums
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ums` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ums`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` bigint(20) unsigned NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `access_token` varchar(100) DEFAULT NULL,
  `password_reset_token` varchar(100) DEFAULT NULL,
  `email_confirmation_token` varchar(100) DEFAULT NULL,
  `role_id_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `user_account` FOREIGN KEY (`account_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `account` */

/*Table structure for table `auditrevisionentity` */

DROP TABLE IF EXISTS `auditrevisionentity`;

CREATE TABLE `auditrevisionentity` (
  `id` int(11) NOT NULL,
  `timestamp` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `auditrevisionentity` */

insert  into `auditrevisionentity`(`id`,`timestamp`,`username`) values 
(1,1566556153290,'jovana.ilic@mailinator.com'),
(2,1566556196883,'jovana.ilic@mailinator.com'),
(3,1566556289065,'lilly.auldrin@mailinator.com');

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `company` */

insert  into `company`(`company_id`,`company_name`) values 
(1,'FON'),
(2,'CloudAfrica'),
(3,'DonDin'),
(4,'Dragon Ball'),
(5,'Levi9');

/*Table structure for table `company_audit_log` */

DROP TABLE IF EXISTS `company_audit_log`;

CREATE TABLE `company_audit_log` (
  `company_id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`,`REV`),
  KEY `FK58613vicnlfo0oq0jrm7c4x2s` (`REV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `company_audit_log` */

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `document_id` bigint(20) NOT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `document` */

/*Table structure for table `document_audit_log` */

DROP TABLE IF EXISTS `document_audit_log`;

CREATE TABLE `document_audit_log` (
  `document_id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`document_id`,`REV`),
  KEY `FKqgigt6wkn3xpxrhl7rhvluevo` (`REV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `document_audit_log` */

/*Table structure for table `document_field` */

DROP TABLE IF EXISTS `document_field`;

CREATE TABLE `document_field` (
  `document_id_fk` bigint(20) NOT NULL,
  `field_id` int(11) NOT NULL,
  `field_value_date` date DEFAULT NULL,
  `field_value_double` double DEFAULT NULL,
  `field_value_integer` int(11) DEFAULT NULL,
  `field_value_long` bigint(20) DEFAULT NULL,
  `field_value_string` varchar(255) DEFAULT NULL,
  `template_field_id_fk` int(11) DEFAULT NULL,
  `template_id_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`document_id_fk`,`field_id`),
  KEY `FKgvyoyf25jjmk1wjt9emu85meu` (`template_field_id_fk`,`template_id_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `document_field` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(4);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `position_id_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKguodx3r7wj0wyr413qmmad3n0` (`position_id_fk`),
  CONSTRAINT `FKguodx3r7wj0wyr413qmmad3n0` FOREIGN KEY (`position_id_fk`) REFERENCES `position` (`position_id`),
  CONSTRAINT `user_position` FOREIGN KEY (`position_id_fk`) REFERENCES `position` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`id`,`email`,`first_name`,`last_name`,`mobile_number`,`gender`,`date_of_birth`,`position_id_fk`) values 
(2,'marina.guzvic@gmail.com','Marina','Guzvic','+38164/933-9101','Female','1995-05-03',4),
(3,'milos.djordjevic@africa.za','Milos','Djordjevic','+2782/123-456','Male','1996-11-10',1),
(4,'anjaxbasara@gmail.com','Marinica','Guzviceva','+38164/933-9101','Female','1999-10-26',2),
(6,'jovan.ilic2@gmail.com','Jovan','Ilic','+38163/155-6666','Male','1995-11-30',4),
(7,'petar.trifunovic@yahoo.com','Petar','Trifunovic','+2782/123-555','Male','1994-09-12',2),
(8,'jelena.iles@hotmail.com','Jelena','Iles','+38163/129-1286','Female','1990-02-04',4),
(9,'ana.dandolo@gmail.com','Ana','Dandolo','+38163/129-2323','Female','2000-06-21',1),
(10,'the.black.cat@cupboard.com','Mile','Bubisic','+38163/129-111','Male','1993-05-10',3),
(11,'orange.cat@basket.com','Cira ','Spiridonovic Djordjevic','+38163/144-333','Male','1999-06-11',1),
(12,'invisible.cat@cupboard.com','Kaja','Djordjevic','+38164/966-7777','Female','1997-02-09',2),
(13,'zojica@lap.com','Zoja','Djordjevic','+2782/123-1111','Female','2000-05-29',4),
(14,'sniffer@food.com','Buddy','Njuskalo','+38163/144-2424','Male','1989-12-30',1),
(15,'igor.stanojevic@hotmail.com','Igor','Stanojevic','+38163/144-331','Male','1991-02-06',3),
(16,'lana.dragojlovic@gmail.com','Lana','Dragojlovic','+38163/155-7878','Female','2000-03-09',4),
(17,'lana.dragojlovic123@gmail.com','Lana','Dragojlovic','+38163/155-7878','Female','2000-03-09',4);

/*Table structure for table `person_audit_log` */

DROP TABLE IF EXISTS `person_audit_log`;

CREATE TABLE `person_audit_log` (
  `id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `position_id_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKrcyijisq4g3nonytctddvlmhh` (`REV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `person_audit_log` */

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `position_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `position_name` varchar(50) DEFAULT NULL,
  `company_id_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`position_id`),
  KEY `FK2i5of7cea5jcx05f5w8k6g85o` (`company_id_fk`),
  CONSTRAINT `FK2i5of7cea5jcx05f5w8k6g85o` FOREIGN KEY (`company_id_fk`) REFERENCES `company` (`company_id`),
  CONSTRAINT `company_position` FOREIGN KEY (`company_id_fk`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `position` */

insert  into `position`(`position_id`,`position_name`,`company_id_fk`) values 
(1,'Accountant',1),
(2,'HR',2),
(3,'QA specialist',3),
(4,'Java Developer',4);

/*Table structure for table `position_audit_log` */

DROP TABLE IF EXISTS `position_audit_log`;

CREATE TABLE `position_audit_log` (
  `position_id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  `company_id_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`position_id`,`REV`),
  KEY `FK2gadnkhs30hc8gi6p9hypupfj` (`REV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `position_audit_log` */

/*Table structure for table `revinfo` */

DROP TABLE IF EXISTS `revinfo`;

CREATE TABLE `revinfo` (
  `REV` int(11) NOT NULL AUTO_INCREMENT,
  `REVTSTMP` bigint(20) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`REV`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `revinfo` */

insert  into `revinfo`(`REV`,`REVTSTMP`,`username`) values 
(1,1566386751504,NULL);

/*Table structure for table `template` */

DROP TABLE IF EXISTS `template`;

CREATE TABLE `template` (
  `template_id` bigint(20) NOT NULL,
  `template_file` longblob,
  `template_file_name` varchar(255) DEFAULT NULL,
  `template_file_type` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`template_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `template` */

insert  into `template`(`template_id`,`template_file`,`template_file_name`,`template_file_type`,`template_name`) values 
(1,'https://dl.acm.org/citation.cfm?id=599797\r\nhttps://ieeexplore.ieee.org/abstract/document/591650','Potential books master.txt','text/plain','Tamplaetaa'),
(2,'PK\0\0\0\0\0!\0ğ!ì}\0\0\0\0\0[Content_Types].xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0´”MOÂ@†ï&ş‡f¯¦]ğ`Œ¡pP<*‰ÏËv\n»ÙY¾ş½Ó\Z4@QğÒ¤İ}ß÷ÙÙÎô+]Dğ¨¬IY7é°Œ´™2Ó”½Ÿã{a&…5²5 ô¯¯zãµŒHm0e³Üç(g &Ö¡•Üz-½ú)wB~Š)ğÛNçKk˜‡Òƒõ{O‹y¢áŠ>×$\ndÑc½±ÌJ™p®PR\"å“ıH‰7		)«=8Soƒñ½	åÊá€î•JãUÑHøğ\"4ağ¥õÏ¬œk:CrÜf§Ís%¡Ñ—nÎ[	ˆTs]$ÍŠÊlùr˜¹€\'ååA\ZëVëğòµï‰ñ*Ì†y’ş¸öKÑ—•Oêˆm{\Z„@õ>%ä{Äm7çV„%LŞşbÇ¼$§ş‹I\'Tü—Åh¬[!\ràÕ³{6Ges,’Úsä­C\ZbşÇŞN©RSß;ğAA3§öõy“HğìóA9b3Èödój¤÷¿\0\0\0ÿÿ\0PK\0\0\0\0\0!\0‘\Z·ó\0\0\0N\0\0\0_rels/.rels ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Œ’ÛJA†ïßaÈ}7Û\n\"ÒÙŞH¡w\"ë„™ìwÌ¤Ú¾½£ ºPÛ^æôçËOÖ›ƒ›Ô;§<¯aYÕ Ø›`Gßkxm·‹PYÈ[š‚g\rGÎ°inoÖ/<‘”¡<Œ1«¢â³†A$>\"f3°£\\…È¾TºI	S‘ÌõŒ«º¾ÇôWš™¦ÚY\rigï@µÇX6_Ö]7\Z~\nfïØË‰ÈaoÙ.b*lIÆrj)õ,\Zl0Ï%‘b¬\n6ài¢ÕõDÿ_‹…,	¡	‰Ïó|uœZ^tÙ¢yÇ¯;!Y,}{ûCƒ³/h>\0\0ÿÿ\0PK\0\0\0\0\0!\0ĞDÓ‡,\0\0>\0\0\0word/_rels/document.xml.rels ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¬“ÁNÃ0†ïH¼C•;M;`Chí.€´+qNS§­h’*ö€½=Ñª­-+=õèßòïÏ³Şüè:ø‡•5	‹Ãˆ`¤Í+S$ì}÷róÀ$arQ[	;\0²Mz}µ~…Z/Â²j0ğ.V5œ£,AmÆg”uZ]Á!?E|EKîú,xÛ<an›ß²`wh|ç?Şº’Î¢UJ«¹Uª’G×ÕĞ•#jÀŠÊg¥@z?á\n „]¤BËø8Çê‘[˜\'+÷\ZŒÊÉï:cØŠñÃbN†vú¢§ÚÇs¶7{ógÖœ¥)ˆåœÊ\ZÚ‰¬î½ÅYš‚¸Ÿâ²7 ò«èİfOœ¹›/(NÊ	~}ú\0\0ÿÿ\0PK\0\0\0\0\0!\0û]©’\0\0I\0\0\0\0\0word/document.xmlìXÍn7¾è;{jËZÉŠí‘ƒÔn£ XÉ¥—b´K­¨åHîªöô”‡È‹ôd¿W‡û\')Rd+AÜB( h—g>ÎgöÕë?\'95–)9:‡a@¨ŒTÌd2>¼Û:\rˆu càJÒApKmğúìÇ^Íû±Š2A¥#!m®£A0uN÷ÛmM©\0{(Xd”Uw)ÑV“	‹h{®LÜî†°xÓFEÔZÜïd6¨àÄ:šÒTâ^e8{¨LÒ`ÒL·]ƒccÆ™»Eìğ¸†Qƒ 3²_	ÔjòKú¥@Õ£^aÖ´Ø°o¹ò¢b Ø±m(G”´S¦j|-\Zª8­EÊ·)‘^Ï›ëNom¿Få§œÁ…9Åp\rnq¹Hğ’¾‹Sı±nS¦:ÑÈğV÷¬%ÀdóuÔ,“‹ñ-ö}iT¦q4û6´+™6XŞ1w,<.<oY5»Àšë¦ i@DÔ¿J¤20æ(Ñ¼Ó#Ş\"ƒ3cßú§&ó>›øf„áÛ°sòò$¨»†èzaø²õŞ4tw~äÅQïüô¢€ÓCãÑLù·}ÃŞ!P|tOƒªçÜ~ŞÇA&uŸ5­kp²u3òóÛ>kø’}·ç}wö¬£†0}/+Å*şõ\Z!µ”ëTU#ÃÍìé‘»å´&ãšY7‰=-ù“™(	f<çõ¼°»Šë¾NÅ_³ :˜È^âõñuš‘Ëb6³)#Ú0AÍÿ„Ö¿Ùª=aWÖxø›å gtg¶èÛmnÿ<öÙ­ğY|ëæ,…ˆÍ€ÜùßÃ\'Ç\\¶³Íì\Z’E·÷Ô:f¼¨Õ¤û§æ…J‹ü¼<ÅTáQjƒêBéŒüdyvÿf4g$U†=|ºÿ‹ÊŒ¬ş*ŒXšæX°EI9Xœƒá$K]f€8cö{€î?JÖ,¯§2¡9õÕB!Íq‹3`.şùqÃúrZ°:ò…»nÿâÎÁ|•¥›%Ç\\ÙÎßãóRö´ó…ş!WñsYÂ÷ÕdhhÂiLÔ=]s«ææ…ıPñ7_sûx’K  ³»=ÑlëîK•úï#Æa¶ÃbL¯}½\"A`ÙóÇ¥ú¢´Ì’ë¹¿JŸ+—3ËRc=›_õÃÿ¦‡ş)Ÿù#İÙˆKWÕÿ7ÃĞ5Ãü½¶QIK#74Uš[Ô±«¢ß¬hZmÉÈ×¦süÀÖíö\n[™âû‹S|/\nU¼è”Æş^9Å°dŠuoİ+ç”X´9,N)Äëç“n?Q\nuhšIæŠfµ]¤¸¯‹­†\rÖ/)¤Àz—†yCåLÒ!sJyt\\ŒbX/õ.JÑ²šÇ¾úàÙ?\0\0\0ÿÿ\0PK\0\0\0\0\0!\00İC)¨\0\0¤\0\0\0\0\0word/theme/theme1.xmlìYOoÛ6¿Øw toc\'v\ZuŠØ±›-MÄn‡i‰–ØP¢@ÒI}Úã€Ãºa‡Øm‡a[Ø¥û4Ù:lĞ¯°GR’ÅX^’6ØŠ­>$ùãûÿ©«×îÇ!)OÚ^ırÍC$ñy@“°íİö/­yH*œ˜ñ„´½)‘Şµ÷ß»Š×UDb‚`}\"×qÛ‹”J×—–¤ÃX^æ)I`nÌEŒ¼Šp)øèÆli¹V[]Š1M<”àÈŞ\Z©OĞP“ô6râ=¯‰’zÀgb Ig…ÁuSÙebÖö€OÀ†ä¾òÃRÁDÛ«™Ÿ·´qu	¯g‹˜Z°¶´®o~ÙºlAp°lxŠpT0­÷­+[}`j×ëõº½zAÏ\0°ïƒ¦V–2ÍF­ŞÉi–@öqv·Ö¬5\\|‰şÊœÌ­N§Óle²X¢dsøµÚjcsÙÁÅ7çğÎf·»êà\rÈâWçğı+­Õ†‹7 ˆÑä`­ÚïgÔÈ˜³íJø\ZÀ×j|†‚h(¢K³óD-Šµßã¢\0\rdXÑ©iJÆØ‡(îâx$(Öğ:Á¥;äË¹!ÍI_ĞTµ½S1£÷êù÷¯?EÇ?øéøáÃã?ZBÎªmœ„åU/¿ıìÏÇ£?~óòÑÕxYÆÿúÃ\'¿üüy5Òg&Î‹/ŸüöìÉ‹¯>ıı»GğMGeøÆD¢›äíó3Vq%\'#q¾ÃÓòŠÍ$”8ÁšKıŠôÍ)f™w9:Äµàå£\nx}rÏx‰‰¢œw¢ØîrÎ:\\TZaGó*™y8IÂjæbRÆíc|XÅ»‹Ç¿½I\nu3KGñnD1÷NIBÒsü€\níîRêØu—ú‚K>Vè.EL+M2¤#\'šf‹¶i~™Véşvl³{u8«Òz‹ºHÈ\nÌ*„æ˜ñ:(W‘â˜•\r~«¨JÈÁTøe\\O*ğtHG½€HYµæ–\0}KNßÁP±*İ¾Ë¦±‹ŠTÑ¼9/#·øA7ÂqZ…Ğ$*c?¢íqUßån†èwğNºû%»O¯·ièˆ4=3¾¼N¸¿ƒ)cbJ\ru§VÇ4ù»ÂÍ(TnËáâ\n7”Ê_?®ûm-Ù›°{UåÌö‰B½w²<w¹èÛ_·ğ$Ù#ó[Ô»âü®8{ÿùâ¼(Ÿ/¾$Ïª0hİ‹ØFÛ´İñÂ®{L¨)#7¤i¼%ì=Aõ:sâ$Å),àQg20pp¡Àf\r\\}DU4ˆp\nM{İÓDB™‘%J¹„Ã¢®¤­ñĞø+{ÔlêCˆ­«]Øá=œŸ5\n2FªĞhsF+šÀY™­\\Éˆ‚n¯Ã¬®…:3·ºÍE‡[¡²6±9”ƒÉÕ`°°&45Z!°ò*œù5k8ì`Fmwë£Ü-Æé\"á€d>ÒzÏû¨nœ”ÇÊœ\"ZúàxŠÕJÜZšìp;‹“Êì\ZØåŞ{/å<óP;™,)\'\'KĞQÛk5—›òqÚöÆpN†Ç8¯KİGbÂe“¯„\rûS“ÙdùÌ›­\\17	êpõaí>§°SR!Õ–‘\r\r3•…\0K4\'+ÿrÌzQ\nTT£³I±²Áğ¯Ivt]KÆcâ«²³K#Úvö5+¥|¢ˆDÁ\Z±‰ØÇà~ª O@%\\w˜Š _ànN[ÛL¹Å9Kºò˜ÁÙqÌÒgåV§hÉn\nR!ƒy+‰ºUÊn”;¿*&å/H•rÿÏTÑû	Ü>¬Ú>\\\rŒt¦´=.TÄ¡\n¥õû\ZS; Zà~¦!¨à‚ÚüäPÿ·9gi˜´†C¤Ú§!ö#	Bö ,™è;…X=Û»,I–2UW¦Vì9$l¨kàªŞÛ=A¨›j’•ƒ;î{–A£P79å|s*Y±÷Úø§;›Ì ”[‡MC“Û¿±hf»ª]o–ç{oY=1k³\ZyV\0³ÒVĞÊÒş5E8çVk+ÖœÆËÍ\\8ğâ¼Æ0X4D)Ü!!ıö?*|f¿vè\ruÈ÷¡¶\"øx¡‰AØ@T_²ÒÒ q²ƒ6˜4)kÚ¬uÒVË7ëît¾\'Œ­%;‹¿Ïiì¢9sÙ9¹x‘ÆÎ,ìØÚ-45xödŠÂĞ8?ÈÇ˜Ïdå/Y|t½ß&LILğJ`è¡& ù-G³tã/\0\0\0ÿÿ\0PK\0\0\0\0\0!\0­Â\n‘\0\0ş\0\0\0\0\0word/settings.xml´V[oÛ6~Ğÿ`è¹$[v!JÑ&óÖ\"^‡)ı”tlá\r$eÅıõ;$Å¸A¼ XÑ\'‘çòû¡®><r6Ùƒ6TŠ*ÉÏ²d¢•Û*ùv¿š^$c‰è“ªä\0&ùpıî·«¡4`-Š™	BSò¶JvÖª2MM»NÌ™T ¹‘š‹W½M9Ñ½š¶’+biCµ‡t–eËd„‘UÒkQSN[-ÜX§RÊÍ†¶0~¢†~‹İ y+Ûƒ°Şbª¡R˜U&¢ñÿ‹†!î\"Èşµ öœE¹!Ï^“Ã¤î4ŞâSPZ¶`ˆ³.\'T<ÁäÅ §TŸaªÓ`;uP¨gştôÜ°ú\'ªªxGMt(36€ó‚·åç­š4›jÈ‹ä\Z;ê»”|2”\nt‹Eª’Ë,Ic‘›ÚÈ5\nóíÙ2 ˆ5”[M86V•Š×é`CzfïIS[©PhOĞåóÙÙîˆ&­]+Ò\"ÚVKå:ù—´7Ø¤\Zsœ-ëÜ	§:´?jÂ1ˆ@[z-;põš¾ÈÓæÙ)x/1>†Ó†$«¦`hj{`°Bçkú>ŠîKo,Å!ñı¼æ\0gù+÷ıAÁ\nˆí1M¿È˜¯ÄŠQµ¦ZKıYtØ\Z?k,EtåÄİ×™xøGJËeùr±,ÎC.œØ›8¿Ïg³ü”Îb^Ü\\Üä\\dç·‹SœË\"›OqVY~~é}ÃhÆxé¶Ğßúú*œ\\cLxhªÂMÉdíö¶/ığ‰ŠÈo\0÷4üÈ©û&2§ÓÀ0œ0¶ÂÉ‰?N¼ì¨Q·°ñ°lMôöˆ;Jè“TœÒ/OXnèAÿ¡e¯‚µA\nÍåE1âQaï(tÓ7uÔ¸k~`õ¢ûº×0=¦g(->Q~pîˆØÆº‚˜~«(öÓµ{Æ`M”Â\"Í6¯F·;›»f·xëğ9ó—f;y3ÏÃ›ãùi]d(=œ@8¢Ôx8Òæ‘6?ÒpY¹âH[DÚâH[F\Z>§C¹ÃéÔ¸*pÅ££o$cr€îÏH¬’¤³#\n°®n“âˆÈÒÆÕj&ûqMCG-ş%(Úqòˆ?ÙléÔGiF²·ÏdÏ	«gÔIG,Au_ªgÊX:ÜûÏ}ÊZŠíXxs\\ÜgÁqF­Aá·RcÈ~­¾÷ÈÇ—ë\0\0ÿÿ\0PK\0\0\0\0\0!\0Ïd±”“\0\0b;\0\0\0\0\0word/styles.xml´›]s›:†ïÏÌù÷©¿Ò¸ÍÔí¤I{š™~¤u2çZ9Öà&é¯?«VØ\rô*1 }VÚÕ»8Ñ¾ywGŞ/™fJ\'òbì{2	t¨’Û…sıñè•ïe¹HBéD.ü™ùïŞşı×›»Ó,ˆdæ$;ƒ…¿Éóíéh”‹ì…ŞÊn®u\Z‹>¦·£X¤?wÛ£@Ç[‘«•ŠTş0šÇ\'~a&¥XÑëµ\nä…v±Lr?Jeu’mÔ6Û[»£X»Ói¸Mu ³&GÖ^,TâÌLk†b¤:ÓëüLfd=\ZS0|2ÆßâÈ÷âàôò6Ñ©XE°xw“cÿ-¬\\¨ƒ¹»(ÏÌÇô*->ŸğÇGä™ww*²@©kXR0+°õé,É”w¤Èò³L‰ƒ77æ©ƒw‚,/Y{¯Bå1û\r6‰háO§û+çÆƒ\'×\"‘Üî¯ÉäèfYödá»K+°»ğEz´<3ÆF8ÍıÏÒt·O&ŸĞ•­ Àë\\BR@N¤LNç/öÃYW±ËuA\0+›…•‡\\ÌYÚ†»rıY?e¸ÌáÆÂG\\¼¹¼J•N!Işë×†	—2VŸTJ³_Šk7ÉF…òßLn2>^ÿş“¿°è]’ƒû\'sÌ‚(?ÜrkÒL\'ÂDø«\0‰á(qĞ¡zôÆ^¨Pñâ{äÄÆğ e#…Ùáúß\nÂYïzƒ¦fFå	 ]–¯³ş&û›xÙß&o¿µ˜÷÷t½oDln”²’Ô\\6ùÊë0{İ’²fD-‹:GÔ’¦sD-G:GÔR¢sD-:GÔŞ9¢ßÎµp¶\nW5‹f¸\Z¤}­òHšñ­4é)uE©ñ®D*nS±İx¦°VİnËån•Ó\\E9}¾X.óT\'·+ÕÙlİgkò‡x»™‚·¤¥Ÿö\\úkóÖãı“ª°õÒ&_mNøbr°„]E\"…2õ®å½(cüWí-í[F§s=ÃúYİnro¹Á’Û	;iXôæ•°ö?«× u34L¥Ë8)†\'\ryÙlü‹Õ.Ş/\rámäÄê9#ÌºØ¾DÇ&DõİÕ9\0Êl¹àOíü·Å…oßÄ˜â¿-EÏ´Oğß®gÚÇüh/[i.àK«GÚ^söŞ=×‘N×»h¿:åaÎŞÁA›{;û$‘˜³wğùôÎ‚\0¾¹Qò”‹GePØá°Ülô¹°ƒR‘½	cFì\0UXS«ŸÖ2@lÑı!)ó71n1@•vïšÛyÖ°P‚HïĞßw:ï~‡6h•r™ÀŸK2éÑh³†G¥ùdë#Æı\nÔ¯2@ıJ!ÔÍï<®&Ò!ı‹#ƒÅ–eWÅ0íÈÊ<g+³ñJÀ@u“ğşÕ°{›s¡^7	v€êu“@aG§RË\\İ$°«›VCÕhQYS9“b×Í2È½	f4Œx@Ãˆ74Œx@ıÅ»2œxXlmpšZoá|Õw ²x@lm°jWüÍh_÷ĞJû—ÛÄ›@a¨.Ş\n;:MâM`á#œL¨°œÔXÃˆ74Œx@Ãˆ74Œx@Ãˆ7Ô_¼»!Ã‰7ÅÖ§©eñ&€Øòà@eñ&€ğ6oÜõ\\¼	v€êâM °£ST÷’J`±Ta9ñ&°ğN2,LnÎ¤†oÂŒ†ohñ&€†o¨¿xwC†o‹­\rNSËâM\0±åÁÊâM\0±µá xãfüãâM °To…Š :#°Øª°œxX˜/½Å›\0ÂGâÌhñ&Ìhñ&€†o¨¿xwC†o‹­\rNSËâM\0±åÁÊâM\0±µá xãùãâM °To…Š :ñ&°Øª°œÔXÃˆ7„‰Ù[¼	 |ä ÜEœ0\r#Ş„\r#ŞPñî†\'Ş[œ¦–Å›\0bËƒ•Å›\0bkƒ9gçEÉÇS\'\rI@=g°?Õ@N‚Dü!×2…&+Ù}:¤\'p?C±!=¨S|¯õOv°{Ö d”ZEJã‘î<¥SjD˜Í[:	®¿{ŸlLm¦ÔÓ“7Ğ=TnÂö$Ó8~æ[hÙÙîO–kĞ dúºŠ l‘»„† ¢­Ç6}>ğ 6U—ñÿ¶~\"¬£‚\r°èˆjAŞİ$<î^7œŠGG[2ön§ãß¡ìsOÎh¶ú›“à->ãIñÖ5òğÕºƒĞœ….uy![E¶Å~¹LB˜!4	âÍl0Ã{aMÁısE_6¤åzÛüh$×¹½;c¬˜Zé<×qóøˆ£\'‡@:”±Í$šó$ÙÅ+™B‡WËšÕ¦r`\'ÚÓ”´g]RºÒÍ¾=Ù.nƒ_\\ÊÖœÂ\Z÷x}[	hµûf:çj[© pÎ=n2èGÌàÀs1z<~9;>uaŸ*ºæ‡‰îÂŸC3Z {Ú\rv\"*Úà*LvßwXlÜıô³·ÿ\0\0ÿÿ\0PK\0\0\0\0\0!\0`?Ñ\0\0S>\0\0\Z\0\0\0word/stylesWithEffects.xml´›[s›:ÇßÏÌùï©/Iã6S·“&½d¦—´Næ<Ë Çš\0âp‰“óéÏJƒ1»†>%´¿]íê¿Ä‘Ş}xç‰\'©ÑÜ¼\Z»<é‹èaîŞß}>yã:iÆ\"Ÿ2âs÷…§î‡÷ÿõns‘f/O0¥›Ø›»ë,‹/F£Ô[ó¥¯Bá%2•«ì•\'Ã‘\\­„ÇG™ø£éx2Ö¿Å‰ôxšíŠEO,usaÓšŒy¬•LB–¥¯dò0\nYò˜Ç\'`=f™XŠ@d/`{|^š‘s7O¢‹Â¡ë\Zra*~”#’F{¸fäµôòG™&€2J×\"Ş†q¬5q]ºôt(ˆ§0(ŸÛÄ“³Ï†ŒÉÁuÂ6Š­Á†¹=“á›Aa`æAåw›ÕºÅÉøP0EF”	ëÆ…]féIÈDdÍ75ÕÉ…õĞ§¾¿$2­;±ègí&z´¶Ô²$x6>×+¯\ZZJ2ĞXº‹5‹¹ë„ŞÅÍC$¶À£ÍäÌQé¾©ğ¥wÍW,²T}Ln“âcñIÿø,£,u6,õ„¸	+¡\0ƒ_/£T¸p‡³4»LÛ{s­Ú{ÇK³ŠµÂîHÓÿÀææîtZ^¹Rì\\XôP^ãÑÉı¢êÉÜµ—–`wî²ädq©Œt˜åÏJ¸ñNğğI»3VpØ*ã B bŠ•İéÍ|ø«Éey&ˆ6\0°ªYøX›qĞ&Pª…Ql¸ËWß¤÷ÈıE7æ®fÁÅû›ÛDÈdtî¾}«˜pqÁCñUø>W\r¢¸v­…ÏÿYóè>åşöú¯ÏZ‹Ì£Ü?Ÿé*RÿÓ³Çc%“`:b*Ã?Ô\0Ğ0HG…£ÊÅÖs¡FÕÿ-‘“Ã½”5gª¥9Úÿƒ uŞ4UUĞvI¾ö7qÖßÄëş&tñö›‹Y/àE¦oFLmTªŸÔLz¦øªópúö@Éª*êÑ(šÎ\ZéÑ(‰Î\nèÑHxçˆF~;G4Òyp„Ç´pÕ«èTÏjaß‰,€>Ù¡t“RW´\Zç–%ì!añÚQµîö!±\\äËçª–ÓãÅr‘%R½nvÌtgµtÖäOa¼f©€·ò.PÏ©¿S¯>Î—DÀëkêµ)¾FLúÅdo»\r˜Ç×2ğyâÜñg“QÂøÒY˜·ŒNçz¦õ›xXg¼ª–Û	;o™ôö™0ö¿‰TÏÁÁn~ŞJ—qTÏ[ê²İøwî‹<,§ñ6rnôœæ\ZB»xxŠÎTŠš««3\n•\0L¦]ĞCĞöş›æB·¯rŒñß´¢#í#ü7ëHûº>ç—¬4×ğµŠƒZ^3òÚ½’LVyP®Ny˜‘W°EàB /bk%3ò\nŞ‘OçÒóà/7L’s±ÕQ…œCÑ‹\r9)5Ù›\"\"\'¨ÆšXı´–\0\"‹îoş$Ô—ÀÔf UÚ¾kv.çÓ–€„z‡ş•Ë¬ûzÚ¢yXÊM_—¤ÜÁÑN[V–VÔ“éw„÷k|P¿H\0õk…PK}´¿óØˆ‡ôoY–mÓe‡VæY™-ˆÖê›ˆ÷¯–ÕÛ^Í¾‰ Ôì›\n9;µ^fû&‚5XßD°ZºF{ªšJ	ŠÜ7« û&€ˆhñF€†ohñF€ú‹w7d8ñF°ÈÚ`5µ*Ş~„ò§¾UÅ\"kƒQ»â;£²ïi+‡ÿ¸@¼r‚šâ ³Ó&Ş–~„R	5–•:kñF€†ohñF€†ohñF€ú‹w7d8ñF°ÈÚ`5µ*ŞY,¨*Ş~„¢\r{Å[¯ú?.Ş\n9AMñFPÈÙ©	ª}IE°È	ª±¬x#XúJ1,]Ü” †oDDÃˆ74Œx#@Ãˆ7Ô_¼»!Ã‰7‚EÖ«©UñF€Èò`AUñF€ÈÚ°W¼õbüãâ Ôo…œš ZC°È	ª±¬x#Xº^z‹7¤9D‰hñFD4Œx#@Ãˆ7Ô_¼»!Ã‰7‚EÖ«©UñF€Èò`AUñF€ÈÚ°W¼õ\Zùãâ Ôo…œš ZñF°È	ª±¬Ô!XÃˆ7¤³·x#@ú‘#@zQÒ4Œx#\"\ZF¼ şâİ\rN¼,²6XM­Š7D–ªŠ7DÖµÏö‹¢·§NZŠ\0»Ï ÜÕ€N[’„şæ+À©BŞ½;¤\'°Œ@l)lˆ¥|tp»O[\nË@H½¥ûEïÒ©D88Ip÷óÊùjÀ4Æé’Úİy§‡ªÇ…ôñ$upüÌ^b8²—;Ë•58 ¤ÎuG€ô™Ğ8TëQƒÕ9xPª*.ëÿÛTøˆz`å­åÁ‰¨¨bÃ»İƒ¤·»×Á-»âµ#Û#¥›Åîøí;”yngæA¿3µü€Ïz§øÁ9rô#&«Máp–v©ËCHÙ20GÌà—›È‡7Åé,“Lÿ™SpÿŠÁw¦¤e2n4à«ÌÜŒu¬™ZÊ,“aûøDo×ì3\0åPuÆ|TA´×I”‡KÛÍ[KRu}m·$Í^×–RÀÎt»o;ËÅ.å‹-Ù†SºÇmokß–ÚıT\'ç\ZK©Y °ÏNÚ.28˜Â†çbôxüúôìêÍµyª8…(t}¨ìÎİÙtlîypzä,(€]¶<wX,Ü2üôıÿ\0\0\0ÿÿ\0PK\0\0\0\0\0!\0qMà\0\0Ü\0\0\0docProps/app.xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0œSMoÛ0½Ø0|o”v(FÅbèa[ÄmÏšL\'ÂdIØ Ù¯e7³í4?D>=Rp÷ÖÚâ€1ïVål2-tÚ×ÆíVåSõåê¶,)W+ë®Ê#¦òN~ü\0›èF2˜\n.áÒªÜ…¥Iï±UiÂaÇ‘ÆÇV›q\'|Ó÷^¿¶èHÌ§ÓOß]õU\n–}Ååş·híuæ—«c`Â*lƒU„ò{¦c\'µ§Äà…Ê“²•iQŞÌÙ?X°Q;Lr¢ğâcäÍ-ˆÁz¯¢ÒÄ\nÊÅ‚óF6|Á\Z­ˆµ•ßŒ>ù†ŠÇN…\"ß1NVf‹ú5\Z:Ê)ˆ±	_c\"L®L,ª]TaÿÎn°`«•Å5?_6Ê&qvÀª<Ú2Ì´< &‹d~ñpçeñC%Ì¢­ÊƒŠF9bñrZotØ†DQV†,×æXowpœ6Ææ:KÈ¹.³³çÀKv]‡ôØğKédgc²‡êˆÎ=ş¨ºömPîÈÍÄÿLO¡ò÷yaŞ5¼t¦şbh¿\rJóp·¼çù\"°å-ÁšzªwvÀËmnÊwİëSÎß¼QÏıg•³ëÉ”O·B\'¯éğ‹äo\0\0\0ÿÿ\0PK\0\0\0\0\0!\0œ2Àİz\0\0ã\0\0\0docProps/core.xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŒRQOÂ0~7ñ?,}ßº\r0ºl#¨!1c£ñ­¶TÖ®iƒo·Á`Ñßz÷}÷İİwMÇ;Qx[Ğ†—2CQ\"$-—Ë½Í§ş5òŒ%’‘¢”¡=4Î//RªZjxÖ¥m9Ï)I“P•¡•µ*ÁØĞbÇ\\”ZëB½ÄŠĞ5YÃğ\n°„Kp-è«N$í$ÕF\0£\n ­ÁQá×‚æÏ‚9c\nn÷Êít÷\\›ÑìØ;Ã;bUUA5hÆpóGøcöøÚ¬êsY{Eå)£‰å¶€<Å§§{™Í×7PÛ¦»ÀT±¥Îg“—‡§ISuLÕf¯a_•šWØ‹\\%C5WÖ°•í%» ÆÎÜMØí¾ëğ©iØòú7äqÓ©İFí À<gIÒ\ZxDŞw÷ó)Êã0ºñÃk?\ZÍ£A2Š“0ü¬êÕ×µ	qíŸŠÃd8ì+Zoúß2ÿ\0\0ÿÿ\0PK\0\0\0\0\0!\0\'5ˆi6\0\0Â\0\0\0\0\0word/fontTable.xml¼•KsÚ0…÷éğh,›×2-\r3İtÑ¦Óµ2hª‡G8üû^É6$ÁiqØÁ‘u,}Ü{¸x–\":0c¹Vs”0Š˜¢zÃÕv~>­î&(²¨\rZ±9:2‹?ÜW³B+g#X¯ìLÒ9Ú9WÎâØÒ“ÄtÉLÚHâà«ÙÆ’˜ßûòjYÇ×\\pwŒSŒG¨±1×¸è¢à”}Ñt/™ra}l˜\0G­ì—¶u«®q«´Ù”FSf-œYŠÚO®N6Iva$95ÚêÂ\rà0q½£Ø[Áò‡OR HÒÙ×­Ò†¬°«’-\ZpQ5SD‚øã(×Z½$J[–ÀÔˆ9Â9Ü	ö†c<‚1Çc{º#Æ2wz0­å‚H.­j´$ª(¹£»V?Ãı~ê)Ë·0±·k/l.T+	ÔÃk%½xføZ¡Ágòb(àsr†íÇuå\\€XÁ×†w’Hñ\nNŸ†;ÃC³n¸‹„­¸µ½H<Â†ÓO«Õ™ÄÒ+Ùøs£œIL¥“D8wRû\\Oâ‰Kf£o¬Š¾‡ßĞ£z[ÅHä8d†½ˆô¯@äñ-‘ñ$¿	‘¥ŞÎŒgòN}ŒÅ4Ô‡¯“¬\r©7ÌtµJÁŸÙæ²OŞc‘\roQ¿ ¦|<ÛNyÛjç±»S:3ƒìîÕ(í[ÎrÛÈ¤„/‚¼iß(ı\"ãÿ\Z^6HÿlivR|d€â¯GÆ4DÏ_\"£IQ»ø\0\0ÿÿ\0PK\0\0\0\0\0!\0 N\0\0¬\0\0\0\0\0word/webSettings.xmlŒĞÁJ1à»à;,¹·Ù•\"²t· Rñ\"‚ú\0ivvÌdÂLj¬OoÚª ^zË$™™¹ú@_½‹£Ğ©f^«\n‚¥Á…©S¯/ëÙª$™0O:µQ«şòb™Û›gH©ü”ª(AZ´Ú¦[­ÅnÌ)B(#1šTJ4\Z~ÛÅ™%Œ&¹ó.íõU]_«o†ÏQh…;²;„ıšÁ‘‚l]”-Ÿ£eâ!2Y)û ?yh\\øešÅ?e\ZÓ¼,£OéUÚ›úxB¯*´íÃˆÍÆ—s³P}‰brè>aM|Ë”X®÷”ŸïK¡ÿdÜ\0\0ÿÿ\0PK\0\0\0\0\0!\0èÛÀ»Y\0\0£\0\0\0\0\0word/numbering.xmlÌWÍnÚ@¾Wê; ßƒm0„ ˆ†Ğ¦j£J¡êy±¼ÊşX»k®y™>B+¯ĞYÿapÅ&.±3;¿ßÎ7.¯Ÿíl°TDğ‰åv«ƒ¹/Â×ë÷b~6²:J# *8X[¬¬ë«ÏŸ.“1ÙKPì€®ÆIäO¬PëhlÛÊ1CªËˆ/…+İõ³ÅjE|l\'BvÏqô-’ÂÇJŸÄ7HY¹;V÷&\"Ì!ÖJH†´ê\n¹¶’qtŞ#¤É’P¢·àÛnÄÄŠ%ç	•	“q–Pş(,d­ŠWâf–3áÇsF´%¦ƒà*$Ñ®Œ¶Ş Ä°HióVF½$r½Z¼²ä÷ÜÁL¢®bç°æî0‚ÌˆÑs¿»[=ôè:o“ßˆqQæğöc™0Dxé¦4UpÇô÷W)â¨L\'\"Çy»ã¥/ÃÌ™9Ã”yÕÒT#5ê>„(ÂV‡ùã»5-)d”¸^Çt¤uÓ-•–È×÷1ëìıwL,\'UáŠp¶Atbßº;˜»–mŒYL5ù7˜.¶.tÂíR’à§9£æ,ÓÕ,¢…Æl4ºõ¦½ì„nÌ‡‰¯:¢0dnû®7ŸÏ¦Y1›3]Ø/cJ±.­ø©<zyşWÊ¿û…Å«\\=ú%Mæ„›’Œjê¥QCÄ×éxíãÂNÆ¹²Ìlä\\p­À)Ÿ@—<lÙR\0Ç“1FJOA˜®\00#€õ·)àfCóRÕö•®è}!A¦F8äààòøi`È 1IWrw@9sá8N?•ÀÔƒa·,Ü8øHÈœüÚàñ>0ES(]Ïk‡åˆ%Á²s“\nfRØp \n›¡Ö«¡6øxÔ^ÿ6Å­çBÏ™^iÚƒ cÍR\0ßµ²ÓöeÍ\0Êš(å_ŞVY£}h[µàho4jĞ¤56ì¯Ö;§À8Ví€9$R6¥¤Ç3.ãWµ¡Nƒq^¿åÔßgW†Ú¾¬ã`#.¾x\'Å¸dÓj$}ãÎkĞœãç-gõ·òyt =qğËğ ¡NƒqC¯åßgWÆÁ\nUÙsÍ*+ Íš›mJ;³¦ûn±	‚fºÂ3ûq}õ\0\0ÿÿ\0PK-\0\0\0\0\0\0!\0ğ!ì}\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0[Content_Types].xmlPK-\0\0\0\0\0\0!\0‘\Z·ó\0\0\0N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ç\0\0_rels/.relsPK-\0\0\0\0\0\0!\0ĞDÓ‡,\0\0>\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ë\0\0word/_rels/document.xml.relsPK-\0\0\0\0\0\0!\0û]©’\0\0I\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Y	\0\0word/document.xmlPK-\0\0\0\0\0\0!\00İC)¨\0\0¤\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›\r\0\0word/theme/theme1.xmlPK-\0\0\0\0\0\0!\0­Â\n‘\0\0ş\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0v\0\0word/settings.xmlPK-\0\0\0\0\0\0!\0Ïd±”“\0\0b;\0\0\0\0\0\0\0\0\0\0\0\0\0\0\06\0\0word/styles.xmlPK-\0\0\0\0\0\0!\0`?Ñ\0\0S>\0\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0ö\0\0word/stylesWithEffects.xmlPK-\0\0\0\0\0\0!\0qMà\0\0Ü\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0A(\0\0docProps/app.xmlPK-\0\0\0\0\0\0!\0œ2Àİz\0\0ã\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0W+\0\0docProps/core.xmlPK-\0\0\0\0\0\0!\0\'5ˆi6\0\0Â\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0.\0\0word/fontTable.xmlPK-\0\0\0\0\0\0!\0 N\0\0¬\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0n0\0\0word/webSettings.xmlPK-\0\0\0\0\0\0!\0èÛÀ»Y\0\0£\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¢1\0\0word/numbering.xmlPK\0\0\0\0\r\0\r\0I\0\0+5\0\0\0\0','Masters work plan.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','Tamplaet');

/*Table structure for table `template_audit_log` */

DROP TABLE IF EXISTS `template_audit_log`;

CREATE TABLE `template_audit_log` (
  `template_id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `template_file` longblob,
  `template_file_name` varchar(255) DEFAULT NULL,
  `template_file_type` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`template_id`,`REV`),
  KEY `FK5hhn7kpyhv6rxeoq0785fxavr` (`REV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `template_audit_log` */

insert  into `template_audit_log`(`template_id`,`REV`,`REVTYPE`,`template_file`,`template_file_name`,`template_file_type`,`template_name`) values 
(1,1,0,'https://dl.acm.org/citation.cfm?id=599797\r\nhttps://ieeexplore.ieee.org/abstract/document/591650','Potential books master.txt','text/plain','Tamplaet'),
(1,2,1,'https://dl.acm.org/citation.cfm?id=599797\r\nhttps://ieeexplore.ieee.org/abstract/document/591650','Potential books master.txt','text/plain','Tamplaetaa'),
(2,3,0,'PK\0\0\0\0\0!\0ğ!ì}\0\0\0\0\0[Content_Types].xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0´”MOÂ@†ï&ş‡f¯¦]ğ`Œ¡pP<*‰ÏËv\n»ÙY¾ş½Ó\Z4@QğÒ¤İ}ß÷ÙÙÎô+]Dğ¨¬IY7é°Œ´™2Ó”½Ÿã{a&…5²5 ô¯¯zãµŒHm0e³Üç(g &Ö¡•Üz-½ú)wB~Š)ğÛNçKk˜‡Òƒõ{O‹y¢áŠ>×$\ndÑc½±ÌJ™p®PR\"å“ıH‰7		)«=8Soƒñ½	åÊá€î•JãUÑHøğ\"4ağ¥õÏ¬œk:CrÜf§Ís%¡Ñ—nÎ[	ˆTs]$ÍŠÊlùr˜¹€\'ååA\ZëVëğòµï‰ñ*Ì†y’ş¸öKÑ—•Oêˆm{\Z„@õ>%ä{Äm7çV„%LŞşbÇ¼$§ş‹I\'Tü—Åh¬[!\ràÕ³{6Ges,’Úsä­C\ZbşÇŞN©RSß;ğAA3§öõy“HğìóA9b3Èödój¤÷¿\0\0\0ÿÿ\0PK\0\0\0\0\0!\0‘\Z·ó\0\0\0N\0\0\0_rels/.rels ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Œ’ÛJA†ïßaÈ}7Û\n\"ÒÙŞH¡w\"ë„™ìwÌ¤Ú¾½£ ºPÛ^æôçËOÖ›ƒ›Ô;§<¯aYÕ Ø›`Gßkxm·‹PYÈ[š‚g\rGÎ°inoÖ/<‘”¡<Œ1«¢â³†A$>\"f3°£\\…È¾TºI	S‘ÌõŒ«º¾ÇôWš™¦ÚY\rigï@µÇX6_Ö]7\Z~\nfïØË‰ÈaoÙ.b*lIÆrj)õ,\Zl0Ï%‘b¬\n6ài¢ÕõDÿ_‹…,	¡	‰Ïó|uœZ^tÙ¢yÇ¯;!Y,}{ûCƒ³/h>\0\0ÿÿ\0PK\0\0\0\0\0!\0ĞDÓ‡,\0\0>\0\0\0word/_rels/document.xml.rels ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¬“ÁNÃ0†ïH¼C•;M;`Chí.€´+qNS§­h’*ö€½=Ñª­-+=õèßòïÏ³Şüè:ø‡•5	‹Ãˆ`¤Í+S$ì}÷róÀ$arQ[	;\0²Mz}µ~…Z/Â²j0ğ.V5œ£,AmÆg”uZ]Á!?E|EKîú,xÛ<an›ß²`wh|ç?Şº’Î¢UJ«¹Uª’G×ÕĞ•#jÀŠÊg¥@z?á\n „]¤BËø8Çê‘[˜\'+÷\ZŒÊÉï:cØŠñÃbN†vú¢§ÚÇs¶7{ógÖœ¥)ˆåœÊ\ZÚ‰¬î½ÅYš‚¸Ÿâ²7 ò«èİfOœ¹›/(NÊ	~}ú\0\0ÿÿ\0PK\0\0\0\0\0!\0û]©’\0\0I\0\0\0\0\0word/document.xmlìXÍn7¾è;{jËZÉŠí‘ƒÔn£ XÉ¥—b´K­¨åHîªöô”‡È‹ôd¿W‡û\')Rd+AÜB( h—g>ÎgöÕë?\'95–)9:‡a@¨ŒTÌd2>¼Û:\rˆu càJÒApKmğúìÇ^Íû±Š2A¥#!m®£A0uN÷ÛmM©\0{(Xd”Uw)ÑV“	‹h{®LÜî†°xÓFEÔZÜïd6¨àÄ:šÒTâ^e8{¨LÒ`ÒL·]ƒccÆ™»Eìğ¸†Qƒ 3²_	ÔjòKú¥@Õ£^aÖ´Ø°o¹ò¢b Ø±m(G”´S¦j|-\Zª8­EÊ·)‘^Ï›ëNom¿Få§œÁ…9Åp\rnq¹Hğ’¾‹Sı±nS¦:ÑÈğV÷¬%ÀdóuÔ,“‹ñ-ö}iT¦q4û6´+™6XŞ1w,<.<oY5»Àšë¦ i@DÔ¿J¤20æ(Ñ¼Ó#Ş\"ƒ3cßú§&ó>›øf„áÛ°sòò$¨»†èzaø²õŞ4tw~äÅQïüô¢€ÓCãÑLù·}ÃŞ!P|tOƒªçÜ~ŞÇA&uŸ5­kp²u3òóÛ>kø’}·ç}wö¬£†0}/+Å*şõ\Z!µ”ëTU#ÃÍìé‘»å´&ãšY7‰=-ù“™(	f<çõ¼°»Šë¾NÅ_³ :˜È^âõñuš‘Ëb6³)#Ú0AÍÿ„Ö¿Ùª=aWÖxø›å gtg¶èÛmnÿ<öÙ­ğY|ëæ,…ˆÍ€ÜùßÃ\'Ç\\¶³Íì\Z’E·÷Ô:f¼¨Õ¤û§æ…J‹ü¼<ÅTáQjƒêBéŒüdyvÿf4g$U†=|ºÿ‹ÊŒ¬ş*ŒXšæX°EI9Xœƒá$K]f€8cö{€î?JÖ,¯§2¡9õÕB!Íq‹3`.şùqÃúrZ°:ò…»nÿâÎÁ|•¥›%Ç\\ÙÎßãóRö´ó…ş!WñsYÂ÷ÕdhhÂiLÔ=]s«ææ…ıPñ7_sûx’K  ³»=ÑlëîK•úï#Æa¶ÃbL¯}½\"A`ÙóÇ¥ú¢´Ì’ë¹¿JŸ+—3ËRc=›_õÃÿ¦‡ş)Ÿù#İÙˆKWÕÿ7ÃĞ5Ãü½¶QIK#74Uš[Ô±«¢ß¬hZmÉÈ×¦süÀÖíö\n[™âû‹S|/\nU¼è”Æş^9Å°dŠuoİ+ç”X´9,N)Äëç“n?Q\nuhšIæŠfµ]¤¸¯‹­†\rÖ/)¤Àz—†yCåLÒ!sJyt\\ŒbX/õ.JÑ²šÇ¾úàÙ?\0\0\0ÿÿ\0PK\0\0\0\0\0!\00İC)¨\0\0¤\0\0\0\0\0word/theme/theme1.xmlìYOoÛ6¿Øw toc\'v\ZuŠØ±›-MÄn‡i‰–ØP¢@ÒI}Úã€Ãºa‡Øm‡a[Ø¥û4Ù:lĞ¯°GR’ÅX^’6ØŠ­>$ùãûÿ©«×îÇ!)OÚ^ırÍC$ñy@“°íİö/­yH*œ˜ñ„´½)‘Şµ÷ß»Š×UDb‚`}\"×qÛ‹”J×—–¤ÃX^æ)I`nÌEŒ¼Šp)øèÆli¹V[]Š1M<”àÈŞ\Z©OĞP“ô6râ=¯‰’zÀgb Ig…ÁuSÙebÖö€OÀ†ä¾òÃRÁDÛ«™Ÿ·´qu	¯g‹˜Z°¶´®o~ÙºlAp°lxŠpT0­÷­+[}`j×ëõº½zAÏ\0°ïƒ¦V–2ÍF­ŞÉi–@öqv·Ö¬5\\|‰şÊœÌ­N§Óle²X¢dsøµÚjcsÙÁÅ7çğÎf·»êà\rÈâWçğı+­Õ†‹7 ˆÑä`­ÚïgÔÈ˜³íJø\ZÀ×j|†‚h(¢K³óD-Šµßã¢\0\rdXÑ©iJÆØ‡(îâx$(Öğ:Á¥;äË¹!ÍI_ĞTµ½S1£÷êù÷¯?EÇ?øéøáÃã?ZBÎªmœ„åU/¿ıìÏÇ£?~óòÑÕxYÆÿúÃ\'¿üüy5Òg&Î‹/ŸüöìÉ‹¯>ıı»GğMGeøÆD¢›äíó3Vq%\'#q¾ÃÓòŠÍ$”8ÁšKıŠôÍ)f™w9:Äµàå£\nx}rÏx‰‰¢œw¢ØîrÎ:\\TZaGó*™y8IÂjæbRÆíc|XÅ»‹Ç¿½I\nu3KGñnD1÷NIBÒsü€\níîRêØu—ú‚K>Vè.EL+M2¤#\'šf‹¶i~™Véşvl³{u8«Òz‹ºHÈ\nÌ*„æ˜ñ:(W‘â˜•\r~«¨JÈÁTøe\\O*ğtHG½€HYµæ–\0}KNßÁP±*İ¾Ë¦±‹ŠTÑ¼9/#·øA7ÂqZ…Ğ$*c?¢íqUßån†èwğNºû%»O¯·ièˆ4=3¾¼N¸¿ƒ)cbJ\ru§VÇ4ù»ÂÍ(TnËáâ\n7”Ê_?®ûm-Ù›°{UåÌö‰B½w²<w¹èÛ_·ğ$Ù#ó[Ô»âü®8{ÿùâ¼(Ÿ/¾$Ïª0hİ‹ØFÛ´İñÂ®{L¨)#7¤i¼%ì=Aõ:sâ$Å),àQg20pp¡Àf\r\\}DU4ˆp\nM{İÓDB™‘%J¹„Ã¢®¤­ñĞø+{ÔlêCˆ­«]Øá=œŸ5\n2FªĞhsF+šÀY™­\\Éˆ‚n¯Ã¬®…:3·ºÍE‡[¡²6±9”ƒÉÕ`°°&45Z!°ò*œù5k8ì`Fmwë£Ü-Æé\"á€d>ÒzÏû¨nœ”ÇÊœ\"ZúàxŠÕJÜZšìp;‹“Êì\ZØåŞ{/å<óP;™,)\'\'KĞQÛk5—›òqÚöÆpN†Ç8¯KİGbÂe“¯„\rûS“ÙdùÌ›­\\17	êpõaí>§°SR!Õ–‘\r\r3•…\0K4\'+ÿrÌzQ\nTT£³I±²Áğ¯Ivt]KÆcâ«²³K#Úvö5+¥|¢ˆDÁ\Z±‰ØÇà~ª O@%\\w˜Š _ànN[ÛL¹Å9Kºò˜ÁÙqÌÒgåV§hÉn\nR!ƒy+‰ºUÊn”;¿*&å/H•rÿÏTÑû	Ü>¬Ú>\\\rŒt¦´=.TÄ¡\n¥õû\ZS; Zà~¦!¨à‚ÚüäPÿ·9gi˜´†C¤Ú§!ö#	Bö ,™è;…X=Û»,I–2UW¦Vì9$l¨kàªŞÛ=A¨›j’•ƒ;î{–A£P79å|s*Y±÷Úø§;›Ì ”[‡MC“Û¿±hf»ª]o–ç{oY=1k³\ZyV\0³ÒVĞÊÒş5E8çVk+ÖœÆËÍ\\8ğâ¼Æ0X4D)Ü!!ıö?*|f¿vè\ruÈ÷¡¶\"øx¡‰AØ@T_²ÒÒ q²ƒ6˜4)kÚ¬uÒVË7ëît¾\'Œ­%;‹¿Ïiì¢9sÙ9¹x‘ÆÎ,ìØÚ-45xödŠÂĞ8?ÈÇ˜Ïdå/Y|t½ß&LILğJ`è¡& ù-G³tã/\0\0\0ÿÿ\0PK\0\0\0\0\0!\0­Â\n‘\0\0ş\0\0\0\0\0word/settings.xml´V[oÛ6~Ğÿ`è¹$[v!JÑ&óÖ\"^‡)ı”tlá\r$eÅıõ;$Å¸A¼ XÑ\'‘çòû¡®><r6Ùƒ6TŠ*ÉÏ²d¢•Û*ùv¿š^$c‰è“ªä\0&ùpıî·«¡4`-Š™	BSò¶JvÖª2MM»NÌ™T ¹‘š‹W½M9Ñ½š¶’+biCµ‡t–eËd„‘UÒkQSN[-ÜX§RÊÍ†¶0~¢†~‹İ y+Ûƒ°Şbª¡R˜U&¢ñÿ‹†!î\"Èşµ öœE¹!Ï^“Ã¤î4ŞâSPZ¶`ˆ³.\'T<ÁäÅ §TŸaªÓ`;uP¨gştôÜ°ú\'ªªxGMt(36€ó‚·åç­š4›jÈ‹ä\Z;ê»”|2”\nt‹Eª’Ë,Ic‘›ÚÈ5\nóíÙ2 ˆ5”[M86V•Š×é`CzfïIS[©PhOĞåóÙÙîˆ&­]+Ò\"ÚVKå:ù—´7Ø¤\Zsœ-ëÜ	§:´?jÂ1ˆ@[z-;põš¾ÈÓæÙ)x/1>†Ó†$«¦`hj{`°Bçkú>ŠîKo,Å!ñı¼æ\0gù+÷ıAÁ\nˆí1M¿È˜¯ÄŠQµ¦ZKıYtØ\Z?k,EtåÄİ×™xøGJËeùr±,ÎC.œØ›8¿Ïg³ü”Îb^Ü\\Üä\\dç·‹SœË\"›OqVY~~é}ÃhÆxé¶Ğßúú*œ\\cLxhªÂMÉdíö¶/ığ‰ŠÈo\0÷4üÈ©û&2§ÓÀ0œ0¶ÂÉ‰?N¼ì¨Q·°ñ°lMôöˆ;Jè“TœÒ/OXnèAÿ¡e¯‚µA\nÍåE1âQaï(tÓ7uÔ¸k~`õ¢ûº×0=¦g(->Q~pîˆØÆº‚˜~«(öÓµ{Æ`M”Â\"Í6¯F·;›»f·xëğ9ó—f;y3ÏÃ›ãùi]d(=œ@8¢Ôx8Òæ‘6?ÒpY¹âH[DÚâH[F\Z>§C¹ÃéÔ¸*pÅ££o$cr€îÏH¬’¤³#\n°®n“âˆÈÒÆÕj&ûqMCG-ş%(Úqòˆ?ÙléÔGiF²·ÏdÏ	«gÔIG,Au_ªgÊX:ÜûÏ}ÊZŠíXxs\\ÜgÁqF­Aá·RcÈ~­¾÷ÈÇ—ë\0\0ÿÿ\0PK\0\0\0\0\0!\0Ïd±”“\0\0b;\0\0\0\0\0word/styles.xml´›]s›:†ïÏÌù÷©¿Ò¸ÍÔí¤I{š™~¤u2çZ9Öà&é¯?«VØ\rô*1 }VÚÕ»8Ñ¾ywGŞ/™fJ\'òbì{2	t¨’Û…sıñè•ïe¹HBéD.ü™ùïŞşı×›»Ó,ˆdæ$;ƒ…¿Éóíéh”‹ì…ŞÊn®u\Z‹>¦·£X¤?wÛ£@Ç[‘«•ŠTş0šÇ\'~a&¥XÑëµ\nä…v±Lr?Jeu’mÔ6Û[»£X»Ói¸Mu ³&GÖ^,TâÌLk†b¤:ÓëüLfd=\ZS0|2ÆßâÈ÷âàôò6Ñ©XE°xw“cÿ-¬\\¨ƒ¹»(ÏÌÇô*->ŸğÇGä™ww*²@©kXR0+°õé,É”w¤Èò³L‰ƒ77æ©ƒw‚,/Y{¯Bå1û\r6‰háO§û+çÆƒ\'×\"‘Üî¯ÉäèfYödá»K+°»ğEz´<3ÆF8ÍıÏÒt·O&ŸĞ•­ Àë\\BR@N¤LNç/öÃYW±ËuA\0+›…•‡\\ÌYÚ†»rıY?e¸ÌáÆÂG\\¼¹¼J•N!Işë×†	—2VŸTJ³_Šk7ÉF…òßLn2>^ÿş“¿°è]’ƒû\'sÌ‚(?ÜrkÒL\'ÂDø«\0‰á(qĞ¡zôÆ^¨Pñâ{äÄÆğ e#…Ùáúß\nÂYïzƒ¦fFå	 ]–¯³ş&û›xÙß&o¿µ˜÷÷t½oDln”²’Ô\\6ùÊë0{İ’²fD-‹:GÔ’¦sD-G:GÔR¢sD-:GÔŞ9¢ßÎµp¶\nW5‹f¸\Z¤}­òHšñ­4é)uE©ñ®D*nS±İx¦°VİnËån•Ó\\E9}¾X.óT\'·+ÕÙlİgkò‡x»™‚·¤¥Ÿö\\úkóÖãı“ª°õÒ&_mNøbr°„]E\"…2õ®å½(cüWí-í[F§s=ÃúYİnro¹Á’Û	;iXôæ•°ö?«× u34L¥Ë8)†\'\ryÙlü‹Õ.Ş/\rámäÄê9#ÌºØ¾DÇ&DõİÕ9\0Êl¹àOíü·Å…oßÄ˜â¿-EÏ´Oğß®gÚÇüh/[i.àK«GÚ^söŞ=×‘N×»h¿:åaÎŞÁA›{;û$‘˜³wğùôÎ‚\0¾¹Qò”‹GePØá°Ülô¹°ƒR‘½	cFì\0UXS«ŸÖ2@lÑı!)ó71n1@•vïšÛyÖ°P‚HïĞßw:ï~‡6h•r™ÀŸK2éÑh³†G¥ùdë#Æı\nÔ¯2@ıJ!ÔÍï<®&Ò!ı‹#ƒÅ–eWÅ0íÈÊ<g+³ñJÀ@u“ğşÕ°{›s¡^7	v€êu“@aG§RË\\İ$°«›VCÕhQYS9“b×Í2È½	f4Œx@Ãˆ74Œx@ıÅ»2œxXlmpšZoá|Õw ²x@lm°jWüÍh_÷ĞJû—ÛÄ›@a¨.Ş\n;:MâM`á#œL¨°œÔXÃˆ74Œx@Ãˆ74Œx@Ãˆ7Ô_¼»!Ã‰7ÅÖ§©eñ&€Øòà@eñ&€ğ6oÜõ\\¼	v€êâM °£ST÷’J`±Ta9ñ&°ğN2,LnÎ¤†oÂŒ†ohñ&€†o¨¿xwC†o‹­\rNSËâM\0±åÁÊâM\0±µá xãfüãâM °To…Š :#°Øª°œxX˜/½Å›\0ÂGâÌhñ&Ìhñ&€†o¨¿xwC†o‹­\rNSËâM\0±åÁÊâM\0±µá xãùãâM °To…Š :ñ&°Øª°œÔXÃˆ7„‰Ù[¼	 |ä ÜEœ0\r#Ş„\r#ŞPñî†\'Ş[œ¦–Å›\0bËƒ•Å›\0bkƒ9gçEÉÇS\'\rI@=g°?Õ@N‚Dü!×2…&+Ù}:¤\'p?C±!=¨S|¯õOv°{Ö d”ZEJã‘î<¥SjD˜Í[:	®¿{ŸlLm¦ÔÓ“7Ğ=TnÂö$Ó8~æ[hÙÙîO–kĞ dúºŠ l‘»„† ¢­Ç6}>ğ 6U—ñÿ¶~\"¬£‚\r°èˆjAŞİ$<î^7œŠGG[2ön§ãß¡ìsOÎh¶ú›“à->ãIñÖ5òğÕºƒĞœ….uy![E¶Å~¹LB˜!4	âÍl0Ã{aMÁısE_6¤åzÛüh$×¹½;c¬˜Zé<×qóøˆ£\'‡@:”±Í$šó$ÙÅ+™B‡WËšÕ¦r`\'ÚÓ”´g]RºÒÍ¾=Ù.nƒ_\\ÊÖœÂ\Z÷x}[	hµûf:çj[© pÎ=n2èGÌàÀs1z<~9;>uaŸ*ºæ‡‰îÂŸC3Z {Ú\rv\"*Úà*LvßwXlÜıô³·ÿ\0\0ÿÿ\0PK\0\0\0\0\0!\0`?Ñ\0\0S>\0\0\Z\0\0\0word/stylesWithEffects.xml´›[s›:ÇßÏÌùï©/Iã6S·“&½d¦—´Næ<Ë Çš\0âp‰“óéÏJƒ1»†>%´¿]íê¿Ä‘Ş}xç‰\'©ÑÜ¼\Z»<é‹èaîŞß}>yã:iÆ\"Ÿ2âs÷…§î‡÷ÿõns‘f/O0¥›Ø›»ë,‹/F£Ô[ó¥¯Bá%2•«ì•\'Ã‘\\­„ÇG™ø£éx2Ö¿Å‰ôxšíŠEO,usaÓšŒy¬•LB–¥¯dò0\nYò˜Ç\'`=f™XŠ@d/`{|^š‘s7O¢‹Â¡ë\Zra*~”#’F{¸fäµôòG™&€2J×\"Ş†q¬5q]ºôt(ˆ§0(ŸÛÄ“³Ï†ŒÉÁuÂ6Š­Á†¹=“á›Aa`æAåw›ÕºÅÉøP0EF”	ëÆ…]féIÈDdÍ75ÕÉ…õĞ§¾¿$2­;±ègí&z´¶Ô²$x6>×+¯\ZZJ2ĞXº‹5‹¹ë„ŞÅÍC$¶À£ÍäÌQé¾©ğ¥wÍW,²T}Ln“âcñIÿø,£,u6,õ„¸	+¡\0ƒ_/£T¸p‡³4»LÛ{s­Ú{ÇK³ŠµÂîHÓÿÀææîtZ^¹Rì\\XôP^ãÑÉı¢êÉÜµ—–`wî²ädq©Œt˜åÏJ¸ñNğğI»3VpØ*ã B bŠ•İéÍ|ø«Éey&ˆ6\0°ªYøX›qĞ&Pª…Ql¸ËWß¤÷ÈıE7æ®fÁÅû›ÛDÈdtî¾}«˜pqÁCñUø>W\r¢¸v­…ÏÿYóè>åşöú¯ÏZ‹Ì£Ü?Ÿé*RÿÓ³Çc%“`:b*Ã?Ô\0Ğ0HG…£ÊÅÖs¡FÕÿ-‘“Ã½”5gª¥9Úÿƒ uŞ4UUĞvI¾ö7qÖßÄëş&tñö›‹Y/àE¦oFLmTªŸÔLz¦øªópúö@Éª*êÑ(šÎ\ZéÑ(‰Î\nèÑHxçˆF~;G4Òyp„Ç´pÕ«èTÏjaß‰,€>Ù¡t“RW´\Zç–%ì!añÚQµîö!±\\äËçª–ÓãÅr‘%R½nvÌtgµtÖäOa¼f©€·ò.PÏ©¿S¯>Î—DÀëkêµ)¾FLúÅdo»\r˜Ç×2ğyâÜñg“QÂøÒY˜·ŒNçz¦õ›xXg¼ª–Û	;o™ôö™0ö¿‰TÏÁÁn~ŞJ—qTÏ[ê²İøwî‹<,§ñ6rnôœæ\ZB»xxŠÎTŠš««3\n•\0L¦]ĞCĞöş›æB·¯rŒñß´¢#í#ü7ëHûº>ç—¬4×ğµŠƒZ^3òÚ½’LVyP®Ny˜‘W°EàB /bk%3ò\nŞ‘OçÒóà/7L’s±ÕQ…œCÑ‹\r9)5Ù›\"\"\'¨ÆšXı´–\0\"‹îoş$Ô—ÀÔf UÚ¾kv.çÓ–€„z‡ş•Ë¬ûzÚ¢yXÊM_—¤ÜÁÑN[V–VÔ“éw„÷k|P¿H\0õk…PK}´¿óØˆ‡ôoY–mÓe‡VæY™-ˆÖê›ˆ÷¯–ÕÛ^Í¾‰ Ôì›\n9;µ^fû&‚5XßD°ZºF{ªšJ	ŠÜ7« û&€ˆhñF€†ohñF€ú‹w7d8ñF°ÈÚ`5µ*Ş~„ò§¾UÅ\"kƒQ»â;£²ïi+‡ÿ¸@¼r‚šâ ³Ó&Ş–~„R	5–•:kñF€†ohñF€†ohñF€ú‹w7d8ñF°ÈÚ`5µ*ŞY,¨*Ş~„¢\r{Å[¯ú?.Ş\n9AMñFPÈÙ©	ª}IE°È	ª±¬x#XúJ1,]Ü” †oDDÃˆ74Œx#@Ãˆ7Ô_¼»!Ã‰7‚EÖ«©UñF€Èò`AUñF€ÈÚ°W¼õbüãâ Ôo…œš ZC°È	ª±¬x#Xº^z‹7¤9D‰hñFD4Œx#@Ãˆ7Ô_¼»!Ã‰7‚EÖ«©UñF€Èò`AUñF€ÈÚ°W¼õ\Zùãâ Ôo…œš ZñF°È	ª±¬Ô!XÃˆ7¤³·x#@ú‘#@zQÒ4Œx#\"\ZF¼ şâİ\rN¼,²6XM­Š7D–ªŠ7DÖµÏö‹¢·§NZŠ\0»Ï ÜÕ€N[’„şæ+À©BŞ½;¤\'°Œ@l)lˆ¥|tp»O[\nË@H½¥ûEïÒ©D88Ip÷óÊùjÀ4Æé’Úİy§‡ªÇ…ôñ$upüÌ^b8²—;Ë•58 ¤ÎuG€ô™Ğ8TëQƒÕ9xPª*.ëÿÛTøˆz`å­åÁ‰¨¨bÃ»İƒ¤·»×Á-»âµ#Û#¥›Åîøí;”yngæA¿3µü€Ïz§øÁ9rô#&«Máp–v©ËCHÙ20GÌà—›È‡7Åé,“Lÿ™SpÿŠÁw¦¤e2n4à«ÌÜŒu¬™ZÊ,“aûøDo×ì3\0åPuÆ|TA´×I”‡KÛÍ[KRu}m·$Í^×–RÀÎt»o;ËÅ.å‹-Ù†SºÇmokß–ÚıT\'ç\ZK©Y °ÏNÚ.28˜Â†çbôxüúôìêÍµyª8…(t}¨ìÎİÙtlîypzä,(€]¶<wX,Ü2üôıÿ\0\0\0ÿÿ\0PK\0\0\0\0\0!\0qMà\0\0Ü\0\0\0docProps/app.xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0œSMoÛ0½Ø0|o”v(FÅbèa[ÄmÏšL\'ÂdIØ Ù¯e7³í4?D>=Rp÷ÖÚâ€1ïVål2-tÚ×ÆíVåSõåê¶,)W+ë®Ê#¦òN~ü\0›èF2˜\n.áÒªÜ…¥Iï±UiÂaÇ‘ÆÇV›q\'|Ó÷^¿¶èHÌ§ÓOß]õU\n–}Ååş·híuæ—«c`Â*lƒU„ò{¦c\'µ§Äà…Ê“²•iQŞÌÙ?X°Q;Lr¢ğâcäÍ-ˆÁz¯¢ÒÄ\nÊÅ‚óF6|Á\Z­ˆµ•ßŒ>ù†ŠÇN…\"ß1NVf‹ú5\Z:Ê)ˆ±	_c\"L®L,ª]TaÿÎn°`«•Å5?_6Ê&qvÀª<Ú2Ì´< &‹d~ñpçeñC%Ì¢­ÊƒŠF9bñrZotØ†DQV†,×æXowpœ6Ææ:KÈ¹.³³çÀKv]‡ôØğKédgc²‡êˆÎ=ş¨ºömPîÈÍÄÿLO¡ò÷yaŞ5¼t¦şbh¿\rJóp·¼çù\"°å-ÁšzªwvÀËmnÊwİëSÎß¼QÏıg•³ëÉ”O·B\'¯éğ‹äo\0\0\0ÿÿ\0PK\0\0\0\0\0!\0œ2Àİz\0\0ã\0\0\0docProps/core.xml ¢( \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŒRQOÂ0~7ñ?,}ßº\r0ºl#¨!1c£ñ­¶TÖ®iƒo·Á`Ñßz÷}÷İİwMÇ;Qx[Ğ†—2CQ\"$-—Ë½Í§ş5òŒ%’‘¢”¡=4Î//RªZjxÖ¥m9Ï)I“P•¡•µ*ÁØĞbÇ\\”ZëB½ÄŠĞ5YÃğ\n°„Kp-è«N$í$ÕF\0£\n ­ÁQá×‚æÏ‚9c\nn÷Êít÷\\›ÑìØ;Ã;bUUA5hÆpóGøcöøÚ¬êsY{Eå)£‰å¶€<Å§§{™Í×7PÛ¦»ÀT±¥Îg“—‡§ISuLÕf¯a_•šWØ‹\\%C5WÖ°•í%» ÆÎÜMØí¾ëğ©iØòú7äqÓ©İFí À<gIÒ\ZxDŞw÷ó)Êã0ºñÃk?\ZÍ£A2Š“0ü¬êÕ×µ	qíŸŠÃd8ì+Zoúß2ÿ\0\0ÿÿ\0PK\0\0\0\0\0!\0\'5ˆi6\0\0Â\0\0\0\0\0word/fontTable.xml¼•KsÚ0…÷éğh,›×2-\r3İtÑ¦Óµ2hª‡G8üû^É6$ÁiqØÁ‘u,}Ü{¸x–\":0c¹Vs”0Š˜¢zÃÕv~>­î&(²¨\rZ±9:2‹?ÜW³B+g#X¯ìLÒ9Ú9WÎâØÒ“ÄtÉLÚHâà«ÙÆ’˜ßûòjYÇ×\\pwŒSŒG¨±1×¸è¢à”}Ñt/™ra}l˜\0G­ì—¶u«®q«´Ù”FSf-œYŠÚO®N6Iva$95ÚêÂ\rà0q½£Ø[Áò‡OR HÒÙ×­Ò†¬°«’-\ZpQ5SD‚øã(×Z½$J[–ÀÔˆ9Â9Ü	ö†c<‚1Çc{º#Æ2wz0­å‚H.­j´$ª(¹£»V?Ãı~ê)Ë·0±·k/l.T+	ÔÃk%½xføZ¡Ágòb(àsr†íÇuå\\€XÁ×†w’Hñ\nNŸ†;ÃC³n¸‹„­¸µ½H<Â†ÓO«Õ™ÄÒ+Ùøs£œIL¥“D8wRû\\Oâ‰Kf£o¬Š¾‡ßĞ£z[ÅHä8d†½ˆô¯@äñ-‘ñ$¿	‘¥ŞÎŒgòN}ŒÅ4Ô‡¯“¬\r©7ÌtµJÁŸÙæ²OŞc‘\roQ¿ ¦|<ÛNyÛjç±»S:3ƒìîÕ(í[ÎrÛÈ¤„/‚¼iß(ı\"ãÿ\Z^6HÿlivR|d€â¯GÆ4DÏ_\"£IQ»ø\0\0ÿÿ\0PK\0\0\0\0\0!\0 N\0\0¬\0\0\0\0\0word/webSettings.xmlŒĞÁJ1à»à;,¹·Ù•\"²t· Rñ\"‚ú\0ivvÌdÂLj¬OoÚª ^zË$™™¹ú@_½‹£Ğ©f^«\n‚¥Á…©S¯/ëÙª$™0O:µQ«şòb™Û›gH©ü”ª(AZ´Ú¦[­ÅnÌ)B(#1šTJ4\Z~ÛÅ™%Œ&¹ó.íõU]_«o†ÏQh…;²;„ıšÁ‘‚l]”-Ÿ£eâ!2Y)û ?yh\\øešÅ?e\ZÓ¼,£OéUÚ›úxB¯*´íÃˆÍÆ—s³P}‰brè>aM|Ë”X®÷”ŸïK¡ÿdÜ\0\0ÿÿ\0PK\0\0\0\0\0!\0èÛÀ»Y\0\0£\0\0\0\0\0word/numbering.xmlÌWÍnÚ@¾Wê; ßƒm0„ ˆ†Ğ¦j£J¡êy±¼ÊşX»k®y™>B+¯ĞYÿapÅ&.±3;¿ßÎ7.¯Ÿíl°TDğ‰åv«ƒ¹/Â×ë÷b~6²:J# *8X[¬¬ë«ÏŸ.“1ÙKPì€®ÆIäO¬PëhlÛÊ1CªËˆ/…+İõ³ÅjE|l\'BvÏqô-’ÂÇJŸÄ7HY¹;V÷&\"Ì!ÖJH†´ê\n¹¶’qtŞ#¤É’P¢·àÛnÄÄŠ%ç	•	“q–Pş(,d­ŠWâf–3áÇsF´%¦ƒà*$Ñ®Œ¶Ş Ä°HióVF½$r½Z¼²ä÷ÜÁL¢®bç°æî0‚ÌˆÑs¿»[=ôè:o“ßˆqQæğöc™0Dxé¦4UpÇô÷W)â¨L\'\"Çy»ã¥/ÃÌ™9Ã”yÕÒT#5ê>„(ÂV‡ùã»5-)d”¸^Çt¤uÓ-•–È×÷1ëìıwL,\'UáŠp¶Atbßº;˜»–mŒYL5ù7˜.¶.tÂíR’à§9£æ,ÓÕ,¢…Æl4ºõ¦½ì„nÌ‡‰¯:¢0dnû®7ŸÏ¦Y1›3]Ø/cJ±.­ø©<zyşWÊ¿û…Å«\\=ú%Mæ„›’Œjê¥QCÄ×éxíãÂNÆ¹²Ìlä\\p­À)Ÿ@—<lÙR\0Ç“1FJOA˜®\00#€õ·)àfCóRÕö•®è}!A¦F8äààòøi`È 1IWrw@9sá8N?•ÀÔƒa·,Ü8øHÈœüÚàñ>0ES(]Ïk‡åˆ%Á²s“\nfRØp \n›¡Ö«¡6øxÔ^ÿ6Å­çBÏ™^iÚƒ cÍR\0ßµ²ÓöeÍ\0Êš(å_ŞVY£}h[µàho4jĞ¤56ì¯Ö;§À8Ví€9$R6¥¤Ç3.ãWµ¡Nƒq^¿åÔßgW†Ú¾¬ã`#.¾x\'Å¸dÓj$}ãÎkĞœãç-gõ·òyt =qğËğ ¡NƒqC¯åßgWÆÁ\nUÙsÍ*+ Íš›mJ;³¦ûn±	‚fºÂ3ûq}õ\0\0ÿÿ\0PK-\0\0\0\0\0\0!\0ğ!ì}\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0[Content_Types].xmlPK-\0\0\0\0\0\0!\0‘\Z·ó\0\0\0N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ç\0\0_rels/.relsPK-\0\0\0\0\0\0!\0ĞDÓ‡,\0\0>\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ë\0\0word/_rels/document.xml.relsPK-\0\0\0\0\0\0!\0û]©’\0\0I\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Y	\0\0word/document.xmlPK-\0\0\0\0\0\0!\00İC)¨\0\0¤\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›\r\0\0word/theme/theme1.xmlPK-\0\0\0\0\0\0!\0­Â\n‘\0\0ş\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0v\0\0word/settings.xmlPK-\0\0\0\0\0\0!\0Ïd±”“\0\0b;\0\0\0\0\0\0\0\0\0\0\0\0\0\0\06\0\0word/styles.xmlPK-\0\0\0\0\0\0!\0`?Ñ\0\0S>\0\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0ö\0\0word/stylesWithEffects.xmlPK-\0\0\0\0\0\0!\0qMà\0\0Ü\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0A(\0\0docProps/app.xmlPK-\0\0\0\0\0\0!\0œ2Àİz\0\0ã\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0W+\0\0docProps/core.xmlPK-\0\0\0\0\0\0!\0\'5ˆi6\0\0Â\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0.\0\0word/fontTable.xmlPK-\0\0\0\0\0\0!\0 N\0\0¬\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0n0\0\0word/webSettings.xmlPK-\0\0\0\0\0\0!\0èÛÀ»Y\0\0£\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¢1\0\0word/numbering.xmlPK\0\0\0\0\r\0\r\0I\0\0+5\0\0\0\0','Masters work plan.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','Tamplaet');

/*Table structure for table `template_field` */

DROP TABLE IF EXISTS `template_field`;

CREATE TABLE `template_field` (
  `template_field_id` int(11) NOT NULL,
  `template_id_fk` bigint(20) NOT NULL,
  `template_field_name` varchar(255) DEFAULT NULL,
  `template_field_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`template_field_id`,`template_id_fk`),
  KEY `FK83qenu6ey4hnws1k82ke1y39l` (`template_id_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `template_field` */

insert  into `template_field`(`template_field_id`,`template_id_fk`,`template_field_name`,`template_field_type`) values 
(1,1,'ytfytyfyt','STRING'),
(2,1,'hkgugjli','STRING'),
(1,2,'ytfytyfyt','STRING');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
