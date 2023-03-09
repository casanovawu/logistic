package com.suzz.mini.dto.goodsowner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/4 21:35
 **/
@Data
public class OrderMyPublishQueryDTO implements Serializable {

    private static final long serialVersionUID = -4226457804223669489L;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer miniUserId;

    private Integer status;

    private String sort;

}
