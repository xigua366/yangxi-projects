package com.yangxi.cloud.framework.web.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * <p>
 * 令牌上下文信息，用于实现用户登录认证
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class TokenContext {

    /**
     * 租户ID
     */
    private static final ThreadLocal<String> TOKEN = new TransmittableThreadLocal<>();

    public static void setToken(String token) {
        TOKEN.set(token);
    }

    public static String getToken() {
        return TOKEN.get();
    }

    /**
     * 清空上下文信息
     */
    public static void clear() {
        TOKEN.remove();
    }
}