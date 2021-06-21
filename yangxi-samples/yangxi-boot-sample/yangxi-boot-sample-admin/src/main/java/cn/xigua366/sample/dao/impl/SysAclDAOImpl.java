package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.SysAclDAO;
import cn.xigua366.sample.domain.entity.SysAclDO;
import cn.xigua366.sample.mapper.SysAclMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Service
public class SysAclDAOImpl extends ServiceImpl<SysAclMapper, SysAclDO> implements SysAclDAO {

}
