package com.example.springboot2demo.common.exeirtorCommon.util;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xnd
 * @since 2023/4/20 11:05
 */
@Data
@Component
public class JwtUtils {
    private String header = "token";
    /** 发起者*/
    private String issuer = "khby";

    /**
     * 生成token
     * @param subject 加密字符
     * @param expire 时长
     * @param secret 密钥
     * @return token
     */


}
