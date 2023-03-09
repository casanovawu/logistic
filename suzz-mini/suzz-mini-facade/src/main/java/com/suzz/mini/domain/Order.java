package com.suzz.mini.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.suzz.mini.constant.ExceptionEnum;
import com.suzz.mini.constant.IsLocationEnum;
import com.suzz.mini.constant.PriceStyleEnum;
import com.suzz.mini.constant.OrderStatusEnum;
import com.suzz.mini.dto.driven.OrderSearchDetailInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchInfoDTO;
import com.suzz.mini.dto.goodsowner.*;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.util.DateUtil;
import com.suzz.platform.util.StringsUtil;
import lombok.Data;
import me.chanjar.weixin.common.util.DataUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * order
 *
 * @author
 */
@Data
public class Order  {

    private Integer id;

    /**
     * 用户id
     */
    private Integer fkMiniUser;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 出发区域code 6位数 2位省份2位城市 2位区域
     */
    private String departureAreaCode;

    private String departureAddressName;

    /**
     * 目的区域code 6位数 2位省份2位城市 2位区域
     */
    private String arriveAreaCode;

    private String arriveAddressName;

    /**
     * 使用开始时间
     */
    private Date useStartDate;

    private Date publishTime;

    /**
     * 最小吨位
     */
    private Integer minTon;

    /**
     * 最大吨位
     */
    private Integer maxTon;

    /**
     * 价格方式 1.价格 2.电议
     */
    private Integer priceStyle;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 货源信息
     */
    private String goodsInfo;

    /**
     * 用车类型
     */
    private List<OrderCarType> cartTypeList;

    private MiniUser miniUser;

    private List<OrderLook> orderLookList;

    private OrderCollection orderCollection;

    private MiniUserFocus miniUserFocus;

    /**
     * 经度
     */
    private String loadLongitude;
    private String unloadLongitude;

    /**
     * 纬度
     */
    private String loadLatitude;

    private String unloadLatitude;

    /**
     * 详细地址
     */
    private String loadAddress;

    private String unloadAddress;

    private String language;

    private Integer isLoadLocation;
    private Integer isUnloadLocation;
    private Date createTime;
    private Date modifyTime;
    private Integer isValid;

    public static Order toOrderByPublish(OrderPublishDTO orderPublishDTO) {
        Order order = new Order();
        order.setFkMiniUser(orderPublishDTO.getMiniUserId());
        order.setDepartureAreaCode(orderPublishDTO.getDepartureAreaCode());
        order.setArriveAreaCode(orderPublishDTO.getArriveAreaCode());
        order.setUseStartDate(DateUtil.parseDate(orderPublishDTO.getUseStartDate()));
        order.setMinTon(StringsUtil.toIntegerAsNull(orderPublishDTO.getMinTon()));
        order.setMaxTon(StringsUtil.toIntegerAsNull(orderPublishDTO.getMaxTon()));
        order.setPriceStyle(StringsUtil.toIntegerAsNull(orderPublishDTO.getPriceStyle()));
        order.setPrice(StringsUtil.toBigDecimal(orderPublishDTO.getPrice()));
        order.setGoodsInfo(orderPublishDTO.getGoodsInfo());
        if(!CollUtil.isEmpty(orderPublishDTO.getCartTypeList())){
            order.setCartTypeList(orderPublishDTO.getCartTypeList().stream().map(a->{
                OrderCarType orderCarType=new OrderCarType();
                orderCarType.setCarType(a);
                return orderCarType;
            }).collect(Collectors.toList()));
        }
        order.setStatus(OrderStatusEnum.AUDITING.getCode());
        order.setLoadAddress(orderPublishDTO.getLoadAddress());
        order.setUnloadAddress(orderPublishDTO.getUnloadAddress());
        if(StrUtil.isNotBlank(orderPublishDTO.getLoadLatitude()) && StrUtil.isNotBlank(orderPublishDTO.getLoadLongitude())){
            order.setLoadLatitude(orderPublishDTO.getLoadLatitude());
            order.setLoadLongitude(orderPublishDTO.getLoadLongitude());
            order.setIsLoadLocation(IsLocationEnum.LOCATION.getCode());
        }
        if(StrUtil.isNotBlank(orderPublishDTO.getUnloadLatitude()) && StrUtil.isNotBlank(orderPublishDTO.getUnloadLongitude())){
            order.setUnloadLatitude(orderPublishDTO.getUnloadLatitude());
            order.setUnloadLongitude(orderPublishDTO.getUnloadLongitude());
            order.setIsUnloadLocation(IsLocationEnum.LOCATION.getCode());
        }
        order.setCreateTime(new Date());
        order.setModifyTime(new Date());
        order.setPublishTime(new Date());
        order.setIsValid(1);
        return order;
    }

