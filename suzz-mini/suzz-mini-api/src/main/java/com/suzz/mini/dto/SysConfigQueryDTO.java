package com.suzz.mini.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022-08-18 11:15
 **/
@Data
@ApiModel
public class SysConfigQueryDTO implements Serializable {

    private static final long serialVersionUID = 8692880174424175612L;

    @ApiModelProperty(value = "参数名")
    private List<String> keyList;
}
