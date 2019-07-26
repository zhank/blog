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

DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_article` (
  `article_id` varchar(32) NOT NULL,
  `article_title` varchar(100) NOT NULL,
  `article_userId` varchar(50) ,
  `reading_num` int,
  `like_num` int ,
   `collect_num` int ,
   `article_content` varchar(1000) ,
   `keywordIds` varchar(200) ,
  `article_create` timestamp ,
  `article_update` timestamp ,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tb_keyword`;
CREATE TABLE `tb_keyword` (
  `keyword_id` varchar(32) NOT NULL,
  `keyword_name` varchar(100) NOT NULL,
  `keyword_date` timestamp ,
  `keyword_userId` varchar(32),
  PRIMARY KEY (`keyword_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;