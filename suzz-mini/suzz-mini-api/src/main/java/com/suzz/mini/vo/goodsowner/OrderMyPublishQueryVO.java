package com.suzz.mini.vo.goodsowner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/4 21:35
 **/
@Data
@ApiModel
public class OrderMyPublishQueryVO {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer miniUserId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    private String sort;

}
