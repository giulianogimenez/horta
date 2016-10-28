CREATE SCHEMA `horta` ;

CREATE TABLE `horta`.`usu_usuario` (
  `usu_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `usu_nome` VARCHAR(255) NULL,
  `usu_email` VARCHAR(255) NULL,
  `usu_senha` VARCHAR(100) NULL,
  PRIMARY KEY (`usu_id`));

CREATE TABLE `horta`.`prj_projeto` (
  `prj_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `prj_nome` VARCHAR(300) NULL,
  `usu_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`prj_id`),
  INDEX `PRJ_USU_FK_idx` (`usu_id` ASC),
  CONSTRAINT `PRJ_USU_FK`
    FOREIGN KEY (`usu_id`)
    REFERENCES `horta`.`usu_usuario` (`usu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `horta`.`pln_planta` (
  `pln_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `pln_nome` VARCHAR(500) NULL,
  `pln_fotopath` VARCHAR(200) NULL,
  `pln_iluminacao` MEDIUMTEXT NULL,
  `pln_irrigacao` LONGTEXT NULL,
  `pln_dica` LONGTEXT NULL,
  PRIMARY KEY (`pln_id`));

CREATE TABLE `horta`.`ppr_plantasprojeto` (
  `ppr_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `prj_id` BIGINT(10) NULL,
  `pln_id` BIGINT(10) NULL,
  PRIMARY KEY (`ppr_id`),
  INDEX `PPR_PLN_FK_idx` (`pln_id` ASC),
  INDEX `PPR_PRJ_FK_idx` (`prj_id` ASC),
  CONSTRAINT `PPR_PLN_FK`
    FOREIGN KEY (`pln_id`)
    REFERENCES `horta`.`pln_planta` (`pln_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PPR_PRJ_FK`
    FOREIGN KEY (`prj_id`)
    REFERENCES `horta`.`prj_projeto` (`prj_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `horta`.`pln_planta` (`pln_nome`, `pln_fotopath`, `pln_iluminacao`, `pln_irrigacao`, `pln_dica`) VALUES ('Manjericão (Ocimum basilicum)', 'manj.jpg', 'O manjericão necessita de alta luminosidade e deve receber luz solar direta ao menos por algumas horas diariamente.', 'Irrigue com frequência para que o solo seja mantido levemente úmido. Tanto a falta quanto o excesso de água prejudicam o manjericão.', 'O manjericão pode ser cultivado facilmente em jardineiras e vasos de tamanho médio ou grande, embora geralmente cresça menos. No solo e em boas condições de cultivo, alguns cultivares de manjericão podem ultrapassar a 1 metro de altura. Assim, para plantio em vasos e jardineiras, dê preferência a cultivares de menor porte, ainda que seja possível plantar qualquer um dos cultivares disponíveis.');
INSERT INTO `horta`.`pln_planta` (`pln_nome`, `pln_fotopath`, `pln_iluminacao`, `pln_irrigacao`, `pln_dica`) VALUES ('Alecrim (Rosmarinus officinalis)', 'alecrim.jpg', 'O alecrim deve receber luz solar direta ao menos por algumas horas diariamente.', 'Irrigue com frequência para que o solo seja mantido levemente úmido enquanto as plantas são jovens. Quando as plantas estiverem bem desenvolvidas, a irrigação deve ser esparsa, permitindo que o solo seque levemente entre as irrigações. O alecrim é bastante resistente a períodos de seca.', 'Retire plantas invasoras que estejam concorrendo por nutrientes e recursos.');
INSERT INTO `horta`.`pln_planta` (`pln_nome`, `pln_fotopath`, `pln_iluminacao`, `pln_irrigacao`, `pln_dica`) VALUES ('Cebolinha verde (Allium fistulosum)', 'cebolinha.jpg', 'A cebolinha verde necessita de luz solar direta ao menos por algumas horas diariamente.', 'Irrigue com frequência para que o solo seja mantido úmido, mas sem que fique encharcado. A planta adulta é relativamente resistente a curtos períodos de seca.', 'Alguns cultivares de cebolinha verde se propagam vegetativamente menos frequentemente, e portanto não são adequados para o método de plantio por divisão.');
INSERT INTO `horta`.`pln_planta` (`pln_nome`, `pln_fotopath`, `pln_iluminacao`, `pln_irrigacao`, `pln_dica`) VALUES ('Coentro (Coriandrum sativum)', 'coentro.jpg', 'O coentro pode ser cultivado em lugares ensolarados ou em sombra parcial. No entanto, plantas que crescem em pleno sol geralmente têm mais sabor e aroma que as cultivadas em sombra parcial.', 'Irrigue de forma a manter o solo sempre úmido quando a planta é jovem, sem que o solo permaneça encharcado. Quando a planta atingir um bom desenvolvimento, as regas devem ser mais espaçadas, permitindo que o solo seque ligeiramente entre uma rega e outra.', 'Retire plantas invasoras que estejam concorrendo por recursos e nutrientes.');
