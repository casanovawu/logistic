package com.suzz.mini.domain.condition;

import com.suzz.mini.dto.driven.OrderSearchDetailQueryDTO;
import com.suzz.mini.dto.driven.OrderSearchQueryDTO;
import com.suzz.mini.dto.goodsowner.OrderMyPublishQueryDTO;
import com.suzz.mini.dto.goodsowner.OrderPublishDetailQueryDTO;
import com.suzz.platform.domain.PagedQuery;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 21:40
 **/
@Data
public class OrderQueryCondition extends PagedQuery {

    private Integer id;
    /**
     * 用户id
     */
    private Integer miniUserId;

    private String lang;

    /**
     * 出发城市code
     */
    private Integer departureAreaCode;

    /**
     * 目的城市code
     */
    private Integer arriveAreaCode;

    /**
     * 最小吨数
     */
    private Integer minTon;

    /**
     * 最大吨数
     */
    private Integer maxTon;

    /**
     * 最小价格
     */
    private BigDecimal minPrice;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 出发时间
     */
    private Date useStartDate;

    /**
     * 截止时间
     */
    private Date useEndDate;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 查询收藏
     */
    private Integer isCollection;

    /**
     * 排序方式
     */
    private String sort;

    private Integer status;

    /**
     * 车型
     */
    private List<Integer> cartTypeList;


    public static OrderQueryCondition toOrderQueryCondition(OrderMyPublishQueryDTO orderMyPublishQueryDTO){
        OrderQueryCondition orderQueryCondition=new OrderQueryCondition();
        orderQueryCondition.setMiniUserId(orderMyPublishQueryDTO.getMiniUserId());
        orderQueryCondition.setStatus(orderMyPublishQueryDTO.getStatus());
        orderQueryCondition.setSort(orderMyPublishQueryDTO.getSort());
        return orderQueryCondition;
    }

    public static OrderQueryCondition toOrderQueryCondition(OrderPublishDetailQueryDTO orderPublishDetailQueryDTO){
        OrderQueryCondition orderQueryCondition = new OrderQueryCondition();
        orderQueryCondition.setId(orderPublishDetailQueryDTO.getOrderId());
        return orderQueryCondition;
    }

    public static OrderQueryCondition toOrderQueryCondition(OrderSearchQueryDTO orderSearchQueryDTO){
        OrderQueryCondition orderQueryCondition = new OrderQueryCondition();
        orderQueryCondition.setLang(orderSearchQueryDTO.getLang());
        orderQueryCondition.setDepartureAreaCode(orderSearchQueryDTO.getDepartureAreaCode());
        orderQueryCondition.setArriveAreaCode(orderSearchQueryDTO.getArriveAreaCode());
        orderQueryCondition.setMinTon(orderSearchQueryDTO.getMinTon());
        orderQueryCondition.setMaxTon(orderSearchQueryDTO.getMaxTon());
        orderQueryCondition.setMinPrice(orderSearchQueryDTO.getMinPrice());
        orderQueryCondition.setMaxPrice(orderSearchQueryDTO.getMaxPrice());
        orderQueryCondition.setUseStartDate(orderSearchQueryDTO.getUseStartDate());
        orderQueryCondition.setUseEndDate(orderSearchQueryDTO.getUseEndDate());
        orderQueryCondition.setKeyword(orderSearchQueryDTO.getKeyword());
        orderQueryCondition.setCartTypeList(orderSearchQueryDTO.getCartTypeList());
        orderQueryCondition.setMiniUserId(orderSearchQueryDTO.getMiniUserId());
        orderQueryCondition.setIsCollection(orderSearchQueryDTO.getIsCollection());
        return orderQueryCondition;
    }

    public static OrderQueryCondition toOrderQueryCondition(OrderSearchDetailQueryDTO orderSearchDetailQueryDTO){
        OrderQueryCondition orderQueryCondition = new OrderQueryCondition();
        orderQueryCondition.setId(orderSearchDetailQueryDTO.getOrderId());
        orderQueryCondition.setMiniUserId(orderSearchDetailQueryDTO.getMiniUserId());
        return orderQueryCondition;
    }
}
