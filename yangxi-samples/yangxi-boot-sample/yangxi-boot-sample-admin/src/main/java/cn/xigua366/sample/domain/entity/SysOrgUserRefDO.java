package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 组织与用户的关联关系表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_org_user_ref")
public class SysOrgUserRefDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 用户ID
     */
    private Integer userId;


}
