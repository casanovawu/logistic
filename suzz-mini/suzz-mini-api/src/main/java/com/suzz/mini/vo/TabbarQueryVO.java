package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/21 22:14
 **/
@ApiModel
@Data
public class TabbarQueryVO {

    private Integer miniUserType;

    private String lang;

}
