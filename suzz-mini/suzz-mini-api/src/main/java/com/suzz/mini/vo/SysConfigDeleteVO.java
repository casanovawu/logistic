package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author subo
 * @date 2022-08-18 11:15
 **/
@Data
@ApiModel
public class SysConfigDeleteVO {

    @ApiModelProperty(value = "参数名")
    @NotBlank(message = "参数名不能为空")
    private String paramKey;
}
