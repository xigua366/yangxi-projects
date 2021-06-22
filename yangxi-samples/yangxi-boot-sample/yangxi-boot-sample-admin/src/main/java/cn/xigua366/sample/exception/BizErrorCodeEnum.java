package cn.xigua366.sample.exception;

import com.yangxi.cloud.framework.exception.BaseErrorCodeEnum;

/**
 * <p>
 * 业务错误码枚举定义
 *
 * 状态码定义约束，共6位数，前三位代表服务/模块，后三位代表接口
 * 比如 商品服务210,购物车是220、用户服务230，403代表权限
 * </p>
 *
 * @author yangxi
 * @version 1.0
 **/
public enum BizErrorCodeEnum implements BaseErrorCodeEnum {

    /**
     * 通用操作码
     */
    OPS_REPEAT(110001,"重复操作"),


    /**
     *验证码
     */
    CODE_TO_ERROR(240001,"接收号码不合规"),
    CODE_LIMITED(240002,"验证码发送过快"),
    CODE_ERROR(240003,"验证码错误"),
    CODE_CAPTCHA_ERROR(240101,"图形验证码错误"),



    /**
     * 账号
     */
    ACCOUNT_REPEAT(250001,"账号已经存在"),
    ACCOUNT_UNREGISTER(250002,"账号不存在"),
    ACCOUNT_PWD_ERROR(250003,"账号或者密码错误"),
    ACCOUNT_UN_LOGIN(250004,"账号未登录"),

    /**
     * 文件相关
     */
    FILE_UPLOAD_USER_IMG_FAIL(600101,"用户头像文件上传失败"),


    /**
     * 流控操作
     */

    CONTROL_FLOW(500101,"限流控制"),
    CONTROL_DEGRADE(500201,"降级控制"),
    CONTROL_AUTH(500301,"认证控制"),

    ;



    private int code;

    private String msg;

    BizErrorCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
