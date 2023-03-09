package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchQueryVO {

    @ApiModelProperty(value = "出发城市code")
    private String departureAreaCode;

    @ApiModelProperty(value = "目的城市code")
    private String arriveAreaCode;

    @ApiModelProperty(value = "最小吨数")
    private String minTon;

    @ApiModelProperty(value = "最大吨数")
    private String maxTon;

    @ApiModelProperty(value = "最小价格")
    private String minPrice;

    @ApiModelProperty(value = "最大价格")
    private String maxPrice;

    @ApiModelProperty(value = "出发时间")
    private String useStartDate;

    @ApiModelProperty(value = "截止时间")
    private String useEndDate;

    @ApiModelProperty(value = "关键词")
    private String keyword;

    @ApiModelProperty(value = "收藏查询")
    private Integer isCollection;

    @ApiModelProperty(value = "收藏查询")
    private Integer miniUserId;

    @ApiModelProperty(value = "车型")
    private List<String> cartTypeList;
}
