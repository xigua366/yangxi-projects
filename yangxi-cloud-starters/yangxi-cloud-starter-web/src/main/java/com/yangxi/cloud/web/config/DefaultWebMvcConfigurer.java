package com.yangxi.cloud.web.config;

import com.yangxi.cloud.framework.web.interceptor.GlobalWebMvcInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

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
        registry.addInterceptor(new GlobalWebMvcInterceptor()).addPathPatterns("/**");
    }

    /**
     * 配置静态资源示例
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/")
                // 设置静态资源在浏览器中的缓存时间
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(30)));
    }
}