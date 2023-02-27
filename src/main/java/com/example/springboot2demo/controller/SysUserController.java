package com.example.springboot2demo.controller;

import com.example.springboot2demo.common.enums.Result;
import com.example.springboot2demo.entity.SysUser;
import model.dto.SysUserDTO;
import model.vo.SysUserVO;
import com.example.springboot2demo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xnd
 * @since 2023-02-18
 */
@Api(tags = "用户信息管理")
@RestController
@Slf4j
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/listSysUserMessage")
    @ApiOperation("获取所有用户信息")
    public Result<List<SysUserVO>> listSysUserMessage(@RequestBody SysUserDTO dto) {
        return Result.success(sysUserService.listSysUserMessage(dto));
    }

    @GetMapping("/getSysUserById")
    @ApiOperation("根据id获取对应用户信息")
    public Result<SysUserVO> getSysUserById(Long id) {
        return Result.success(sysUserService.getSysUserById(id));
    }

    @PostMapping("/saveUser")
    @ApiOperation("新增用户信息")
    public Result<Boolean> saveUser(@RequestBody SysUser entity){
        return Result.success(sysUserService.saveUser(entity));
    }

}
