package ${package}.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 登录用户信息
 * @author yangxi
 */
@Data
public class LoginUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    private String headImg;

    /**
     * 邮箱
     */
    private String mail;


    /**
     * 手机号码
     */
    private String phone;

}