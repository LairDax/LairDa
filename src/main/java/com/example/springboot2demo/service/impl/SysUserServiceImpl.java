package com.example.springboot2demo.service.impl;

import com.example.springboot2demo.common.javaCommon.enums.DataEnums;
import com.example.springboot2demo.common.javaCommon.exception.DataException;
import com.example.springboot2demo.model.entity.SysUser;
import com.example.springboot2demo.mapper.SysUserMapper;
import com.example.springboot2demo.model.dto.SysUserDTO;
import com.example.springboot2demo.model.vo.SysUserVO;
import com.example.springboot2demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot2demo.common.exeirtorCommon.excel.ExcelTransfer;

import javax.servlet.http.HttpServletResponse;
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
    private ExcelTransfer<SysUserVO> excelTransfer;
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
        return sysUserMapper.getSysUserById(id);
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

    @Override
    public void exportExcel(HttpServletResponse response, SysUserDTO dto) throws ClassNotFoundException {
        List<SysUserVO> sysUserVOList = sysUserMapper.listSysUserMessage(dto);
        excelTransfer.exportExcel(response,sysUserVOList,"用户信息","sheet",SysUserVO.class);
    }
}
