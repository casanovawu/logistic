package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeQueryDetailDTO implements Serializable {

    private static final long serialVersionUID = 2283627048862430190L;

    @ApiModelProperty(value = "id")
    private Integer id;

}
