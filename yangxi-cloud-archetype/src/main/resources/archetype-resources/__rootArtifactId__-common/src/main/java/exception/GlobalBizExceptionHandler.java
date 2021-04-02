package ${package}.exception;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局业务异常处理器
 * @author yangxi
 **/
@Slf4j
@RestControllerAdvice
public class GlobalBizExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonData<Object> handle(Exception e) {

        if(e instanceof BizException) {
            log.error("[ 业务异常 ]", e);
            BizException bizException = (BizException) e;
            return JsonData.buildError(bizException.getCode(), bizException.getMsg());
        } else {
            log.error("[ 系统异常 ]", e);
            return JsonData.buildError("全局异常，未知错误");
        }

    }

}