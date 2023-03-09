package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class MiniUserFocusUpdateDTO implements Serializable {

    private static final long serialVersionUID = 3020401172558453859L;

    @ApiModelProperty(value = "用户id")
    private Integer miniUserId;

    @ApiModelProperty(value = "关注的用户id")
    private Integer miniUserFocusId;

    @ApiModelProperty(value = "关注",example = "1.关注 0.取消关注")
    private Integer isFocus;

}
