package cn.xigua366.sample.mapper;

import cn.xigua366.sample.domain.entity.SysRoleAclRefDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与权限的关联关系表 Mapper 接口
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Mapper
public interface SysRoleAclRefMapper extends BaseMapper<SysRoleAclRefDO> {

}
