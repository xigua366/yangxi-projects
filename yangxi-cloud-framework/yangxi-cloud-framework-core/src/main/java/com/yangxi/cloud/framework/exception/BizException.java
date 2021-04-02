package com.yangxi.cloud.framework.exception;

import java.text.MessageFormat;

/**
 * 自定义业务异常
 * @author yangxi
 *
 */
public class BizException extends RuntimeException {

    private int code = -1;

    private String msg;

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BaseBizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getMsg());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMsg();
    }

    public BizException(int code, String msg, Object... arguments) {
        super(MessageFormat.format(msg, arguments));
        this.code = code;
        this.msg = MessageFormat.format(msg, arguments);
    }

    public BizException(BaseBizCodeEnum bizCodeEnum, Object... arguments) {
        super(MessageFormat.format(bizCodeEnum.getMsg(), arguments));
        this.code = bizCodeEnum.getCode();
        this.msg = MessageFormat.format(bizCodeEnum.getMsg(), arguments);
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