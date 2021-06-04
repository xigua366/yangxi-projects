package com.yangxi.cloud.framework.web.config;

import com.yangxi.cloud.framework.constants.CoreConstant;
import com.yangxi.cloud.framework.web.aop.ControllerLogAspect;
import com.yangxi.cloud.framework.web.filter.GlobalHttpRequestFilter;
import com.yangxi.cloud.framework.web.properties.WebProperties;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.ZoneId;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
@Import(value = {ControllerLogAspect.class, DefaultGlobalExceptionHandler.class})
@EnableConfigurationProperties(WebProperties.class)
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean<GlobalHttpRequestFilter> globalHttpRequestFilter() {
        GlobalHttpRequestFilter globalHttpRequestFilter = new GlobalHttpRequestFilter();
        FilterRegistrationBean<GlobalHttpRequestFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(globalHttpRequestFilter);
        filterFilterRegistrationBean.setName("globalHttpRequestFilter");
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(100);
        return filterFilterRegistrationBean;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.timeZone(ZoneId.systemDefault().getId());
            jacksonObjectMapperBuilder.simpleDateFormat(CoreConstant.DATE_TIME_FORMAT_PATTERN);
            jacksonObjectMapperBuilder.failOnUnknownProperties(false);
        };
    }

}