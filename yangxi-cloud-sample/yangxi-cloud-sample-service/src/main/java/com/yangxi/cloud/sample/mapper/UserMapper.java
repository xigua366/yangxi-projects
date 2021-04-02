package com.yangxi.cloud.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangxi.cloud.sample.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xi.yang
 * @since 2021-03-30
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}