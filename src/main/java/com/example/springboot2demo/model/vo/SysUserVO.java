package com.example.springboot2demo.model.vo;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/2/18 15:07
 */
@Data
@ApiModel
public class SysUserVO {
    @ApiModelProperty("姓名")
    @ExcelProperty(value = "姓名", index = 0)
    @TableField("name")
    @ColumnWidth(20)
    private String name;

    @ApiModelProperty("密码")
    @ExcelProperty(value = "密码", index = 1)
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("昵称")
    @ExcelProperty(value = "昵称", index = 2)
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("身份证号")
    @ExcelProperty(value = "身份证号", index = 3)
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("性别")
    @ExcelProperty(value = "性别", index = 4)
    @ColumnWidth(20)
    @TableField("sex")
    private String sex;

    @ApiModelProperty("联系方式")
    @ExcelProperty(value = "联系方式", index = 5)
    @TableField("tel")
    private String tel;
}
