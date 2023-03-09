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
public enum IsLocationEnum implements BaseEnum<IsLocationEnum> {

    NOTLOCATION(0,"不定位"),
    LOCATION(1,"定位");

    private Integer code;

    private String name;

    public static IsLocationEnum valueOf(Integer code) {
        return EnumUtils.getEnumByCode(IsLocationEnum.class, code);
    }
}
