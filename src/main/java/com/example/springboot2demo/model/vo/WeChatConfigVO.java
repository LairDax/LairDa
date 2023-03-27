package com.example.springboot2demo.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author xnd
 * @since 2023/3/27 15:57
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wx.config")
public class WeChatConfigVO {

    @ApiModelProperty("公众号AppId")
    private String appId;

    @ApiModelProperty("公众号密钥")
    private String appSecret;
}
