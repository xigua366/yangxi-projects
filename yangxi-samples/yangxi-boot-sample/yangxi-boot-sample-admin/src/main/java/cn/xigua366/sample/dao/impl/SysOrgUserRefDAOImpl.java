package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysOrgUserRefDAO;
import cn.xigua366.sample.domain.entity.SysOrgUserRefDO;
import cn.xigua366.sample.mapper.SysOrgUserRefMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织与用户的关联关系表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysOrgUserRefDAOImpl extends ServiceImpl<SysOrgUserRefMapper, SysOrgUserRefDO> implements SysOrgUserRefDAO {

}
