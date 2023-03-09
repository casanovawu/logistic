package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeDeleteVO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Integer id;

}
