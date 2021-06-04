package com.yangxi.cloud.web.config;

import com.yangxi.cloud.framework.web.converter.StringToDateConverter;
import com.yangxi.cloud.framework.web.interceptor.DefaultWebMvcHandlerInterceptor;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

/**
 * <p>
 * 默认的web mvc相关配置
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
public class DefaultWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO 拦截的内容，可以开放一个配置出去，让应用方自行配置
        registry.addInterceptor(new DefaultWebMvcHandlerInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
    }
}