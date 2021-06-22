package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_acl")
public class SysAclDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限模块ID
     */
    private Long aclModuleId;

    /**
     * 权限code
     */
    private String aclCode;

    /**
     * 权限名称
     */
    private String aclName;

    /**
     * 权限描述
     */
    private String aclDesc;

    /**
     * 权限类型 1:菜单 2:按钮 3:链接 4:其它
     */
    private Integer aclType;

    /**
     * 请求method
     */
    private String httpMethod;

    /**
     * 请求url
     */
    private String httpUrl;

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
