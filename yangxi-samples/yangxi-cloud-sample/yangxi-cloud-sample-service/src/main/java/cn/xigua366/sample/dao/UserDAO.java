package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.entity.UserDO;
import cn.xigua366.sample.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangxi.cloud.framework.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * <P>
 *
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Repository
public class UserDAO extends BaseDAO<UserMapper, UserDO> {

    public UserDO findUserByPhone(String phone) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<UserDO>().eq("phone", phone);
        return baseMapper.selectOne(queryWrapper);
    }
}