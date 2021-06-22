package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 权限模块表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_acl_module")
public class SysAclModuleDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限模块code
     */
    private String aclModuleCode;

    /**
     * 权限模块名称
     */
    private String aclModuleName;

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
