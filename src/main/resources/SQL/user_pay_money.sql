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

 Date: 18/04/2021 13:07:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_pay_money
-- ----------------------------
DROP TABLE IF EXISTS `user_pay_money`;
CREATE TABLE `user_pay_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-工资理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `payId` int(10) NULL DEFAULT NULL COMMENT '工资理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_pay_money
-- ----------------------------
INSERT INTO `user_pay_money` VALUES (15, 18, 7, '2021-04-11', 0.03123000, 312.30, 1);
INSERT INTO `user_pay_money` VALUES (16, 17, 8, '2021-04-12', 0.03123000, 93.69, 1);
INSERT INTO `user_pay_money` VALUES (17, 3, 10, '2021-04-16', 0.03123000, 3.15, 1);

SET FOREIGN_KEY_CHECKS = 1;
