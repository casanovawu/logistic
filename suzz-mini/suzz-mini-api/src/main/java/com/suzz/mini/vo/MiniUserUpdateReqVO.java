package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/5/2 16:49
 **/
@ApiModel
@Data
public class MiniUserUpdateReqVO {

    @ApiModelProperty(value = "用户Id")
    @NotNull(message = "用户Id不能为空")
    private Integer miniUserId;

    @ApiModelProperty(value = "language")
    private String language;

    @ApiModelProperty(value = "type")
    private Integer type;

    @ApiModelProperty(value = "手机号")
    private String phone;

}
