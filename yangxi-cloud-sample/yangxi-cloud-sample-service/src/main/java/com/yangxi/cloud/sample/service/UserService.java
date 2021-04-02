package com.yangxi.cloud.sample.service;

import com.yangxi.cloud.sample.domain.request.LoginRequest;
import com.yangxi.cloud.sample.domain.request.RegisterRequest;

/**
 * 用户管理服务Service接口
 * @author yangxi
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
