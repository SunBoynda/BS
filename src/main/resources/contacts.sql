/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : contacts

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 26/10/2022 19:05:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(255) NULL DEFAULT NULL COMMENT '0男 ，1女',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 162 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES (157, '喜羊羊', '西南石油大学', '1515151', 1);
INSERT INTO `people` VALUES (158, '美羊羊', '成都理工', '151515123131', 1);
INSERT INTO `people` VALUES (160, '兰华伟', '四川职业技术学院', '1415151515', 1);
INSERT INTO `people` VALUES (161, '刘向川', '电子科技大学', '1415151515大萨达', 0);

SET FOREIGN_KEY_CHECKS = 1;
