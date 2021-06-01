package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Data
@TableName("t_user")
public class UserDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 签名
     */
    private String slogan;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 盐
     */
    private String secret;

}