USE `hib_test`;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` INT(11) AUTO_INCREMENT,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `person` (`fname`) VALUES ('Anders And');
INSERT INTO `person` (`fname`) VALUES ('Mickey Mouse');
INSERT INTO `person` (`fname`) VALUES ('Fedtmule');