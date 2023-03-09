package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/2 16:49
 **/
@ApiModel
@Data
public class MiniUserAuthReqDTO implements Serializable {

    private static final long serialVersionUID = 603314027066624473L;

    @ApiModelProperty(value = "openId")
    @NotNull(message = "openId不能为空")
    private String openId;

    @ApiModelProperty(value = "userName")
    private String userName;

    @ApiModelProperty(value = "union_id")
    private String union_id;

    @ApiModelProperty(value = "language")
    private String language;

    @ApiModelProperty(value = "headPic")
    private String headPic;

    @ApiModelProperty(value = "sex")
    private Integer sex;

    @ApiModelProperty(value = "type")
    private Integer type;

}
