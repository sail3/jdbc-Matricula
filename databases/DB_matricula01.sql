-- MySQL dump 10.13  Distrib 5.1.61, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: DB_matricula
-- ------------------------------------------------------
-- Server version	5.1.61-2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `int_alumid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_alumnombre` varchar(40) NOT NULL,
  `chr_alumrecibo` char(10) NOT NULL,
  PRIMARY KEY (`int_alumid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
INSERT INTO `Alumno` VALUES (1000,'alumno','recibo0000');
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Curso`
--

DROP TABLE IF EXISTS `Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Curso` (
  `int_cursid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_cursnombre` varchar(40) NOT NULL,
  `vch_cursdescripcion` varchar(80) NOT NULL DEFAULT 'No hay descripcion disponible',
  `int_curscreditos` int(1) NOT NULL,
  PRIMARY KEY (`int_cursid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1 COMMENT='Cursos que se impartiran.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Curso`
--

LOCK TABLES `Curso` WRITE;
/*!40000 ALTER TABLE `Curso` DISABLE KEYS */;
INSERT INTO `Curso` VALUES (1000,'curso','curso',3);
/*!40000 ALTER TABLE `Curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Matricula`
--

DROP TABLE IF EXISTS `Matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Matricula` (
  `int_matrid` int(4) NOT NULL AUTO_INCREMENT,
  `int_alumid` int(4) NOT NULL,
  `int_progid` int(4) NOT NULL,
  `vch_matrsemestre` varchar(15) NOT NULL,
  PRIMARY KEY (`int_matrid`),
  KEY `fk_matricula_alumno` (`int_alumid`),
  KEY `fk_matricula_programacion` (`int_progid`),
  CONSTRAINT `Matricula_ibfk_1` FOREIGN KEY (`int_alumid`) REFERENCES `Alumno` (`int_alumid`),
  CONSTRAINT `Matricula_ibfk_2` FOREIGN KEY (`int_progid`) REFERENCES `Programacion` (`int_progid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Matricula`
--

LOCK TABLES `Matricula` WRITE;
/*!40000 ALTER TABLE `Matricula` DISABLE KEYS */;
INSERT INTO `Matricula` VALUES (1000,1000,1000,'Semestre Academ');
/*!40000 ALTER TABLE `Matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profesor`
--

DROP TABLE IF EXISTS `Profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profesor` (
  `int_profid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_profnombre` varchar(40) NOT NULL,
  `vch_proftitulo` varchar(40) NOT NULL,
  PRIMARY KEY (`int_profid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profesor`
--

LOCK TABLES `Profesor` WRITE;
/*!40000 ALTER TABLE `Profesor` DISABLE KEYS */;
INSERT INTO `Profesor` VALUES (1000,'profesor','profesor');
/*!40000 ALTER TABLE `Profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Programacion`
--

DROP TABLE IF EXISTS `Programacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Programacion` (
  `int_progid` int(4) NOT NULL AUTO_INCREMENT,
  `int_cursid` int(4) NOT NULL,
  `int_profid` int(4) NOT NULL,
  `vch_proghorario` varchar(20) NOT NULL DEFAULT 'No hay programacion.',
  PRIMARY KEY (`int_progid`),
  KEY `fk_programacion_curso` (`int_cursid`),
  KEY `fk_programacion_profesor` (`int_profid`),
  CONSTRAINT `Programacion_ibfk_1` FOREIGN KEY (`int_cursid`) REFERENCES `Curso` (`int_cursid`),
  CONSTRAINT `Programacion_ibfk_2` FOREIGN KEY (`int_profid`) REFERENCES `Profesor` (`int_profid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1 COMMENT='Programacion de cada curso';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Programacion`
--

LOCK TABLES `Programacion` WRITE;
/*!40000 ALTER TABLE `Programacion` DISABLE KEYS */;
INSERT INTO `Programacion` VALUES (1000,1000,1000,'horario');
/*!40000 ALTER TABLE `Programacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-22 12:19:20
