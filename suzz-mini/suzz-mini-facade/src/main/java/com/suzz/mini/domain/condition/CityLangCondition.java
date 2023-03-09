package com.suzz.mini.domain.condition;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:26
 **/
@Builder
@Getter
public class CityLangCondition {

    private List<Integer> cityIds;

    private String lang;
}
