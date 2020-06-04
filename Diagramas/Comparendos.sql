SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `Usuario`;
DROP TABLE IF EXISTS `TipoUsuario`;
DROP TABLE IF EXISTS `Vehiculo`;
DROP TABLE IF EXISTS `TipoCobustible`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `Usuario` (
    `IdUsuario` INTEGER NOT NULL,
    `Nombres` VARCHAR(60) NOT NULL,
    `Apellidos` VARCHAR(60) NOT NULL,
    `Documento` INTEGER(15) NOT NULL,
    `Direccion` VARCHAR(100) NOT NULL,
    `Correo` VARCHAR(200) NOT NULL,
    `FechaNacimiento` DATE NOT NULL,
    `Contraseña` VARCHAR(200) NOT NULL,
    `IdTipoUsuario` INTEGER NOT NULL,
    PRIMARY KEY (`IdUsuario`)
);

CREATE TABLE `TipoUsuario` (
    `IdTipoUsuario` INTEGER NOT NULL,
    `Descripcion` INTEGER NOT NULL,
    PRIMARY KEY (`IdTipoUsuario`)
);

CREATE TABLE `Vehiculo` (
    `IdVehiculo` INTEGER NOT NULL,
    `Placa` VARCHAR(15) NOT NULL,
    `Marca` VARCHAR(100) NOT NULL,
    `Linea` VARCHAR(100) NOT NULL,
    `Modelo` INTEGER(100) NOT NULL,
    `NumeroMotor` VARCHAR(20) NOT NULL,
    `NumeroChasis` VARCHAR(20) NOT NULL,
    `NumeroVin` VARCHAR(20) NOT NULL,
    `Cilindraje` INTEGER NOT NULL,
    `IdTipoCombustible` INTEGER NOT NULL,
    `IdPropietario` INTEGER NOT NULL,
    `FechaMatricula` DATE NOT NULL,
    `CapacidadCarga` INTEGER(10) NOT NULL,
    `CapacidadPasajeros` INTEGER(10) NOT NULL,
    `Peso` INTEGER(10) NOT NULL,
    `NumeroEjes` INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdVehiculo`)
);

CREATE TABLE `TipoCobustible` (
    `IdTipoCombustible` INTEGER NOT NULL,
    `Descripcion` INTEGER NOT NULL,
    PRIMARY KEY (`IdTipoCombustible`)
);

ALTER TABLE `Usuario` ADD FOREIGN KEY (`IdTipoUsuario`) REFERENCES `TipoUsuario`(`IdTipoUsuario`);
ALTER TABLE `Vehiculo` ADD FOREIGN KEY (`IdTipoCombustible`) REFERENCES `TipoCobustible`(`IdTipoCombustible`);
ALTER TABLE `Vehiculo` ADD FOREIGN KEY (`IdPropietario`) REFERENCES `Usuario`(`IdUsuario`);