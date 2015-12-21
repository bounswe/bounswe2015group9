CREATE TABLE `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `violation_tag` (
  `tag_id` INT NOT NULL,
  `violation_id` INT NOT NULL,
  PRIMARY KEY (`tag_id`,`violation_id`),
  KEY fk_tag (tag_id),
  KEY fk_violation (violation_id),
  CONSTRAINT `fk_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `fk_violation` FOREIGN KEY (`violation_id`) REFERENCES `violation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


