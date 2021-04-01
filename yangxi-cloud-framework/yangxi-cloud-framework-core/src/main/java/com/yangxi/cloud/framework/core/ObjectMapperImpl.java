package com.yangxi.cloud.framework.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义ObjectMapper组件实现
 * @author yangxi
 * @version 1.0
 */
public class ObjectMapperImpl extends ObjectMapper {

    public ObjectMapperImpl() {
        // 设置在序列化时包含为NULL的属性
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}