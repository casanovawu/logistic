package com.suzz.platform.vo.request;

import com.suzz.platform.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/4/23 0:24
 **/
@Getter
@Setter
public class SimpleRequest <T> extends RequestDTO {

    private static final long serialVersionUID = 8259039733730440370L;

    @ApiModelProperty(value = "请求参数", required = true)
    @Valid
    @NotNull(message = "请求参数不能为空")
    private T reqDtos;

    public SimpleRequest(T reqDtos) {
        this.reqDtos = reqDtos;
    }

    public static <T> SimpleRequest<T> of(T reqDtos) {
        return new SimpleRequest(reqDtos);
    }

    public SimpleRequest() {
    }
}
