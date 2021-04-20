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

 Date: 18/04/2021 13:03:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for change_money
-- ----------------------------
DROP TABLE IF EXISTS `change_money`;
CREATE TABLE `change_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '零钱理财产品 主键id',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理财产品名称',
  `annualIncome` decimal(10, 8) NULL DEFAULT NULL COMMENT '七日年化收益率',
  `peiIncome` decimal(10, 2) NULL DEFAULT NULL COMMENT '每万元收益',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `invesMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '起投金额',
  `risLevel` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风险级别',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理人',
  `instruction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of change_money
-- ----------------------------
INSERT INTO `change_money` VALUES (17, '诺安', 0.30000000, NULL, NULL, NULL, '3', '半导体', '菜', '半导体', '999999');
INSERT INTO `change_money` VALUES (19, '煤炭综合', 30.00000000, NULL, NULL, NULL, '1', '煤炭', '膏体', '半导体啊实打实大自产自销全文231231', '988774');

-- ----------------------------
-- Table structure for user_change_money
-- ----------------------------
DROP TABLE IF EXISTS `user_change_money`;
CREATE TABLE `user_change_money`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-零钱理财 投资表id 主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `changeId` int(10) NULL DEFAULT NULL COMMENT '零钱理财产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_change_money
-- ----------------------------
INSERT INTO `user_change_money` VALUES (23, 17, 12, '2021-04-11', 10.00000000, 1000.00, 1);
INSERT INTO `user_change_money` VALUES (25, 18, 12, '2021-04-11', 10.00000000, 1000.00, 1);
INSERT INTO `user_change_money` VALUES (26, 1, 12, '2021-04-11', 10.00000000, 1000.00, 1);
INSERT INTO `user_change_money` VALUES (27, 17, 13, '2021-04-12', 10.00000000, 1000.00, 1);
INSERT INTO `user_change_money` VALUES (28, 26, 12, NULL, NULL, NULL, NULL);
INSERT INTO `user_change_money` VALUES (29, 1, 17, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
