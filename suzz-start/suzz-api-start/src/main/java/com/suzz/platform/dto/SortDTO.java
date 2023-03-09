package com.suzz.platform.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/2 15:47
 **/
@ApiModel
@Getter
@Setter
public class SortDTO implements Serializable {

    private static final long serialVersionUID = -355421183672206108L;
    @ApiModelProperty(
            value = "排序字段",
            dataType = "String",
            example = "createTime"
    )
    private String sortField;
    @ApiModelProperty(
            value = "排序方式",
            dataType = "String",
            example = "asc"
    )
    private String sortType;

    public String toString() {
        return "SortDTO(sortField=" + this.getSortField() + ", sortType=" + this.getSortType() + ")";
    }
}
