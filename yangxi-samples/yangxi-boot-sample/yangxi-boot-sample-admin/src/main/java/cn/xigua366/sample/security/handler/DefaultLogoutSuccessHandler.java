package cn.xigua366.sample.security.handler;

import cn.xigua366.sample.security.token.TokenStoreFactory;
import cn.xigua366.sample.security.token.LoginUser;
import com.yangxi.cloud.framework.web.context.TokenContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-11-24 16:38
 */
@Component
public class DefaultLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private TokenStoreFactory tokenStoreFactory;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 注销令牌
        Object principal = authentication.getPrincipal();
        if(principal instanceof LoginUser){
            String token = TokenContext.getToken();
            tokenStoreFactory.createTokenStore().destroyToken(token, ((LoginUser) principal));
        } else {
            super.onLogoutSuccess(request, response, authentication);
        }
    }
}
