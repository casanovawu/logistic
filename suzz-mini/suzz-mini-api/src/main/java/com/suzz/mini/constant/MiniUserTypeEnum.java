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
public enum MiniUserTypeEnum implements BaseEnum<MiniUserTypeEnum> {

    DRIVEN(1,"司机"),
    GOODS_OWNER(2,"货主");

    private Integer code;

    private String name;

    public static MiniUserTypeEnum valueOf(Integer code) {
        return EnumUtils.getEnumByCode(MiniUserTypeEnum.class, code);
    }
}
