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

 Date: 18/04/2021 13:05:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '网贷信息表id 主键自增',
  `loanId` int(10) NULL DEFAULT NULL COMMENT '借贷人id（用户）',
  `examineId` int(10) NULL DEFAULT NULL COMMENT '审核人id（管理员）',
  `loanTime` date NULL DEFAULT NULL COMMENT '借贷时间',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '借贷金额',
  `term` int(20) NULL DEFAULT NULL COMMENT '借贷期限（天）',
  `rate` decimal(10, 8) NULL DEFAULT NULL COMMENT '固定年借贷利率',
  `applyStatus` int(10) NULL DEFAULT NULL COMMENT '申请状态（0：未审核  1：审核未通过  2：审核通过）',
  `loanStatus` int(10) NULL DEFAULT NULL COMMENT '借贷状态（0：未逾期  1：逾期  2：已还请）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of loan
-- ----------------------------
INSERT INTO `loan` VALUES (7, 17, 1, '2021-04-11', 3000.00, 30, 0.28450000, 2, 0);

SET FOREIGN_KEY_CHECKS = 1;
