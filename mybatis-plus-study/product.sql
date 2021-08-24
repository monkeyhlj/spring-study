/*
Navicat MySQL Data Transfer

Source Server         : hlj
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-08-19 18:30:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `user_id` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '10', '手机', '1');
INSERT INTO `product` VALUES ('2', '1', '2', '电脑', '1');
INSERT INTO `product` VALUES ('3', '2', '4', '电视机', '2');
