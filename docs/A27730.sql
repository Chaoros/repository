/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100413
 Source Host           : localhost:3306
 Source Schema         : a27730

 Target Server Type    : MySQL
 Target Server Version : 100413
 File Encoding         : 65001

 Date: 20/05/2023 13:59:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_commodity
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity`;
CREATE TABLE `tb_commodity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `repository` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库',
  `coding` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '货品编码',
  `category` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '货品类别',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '货品名称',
  `model` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `number` int(10) NULL DEFAULT NULL COMMENT '货品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_commodity
-- ----------------------------
INSERT INTO `tb_commodity` VALUES (7, '仓库1', '1001', '普通货物', '玩具', 'xxxx', '吨', 5);
INSERT INTO `tb_commodity` VALUES (8, '仓库1', '01552', '危险货物', '打火机', '电炉丝', '个', 98);

-- ----------------------------
-- Table structure for tb_repository
-- ----------------------------
DROP TABLE IF EXISTS `tb_repository`;
CREATE TABLE `tb_repository`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `commodity_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `number` int(10) NULL DEFAULT NULL COMMENT '入库数量/出库数量',
  `repository_time` datetime(0) NULL DEFAULT NULL COMMENT '出库时间/入库时间',
  `type` int(1) NULL DEFAULT NULL COMMENT '0出库；1入库',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `tb_repository_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `tb_commodity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_repository_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '入库/出库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_repository
-- ----------------------------
INSERT INTO `tb_repository` VALUES (13, 7, 100, '2023-05-20 13:55:08', 1, 1);
INSERT INTO `tb_repository` VALUES (14, 7, 200, '2023-05-20 13:55:20', 0, 1);
INSERT INTO `tb_repository` VALUES (15, 7, 5, '2023-05-20 13:57:10', 1, 1);
INSERT INTO `tb_repository` VALUES (16, 8, 2, '2023-05-20 13:58:17', 0, 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱号码',
  `type` int(1) NULL DEFAULT NULL COMMENT '用户类型：1管理员；0普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '123456', '123456@qq.com', 1);
INSERT INTO `tb_user` VALUES (3, 'user', '123456', '123456@qq.com', 0);

-- ----------------------------
-- Table structure for tb_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse`;
CREATE TABLE `tb_warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_warehouse
-- ----------------------------
INSERT INTO `tb_warehouse` VALUES (1, '仓库1', '仓库1');

SET FOREIGN_KEY_CHECKS = 1;
