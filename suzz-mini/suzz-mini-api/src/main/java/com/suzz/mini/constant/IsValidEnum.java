package com.suzz.mini.constant;

import com.suzz.platform.constant.BaseEnum;
import com.suzz.platform.util.EnumUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum IsValidEnum implements BaseEnum<IsValidEnum> {

    NOT_VALID(0,"无效"),
    VALID(1,"有效");

    private Integer code;

    private String name;

    public static IsValidEnum valueOf(Integer code) {
        return EnumUtils.getEnumByCode(IsValidEnum.class, code);
    }
}
