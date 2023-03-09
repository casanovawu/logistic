package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class OrderSearchDetailInfoDTO implements Serializable {

    private static final long serialVersionUID = -4602255211207641430L;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "订单用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "headPic")
    private String headPic;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "是否关注",example = "1.关注 0.未关注")
    private Integer isFocus;

    @ApiModelProperty(value = "是否收藏",example = "1.收藏 0.未收藏")
    private Integer isCollection;

    @ApiModelProperty(value = "使用开始时间")
    private Date useStartDate;

    @ApiModelProperty(value = "出发地址")
    private String departureAddressName;

    @ApiModelProperty(value = "目的城市")
    private String arriveAddressName;

    @ApiModelProperty(value = "车型名称")
    private String cartTypeListName;

    @ApiModelProperty(value = "价格方式")
    private Integer priceStyle;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "货运信息")
    private String goodsInfo;

    @ApiModelProperty(value = "最大吨位")
    private Integer maxTon;

    @ApiModelProperty(value = "最小吨位")
    private Integer minTon;

    @ApiModelProperty(value = "纬度")
    private String loadLatitude;

    @ApiModelProperty(value = "经度")
    private String loadLongitude;

    @ApiModelProperty(value = "详细地址")
    private String loadAddress;

    @ApiModelProperty(value = "纬度")
    private String unloadLatitude;

    @ApiModelProperty(value = "经度")
    private String unloadLongitude;

    @ApiModelProperty(value = "详细地址")
    private String unloadAddress;

    private Integer isLoadLocation;

    private Integer isUnloadLocation;

}
