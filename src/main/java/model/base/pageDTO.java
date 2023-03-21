package model.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/3/21 10:58
 */
@Data
public class pageDTO {
    private Integer pageSize;

    private Integer pageNum;

    @JsonIgnore
    public IPage<Object> getPage() {
        return com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO.of(pageNum, pageSize);
    }
}
