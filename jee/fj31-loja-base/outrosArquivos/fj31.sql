/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.17 : Database - fj31
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fj31` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `fj31`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Table structure for table `livro` */

DROP TABLE IF EXISTS `livro`;

CREATE TABLE `livro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataAlteracao` datetime DEFAULT NULL,
  `dataCriacao` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Table structure for table `livro_autor` */

DROP TABLE IF EXISTS `livro_autor`;

CREATE TABLE `livro_autor` (
  `Livro_id` bigint(20) NOT NULL,
  `autores_id` bigint(20) NOT NULL,
  KEY `FK9590997A6C3A7896` (`autores_id`),
  KEY `FK9590997AA4CF6E64` (`Livro_id`),
  CONSTRAINT `FK9590997A6C3A7896` FOREIGN KEY (`autores_id`) REFERENCES `autor` (`id`),
  CONSTRAINT `FK9590997AA4CF6E64` FOREIGN KEY (`Livro_id`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `user` varchar(15) COLLATE latin1_bin NOT NULL,
  `role` varchar(15) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`user`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user` varchar(15) COLLATE latin1_bin NOT NULL,
  `password` varchar(40) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`user`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
