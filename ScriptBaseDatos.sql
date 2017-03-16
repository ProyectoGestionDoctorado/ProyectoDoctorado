-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 04, 2017 at 09:18 PM
-- Server version: 5.5.52-0+deb8u1
-- PHP Version: 5.6.27-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `proyectobase`
--

-- --------------------------------------------------------

--
-- Table structure for table `CARGO`
--

CREATE TABLE IF NOT EXISTS `CARGO` (
`CARID` bigint(20) NOT NULL,
  `CARNOMBRE` varchar(75) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CARGO`
--

INSERT INTO `CARGO` (`CARID`, `CARNOMBRE`) VALUES
(1, 'Docente'),
(2, 'Administrativo');

-- --------------------------------------------------------

--
-- Table structure for table `GRUPO`
--

CREATE TABLE IF NOT EXISTS `GRUPO` (
  `GRUID` varchar(20) NOT NULL,
  `GRUDESCRIPCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GRUPO`
--

INSERT INTO `GRUPO` (`GRUID`, `GRUDESCRIPCION`) VALUES
('admin', 'administrador'),
('user', 'usuario');

-- --------------------------------------------------------

--
-- Table structure for table `USUARIO`
--

CREATE TABLE IF NOT EXISTS `USUARIO` (
`USUID` bigint(20) NOT NULL,
  `CARID` bigint(20) DEFAULT NULL,
  `USUFECHANACIMIENTO` datetime NOT NULL,
  `USUNOMBRES` varchar(75) NOT NULL,
  `USUAPELLIDOS` varchar(75) NOT NULL,
  `USUGENERO` char(1) NOT NULL,
  `USUNOMBREUSUARIO` varchar(75) NOT NULL,
  `USUCONTRASENA` varchar(250) NOT NULL,
  `USUEMAIL` varchar(150) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20141269 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USUARIO`
--

INSERT INTO `USUARIO` (`USUID`, `CARID`, `USUFECHANACIMIENTO`, `USUNOMBRES`, `USUAPELLIDOS`, `USUGENERO`, `USUNOMBREUSUARIO`, `USUCONTRASENA`, `USUEMAIL`) VALUES
(20141238, 1, '1962-01-02 00:00:00', 'Nairo Juan', 'Grisales Sarmiento', 'M', 'admin', '123', 'nairo@unicauca.edu.co'),
(20141239, 1, '1966-08-28 00:00:00', 'Carlos', 'Londoño', 'M', 'pmage', '123', 'carlitos@unicauca.edu.co'),
(20141240, 1, '1976-04-08 00:00:00', 'Andrea', 'Burbano', 'F', 'andrea', '123', 'andrea@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `USUARIOGRUPO`
--

CREATE TABLE IF NOT EXISTS `USUARIOGRUPO` (
  `GRUID` varchar(20) NOT NULL,
  `USUID` bigint(20) NOT NULL,
  `USUNOMBREUSUARIO` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USUARIOGRUPO`
--

INSERT INTO `USUARIOGRUPO` (`GRUID`, `USUID`, `USUNOMBREUSUARIO`) VALUES
('admin', 20141238, 'admin'),
('user', 20141239, 'pmage'),
('user', 20141240, 'wpantoja');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CARGO`
--
ALTER TABLE `CARGO`
 ADD PRIMARY KEY (`CARID`);

--
-- Indexes for table `GRUPO`
--
ALTER TABLE `GRUPO`
 ADD PRIMARY KEY (`GRUID`);

--
-- Indexes for table `USUARIO`
--
ALTER TABLE `USUARIO`
 ADD PRIMARY KEY (`USUID`), ADD KEY `FK_USUARIOCARGO` (`CARID`);

--
-- Indexes for table `USUARIOGRUPO`
--
ALTER TABLE `USUARIOGRUPO`
 ADD PRIMARY KEY (`GRUID`,`USUID`), ADD KEY `FK_USUARIO_USUID` (`USUID`), ADD KEY `FK_GRUPOS_GRUID` (`GRUID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CARGO`
--
ALTER TABLE `CARGO`
MODIFY `CARID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `USUARIO`
--
ALTER TABLE `USUARIO`
MODIFY `USUID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20141269;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `USUARIO`
--
ALTER TABLE `USUARIO`
ADD CONSTRAINT `FK_USUARIOCARGO` FOREIGN KEY (`CARID`) REFERENCES `CARGO` (`CARID`);

--
-- Constraints for table `USUARIOGRUPO`
--
ALTER TABLE `USUARIOGRUPO`
ADD CONSTRAINT `FK_GRUPOS_GRUID` FOREIGN KEY (`GRUID`) REFERENCES `GRUPO` (`GRUID`),
ADD CONSTRAINT `FK_USUARIO_USUID` FOREIGN KEY (`USUID`) REFERENCES `USUARIO` (`USUID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
CREATE TABLE IF NOT EXISTS `estudiante` ( 
  `est_id` int(11) NOT NULL, 
  `est_codigo` varchar(12) NOT NULL, 
  `est_nombre` varchar(45) NOT NULL, 
  `est_correo` varchar(30) NOT NULL, 
  `est_cohorte` varchar(10) NOT NULL, 
  `est_contrasena` varchar(40) NOT NULL, 
  `est_tutor` varchar(45) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

ALTER TABLE `estudiante`
 ADD PRIMARY KEY (`est_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
MODIFY `est_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
