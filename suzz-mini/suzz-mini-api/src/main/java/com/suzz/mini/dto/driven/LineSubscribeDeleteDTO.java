package com.suzz.mini.dto.driven;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author subo
 * @date 2022/7/4 0:00
 **/
@Data
public class LineSubscribeDeleteDTO implements Serializable {

    private static final long serialVersionUID = 6898071455260681844L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Integer id;

}
