package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderCollectionQueryDTO implements Serializable {

    private static final long serialVersionUID = 7351780527937985472L;
        
    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "是否收藏",example = "1.收藏")
    private Integer isCollection;
}
