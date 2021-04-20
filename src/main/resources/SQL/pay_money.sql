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

 Date: 18/04/2021 13:06:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pay_money
-- ----------------------------
DROP TABLE IF EXISTS `pay_money`;
CREATE TABLE `pay_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '工资理财 主键id',
  `monthMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '每月金额设定',
  `autoInto` int(10) NULL DEFAULT NULL COMMENT '1:每月自动转入   2：每月不自动转入',
  `type` int(10) NULL DEFAULT NULL COMMENT '产品类型（1：国债  2：期货）',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `risLevel` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风险级别',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理人',
  `instruction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pay_money
-- ----------------------------
INSERT INTO `pay_money` VALUES (10, 101.00, NULL, NULL, NULL, '3', '白酒12', '许嵩21', '白酒行业22', 'vfvsad', '223431');

SET FOREIGN_KEY_CHECKS = 1;
