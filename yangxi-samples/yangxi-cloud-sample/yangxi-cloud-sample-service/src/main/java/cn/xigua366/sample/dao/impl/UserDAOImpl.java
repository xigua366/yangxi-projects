package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.UserDAO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xigua366.sample.domain.entity.UserDO;
import cn.xigua366.sample.mapper.UserMapper;
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
public class UserDAOImpl extends ServiceImpl<UserMapper, UserDO> implements UserDAO {

    @Override
    public UserDO findUserByPhone(String phone) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<UserDO>().eq("phone", phone);
        return baseMapper.selectOne(queryWrapper);
    }
}