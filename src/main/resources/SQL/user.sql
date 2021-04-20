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

 Date: 18/04/2021 13:07:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id 主键自增',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `IDcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `paypwd` int(40) NULL DEFAULT NULL COMMENT '交易密码',
  `status` int(10) NULL DEFAULT NULL COMMENT '用户状态（0：离线   1：在线）',
  `reputation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户信誉',
  `risLevel` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风险级别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lisi', '李四', 'e10adc3949ba59abbe56e057f20f883e', '110101199703142123', '15188888884', '1231234@qq.com', 123456, 1, '良好', '1');
INSERT INTO `user` VALUES (2, 'inmaps', '赵六', 'e10adc3949ba59abbe56e057f20f883e', '110101199608142123', '12345678912', '2333@233.com', 123456, 0, '超级优秀', '1');
INSERT INTO `user` VALUES (3, 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', '110101199703142123', '15188888888', '567567@qq.com', 123456, 1, '良好', '1');
INSERT INTO `user` VALUES (17, 'test', '测试', 'e10adc3949ba59abbe56e057f20f883e', NULL, '15168922759', '1334243466@qq.com', NULL, 1, '不错', '3');
INSERT INTO `user` VALUES (20, 'qwe', '全文', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', '1');
INSERT INTO `user` VALUES (21, '掂掂让他', '顺丰航空', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', '1');
INSERT INTO `user` VALUES (22, '上市时', '试试', 'e10adc3949ba59abbe56e057f20f883e', NULL, '15956657678', '', NULL, 0, '良好', '1');
INSERT INTO `user` VALUES (24, 'RGRE', '奥是', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', '1');
INSERT INTO `user` VALUES (26, '详情', '', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', '1');
INSERT INTO `user` VALUES (27, 'qinrundong', '秦润东', 'e10adc3949ba59abbe56e057f20f883e', NULL, '15168922759', '1334243466@qq.com', NULL, 0, '良好', NULL);
INSERT INTO `user` VALUES (28, 'GG', '中国妇女', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', NULL);
INSERT INTO `user` VALUES (29, 'YUE', '', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', NULL);
INSERT INTO `user` VALUES (31, 'FDFG', '方法', 'e10adc3949ba59abbe56e057f20f883e', NULL, '', '', NULL, 0, '良好', NULL);
INSERT INTO `user` VALUES (32, '王五', '王五', 'e10adc3949ba59abbe56e057f20f883e', NULL, '15168922759', '1334243466@qq.com', NULL, 0, '良好', NULL);

SET FOREIGN_KEY_CHECKS = 1;
