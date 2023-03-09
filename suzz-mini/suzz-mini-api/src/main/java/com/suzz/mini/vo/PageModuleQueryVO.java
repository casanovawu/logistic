package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/15 19:28
 **/
@Data
@ApiModel
public class PageModuleQueryVO {

    @ApiModelProperty(value = "页面id")
    private Integer pageId;
}
