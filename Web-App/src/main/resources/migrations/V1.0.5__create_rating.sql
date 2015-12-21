CREATE TABLE `rating` (
  `user_id` int(11) unsigned NOT NULL,
  `violation_id` int(11) unsigned NOT NULL,
  `score` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`,`violation_id`),
  KEY `FK_VIOLATION_USER` (`user_id`),
  CONSTRAINT `FK_RATING_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RATING_VIOLATION` FOREIGN KEY (`violation_id`) REFERENCES `violation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;