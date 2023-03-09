package com.suzz.mini.dto.goodsowner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 13:28
 **/
@ApiModel
@Data
public class OrderUpdateStatusDTO implements Serializable {

    private static final long serialVersionUID = 4846827696211149103L;

    @ApiModelProperty(value = "发布id")
    private Integer id;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
