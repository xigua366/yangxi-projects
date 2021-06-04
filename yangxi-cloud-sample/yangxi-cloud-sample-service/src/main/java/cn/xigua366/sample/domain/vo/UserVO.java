package cn.xigua366.sample.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yangxi.cloud.framework.domain.vo.BaseVO;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Data
public class UserVO extends BaseVO {

    private Long id;


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
     * 生日
     *
     * 框架默认是转换成 yyyy-MM-dd HH:mm:ss格式
     * 如果明确需要yyyy-MM-dd格式，那么需要自行给对应的字段添加@JsonFormat注解
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String tenantId;

    private String remark;

    private Date createdTime;

    private Date updatedTime;

}