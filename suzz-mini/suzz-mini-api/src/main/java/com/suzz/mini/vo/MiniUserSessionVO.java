package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/15 18:45
 **/
@Data
@ApiModel
public class MiniUserSessionVO {

    @ApiModelProperty(value = "用户openId")
    private String openId;

    @ApiModelProperty(value = "用户unionId")
    private String unionId;

    @ApiModelProperty(value = "用户sessionKey")
    private String sessionKey;
}
