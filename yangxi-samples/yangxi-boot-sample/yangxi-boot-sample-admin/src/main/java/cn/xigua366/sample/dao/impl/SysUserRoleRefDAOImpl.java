package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysUserRoleRefDAO;
import cn.xigua366.sample.domain.entity.SysUserRoleRefDO;
import cn.xigua366.sample.mapper.SysUserRoleRefMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysUserRoleRefDAOImpl extends ServiceImpl<SysUserRoleRefMapper, SysUserRoleRefDO> implements SysUserRoleRefDAO {

}
