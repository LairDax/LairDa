package com.example.springboot2demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot2demo.entity.SysUser;
import model.dto.SysUserDTO;
import model.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xnd
 * @since 2023-02-18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取所有用户信息
     * @return
     */
    List<SysUserVO> listSysUserMessage(@Param("dto") SysUserDTO dto);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    SysUserVO getSysUserById(@Param("id")Long id);
}
