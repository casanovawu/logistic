package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeQueryListDTO implements Serializable {

    private static final long serialVersionUID = 8668330214127185395L;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer miniUserId;

}
