package cn.xigua366.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * Spring MVC配置
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 登录拦截器只拦截/api/v1/pri 这样的路径，像swagger-ui、/api/v1/pub 等路径是不会去拦截的
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/*/pri/**")
                //不拦截哪些路径   斜杠一定要加
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
    }

}