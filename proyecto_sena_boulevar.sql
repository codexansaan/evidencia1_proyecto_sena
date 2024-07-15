-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2024 a las 16:02:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_sena_boulevar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiaprima`
--

CREATE TABLE `materiaprima` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `stock` double NOT NULL,
  `unidadmedida` varchar(15) NOT NULL,
  `preciounidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materiaprima`
--

INSERT INTO `materiaprima` (`Id`, `Nombre`, `stock`, `unidadmedida`, `preciounidad`) VALUES
(67, 'Carne de hamburguesa', 15, 'Unidades', 0.75),
(71, 'Salsa de tomate', 2, 'Baldes', 6.75),
(74, 'Pechuga de pollo', 16, 'Libras', 1.75),
(84, 'Avena', 17, 'Libras', 0.56),
(100, 'Mantequilla', 36, 'Libras', 0.95),
(101, 'Papa de guiso', 33, 'libras', 0.35),
(103, 'Perejil', 3, 'Libras', 0.15),
(105, 'Levadura', 20, 'Libras', 1.5),
(106, 'Fresas', 20, 'Libras', 0.99),
(111, 'Limones', 25, 'Libras', 0.05),
(114, 'Pollo', 20, 'Libras', 1.15),
(115, 'Huevos', 25, 'Panal', 3.35),
(116, 'Cocacola', 25, 'Unidades', 0.45),
(117, 'Mora', 20, 'Libras', 1.25),
(120, 'Salchicha', 3, 'Paquete * 48', 6.75),
(129, 'Carne de empanadas', 32, 'Libras', 2),
(130, 'Peperoni', 2, 'kilos', 19.75),
(134, 'Carne de empanadas', 2, 'Libras', 2),
(136, 'Queso crema', 5, 'Baldes', 16.55),
(137, 'Pechuga de pollo', 4, 'Libras', 1.75),
(138, 'Salsa de tomate', 45, 'Baldes', 6.75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `precioLLevar` double DEFAULT NULL,
  `IVA` double DEFAULT NULL,
  `costo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id`, `Nombre`, `stock`, `precio`, `precioLLevar`, `IVA`, `costo`) VALUES
(1, 'Producto1', 100, 50, 55, 19, 35),
(2, 'Producto2', 200, 45, 50, 19, 20),
(3, 'Producto3', 300, 40, 45, 19, 18),
(4, 'Producto4', 150, 35, 40, 19, 16),
(5, 'Producto5', 250, 60, 65, 19, 45),
(6, 'Producto6', 350, 70, 75, 19, 200),
(7, 'Producto7', 400, 80, 85, 19, 50),
(8, 'Producto8', 500, 90, 95, 19, 55),
(9, 'Producto9', 600, 100, 105, 19, 65),
(10, 'Producto10', 700, 110, 115, 19, 50),
(11, 'Producto11', 800, 120, 125, 19, 50),
(12, 'Producto12', 900, 130, 135, 19, 50),
(13, 'Producto13', 1000, 140, 145, 19, 50),
(14, 'Producto14', 1100, 150, 155, 19, 50),
(15, 'Producto15', 1200, 160, 165, 19, 50),
(16, 'Producto16', 1300, 170, 175, 19, 50),
(17, 'Producto17', 1400, 180, 185, 19, 50),
(18, 'Producto18', 1500, 190, 195, 19, 50),
(19, 'Producto19', 1600, 200, 205, 19, 50),
(20, 'Producto20', 1700, 210, 215, 19, 50),
(21, 'Producto21', 1800, 220, 225, 19, 50),
(22, 'Producto22', 1900, 230, 235, 19, 50),
(23, 'Producto23', 2000, 240, 245, 19, 50),
(24, 'Producto24', 2100, 250, 255, 19, 50),
(25, 'Producto25', 2200, 260, 265, 19, 50),
(26, 'Producto26', 2300, 270, 275, 19, 50),
(27, 'Producto27', 2400, 280, 285, 19, 50),
(28, 'Producto28', 2500, 290, 295, 19, 50),
(29, 'Producto29', 2600, 300, 305, 19, 50),
(30, 'Producto30', 2700, 310, 315, 19, 50),
(31, 'Producto31', 2800, 320, 325, 19, 50),
(32, 'Producto32', 2900, 330, 335, 19, 50),
(33, 'Producto33', 3000, 340, 345, 19, 50),
(34, 'Producto34', 3100, 350, 355, 19, 50),
(35, 'Producto35', 3200, 360, 365, 19, 50);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `materiaprima`
--
ALTER TABLE `materiaprima`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `materiaprima`
--
ALTER TABLE `materiaprima`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=139;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
