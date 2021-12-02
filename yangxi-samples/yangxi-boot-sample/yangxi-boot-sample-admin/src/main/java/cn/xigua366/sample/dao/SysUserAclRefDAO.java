package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.entity.SysUserAclRefDO;
import cn.xigua366.sample.mapper.SysUserAclRefMapper;
import com.yangxi.cloud.framework.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户与权限的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Repository
public class SysUserAclRefDAO extends BaseDAO<SysUserAclRefMapper, SysUserAclRefDO> {

}
