package com.yangxi.cloud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.cloud.framework.core.ObjectMapperImpl;
import com.yangxi.cloud.framework.web.config.WebConfiguration;
import org.springframework.context.annotation.Bean;
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