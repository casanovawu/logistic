package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeQueryInfoVO {

    @ApiModelProperty(value = "订阅id")
    private Integer id;

    @ApiModelProperty(value = "出发城市")
    @NotNull(message = "出发城市不能为空")
    private String departureAreaCode;

    @ApiModelProperty(value = "目的城市")
    private String arriveAreaCode;

    @ApiModelProperty(value = "目的城市")
    private List<String> cartTypeList;

    private String departureName;

    private String arriveName;

    private String cartTypeName;

}
