/*
 Navicat Premium Data Transfer

 Source Server         : yuncang
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : 12.168.3.75:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 18/04/2021 13:03:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bankcard
-- ----------------------------
DROP TABLE IF EXISTS `bankcard`;
CREATE TABLE `bankcard`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号 主键自增',
  `cardBank` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡所属银行',
  `type` int(10) NULL DEFAULT NULL COMMENT '银行卡类型（1：借记卡  2：信用卡）',
  `cardNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `userId` int(10) NULL DEFAULT NULL COMMENT '银行卡所属用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bankcard
-- ----------------------------
INSERT INTO `bankcard` VALUES (8, '农业银行', 1, '6216610200016587010', 17);
INSERT INTO `bankcard` VALUES (9, '农业银行', 2, '6216610200016587010', 18);

SET FOREIGN_KEY_CHECKS = 1;
