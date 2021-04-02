package ${package}.service;

import ${package}.domain.request.LoginRequest;
import ${package}.domain.request.RegisterRequest;

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