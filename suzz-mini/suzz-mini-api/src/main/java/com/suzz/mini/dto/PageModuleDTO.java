package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/15 19:55
 **/
@Data
@ApiModel
public class PageModuleDTO implements Serializable {

    private static final long serialVersionUID = -6864151615009165727L;

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;
}
