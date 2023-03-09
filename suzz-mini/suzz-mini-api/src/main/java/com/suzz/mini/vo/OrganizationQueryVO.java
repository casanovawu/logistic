package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author subo
 * @date 2022/5/15 17:28
 **/
@Data
@ApiModel
public class OrganizationQueryVO  {

    @ApiModelProperty(value = "语言")
    private String lang;
}
