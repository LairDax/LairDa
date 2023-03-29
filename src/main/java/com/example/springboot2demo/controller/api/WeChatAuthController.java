package com.example.springboot2demo.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xnd
 * @since 2023/3/27 13:47
 */
@Slf4j
@Api(tags = "微信开放Api")
@RestController
@RequestMapping("")
public class WeChatAuthController {

    @GetMapping("/MP_verify_DZcAbTjXNzdrQaVW.txt")
    @ApiOperation("auth")
    public String getAuth() {
        return "DZcAbTjXNzdrQaVW";
    }




}
