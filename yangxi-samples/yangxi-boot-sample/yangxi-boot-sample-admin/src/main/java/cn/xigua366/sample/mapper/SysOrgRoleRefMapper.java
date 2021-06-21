package cn.xigua366.sample.mapper;

import cn.xigua366.sample.domain.entity.SysOrgRoleRefDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 组织与角色的关联关系表 Mapper 接口
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Mapper
public interface SysOrgRoleRefMapper extends BaseMapper<SysOrgRoleRefDO> {

}
