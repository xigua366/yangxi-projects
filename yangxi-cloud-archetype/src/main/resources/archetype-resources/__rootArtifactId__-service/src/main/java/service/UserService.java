package ${package}.service;

import ${package}.domain.request.LoginRequest;
import ${package}.domain.request.RegisterRequest;

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