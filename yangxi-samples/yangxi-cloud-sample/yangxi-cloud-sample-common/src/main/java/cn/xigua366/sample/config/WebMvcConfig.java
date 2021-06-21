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


        registry.addInterceptor(new LoginInterceptor())
                // 登录拦截器只拦截/api/v1/user 这样的路径，像/rpc/*/**、/swagger-ui等路径是不会去拦截的
                .addPathPatterns("/api/*/**")
                //不拦截像/api/v1/pub/product 这种含有/pub的路径
                .excludePathPatterns("/api/*/pub/**");
    }

}