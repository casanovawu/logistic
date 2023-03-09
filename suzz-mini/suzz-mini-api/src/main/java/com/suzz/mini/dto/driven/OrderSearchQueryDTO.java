package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchQueryDTO implements Serializable {

    private static final long serialVersionUID = -2993853056325033411L;

    @ApiModelProperty(value = "出发城市code")
    private Integer departureAreaCode;

    @ApiModelProperty(value = "目的城市code")
    private Integer arriveAreaCode;

    @ApiModelProperty(value = "最小吨数")
    private Integer minTon;

    @ApiModelProperty(value = "最大吨数")
    private Integer maxTon;

    @ApiModelProperty(value = "最小价格")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "最大价格")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "出发时间")
    private Date useStartDate;

    @ApiModelProperty(value = "截止时间")
    private Date useEndDate;

    @ApiModelProperty(value = "关键词")
    private String keyword;

    @ApiModelProperty(value = "语言")
    private String lang;

    @ApiModelProperty(value = "收藏查询")
    private Integer isCollection;

    @ApiModelProperty(value = "收藏查询")
    private Integer miniUserId;

    @ApiModelProperty(value = "车型")
    private List<Integer> cartTypeList;
}
