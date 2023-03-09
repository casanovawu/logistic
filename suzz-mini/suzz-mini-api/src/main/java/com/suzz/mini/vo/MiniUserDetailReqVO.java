package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/2 16:49
 **/
@ApiModel
@Data
public class MiniUserDetailReqVO {

    @ApiModelProperty(value = "用户Id")
    @NotNull(message = "用户Id不能为空")
    private Integer miniUserId;

}
