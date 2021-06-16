package cn.xigua366.sample.config;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.JsonMap;
import com.yangxi.cloud.framework.utils.JsonUtil;
import com.yangxi.cloud.framework.web.utils.CommonUtil;
import com.yangxi.cloud.framework.web.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>
 * Spring mvc全局响应结果处理器
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@Configuration
@RestControllerAdvice(basePackages = "cn.xigua366.sample")
@Order
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持advice功能
     *
     * @param returnType
     * @param converterType
     * @return true:支持  false:不支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // TODO
        // 这里要是想办法把swagger ui的 url接口地址都过滤出来，
        // 然后把swagger ui的静态资源地址都在WebMvcConfigurer组件的addResourceHandlers()方法中配置出来
        // 那么是不是这个GlobalResponseHandler组件就可以不用配置basePackages = "cn.xigua366.sample"了？
        // 然后就可以把GlobalResponseHandler组件挪动封装到yangxi-cloud-framework-web模块中去了呢？
        return true;
    }

    /**
     * 处理response的具体业务方法
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {


        if(body instanceof JsonData) {
            return body;
        }

        if(body instanceof String) {
            try {
                HttpServletResponse httpServletResponse = ServletUtils.getResponse();
                if(httpServletResponse != null) {
                    CommonUtil.sendJsonMessage(httpServletResponse, JsonData.buildSuccess(body));
                    return null;
                }
            } catch(Exception e) {
                log.warn("响应字符串对象给前端异常", e);
            }

            return JsonUtil.object2Json(JsonData.buildSuccess(body));
        }

        // 如果是返回JsonMap对象，则不进行JsonData封装
        if(body instanceof JsonMap) {
            return body;
        }

        return JsonData.buildSuccess(body);
    }
}