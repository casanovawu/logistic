package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suzz.mini.dto.driven.OrderLookUpdateDTO;
import lombok.Data;

import java.util.Date;

/**
 * @author subo
 * @date 2022/7/31 10:52
 **/
@Data
@TableName(value = "order_look")
public class OrderLook {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_order")
    private Integer orderId;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    private Integer num;

    private Date LookTime;

    private Date modifyTime;

    public static OrderLook toOrderLook(OrderLookUpdateDTO orderLookUpdateDTO){
        OrderLook orderLook = new OrderLook();
        orderLook.setOrderId(orderLookUpdateDTO.getOrderId());
        orderLook.setMiniUserId(orderLookUpdateDTO.getMiniUserId());
        return orderLook;

    }
}
