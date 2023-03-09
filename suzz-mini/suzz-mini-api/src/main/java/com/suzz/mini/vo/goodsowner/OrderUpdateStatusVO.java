package com.suzz.mini.vo.goodsowner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/4 13:28
 **/
@ApiModel
@Data
public class OrderUpdateStatusVO {

    @ApiModelProperty(value = "发布id")
    private Integer id;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
