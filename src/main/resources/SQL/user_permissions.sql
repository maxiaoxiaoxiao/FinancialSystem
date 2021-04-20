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

 Date: 18/04/2021 13:08:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `user_permissions`;
CREATE TABLE `user_permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户权限中间表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `permissionId` int(10) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_permissions
-- ----------------------------
INSERT INTO `user_permissions` VALUES (87, 1, 1);
INSERT INTO `user_permissions` VALUES (88, 1, 2);
INSERT INTO `user_permissions` VALUES (89, 1, 3);
INSERT INTO `user_permissions` VALUES (90, 1, 4);
INSERT INTO `user_permissions` VALUES (91, 1, 5);
INSERT INTO `user_permissions` VALUES (92, 1, 6);
INSERT INTO `user_permissions` VALUES (93, 1, 7);
INSERT INTO `user_permissions` VALUES (94, 1, 9);
INSERT INTO `user_permissions` VALUES (95, 1, 8);

SET FOREIGN_KEY_CHECKS = 1;
