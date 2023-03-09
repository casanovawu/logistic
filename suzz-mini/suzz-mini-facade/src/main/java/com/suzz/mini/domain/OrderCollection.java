package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.suzz.mini.constant.IsValidEnum;
import com.suzz.mini.dto.driven.OrderCollectionUpdateDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/7/31 10:52
 **/
@Data
@TableName(value = "order_collection")
public class OrderCollection  {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_order")
    private Integer orderId;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    /**
     * 数据有效状态
     * 对应表中的 isValid 字段
     */
    @TableLogic(value = "1",delval = "0")
    private Integer isValid;

    @TableField(exist = false)
    private Integer isCollection;

    public static OrderCollection toOrderCollection(OrderCollectionUpdateDTO orderCollectionUpdateDTO){
        OrderCollection orderCollection = new OrderCollection();
        orderCollection.setOrderId(orderCollectionUpdateDTO.getOrderId());
        orderCollection.setMiniUserId(orderCollectionUpdateDTO.getMiniUserId());
        orderCollection.setIsCollection(orderCollectionUpdateDTO.getIsCollection());
        orderCollection.setIsValid(IsValidEnum.VALID.getCode());
        return orderCollection;
    }

}
