package cn.xigua366.sample.exception;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.exception.BaseBizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义统一业务异常处理器
 *
 * @author yangxi
 * @version 1.0
 **/
@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyBizExceptionHandler {

    /**
     * 系统自定义业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseBizException.class)
    public JsonData<Object> handle(BaseBizException e) {
        log.error("[ 业务异常 ]", e);
        return JsonData.buildError(e.getCode(), e.getMsg());
    }

}