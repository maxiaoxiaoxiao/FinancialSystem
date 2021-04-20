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

 Date: 18/04/2021 13:07:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_fund_product
-- ----------------------------
DROP TABLE IF EXISTS `user_fund_product`;
CREATE TABLE `user_fund_product`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-基金理财 投资表id 主键 自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `fundId` int(10) NULL DEFAULT NULL COMMENT '基金产品id',
  `startTime` date NULL DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10, 8) NULL DEFAULT NULL COMMENT '平均投资率',
  `profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '收益',
  `status` int(10) NULL DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_fund_product
-- ----------------------------
INSERT INTO `user_fund_product` VALUES (8, 18, 4, '2021-04-11', 0.30000000, 300.00, 1);
INSERT INTO `user_fund_product` VALUES (9, 17, 6, '2021-04-12', 3.00000000, 150.00, 1);
INSERT INTO `user_fund_product` VALUES (10, 17, 5, '2021-04-12', 0.03000000, 90.00, 1);
INSERT INTO `user_fund_product` VALUES (11, 17, 4, '2021-04-12', 0.30000000, 300.00, 1);

SET FOREIGN_KEY_CHECKS = 1;
