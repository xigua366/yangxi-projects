package cn.xigua366.sample.security.token.store;

import cn.xigua366.sample.security.service.MyUserDetails;
import cn.xigua366.sample.security.token.LoginUser;

/**
 * 令牌存储方式
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:18
 */
public interface TokenStore {

    /**
     * 基于用户信息生成令牌
     *
     * @param myUserDetails 用户信息
     * @return
     */
    String createToken(MyUserDetails myUserDetails);

    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return
     */
    LoginUser parseToken(String token);

    /**
     * 刷新令牌
     *
     * @return 新的令牌
     */
    // String refreshToken();

    /**
     * 销毁令牌
     *
     * @param token 令牌
     * @param loginUser 登录用户信息
     * @return
     */
    boolean destroyToken(String token, LoginUser loginUser);
}
