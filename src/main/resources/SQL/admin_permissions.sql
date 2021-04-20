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

 Date: 18/04/2021 13:01:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_permissions
-- ----------------------------
DROP TABLE IF EXISTS `admin_permissions`;
CREATE TABLE `admin_permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员权限表 主键自增',
  `adminId` int(10) NULL DEFAULT NULL COMMENT '管理员id',
  `permissionId` int(10) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_permissions
-- ----------------------------
INSERT INTO `admin_permissions` VALUES (95, 1, 10);
INSERT INTO `admin_permissions` VALUES (96, 1, 11);
INSERT INTO `admin_permissions` VALUES (97, 1, 12);
INSERT INTO `admin_permissions` VALUES (98, 1, 13);
INSERT INTO `admin_permissions` VALUES (99, 1, 14);
INSERT INTO `admin_permissions` VALUES (100, 1, 15);
INSERT INTO `admin_permissions` VALUES (101, 1, 16);
INSERT INTO `admin_permissions` VALUES (102, 1, 17);
INSERT INTO `admin_permissions` VALUES (103, 1, 18);
INSERT INTO `admin_permissions` VALUES (104, 1, 19);
INSERT INTO `admin_permissions` VALUES (105, 1, 20);
INSERT INTO `admin_permissions` VALUES (106, 1, 21);
INSERT INTO `admin_permissions` VALUES (107, 1, 22);
INSERT INTO `admin_permissions` VALUES (108, 1, 23);
INSERT INTO `admin_permissions` VALUES (109, 1, 24);
INSERT INTO `admin_permissions` VALUES (110, 1, 25);

SET FOREIGN_KEY_CHECKS = 1;
