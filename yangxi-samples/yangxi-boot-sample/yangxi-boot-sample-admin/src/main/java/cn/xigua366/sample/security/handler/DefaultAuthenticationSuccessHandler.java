package cn.xigua366.sample.security.handler;

import cn.xigua366.sample.security.service.MyUserDetails;
import cn.xigua366.sample.security.token.TokenStoreFactory;
import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.web.utils.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证成功处理器
 * @author yangxi
 * @version 1.0
 * @date 2020-11-20 15:28
 */
@Component
public class DefaultAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private TokenStoreFactory tokenStoreFactory;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String token = tokenStoreFactory.createTokenStore().createToken((MyUserDetails)authentication.getPrincipal());
        ServletUtil.sendJsonMessage(response, JsonData.buildSuccess(token));
    }
}
