package com.example.springboot2demo.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/2/18 15:05
 */
@Data
public class SysUserDTO {
    @ApiModelProperty("姓名")
    private String name;
}
