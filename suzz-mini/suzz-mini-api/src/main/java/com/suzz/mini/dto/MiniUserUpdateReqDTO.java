package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022-08-08 20:02
 **/
@ApiModel
@Data
public class MiniUserUpdateReqDTO implements Serializable {

    private static final long serialVersionUID = -6085729685241305463L;

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
