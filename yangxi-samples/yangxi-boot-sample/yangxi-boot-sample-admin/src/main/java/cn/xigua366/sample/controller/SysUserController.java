package cn.xigua366.sample.controller;

import cn.xigua366.sample.domain.dto.SysUserDTO;
import cn.xigua366.sample.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户管理Controller组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/v1/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    // **********  用户管理 ***********

    // 新增用户


    // 分页查询用户列表

    // 根据用户ID查询用户信息

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public SysUserDTO getUserByUsername(@PathVariable("username") String username) {
        return sysUserService.getUserByUsername(username);
    }

    // 更新用户信息


    // 更改用户密码


    // 禁用/启用用户


    // 删除用户


    // 批量删除用户


    // **********  用户与组织关联管理 ***********

    // 将用户加入到一个组织

    // 将用户加入到一批组织

    // 查看用户所属组织列表


    // **********  用户与角色关联管理 ***********

    // 分页查询用户关联的角色

    // 给用户添加一个角色

    // 给用户添加一批角色


    // 给用户移除一个角色


    // 给用户移除一批角色


    // **********  用户权限关联管理 ***********

    // 给用户添加一个权限

    // 给用户添加一批权限

    // 给用户移除一个权限

    // 给用户移除一批权限



}