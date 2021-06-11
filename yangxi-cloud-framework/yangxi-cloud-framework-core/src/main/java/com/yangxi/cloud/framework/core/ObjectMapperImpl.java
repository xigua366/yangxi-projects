package com.yangxi.cloud.framework.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.yangxi.cloud.framework.constants.CoreConstant;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

//#统一返回时间戳配置
//        spring.jackson.serialization.write-dates-as-timestamps=true
//        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

//        #统一时区
//        spring.jackson.time-zone=Asia/Shanghai
        setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault().getId()));

        // 设置日期格式化
        setDateFormat(new SimpleDateFormat(CoreConstant.DATE_TIME_FORMAT_PATTERN));

        // Java8 日期相关
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(CoreConstant.DATE_TIME_FORMAT_PATTERN)));
        javaTimeModule.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ofPattern(CoreConstant.DATE_FORMAT_PATTERN)));
        javaTimeModule.addSerializer(LocalTime.class,new LocalTimeSerializer(DateTimeFormatter.ofPattern(CoreConstant.TIME_FORMAT_PATTERN)));
        javaTimeModule.addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(CoreConstant.DATE_TIME_FORMAT_PATTERN)));
        javaTimeModule.addDeserializer(LocalDate.class,new LocalDateDeserializer(DateTimeFormatter.ofPattern(CoreConstant.DATE_FORMAT_PATTERN)));
        javaTimeModule.addDeserializer(LocalTime.class,new LocalTimeDeserializer(DateTimeFormatter.ofPattern(CoreConstant.TIME_FORMAT_PATTERN)));
        registerModule(javaTimeModule);
        registerModules(javaTimeModule, new ParameterNamesModule());
    }
}