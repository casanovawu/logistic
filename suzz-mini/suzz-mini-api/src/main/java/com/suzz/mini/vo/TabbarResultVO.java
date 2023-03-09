package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/21 22:14
 **/
@ApiModel
@Data
@AllArgsConstructor
public class TabbarResultVO {

    private String url;

    private String text;

    private String normal;

    private String active;

}
