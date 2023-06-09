package com.example.springboot2demo.mapper;

import com.example.springboot2demo.model.entity.Curtain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 窗帘基本信息表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-04-13
 */
@Mapper
public interface CurtainMapper extends BaseMapper<Curtain> {

}
