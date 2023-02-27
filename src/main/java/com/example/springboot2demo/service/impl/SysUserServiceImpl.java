package com.example.springboot2demo.service.impl;

import com.example.springboot2demo.common.enums.DataEnums;
import com.example.springboot2demo.common.exception.DataException;
import com.example.springboot2demo.entity.SysUser;
import com.example.springboot2demo.mapper.SysUserMapper;
import model.dto.SysUserDTO;
import model.vo.SysUserVO;
import com.example.springboot2demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xnd
 * @since 2023-02-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUserVO> listSysUserMessage(SysUserDTO dto) {
        List<SysUserVO> sysUserVOS = sysUserMapper.listSysUserMessage(dto);
        System.out.println(sysUserVOS);
        return sysUserVOS;
    }

    @Override
    public SysUserVO getSysUserById(Long id) {
        SysUserVO sysUserVO = sysUserMapper.getSysUserById(id);
        return sysUserVO;
    }

    @Override
    public boolean saveUser(SysUser entity) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(entity, sysUser);
        boolean update = saveOrUpdate(sysUser);
        if (!update){
            throw new DataException(DataEnums.FAILED);
        }
        return update;
    }
}
