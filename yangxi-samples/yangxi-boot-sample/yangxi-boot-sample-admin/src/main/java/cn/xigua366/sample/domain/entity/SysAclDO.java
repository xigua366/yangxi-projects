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
 * 权限表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_acl")
public class SysAclDO implements Serializable {

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
