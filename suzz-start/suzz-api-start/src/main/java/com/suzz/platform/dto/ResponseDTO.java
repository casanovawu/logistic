package com.suzz.platform.dto;

import com.suzz.platform.constant.BaseExceptionCode;
import com.suzz.platform.util.StringsUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/4/23 0:35
 **/
@Getter
@Setter
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1612970957054888402L;

    @ApiModelProperty(
            value = "响应消息",
            dataType = "String",
            required = true,
            example = "操作成功"
    )
    private String message = "操作成功";
    @ApiModelProperty(
            value = "错误消息",
            dataType = "String",
            example = "错误提示信息(可选)"
    )
    private String errorMessage = "";
    @ApiModelProperty(
            value = "状态码",
            dataType = "Integer",
            required = true,
            example = "100"
    )
    private String responseCode = "200";
    @ApiModelProperty(
            value = "是否包含错误",
            dataType = "Boolean",
            required = true,
            example = "false"
    )
    private boolean hasError = false;
    @ApiModelProperty(
            value = "调用链路标识",
            dataType = "String",
            example = "bdc3731203e95044ab0b2fa0db0087f5e3ce"
    )
    private String traceId;

    public ResponseDTO() {
        this.responseCode = StringsUtil.valueOf(BaseExceptionCode.SUCCESS.getCode());
        this.message = BaseExceptionCode.SUCCESS.getMessage();
        this.hasError = false;
    }

    public void systemFail(String code, String msg, String errmsg) {
        this.hasError = true;
        this.responseCode = code;
        this.message = msg;
        this.errorMessage = errmsg;
    }
}
