/*
Navicat MySQL Data Transfer

Source Server         : hlj
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-08-19 18:30:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '1',
  `status` int(11) DEFAULT '1',
  `deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1295741123079266310 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '梅西2', '18', '2020-08-19 11:54:06', '2020-08-19 12:08:22', '2', '1', '1');
INSERT INTO `user` VALUES ('2', '孙悟空', '5', '2020-08-19 12:04:26', '2020-08-19 12:04:26', '1', '0', '0');
