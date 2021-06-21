package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysRoleAclRefDAO;
import cn.xigua366.sample.domain.entity.SysRoleAclRefDO;
import cn.xigua366.sample.mapper.SysRoleAclRefMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与权限的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysRoleAclRefDAOImpl extends ServiceImpl<SysRoleAclRefMapper, SysRoleAclRefDO> implements SysRoleAclRefDAO {

}
