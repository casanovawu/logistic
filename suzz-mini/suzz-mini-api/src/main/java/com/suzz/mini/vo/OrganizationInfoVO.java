package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author subo
 * @date 2022/5/15 17:29
 **/
@Data
@ApiModel
public class OrganizationInfoVO{

    @ApiModelProperty(value = "城市")
    private Map<Integer,String> city_list;

    @ApiModelProperty(value = "区域")
    private Map<Integer,String> county_list;

    @ApiModelProperty(value = "省份")
    private Map<Integer,String> province_list;
}
