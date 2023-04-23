package com.example.springboot2demo.common.exeirtorCommon.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author xnd
 * @since 2023/2/26 9:38
 */
public class HttpUtils {
    private HttpUtils() {

    }

    /**
     * 获取请求头中的某个参数
     */
    public static String getRequestHeaderInfo(String parameter) {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest()
                .getHeader(parameter);
    }

}
