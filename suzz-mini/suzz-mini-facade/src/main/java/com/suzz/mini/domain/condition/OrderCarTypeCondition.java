package com.suzz.mini.domain.condition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 22:03
 **/
@Getter
@Setter
@Builder
public class OrderCarTypeCondition {

    private Integer orderId;

    private List<Integer> orderIds;
}
