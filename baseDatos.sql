SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuarios` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Usuarios` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `contrasenna` VARCHAR(45) NULL ,
  `rol` VARCHAR(45) NULL ,
  `salario` INT NULL ,
  `precioPorHora` INT NULL ,
  `keywords` TEXT NULL ,
  `correo` VARCHAR(45) NULL ,
  `horaEntrada` TIME NULL ,
  `horaSalida` TIME NULL ,
  `estado` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ControlHorarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ControlHorarios` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`ControlHorarios` (
  `idUsuario` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `horaEntrada` TIME NULL ,
  `horaSalida` TIME NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_ControlHorarios_Usuarios_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_ControlHorarios_Usuarios`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ShiftReports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ShiftReports` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`ShiftReports` (
  `idUsuario` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `reporte` TEXT NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_ShiftReports_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_ShiftReports_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permisos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Permisos` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Permisos` (
  `idUsuario` INT NOT NULL ,
  `desdeFecha` DATE NOT NULL ,
  `hastaFecha` DATE NULL ,
  `tipo` VARCHAR(45) NULL ,
  `estado` TINYINT(1) NULL ,
  PRIMARY KEY (`idUsuario`, `desdeFecha`) ,
  INDEX `fk_Permisos_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_Permisos_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pagos` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Pagos` (
  `idUsuario` INT NOT NULL ,
  `fecha` VARCHAR(45) NOT NULL ,
  `cantidad` INT NOT NULL ,
  PRIMARY KEY (`idUsuario`, `fecha`) ,
  INDEX `fk_Pagos_Usuarios1_idx` (`idUsuario` ASC) ,
  CONSTRAINT `fk_Pagos_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Horas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Horas` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Horas` (
  `idUsuario` INT NOT NULL ,
  `fecha` DATE NULL ,
  `HorasExtra` INT NULL ,
  `HorasNormales` INT NULL ,
  PRIMARY KEY (`idUsuario`) ,
  CONSTRAINT `fk_HorasExtra_Usuarios1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `mydb`.`Usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
