package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum SuggestEnum {

    DEALING(1,"处理中"),
    DEALED(2,"已处理"),
    CANCELED(3,"已取消");

    private Integer code;
    private String value;
}