    public void checkParam(){
        BusinessException.assertTrue(Objects.nonNull(this.fkMiniUser),"未查询到当前登录账号");
        BusinessException.assertTrue(!StringUtils.isEmpty(this.departureAreaCode), ExceptionEnum.DEPARTURE_CITY_NOT_SELECTED.getCode());
        BusinessException.assertTrue(!StringUtils.isEmpty(this.arriveAreaCode), "目的城市未填选");
        BusinessException.assertTrue(Objects.nonNull(this.useStartDate),"使用开始时间未填选");
        Date now = DateUtil.parseDate(DateUtil.get4yMd(new Date()));
        BusinessException.assertTrue(this.useStartDate.compareTo(now)>=0,"选择的使用时间小于当前的时间");
        BusinessException.assertTrue(!CollectionUtils.isEmpty(cartTypeList),"用车类型未填选");
        BusinessException.assertTrue(Objects.nonNull(this.priceStyle),"价格方式未填选");
        if(PriceStyleEnum.PRICE.getCode().equals(this.priceStyle)){
            BusinessException.assertTrue(Objects.nonNull(this.price),"价格未填写");
        }
        if(Objects.nonNull(this.minTon) && Objects.nonNull(this.maxTon)){
            BusinessException.assertTrue(this.minTon.compareTo(this.maxTon)<=0,"最小吨位大于最大吨位");
        }
    }

    public OrderMyPublishInfoDTO toOrderMyPublishInfoDTO(){
        OrderMyPublishInfoDTO orderMyPublishInfoDTO = new OrderMyPublishInfoDTO();
        orderMyPublishInfoDTO.setMiniUserId(this.fkMiniUser);
        orderMyPublishInfoDTO.setDepartureAddressName(this.departureAddressName);
        orderMyPublishInfoDTO.setArriveAddressName(this.arriveAddressName);
        if(CollUtil.isNotEmpty(this.getCartTypeList())){
            orderMyPublishInfoDTO.setCartTypeList(this.getCartTypeList().stream().map(OrderCarType::getCarType).collect(Collectors.toList()));
            orderMyPublishInfoDTO.setCartTypeListName(this.getCartTypeList().stream().map(OrderCarType::getCarName).collect(Collectors.toList()));
        }
        orderMyPublishInfoDTO.setGoodsInfo(this.getGoodsInfo());
        orderMyPublishInfoDTO.setStatus(this.status);
        if(OrderStatusEnum.ONLINE.getCode().equals(this.status)){
            Date endDate = DateUtil.addDay(this.getPublishTime(), 5);
            orderMyPublishInfoDTO.setRemainTime(endDate.getTime()-new Date().getTime());
        }
        orderMyPublishInfoDTO.setPriceStyle(this.priceStyle);
        orderMyPublishInfoDTO.setPrice(StringsUtil.valueOf(this.price));
        orderMyPublishInfoDTO.setOrderId(this.id);
        return orderMyPublishInfoDTO;
    }

    public OrderPublishDetailInfoDTO toOrderPublishDetailInfoDTO(){
        OrderPublishDetailInfoDTO orderPublishDetailInfoDTO=new OrderPublishDetailInfoDTO();
        orderPublishDetailInfoDTO.setDepartureAreaCode(this.departureAreaCode);
        orderPublishDetailInfoDTO.setArriveAreaCode(this.arriveAreaCode);
        orderPublishDetailInfoDTO.setDepartureAddressName(this.departureAddressName);
        orderPublishDetailInfoDTO.setArriveAddressName(this.arriveAddressName);
        if(CollUtil.isNotEmpty(this.getCartTypeList())){
            orderPublishDetailInfoDTO.setCartTypeList(this.getCartTypeList().stream().map(OrderCarType::getCarType).collect(Collectors.toList()));
            orderPublishDetailInfoDTO.setCartTypeListName(this.getCartTypeList().stream().map(OrderCarType::getCarName).collect(Collectors.toList()));
        }
        orderPublishDetailInfoDTO.setGoodsInfo(this.goodsInfo);
        orderPublishDetailInfoDTO.setPriceStyle(this.priceStyle);
        orderPublishDetailInfoDTO.setMaxTon(this.maxTon);
        orderPublishDetailInfoDTO.setMinTon(this.minTon);
        orderPublishDetailInfoDTO.setUseStartDate(DateUtil.get4yMd(this.useStartDate));
        orderPublishDetailInfoDTO.setStatus(this.status);
        if(Objects.nonNull(this.price)){
            orderPublishDetailInfoDTO.setPrice(StringsUtil.valueOf(this.price));
        }
        orderPublishDetailInfoDTO.setIsLoadLocation(this.isLoadLocation);
        orderPublishDetailInfoDTO.setIsUnloadLocation(this.isUnloadLocation);
        orderPublishDetailInfoDTO.setLoadAddress(this.getLoadAddress());
        orderPublishDetailInfoDTO.setUnloadAddress(this.getUnloadAddress());
        orderPublishDetailInfoDTO.setLoadLatitude(this.loadLatitude);
        orderPublishDetailInfoDTO.setLoadLongitude(this.loadLongitude);
        orderPublishDetailInfoDTO.setUnloadLatitude(this.unloadLatitude);
        orderPublishDetailInfoDTO.setUnloadLongitude(this.unloadLongitude);
        return orderPublishDetailInfoDTO;
    }

