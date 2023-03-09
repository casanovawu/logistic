package com.suzz.mini.vo.goodsowner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author subo
 * @date 2022/5/4 21:35
 **/
@Data
public class OrderMyPublishInfoVO  {

    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "出发地址")
    private String departureAddressName;

    @ApiModelProperty(value = "目的城市code")
    private String arriveAddressName;

    @ApiModelProperty(value = "车型名称")
    private String cartTypeListName;

    @ApiModelProperty(value = "货运信息")
    private String goodsInfo;

    @ApiModelProperty(value = "剩余时间")
    private Long remainTime;

    @ApiModelProperty(value = "价格方式")
    private Integer priceStyle;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态名称")
    private String statusName;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;


}
