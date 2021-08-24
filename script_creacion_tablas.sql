CREATE DATABASE `dds` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use dds;

CREATE TABLE `boleto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `fila_columna` varchar(3) DEFAULT NULL,
  `id_funcion` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_funcion_idx` (`id_funcion`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `id_funcion` FOREIGN KEY (`id_funcion`) REFERENCES `funcion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `combo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_combo_padre` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_combo_padre_idx` (`id_combo_padre`),
  CONSTRAINT `id_combo_padre` FOREIGN KEY (`id_combo_padre`) REFERENCES `combo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comboxcliente` (
  `id_combo` int NOT NULL,
  `id_cliente` int NOT NULL,
  KEY `id_combo_idx` (`id_combo`),
  KEY `cliente_idx` (`id_cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `combo` FOREIGN KEY (`id_combo`) REFERENCES `combo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funcion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_sala` int DEFAULT NULL,
  `asientos_libres` int DEFAULT NULL,
  `asientos_totales` int DEFAULT NULL,
  `dia` int DEFAULT NULL,
  `fecha_funcion` datetime DEFAULT NULL,
  `precio_general` int DEFAULT NULL,
  `id_pelicula` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pelicula_idx` (`id_pelicula`),
  CONSTRAINT `id` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pelicula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `generos` varchar(500) DEFAULT NULL,
  `actores` varchar(500) DEFAULT NULL,
  `estreno` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `productoSimple` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_combo` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_combo_idx` (`id_combo`),
  CONSTRAINT `id_combo` FOREIGN KEY (`id_combo`) REFERENCES `combo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
