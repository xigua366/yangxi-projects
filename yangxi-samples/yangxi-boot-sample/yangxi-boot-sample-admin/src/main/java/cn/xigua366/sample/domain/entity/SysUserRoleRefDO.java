package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 用户与角色的关联关系表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_user_role_ref")
public class SysUserRoleRefDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Integer roleId;


}
