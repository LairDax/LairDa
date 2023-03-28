package com.example.springboot2demo.controller.api;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot2demo.model.vo.WeChatConfigVO;
import com.example.springboot2demo.model.vo.WeChatTemplateMsg;
import com.example.springboot2demo.model.vo.WeChatVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xnd
 * @since 2023/3/27 13:47
 */
@Slf4j
@Api(tags = "微信开放Api")
@RestController
@RequestMapping("")
public class WeChatController {

    @GetMapping("/MP_verify_DZcAbTjXNzdrQaVW.txt")
    @ApiOperation("auth")
    public String getAuth() {
        return "DZcAbTjXNzdrQaVW";
    }




}
