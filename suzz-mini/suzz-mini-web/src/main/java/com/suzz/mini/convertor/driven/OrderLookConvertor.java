package com.suzz.mini.convertor.driven;

import com.suzz.mini.dto.driven.OrderLookUpdateDTO;
import com.suzz.mini.vo.driven.OrderLookUpdateVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/8/7 14:54
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderLookConvertor {

    public static OrderLookUpdateDTO convertoToOrderLookUpdateDTO(OrderLookUpdateVO orderLookUpdateVO){
        OrderLookUpdateDTO orderLookUpdateDTO = new OrderLookUpdateDTO();
        orderLookUpdateDTO.setOrderId(orderLookUpdateVO.getOrderId());
        orderLookUpdateDTO.setMiniUserId(orderLookUpdateVO.getMiniUserId());
        return orderLookUpdateDTO;
    }
}
