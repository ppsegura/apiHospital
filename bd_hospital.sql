-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2022 a las 04:47:49
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--
-- borra la bd si existe
DROP DATABASE IF EXISTS bd_hospital;

SET GLOBAL FOREIGN_KEY_CHECKS=0;
-- creamos la bd
CREATE DATABASE bd_hospital;
-- activamos la bd
USE bd_hospital;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `PacienteID` int NOT NULL auto_increment primary key,
  `Nombres` varchar(50) DEFAULT NULL,
  `ApePat` varchar(50) DEFAULT NULL,
  `ApeMat` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Tipo_Doc` varchar(50) DEFAULT NULL,
  `Nro_Doc` varchar(50) DEFAULT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `Edad` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--
select * from paciente;
INSERT INTO `paciente` (`PacienteID`, `Nombres`, `ApePat`, `ApeMat`, `Email`, `Tipo_Doc`, `Nro_Doc`, `Fecha_Nacimiento`, `Edad`) VALUES
(1, 'David Alfonso', 'Caceres', 'Solsol', 'davidca@gmail.com', 'DNI', '09545583', '1945-02-15', 77),
(2, 'Mirko Fernando', 'Leiva', 'Castillo', 'mirkoleicas@gmail.com', 'DNI', '09545583', '1981-10-20', 40),
(3, 'Jaime Raul', 'Ramirez', 'Raza', 'jaimeramraz@gmail.com', 'DNI', '41638057', '1999-05-28', 22),
(4, 'Jose Efrain', 'Colina', 'Serra', 'josecolser@gmail.com', 'DNI', '97105348', '1960-06-09', 61),
(5, 'George Michael', 'Segura', 'Ccapa', 'georgesegcap@gmail.com', 'DNI', '146559417', '1950-09-21', 71),
(6, 'Abraham Jose', 'Molina', 'Medina', 'abrahammolme@gmail.com', 'DNI', '87492132', '1970-11-07', 51),
(7, 'Maicol Jhonatan', 'Barrozo', 'Figueroa', 'maicolbafi@gmail.com', 'DNI', '92345892', '1980-08-08', 41),
(8, 'Brandon', 'Villanueva', 'Salas', 'branvillsal@gmail.com', 'DNI', '41567841', '2000-07-13', 21),
(9, 'Ivan Enrique', 'Escobar', 'Hanco', 'ivaneschanc@gmail.com', 'DNI', '98745862', '2001-06-20', 20);

/*insert into paciente values('Pedro', 'Peña', 'Segura', 'ppsegura@gmail.com', 'DNI', '55555555', '1998-06-20', 25);*/
--
--
--
-- Estructura de tabla para la tabla `hospital`
--

CREATE TABLE `hospital` (
  `HospitalID` int NOT NULL auto_increment primary key,
  `Departamento` varchar(50) NOT NULL,
  `Distrito` varchar(50) NOT NULL,
  `Direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hospital`
--

INSERT INTO `hospital` (`HospitalID`, `Departamento`, `Distrito`, `Direccion`) VALUES
(1, 'Lima', 'Comas', 'Av. Túpac Amaru Km. 4.5, Comas 15328'),
(2, 'Lima', 'San Juan de Lurigancho', 'Av. Canto Grande, San Juan de Lurigancho 15423'),
(3, 'Lima', 'San Borja', 'Av. Javier Prado Este 3101, Cercado de Lima 15037'),
(4, 'Lima', 'Los Olivos', 'Av. Naranjal, Cercado de Lima 15328'),
(5, 'Lima', 'Callao', 'Av. Tomas Valle 3535, Callao 07036');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `MedicoID` int NOT NULL auto_increment primary key,
  `HospitalID` int NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `ApePat` varchar(50) DEFAULT NULL,
  `ApeMat` varchar(50) DEFAULT NULL,
  `Especialidad` varchar(255) DEFAULT NULL,
  `Area` varchar(255) DEFAULT NULL,
  foreign key(`HospitalID`) references `hospital`(`HospitalID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`MedicoID`, `HospitalID`, `Nombre`, `ApePat`, `ApeMat`, `Especialidad`, `Area`) VALUES
(6, 2, 'Jorge Luis', 'Gonzalez', 'Echeverria', 'Dermatología', NULL),
(7, 5, 'Frank Jesùs', 'Diestra', 'Mezarina', 'Traumatología', NULL),
(8, 4, 'John Paul', 'Chunga', 'Castillo', 'Pediatría', NULL),
(9, 3, 'Kevin Jorge', 'Argote', 'Basualdo', 'Cardiología', NULL),
(10, 1, 'Jose Luis', 'Castillo', 'Montes', 'Gastroenterología', NULL);
-- Estructura de tabla para la tabla `cita_medica`
--

CREATE TABLE `cita_medica` (
  `CitaMedicaID` int NOT NULL auto_increment primary key,
  `Fecha_Creacion` date NOT NULL,
  `PacienteID` int NOT NULL,
  `MedicoID` int NOT NULL,
  `Area` varchar(50) NOT NULL,
  `HospitalID` int NOT NULL,
  `Estado` varchar(50) NOT NULL,
  foreign key(`PacienteID`) references `paciente`(`PacienteID`),
  foreign key(`MedicoID`) references `medico`(`MedicoID`),
  foreign key(`HospitalID`) references `hospital`(`HospitalID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_medico`
--

CREATE TABLE `historial_medico` (
  `HistorialMedicoID` int NOT NULL auto_increment primary key,
  `CitaMedicaID` int DEFAULT NULL,
  `Sintomas` varchar(450) DEFAULT NULL,
  `Diagnostico` varchar(250) DEFAULT NULL,
  `Peso` double DEFAULT NULL,
  `Altura` double DEFAULT NULL,
  foreign key(`CitaMedicaID`) references `cita_medica`(`CitaMedicaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------




-- --------------------------------------------------------

-- Índices para tablas volcadas
--
--
/*-- Indices de la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  ADD PRIMARY KEY (`CitaMedicaID`),
  ADD KEY `PacienteID` (`PacienteID`),
  ADD KEY `MedicoID` (`MedicoID`),
  ADD KEY `HospitalID` (`HospitalID`);

--
-- Indices de la tabla `historial_medico`
--
ALTER TABLE `historial_medico`
  ADD PRIMARY KEY (`HistorialMedicoID`),
  ADD KEY `CitaMedicaID` (`CitaMedicaID`);

--
-- Indices de la tabla `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`HospitalID`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`MedicoID`),
  ADD KEY `HospitalID` (`HospitalID`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`PacienteID`);*/

-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita_medica`
--
/*ALTER TABLE `cita_medica`
  ADD CONSTRAINT `cita_medica_ibfk_1` FOREIGN KEY (`HospitalID`) REFERENCES `hospital` (`HospitalID`),
  ADD CONSTRAINT `cita_medica_ibfk_2` FOREIGN KEY (`MedicoID`) REFERENCES `medico` (`MedicoID`),
  ADD CONSTRAINT `cita_medica_ibfk_3` FOREIGN KEY (`PacienteID`) REFERENCES `paciente` (`PacienteID`);

--
-- Filtros para la tabla `historial_medico`
--
ALTER TABLE `historial_medico`
  ADD CONSTRAINT `historial_medico_ibfk_1` FOREIGN KEY (`CitaMedicaID`) REFERENCES `cita_medica` (`CitaMedicaID`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`HospitalID`) REFERENCES `hospital` (`HospitalID`);*/
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;