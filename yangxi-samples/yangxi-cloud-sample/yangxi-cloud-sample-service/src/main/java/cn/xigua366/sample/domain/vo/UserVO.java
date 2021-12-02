package cn.xigua366.sample.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yangxi.cloud.framework.domain.vo.BaseVO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
     * 出生日期
     *
     * 框架默认是 yyyy-MM-dd HH:mm:ss格式
     * 如果明确需要yyyy-MM-dd格式，那么需要自行给对应的字段添加@JsonFormat注解
     */
//    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String tenantId;

    private String remark;

    /**
     * 创建时间
     */
    // 框架添加了默认的json日期字段格式为yyyy-MM-dd HH:mm:ss，对于json request body 或者 json response body的时候，格式为yyyy-MM-dd HH:mm:ss的日期字段可以不加@JsonFormat注解
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 对于非 json request body方式提交日期入参的话，还是最好每个日期参数都自行添加一下@DateTimeFormat注解是最好的方式。
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

}