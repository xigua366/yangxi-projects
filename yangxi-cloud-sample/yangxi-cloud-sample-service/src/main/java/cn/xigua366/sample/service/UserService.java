package cn.xigua366.sample.service;

import cn.xigua366.sample.domain.request.LoginRequest;
import cn.xigua366.sample.domain.request.RegisterRequest;

/**
 * <p>
 * 用户管理服务Service接口
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public interface UserService {

    /**
     * 新增用户
     * @param registerRequest
     * @return
     */
    boolean register(RegisterRequest registerRequest);

    /**
     * 登录接口
     * @param loginRequest
     * @return token 令牌
     */
    String login(LoginRequest loginRequest);
}
