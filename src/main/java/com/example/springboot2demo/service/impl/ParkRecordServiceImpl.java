package com.example.springboot2demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.springboot2demo.model.entity.ParkRecord;
import com.example.springboot2demo.mapper.ParkRecordMapper;
import com.example.springboot2demo.service.ParkRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot2demo.util.ThreadPoolProxy;
import com.example.springboot2demo.common.enums.DataEnums;
import com.example.springboot2demo.common.enums.Result;
import com.example.springboot2demo.util.excel.ExcelTransfer;
import com.example.springboot2demo.common.exception.DataException;
import lombok.extern.slf4j.Slf4j;
import com.example.springboot2demo.model.bo.packRecordBo;
import com.example.springboot2demo.model.dto.ParkRecordDownLoadDTO;
import com.example.springboot2demo.model.vo.ParkRecordDownLoadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class ParkRecordServiceImpl extends ServiceImpl<ParkRecordMapper, ParkRecord> implements ParkRecordService {

    @Autowired
    private ExcelTransfer<ParkRecord> excelTransfer;
    @Autowired
    private ThreadPoolProxy threadPoolProxy;
    @Autowired
    private ExcelTransfer<ParkRecordDownLoadVO> excelTransfers;
    @Autowired
    private ParkRecordMapper parkRecordMapper;

    /**
     * 导入
     * @param file     文件
     * @param response 返回信息
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public void importExcel(MultipartFile file, HttpServletResponse response) throws ClassNotFoundException,
            IOException {
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

    @Override
    public void exportExcel(HttpServletResponse response, ParkRecordDownLoadDTO dto) throws ClassNotFoundException {
        List<ParkRecordDownLoadVO> parkRecordDownLoadVOList = new ArrayList<>();
        int i = 1;
        int a = 1;
        int b = 1;
        if (dto.getDateTime()==null){
            throw  new DataException(DataEnums.TIME_FORMAT_MISTAKE);
        }
        //选择日期
        LocalDate dateTime = dto.getDateTime();
        //拼第一个开始时间   07:00:00 ~ 17:59:59
        LocalDateTime starTime1 = dateTime.atTime(7, 0, 0);
        LocalDateTime endTime1 = dateTime.atTime(17, 59, 59);
        //拼第二个开始时间   18:00:00 ~ 23:59:59
        LocalDateTime starTime2 = dateTime.atTime(18, 0, 0);
        LocalDateTime endTime2 = dateTime.atTime(23, 59, 59);
        //拼第三个开始时间   00:00:00 ~ 06:59:59
        LocalDateTime starTime3 = dateTime.atTime(0, 0, 0);
        LocalDateTime endTime3 = dateTime.atTime(6, 59, 59);
        ParkRecordDownLoadVO parkRecordDownLoadVO = new ParkRecordDownLoadVO();
        List<ParkRecordDownLoadVO> downLoad1 = parkRecordMapper.listDownLoad1(starTime1, endTime1);
        for (ParkRecordDownLoadVO item:downLoad1) {
          item.setNum(i++);
        }
        downLoad1.add(parkRecordDownLoadVO);
        parkRecordDownLoadVOList.addAll(downLoad1);
        List<ParkRecordDownLoadVO> downLoad2 = parkRecordMapper.listDownLoad2(starTime2, endTime2);
        for (ParkRecordDownLoadVO item:downLoad2) {
            item.setNum(a++);
        }
        downLoad2.add(parkRecordDownLoadVO);
        parkRecordDownLoadVOList.addAll(downLoad2);
        List<ParkRecordDownLoadVO> downLoad3 = parkRecordMapper.listDownLoad3(starTime3, endTime3);
        for (ParkRecordDownLoadVO item:downLoad3) {
            item.setNum(b++);
        }
        downLoad3.add(parkRecordDownLoadVO);
        parkRecordDownLoadVOList.addAll(downLoad3);
        excelTransfers.exportExcel(response, parkRecordDownLoadVOList, "三月定额", "sheet", ParkRecordDownLoadVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteDataByDateTime(ParkRecordDownLoadDTO dto) {
        if (dto.getDateTime()==null){
            throw  new DataException(DataEnums.TIME_FORMAT_MISTAKE);
        }
        return parkRecordMapper.deleteDataByDateTime(dto);
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
        String s = JSONArray.toJSON(Result.failed(errorString, 200)).toString();
        writer.write(s);
        writer.flush();
    }
}
