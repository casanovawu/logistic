package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchDetailQueryVO {

    @ApiModelProperty(value = "订单id")
    @NotBlank(message = "发布id不能为空")
    private Integer orderId;

    @ApiModelProperty(value = "用户id")
    @NotBlank(message = "用户id不能为空")
    private Integer miniUserId;

}
