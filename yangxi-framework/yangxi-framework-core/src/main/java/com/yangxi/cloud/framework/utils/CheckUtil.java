package com.yangxi.cloud.framework.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yangxi.cloud.framework.exception.BaseBizException;
import com.yangxi.cloud.framework.exception.BaseErrorCodeEnum;
import com.yangxi.cloud.framework.exception.CommonErrorCodeEnum;

import java.util.Collection;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <P>
 * 参数检查工具方法
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
public class CheckUtil {


    /**
     * 邮箱正则
     */
    private static final Pattern MAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

    /**
     * 手机号正则
     */
    private static final Pattern PHONE_PATTERN = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    /**
     * 是否是邮箱
     * @param email
     * @return
     */
    public static  boolean isEmail(String email) {
        if (null == email || "".equals(email)) {
            return false;
        }
        Matcher m = MAIL_PATTERN.matcher(email);
        return m.matches();
    }

    /**
     * 是否是手机号码
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (null == phone || "".equals(phone)) {
            return false;
        }
        Matcher m = PHONE_PATTERN.matcher(phone);
        return m.matches();
    }

    /**
     * 检查普通对象是否为空
     * @param object
     * @throws BaseBizException
     */
    public static void checkObjectNonNull(Object object) throws BaseBizException {
        if (Objects.isNull(object)) {
            throw new BaseBizException(CommonErrorCodeEnum.SERVER_ILLEGAL_ARGUMENT_ERROR);
        }
    }

    /**
     * 检查普通对象是否为空
     * @param object
     * @param baseErrorCodeEnum 自定义错误码与提示
     * @param arguments
     * @throws BaseBizException
     */
    public static void checkObjectNonNull(Object object, BaseErrorCodeEnum baseErrorCodeEnum, Object... arguments) throws BaseBizException {
        if (Objects.isNull(object)) {
            throw new BaseBizException(baseErrorCodeEnum.getCode(), baseErrorCodeEnum.getMsg(), arguments);
        }
    }

    /**
     * 检查字符串入参对象是否为空
     * @param str
     * @throws BaseBizException
     */
    public static void checkStringNonEmpty(String str) throws BaseBizException {
        if (StringUtils.isBlank(str)) {
            throw new BaseBizException(CommonErrorCodeEnum.SERVER_ILLEGAL_ARGUMENT_ERROR);
        }
    }

    /**
     * 检查字符串入参对象是否为空
     * @param str
     * @param baseErrorCodeEnum 自定义错误码与提示
     * @param arguments
     * @throws BaseBizException
     */
    public static void checkStringNonEmpty(String str, BaseErrorCodeEnum baseErrorCodeEnum, Object... arguments) throws BaseBizException {
        if (StringUtils.isBlank(str)) {
            throw new BaseBizException(baseErrorCodeEnum.getCode(), baseErrorCodeEnum.getMsg(), arguments);
        }
    }

    /**
     * 检查集合入参对象是否为空
     * @param collection
     * @throws BaseBizException
     */
    public static void checkCollectionNonEmpty(Collection<?> collection) throws BaseBizException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseBizException(CommonErrorCodeEnum.SERVER_ILLEGAL_ARGUMENT_ERROR);
        }
    }

    /**
     * 检查集合入参对象是否为空
     * @param collection
     * @param baseErrorCodeEnum 自定义错误码与提示
     * @param arguments
     * @throws BaseBizException
     */
    public static void checkCollectionNonEmpty(Collection<?> collection, BaseErrorCodeEnum baseErrorCodeEnum, Object... arguments) throws BaseBizException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseBizException(baseErrorCodeEnum.getCode(), baseErrorCodeEnum.getMsg(), arguments);
        }
    }

}