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

 Date: 18/04/2021 13:06:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for term_financial
-- ----------------------------
DROP TABLE IF EXISTS `term_financial`;
CREATE TABLE `term_financial`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '期限理财产品 主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资期限',
  `leastMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '起投金额',
  `profit` int(10) NULL DEFAULT NULL COMMENT '收益方式(1:收益型  2:净值型)',
  `annualIncome` decimal(30, 8) NULL DEFAULT NULL COMMENT '七日年化收益率',
  `risLevel` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风险级别',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经理人',
  `instruction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of term_financial
-- ----------------------------
INSERT INTO `term_financial` VALUES (4, '期限理财3', '33年', 2.00, 1, 302.00000000, '3', NULL, NULL, NULL, NULL);
INSERT INTO `term_financial` VALUES (6, '期限理财5', '岁时', 10.00, 2, 0.40000000, '1', NULL, NULL, NULL, NULL);
INSERT INTO `term_financial` VALUES (7, '地方大师傅', NULL, 1.00, NULL, NULL, '2', '二娃', '二五', '如果人员为因为', '飞飞飞');
INSERT INTO `term_financial` VALUES (8, '4513', NULL, 1.00, NULL, NULL, '1', '351', '1223', '给我人体红外日本', '451');

SET FOREIGN_KEY_CHECKS = 1;
