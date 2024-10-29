-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema n.m
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `n.m` DEFAULT CHARACTER SET utf8mb3 ;
USE `n.m` ;


-- -----------------------------------------------------
-- Table `n.m`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `n.m`.`players` (
  `idplayer` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idplayer`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `n.m`.`trophies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `n.m`.`trophies` (
  `idtrophie` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`idtrophie`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `n.m`.`players_has_trophies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `n.m`.`players_has_trophies` (
  `players_idplayer` INT NOT NULL,
  `trophies_idtrophie` INT NOT NULL,
  PRIMARY KEY (`players_idplayer`, `trophies_idtrophie`),
  INDEX `fk_players_has_trophies_trophies1_idx` (`trophies_idtrophie` ASC) VISIBLE,
  INDEX `fk_players_has_trophies_players_idx` (`players_idplayer` ASC) VISIBLE,
  CONSTRAINT `fk_players_has_trophies_players`
    FOREIGN KEY (`players_idplayer`)
    REFERENCES `n.m`.`players` (`idplayer`),
  CONSTRAINT `fk_players_has_trophies_trophies1`
    FOREIGN KEY (`trophies_idtrophie`)
    REFERENCES `n.m`.`trophies` (`idtrophie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
