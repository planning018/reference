package com.planning.tool;

import org.apache.commons.lang3.StringUtils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * 时间处理工具类
 *
 * @author yxc
 * @since 2020-12-11 9:21
 **/
public class DateUtils {

    /**
     * date 转 YYYY/MM/dd
     *
     * @param dateTime
     * @return
     */
    public static String dateConvertYYYYMmDd(Long dateTime) {
        if (Objects.isNull(dateTime)) {
            return StringUtils.EMPTY;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        return formatter.format(new Date(dateTime).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}