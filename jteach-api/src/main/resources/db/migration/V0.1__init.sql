## CREATE SCHEMA `open_api` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) NOT NULL COMMENT '用户账号',
  `nickName` varchar(32) NOT NULL COMMENT '用户昵称',
  `mobile` varchar(11)  NULL COMMENT '手机号',
  `uuid` varchar(22) NOT NULL COMMENT 'uuid',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码HASH',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL COMMENT '用户id',
  `token` VARCHAR(64) NULL COMMENT '登录token',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT '登录token';

