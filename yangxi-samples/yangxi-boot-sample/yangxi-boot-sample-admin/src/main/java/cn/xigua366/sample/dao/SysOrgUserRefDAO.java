package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.entity.SysOrgUserRefDO;
import cn.xigua366.sample.mapper.SysOrgUserRefMapper;
import com.yangxi.cloud.framework.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 组织与用户的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Repository
public class SysOrgUserRefDAO extends BaseDAO<SysOrgUserRefMapper, SysOrgUserRefDO> {

}
