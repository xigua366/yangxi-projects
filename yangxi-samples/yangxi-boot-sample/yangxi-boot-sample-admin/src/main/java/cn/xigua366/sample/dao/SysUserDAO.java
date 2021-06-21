package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.entity.SysUserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
public interface SysUserDAO extends IService<SysUserDO> {

    SysUserDO getUserByUsername(String username);

}
