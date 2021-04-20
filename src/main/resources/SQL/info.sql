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

 Date: 18/04/2021 13:05:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '消息编号 主键自增',
  `sendId` int(10) NULL DEFAULT NULL COMMENT '消息发送者id（admin）',
  `receiveId` int(10) NULL DEFAULT NULL COMMENT '消息接收者id（user）',
  `createTime` date NULL DEFAULT NULL COMMENT '消息创建时间',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `infoDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `status` int(10) NULL DEFAULT NULL COMMENT '消息状态（0：未读  1：已读）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (9, 1, 17, '2021-04-11', '网贷审核通过', '用户test的3000.00元网贷申请审核通过！审核人为：admin', 0);

SET FOREIGN_KEY_CHECKS = 1;
