package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022-08-18 11:15
 **/
@Data
@ApiModel
public class SysConfigDeleteDTO implements Serializable {

    private static final long serialVersionUID = 2109990535830265958L;

    @ApiModelProperty(value = "参数名")
    private String paramKey;
}
