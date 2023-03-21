package com.example.springboot2demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 窗帘基本信息表
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Getter
@Setter
@TableName("curtain")
@ApiModel(value = "Curtain对象", description = "窗帘基本信息表")
@EqualsAndHashCode
public class Curtain extends BaseEntity {

    @ApiModelProperty("窗帘单品id")
      @TableId("curtain_id")
    private Long curtainId;

    @ApiModelProperty("窗帘编号")
    @TableField("curtain_code")
    private String curtainCode;

    @ApiModelProperty("窗帘名称")
    @TableField("curtain_name")
    private String curtainName;
}
