package com.suzz.mini.dto.mgt;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarTypeMgtDTO implements Serializable {

    private Integer id;

    /**
     * 订单id
     */
    private Integer fkOrder;

    /**
     * 用车类型
     */
    private Integer carType;


    /**
     * 用车类型
     */
    private String carName;

}
