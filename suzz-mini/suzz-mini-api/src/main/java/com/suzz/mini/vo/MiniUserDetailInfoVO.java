package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/2 14:19
 **/
@Data
@ApiModel
public class MiniUserDetailInfoVO {

    @ApiModelProperty(value = "用户Id")
    private Integer miniUserId;

    /**
     * 语言
     */
    @ApiModelProperty(value = "语言")
    private String language;

    @ApiModelProperty(value = "语言名称")
    private String languageName;

    /**
     * 1.司机 2货主
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "用户头像")
    private String headUrl;

    @ApiModelProperty(value = "手机号")
    private String phone;
}
