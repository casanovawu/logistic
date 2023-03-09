package com.suzz.mini.domain;


import lombok.Data;

/**
 * order_car_type
 * @author 
 */
@Data
public class OrderCarType  {

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