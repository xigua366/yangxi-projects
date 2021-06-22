package cn.xigua366.sample.security.filter;

import cn.xigua366.sample.security.token.store.TokenStore;
import cn.xigua366.sample.security.token.LoginUser;
import com.yangxi.cloud.framework.web.constants.WebConstant;
import com.yangxi.cloud.framework.web.context.TokenContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于令牌的认证处理过滤器
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 12:10
 */
@Slf4j
public class TokenFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private TokenStore tokenStore;

    public TokenFilter(AuthenticationFailureHandler authenticationFailureHandler, TokenStore tokenStore) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.tokenStore = tokenStore;
    }

    private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(WebConstant.TOKEN);
        if(token == null || "".equals(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            // 解析token
            LoginUser userInfo = tokenStore.parseToken(token);
            if(userInfo != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userInfo, null, AuthorityUtils.NO_AUTHORITIES);
                setDetails(request, authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // 设置到token到上下文
                TokenContext.setToken(token);
            }
        } catch (Exception e) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, new BadCredentialsException(e.getMessage(), e));
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void setDetails(HttpServletRequest request,
                              UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
