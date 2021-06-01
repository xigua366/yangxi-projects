package com.yangxi.cloud.framework.core;

import com.yangxi.cloud.framework.exception.BaseErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Controller接口返回统一封装对象
 *
 * @author yangxi
 *
 */
@Slf4j
public class JsonData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求成功
     */
    private static final int REQUEST_SUCCESS = 0;

    /**
     * 请求失败
     */
    private static final int REQUEST_FAIL = -1;

    /**
     * 状态码 0表示成功过，1表示处理中，-1 表示失败
     */
    private int code;

    /**
     * 业务数据
     */
    private T data;

    /**
     * 信息表示
     */
    private String msg;

    public JsonData() {}

    public JsonData(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功，不用返回数据
     * @return
     */
    public static <T> JsonData<T> buildSuccess() {
        return new JsonData<>(REQUEST_SUCCESS,null,null);
    }

    /**
     * 成功，返回数据
     * @param data
     * @return
     */
    public static <T> JsonData<T> buildSuccess(T data) {
        return new JsonData<>(REQUEST_SUCCESS, data,null);
    }


    /**
     * 失败，固定状态码
     * @param msg
     * @return
     */
    public static <T> JsonData<T> buildError(String msg) {
        return new JsonData<>(REQUEST_FAIL ,null, msg);
    }


    /**
     * 失败，自定义错误码和信息
     * @param code
     * @param msg
     * @return
     */
    public static <T> JsonData<T> buildError(Integer code, String msg) {
        return new JsonData<>(code ,null, msg);
    }

    /**
     * 失败，枚举类定义错误码和信息
     * @param baseErrorCodeEnum
     * @return
     */
    public static <T> JsonData<T> buildError(BaseErrorCodeEnum baseErrorCodeEnum) {
        return new JsonData<>(baseErrorCodeEnum.getCode() ,null, baseErrorCodeEnum.getMsg());
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
