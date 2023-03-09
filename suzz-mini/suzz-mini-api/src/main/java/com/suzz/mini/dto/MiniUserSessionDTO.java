package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/2 14:19
 **/
@Data
@ApiModel
public class MiniUserSessionDTO implements Serializable {

    private static final long serialVersionUID = -7927696646558905335L;

    @ApiModelProperty(value = "用户openId")
    private String openId;

    @ApiModelProperty(value = "用户unionId")
    private String unionId;

    @ApiModelProperty(value = "用户sessionKey")
    private String sessionKey;
}
