package com.suzz.platform.constant;

import com.suzz.platform.util.EnumUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日志类型枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LogTypeEnum {

    CUSTOMER(1, "人工日志"),
    SYSTEM(2, "系统日志"),
    ;

    private Integer code;

    private String value;

    public static LogTypeEnum valueOf(Integer code) {
        return EnumUtil.valueOfDefaultField(LogTypeEnum.class, code);
    }

}
