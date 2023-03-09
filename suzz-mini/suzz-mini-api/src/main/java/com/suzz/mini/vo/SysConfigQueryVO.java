package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author subo
 * @date 2022-08-18 11:15
 **/
@Data
@ApiModel
public class SysConfigQueryVO {

    @ApiModelProperty(value = "参数名")
    private List<String> keyList;
}
