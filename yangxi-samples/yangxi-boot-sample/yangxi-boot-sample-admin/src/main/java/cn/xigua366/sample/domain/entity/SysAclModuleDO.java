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
 * 权限模块表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_acl_module")
public class SysAclModuleDO implements Serializable {

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
    private Boolean isEnabled;

    /**
     * 显示顺序
     */
    private Integer order;

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
