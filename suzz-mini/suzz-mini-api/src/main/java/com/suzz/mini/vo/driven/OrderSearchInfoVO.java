package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchInfoVO {

    @ApiModelProperty(value = "orderId")
    private Integer orderId;

    @ApiModelProperty(value = "headPic")
    private String headPic;

    @ApiModelProperty(value = "出发地址")
    private String departureAddressName;

    @ApiModelProperty(value = "目的城市")
    private String arriveAddressName;

    @ApiModelProperty(value = "车型名称")
    private String cartTypeListName;

    @ApiModelProperty(value = "使用开始时间")
    private String useStartDate;

    @ApiModelProperty(value = "价格方式")
    private Integer priceStyle;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "发布时间")
    private String publishTime;

    @ApiModelProperty(value = "查看人数")
    private Integer lookNumber;

}
