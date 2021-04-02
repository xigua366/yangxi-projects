package com.yangxi.cloud.openfeign.config;

import com.yangxi.cloud.openfeign.interceptor.DefaultFeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangxi
 * @version 1.0
 */
@Configuration
public class DefaultFeignClientAutoConfiguration {

    @Bean
    public DefaultFeignRequestInterceptor defaultFeignRequestInterceptor() {
        return new DefaultFeignRequestInterceptor();
    }

}