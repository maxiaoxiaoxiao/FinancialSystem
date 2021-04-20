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

 Date: 18/04/2021 13:04:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flow_of_funds
-- ----------------------------
DROP TABLE IF EXISTS `flow_of_funds`;
CREATE TABLE `flow_of_funds`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '资金记录表 id主键自增',
  `userId` int(10) NULL DEFAULT NULL COMMENT '所属用户',
  `flowMoney` decimal(20, 2) NULL DEFAULT NULL COMMENT '金额',
  `type` int(10) NULL DEFAULT NULL COMMENT '类型（1：支出  2：收入 3：投资）',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `createTime` date NULL DEFAULT NULL COMMENT '创建时间',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of flow_of_funds
-- ----------------------------
INSERT INTO `flow_of_funds` VALUES (29, 17, 12.00, 1, '干啥来着', '2021-04-11', '招商中证薄酒');
INSERT INTO `flow_of_funds` VALUES (30, 17, 10.00, 3, '干啥来着', '2021-04-11', '招商中证薄酒');
INSERT INTO `flow_of_funds` VALUES (31, 18, 100.00, 1, '工资', '2021-04-11', '工资收入');
INSERT INTO `flow_of_funds` VALUES (32, 18, 50.00, 2, '买菜', '2021-04-11', '买菜花了50');

SET FOREIGN_KEY_CHECKS = 1;
