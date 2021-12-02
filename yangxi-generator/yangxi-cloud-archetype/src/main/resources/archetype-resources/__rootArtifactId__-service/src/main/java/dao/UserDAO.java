package ${package}.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.dao.UserDAO;
import ${package}.domain.entity.UserDO;
import ${package}.mapper.UserMapper;
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