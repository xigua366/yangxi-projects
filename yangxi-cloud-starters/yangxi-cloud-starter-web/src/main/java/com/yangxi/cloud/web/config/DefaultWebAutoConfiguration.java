package com.yangxi.cloud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.cloud.framework.core.ObjectMapperImpl;
import com.yangxi.cloud.framework.web.config.DefaultGlobalBizExceptionHandler;
import com.yangxi.cloud.framework.web.config.DefaultGlobalResponseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
@Import(value = {DefaultGlobalBizExceptionHandler.class, DefaultGlobalResponseHandler.class, DefaultWebMvcConfigurer.class})
public class DefaultWebAutoConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImpl();
    }

}