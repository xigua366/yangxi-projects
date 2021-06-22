package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 组织表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_org")
public class SysOrgDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 组织code
     */
    private String orgCode;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 组织描述
     */
    private String orgDesc;

    /**
     * 组织类型 1:真实的组织机构  2:虚拟团队
     */
    private Integer orgType;

    /**
     * 组织等级：-1:无等级 1:一级部门 2:二级部门
     */
    private Integer orgLevel;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 启用状态0:禁用  1:启用
     */
    @TableField("is_enabled")
    private Boolean enabled;

}
