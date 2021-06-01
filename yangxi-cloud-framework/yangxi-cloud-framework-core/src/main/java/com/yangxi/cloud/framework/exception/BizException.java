package com.yangxi.cloud.framework.exception;

import java.text.MessageFormat;

/**
 * <P>
 * 自定义业务异常
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
public class BizException extends RuntimeException {

    private int code = -1;

    private String msg;

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BaseErrorCodeEnum baseErrorCodeEnum) {
        super(baseErrorCodeEnum.getMsg());
        this.code = baseErrorCodeEnum.getCode();
        this.msg = baseErrorCodeEnum.getMsg();
    }

    public BizException(int code, String msg, Object... arguments) {
        super(MessageFormat.format(msg, arguments));
        this.code = code;
        this.msg = MessageFormat.format(msg, arguments);
    }

    public BizException(BaseErrorCodeEnum baseErrorCodeEnum, Object... arguments) {
        super(MessageFormat.format(baseErrorCodeEnum.getMsg(), arguments));
        this.code = baseErrorCodeEnum.getCode();
        this.msg = MessageFormat.format(baseErrorCodeEnum.getMsg(), arguments);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}