package com.yangxi.cloud.framework.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.TimeZone;

/**
 * <p>
 * 自定义ObjectMapper组件实现
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class ObjectMapperImpl extends ObjectMapper {

    public ObjectMapperImpl() {
        // 设置在序列化时不包含为NULL的属性
//        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 设置反序列化时忽略JSON字符串中存在而Java对象实际没有的属性
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        #统一时区
//        spring.jackson.time-zone=Asia/Shanghai
//#统一返回时间戳配置
//        spring.jackson.serialization.write-dates-as-timestamps=true

//        setTimeZone(TimeZone.getTimeZone());
    }
}