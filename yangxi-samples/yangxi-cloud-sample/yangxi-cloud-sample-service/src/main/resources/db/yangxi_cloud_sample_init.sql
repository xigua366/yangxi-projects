/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : yangxi_boot_sample

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/04/2021 16:24:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_school
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                            `tenant_id` varchar(32) NOT NULL COMMENT '租户id',
                            `name` varchar(255) NOT NULL COMMENT '学校名称',
                            `address` varchar(255) NOT NULL COMMENT '学校地址',
                            `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_time` datetime NOT NULL COMMENT '修改时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_school
-- ----------------------------
BEGIN;
INSERT INTO `t_school` VALUES (1, 'abc', '广州一中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (2, 'abc', '广州二中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (3, 'abc', '广州三中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (4, 'abc', '广州四中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (5, 'abc', '广州五中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (6, 'abc', '广州六中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (7, 'abc', '广州七中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (8, 'abc', '广州八中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (9, 'abc', '广州九中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (10, 'abc', '广州十中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (11, 'abc', '广州十一中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (12, 'abc', '广州十二中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (13, 'abc', '广州十三中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (14, 'abc', '广州十四中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `tenant_id` varchar(32) NOT NULL COMMENT '租户id',
                             `school_id` bigint(20) NOT NULL COMMENT '学校ID',
                             `name` varchar(64) NOT NULL COMMENT '姓名',
                             `age` smallint(6) NOT NULL COMMENT '年龄',
                             `sex` tinyint(255) NOT NULL COMMENT '性别 1:男 2:女',
                             `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, 'abc', 1, '张三', 10, 1, 'test', '2021-02-27 19:13:30', '2021-02-27 19:13:32');
INSERT INTO `t_student` VALUES (3, 'abc', 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:24:28', '2021-03-03 05:24:28');
INSERT INTO `t_student` VALUES (4, 'abc', 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:45:42', '2021-03-03 05:45:42');
INSERT INTO `t_student` VALUES (5, 'abc', 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:57:46', '2021-03-03 05:57:46');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                          `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户ID',
                          `phone` varchar(255) NOT NULL COMMENT '手机号',
                          `pwd` varchar(64) NOT NULL COMMENT '密码',
                          `name` varchar(64) NOT NULL COMMENT '昵称',
                          `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
                          `slogan` varchar(255) DEFAULT NULL COMMENT '签名',
                          `sex` smallint(1) DEFAULT NULL COMMENT '性别',
                          `mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
                          `secret` varchar(255) DEFAULT NULL COMMENT '盐',
                          `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          `update_time` datetime NOT NULL COMMENT '更新时间',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `uk_phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, NULL, '13812345543', '$1$jTSk8DPo$6A.wgghBysRC.3EoY1H8C0', '韦小宝', NULL, NULL, NULL, NULL, '$1$jTSk8DPo', NULL, '2021-03-30 02:30:16', '2021-03-30 02:30:16');
INSERT INTO `t_user` VALUES (2, NULL, '13812345542', '$1$yHzRlDys$9WNYERee4dMczOtE06Xrj0', '韦大宝', NULL, NULL, NULL, NULL, '$1$yHzRlDys', NULL, '2021-04-01 03:10:19', '2021-04-01 03:10:19');
INSERT INTO `t_user` VALUES (5, 'abc', '13812345541', '$1$Ki7xKpqv$Ygb2Oiev3RVb59HO5LUST0', '韦中宝', NULL, NULL, NULL, NULL, '$1$Ki7xKpqv', NULL, '2021-04-01 03:23:21', '2021-04-01 03:23:21');
INSERT INTO `t_user` VALUES (6, NULL, '13812345540', '$1$yFT5SQ8k$wP540H3TiN/ExQ9S.SqFK.', '韦四宝', NULL, NULL, NULL, NULL, '$1$yFT5SQ8k', NULL, '2021-04-01 03:24:20', '2021-04-01 03:24:20');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
