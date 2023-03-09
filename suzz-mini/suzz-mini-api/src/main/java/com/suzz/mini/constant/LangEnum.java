package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum LangEnum {

    CHINESE("chinese","中文"),
    ENGLISH("english","维语"),
    ;

    private String code;

    private String name;

}
