-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-08-2023 a las 15:30:30
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gymapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `id_entradas` int(11) NOT NULL,
  `documento` varchar(50) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id_metodo`, `nombre`, `descripcion`) VALUES
(1, 'efectivo', 'Pago en efectivo'),
(2, 'nequi', 'Pago a través de Nequi'),
(3, 'daviplata', 'Pago a través de Daviplata'),
(4, 'bancolombia', 'Pago a través de Bancolombia'),
(5, 'debit.card', 'Pago con tarjeta de débito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_informepago` int(11) NOT NULL,
  `id_metodo` int(11) NOT NULL,
  `id_suscripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_informepago`, `id_metodo`, `id_suscripcion`) VALUES
(1, 1, 3),
(2, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrosuscriptor`
--

CREATE TABLE `registrosuscriptor` (
  `documento` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `rh` varchar(50) NOT NULL,
  `fechaNacimiento` varchar(50) NOT NULL,
  `numero_emergencia` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `discapacidad` varchar(50) NOT NULL,
  `estado` tinyint(4) DEFAULT 1,
  `image_data` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registrosuscriptor`
--

INSERT INTO `registrosuscriptor` (`documento`, `nombre`, `apellido`, `telefono`, `correo`, `direccion`, `rh`, `fechaNacimiento`, `numero_emergencia`, `sexo`, `discapacidad`, `estado`, `image_data`) VALUES
('1078', 'Herrera', 'Herrera', '147', 'mateo@gmail.com', 'calle 11', 'a+', '02/02/2020', '369', 'MASCULINO', '1222', 1, NULL),
('1088', 'Juliana', 'Vanila', '30544', 'julian@mail.com', 'calle 9', '0+', '25/08/2023', '666', 'FEMENINO', 'Espalda', 1, NULL),
('144', 'Juan', 'Carmona', '9787', 'pablo@mail.com', '2500', 'o+', '13/08/1986', '0000', 'MASCULINO', 'Viejo', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripciones`
--

CREATE TABLE `suscripciones` (
  `id_suscripcion` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `documento` varchar(50) NOT NULL,
  `descuento` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `suscripciones`
--

INSERT INTO `suscripciones` (`id_suscripcion`, `id_tipo`, `documento`, `descuento`, `fecha_inicio`, `fecha_fin`, `estado`) VALUES
(1, 1, '1078', 0, '2023-08-24', '2023-09-23', 1),
(3, 3, '1088', 0, '2023-08-25', '2024-08-24', 1),
(4, 3, '144', 0, '2023-08-25', '2024-08-24', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_suscripcion`
--

CREATE TABLE `tipo_suscripcion` (
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `dias` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_suscripcion`
--

INSERT INTO `tipo_suscripcion` (`id_tipo`, `nombre`, `descripcion`, `precio`, `dias`) VALUES
(1, 'EASY - Recurrente Mensual', 'Suscripcion Por Mes', 90000, 30),
(2, 'VIP - Recurrente Semestral', 'Suscripcion Por 6 Meses', 390000, 180),
(3, 'VIP - Recurrente Anual', 'Suscripcion Por 12 Meses', 590000, 365),
(4, 'EASY - IRREGULAR', 'Suscripcion por 15 dias', 50000, 15),
(5, 'Si es uno nuevo', 'Hola nueva suscripcion', 20000, 30),
(6, 'dadas', 'asdsadas', 40000, 45);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`id_entradas`),
  ADD KEY `documento` (`documento`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodo`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_informepago`),
  ADD KEY `id_metodo` (`id_metodo`),
  ADD KEY `id_suscripcion` (`id_suscripcion`);

--
-- Indices de la tabla `registrosuscriptor`
--
ALTER TABLE `registrosuscriptor`
  ADD PRIMARY KEY (`documento`);

--
-- Indices de la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD PRIMARY KEY (`id_suscripcion`),
  ADD KEY `id_tipo` (`id_tipo`),
  ADD KEY `documento` (`documento`);

--
-- Indices de la tabla `tipo_suscripcion`
--
ALTER TABLE `tipo_suscripcion`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `id_entradas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  MODIFY `id_metodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_informepago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  MODIFY `id_suscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_suscripcion`
--
ALTER TABLE `tipo_suscripcion`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `registrosuscriptor` (`documento`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_metodo`) REFERENCES `metodo_pago` (`id_metodo`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`id_suscripcion`) REFERENCES `suscripciones` (`id_suscripcion`);

--
-- Filtros para la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD CONSTRAINT `suscripciones_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_suscripcion` (`id_tipo`),
  ADD CONSTRAINT `suscripciones_ibfk_2` FOREIGN KEY (`documento`) REFERENCES `registrosuscriptor` (`documento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
