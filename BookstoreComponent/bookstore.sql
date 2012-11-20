-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2012 at 11:58 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `publisher` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `authors` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `count` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `isbn`, `title`, `publisher`, `authors`, `count`, `price`) VALUES
(1, '0000000000013', 'The First Book', 'Publisher', 'Buk Riter', 10, 49.99);
INSERT INTO `books` (`id`, `isbn`, `title`, `publisher`, `authors`, `count`, `price`) VALUES
(2, '0000000000014', 'Advanced Database Management', 'Addison Wesley', 'Orlando Karam', 19, 69.99);
INSERT INTO `books` (`id`, `isbn`, `title`, `publisher`, `authors`, `count`, `price`) VALUES
(3, '0000000000015', 'Intro TO SWE', 'Oxford Press', 'Barbara Thomas', 15, 59.99);
INSERT INTO `books` (`id`, `isbn`, `title`, `publisher`, `authors`, `count`, `price`) VALUES
(4, '9781401820497', 'Advanced Engine Performance', 'Thomson', 'Chri Shortt', 5, 29.99);
INSERT INTO `books` (`id`, `isbn`, `title`, `publisher`, `authors`, `count`, `price`) VALUES
(5, '9780132158718', 'A discipline of Programming', 'Prentice Hall', 'Edsger Dijkstra', 5, 199.99);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
