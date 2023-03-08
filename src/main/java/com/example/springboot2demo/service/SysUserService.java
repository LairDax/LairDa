package com.example.springboot2demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot2demo.entity.SysUser;
import model.dto.SysUserDTO;
import model.vo.SysUserVO;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 添加用户信息
     * @param entity
     * @return
     */
    boolean saveUser(SysUser entity);

    /**
     * 导出用户信息
     * @param response
     */
    void exportExcel(HttpServletResponse response, SysUserDTO dto) throws ClassNotFoundException;
}
