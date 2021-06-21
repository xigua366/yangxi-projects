package cn.xigua366.sample.domain.dto;

import com.yangxi.cloud.framework.domain.dto.BaseDTO;
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
public class SysUserDTO extends BaseDTO {

    /**
     * 用户名/员工工号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
    private Boolean isEnabled;

}