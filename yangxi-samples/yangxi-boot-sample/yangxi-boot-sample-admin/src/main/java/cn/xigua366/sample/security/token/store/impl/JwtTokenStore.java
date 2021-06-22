package cn.xigua366.sample.security.token.store.impl;

import cn.xigua366.sample.security.service.MyUserDetails;
import cn.xigua366.sample.security.token.store.AbstractTokenStore;
import cn.xigua366.sample.security.token.utils.JWTUtil;
import cn.xigua366.sample.security.token.LoginUser;
import org.springframework.stereotype.Component;

/**
 * 基于jwt的令牌存储实现
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:52
 */
@Component
public class JwtTokenStore extends AbstractTokenStore {

    /**
     * 基于用户信息生成令牌
     *
     * @param myUserDetails 用户信息
     * @return
     */
    @Override
    public String createToken(MyUserDetails myUserDetails) {
        // 获取需要存储到token中的用户信息
        LoginUser loginUser = getLoginUser(myUserDetails);
        return JWTUtil.createToken(loginUser);
    }

    /**
     * Jwt令牌自带存储信息
     *
     * @param token 令牌
     * @param loginUser 登录用户信息
     */
    @Override
    protected void storeLoginUser(String token, LoginUser loginUser) {
        // do nothing
    }

    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return
     */
    @Override
    public LoginUser parseToken(String token) {
        return JWTUtil.parseToken(token);
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
        // 也可以存放到redis然后进行销毁
        return true;
    }
}
