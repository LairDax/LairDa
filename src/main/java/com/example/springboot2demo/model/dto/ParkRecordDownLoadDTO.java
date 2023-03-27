package com.example.springboot2demo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author xnd
 * @since 2023/3/21 10:53
 */
@Data
public class ParkRecordDownLoadDTO {
    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate dateTime;
}
