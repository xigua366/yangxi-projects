package com.yangxi.cloud.web.config;

import com.yangxi.cloud.framework.web.config.WebConfiguration;
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
@Import(value = {WebConfiguration.class, DefaultWebMvcConfigurer.class})
public class DefaultWebAutoConfiguration {

}