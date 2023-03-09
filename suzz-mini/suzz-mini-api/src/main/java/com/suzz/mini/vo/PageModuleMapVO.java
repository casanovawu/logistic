package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author subo
 * @date 2022/5/15 19:19
 **/
@Data
@ApiModel
public class PageModuleMapVO {

    @ApiModelProperty(value = "页面组件名称")
    private Map<String,String> pageModuleMap;
}
