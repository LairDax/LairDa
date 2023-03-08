package com.example.springboot2demo.service.impl;

import com.example.springboot2demo.entity.Curtain;
import com.example.springboot2demo.mapper.CurtainMapper;
import com.example.springboot2demo.service.CurtainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 窗帘基本信息表 服务实现类
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Service
public class CurtainServiceImpl extends ServiceImpl<CurtainMapper, Curtain> implements CurtainService {

}
