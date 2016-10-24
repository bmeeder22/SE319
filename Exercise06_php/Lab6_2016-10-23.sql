# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.28)
# Database: Lab6
# Generation Time: 2016-10-24 00:10:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table books
# ------------------------------------------------------------

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `shelf` int(11) NOT NULL,
  `name` varchar(11) NOT NULL DEFAULT '',
  `borrowedBy` int(11) DEFAULT NULL,
  `author` int(11) DEFAULT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;

INSERT INTO `books` (`id`, `shelf`, `name`, `borrowedBy`, `author`, `availability`)
VALUES
	(1,1,'R1',NULL,NULL,0),
	(2,1,'B1',NULL,NULL,0),
	(3,1,'R2',NULL,NULL,0),
	(4,1,'B2',NULL,NULL,0),
	(5,1,'B3',NULL,NULL,0),
	(6,1,'R5',NULL,NULL,0),
	(7,1,'B20',NULL,NULL,0),
	(8,2,'B6',NULL,NULL,0),
	(9,2,'B7',NULL,NULL,0),
	(10,2,'B8',NULL,NULL,0),
	(11,2,'B9',NULL,NULL,0),
	(12,2,'B10',NULL,NULL,0),
	(13,2,'B19',NULL,NULL,0),
	(14,3,'R3',NULL,NULL,0),
	(15,3,'B11',NULL,NULL,0),
	(16,3,'B12',NULL,NULL,0),
	(17,3,'B4',NULL,NULL,0),
	(18,3,'B5',NULL,NULL,0),
	(19,3,'R4',NULL,NULL,0),
	(20,4,'B13',NULL,NULL,0),
	(21,4,'B14',NULL,NULL,0),
	(22,4,'B15',NULL,NULL,0),
	(23,4,'B16',NULL,NULL,0),
	(24,4,'B17',NULL,NULL,0),
	(25,4,'B18',NULL,NULL,0);

/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table loanHistory
# ------------------------------------------------------------

DROP TABLE IF EXISTS `loanHistory`;

CREATE TABLE `loanHistory` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table shelves
# ------------------------------------------------------------

DROP TABLE IF EXISTS `shelves`;

CREATE TABLE `shelves` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(40) NOT NULL DEFAULT '',
  `email` varchar(20) NOT NULL DEFAULT '',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `librarian` tinyint(1) NOT NULL,
  `first_name` varchar(20) NOT NULL DEFAULT '',
  `last_name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `username`, `password`, `email`, `phone`, `librarian`, `first_name`, `last_name`)
VALUES
	(7,'ben','098f6bcd462','bkmeeder@iastate.edu','1234567890',1,'ben','meeder'),
	(8,'test','098f6bcd4621d373cade4e832627b4f6','bkmeeder@iastate.edu','1234567890',0,'ben','meeder'),
	(9,'noah','098f6bcd4621d373cade4e832627b4f6','tes@a.com','1234567890',0,'noah','e');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
