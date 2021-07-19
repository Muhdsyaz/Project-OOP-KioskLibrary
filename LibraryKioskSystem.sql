-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2021 at 11:41 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `ISBN` varchar(10) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `yearOfPublish` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ISBN`, `title`, `author`, `publisher`, `yearOfPublish`) VALUES
('CD302', 'The Children Of H-rin', 'J.R.R. Tolkien', 'Allen & Unwin', '2013'),
('CD303', 'The Hobbit', 'J.R.R. Tolkien', 'Allen & Unwin', '2015'),
('CD304', 'The Last Magician', 'Lisa Maxwell', 'Simon Pulse', '2013'),
('CD305', 'Programming Technique C++', 'Mashanum Osman', 'FTMK', '2019'),
('CD306', 'Hypertensi Dalam Generasi', 'M. Syazani Md. Shah', 'Definisi Muda', '2021');

-- --------------------------------------------------------

--
-- Table structure for table `borrow_book`
--

CREATE TABLE IF NOT EXISTS `borrow_book` (
  `ISBN` varchar(50) DEFAULT NULL,
  `ID` varchar(50) DEFAULT NULL,
  `borrow_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrow_book`
--

INSERT INTO `borrow_book` (`ISBN`, `ID`, `borrow_date`) VALUES
('CD304', 'B031910120', '24/1/2021'),
('CD303', 'B031910120', '23/1/2021'),
('CD302', 'B031910120', '23/1/2021'),
('CD305', 'B031910197', '23/1/2021');

-- --------------------------------------------------------

--
-- Table structure for table `history_book`
--

CREATE TABLE IF NOT EXISTS `history_book` (
  `ISBN` varchar(10) NOT NULL,
  `ID` varchar(20) NOT NULL,
  `BORROW_DATE` varchar(10) NOT NULL,
  `RETURN_DATE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history_book`
--

INSERT INTO `history_book` (`ISBN`, `ID`, `BORROW_DATE`, `RETURN_DATE`) VALUES
('CD306', 'B031910197', '24/1/2021', '29/1/2021'),
('CD304', 'B031910197', '24/1/2021', '27/1/2021');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `ID` varchar(20) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `phone` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `name`, `phone`, `password`) VALUES
('B031910055', 'Muhammad Syazani', '0172696437', 'abc123'),
('B031910120', 'Abdillah Safwan', '0138469671', 'abc123'),
('B031910197', 'Muhd Ridhwan', '0189861723', 'abc123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
