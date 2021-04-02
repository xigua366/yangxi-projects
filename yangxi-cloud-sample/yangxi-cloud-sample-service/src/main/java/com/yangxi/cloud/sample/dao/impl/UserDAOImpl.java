package com.yangxi.cloud.sample.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxi.cloud.sample.dao.UserDAO;
import com.yangxi.cloud.sample.domain.entity.UserDO;
import com.yangxi.cloud.sample.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
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