package com.example.springboot2demo.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/3/27 13:45
 */
@Data
public class WeChatVO {
    @ApiModelProperty("微信开放id")
    private String openId;

    private String token;
}
