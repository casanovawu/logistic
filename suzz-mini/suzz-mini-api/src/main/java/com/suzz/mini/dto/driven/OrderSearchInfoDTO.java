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
public class OrderSearchInfoDTO implements Serializable {

    private static final long serialVersionUID = -3842431354945023600L;

    @ApiModelProperty(value = "orderId")
    private Integer orderId;

    @ApiModelProperty(value = "headPic")
    private String headPic;

    @ApiModelProperty(value = "出发地址")
    private String departureAddressName;

    @ApiModelProperty(value = "目的城市code")
    private String arriveAddressName;

    @ApiModelProperty(value = "车型")
    private List<Integer> cartTypeList;

    @ApiModelProperty(value = "车型名称")
    private List<String> cartTypeListName;

    @ApiModelProperty(value = "使用开始时间")
    private Date useStartDate;

    @ApiModelProperty(value = "价格方式")
    private Integer priceStyle;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "查看人数")
    private Integer lookNumber;

}
