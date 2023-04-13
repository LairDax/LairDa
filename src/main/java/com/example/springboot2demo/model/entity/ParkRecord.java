package com.example.springboot2demo.model.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot2demo.model.base.BaseEntity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 停车记录表
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Data
@TableName("park_record")
@Accessors(chain = false)
@ApiModel(value = "ParkRecord对象", description = "停车记录表")
public class ParkRecord extends BaseEntity {

    @ApiModelProperty("停车记录id")
    @TableId(value = "park_record_id",type = IdType.AUTO)
    private Long parkRecordId;

    @ApiModelProperty("车牌号码")
    @TableField("license_number")
    @ExcelProperty("车牌号码")
    private String licenseNumber;

    @ApiModelProperty("停车场组名称")
    @TableField("park_group_name")
    @ExcelProperty("停车场组名称")
    private String parkGroupName;

    @ApiModelProperty("进入时间")
    @TableField("entry_time")
    @ExcelProperty("进入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime entryTime;

    @ApiModelProperty("出门时间")
    @TableField("departure_time")
    @ExcelProperty("出门时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime departureTime;

    @ApiModelProperty("进口通过")
    @TableField("in_door")
    @ExcelProperty("进口通过")
    private String inDoor;

    @ApiModelProperty("出口通过")
    @TableField("out_door")
    @ExcelProperty("出口通过")
    private String outDoor;

    @ApiModelProperty("进门方式")
    @TableField("in_door_way")
    @ExcelProperty("进门方式")
    private String inDoorWay;

    @ApiModelProperty("出门方式")
    @TableField("out_door_way")
    @ExcelProperty("出门方式")
    private String outDoorWay;

    @ApiModelProperty("车牌获取方式")
    @TableField("recording_mode")
    @ExcelProperty("车牌获取方式")
    private String recordingMode;

    @ApiModelProperty("支付方式")
    @TableField("pay_way")
    @ExcelProperty("支付方式")
    private String payWay;

    @ApiModelProperty("停留")
    @TableField("remain")
    @ExcelProperty("停留")
    private String remain;

    @ApiModelProperty("停留时长")
    @TableField("duration_stay")
    @ExcelProperty("停留时长")
    private String durationStay;

    @ApiModelProperty("值班人员")
    @TableField("watch_keeper")
    @ExcelProperty("值班人员")
    private String watchKeeper;

    @ApiModelProperty("总计费")
    @TableField("total_billing")
    @ExcelProperty("总计费")
    private String totalBilling;

    @ApiModelProperty("线下应缴")
    @TableField("offline_payable")
    @ExcelProperty("线下应缴")
    private String offlinePayable;

    @ApiModelProperty("线上支付")
    @TableField("online_payable")
    @ExcelProperty("线上支付")
    private String onlinePayable;

    @ApiModelProperty("抵扣")
    @TableField("deduction")
    @ExcelProperty("抵扣")
    private String deduction;

    @ApiModelProperty("减免")
    @TableField("derate")
    @ExcelProperty("减免")
    private String derate;

    @ApiModelProperty("抵扣")
    @TableField("deduction_two")
    @ExcelProperty("抵扣")
    private String deductionTwo;

    @ApiModelProperty("红冲")
    @TableField("red_flush")
    @ExcelProperty("红冲")
    private String redFlush;

    @ApiModelProperty("在库状态")
    @TableField("car_state")
    @ExcelProperty("在库状态")
    private String carState;
}
