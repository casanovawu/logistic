package com.suzz.mini.facade.impl.driven;

import com.github.pagehelper.Page;
import com.suzz.mini.constant.OrderStatusEnum;
import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.condition.OrderQueryCondition;
import com.suzz.mini.dto.driven.OrderSearchDetailInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchDetailQueryDTO;
import com.suzz.mini.dto.driven.OrderSearchInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchQueryDTO;
import com.suzz.mini.facade.user.driven.DrivenOrderFacade;
import com.suzz.mini.serivce.MiniOrderService;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/7/31 9:50
 **/
@DubboService(interfaceClass = DrivenOrderFacade.class)
@Api(tags = "drivenOrderFacadeImpl")
public class DrivenOrderFacadeImpl implements DrivenOrderFacade {

    @Autowired
    private MiniOrderService miniOrderService;

    @Override
    public PageResponse<OrderSearchInfoDTO> search(PageRequest<OrderSearchQueryDTO> request) throws ApplicationException, BusinessException, ProgramException {
        OrderQueryCondition orderQueryCondition = FacadeConvertUtil.convertForPage(request, OrderQueryCondition::toOrderQueryCondition);
        orderQueryCondition.setStatus(OrderStatusEnum.ONLINE.getCode());
        Page<Order> orders = miniOrderService.queryOrderPage(orderQueryCondition);
        return FacadeConvertUtil.successForPage(orders,Order::toOrderSearchInfoDTO);
    }

    @Override
    public SimpleResponse<OrderSearchDetailInfoDTO> searchDetail(SimpleRequest<OrderSearchDetailQueryDTO> request) throws ApplicationException, BusinessException, ProgramException {
        OrderQueryCondition orderQueryCondition = OrderQueryCondition.toOrderQueryCondition(request.getReqDtos());
        Order order = miniOrderService.queryDetail(orderQueryCondition);
        return FacadeConvertUtil.success(order,Order::toOrderSearchDetailInfoDTO);
    }
}
