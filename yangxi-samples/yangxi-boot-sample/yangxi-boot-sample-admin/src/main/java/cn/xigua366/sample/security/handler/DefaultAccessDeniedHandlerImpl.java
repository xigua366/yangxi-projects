package cn.xigua366.sample.security.handler;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.web.utils.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-11-24 19:06
 */
@Slf4j
@Component
public class DefaultAccessDeniedHandlerImpl extends AccessDeniedHandlerImpl {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String requestUri = request.getRequestURI();

        log.error("登录认证失败", accessDeniedException);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        JsonData<String> jsonData = JsonData.buildError("访问{" + requestUri + "}权限不足，请联系管理员");
        ServletUtil.sendJsonMessage(response, jsonData);
    }
}
