package com.yangxi.cloud.framework.exception;

/**
 * <p>
 * 异常错误码枚举抽象定义
 * </p>
 *
 * @author yangxi
 * @version 1.0
 **/
public interface BaseErrorCodeEnum {

    int getCode();

    String getMsg();
}