    public static Order toOrderByPublishUpdate(OrderUpdatePublishDTO orderUpdatePublishDTO) {
        Order order = new Order();
        order.setId(orderUpdatePublishDTO.getId());
        order.setDepartureAreaCode(orderUpdatePublishDTO.getDepartureAreaCode());
        order.setArriveAreaCode(orderUpdatePublishDTO.getArriveAreaCode());
        order.setUseStartDate(DateUtil.parseDate(orderUpdatePublishDTO.getUseStartDate()));
        order.setMinTon(StringsUtil.toIntegerAsNull(orderUpdatePublishDTO.getMinTon()));
        order.setMaxTon(StringsUtil.toIntegerAsNull(orderUpdatePublishDTO.getMaxTon()));
        order.setPriceStyle(StringsUtil.toIntegerAsNull(orderUpdatePublishDTO.getPriceStyle()));
        order.setPrice(StringsUtil.toBigDecimal(orderUpdatePublishDTO.getPrice()));
        order.setGoodsInfo(orderUpdatePublishDTO.getGoodsInfo());
        if(!CollUtil.isEmpty(orderUpdatePublishDTO.getCartTypeList())){
            order.setCartTypeList(orderUpdatePublishDTO.getCartTypeList().stream().map(a->{
                OrderCarType orderCarType=new OrderCarType();
                orderCarType.setCarType(a);
                return orderCarType;
            }).collect(Collectors.toList()));
        }
        order.setStatus(OrderStatusEnum.AUDITING.getCode());
        order.setLoadAddress(orderUpdatePublishDTO.getLoadAddress());
        order.setUnloadAddress(orderUpdatePublishDTO.getUnloadAddress());
        if(StrUtil.isNotBlank(orderUpdatePublishDTO.getLoadLatitude()) && StrUtil.isNotBlank(orderUpdatePublishDTO.getLoadLongitude())){
            order.setLoadLatitude(orderUpdatePublishDTO.getLoadLatitude());
            order.setLoadLongitude(orderUpdatePublishDTO.getLoadLongitude());
            order.setIsLoadLocation(IsLocationEnum.LOCATION.getCode());
        }
        if(StrUtil.isNotBlank(orderUpdatePublishDTO.getUnloadLatitude()) && StrUtil.isNotBlank(orderUpdatePublishDTO.getUnloadLongitude())){
            order.setUnloadLatitude(orderUpdatePublishDTO.getUnloadLatitude());
            order.setUnloadLongitude(orderUpdatePublishDTO.getUnloadLongitude());
            order.setIsUnloadLocation(IsLocationEnum.LOCATION.getCode());
        }
        order.setModifyTime(new Date());
        return order;
    }

    public static Order toOrderByUpdateStatus(OrderUpdateStatusDTO orderUpdateStatusDTO){
        Order order = new Order();
        order.setId(orderUpdateStatusDTO.getId());
        order.setStatus(orderUpdateStatusDTO.getStatus());
        order.setModifyTime(new Date());
        return order;
    }

