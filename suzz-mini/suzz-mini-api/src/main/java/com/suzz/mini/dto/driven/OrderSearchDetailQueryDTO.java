package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchDetailQueryDTO implements Serializable {

    private static final long serialVersionUID = 1153355851315868495L;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    private Integer miniUserId;

}
