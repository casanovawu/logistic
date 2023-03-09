package com.suzz.mini.dto.goodsowner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/25 11:17
 **/
@Data
public class OrderPublishDetailQueryDTO implements Serializable {

    private static final long serialVersionUID = -888150548017249191L;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;
}
