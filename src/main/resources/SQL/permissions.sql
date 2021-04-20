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

 Date: 18/04/2021 13:06:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限id 主键自增',
  `permission` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, 'user:finance');
INSERT INTO `permissions` VALUES (2, 'user:changeMoney');
INSERT INTO `permissions` VALUES (3, 'user:payMoney');
INSERT INTO `permissions` VALUES (4, 'user:termFinancial');
INSERT INTO `permissions` VALUES (5, 'user:fundProduct');
INSERT INTO `permissions` VALUES (6, 'user:bank');
INSERT INTO `permissions` VALUES (7, 'user:tools');
INSERT INTO `permissions` VALUES (8, 'user:loan');
INSERT INTO `permissions` VALUES (9, 'user:record');
INSERT INTO `permissions` VALUES (10, 'admin:userInfo');
INSERT INTO `permissions` VALUES (11, 'admin:bankCard');
INSERT INTO `permissions` VALUES (12, 'admin:reputation');
INSERT INTO `permissions` VALUES (13, 'admin:userInfoElse');
INSERT INTO `permissions` VALUES (14, 'admin:finance');
INSERT INTO `permissions` VALUES (15, 'admin:changeMoney');
INSERT INTO `permissions` VALUES (16, 'admin:payMoney');
INSERT INTO `permissions` VALUES (17, 'admin:termFinancial');
INSERT INTO `permissions` VALUES (18, 'admin:fundProduct');
INSERT INTO `permissions` VALUES (19, 'admin:bank');
INSERT INTO `permissions` VALUES (20, 'admin:permission');
INSERT INTO `permissions` VALUES (21, 'admin:userPermissions');
INSERT INTO `permissions` VALUES (22, 'admin:adminPermissions');
INSERT INTO `permissions` VALUES (23, 'admin:loan');
INSERT INTO `permissions` VALUES (24, 'admin:loanExam');
INSERT INTO `permissions` VALUES (25, 'admin:loanInfo');

SET FOREIGN_KEY_CHECKS = 1;
