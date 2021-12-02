package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.entity.SysUserDO;
import cn.xigua366.sample.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangxi.cloud.framework.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Repository
public class SysUserDAO extends BaseDAO<SysUserMapper, SysUserDO> {

    public SysUserDO getUserByUsername(String username) {
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return baseMapper.selectOne(queryWrapper);
    }
}
