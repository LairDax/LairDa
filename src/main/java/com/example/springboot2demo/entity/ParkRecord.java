package com.example.springboot2demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot2demo.config.BaseEntity;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 停车记录表
 * </p>
 *
 * @author xnd
 * @since 2023-03-08
 */
@Getter
@Setter
@TableName("park_record")
@ApiModel(value = "ParkRecord对象", description = "停车记录表")
public class ParkRecord extends BaseEntity {

    @ApiModelProperty("停车记录id")
      @TableId("park_record_id")
    private Long parkRecordId;

    @ApiModelProperty("车牌号码")
    @TableField("license_number")
    private String licenseNumber;

    @ApiModelProperty("停车场组名称")
    @TableField("park_group_name")
    private String parkGroupName;

    @ApiModelProperty("进入时间")
    @TableField("entry_time")
    private LocalDateTime entryTime;

    @ApiModelProperty("出门时间")
    @TableField("departure_time")
    private LocalDateTime departureTime;

    @ApiModelProperty("进口通过")
    @TableField("in_door")
    private String inDoor;

    @ApiModelProperty("出口通过")
    @TableField("out_door")
    private String outDoor;

    @ApiModelProperty("进门方式")
    @TableField("in_door_way")
    private String inDoorWay;

    @ApiModelProperty("出门方式")
    @TableField("out_door_way")
    private String outDoorWay;

    @ApiModelProperty("车牌获取方式")
    @TableField("recording_mode")
    private String recordingMode;

    @ApiModelProperty("支付方式")
    @TableField("pay_way")
    private String payWay;

    @ApiModelProperty("停留")
    @TableField("remain")
    private String remain;

    @ApiModelProperty("停留时长")
    @TableField("duration_stay")
    private String durationStay;

    @ApiModelProperty("值班人员")
    @TableField("watch_keeper")
    private String watchKeeper;

    @ApiModelProperty("总计费")
    @TableField("total_billing")
    private String totalBilling;

    @ApiModelProperty("线下应缴")
    @TableField("offline_payable")
    private String offlinePayable;

    @ApiModelProperty("线上支付")
    @TableField("online_payable")
    private String onlinePayable;

    @ApiModelProperty("抵扣")
    @TableField("deduction")
    private String deduction;

    @ApiModelProperty("减免")
    @TableField("derate")
    private String derate;

    @ApiModelProperty("抵扣")
    @TableField("deduction_two")
    private String deductionTwo;

    @ApiModelProperty("红冲")
    @TableField("red_flush")
    private String redFlush;

    @ApiModelProperty("在库状态")
    @TableField("car_state")
    private String carState;
}
