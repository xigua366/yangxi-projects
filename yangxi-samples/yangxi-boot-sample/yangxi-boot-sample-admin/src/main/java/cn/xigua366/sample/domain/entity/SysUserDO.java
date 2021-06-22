package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xi.yang
 * @since 2021-06-21
 */
@Data
@TableName("sys_user")
public class SysUserDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名/员工工号
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 盐
     */
    private String secret;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 固定电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 启用状态0:禁用  1:启用
     */
    @TableField("is_enabled")
    private Boolean enabled;

    /**
     * 删除状态0:未删除 1:已删除
     */
    @TableLogic
    @TableField("is_deleted")
    private Boolean deleted;


}
