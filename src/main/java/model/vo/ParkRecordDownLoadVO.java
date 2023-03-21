package model.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/3/21 11:22
 */
@Data
@ColumnWidth(value = 20) // 列宽
public class ParkRecordDownLoadVO {
    @ApiModelProperty("序号")
    @ExcelProperty(value = "序号", index = 0)
    private Integer num;

    @ApiModelProperty("日期")
    @ExcelProperty(value = "日期", index = 1)
    private String dateTime;

    @ApiModelProperty("出口通过")
    @ExcelProperty(value = "出口通过", index = 2)
    private String outDoor;

    @ApiModelProperty("应缴总计")
    @ExcelProperty(value = "应缴总计", index = 3)
    private String totalBilling;

    @ApiModelProperty("门岗应缴")
    @ExcelProperty(value = "门岗应缴", index = 4)
    private String offlinePayable;
}
