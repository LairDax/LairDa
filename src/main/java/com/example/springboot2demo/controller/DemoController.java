package com.example.springboot2demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xnd
 * @since 2023/3/8 11:40
 */
@Api(tags = "测试用例")
@RestController
@Slf4j
@RequestMapping("/test")
public class DemoController {
}
