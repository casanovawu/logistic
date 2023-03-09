package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderLookUpdateVO {

    @ApiModelProperty(value = "关注的用户id")
    @NotNull(message = "任务id为空")
    private Integer orderId;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id为空")
    private Integer miniUserId;

}
