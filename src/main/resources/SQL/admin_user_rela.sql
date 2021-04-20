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

 Date: 19/04/2021 14:16:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user_rela
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_rela`;
CREATE TABLE `admin_user_rela`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `adminId` int(11) NOT NULL COMMENT '投资顾问id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投资顾问和用户关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_user_rela
-- ----------------------------
INSERT INTO `admin_user_rela` VALUES (1, 2, 1, '2021-04-11 20:21:19');
INSERT INTO `admin_user_rela` VALUES (8, 2, 26, '2021-04-12 16:17:41');
INSERT INTO `admin_user_rela` VALUES (9, 9, 27, '2021-04-12 21:01:39');
INSERT INTO `admin_user_rela` VALUES (10, 13, 28, '2021-04-13 14:41:09');
INSERT INTO `admin_user_rela` VALUES (11, 2, 29, '2021-04-13 14:48:18');
INSERT INTO `admin_user_rela` VALUES (13, 2, 31, '2021-04-15 21:32:16');
INSERT INTO `admin_user_rela` VALUES (14, 12, 32, '2021-04-16 22:24:15');
INSERT INTO `admin_user_rela` VALUES (15, 20, 33, '2021-04-18 21:11:44');
INSERT INTO `admin_user_rela` VALUES (16, 20, 34, '2021-04-18 21:15:28');
INSERT INTO `admin_user_rela` VALUES (17, 2, 35, '2021-04-18 22:14:05');
INSERT INTO `admin_user_rela` VALUES (18, 2, 36, '2021-04-18 22:15:30');
INSERT INTO `admin_user_rela` VALUES (19, 2, 37, '2021-04-18 22:21:31');

SET FOREIGN_KEY_CHECKS = 1;
