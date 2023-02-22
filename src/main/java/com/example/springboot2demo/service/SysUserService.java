package com.example.springboot2demo.service;

import com.example.springboot2demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot2demo.model.dto.SysUserDTO;
import com.example.springboot2demo.model.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xnd
 * @since 2023-02-18
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 获取所有用户信息
     * @return
     */
     List<SysUserVO> listSysUserMessage(SysUserDTO dto);

    /**
     * 根据用户id获取当前人信息
     * @param id
     * @return
     */
    SysUserVO getSysUserById(Long id);
}
