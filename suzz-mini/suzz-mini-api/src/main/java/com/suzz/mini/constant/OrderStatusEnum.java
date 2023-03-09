package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    AUDITING(1, "审核中"),
    ONLINE(2, "已上架"),
    OFFLINE(3, "已下架"),
    REFUSE(4, "审核拒绝");

    private final Integer code;
    private final String value;
}
