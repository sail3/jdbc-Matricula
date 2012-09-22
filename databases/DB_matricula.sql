# MySQL Navigator Xport
# Database: DB_matricula
# root@localhost

# CREATE DATABASE DB_matricula;
# USE DB_matricula;

#
# Table structure for table 'Alumno'
#

# DROP TABLE IF EXISTS Alumno;
CREATE TABLE `Alumno` (
  `int_alumid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_alumnombre` varchar(40) NOT NULL,
  `chr_alumrecibo` char(10) NOT NULL,
  PRIMARY KEY (`int_alumid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;

#
# Dumping data for table 'Alumno'
#

INSERT INTO Alumno VALUES (1000,'alumno','recibo0000');

#
# Table structure for table 'Curso'
#

# DROP TABLE IF EXISTS Curso;
CREATE TABLE `Curso` (
  `int_cursid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_cursnombre` varchar(40) NOT NULL,
  `vch_cursdescripcion` varchar(80) NOT NULL DEFAULT 'No hay descripcion disponible',
  `int_curscreditos` int(1) NOT NULL,
  PRIMARY KEY (`int_cursid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1 COMMENT='Cursos que se impartiran.';

#
# Dumping data for table 'Curso'
#

INSERT INTO Curso VALUES (1000,'curso','curso',3);

#
# Table structure for table 'Matricula'
#

# DROP TABLE IF EXISTS Matricula;
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

#
# Dumping data for table 'Matricula'
#

INSERT INTO Matricula VALUES (1000,1000,1000,'Semestre Academ');

#
# Table structure for table 'Profesor'
#

# DROP TABLE IF EXISTS Profesor;
CREATE TABLE `Profesor` (
  `int_profid` int(4) NOT NULL AUTO_INCREMENT,
  `vch_profnombre` varchar(40) NOT NULL,
  `vch_proftitulo` varchar(40) NOT NULL,
  PRIMARY KEY (`int_profid`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;

#
# Dumping data for table 'Profesor'
#

INSERT INTO Profesor VALUES (1000,'profesor','profesor');

#
# Table structure for table 'Programacion'
#

# DROP TABLE IF EXISTS Programacion;
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

#
# Dumping data for table 'Programacion'
#

INSERT INTO Programacion VALUES (1000,1000,1000,'horario');

