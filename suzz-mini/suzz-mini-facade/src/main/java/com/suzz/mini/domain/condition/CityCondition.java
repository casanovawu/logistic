package com.suzz.mini.domain.condition;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:26
 **/
@Getter
@Builder
public class CityCondition {

    private List<Integer> provinceIds;

    private Integer code;

    private Integer areaCode;

    private Integer provinceId;

    private String lang;
}
