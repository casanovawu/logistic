package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderCollectionQueryVO {

    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "是否收藏",example = "1.收藏")
    private Integer isCollection;
}
