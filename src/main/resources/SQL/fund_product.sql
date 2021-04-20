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

 Date: 18/04/2021 13:04:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fund_product
-- ----------------------------
DROP TABLE IF EXISTS `fund_product`;
CREATE TABLE `fund_product`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '基金理财产品  主键id',
  `type` int(10) NULL DEFAULT NULL COMMENT '基金类型(1:股票型基金  2:债券型基金  3:货币型基金  4:混合型基金)',
  `code` int(10) NULL DEFAULT NULL COMMENT '基金代码',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金简称',
  `dailyGrowth` decimal(10, 8) NULL DEFAULT NULL COMMENT '日增长率',
  `monthlyGrowth` decimal(20, 8) NULL DEFAULT NULL COMMENT '月增长率',
  `annualGrowth` decimal(20, 8) NULL DEFAULT NULL COMMENT '年增长率',
  `leastMoney` decimal(20, 2) NULL DEFAULT NULL COMMENT '起投金额',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `risLevel` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风险级别',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理人',
  `instruction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fund_product
-- ----------------------------
INSERT INTO `fund_product` VALUES (4, 1, 518752, '招商中证薄酒', 0.10000000, 0.30000000, 1.00000000, 1000.00, '3年', '3', NULL, NULL, NULL, NULL);
INSERT INTO `fund_product` VALUES (10, NULL, 77777711, '77711', NULL, NULL, 7711.00000000, NULL, NULL, '2', '777', '777', '777', NULL);

SET FOREIGN_KEY_CHECKS = 1;
