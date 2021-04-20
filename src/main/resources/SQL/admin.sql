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

 Date: 18/04/2021 13:01:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员账户  主键id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员用户名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `status` int(10) NULL DEFAULT NULL COMMENT '登录状态（0：离线   1：在线）',
  `type` int(1) NOT NULL COMMENT '类型 0：管理员 1：投资顾问',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 0, 0);
INSERT INTO `admin` VALUES (2, 'test1', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (7, '管理员1', 'e10adc3949ba59abbe56e057f20f883e', 1, 0);
INSERT INTO `admin` VALUES (8, '管理员222', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (9, '管理员333', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (11, '的测试得出', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (12, '做好准备', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (13, '走开', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (15, '秦润东', 'e10adc3949ba59abbe56e057f20f883e', 1, 1);
INSERT INTO `admin` VALUES (17, 'UJU', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);
INSERT INTO `admin` VALUES (19, '投资顾问', 'e10adc3949ba59abbe56e057f20f883e', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
