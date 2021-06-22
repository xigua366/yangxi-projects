package cn.xigua366.sample.security.token.store;


import cn.xigua366.sample.security.SecurityConstants;
import cn.xigua366.sample.security.service.MyUserDetails;
import cn.xigua366.sample.security.token.LoginUser;
import cn.xigua366.sample.security.token.utils.JWTUtil;

import java.util.UUID;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-11-24 09:42
 */
public abstract class AbstractTokenStore implements TokenStore {

    /**
     * 基于用户信息生成令牌
     *
     * @param myUserDetails 用户信息
     * @return 令牌
     */
    @Override
    public String createToken(MyUserDetails myUserDetails) {
        // 生成token
        String token = generateToken();

        // 获取存储到token中的用户信息
        LoginUser loginUser = getLoginUser(myUserDetails);

        // 存储令牌与用户信息
        storeLoginUser(token, loginUser);
        return SecurityConstants.TOKEN_PREFIX + token;
    }

    /**
     * 生成token
     *
     * @return 令牌字符串
     */
    private String generateToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取登录成功的用户信息
     *
     * @param myUserDetails spring security 中的自定义用户信息
     * @return 用户信息
     */
    protected LoginUser getLoginUser(MyUserDetails myUserDetails) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(myUserDetails.getId());
        loginUser.setUsername(myUserDetails.getUsername());
        loginUser.setRealName(myUserDetails.getRealName());
        loginUser.setHeadImg(myUserDetails.getHeadImg());
        loginUser.setPhone(myUserDetails.getPhone());
        loginUser.setMail(myUserDetails.getMail());
        loginUser.setAdmin(myUserDetails.isAdmin());
        loginUser.setExpiration(JWTUtil.generateExpirationDate());
        return loginUser;
    }

    /**
     * 存储用户信息（将用户信息与令牌进行绑定）
     *
     * @param token 令牌
     * @param loginUser 登录用户信息
     */
    protected abstract void storeLoginUser(String token, LoginUser loginUser);
}
