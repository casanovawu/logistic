package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeUpdateDTO implements Serializable {

    private static final long serialVersionUID = 5325441698556450262L;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "id不能为空")
    private Integer id;

    @ApiModelProperty(value = "出发城市")
    @NotNull(message = "出发城市不能为空")
    private String departureAreaCode;

    @ApiModelProperty(value = "目的城市")
    private String arriveAreaCode;

    @ApiModelProperty(value = "目的城市")
    private List<Integer> cartTypeList;

}
