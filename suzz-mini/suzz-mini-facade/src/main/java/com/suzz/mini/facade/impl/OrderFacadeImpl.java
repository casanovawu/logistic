package com.suzz.mini.facade.impl;

import com.github.pagehelper.Page;
import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.condition.OrderQueryCondition;
import com.suzz.mini.dto.goodsowner.*;
import com.suzz.mini.facade.user.goodsowner.OrderFacade;
import com.suzz.mini.serivce.MiniOrderService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.util.LangContent;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author subo
 * @date 2022/5/4 13:34
 **/
@DubboService(interfaceClass = OrderFacade.class)
@Api(tags = "orderFacadeImpl")
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private MiniOrderService miniOrderService;

    @Override
    public SimpleResponse<Integer> publish(SimpleRequest<OrderPublishDTO> request) {
        Order order = Order.toOrderByPublish(request.getReqDtos());
        order.setLanguage(LangContent.getLang());
        return new SimpleResponse<>(miniOrderService.publish(order));
    }

    @Override
    public PageResponse<OrderMyPublishInfoDTO> myPublish(PageRequest<OrderMyPublishQueryDTO> request) throws ApplicationException, BusinessException, ProgramException {
        OrderQueryCondition orderQueryCondition = FacadeConvertUtil.convertForPage(request, OrderQueryCondition::toOrderQueryCondition);
        Page<Order> orders = miniOrderService.queryOrderPage(orderQueryCondition);
        return FacadeConvertUtil.successForPage(orders,Order::toOrderMyPublishInfoDTO);
    }

    @Override
    public SimpleResponse<OrderPublishDetailInfoDTO> publishDetail(SimpleRequest<OrderPublishDetailQueryDTO> request) throws ApplicationException, BusinessException, ProgramException {
        OrderQueryCondition orderQueryCondition = OrderQueryCondition.toOrderQueryCondition(request.getReqDtos());
        Order order = miniOrderService.queryDetail(orderQueryCondition);
        return FacadeConvertUtil.success(order,Order::toOrderPublishDetailInfoDTO);
    }

    @Override
    public ResponseDTO updatePublish(SimpleRequest<OrderUpdatePublishDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException {
        Order order = Order.toOrderByPublishUpdate(simpleRequest.getReqDtos());
        miniOrderService.updatePublish(order);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateStatus(SimpleRequest<OrderUpdateStatusDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException {
        Order order = Order.toOrderByUpdateStatus(simpleRequest.getReqDtos());
        miniOrderService.updateStatus(order);
        return new ResponseDTO();
    }
}
