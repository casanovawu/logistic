package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
@Getter
@AllArgsConstructor
public enum OrderCartTypeEnum {

    FLAT(1,"平板"),
    HIGH_HURDLE(2,"高栏"),
    VAN_TYPE(3,"厢式"),
    CONTAINER(4,"集装箱"),
   DUMP(5,"自卸"),
    COLD_STORAGE(6,"冷藏"),
    HEAT_PRESERVATION(7,"保温"),
    HIGH_AND_LOW_BOARD(8,"高低板"),
    VAN(9,"面包车"),
    QUILT_CART(10,"棉被车"),
    LADDER_CAR(11,"爬梯车"),
    FLYING_WING_VEHICLE(12,"飞翼车"),
    IVECO(13,"依维柯"),
    CRANE(14,"吊车"),
            ;

    private Integer code;
    private String value;
}
