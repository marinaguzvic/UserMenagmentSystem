-- CREATE SCHEMA `ums`;
-- SET SCHEMA `ums`;
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (`company_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,`company_name` varchar(100) DEFAULT NULL,PRIMARY KEY (`company_id`));
INSERT INTO `company` (`company_id`,`company_name`) VALUES (1,'FON'),(2,'CloudAfrica'),(3,'Levi9');
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (`position_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,`position_name` varchar(50) DEFAULT NULL,`company_id_fk` bigint(20) UNSIGNED DEFAULT NULL,PRIMARY KEY (`position_id`));
INSERT INTO `position` (`position_id`,`position_name`,`company_id_fk`) VALUES (1,'Accountant',1),(2,'HR',2),(3,'QA specialist',3),(4,'Java Developer',1);
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,`email` varchar(50) NOT NULL,`first_name` varchar(30) DEFAULT NULL,`last_name` varchar(30) DEFAULT NULL,`mobile_number` varchar(20) DEFAULT NULL,`gender` varchar(30) DEFAULT NULL,`date_of_birth` date DEFAULT NULL,`position_id_fk` bigint(20) UNSIGNED DEFAULT NULL,PRIMARY KEY (`id`));
INSERT INTO `person` (`id`,`email`,`first_name`,`last_name`,`mobile_number`,`gender`,`date_of_birth`,`position_id_fk`) VALUES 
(1,'jovan.ilic2@gmail.com','Jovan','Ilic','+38163/155-6666','Male','1995-11-30',4),
(2,'milos.djordjevic@africa.za','Milos','Djordjevic','+2782/123-456','Male','1996-11-10',1),
(3,'anjaxbasara@gmail.com','Marinica','Guzviceva','+38164/933-9101','Female','1999-10-26',2),
(4,'marina.guzvic@gmail.com','Marina','Guzvic','+38164/933-9101','Female','1995-05-07',4),
(5,'petar.trifunovic@yahoo.com','Petar','Trifunovic','+2782/123-555','Male','1994-09-12',2);


ALTER TABLE `person` ADD CONSTRAINT `user_position` FOREIGN KEY (`position_id_fk`) REFERENCES `position` (`position_id`);
ALTER TABLE `position` ADD CONSTRAINT `company_position` FOREIGN KEY (`company_id_fk`) REFERENCES `company` (`company_id`);
