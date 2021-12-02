package com.yangxi.cloud.framework.web.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * <p>
 * 登录用户信息上下文信息，用于实现用户登录成功之后获取用户信息
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class LoginUserContext {

    /**
     * 登录用户信息
     */
    private static final ThreadLocal<String> LOGIN_USER = new TransmittableThreadLocal<>();

    public static void setLoginUser(String loginUser) {
        LOGIN_USER.set(loginUser);
    }

    public static String getLoginUser() {
        return LOGIN_USER.get();
    }

    /**
     * 清空上下文信息
     */
    public static void clear() {
        LOGIN_USER.remove();
    }

}