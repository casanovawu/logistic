package com.suzz.mini.vo.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class MiniUserFocusUpdateVO {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id为空")
    private Integer miniUserId;

    @ApiModelProperty(value = "关注的用户id")
    @NotNull(message = "关注的用户id为空")
    private Integer miniUserFocusId;

    @ApiModelProperty(value = "关注状态",example = "1.关注 0.取消关注")
    @NotNull(message = "关注状态为空")
    private Integer isFocus;

}
