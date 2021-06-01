package com.yangxi.cloud.framework.web.config;

import com.yangxi.cloud.framework.web.aop.ControllerLogAspect;
import com.yangxi.cloud.framework.web.properties.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
@Import(value = {ControllerLogAspect.class, DefaultGlobalExceptionHandler.class, DefaultGlobalResponseHandler.class})
@EnableConfigurationProperties(WebProperties.class)
public class WebConfiguration {
}