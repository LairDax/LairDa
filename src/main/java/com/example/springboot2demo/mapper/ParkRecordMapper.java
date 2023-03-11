package com.example.springboot2demo.mapper;

import com.example.springboot2demo.entity.ParkRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
