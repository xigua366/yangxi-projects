package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org")
public class SysOrgDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

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
    private Integer order;

    /**
     * 启用状态0:禁用  1:启用
     */
    private Boolean isEnabled;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
