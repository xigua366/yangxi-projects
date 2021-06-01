package com.yangxi.cloud.framework.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Data
@ConfigurationProperties("yangxi.cloud.web")
public class WebProperties {

    public final ControllerLog controllerLog = new ControllerLog();

    /**
     * Controller方法日志拦截配置
     */
    @Data
    public static class ControllerLog {

        /**
         * 是否启用Controller aop
         */
        private final Boolean enable = true;

    }

}