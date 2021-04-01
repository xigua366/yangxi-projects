package com.yangxi.cloud.framework.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.cloud.framework.exception.BaseBizCodeEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Controller接口返回统一封装对象
 *
 * @author yangxi
 *
 */
@Slf4j
public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求成功
     */
    private static final Integer REQUEST_SUCCESS = 0;

    /**
     * 请求失败
     */
    private static final Integer REQUEST_FAIL = -1;

    /**
     * 状态码 0表示成功过，1表示处理中，-1 表示失败
     */
    private Integer code;

    /**
     * 业务数据
     */
    private Object data;

    /**
     * 信息表示
     */
    private String msg;

    private static ObjectMapper objectMapper = new ObjectMapperImpl();

    public JsonData() {}

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功，不用返回数据
     * @return
     */
    public static JsonData buildSuccess() {
        return new JsonData(REQUEST_SUCCESS,null,null);
    }

    /**
     * 成功，返回数据
     * @param data
     * @return
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(REQUEST_SUCCESS, data,null);
    }


    /**
     * 失败，固定状态码
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg) {
        return new JsonData(REQUEST_FAIL ,null, msg);
    }


    /**
     * 失败，自定义错误码和信息
     * @param code
     * @param msg
     * @return
     */
    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code ,null, msg);
    }

    /**
     * 失败，枚举类定义错误码和信息
     * @param baseBizCodeEnum
     * @return
     */
    public static JsonData buildError(BaseBizCodeEnum baseBizCodeEnum) {
        return new JsonData(baseBizCodeEnum.getCode() ,null, baseBizCodeEnum.getMsg());
    }

    /**
     *  用于支持获取远程调用返回数据的转换
     *  注意事项：
     *      支持多单词下划线专驼峰（序列化和反序列化）
     *
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(Class<T> clazz){
        if(data == null) {
            return null;
        }
        try {
            String jsonStr = objectMapper.writeValueAsString(data);
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("json data process error", e);
        }
        return null;
    }

    /**
     *  用于支持获取远程调用返回数据的转换
     *  注意事项：
     *      支持多单词下划线专驼峰（序列化和反序列化）
     *
     *
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T getData(TypeReference<T> typeReference){
        if(data == null) {
            return null;
        }
        try {
            String jsonStr = objectMapper.writeValueAsString(data);
            return objectMapper.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            log.error("json data process error", e);
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
