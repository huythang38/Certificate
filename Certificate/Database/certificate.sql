SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `certificate` ;
CREATE SCHEMA IF NOT EXISTS `certificate` DEFAULT CHARACTER SET utf8 ;
USE `certificate` ;

-- -----------------------------------------------------
-- Table `certificate`.`accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`accounts` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`accounts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(100) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `status` INT(11) NOT NULL ,
  `role` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`tuitions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`tuitions` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`tuitions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `payment` FLOAT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = big5;


-- -----------------------------------------------------
-- Table `certificate`.`candidates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`candidates` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`candidates` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `tuitions_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_tuitions_id_idx` (`tuitions_id` ASC) ,
  CONSTRAINT `fk_tuitions_id`
    FOREIGN KEY (`tuitions_id` )
    REFERENCES `certificate`.`tuitions` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`courses` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`courses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`class` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`class` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `size` INT(11) NULL DEFAULT NULL ,
  `courses_id` INT(11) NOT NULL ,
  `year` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_class_courses1_idx` (`courses_id` ASC) ,
  CONSTRAINT `fk_class_courses1`
    FOREIGN KEY (`courses_id` )
    REFERENCES `certificate`.`courses` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`students`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`students` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`students` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `address` VARCHAR(100) NOT NULL ,
  `birthday` DATE NOT NULL ,
  `gender` INT(11) NOT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  `phone_number` INT(11) NULL DEFAULT NULL ,
  `candidates_id` INT(11) NOT NULL ,
  `class_id` INT(11) NULL ,
  `accounts_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `accounts_id_idx` (`accounts_id` ASC) ,
  INDEX `candidates_id_idx` (`candidates_id` ASC) ,
  INDEX `fk_students_class1_idx` (`class_id` ASC) ,
  CONSTRAINT `accounts_id`
    FOREIGN KEY (`accounts_id` )
    REFERENCES `certificate`.`accounts` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `candidates_id`
    FOREIGN KEY (`candidates_id` )
    REFERENCES `certificate`.`candidates` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_students_class1`
    FOREIGN KEY (`class_id` )
    REFERENCES `certificate`.`class` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`certificates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`certificates` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`certificates` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `score` INT(11) NOT NULL ,
  `classified` VARCHAR(50) NOT NULL ,
  `students_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_certificates_students1_idx` (`students_id` ASC) ,
  CONSTRAINT `fk_certificates_students1`
    FOREIGN KEY (`students_id` )
    REFERENCES `certificate`.`students` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`payments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`payments` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`payments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `paid` FLOAT NULL DEFAULT NULL ,
  `students_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_tuitions_students1_idx` (`students_id` ASC) ,
  CONSTRAINT `fk_tuitions_students1`
    FOREIGN KEY (`students_id` )
    REFERENCES `certificate`.`students` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`subjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`subjects` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`subjects` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `courses_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `courses_id_idx` (`courses_id` ASC) ,
  CONSTRAINT `courses_id`
    FOREIGN KEY (`courses_id` )
    REFERENCES `certificate`.`courses` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `certificate`.`records`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certificate`.`records` ;

CREATE  TABLE IF NOT EXISTS `certificate`.`records` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `mark` INT(11) NOT NULL ,
  `subjects_id` INT(11) NOT NULL ,
  `students_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_records_subjects_idx` (`subjects_id` ASC) ,
  INDEX `fk_records_students1_idx` (`students_id` ASC) ,
  CONSTRAINT `fk_records_subjects`
    FOREIGN KEY (`subjects_id` )
    REFERENCES `certificate`.`subjects` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_records_students1`
    FOREIGN KEY (`students_id` )
    REFERENCES `certificate`.`students` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
