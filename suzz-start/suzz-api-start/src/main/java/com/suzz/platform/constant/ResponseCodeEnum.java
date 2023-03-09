package com.suzz.platform.constant;

public enum ResponseCodeEnum {

    ERROR("500"),
    SUCCESS("0"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    ResponseCodeEnum(String code) {
        this.code = code;
    }
}
