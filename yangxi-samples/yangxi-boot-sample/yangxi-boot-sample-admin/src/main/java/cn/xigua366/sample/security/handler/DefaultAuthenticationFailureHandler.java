package cn.xigua366.sample.security.handler;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.web.utils.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证失败处理器
 * @author yangxi
 * @version 1.0
 * @date 2020-11-20 15:34
 */
@Slf4j
@Component
public class DefaultAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.error("登录认证失败", exception);
        ServletUtil.sendJsonMessage(response, JsonData.buildError(exception.getMessage()));
    }

}
