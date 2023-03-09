package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderCollectionUpdateVO {

    @ApiModelProperty(value = "关注的用户id")
    @NotNull(message = "任务id为空")
    private Integer orderId;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id为空")
    private Integer miniUserId;

    @ApiModelProperty(value = "收藏状态",example = "1.收藏 0.取消收藏")
    @NotNull(message = "收藏状态为空")
    private Integer isCollection;

}
