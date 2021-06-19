package com.yangxi.cloud.framework.web.config;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.JsonMap;
import com.yangxi.cloud.framework.utils.JsonUtil;
import com.yangxi.cloud.framework.web.utils.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.web.Swagger2Controller;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 默认的Controller全局响应结果处理增强配置
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@Configuration
@RestControllerAdvice
@Order
public class DefaultGlobalResponseBodyConfig implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持advice功能
     *
     * @param returnType
     * @param converterType
     * @return true:支持  false:不支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> declaringClass = returnType.getDeclaringClass();

        // 排除掉swagger ui的Controller
        if(declaringClass.equals(ApiResourceController.class) || declaringClass.equals(Swagger2Controller.class)) {
            return false;
        }

        // 排除掉Spring mvc内置的一些Controller
        if(declaringClass.equals(BasicErrorController.class)) {
            return false;
        }

        // more

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

        if(!selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            return body;
        }

        if(body instanceof JsonData || body instanceof JsonMap) {
            return body;
        } else if(body instanceof String) {
            try {
                HttpServletResponse httpServletResponse = ServletUtil.getResponse();
                if(httpServletResponse != null) {
                    ServletUtil.sendJsonMessage(httpServletResponse, JsonData.buildSuccess(body));
                    return null;
                }
            } catch(Exception e) {
                log.warn("响应字符串对象给前端异常", e);
            }

            return JsonUtil.object2Json(JsonData.buildSuccess(body));
        }

        return JsonData.buildSuccess(body);
    }
}