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

 Date: 18/04/2021 13:09:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_term_financial
-- ----------------------------
DROP TABLE IF EXISTS `user_term_financial`;
CREATE TABLE `user_term_financial`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-期限理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `termId` int(10) NULL DEFAULT NULL COMMENT '期限理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(20, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_term_financial
-- ----------------------------
INSERT INTO `user_term_financial` VALUES (9, 18, 4, '2021-04-11', 302.00000000, 6342000.00, 1);

SET FOREIGN_KEY_CHECKS = 1;
