CREATE TABLE `violation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  `date` date NOT NULL ,
  `title` varchar(255) NOT NULL DEFAULT '',
  `owner_name` varchar(255) NOT NULL DEFAULT '',
  `owner_id` int(11) unsigned NOT NULL,
  `severity_rate` int(11) unsigned NOT NULL,
  `image_url` varchar(255),
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;