DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `message_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `message_title` varchar(100) DEFAULT NULL,
  `message_author` varchar(20) DEFAULT NULL,
  `message_content` varchar(500) DEFAULT NULL,
  `message_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;