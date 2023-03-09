package com.suzz.mini.serivce.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.suzz.mini.constant.OrderStatusEnum;
import com.suzz.mini.domain.*;
import com.suzz.mini.domain.condition.LineSubscribeCondition;
import com.suzz.mini.domain.condition.OrderCarTypeCondition;
import com.suzz.mini.domain.condition.OrderQueryCondition;
import com.suzz.mini.mapper.OrderAuditMapper;
import com.suzz.mini.mapper.OrderCarTypeMapper;
import com.suzz.mini.mapper.OrderMapper;
import com.suzz.mini.serivce.*;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Exception;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/5/4 13:41
 **/
@Service
public class MiniOrderServiceImpl implements MiniOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderCarTypeMapper orderCarTypeMapper;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private OrderAuditMapper orderAuditMapper;

    @Autowired
    private OrderLookService orderLookService;

    @Autowired
    private OrderCollectionService orderCollectionService;

    @Autowired
    private MiniUserService miniUserService;

    @Autowired
    private MiniUserFocusService miniUserFocusService;

    @Autowired
    private LineSubscribeService lineSubscribeService;

    @Autowired
    private WxMaService wxMaService;

    @Override
    @Transactional
    public Integer publish(Order order){
        order.checkParam();
        boolean checkMessage = false;
        try {
            checkMessage = wxMaService.getSecCheckService().checkMessage(order.checkMessageContent());
        } catch (WxErrorException e) {
            //throw new ApplicationException("微信内容检查错误","-1");
        }
        if(checkMessage){
            order.setStatus(OrderStatusEnum.ONLINE.getCode());
        }
        orderMapper.insert(order);
        if (!CollUtil.isEmpty(order.getCartTypeList())) {
            for (OrderCarType orderCarType : order.getCartTypeList()) {
                orderCarType.setFkOrder(order.getId());
                orderCarType.setCarType(orderCarType.getCarType());
                orderCarTypeMapper.insertSelective(orderCarType);
            }
        }
        if (order.getStatus().equals(OrderStatusEnum.ONLINE.getCode())) {
            sendSubscribeMessageProcess(order.getId());
        }
        return order.getId();
    }

    @Override
    public List<Order> queryOrderList(OrderQueryCondition condition) {
        return orderMapper.queryList(condition);
    }

    @Override
    public Page<Order> queryOrderPage(OrderQueryCondition condition) {
        Page<Order> page = PageHelper.startPage(condition.getPageNumber(), condition.getPageSize());
        orderMapper.queryList(condition);
        if (CollUtil.isNotEmpty(page.getResult())) {
            List<Integer> orderIds = page.getResult().stream().map(Order::getId).collect(Collectors.toList());
            List<OrderCarType> orderCarTypes = orderCarTypeMapper.queryList(OrderCarTypeCondition.builder().orderIds(orderIds).build());
            if(CollUtil.isNotEmpty(orderCarTypes)){
                Map<Integer, List<OrderCarType>> orderCarTypeMap = orderCarTypes.stream().collect(Collectors.groupingBy(OrderCarType::getFkOrder));
                for (Order order : page.getResult()) {
                    List<OrderCarType> orderCarTypeItem = orderCarTypeMap.get(order.getId());
                    order.setCartTypeList(orderCarTypeItem);
                }
            }
            List<OrderLook> orderLookList = orderLookService.list(new LambdaQueryWrapper<OrderLook>().in(OrderLook::getOrderId,orderIds));
            if(CollUtil.isNotEmpty(orderLookList)){
                Map<Integer, List<OrderLook>> orderLookMap = orderLookList.stream().collect(Collectors.groupingBy(OrderLook::getOrderId));
                for (Order order : page.getResult()) {
                    List<OrderLook> orderLookItem = orderLookMap.get(order.getId());
                    order.setOrderLookList(orderLookItem);
                }
            }
        }
        return page;
    }

    @Override
    public Order queryDetail(OrderQueryCondition condition) {
        Order order = orderMapper.selectByPrimaryKey(condition.getId());
        if (Objects.nonNull(order)) {
            order.setMiniUser(miniUserService.selectByPrimaryKey(order.getFkMiniUser()));
            order.setCartTypeList(orderCarTypeMapper.queryList(OrderCarTypeCondition.builder().orderId(order.getId()).build()));
            order.setDepartureAddressName(provinceService.queryNameByCode(order.getDepartureAreaCode()));
            order.setArriveAddressName(provinceService.queryNameByCode(order.getArriveAreaCode()));
            //查询该用户是否关注
            if(Objects.nonNull(condition.getMiniUserId())){
                OrderCollection orderCollection = orderCollectionService.getBaseMapper().selectOne(
                        new LambdaQueryWrapper<OrderCollection>()
                                .eq(OrderCollection::getOrderId, order.getId())
                                .eq(OrderCollection::getMiniUserId, condition.getMiniUserId())
                        .eq(OrderCollection::getIsValid,1)
                );
                order.setOrderCollection(orderCollection);
            }
            //查询发布订单的用户是否被关注
            if(Objects.nonNull(order.getMiniUser()) && Objects.nonNull(condition.getMiniUserId())){
                MiniUserFocus miniUserFocus = miniUserFocusService.getBaseMapper().selectOne(
                        new LambdaQueryWrapper<MiniUserFocus>()
                                .eq(MiniUserFocus::getMiniUserId, order.getMiniUser().getId())
                                .eq(MiniUserFocus::getMiniUserFocusId, condition.getMiniUserId())
                                .eq(MiniUserFocus::getIsValid, 1));
                order.setMiniUserFocus(miniUserFocus);
            }
        }
        return order;
    }

    @Override
    @Transactional
    public void updatePublish(Order order) {
        boolean checkMessage = false;
        try {
            checkMessage = wxMaService.getSecCheckService().checkMessage(order.checkMessageContent());
        } catch (WxErrorException e) {
            //throw new ApplicationException("微信内容检查错误","-1");
        }
        if(checkMessage){
            order.setStatus(OrderStatusEnum.ONLINE.getCode());
        }
        orderMapper.updateByPrimaryKeySelective(order);
        OrderCarType orderCarType = new OrderCarType();
        orderCarType.setFkOrder(order.getId());
        orderCarTypeMapper.updateValid(orderCarType);
        if(CollectionUtil.isNotEmpty(order.getCartTypeList())){
            for (OrderCarType orderCarTypeItem : order.getCartTypeList()) {
                orderCarType.setCarType(orderCarTypeItem.getCarType());
                orderCarTypeMapper.insertSelective(orderCarType);
            }
        }
    }

    @Override
    public void updateStatusMoreThanFiveDay() {
        orderMapper.updateStatusMoreThanFiveDay();
    }

    @Override
    public void updateStatus(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order selectOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> selectOrderList(Order order) {
        return orderMapper.selectOrderList(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<OrderCarType> selectCarList(Integer orderId) {
        return orderCarTypeMapper.queryList(OrderCarTypeCondition.builder().orderId(orderId).build());
    }

    @Override
    public List<OrderAudit> selectAuditList(Integer orderId) {
        OrderAudit audit = new OrderAudit();
        audit.setFkOrder(orderId);
        return orderAuditMapper.selectOrderAuditList(audit);
    }

    @Override
    @Transactional
    public Integer audit(OrderAudit orderAudit) {
        Integer newStatus;
        if (orderAudit.getStatus() == 1) {
            newStatus = OrderStatusEnum.ONLINE.getCode();
        } else if (orderAudit.getStatus() == 2) {
            newStatus = OrderStatusEnum.REFUSE.getCode();
        } else {
            throw BusinessException.of("不支持该审批状态", "100001");
        }
        int auditResult = orderMapper.audit(orderAudit.getFkOrder(), newStatus, OrderStatusEnum.AUDITING.getCode());
        if (auditResult != 1) {
            throw BusinessException.of("审核信息不存在", "100001");
        }
        int i = orderAuditMapper.insertOrderAudit(orderAudit);
        if (orderAudit.getStatus() == 1) {
            sendSubscribeMessageProcess(orderAudit.getFkOrder());
        }
        return i;
    }

    public void sendSubscribeMessageProcess(Integer orderId){
        OrderQueryCondition orderQueryCondition=new OrderQueryCondition();
        orderQueryCondition.setId(orderId);
        Order order = queryDetail(orderQueryCondition);
        LineSubscribeCondition lineSubscribeCondition=new LineSubscribeCondition();
        lineSubscribeCondition.setArriveAreaCode(order.getArriveAreaCode());
        lineSubscribeCondition.setDepartureAreaCode(order.getDepartureAreaCode());
        lineSubscribeCondition.setUseStartDate(order.getUseStartDate());
        lineSubscribeCondition.setCarTypeList(order.obtainCartTypeListInteger());
        lineSubscribeCondition.setPrice(order.getPrice());
        lineSubscribeCondition.setPriceStyle(order.getPriceStyle());
        lineSubscribeService.sendSubscribeMessage(lineSubscribeCondition);
    }

}
