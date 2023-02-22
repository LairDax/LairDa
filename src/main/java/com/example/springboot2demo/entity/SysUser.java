package com.example.springboot2demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot2demo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xnd
 * @since 2023-02-18
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户表")
public class SysUser extends BaseEntity {

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("身份证号")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("联系方式")
    @TableField("tel")
    private String tel;
}
