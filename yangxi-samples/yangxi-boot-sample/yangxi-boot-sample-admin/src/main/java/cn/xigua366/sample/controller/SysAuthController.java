package cn.xigua366.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户认证与鉴权管理Controller组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/v1/sys/auth")
public class SysAuthController {

    // **********  用户认证与鉴权管理 ***********

    // 查询用户被授权的模块（不查询模块下的权限树）

    // 查询用户被授权的权限树（同时返回模块信息）

    // 检查用户对指定的权限ID是否有授权记录

    // 检查用户对指定的权限code是否有授权记录

    // 检查用户对指定的url是否有权限访问

}