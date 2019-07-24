DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `message_id` varchar(32) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `msg_content` varchar(200) ,
  `user_ip` varchar(20),
  `head_url` varchar(60) ,
  `msg_date` timestamp ,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;