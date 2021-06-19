package com.yangxi.cloud.framework.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import java.lang.reflect.Type;

/**
 * <p>
 * 默认的Controller全局响应结果处理增强组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
@Order
public class GlobalRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // TODO

        log.info("默认的Controller全局响应结果处理增强配置，methodParameter:" + methodParameter + "， targetType:" + targetType + ", converterType:" + converterType);

        // just test config and do nothing

        return false;
    }
}