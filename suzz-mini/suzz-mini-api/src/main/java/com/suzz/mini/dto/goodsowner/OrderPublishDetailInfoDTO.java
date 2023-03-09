package com.suzz.mini.dto.goodsowner;

import com.suzz.mini.annotation.Dic;
import com.suzz.mini.annotation.DicMark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 21:35
 **/
@Data
@DicMark
public class OrderPublishDetailInfoDTO implements Serializable {

    private static final long serialVersionUID = -4226457804223669489L;

    @ApiModelProperty(value = "出发区域")
    private String departureAreaCode;

    @ApiModelProperty(value = "到达区域")
    private String arriveAreaCode;

    @ApiModelProperty(value = "出发地址")
    private String departureAddressName;

    @ApiModelProperty(value = "目的城市code")
    private String arriveAddressName;

    @ApiModelProperty(value = "车型")
    @Dic(code = "car_type",target = "cartTypeListName")
    private List<Integer> cartTypeList;

    @ApiModelProperty(value = "车型名称")
    private List<String> cartTypeListName;

    @ApiModelProperty(value = "货运信息")
    private String goodsInfo;

    @ApiModelProperty(value = "价格方式")
    private Integer priceStyle;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "使用开始时间")
    private String useStartDate;

    @ApiModelProperty(value = "最大吨位")
    private Integer maxTon;

    @ApiModelProperty(value = "最小吨位")
    private Integer minTon;

    @ApiModelProperty(value = "状态")
    private Integer status;

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
