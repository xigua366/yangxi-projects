# yangxi-boot-sample-admin
基于RBAC模型的后台运行管理系统（单体架构）

## RBAC领域模型设计
![avatar](https://yangxi-projects.oss-cn-shenzhen.aliyuncs.com/yangxi-boot-sample-admin/1_RBAC%E9%A2%86%E5%9F%9F%E6%A8%A1%E5%9E%8B%E8%AE%BE%E8%AE%A1.png) 

## RBAC相关表定义
```
sys_org              --组织表（企业组织机构或虚拟团队表 ）
sys_user             --用户表

sys_org_user_ref     --组织与用户的关联关系表

-----------------------------------------------------
sys_role             --角色表

sys_org_role_ref     --组织与角色的关联关系表
sys_user_role_ref    --用户与角色的关联关系表

-----------------------------------------------------
sys_acl_module       --权限模块表
sys_acl              --权限表

sys_role_acl_ref     --角色与权限的关联关系表
sys_user_acl_ref     --用户与权限的关联关系表

-----------------------------------------------------
```

## 具体表结构定义
```
-- 组织表
CREATE TABLE `sys_org` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `org_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '组织code',
  `org_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '组织名称',
  `org_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '组织描述',
  `org_type` tinyint(4) NOT NULL COMMENT '组织类型 1:真实的组织机构  2:虚拟团队',
  `org_level` int(11) NOT NULL DEFAULT '-1' COMMENT '组织等级：-1:无等级 1:一级部门 2:二级部门',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态0:禁用  1:启用',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织表';

-- 用户表
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `username` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名/员工工号',
  `pwd` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `secret` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '盐',
  `real_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '真实姓名',
  `phone` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
  `tel` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '固定电话',
  `email` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态0:禁用  1:启用',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '删除状态0:未删除 1:已删除',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- 组织与用户的关联关系表
CREATE TABLE `sys_org_user_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `org_id` bigint(20) NOT NULL COMMENT '组织ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织与用户的关联关系表';

-- 角色表
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `role_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '角色code',
  `role_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色描述',
  `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态0:禁用  1:启用',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

-- 组织与角色的关联关系表
CREATE TABLE `sys_org_role_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `org_id` bigint(20) NOT NULL COMMENT '组织ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织与角色的关联关系表';

-- 用户与权限的关联关系表
CREATE TABLE `sys_user_role_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户与角色的关联关系表';

-- 权限模块表
CREATE TABLE `sys_acl_module` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `acl_module_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '权限模块code',
  `acl_module_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '权限模块名称',
  `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态0:禁用  1:启用',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限模块表';


-- 权限表
CREATE TABLE `sys_acl` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `acl_module_id` bigint(20) NOT NULL COMMENT '权限模块ID',
  `acl_code` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '权限code',
  `acl_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '权限名称',
  `acl_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限描述',
  `acl_type` tinyint(4) DEFAULT NULL COMMENT '权限类型 1:菜单 2:按钮 3:链接 4:其它',
  `http_method` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '请求method',
  `http_url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '请求url',
  `is_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态0:禁用  1:启用',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限表';


-- 角色与权限的关联关系表
CREATE TABLE `sys_role_acl_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `acl_id` int(11) NOT NULL COMMENT '权限ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色与权限的关联关系表';

-- 用户与权限的关联关系表
CREATE TABLE `sys_user_acl_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `acl_id` int(11) NOT NULL COMMENT '权限ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户与权限的关联关系表';

-- 系统枚举值信息表


-- 系统参数信息表


-- 系统访问日志信息表


-- 用户黑名单表


```