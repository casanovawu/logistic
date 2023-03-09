package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum SysConfigEnum {

    MINI_APP_ID("MINI_APP_ID","小程序appId"),
    MINI_APP_SECRET("MINI_APP_SECRET","小程序appSecret"),
    MINI_LOCATION_KEY("MINI_LOCATION_KEY","小程序定位key"),
    MINI_LOCATION_REFERER("MINI_LOCATION_REFERER","小程序定位referer"),
    ;

    private String key;
    private String value;
}
