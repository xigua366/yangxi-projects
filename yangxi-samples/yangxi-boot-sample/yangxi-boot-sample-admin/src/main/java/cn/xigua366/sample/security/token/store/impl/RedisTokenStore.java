package cn.xigua366.sample.security.token.store.impl;

import cn.xigua366.sample.security.token.LoginUser;
import cn.xigua366.sample.security.token.store.AbstractTokenStore;
import org.springframework.stereotype.Component;

/**
 * 基于Redis的令牌存储方案
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:55
 */
@Component
public class RedisTokenStore extends AbstractTokenStore {

    /**
     * 存储用户信息（将用户信息与令牌进行绑定）
     *
     * @param token 令牌
     * @param loginUser 登录用户信息
     */
    @Override
    protected void storeLoginUser(String token, LoginUser loginUser) {
        // 存储到redis TODO
    }

    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return
     */
    @Override
    public LoginUser parseToken(String token) {
        // 从redis中获取用户信息 TODO
        return null;
    }

    /**
     * 销毁令牌
     *
     * @param token 令牌
     * @param loginUser 登录用户信息
     * @return
     */
    @Override
    public boolean destroyToken(String token, LoginUser loginUser) {
        // 从redis中移除令牌与用户信息 TODO
        return false;
    }
}
