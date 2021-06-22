package cn.xigua366.sample.service.impl;

import cn.xigua366.sample.dao.SysUserDAO;
import cn.xigua366.sample.domain.dto.SysUserDTO;
import cn.xigua366.sample.domain.entity.SysUserDO;
import cn.xigua366.sample.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 * 系统用户管理Service组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDAO sysUserDAO;

    @Override
    public SysUserDTO getUserByUsername(String username) {
        Assert.notNull(username, "用户名不能为空");
        SysUserDO sysUserDO = sysUserDAO.getUserByUsername(username);
        if(sysUserDO == null) {
            return null;
        }
        return sysUserDO.clone(SysUserDTO.class);
    }
}