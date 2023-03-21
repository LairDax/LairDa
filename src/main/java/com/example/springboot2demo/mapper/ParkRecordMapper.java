package com.example.springboot2demo.mapper;

import com.example.springboot2demo.entity.ParkRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.dto.ParkRecordDownLoadDTO;
import model.vo.ParkRecordDownLoadVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 停车记录表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Mapper
public interface ParkRecordMapper extends BaseMapper<ParkRecord> {

    /**
     * 获取日期,查询对应的停车缴费记录
     * @param starTime
     * @param endTime
     * @return
     */
    List<ParkRecordDownLoadVO> listDownLoad1(
            @Param("starTime") LocalDateTime starTime, @Param("endTime") LocalDateTime endTime);

    /**
     * 获取日期,查询对应的停车缴费记录
     * @param starTimeTwo
     * @param endTimeTwo
     * @return
     */
    List<ParkRecordDownLoadVO> listDownLoad2(@Param("starTimeTwo")LocalDateTime starTimeTwo,
                                             @Param("endTimeTwo")  LocalDateTime endTimeTwo);

    /**
     * 获取日期,查询对应的停车缴费记录
     * @param starTime3
     * @param endTime3
     * @return
     */
    List<ParkRecordDownLoadVO> listDownLoad3(@Param("starTimeThree")LocalDateTime starTime3,
                                             @Param("endTimeThree")LocalDateTime endTime3);

    /**
     * 根据出口时间删除对应停车记录
     * @param dto
     * @return
     */
    boolean deleteDataByDateTime(@Param("deleteDTO") ParkRecordDownLoadDTO dto);
}
