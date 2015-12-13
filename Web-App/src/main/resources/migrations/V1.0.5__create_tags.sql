CREATE TABLE `tag` (
  `name` varchar(255) NOT NULL,
  `violation_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`name`),
  KEY `FK_VIOLATION_TAG` (`violation_id`),
  CONSTRAINT `FK_VIOLATION_TAG` FOREIGN KEY (`violation_id`) REFERENCES `violation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
