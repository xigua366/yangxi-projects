package cn.xigua366.sample.security;

import cn.xigua366.sample.security.configurer.TokenAuthenticationConfigurer;
import cn.xigua366.sample.security.encoder.MyPasswordEncoder;
import cn.xigua366.sample.security.filter.TenantFilter;
import cn.xigua366.sample.security.handler.DefaultAccessDeniedHandlerImpl;
import cn.xigua366.sample.security.handler.DefaultAuthenticationFailureHandler;
import cn.xigua366.sample.security.handler.DefaultAuthenticationSuccessHandler;
import cn.xigua366.sample.security.handler.DefaultLogoutSuccessHandler;
import cn.xigua366.sample.security.service.DefaultUserDetailsServiceImpl;
import cn.xigua366.sample.security.token.store.TokenStore;
import cn.xigua366.sample.security.token.TokenStoreFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-09-20 20:31
 */
@EnableConfigurationProperties(SecurityProperties.class)
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler;

    @Autowired
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;

    @Autowired
    private DefaultLogoutSuccessHandler defaultLogoutSuccessHandler;

    @Autowired
    private DefaultAccessDeniedHandlerImpl defaultAccessDeniedHandler;

    @Autowired
    private TokenStoreFactory tokenStoreFactory;

    @Autowired
    private DefaultUserDetailsServiceImpl defaultUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @Bean
    public TenantFilter tenantFilter() {
        return new TenantFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(defaultUserDetailsService).addObjectPostProcessor(new ObjectPostProcessor<AbstractUserDetailsAuthenticationProvider>() {

            @Override
            public <O extends AbstractUserDetailsAuthenticationProvider> O postProcess(O object) {
                // DaoAuthenticationProvider对象自定义后置处理
                object.setHideUserNotFoundExceptions(false);
                return object;
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();

        // 表单登录
        http.formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/login/form")
                .successHandler(defaultAuthenticationSuccessHandler)
                .failureHandler(defaultAuthenticationFailureHandler);


        // TODO 其它登录方式，比如手机号码+验证码， openid等

        // 基于token令牌认证
        configTokenAuthentication(http);

        // 自定义上下文信息处理过滤器
        http.addFilterBefore(tenantFilter(), UsernamePasswordAuthenticationFilter.class);

        // 退出登录
        http.logout().logoutSuccessHandler(defaultLogoutSuccessHandler);


        // 放行登录请求
        http.authorizeRequests().antMatchers( "/loginPage", "/login/form", "/logout").permitAll();

        // 基于数据库的权限配置
        http.authorizeRequests().anyRequest().access("@dbAuthorityChecker.check(authentication, request)");

        // 鉴权不通过处理
//        http.exceptionHandling().authenticationEntryPoint(defaultAuthenticationEntryPoint);
        http.exceptionHandling().accessDeniedHandler(defaultAccessDeniedHandler);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略swagger-ui相关请求
        web.ignoring().antMatchers("/swagger-ui/**", "/webjars/**", "/v2/**", "/swagger-resources/**");
    }

    /**
     * 基于token令牌的认证配置
     *
     * @param http
     * @throws Exception
     */
    private void configTokenAuthentication(HttpSecurity http) throws Exception {
        TokenStore tokenStore = tokenStoreFactory.createTokenStore();
        TokenAuthenticationConfigurer tokenAuthenticationConfigurer = new TokenAuthenticationConfigurer(defaultAuthenticationFailureHandler, tokenStore);
        http.apply(tokenAuthenticationConfigurer);
    }

}
