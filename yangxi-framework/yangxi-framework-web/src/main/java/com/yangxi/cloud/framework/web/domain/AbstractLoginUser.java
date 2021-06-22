package com.yangxi.cloud.framework.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录用户信息的抽象类
 *
 * @author yangxi
 * @version 1.0
 */
@Data
public abstract class AbstractLoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户名称
     */
    @JsonProperty("real_name")
    private String realName;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    private String headImg;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 令牌过期时间
     */
    private Date expiration;
}