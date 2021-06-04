package com.yangxi.cloud.framework.web.converter;

import com.yangxi.cloud.framework.constants.CoreConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>
 * 字符串格式的日期转换器
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if("".equals(source)) {
            return null;
        }

        // 如果是yyyy-MM-dd格式
        if(source.length() == 10) {
            LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern(CoreConstant.DATE_FORMAT_PATTERN));
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            return Date.from(zonedDateTime.toInstant());
        }

        // 如果是yyyy-MM-dd HH:mm:ss格式
        LocalDateTime localDateTime = LocalDateTime.parse(source, DateTimeFormatter.ofPattern(CoreConstant.DATE_TIME_FORMAT_PATTERN));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}