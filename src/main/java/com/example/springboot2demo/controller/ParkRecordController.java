package com.example.springboot2demo.controller;

import com.example.springboot2demo.service.ParkRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 停车记录表 前端控制器
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Api(tags = "停车记录导入导出")
@Slf4j
@RestController
@RequestMapping("/parkRecord")
public class ParkRecordController {
    @Autowired
    private ParkRecordService parkRecordService;

    @ApiOperation("停车记录导入")
    @PostMapping("/importExcel")
    public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws ClassNotFoundException,
            IOException {
        parkRecordService.importExcel(file, response);
    }

    @ApiOperation("停车记录模板下载")
    @GetMapping("/exportExcelDemo")
    public void exportExcelDemo(HttpServletResponse response) throws ClassNotFoundException {
        parkRecordService.exportExcelDemo(response);
    }
}
