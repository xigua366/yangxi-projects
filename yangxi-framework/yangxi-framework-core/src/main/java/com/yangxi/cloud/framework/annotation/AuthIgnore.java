package com.yangxi.cloud.framework.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * api接口，忽略Token验证
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {

}