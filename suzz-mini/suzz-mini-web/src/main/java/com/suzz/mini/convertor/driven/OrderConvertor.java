package com.suzz.mini.convertor.driven;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.driven.OrderSearchDetailInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchDetailQueryDTO;
import com.suzz.mini.dto.driven.OrderSearchInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchQueryDTO;
import com.suzz.mini.vo.driven.OrderSearchDetailInfoVO;
import com.suzz.mini.vo.driven.OrderSearchDetailQueryVO;
import com.suzz.mini.vo.driven.OrderSearchInfoVO;
import com.suzz.mini.vo.driven.OrderSearchQueryVO;
import com.suzz.platform.util.DateUtil;
import com.suzz.platform.util.LangContent;
import com.suzz.platform.util.StringsUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/5/15 18:55
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConvertor {

    public static OrderSearchQueryDTO convertorToOrderSearchQueryDTO(OrderSearchQueryVO orderSearchQueryVO) {
        OrderSearchQueryDTO orderSearchQueryDTO = new OrderSearchQueryDTO();
        orderSearchQueryDTO.setDepartureAreaCode(StringsUtil.toIntegerAsNull(orderSearchQueryVO.getDepartureAreaCode()));
        orderSearchQueryDTO.setArriveAreaCode(StringsUtil.toIntegerAsNull(orderSearchQueryVO.getArriveAreaCode()));
        orderSearchQueryDTO.setMinTon(StringsUtil.toIntegerAsNull(orderSearchQueryVO.getMinTon()));
        orderSearchQueryDTO.setMaxTon(StringsUtil.toIntegerAsNull(orderSearchQueryVO.getMaxTon()));
        orderSearchQueryDTO.setMinPrice(StringsUtil.toBigDecimal(orderSearchQueryVO.getMinPrice()));
        orderSearchQueryDTO.setMaxPrice(StringsUtil.toBigDecimal(orderSearchQueryVO.getMaxPrice()));
        orderSearchQueryDTO.setUseStartDate(DateUtil.parseDate(orderSearchQueryVO.getUseStartDate()));
        orderSearchQueryDTO.setUseEndDate(DateUtil.parseDate(orderSearchQueryVO.getUseEndDate()));
        orderSearchQueryDTO.setKeyword(orderSearchQueryVO.getKeyword());
        orderSearchQueryDTO.setLang(LangContent.getLang());
        orderSearchQueryDTO.setIsCollection(orderSearchQueryVO.getIsCollection());
        orderSearchQueryDTO.setMiniUserId(orderSearchQueryVO.getMiniUserId());
        if (CollUtil.isNotEmpty(orderSearchQueryVO.getCartTypeList())) {
            orderSearchQueryDTO.setCartTypeList(orderSearchQueryVO.getCartTypeList().stream().map(StringsUtil::toIntegerAsNull).collect(Collectors.toList()));
        }
        return orderSearchQueryDTO;
    }

    public static OrderSearchInfoVO convertorToOrderSearchInfoVO(OrderSearchInfoDTO orderSearchInfoDTO) {
        OrderSearchInfoVO orderSearchInfoVO = new OrderSearchInfoVO();
        orderSearchInfoVO.setOrderId(orderSearchInfoDTO.getOrderId());
        if(orderSearchInfoDTO.getHeadPic().startsWith("http")){
            orderSearchInfoVO.setHeadPic(orderSearchInfoDTO.getHeadPic());
        }else{
            orderSearchInfoVO.setHeadPic("http://1.116.142.225:8092/mini/web/picture/queryHead?path="+orderSearchInfoDTO.getHeadPic());
        }
        orderSearchInfoVO.setDepartureAddressName(orderSearchInfoDTO.getDepartureAddressName());
        orderSearchInfoVO.setArriveAddressName(orderSearchInfoDTO.getArriveAddressName());
        if (CollUtil.isNotEmpty(orderSearchInfoDTO.getCartTypeListName())) {
            String cartTypeListName = String.join(",", orderSearchInfoDTO.getCartTypeListName());
            orderSearchInfoVO.setCartTypeListName(cartTypeListName);
        }
        orderSearchInfoVO.setUseStartDate(DateUtil.get4yMd(orderSearchInfoDTO.getUseStartDate()));
        orderSearchInfoVO.setPriceStyle(orderSearchInfoDTO.getPriceStyle());
        orderSearchInfoVO.setPrice(StringsUtil.valueOf(orderSearchInfoDTO.getPrice()));
        if (Objects.nonNull(orderSearchInfoDTO.getPublishTime())) {
            // 如果相差时间小于一天 展示小时
            // 如果相差时间大于一天展示月份
            Date nowDate = new Date();
            if(orderSearchInfoDTO.getPublishTime().compareTo(nowDate) < 0){
                Date oneDate = DateUtil.addDay(nowDate, 1);
                if (orderSearchInfoDTO.getPublishTime().compareTo(oneDate) < 0) {
                    orderSearchInfoVO.setPublishTime(DateUtil.get4yMd(orderSearchInfoDTO.getPublishTime())+"发布");
                }else {
                    int hourDif = DateUtil.getHourDif(nowDate, orderSearchInfoDTO.getPublishTime());
                    orderSearchInfoVO.setPublishTime(hourDif+"小时前发布");
                    if(hourDif==0){
                        long minuteDif = DateUtil.getMinuteDif(nowDate, orderSearchInfoDTO.getPublishTime());
                        orderSearchInfoVO.setPublishTime(minuteDif+"分钟前发布");
                    }
                }
            }
        }
        orderSearchInfoVO.setLookNumber(orderSearchInfoDTO.getLookNumber());
        return orderSearchInfoVO;
    }

    public static OrderSearchDetailQueryDTO convertorToOrderSearchDetailQueryDTO(OrderSearchDetailQueryVO orderSearchDetailQueryVO){
        OrderSearchDetailQueryDTO orderSearchDetailQueryDTO = new OrderSearchDetailQueryDTO();
        orderSearchDetailQueryDTO.setOrderId(orderSearchDetailQueryVO.getOrderId());
        orderSearchDetailQueryDTO.setMiniUserId(orderSearchDetailQueryVO.getMiniUserId());
        return orderSearchDetailQueryDTO;
    }

    public static OrderSearchDetailInfoVO toOrderSearchDetailInfoVO(OrderSearchDetailInfoDTO orderSearchDetailInfoDTO){
        OrderSearchDetailInfoVO orderSearchDetailInfoVO = new OrderSearchDetailInfoVO();
        orderSearchDetailInfoVO.setOrderId(orderSearchDetailInfoDTO.getOrderId());
        orderSearchDetailInfoVO.setMiniUserId(orderSearchDetailInfoDTO.getMiniUserId());
        if(orderSearchDetailInfoDTO.getHeadPic().startsWith("http")){
            orderSearchDetailInfoVO.setHeadPic(orderSearchDetailInfoDTO.getHeadPic());
        }else{
            orderSearchDetailInfoVO.setHeadPic("http://xxx.xxx.xxx.xxx:8092/mini/web/picture/queryHead?path="+orderSearchDetailInfoDTO.getHeadPic());
        }
        orderSearchDetailInfoVO.setPhone(orderSearchDetailInfoDTO.getPhone());
        orderSearchDetailInfoVO.setIsFocus(orderSearchDetailInfoDTO.getIsFocus());
        orderSearchDetailInfoVO.setIsCollection(orderSearchDetailInfoDTO.getIsCollection());
        orderSearchDetailInfoVO.setUseStartDate(DateUtil.get4yMd(orderSearchDetailInfoDTO.getUseStartDate()));
        orderSearchDetailInfoVO.setDepartureAddressName(orderSearchDetailInfoDTO.getDepartureAddressName());
        orderSearchDetailInfoVO.setArriveAddressName(orderSearchDetailInfoDTO.getArriveAddressName());
        orderSearchDetailInfoVO.setCartTypeListName(orderSearchDetailInfoDTO.getCartTypeListName());
        orderSearchDetailInfoVO.setPriceStyle(orderSearchDetailInfoDTO.getPriceStyle());
        orderSearchDetailInfoVO.setPrice(StringsUtil.valueOf(orderSearchDetailInfoDTO.getPrice()));
        orderSearchDetailInfoVO.setGoodsInfo(orderSearchDetailInfoDTO.getGoodsInfo());
        if(Objects.nonNull(orderSearchDetailInfoDTO.getMaxTon())){
            orderSearchDetailInfoVO.setMaxTon(orderSearchDetailInfoDTO.getMaxTon());
        }
        if(Objects.nonNull(orderSearchDetailInfoDTO.getMinTon())){
            orderSearchDetailInfoVO.setMinTon(orderSearchDetailInfoDTO.getMinTon());
        }
        orderSearchDetailInfoVO.setIsLoadLocation(orderSearchDetailInfoDTO.getIsLoadLocation());
        orderSearchDetailInfoVO.setIsUnloadLocation(orderSearchDetailInfoDTO.getIsUnloadLocation());
        orderSearchDetailInfoVO.setLoadAddress(orderSearchDetailInfoDTO.getLoadAddress());
        orderSearchDetailInfoVO.setUnloadAddress(orderSearchDetailInfoDTO.getUnloadAddress());
        orderSearchDetailInfoVO.setLoadLatitude(orderSearchDetailInfoDTO.getLoadLatitude());
        orderSearchDetailInfoVO.setLoadLongitude(orderSearchDetailInfoDTO.getLoadLongitude());
        orderSearchDetailInfoVO.setUnloadLatitude(orderSearchDetailInfoDTO.getUnloadLatitude());
        orderSearchDetailInfoVO.setUnloadLongitude(orderSearchDetailInfoDTO.getUnloadLongitude());
        return orderSearchDetailInfoVO;
    }
}
