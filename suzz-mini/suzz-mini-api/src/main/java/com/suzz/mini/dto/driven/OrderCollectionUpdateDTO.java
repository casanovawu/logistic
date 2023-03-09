package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderCollectionUpdateDTO implements Serializable {

    private static final long serialVersionUID = -3156357800314110789L;

    @ApiModelProperty(value = "关注的用户id")
    private Integer orderId;

    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "收藏状态",example = "1.收藏 0.取消收藏")
    private Integer isCollection;

}
