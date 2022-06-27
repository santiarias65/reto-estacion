-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2022 a las 02:12:10
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lanzadera`
--

CREATE TABLE `lanzadera` (
  `carga` double NOT NULL,
  `potencia` double DEFAULT NULL,
  `VEHICULO_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `lanzadera`
--

INSERT INTO `lanzadera` (`carga`, `potencia`, `VEHICULO_id`) VALUES
(118, 32000, 12),
(100, 30000, 13),
(130, 35000, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notripulada`
--

CREATE TABLE `notripulada` (
  `estudio` varchar(60) NOT NULL,
  `VEHICULO_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `notripulada`
--

INSERT INTO `notripulada` (`estudio`, `VEHICULO_id`) VALUES
('Júpiter', 15),
('Saturno y sus lunas', 16),
('Marte', 17),
('pluton', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tripulada`
--

CREATE TABLE `tripulada` (
  `numero_tripulantes` int(11) NOT NULL,
  `mision` varchar(60) DEFAULT NULL,
  `VEHICULO_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tripulada`
--

INSERT INTO `tripulada` (`numero_tripulantes`, `mision`, `VEHICULO_id`) VALUES
(5, 'laboratorio en el espacio', 18),
(3, 'llevar acabo investigaciones en el espacio', 19),
(1, 'llevar el primer hombre al espacio', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id` int(11) NOT NULL,
  `tipo_nave` varchar(45) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `combustible` varchar(45) DEFAULT NULL,
  `peso` varchar(30) DEFAULT NULL,
  `empuje` varchar(30) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id`, `tipo_nave`, `nombre`, `combustible`, `peso`, `empuje`, `descripcion`) VALUES
(12, 'Vehiculo de Lanzadera', 'Saturno V', 'petróleo refinado y oxígeno líquido', '2900T', '3500T', 'fue retirado en 1973'),
(13, 'Vehiculo de Lanzadera', 'misilin d', 'oxígeno líquido', '2500T', '2900T', 'descripcion de la nave'),
(14, 'Vehiculo de Lanzadera', 'carga max', 'petroleo refinad', '3200T', '3100T', 'nave de alta carga'),
(15, 'Nave No Tripulada', 'Pionero X', 'no informacion', '258KG', '26KG', 'se desplaza sin energía de forma inercial'),
(16, 'Nave No Tripulada', 'Cassini', 'tetróxido de nitrógeno', '2150KG', '45,39KG', 'Desplazándose a unos 18000 km/h '),
(17, 'Nave No Tripulada', 'Mariner IV', 'hidracina', '2000KG', '22,44KG', 'existen varios modelos de esta nave'),
(18, 'Nave Tripulada', 'Skylab', 'no info', '77T', 'no infonull', 'centro de investigación espaciales'),
(19, 'Nave Tripulada', 'Salyut', 'no info', '19,8T', 'no infonull', 'orbita a una media de 248,9 km de distancia sobre la superficie terrestre'),
(20, 'Nave Tripulada', 'Vostok', 'no info', '15T', 'no infonull', 'primera de la historia en llevar un ser humano al espacio'),
(21, 'Nave No Tripulada', 'Horizons', 'no info', '2000KG', '0,44KG', 'Viaja a unos 56000 km/h');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `lanzadera`
--
ALTER TABLE `lanzadera`
  ADD PRIMARY KEY (`VEHICULO_id`) USING BTREE,
  ADD KEY `fk_LANZADERA_VEHICULO1_idx` (`VEHICULO_id`);

--
-- Indices de la tabla `notripulada`
--
ALTER TABLE `notripulada`
  ADD PRIMARY KEY (`VEHICULO_id`) USING BTREE,
  ADD KEY `fk_noTRIPULADA_VEHICULO_idx` (`VEHICULO_id`);

--
-- Indices de la tabla `tripulada`
--
ALTER TABLE `tripulada`
  ADD PRIMARY KEY (`VEHICULO_id`) USING BTREE,
  ADD KEY `fk_TRIPULADA_VEHICULO1_idx` (`VEHICULO_id`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lanzadera`
--
ALTER TABLE `lanzadera`
  ADD CONSTRAINT `fk_LANZADERA_VEHICULO1` FOREIGN KEY (`VEHICULO_id`) REFERENCES `vehiculo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `notripulada`
--
ALTER TABLE `notripulada`
  ADD CONSTRAINT `fk_noTRIPULADA_VEHICULO` FOREIGN KEY (`VEHICULO_id`) REFERENCES `vehiculo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tripulada`
--
ALTER TABLE `tripulada`
  ADD CONSTRAINT `fk_TRIPULADA_VEHICULO1` FOREIGN KEY (`VEHICULO_id`) REFERENCES `vehiculo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
