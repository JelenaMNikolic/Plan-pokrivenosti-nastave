/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.36-MariaDB : Database - plan_pokrivenosti_nastave
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`plan_pokrivenosti_nastave` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `plan_pokrivenosti_nastave`;

/*Table structure for table `katedra` */

DROP TABLE IF EXISTS `katedra`;

CREATE TABLE `katedra` (
  `sifra_katedre` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `naziv_katedre` varchar(100) DEFAULT NULL,
  `delatnost_katedre` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`sifra_katedre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `katedra` */

insert  into `katedra`(`sifra_katedre`,`naziv_katedre`,`delatnost_katedre`) values 
(1,'silab','razvoj sofrvera'),
(2,'elab','web razvoj');

/*Table structure for table `nastavnik` */

DROP TABLE IF EXISTS `nastavnik`;

CREATE TABLE `nastavnik` (
  `sifra_nastavnika` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `pozicija` varchar(30) DEFAULT NULL,
  `konsultacije` varchar(10) DEFAULT NULL,
  `kabinet` varchar(10) DEFAULT NULL,
  `fk_sifra_katedre` bigint(100) unsigned NOT NULL,
  PRIMARY KEY (`sifra_nastavnika`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `nastavnik` */

insert  into `nastavnik`(`sifra_nastavnika`,`ime`,`prezime`,`email`,`password`,`pozicija`,`konsultacije`,`kabinet`,`fk_sifra_katedre`) values 
(1,'Marko','Markovic','marko@marko.com','sifra','asistent','sreda, 14:','210',1),
(2,'Ivana','Zivkovic','zizela@zizela.com','sifra','profesor','utorak, 15','110a',2);

/*Table structure for table `ppn` */

DROP TABLE IF EXISTS `ppn`;

CREATE TABLE `ppn` (
  `sifra_ppn` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `godina_ppn` date DEFAULT NULL,
  `stavke_ppn` bigint(100) unsigned NOT NULL,
  PRIMARY KEY (`sifra_ppn`),
  KEY `stavke_ppn` (`stavke_ppn`),
  CONSTRAINT `ppn_ibfk_1` FOREIGN KEY (`stavke_ppn`) REFERENCES `stavke_ppn` (`sifra_stavki_ppn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `ppn` */

insert  into `ppn`(`sifra_ppn`,`godina_ppn`,`stavke_ppn`) values 
(4,'2017-10-01',1);

/*Table structure for table `predmet` */

DROP TABLE IF EXISTS `predmet`;

CREATE TABLE `predmet` (
  `sifra_predmeta` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `naziv_predmeta` varchar(50) DEFAULT NULL,
  `opis_predmeta` varchar(500) DEFAULT NULL,
  `cilj_predmeta` varchar(200) DEFAULT NULL,
  `fk_katedra` bigint(100) unsigned NOT NULL,
  PRIMARY KEY (`sifra_predmeta`),
  KEY `fk_katedra` (`fk_katedra`),
  CONSTRAINT `predmet_ibfk_1` FOREIGN KEY (`fk_katedra`) REFERENCES `katedra` (`sifra_katedre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `predmet` */

insert  into `predmet`(`sifra_predmeta`,`naziv_predmeta`,`opis_predmeta`,`cilj_predmeta`,`fk_katedra`) values 
(1,'Projektovanje softvera','java','uci se java',1),
(2,'Internet tehnologije','AJAX','uci se js i php',2);

/*Table structure for table `stavke_ppn` */

DROP TABLE IF EXISTS `stavke_ppn`;

CREATE TABLE `stavke_ppn` (
  `sifra_stavki_ppn` bigint(100) unsigned NOT NULL,
  `sifra_predmeta` bigint(100) unsigned NOT NULL,
  `sifra_nastavnika` bigint(100) unsigned NOT NULL,
  PRIMARY KEY (`sifra_stavki_ppn`,`sifra_predmeta`,`sifra_nastavnika`),
  KEY `sifra_predmeta` (`sifra_predmeta`),
  KEY `sifra_nastavnika` (`sifra_nastavnika`),
  CONSTRAINT `stavke_ppn_ibfk_1` FOREIGN KEY (`sifra_predmeta`) REFERENCES `predmet` (`sifra_predmeta`),
  CONSTRAINT `stavke_ppn_ibfk_2` FOREIGN KEY (`sifra_nastavnika`) REFERENCES `nastavnik` (`sifra_nastavnika`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavke_ppn` */

insert  into `stavke_ppn`(`sifra_stavki_ppn`,`sifra_predmeta`,`sifra_nastavnika`) values 
(1,1,1),
(1,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
