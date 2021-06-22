package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 角色与权限的关联关系表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_role_acl_ref")
public class SysRoleAclRefDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Integer aclId;


}
