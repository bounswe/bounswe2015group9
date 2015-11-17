CREATE TABLE `oauth_access_token`(
    token_id VARCHAR(255) NOT NULL,
    token BLOB NOT NULL,
    authentication_id VARCHAR(255) DEFAULT NULL,
    user_name VARCHAR(255) DEFAULT NULL,
    client_id VARCHAR(255) DEFAULT NULL,
    authentication BLOB,
    refresh_token VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (token_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_refresh_token` (
  token_id VARCHAR(255) NOT NULL,
  token BLOB NOT NULL,
  authentication BLOB,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;