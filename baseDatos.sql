SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `dogebarcelo` DEFAULT CHARACTER SET utf8 ;
USE `dogebarcelo` ;

-- -----------------------------------------------------
-- Table `dogebarcelo`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`cliente` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`cliente` (
  `idCliente` INT(11) NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Cedula` VARCHAR(45) NOT NULL ,
  `Telefono` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCliente`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`Cadena_Hotelera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`Cadena_Hotelera` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`Cadena_Hotelera` (
  `idCadena_Hotelera` INT(11) NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCadena_Hotelera`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`hotel` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`hotel` (
  `idHotel` INT(11) NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Ubicacion` VARCHAR(45) NOT NULL ,
  `Cadena_Hotelera_idCadena_Hotelera` INT(11) NOT NULL ,
  PRIMARY KEY (`idHotel`) ,
  INDEX `fk_Hotel_dogebarcelo_idx` (`Cadena_Hotelera_idCadena_Hotelera` ASC) ,
  CONSTRAINT `fk_Hotel_dogebarcelo`
    FOREIGN KEY (`Cadena_Hotelera_idCadena_Hotelera` )
    REFERENCES `dogebarcelo`.`Cadena_Hotelera` (`idCadena_Hotelera` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`servicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`servicios` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`servicios` (
  `idServicios` INT(11) NOT NULL ,
  `Descripcion` VARCHAR(45) NOT NULL ,
  `Horario` DATETIME NOT NULL ,
  `Costo` INT(11) NOT NULL ,
  `Hotel_idHotel` INT(11) NOT NULL ,
  PRIMARY KEY (`idServicios`) ,
  INDEX `fk_Servicios_Hotel1_idx` (`Hotel_idHotel` ASC) ,
  CONSTRAINT `fk_Servicios_Hotel1`
    FOREIGN KEY (`Hotel_idHotel` )
    REFERENCES `dogebarcelo`.`hotel` (`idHotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`cliente_has_servicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`cliente_has_servicios` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`cliente_has_servicios` (
  `Cliente_idCliente` INT(11) NOT NULL ,
  `Servicios_idServicios` INT(11) NOT NULL ,
  PRIMARY KEY (`Cliente_idCliente`, `Servicios_idServicios`) ,
  INDEX `fk_Cliente_has_Servicios_Servicios1_idx` (`Servicios_idServicios` ASC) ,
  INDEX `fk_Cliente_has_Servicios_Cliente1_idx` (`Cliente_idCliente` ASC) ,
  CONSTRAINT `fk_Cliente_has_Servicios_Cliente1`
    FOREIGN KEY (`Cliente_idCliente` )
    REFERENCES `dogebarcelo`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_Servicios_Servicios1`
    FOREIGN KEY (`Servicios_idServicios` )
    REFERENCES `dogebarcelo`.`servicios` (`idServicios` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`usuarios` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`usuarios` (
  `id` INT(11) NOT NULL ,
  `idHotel` INT(11) NOT NULL ,
  `nombre` VARCHAR(45) NULL DEFAULT NULL ,
  `contrasenna` VARCHAR(45) NULL DEFAULT NULL ,
  `rol` VARCHAR(45) NULL DEFAULT NULL ,
  `salario` INT(11) NULL DEFAULT NULL ,
  `precioPorHora` INT(11) NULL DEFAULT NULL ,
  `keywords` TEXT NULL DEFAULT NULL ,
  `correo` VARCHAR(45) NULL DEFAULT NULL ,
  `horaEntrada` TIME NULL DEFAULT NULL ,
  `horaSalida` TIME NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_usuarios_hotel1` (`idHotel` ASC) ,
  CONSTRAINT `fk_usuarios_hotel1`
    FOREIGN KEY (`idHotel` )
    REFERENCES `dogebarcelo`.`hotel` (`idHotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`controlhorarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`controlhorarios` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`controlhorarios` (
  `idUsuario` INT(11) NOT NULL ,
  `fecha` DATE NOT NULL ,
  `horaEntrada` TIME NULL DEFAULT NULL ,
  `horaSalida` TIME NULL DEFAULT NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_ControlHorarios_Usuarios_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_ControlHorarios_Usuarios`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `dogebarcelo`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`habitaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`habitaciones` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`habitaciones` (
  `idHabitaciones` INT(11) NOT NULL ,
  `Hotel_idHotel` INT(11) NOT NULL ,
  PRIMARY KEY (`idHabitaciones`) ,
  INDEX `fk_Habitaciones_Hotel1_idx` (`Hotel_idHotel` ASC) ,
  CONSTRAINT `fk_Habitaciones_Hotel1`
    FOREIGN KEY (`Hotel_idHotel` )
    REFERENCES `dogebarcelo`.`hotel` (`idHotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`elemento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`elemento` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`elemento` (
  `idElemento` INT(11) NOT NULL ,
  `Descripcion_Elemento` VARCHAR(45) NOT NULL ,
  `Habitaciones_idHabitaciones` INT(11) NOT NULL ,
  PRIMARY KEY (`idElemento`) ,
  INDEX `fk_Elemento_Habitaciones1_idx` (`Habitaciones_idHabitaciones` ASC) ,
  CONSTRAINT `fk_Elemento_Habitaciones1`
    FOREIGN KEY (`Habitaciones_idHabitaciones` )
    REFERENCES `dogebarcelo`.`habitaciones` (`idHabitaciones` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`reservacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`reservacion` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`reservacion` (
  `idReservacion` INT(11) NOT NULL ,
  `Hotel_idHotel` INT(11) NOT NULL ,
  `Cliente_idCliente` INT(11) NOT NULL ,
  `Fecha_Llegada` VARCHAR(45) NOT NULL ,
  `Fecha_Salida` VARCHAR(45) NOT NULL ,
  `Fecha_Reserva` VARCHAR(45) NOT NULL ,
  `Costo` INT(11) NOT NULL ,
  PRIMARY KEY (`idReservacion`) ,
  INDEX `fk_Reservacion_Hotel1_idx` (`Hotel_idHotel` ASC) ,
  INDEX `fk_Reservacion_Cliente1_idx` (`Cliente_idCliente` ASC) ,
  CONSTRAINT `fk_Reservacion_Hotel1`
    FOREIGN KEY (`Hotel_idHotel` )
    REFERENCES `dogebarcelo`.`hotel` (`idHotel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservacion_Cliente1`
    FOREIGN KEY (`Cliente_idCliente` )
    REFERENCES `dogebarcelo`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`factura` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`factura` (
  `idFactura` INT(11) NOT NULL ,
  `Reservacion_idReservacion` INT(11) NOT NULL ,
  PRIMARY KEY (`idFactura`) ,
  INDEX `fk_Factura_Reservacion1_idx` (`Reservacion_idReservacion` ASC) ,
  CONSTRAINT `fk_Factura_Reservacion1`
    FOREIGN KEY (`Reservacion_idReservacion` )
    REFERENCES `dogebarcelo`.`reservacion` (`idReservacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`horas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`horas` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`horas` (
  `idUsuario` INT(11) NOT NULL ,
  `fecha` DATE NULL DEFAULT NULL ,
  `HorasExtra` INT(11) NULL DEFAULT NULL ,
  `HorasNormales` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idUsuario`) ,
  CONSTRAINT `fk_HorasExtra_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `dogebarcelo`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`pagos` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`pagos` (
  `idUsuario` INT(11) NOT NULL ,
  `fecha` VARCHAR(45) NOT NULL ,
  `cantidad` INT(11) NOT NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_Pagos_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_Pagos_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `dogebarcelo`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`permisos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`permisos` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`permisos` (
  `idUsuario` INT(11) NOT NULL ,
  `desdeFecha` DATE NOT NULL ,
  `hastaFecha` DATE NULL DEFAULT NULL ,
  `tipo` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` TINYINT(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`idUsuario`, `desdeFecha`) ,
  INDEX `fk_Permisos_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_Permisos_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `dogebarcelo`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`servicio_extra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`servicio_extra` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`servicio_extra` (
  `idServicio_Extra` INT(11) NOT NULL ,
  `Descripcion` VARCHAR(45) NOT NULL ,
  `Costo` INT(11) NOT NULL ,
  `Horario` DATETIME NOT NULL ,
  `Habitaciones_idHabitaciones` INT(11) NOT NULL ,
  PRIMARY KEY (`idServicio_Extra`) ,
  INDEX `fk_Servicio_Extra_Habitaciones1_idx` (`Habitaciones_idHabitaciones` ASC) ,
  CONSTRAINT `fk_Servicio_Extra_Habitaciones1`
    FOREIGN KEY (`Habitaciones_idHabitaciones` )
    REFERENCES `dogebarcelo`.`habitaciones` (`idHabitaciones` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dogebarcelo`.`shiftreports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogebarcelo`.`shiftreports` ;

CREATE  TABLE IF NOT EXISTS `dogebarcelo`.`shiftreports` (
  `idUsuario` INT(11) NOT NULL ,
  `fecha` DATE NOT NULL ,
  `reporte` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_ShiftReports_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_ShiftReports_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `dogebarcelo`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
