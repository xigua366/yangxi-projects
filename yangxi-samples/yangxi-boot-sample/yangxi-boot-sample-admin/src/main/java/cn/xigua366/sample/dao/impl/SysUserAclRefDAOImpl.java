package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysUserAclRefDAO;
import cn.xigua366.sample.domain.entity.SysUserAclRefDO;
import cn.xigua366.sample.mapper.SysUserAclRefMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与权限的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysUserAclRefDAOImpl extends ServiceImpl<SysUserAclRefMapper, SysUserAclRefDO> implements SysUserAclRefDAO {

}
