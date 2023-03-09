package com.suzz.platform.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2019-10-31 11:01
 */
@Getter
@AllArgsConstructor(access= AccessLevel.PRIVATE)
public enum SystemProfileEnum {

    DEV("dev"),
    UAT("uat"),
    PRD("prd");

    private String value;
}
