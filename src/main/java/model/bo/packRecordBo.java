package model.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/3/9 9:03
 */
@Data
public class packRecordBo {
    @ExcelProperty("车牌号码")
    private String licenseNumber;

    @ExcelProperty("停车场组名称")
    private String packGroupName;

    @ExcelProperty("进入时间")
    private LocalDateTime entryTime;

    @ExcelProperty("出门时间")
    private LocalDateTime departureTime;

    @ExcelProperty("进口通过")
    private String inDoor;

    @ExcelProperty("出口通过")
    private String outDoor;

    @ExcelProperty("进门方式")
    private String inDoorWay;

    @ExcelProperty("出门方式")
    private String outDoorWay;

    @ExcelProperty("车牌获取方式")
    private String recordingMode;

    @ExcelProperty("支付方式")
    private String payWay;

    @ExcelProperty("停留")
    private String remain;

    @ExcelProperty("停留时长")
    private String durationStay;

    @ExcelProperty("值班人员")
    private String watchKeeper;

    @ExcelProperty("总计费")
    private String totalBilling;

    @ExcelProperty("线下应缴")
    private String offlinePayable;

    @ExcelProperty("线上支付")
    private String onlinePayable;

    @ExcelProperty("抵扣")
    private String deduction;

    @ExcelProperty("减免")
    private String derate;

    @ExcelProperty("抵扣")
    private String deductionTwo;

    @ExcelProperty("红冲")
    private String redFlush;

    @ExcelProperty("在库状态")
    private String carState;
}
