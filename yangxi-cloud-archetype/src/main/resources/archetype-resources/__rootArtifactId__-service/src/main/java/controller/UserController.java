package ${package}.controller;

import com.yangxi.cloud.framework.annotation.AuthIgnore;
import com.yangxi.cloud.framework.core.JsonData;
import ${package}.domain.request.LoginRequest;
import ${package}.domain.request.RegisterRequest;
import ${package}.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员用户管理
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param registerRequest
     * @return
     */
    @AuthIgnore
    @PostMapping("register")
    public JsonData<Boolean> register(@RequestBody RegisterRequest registerRequest) {
        boolean result = userService.register(registerRequest);
        return JsonData.buildSuccess(result);
    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @AuthIgnore
    @PostMapping("login")
    public JsonData<String> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return JsonData.buildSuccess(token);
    }

}