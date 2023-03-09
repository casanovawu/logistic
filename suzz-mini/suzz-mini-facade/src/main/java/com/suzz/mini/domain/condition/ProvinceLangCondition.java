package com.suzz.mini.domain.condition;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:05
 **/
@Builder
@Getter
public class ProvinceLangCondition {

    private List<Integer> provinceIds;

    private String Lang;
}
