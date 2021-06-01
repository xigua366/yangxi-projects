package com.yangxi.cloud.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangxi.cloud.sample.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}