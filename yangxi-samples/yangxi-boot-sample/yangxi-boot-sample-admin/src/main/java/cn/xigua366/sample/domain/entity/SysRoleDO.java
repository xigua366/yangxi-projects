package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_role")
public class SysRoleDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 启用状态0:禁用  1:启用
     */
    @TableField("is_enabled")
    private Boolean enabled;

    /**
     * 显示顺序
     */
    private Integer sort;

}
