/*
 Navicat Premium Data Transfer

 Source Server         : svn
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : 127.0.0.1:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 22/04/2019 15:02:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `region_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `phone_number` char(11) CHARACTER SET utf8 DEFAULT NULL,
  `nick_name` varchar(50) CHARACTER SET utf8 DEFAULT '匿名',
  `sex` int(11) DEFAULT NULL,
  `headimg_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
