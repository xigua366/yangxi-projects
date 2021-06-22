package cn.xigua366.sample.service;

import cn.xigua366.sample.domain.dto.SysUserDTO;

/**
 * <p>
 * 系统用户管理Service组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public interface SysUserService {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    SysUserDTO getUserByUsername(String username);
}