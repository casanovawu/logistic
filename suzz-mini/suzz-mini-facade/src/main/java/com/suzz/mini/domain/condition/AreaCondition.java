package com.suzz.mini.domain.condition;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:39
 **/
@Getter
@Builder
public class AreaCondition {

    private List<Integer> cityIds;

    private String lang;

    private Integer code;
}
