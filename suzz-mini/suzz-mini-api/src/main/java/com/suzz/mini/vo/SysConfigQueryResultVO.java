package com.suzz.mini.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;


/**
 * @author subo
 * @date 2022-08-18 11:13
 **/
@Data
public class SysConfigQueryResultVO {

    @ApiModelProperty(value = "配置信息")
    private Map<String,String> sysConfigMap;
}
