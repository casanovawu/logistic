package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum PriceStyleEnum {

    PRICE(1,"价格"),
    PHONE(2,"电议");

    private Integer code;
    private String value;
}
