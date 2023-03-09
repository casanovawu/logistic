package com.suzz.mini.dto.goodsowner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 13:28
 **/
@ApiModel
@Data
public class OrderUpdateDetailDTO implements Serializable {

    private static final long serialVersionUID = -9156806059293644092L;

    @ApiModelProperty(value = "商品id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "出发城市code")
    private String departureAreaCode;

    @ApiModelProperty(value = "目的城市code")
    private String arriveAreaCode;

    @ApiModelProperty(value = "出发时间")
    private String useStartDate;

    @ApiModelProperty(value = "最小吨数")
    private String minTon;

    @ApiModelProperty(value = "最大吨数")
    private String maxTon;

    @ApiModelProperty(value = "价格方式")
    private String priceStyle;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "货运信息")
    private String goodsInfo;

    @ApiModelProperty(value = "车型")
    private List<String> cartTypeList;

}
