package com.example.springboot2demo.service;

import com.example.springboot2demo.entity.ParkRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot2demo.model.dto.ParkRecordDownLoadDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 停车记录表 服务类
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
public interface ParkRecordService extends IService<ParkRecord> {

    /**
     * 文件导入
     * 停车记录导入
     * @param file     文件
     * @param response 返回信息
     * @throws ClassNotFoundException 实体类未找到
     */
    void importExcel(MultipartFile file, HttpServletResponse response) throws ClassNotFoundException, IOException;

    /**
     * 文件导出模板
     *
     * @param response 返回信息
     * @throws ClassNotFoundException 实体类未找到
     */
    void exportExcelDemo(HttpServletResponse response)throws ClassNotFoundException;

    /**
     * 定额报表导出
     *
     * @param response
     * @param dto
     */
    void exportExcel(HttpServletResponse response, ParkRecordDownLoadDTO dto)throws ClassNotFoundException;

    /**
     * 根据出口时间删除对应停车记录
     * @param dto
     * @return
     */
    boolean deleteDataByDateTime(ParkRecordDownLoadDTO dto);
}
