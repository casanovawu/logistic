package com.suzz.mini.dto.driven;

import com.suzz.mini.annotation.Dic;
import com.suzz.mini.annotation.DicMark;
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
@DicMark
public class LineSubscribeQueryInfoDTO implements Serializable {

    private static final long serialVersionUID = -4351797463980275277L;

    @ApiModelProperty(value = "订阅id")
    private Integer id;

    @ApiModelProperty(value = "出发城市")
    @NotNull(message = "出发城市不能为空")
    private String departureAreaCode;

    @ApiModelProperty(value = "目的城市")
    private String arriveAreaCode;

    private String departureName;

    private String arriveName;

    @ApiModelProperty(value = "车型")
    @Dic(code = "car_type",target = "cartTypeNameList")
    private List<Integer> cartTypeList;

    private List<String> cartTypeNameList;

}
