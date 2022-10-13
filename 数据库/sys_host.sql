/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : vue

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 17/06/2022 09:30:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_host
-- ----------------------------
DROP TABLE IF EXISTS `sys_host`;
CREATE TABLE `sys_host`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hostname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主机名',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'IP',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主机密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 450535426 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_host
-- ----------------------------
INSERT INTO `sys_host` VALUES (1, 'h3m2201', '10.7.120.75', '从节点', '123456');
INSERT INTO `sys_host` VALUES (2, 'h3m2202', '10.7.120.116', '主节点', '123456');
INSERT INTO `sys_host` VALUES (3, 'h3m2203', '10.7.120.131', '从节点', '123456');
INSERT INTO `sys_host` VALUES (450535425, 'ghrhh', '10.7.120.45', '从节点', '124');

SET FOREIGN_KEY_CHECKS = 1;
