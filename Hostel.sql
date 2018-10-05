/*
SQLyog Ultimate v8.55 
MySQL - 5.1.41 : Database - hostel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hostel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hostel`;

/*Table structure for table `expected` */

DROP TABLE IF EXISTS `expected`;

CREATE TABLE `expected` (
  `RENT` varchar(12) DEFAULT '0.0',
  `WATER` varchar(12) DEFAULT '0.0',
  `ELECTRICITY` varchar(12) DEFAULT '0.0',
  `OTHERS` varchar(12) DEFAULT '0.0',
  `IDNO` varchar(12) DEFAULT NULL,
  `NUM` int(6) NOT NULL AUTO_INCREMENT,
  `HOSTEL` varchar(50) DEFAULT NULL,
  `ROOMNO` varchar(20) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `MONTH` varchar(12) DEFAULT NULL,
  `YEAR` varchar(6) DEFAULT NULL,
  `FROM` date DEFAULT NULL,
  `TO` date DEFAULT NULL,
  PRIMARY KEY (`NUM`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `expected` */

/*Table structure for table `hostel` */

DROP TABLE IF EXISTS `hostel`;

CREATE TABLE `hostel` (
  `HOSTEL` varchar(70) DEFAULT NULL,
  `IDNO` varchar(11) DEFAULT NULL,
  `ROOMNO` varchar(7) DEFAULT NULL,
  `RATE` varchar(20) DEFAULT NULL,
  `DATEE` date DEFAULT NULL,
  `DATEEX` date DEFAULT NULL,
  `ASSET` varchar(20) DEFAULT NULL,
  `NUM` int(5) NOT NULL AUTO_INCREMENT,
  `STATUS` varchar(10) NOT NULL DEFAULT 'IN',
  PRIMARY KEY (`NUM`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `hostel` */

insert  into `hostel`(`HOSTEL`,`IDNO`,`ROOMNO`,`RATE`,`DATEE`,`DATEEX`,`ASSET`,`NUM`,`STATUS`) values ('mowbray','27380969','1','3500','2014-01-01','2015-01-31','bed',1,'IN'),('mowbray','21212121','2','3500','2014-01-01','2014-01-31','this',2,'IN');

/*Table structure for table `hostelin` */

DROP TABLE IF EXISTS `hostelin`;

CREATE TABLE `hostelin` (
  `NAME` varchar(70) NOT NULL,
  `LOC` varchar(70) DEFAULT NULL,
  `OWNER` varchar(40) DEFAULT NULL,
  `IDNO` varchar(10) DEFAULT NULL,
  `PHONENO` varchar(14) DEFAULT NULL,
  `ROOMNO` varchar(4) DEFAULT NULL,
  `CARET` varchar(40) DEFAULT NULL,
  `CPHONENO` varchar(14) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT 'AVAILABLE',
  `CARETID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hostelin` */

insert  into `hostelin`(`NAME`,`LOC`,`OWNER`,`IDNO`,`PHONENO`,`ROOMNO`,`CARET`,`CPHONENO`,`STATUS`,`CARETID`) values ('Veecam','Next to Khetis','Alex','21212121','0724010547','36','Ken','0724010547','AVAILABLE','21212213'),('mowbray','stage ','Mr.rono','21212121','0721456455','100','KENNEDY','0725665422','AVAILABLE','21212212');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `PASSWORD` varchar(15) NOT NULL,
  `USERNAME` varchar(15) NOT NULL,
  `KEYY` int(2) NOT NULL AUTO_INCREMENT,
  `CATEG` varchar(15) DEFAULT NULL,
  `STATUS` varchar(4) DEFAULT 'OFF',
  PRIMARY KEY (`KEYY`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`PASSWORD`,`USERNAME`,`KEYY`,`CATEG`,`STATUS`) values ('nastyboy','james',1,'Administrator','ON'),('nastyboy','jamesm',11,'User','ON');

/*Table structure for table `payed` */

DROP TABLE IF EXISTS `payed`;

CREATE TABLE `payed` (
  `AMOUNT` varchar(12) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `MONTH` varchar(12) DEFAULT NULL,
  `YEAR` varchar(6) DEFAULT NULL,
  `DATEFROM` date DEFAULT NULL,
  `TO` date DEFAULT NULL,
  `EXPECTEDBY` date DEFAULT NULL,
  `IDNO` varchar(12) DEFAULT NULL,
  `HOSTEL` varchar(50) DEFAULT NULL,
  `ROOMNO` varchar(20) DEFAULT NULL,
  `NUM` int(6) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`NUM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `payed` */

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `AMOUNT` varchar(12) DEFAULT '0.0',
  `IDNO` varchar(11) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `MONTH` varchar(20) DEFAULT NULL,
  `YEAR` varchar(8) DEFAULT NULL,
  `PFROM` date DEFAULT NULL,
  `PTO` date DEFAULT NULL,
  `NUM` int(5) NOT NULL AUTO_INCREMENT,
  `HOSTEL` varchar(50) DEFAULT '-',
  `ROOMNO` varchar(15) DEFAULT '-',
  `EXPECTED` date DEFAULT NULL,
  PRIMARY KEY (`NUM`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `payment` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `HOSTEL` varchar(70) NOT NULL,
  `ROOMNO` varchar(20) NOT NULL,
  `CATEGORY` varchar(20) DEFAULT NULL,
  `INCLUDED` varchar(100) DEFAULT NULL,
  `RENT` varchar(15) DEFAULT '0.0',
  `WATER` varchar(10) DEFAULT '0.0',
  `ELECTRICITY` varchar(10) DEFAULT '0.0',
  `DURATION` varchar(15) DEFAULT NULL,
  `CONDITION` varchar(40) DEFAULT NULL,
  `STATUS` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`HOSTEL`,`ROOMNO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `room` */

insert  into `room`(`HOSTEL`,`ROOMNO`,`CATEGORY`,`INCLUDED`,`RENT`,`WATER`,`ELECTRICITY`,`DURATION`,`CONDITION`,`STATUS`) values ('mowbray','1','Single','BATHROOM','3500','0.0','0.0','Monthly','Average','TAKEN'),('mowbray','2','Single','bathroom','3500','0.0','0.0','Monthly','Average','TAKEN');

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `FNAME` varchar(50) DEFAULT NULL,
  `IDNO` varchar(10) NOT NULL,
  `GENDER` varchar(7) DEFAULT NULL,
  `JOB` varchar(20) DEFAULT NULL,
  `LNAME` varchar(20) DEFAULT NULL,
  `INST` varchar(30) DEFAULT NULL,
  `PHONENO` varchar(14) DEFAULT NULL,
  `FRIENDP` varchar(14) DEFAULT NULL,
  `PHOTO` mediumblob,
  `STATUS` varchar(10) DEFAULT 'AVAILABLE',
  `ISSUED` varchar(3) DEFAULT 'no',
  PRIMARY KEY (`IDNO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `staff` */

insert  into `staff`(`FNAME`,`IDNO`,`GENDER`,`JOB`,`LNAME`,`INST`,`PHONENO`,`FRIENDP`,`PHOTO`,`STATUS`,`ISSUED`) values ('jk  jkgjk','27380969','Male','hjk','jkgjk','jkhjk','0724010547','0724010547',NULL,'AVAILABLE','no'),('james  mbithi','21212121','Male','student','mbithi','moi','0721212121','0721212121',NULL,'AVAILABLE','yes'),('james1  mbithi2','23232323','Male','conductor','mbithi2','moi','0715454545','0715454545',NULL,'AVAILABLE','no'),('jkgdfs  jkgjkdfgdf','27380967','Male','hjk','jkgjkdfgdf','jkhjk','0724010547','0724010547',NULL,'AVAILABLE','no'),('jkgdfshf  jkgjkdfgdfhfh','27380963','Male','hjk','jkgjkdfgdfhfh','jkhjk','0724010547','0724010547',NULL,'AVAILABLE','no'),('jkkjkhjkl  jkgjkljlkjh','27380966','Male','hjk','jkgjkljlkjh','jkhjk','0724010547','0724010547',NULL,'AVAILABLE','no'),('mm  mm','14141414','Male','worker','mm','moi','0715484978','0713252689',NULL,'AVAILABLE','no'),('gg  gg','25252525','Male','gg','gg','gg','0714141414','0715151515',NULL,'AVAILABLE','no');

/*Table structure for table `clientv` */

DROP TABLE IF EXISTS `clientv`;

/*!50001 DROP VIEW IF EXISTS `clientv` */;
/*!50001 DROP TABLE IF EXISTS `clientv` */;

/*!50001 CREATE TABLE  `clientv`(
 `FNAME` varchar(50) ,
 `IDNO` varchar(10) ,
 `GENDER` varchar(7) ,
 `JOB` varchar(20) ,
 `LNAME` varchar(20) ,
 `INST` varchar(30) ,
 `PHONENO` varchar(14) ,
 `FRIENDP` varchar(14) ,
 `PHOTO` mediumblob ,
 `STATUS` varchar(10) ,
 `ISSUED` varchar(3) ,
 `HOSTEL` varchar(70) ,
 `ROOMNO` varchar(7) ,
 `RATE` varchar(20) ,
 `DATEE` date ,
 `DATEEX` date ,
 `ASSET` varchar(20) 
)*/;

/*Table structure for table `paymentv` */

DROP TABLE IF EXISTS `paymentv`;

/*!50001 DROP VIEW IF EXISTS `paymentv` */;
/*!50001 DROP TABLE IF EXISTS `paymentv` */;

/*!50001 CREATE TABLE  `paymentv`(
 `AMOUNT` varchar(12) ,
 `IDNO` varchar(11) ,
 `DATE` date ,
 `MONTH` varchar(20) ,
 `YEAR` varchar(8) ,
 `PFROM` date ,
 `PTO` date ,
 `HOSTEL` varchar(50) ,
 `EXPECTED` date ,
 `ROOMNO` varchar(15) ,
 `FNAME` varchar(50) ,
 `STATUS` varchar(10) 
)*/;

/*View structure for view clientv */

/*!50001 DROP TABLE IF EXISTS `clientv` */;
/*!50001 DROP VIEW IF EXISTS `clientv` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `clientv` AS select `staff`.`FNAME` AS `FNAME`,`staff`.`IDNO` AS `IDNO`,`staff`.`GENDER` AS `GENDER`,`staff`.`JOB` AS `JOB`,`staff`.`LNAME` AS `LNAME`,`staff`.`INST` AS `INST`,`staff`.`PHONENO` AS `PHONENO`,`staff`.`FRIENDP` AS `FRIENDP`,`staff`.`PHOTO` AS `PHOTO`,`staff`.`STATUS` AS `STATUS`,`staff`.`ISSUED` AS `ISSUED`,`hostel`.`HOSTEL` AS `HOSTEL`,`hostel`.`ROOMNO` AS `ROOMNO`,`hostel`.`RATE` AS `RATE`,`hostel`.`DATEE` AS `DATEE`,`hostel`.`DATEEX` AS `DATEEX`,`hostel`.`ASSET` AS `ASSET` from (`staff` join `hostel` on((`staff`.`IDNO` = `hostel`.`IDNO`))) */;

/*View structure for view paymentv */

/*!50001 DROP TABLE IF EXISTS `paymentv` */;
/*!50001 DROP VIEW IF EXISTS `paymentv` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `paymentv` AS select `payment`.`AMOUNT` AS `AMOUNT`,`payment`.`IDNO` AS `IDNO`,`payment`.`DATE` AS `DATE`,`payment`.`MONTH` AS `MONTH`,`payment`.`YEAR` AS `YEAR`,`payment`.`PFROM` AS `PFROM`,`payment`.`PTO` AS `PTO`,`payment`.`HOSTEL` AS `HOSTEL`,`payment`.`EXPECTED` AS `EXPECTED`,`payment`.`ROOMNO` AS `ROOMNO`,`staff`.`FNAME` AS `FNAME`,`staff`.`STATUS` AS `STATUS` from (`payment` join `staff` on((`payment`.`IDNO` = `staff`.`IDNO`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
