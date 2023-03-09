package com.suzz.platform.vo.response;

import com.suzz.platform.constant.BaseExceptionCode;
import com.suzz.platform.dto.EmptyData;
import com.suzz.platform.dto.ResponseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author subo
 * @date 2022/4/23 8:51
 **/
@Getter
@Setter
public class SimpleResponse<T> extends ResponseDTO {

    private static final long serialVersionUID = -3714371768319108123L;

    @ApiModelProperty(
            value = "返回参数",
            required = true
    )
    @Getter
    private T data;

    public SimpleResponse(T data) {
        this.data = data;
    }

    public static <T> SimpleResponse<T> of(T data) {
        return new SimpleResponse<>(data);
    }

    public static SimpleResponse<EmptyData> ofEmpty() {
        return new SimpleResponse<>(EmptyData.getInstance());
    }

    public String toString() {
        return "SimpleResponse(data=" + this.getData() + ")";
    }

    public SimpleResponse() {
    }

    public static <T> SimpleResponse<T> error(String code, String meg) {
        SimpleResponse<T> simpleResponse = new SimpleResponse<>();
        simpleResponse.systemFail(code, meg, meg);
        return simpleResponse;
    }

    public static <T> SimpleResponse<T> sysError() {
        return error(BaseExceptionCode.SYSTEM_ERROR);
    }

    public static <T> SimpleResponse<T> error(BaseExceptionCode exceptionCode) {
        return error(exceptionCode.getCode().toString(), exceptionCode.getMessage());
    }
}
