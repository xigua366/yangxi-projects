package cn.xigua366.sample.service;

import cn.xigua366.sample.domain.dto.SysUserDTO;

/**
 * <p>
 *
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