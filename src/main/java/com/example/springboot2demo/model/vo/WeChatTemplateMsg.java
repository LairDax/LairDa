package com.example.springboot2demo.model.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xnd
 * @since 2023/3/27 16:34
 */
@Data
@ToString
public class WeChatTemplateMsg {
    /**
     * 消息
     */
    private String value;
    /**
     * 消息颜色
     */
    private String color;


    public WeChatTemplateMsg(String value) {
        this.value = value;
        this.color = "#173177";
    }

    public WeChatTemplateMsg(String value, String color) {
        this.value = value;
        this.color = color;
    }

}
