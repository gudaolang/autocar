CREATE TABLE `user` (
  `uuid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;