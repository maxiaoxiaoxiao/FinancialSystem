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

 Date: 18/04/2021 13:08:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `admin_id` int(11) NOT NULL COMMENT '评论人id',
  `type` int(1) NOT NULL COMMENT '1-基金 2-零钱 3-工资 4-期限',
  `relaId` int(11) NOT NULL COMMENT '产品的id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `idx_relaId`(`relaId`) USING BTREE,
  INDEX `idx_admin_id`(`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (27, '不错', 1, 2, 12, '2021-04-11 15:10:30', '2021-04-11 15:10:30');
INSERT INTO `comment` VALUES (28, 'good', 1, 3, 7, '2021-04-11 15:11:37', '2021-04-11 15:11:37');
INSERT INTO `comment` VALUES (29, '期限理财3不错', 1, 4, 4, '2021-04-11 15:13:48', '2021-04-11 15:13:48');
INSERT INTO `comment` VALUES (30, '招商中证白酒真的好', 1, 1, 4, '2021-04-11 15:16:48', '2021-04-11 15:16:48');
INSERT INTO `comment` VALUES (31, '这个理财产品不错哦', 1, 2, 14, '2021-04-11 17:14:52', '2021-04-11 17:14:52');
INSERT INTO `comment` VALUES (32, '工资理财这个还不错', 1, 3, 9, '2021-04-11 17:15:24', '2021-04-11 17:15:24');
INSERT INTO `comment` VALUES (33, '秒啊', 1, 4, 6, '2021-04-11 17:16:02', '2021-04-11 17:16:02');
INSERT INTO `comment` VALUES (34, '易方达蓝筹，YYDS', 1, 1, 6, '2021-04-11 17:16:54', '2021-04-11 17:16:54');
INSERT INTO `comment` VALUES (35, 'h tyu4 t', 2, 2, 12, '2021-04-12 16:19:23', '2021-04-12 16:19:23');
INSERT INTO `comment` VALUES (36, '发黑发黄我i附件我凭感觉婉容故居欧日我【ir【 为人情味【欸让他去【我【ig问题【怕', 1, 2, 18, '2021-04-15 20:49:54', '2021-04-15 20:49:54');
INSERT INTO `comment` VALUES (37, '润帝国埃尔也爱他哈人', 1, 3, 13, '2021-04-15 21:04:41', '2021-04-15 21:04:41');
INSERT INTO `comment` VALUES (38, '法国侮辱人格侮辱', 1, 4, 9, '2021-04-15 21:25:00', '2021-04-15 21:25:00');
INSERT INTO `comment` VALUES (39, 'DGARDGADFG', 1, 1, 9, '2021-04-15 21:30:01', '2021-04-15 21:30:01');
INSERT INTO `comment` VALUES (40, '发噶地方噶的', 2, 2, 17, '2021-04-15 21:32:38', '2021-04-15 21:32:38');
INSERT INTO `comment` VALUES (41, 'dgrdrw5 y4ywh', 2, 3, 10, '2021-04-15 21:36:37', '2021-04-15 21:36:37');
INSERT INTO `comment` VALUES (42, 'h tyu4 t', 2, 1, 9, '2021-04-15 21:37:40', '2021-04-15 21:37:40');
INSERT INTO `comment` VALUES (43, '12312321', 1, 2, 19, '2021-04-16 22:25:34', '2021-04-16 22:25:34');

SET FOREIGN_KEY_CHECKS = 1;
