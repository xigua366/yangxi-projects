package ${package}.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * <P>
 * 统一日志打印切面
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void logAop() {
    }

    @Around("logAop()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        MethodSignature signature = (MethodSignature) point.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        log.info("统一日志打印(start): {}.{}() ↓ ↓ ↓ ↓ ↓,请求参数:\n{}",
                declaringTypeName, methodName, argsToString(point.getArgs()));

        Object response = null;

        try {
            //执行该方法
            response = point.proceed();
        } finally {
            stopWatch.stop();

            log.info("统一日志打印(end): {}.{}() ↑ ↑ ↑ ↑ ↑,响应时间:{}毫秒,响应内容:\n{}",
                    declaringTypeName, methodName, stopWatch.getTotalTimeMillis(), argsToString(response));
        }

        return response;
    }

    private String argsToString(Object object) {
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            log.error("LogAspect转换参数异常：", e);
        }
        return String.valueOf(object);
    }
}