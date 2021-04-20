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

 Date: 18/04/2021 13:05:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '推荐消息id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '推荐人',
  `userId` int(11) NULL DEFAULT NULL COMMENT '被推荐人',
  `createTime` date NULL DEFAULT NULL COMMENT '新闻发布时间',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `status` int(1) NULL DEFAULT NULL COMMENT '1:已推 0:未推',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (3, 2, 1, '2021-04-12', '产品是', 0, NULL);
INSERT INTO `news` VALUES (4, 2, 1, '2021-04-12', '产品是从', 0, NULL);
INSERT INTO `news` VALUES (5, 2, 26, '2021-04-12', '零钱理财', 0, '<h1>请输入推荐理由</h1>');
INSERT INTO `news` VALUES (6, 2, 1, '2021-04-15', '诺安', 0, '<h1>FGADRFGADHADHADZ</h1>');
INSERT INTO `news` VALUES (7, 2, 1, '2021-04-15', '诺安', 0, '');

SET FOREIGN_KEY_CHECKS = 1;
