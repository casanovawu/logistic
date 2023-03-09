package com.suzz.mini.convertor.driven;

import com.suzz.mini.dto.driven.OrderCollectionUpdateDTO;
import com.suzz.mini.vo.driven.OrderCollectionUpdateVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/8/7 1:22
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCollectionConvertor {

    public static OrderCollectionUpdateDTO convertoToOrderCollectionUpdateDTO(OrderCollectionUpdateVO orderCollectionUpdateVO){
        OrderCollectionUpdateDTO orderCollectionUpdateDTO = new OrderCollectionUpdateDTO();
        orderCollectionUpdateDTO.setOrderId(orderCollectionUpdateVO.getOrderId());
        orderCollectionUpdateDTO.setMiniUserId(orderCollectionUpdateVO.getMiniUserId());
        orderCollectionUpdateDTO.setIsCollection(orderCollectionUpdateVO.getIsCollection());
        return orderCollectionUpdateDTO;
    }
}
