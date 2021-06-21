package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysRoleDAO;
import cn.xigua366.sample.domain.entity.SysRoleDO;
import cn.xigua366.sample.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysRoleDAOImpl extends ServiceImpl<SysRoleMapper, SysRoleDO> implements SysRoleDAO {

}
