/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 11/05/2020 14:49:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_developer
-- ----------------------------
DROP TABLE IF EXISTS `app_developer`;
CREATE TABLE `app_developer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App秘钥',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `login_password` varchar(64) NOT NULL COMMENT '登录密码',
  `permission` tinyint(4) NOT NULL COMMENT '开发者权限（0:创建者 1:管理 2:普通）',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_environment
-- ----------------------------
DROP TABLE IF EXISTS `app_environment`;
CREATE TABLE `app_environment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT '应用密钥',
  `env_name` varchar(16) NOT NULL COMMENT '环境名称',
  `env_desc` varchar(128) DEFAULT NULL COMMENT '环境描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_milestone
-- ----------------------------
DROP TABLE IF EXISTS `app_milestone`;
CREATE TABLE `app_milestone` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT '应用密钥',
  `product_release_date` date NOT NULL COMMENT '生产发布日期',
  `name` varchar(128) NOT NULL COMMENT '版本名称',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_release_hook
-- ----------------------------
DROP TABLE IF EXISTS `app_release_hook`;
CREATE TABLE `app_release_hook` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App密钥',
  `env_name` varchar(16) DEFAULT NULL COMMENT '环境名称',
  `app_module` tinyint(4) NOT NULL COMMENT '模块（1:iOS 2:Android 3:离线资源 4:微服务）',
  `module_id` varchar(16) NOT NULL COMMENT '模块ID',
  `release_hook` varchar(128) NOT NULL COMMENT '发布 jenkins Hook',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_release_log
-- ----------------------------
DROP TABLE IF EXISTS `app_release_log`;
CREATE TABLE `app_release_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App密钥',
  `env_name` varchar(16) DEFAULT NULL COMMENT '环境名称',
  `app_module` tinyint(4) NOT NULL COMMENT '模块（1:iOS 2:Android 3:离线资源 4:微服务）',
  `module_id` varchar(16) NOT NULL COMMENT '模块ID',
  `release_time` varchar(128) NOT NULL COMMENT '发布时间',
  `version` varchar(32) NOT NULL COMMENT '发布版本',
  `developer` varchar(32) NOT NULL COMMENT '发布者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_requirement
-- ----------------------------
DROP TABLE IF EXISTS `app_requirement`;
CREATE TABLE `app_requirement` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `app_key` varchar(32) NOT NULL COMMENT 'App密钥',
  `name` varchar(64) NOT NULL COMMENT '需求名称',
  `milestone` date NOT NULL COMMENT '所属版本发布日期',
  `owner` varchar(64) NOT NULL COMMENT '开发负责人',
  `client` char(2) NOT NULL COMMENT '涉及的客户端（00:不涉及 10:iOS 01:Android 11:iOS+Android）',
  `resource` varchar(64) DEFAULT NULL COMMENT '涉及的离线资源，多个离线资源ID用‘|’分割',
  `service` varchar(64) DEFAULT NULL COMMENT '涉及的微服务，，多个微服务简称用‘|’分割',
  `state` tinyint(4) NOT NULL COMMENT '需求状态（0:未启动 1:开发中 2:测试中 3:测试未通过 4:测试通过 5:需求终止）',
  `descriptor` varchar(128) DEFAULT NULL COMMENT '需求描述信息',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_resource
-- ----------------------------
DROP TABLE IF EXISTS `app_resource`;
CREATE TABLE `app_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App密钥',
  `resource_id` varchar(16) NOT NULL COMMENT '资源包ID',
  `resource_desc` varchar(128) DEFAULT NULL COMMENT '资源描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_service
-- ----------------------------
DROP TABLE IF EXISTS `app_service`;
CREATE TABLE `app_service` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App密钥',
  `service_id` varchar(16) NOT NULL COMMENT '服务ID',
  `service_desc` varchar(128) DEFAULT NULL COMMENT '服务描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表唯一主键',
  `app_key` varchar(32) NOT NULL COMMENT 'App秘钥',
  `app_name` varchar(128) NOT NULL DEFAULT '我的应用' COMMENT 'App名称',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
