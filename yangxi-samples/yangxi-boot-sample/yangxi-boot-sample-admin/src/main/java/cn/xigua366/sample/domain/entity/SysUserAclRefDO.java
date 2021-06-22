package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 用户与权限的关联关系表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_user_acl_ref")
public class SysUserAclRefDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 权限ID
     */
    private Integer aclId;


}
