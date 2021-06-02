package com.yangxi.cloud.framework.web.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <P>
 * Controller接口统一日志打印切面
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@ConditionalOnProperty(prefix = "yangxi.cloud", name = "controller-log.enable", havingValue = "true", matchIfMissing = true)
@Configuration
@Aspect
public class ControllerLogAspect {

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

        Object[] args = point.getArgs();
        List<Object> argList = null;
        if(args != null && args.length > 0) {
            argList = Arrays.stream(args).filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                    .collect(Collectors.toList());
        }


        log.info("统一日志打印(start): {}.{}() ↓ ↓ ↓ ↓ ↓,请求参数:\n{}",
                declaringTypeName, methodName, argsToString(argList));

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
            if(object != null) {
                return JSON.toJSONString(object);
            }
            return null;
        } catch (Exception e) {
            log.warn("LogAspect转换参数异常：", e);
        }
        return String.valueOf(object);
    }
}