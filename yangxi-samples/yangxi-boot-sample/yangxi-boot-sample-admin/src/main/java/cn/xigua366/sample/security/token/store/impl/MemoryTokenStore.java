package cn.xigua366.sample.security.token.store.impl;

import cn.xigua366.sample.security.token.LoginUser;
import cn.xigua366.sample.security.token.store.AbstractTokenStore;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于内存的令牌存储方案
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:55
 */
@Component
public class MemoryTokenStore extends AbstractTokenStore {

    private Map<String, Object> tokens = new ConcurrentHashMap<>();

    /**
     * 存储用户信息（将用户信息与令牌进行绑定）
     *
     * @param token 令牌
     * @param loginUser 用户信息
     */
    @Override
    protected void storeLoginUser(String token, LoginUser loginUser) {
        tokens.put(token, loginUser);
    }

    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return
     */
    @Override
    public LoginUser parseToken(String token) {
        return (LoginUser) tokens.get(token);
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
        tokens.remove(token);
        return true;
    }
}
