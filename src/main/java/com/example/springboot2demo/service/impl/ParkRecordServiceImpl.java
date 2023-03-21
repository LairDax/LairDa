package com.example.springboot2demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springboot2demo.config.BaseEntity;
import com.example.springboot2demo.entity.ParkRecord;
import com.example.springboot2demo.mapper.ParkRecordMapper;
import com.example.springboot2demo.service.ParkRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.enums.Result;
import com.example.springboot2demo.util.excel.ExcelTransfer;
import lombok.extern.slf4j.Slf4j;
import model.bo.packRecordBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * <p>
 * 停车记录表 服务实现类
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Slf4j
@Service
public  class ParkRecordServiceImpl extends ServiceImpl<ParkRecordMapper, ParkRecord> implements ParkRecordService {

    @Autowired
    private ExcelTransfer<ParkRecord> excelTransfer;

    /**
     * 导入
     * @param file     文件
     * @param response 返回信息
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public void importExcel(MultipartFile file, HttpServletResponse response) throws ClassNotFoundException, IOException {
        long size = file.getSize();
        String excel = excelTransfer.importExcel(file, this, list -> {
            ArrayList<ParkRecord> arrayList = new ArrayList<>();
            list.forEach(e -> {
                if (StringUtils.isNotBlank(e.getLicenseNumber())) {
                    arrayList.add(e);
                }
            });
            return arrayList;
        });
        failed(response, excel);
        log.info(String.valueOf(size));
    }

    /**
     * 下载模板
     * @param response 返回信息
     * @throws ClassNotFoundException
     */
    @Override
    public void exportExcelDemo(HttpServletResponse response) throws ClassNotFoundException {
        excelTransfer.exportExcel(response, new ArrayList<>(), "停车记录表", "sheet", packRecordBo.class);
    }

    /**
     * 过滤器返回信息
     *
     * @param response  response
     * @throws IOException io失败
     */
    public void failed(HttpServletResponse response, String errorString) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //设置响应状态码
        response.setStatus(HttpServletResponse.SC_OK);
        //输入响应内容
        PrintWriter writer = response.getWriter();
        String s = JSONArray.toJSON(Result.failed(errorString,200)).toString();
        writer.write(s);
        writer.flush();
    }
}
