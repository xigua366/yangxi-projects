package cn.xigua366.sample.mapper;

import cn.xigua366.sample.domain.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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