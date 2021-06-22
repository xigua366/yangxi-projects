package cn.xigua366.sample.security.configurer;

import cn.xigua366.sample.security.filter.TokenFilter;
import cn.xigua366.sample.security.token.store.TokenStore;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 令牌认证配置Configurer组件
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-25 19:40
 */
public class TokenAuthenticationConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private TokenStore tokenStore;

    public TokenAuthenticationConfigurer(AuthenticationFailureHandler authenticationFailureHandler, TokenStore tokenStore) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        TokenFilter tokenFilter = new TokenFilter(authenticationFailureHandler, tokenStore);
        http.addFilterAfter(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
