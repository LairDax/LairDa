package com.example.springboot2demo.model.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xnd
 * @since 2023/3/21 10:57
 */
@Data
public class PageDateDTO {
    private Integer pageNum;
    private Integer pageSize;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime starTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    @JsonIgnore
    public IPage<Object> getPage() {
        return com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO.of(pageNum, pageSize);
    }
}
