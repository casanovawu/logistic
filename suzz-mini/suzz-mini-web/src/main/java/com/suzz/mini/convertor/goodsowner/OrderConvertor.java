package com.suzz.mini.convertor.goodsowner;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.goodsowner.*;
import com.suzz.mini.vo.goodsowner.*;
import com.suzz.platform.util.StringsUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;


/**
 * @author subo
 * @date 2022/5/15 18:55
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConvertor {

    public static OrderMyPublishQueryDTO convertorToOrderMyPublishQueryDTO(OrderMyPublishQueryVO orderPublishVO){
        OrderMyPublishQueryDTO orderMyPublishQueryDTO = new OrderMyPublishQueryDTO();
        orderMyPublishQueryDTO.setMiniUserId(orderPublishVO.getMiniUserId());
        orderMyPublishQueryDTO.setStatus(orderPublishVO.getStatus());
        orderMyPublishQueryDTO.setSort(orderPublishVO.getSort());
        return orderMyPublishQueryDTO;
    }

    public static OrderPublishDTO convertorToOrderPublishDTO(OrderPublishVO orderPublishVO){
        OrderPublishDTO orderPublishDTO = new OrderPublishDTO();
        orderPublishDTO.setMiniUserId(orderPublishVO.getMiniUserId());
        orderPublishDTO.setDepartureAreaCode(orderPublishVO.getDepartureAreaCode());
        orderPublishDTO.setArriveAreaCode(orderPublishVO.getArriveAreaCode());
        orderPublishDTO.setUseStartDate(orderPublishVO.getUseStartDate());
        orderPublishDTO.setMinTon(orderPublishVO.getMinTon());
        orderPublishDTO.setMaxTon(orderPublishVO.getMaxTon());
        orderPublishDTO.setPriceStyle(orderPublishVO.getPriceStyle());
        orderPublishDTO.setPrice(orderPublishVO.getPrice());
        orderPublishDTO.setGoodsInfo(orderPublishVO.getGoodsInfo());
        if(CollUtil.isNotEmpty(orderPublishVO.getCartTypeList())){
            orderPublishDTO.setCartTypeList(orderPublishVO.getCartTypeList().stream().map(Integer::valueOf).collect(Collectors.toList()));
        }
        orderPublishDTO.setLoadLatitude(orderPublishVO.getLoadLatitude());
        orderPublishDTO.setLoadLongitude(orderPublishVO.getLoadLongitude());
        orderPublishDTO.setLoadAddress(orderPublishVO.getLoadAddress());
        orderPublishDTO.setUnloadLatitude(orderPublishVO.getUnloadLatitude());
        orderPublishDTO.setUnloadLongitude(orderPublishVO.getUnloadLongitude());
        orderPublishDTO.setUnloadAddress(orderPublishVO.getUnloadAddress());
        return orderPublishDTO;
    }

    public static OrderMyPublishInfoVO convertorToOrderMyPublishInfoDTO(OrderMyPublishInfoDTO orderMyPublishInfoDTO){
        OrderMyPublishInfoVO orderMyPublishInfoVO = new OrderMyPublishInfoVO();
        orderMyPublishInfoVO.setMiniUserId(orderMyPublishInfoDTO.getMiniUserId());
        orderMyPublishInfoVO.setDepartureAddressName(orderMyPublishInfoDTO.getDepartureAddressName());
        orderMyPublishInfoVO.setArriveAddressName(orderMyPublishInfoDTO.getArriveAddressName());
        if(CollUtil.isNotEmpty(orderMyPublishInfoDTO.getCartTypeListName())){
            String cartTypeListName = String.join(",", orderMyPublishInfoDTO.getCartTypeListName());
            orderMyPublishInfoVO.setCartTypeListName(cartTypeListName);
        }
        orderMyPublishInfoVO.setGoodsInfo(orderMyPublishInfoDTO.getGoodsInfo());
        orderMyPublishInfoVO.setRemainTime(orderMyPublishInfoDTO.getRemainTime());
        orderMyPublishInfoVO.setStatusName(orderMyPublishInfoDTO.getStatusName());
        orderMyPublishInfoVO.setStatus(orderMyPublishInfoDTO.getStatus());
        orderMyPublishInfoVO.setPriceStyle(orderMyPublishInfoDTO.getPriceStyle());
        orderMyPublishInfoVO.setPrice(orderMyPublishInfoDTO.getPrice());
        orderMyPublishInfoVO.setOrderId(orderMyPublishInfoDTO.getOrderId());
        return orderMyPublishInfoVO;
    }

    public static OrderPublishDetailQueryDTO convertorToOrderPublishDetailQueryVO(OrderPublishDetailQueryVO orderPublishDetailQueryVO){
        OrderPublishDetailQueryDTO orderPublishDetailQueryDTO = new OrderPublishDetailQueryDTO();
        orderPublishDetailQueryDTO.setOrderId(orderPublishDetailQueryVO.getOrderId());
        return orderPublishDetailQueryDTO;
    }

    public static OrderPublishDetailInfoVO convertorToOrderPublishDetailInfoVO(OrderPublishDetailInfoDTO orderPublishDetailInfoDTO){
        OrderPublishDetailInfoVO orderPublishDetailInfoVO = new OrderPublishDetailInfoVO();
        orderPublishDetailInfoVO.setDepartureAreaCode(orderPublishDetailInfoDTO.getDepartureAreaCode());
        orderPublishDetailInfoVO.setArriveAreaCode(orderPublishDetailInfoDTO.getArriveAreaCode());
        orderPublishDetailInfoVO.setDepartureAddressName(orderPublishDetailInfoDTO.getDepartureAddressName());
        orderPublishDetailInfoVO.setArriveAddressName(orderPublishDetailInfoDTO.getArriveAddressName());
        if(CollUtil.isNotEmpty(orderPublishDetailInfoDTO.getCartTypeList())){
            orderPublishDetailInfoVO.setCartTypeList(orderPublishDetailInfoDTO.getCartTypeList().stream().map(StringsUtil::valueOf).collect(Collectors.toList()));
        }
        orderPublishDetailInfoVO.setCartTypeListName(orderPublishDetailInfoDTO.getCartTypeListName());
        orderPublishDetailInfoVO.setGoodsInfo(orderPublishDetailInfoDTO.getGoodsInfo());
        orderPublishDetailInfoVO.setPriceStyle(StringsUtil.valueOf(orderPublishDetailInfoDTO.getPriceStyle()));
        orderPublishDetailInfoVO.setPrice(orderPublishDetailInfoDTO.getPrice());
        orderPublishDetailInfoVO.setUseStartDate(orderPublishDetailInfoDTO.getUseStartDate());
        orderPublishDetailInfoVO.setMaxTon(orderPublishDetailInfoDTO.getMaxTon());
        orderPublishDetailInfoVO.setMinTon(orderPublishDetailInfoDTO.getMinTon());
        orderPublishDetailInfoVO.setStatus(orderPublishDetailInfoDTO.getStatus());
        orderPublishDetailInfoVO.setIsLoadLocation(orderPublishDetailInfoDTO.getIsLoadLocation());
        orderPublishDetailInfoVO.setIsUnloadLocation(orderPublishDetailInfoDTO.getIsUnloadLocation());
        orderPublishDetailInfoVO.setLoadAddress(orderPublishDetailInfoDTO.getLoadAddress());
        orderPublishDetailInfoVO.setUnloadAddress(orderPublishDetailInfoDTO.getUnloadAddress());
        orderPublishDetailInfoVO.setLoadLatitude(orderPublishDetailInfoDTO.getLoadLatitude());
        orderPublishDetailInfoVO.setLoadLongitude(orderPublishDetailInfoDTO.getLoadLongitude());
        orderPublishDetailInfoVO.setUnloadLatitude(orderPublishDetailInfoDTO.getUnloadLatitude());
        orderPublishDetailInfoVO.setUnloadLongitude(orderPublishDetailInfoDTO.getUnloadLongitude());
        return orderPublishDetailInfoVO;
    }

    public static OrderUpdatePublishDTO convertorToOrderUpdatePublishDTO(OrderUpdatePublishVO orderUpdatePublishVO){
        OrderUpdatePublishDTO orderUpdatePublishDTO = new OrderUpdatePublishDTO();
        orderUpdatePublishDTO.setId(orderUpdatePublishVO.getId());
        orderUpdatePublishDTO.setDepartureAreaCode(orderUpdatePublishVO.getDepartureAreaCode());
        orderUpdatePublishDTO.setArriveAreaCode(orderUpdatePublishVO.getArriveAreaCode());
        orderUpdatePublishDTO.setUseStartDate(orderUpdatePublishVO.getUseStartDate());
        orderUpdatePublishDTO.setMinTon(orderUpdatePublishVO.getMinTon());
        orderUpdatePublishDTO.setMaxTon(orderUpdatePublishVO.getMaxTon());
        orderUpdatePublishDTO.setPriceStyle(orderUpdatePublishVO.getPriceStyle());
        orderUpdatePublishDTO.setPrice(orderUpdatePublishVO.getPrice());
        orderUpdatePublishDTO.setGoodsInfo(orderUpdatePublishVO.getGoodsInfo());
        if(CollUtil.isNotEmpty(orderUpdatePublishVO.getCartTypeList())){
            orderUpdatePublishDTO.setCartTypeList(orderUpdatePublishVO.getCartTypeList().stream().map(Integer::valueOf).collect(Collectors.toList()));
        }
        orderUpdatePublishDTO.setLoadAddress(orderUpdatePublishVO.getLoadAddress());
        orderUpdatePublishDTO.setUnloadAddress(orderUpdatePublishVO.getUnloadAddress());
        orderUpdatePublishDTO.setLoadLatitude(orderUpdatePublishVO.getLoadLatitude());
        orderUpdatePublishDTO.setLoadLongitude(orderUpdatePublishVO.getLoadLongitude());
        orderUpdatePublishDTO.setUnloadLatitude(orderUpdatePublishVO.getUnloadLatitude());
        orderUpdatePublishDTO.setUnloadLongitude(orderUpdatePublishVO.getUnloadLongitude());
        return orderUpdatePublishDTO;
    }

    public static OrderUpdateStatusDTO convertoToOrderUpdateStatusDTO(OrderUpdateStatusVO orderUpdateStatusVO){
        OrderUpdateStatusDTO orderUpdateStatusDTO = new OrderUpdateStatusDTO();
        orderUpdateStatusDTO.setId(orderUpdateStatusVO.getId());
        orderUpdateStatusDTO.setStatus(orderUpdateStatusVO.getStatus());
        return orderUpdateStatusDTO;
    }

}
