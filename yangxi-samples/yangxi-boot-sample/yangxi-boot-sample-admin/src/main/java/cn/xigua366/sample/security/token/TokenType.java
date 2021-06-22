package cn.xigua366.sample.security.token;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 18:35
 */
public enum TokenType {

    /**
     * jwt
     */
    JWT,

    /**
     * 基于redis存储
     */
    REDIS,

    /**
     * 基于mysql存储
     */
    MYSQL,

    /**
     * 基于内存存储
     */
    MEMORY;

}