    public OrderSearchInfoDTO toOrderSearchInfoDTO(){
        OrderSearchInfoDTO orderSearchInfoDTO=new OrderSearchInfoDTO();
        orderSearchInfoDTO.setOrderId(this.id);
        if(Objects.nonNull(miniUser)){
            orderSearchInfoDTO.setHeadPic(miniUser.getHeadPic());
        }
        orderSearchInfoDTO.setDepartureAddressName(this.departureAddressName);
        orderSearchInfoDTO.setArriveAddressName(this.arriveAddressName);
        if(CollUtil.isNotEmpty(this.getCartTypeList())){
            orderSearchInfoDTO.setCartTypeList(this.getCartTypeList().stream().map(OrderCarType::getCarType).collect(Collectors.toList()));
            orderSearchInfoDTO.setCartTypeListName(this.getCartTypeList().stream().map(OrderCarType::getCarName).collect(Collectors.toList()));
        }
        orderSearchInfoDTO.setUseStartDate(this.useStartDate);
        orderSearchInfoDTO.setPriceStyle(this.priceStyle);
        orderSearchInfoDTO.setPrice(this.price);
        orderSearchInfoDTO.setPublishTime(this.publishTime);
        if(CollUtil.isNotEmpty(this.orderLookList)){
            Integer lookNumber = this.orderLookList.stream().map(OrderLook::getNum).reduce(0, Integer::sum);
            orderSearchInfoDTO.setLookNumber(lookNumber);
        }else{
            orderSearchInfoDTO.setLookNumber(0);
        }
        return orderSearchInfoDTO;
    }

    public OrderSearchDetailInfoDTO toOrderSearchDetailInfoDTO(){
        OrderSearchDetailInfoDTO orderSearchDetailInfoDTO=new OrderSearchDetailInfoDTO();
        orderSearchDetailInfoDTO.setOrderId(this.id);
        if(Objects.nonNull(this.miniUser)){
            orderSearchDetailInfoDTO.setHeadPic(this.miniUser.getHeadPic());
            orderSearchDetailInfoDTO.setPhone(this.miniUser.getPhone());
            orderSearchDetailInfoDTO.setMiniUserId(this.miniUser.getId());
        }
        if(Objects.nonNull(this.miniUserFocus)){
            orderSearchDetailInfoDTO.setIsFocus(1);
        }else {
            orderSearchDetailInfoDTO.setIsFocus(0);
        }
        if(Objects.nonNull(this.orderCollection)){
            orderSearchDetailInfoDTO.setIsCollection(1);
        }else {
            orderSearchDetailInfoDTO.setIsCollection(0);
        }
        orderSearchDetailInfoDTO.setUseStartDate(this.useStartDate);
        orderSearchDetailInfoDTO.setDepartureAddressName(this.departureAddressName);
        orderSearchDetailInfoDTO.setArriveAddressName(this.arriveAddressName);
        if(CollUtil.isNotEmpty(this.getCartTypeList())){
            orderSearchDetailInfoDTO.setCartTypeListName(this.getCartTypeList().stream().map(OrderCarType::getCarName).collect(Collectors.joining()));
        }
        orderSearchDetailInfoDTO.setPriceStyle(this.priceStyle);
        orderSearchDetailInfoDTO.setPrice(this.price);
        orderSearchDetailInfoDTO.setGoodsInfo(this.goodsInfo);
        orderSearchDetailInfoDTO.setMaxTon(this.maxTon);
        orderSearchDetailInfoDTO.setMinTon(this.minTon);
        orderSearchDetailInfoDTO.setIsLoadLocation(this.isLoadLocation);
        orderSearchDetailInfoDTO.setIsUnloadLocation(this.isUnloadLocation);
        orderSearchDetailInfoDTO.setLoadAddress(this.getLoadAddress());
        orderSearchDetailInfoDTO.setUnloadAddress(this.getUnloadAddress());
        orderSearchDetailInfoDTO.setLoadLatitude(this.loadLatitude);
        orderSearchDetailInfoDTO.setLoadLongitude(this.loadLongitude);
        orderSearchDetailInfoDTO.setUnloadLatitude(this.unloadLatitude);
        orderSearchDetailInfoDTO.setUnloadLongitude(this.unloadLongitude);
        return orderSearchDetailInfoDTO;
    }

    public List<Integer> obtainCartTypeListInteger(){
        if(CollUtil.isNotEmpty(this.cartTypeList)){
            return this.cartTypeList.stream().map(OrderCarType::getCarType).collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }

    public String checkMessageContent(){
        StringBuilder sb=new StringBuilder();
        if(StrUtil.isNotBlank(this.loadAddress)){
            sb.append(this.loadAddress);
        }
        if(StrUtil.isNotBlank(this.unloadAddress)){
            sb.append(this.unloadAddress);
        }
        if(Objects.nonNull(this.minTon)){
            sb.append(this.minTon);
        }
        if(Objects.nonNull(this.maxTon)){
            sb.append(this.maxTon);
        }
        if(Objects.nonNull(this.price)){
            sb.append(this.price);
        }
        if(StrUtil.isNotBlank(this.goodsInfo)){
            sb.append(this.goodsInfo);
        }
        return sb.toString();
    }
}