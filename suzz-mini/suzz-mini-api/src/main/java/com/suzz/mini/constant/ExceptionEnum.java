package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/20 1:58
 **/
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    DEPARTURE_CITY_NOT_SELECTED("departure_city_not_selected","出发城市未填选");


    private String code;
    private String name;
}
