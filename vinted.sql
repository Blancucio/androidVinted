-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-03-2023 a las 13:15:16
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vinted`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `ID_COMPRA` int(5) NOT NULL,
  `ID_USUARIO` int(5) DEFAULT NULL,
  `ID_PRODUCTO` int(5) DEFAULT NULL,
  `EMAIL` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `NOTIFICACION_COMPRA` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_PRODUCTO` int(5) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `IMAGEN` varchar(500) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `DESCRIPCION` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `PRECIO` int(4) NOT NULL,
  `VENDIDO` tinyint(1) DEFAULT NULL,
  `PUNTUACION` int(2) DEFAULT NULL,
  `CATEGORIA` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `ID_USUARIO` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_PRODUCTO`, `NOMBRE`, `IMAGEN`, `DESCRIPCION`, `PRECIO`, `VENDIDO`, `PUNTUACION`, `CATEGORIA`, `ID_USUARIO`) VALUES
(1, 'Camiseta estampada', 'https://www.colmar.com/dw/image/v2/BDNR_PRD/on/demandware.static/-/Sites-colmar-master-catalog/default/dwa00984ed/images/8033129441081---35371WZES2209-S-AF-N-N-6-N.jpg?sw=693&sh=956', 'Camiseta estampada de algodón', 25, 0, 0, 'Ropa', 1),
(2, 'Pantalones vaqueros', 'https://media.vogue.es/photos/5cc7367ffdc82261481fda65/master/w_1600%2Cc_limit/pantalones_vaqueros_mom_jeans_goma_pull_bear_basico_armario_2019_7512.jpg', 'Pantalones vaqueros desgastados', 45, 0, 0, 'Ropa', 1),
(3, 'Vestido de noche', 'https://smoda.elpais.com/wp-content/uploads/images/201228/travesti_2138.jpg', 'Vestido de noche con lentejuelas', 120, 0, 0, 'Ropa', 2),
(4, 'Blusa de seda', 'https://www.caroll.com/on/demandware.static/-/Sites-Caroll_master/default/dwb7464cf6/blouse-100-soie-tatiana-ivoire-femme-vue1-35967719110261014.jpg', 'Blusa de seda con volantes', 55, 0, 3, 'Ropa', 2),
(5, 'Camiseta deportiva', 'https://imagenes.20minutos.es/files/article_default_content/uploads/imagenes/2022/06/14/camiseta-athletic-2004-2005.jpeg', 'Camiseta deportiva', 25, 0, 0, 'Ropa', 3),
(6, 'Pantalones Chinos', 'https://mm1.valecuatro.com/33073-large_default/pantalon-h-chino.jpg', 'Pantalones chinos ajustados', 45, 0, 0, 'Ropa', 3),
(7, 'Reloj Rolex', 'https://i1.wp.com/clipset.com/wp-content/uploads/2013/04/Reloj-Dora-clipset-Iron-Man.jpg?resize=552%2C419&ssl=1', 'Reloj Rolex acero inoxidable', 120, 0, 7, 'Accesorios', 4),
(8, 'Sudadera Felpa', 'https://benisportshop.es/416-large_default/sudadera_felpa_240_gr_.jpg', 'Sudadera de felpa con cremallera', 55, 0, 0, 'Ropa', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(5) NOT NULL,
  `NOMBRE` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `NUM_VENTAS` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `NOMBRE`, `NUM_VENTAS`) VALUES
(1, 'Cristian', 0),
(2, 'José', 0),
(3, 'Antonio', 0),
(4, 'Lucia', 0),
(5, 'Alexandra', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`ID_COMPRA`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`),
  ADD KEY `ID_PRODUCTO` (`ID_PRODUCTO`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ID_PRODUCTO` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `productos` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
