package cn.xigua366.sample.security;

import cn.xigua366.sample.security.token.TokenType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全相关的配置信息
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:00
 */
@Data
@ConfigurationProperties(prefix = "yangxi.boot.admin.security")
public class SecurityProperties {

    /**
     * 令牌类型
     * Jwt, Redis, Mysql, Memory
     */
    private String tokenType = TokenType.MEMORY.name();

}
