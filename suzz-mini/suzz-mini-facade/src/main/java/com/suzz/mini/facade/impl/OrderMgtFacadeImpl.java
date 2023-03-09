package com.suzz.mini.facade.impl;

import com.suzz.mini.convert.OrderAuditConvert;
import com.suzz.mini.convert.OrderConvert;
import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.OrderAudit;
import com.suzz.mini.domain.OrderCarType;
import com.suzz.mini.dto.mgt.OrderAuditDTO;
import com.suzz.mini.dto.mgt.OrderMgtDTO;
import com.suzz.mini.facade.mgt.OrderMgtFacade;
import com.suzz.mini.serivce.MiniOrderService;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.util.FacadeServerUtil;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@DubboService(interfaceClass = OrderMgtFacade.class)
@Api(tags = "orderMgtFacadeImpl")
public class OrderMgtFacadeImpl implements OrderMgtFacade {

    @Autowired
    private MiniOrderService miniOrderService;

    @Override
    public SimpleResponse<OrderMgtDTO> selectOrderById(SimpleRequest<OrderMgtDTO> request) {
        Order order = miniOrderService.selectOrderById(request.getReqDtos().getId());
        OrderMgtDTO dto = OrderConvert.entityToDTO(order);
        List<OrderCarType> orderCarTypes = miniOrderService.selectCarList(request.getReqDtos().getId());
        OrderConvert.setCar(dto, orderCarTypes);
        List<OrderAudit> orderAudits = miniOrderService.selectAuditList(request.getReqDtos().getId());
        OrderConvert.setAudit(dto, orderAudits);
        return SimpleResponse.of(dto);
    }

    @Override
    public ListResponse<OrderMgtDTO> selectOrderList(SimpleRequest<OrderMgtDTO> request) {
        Order order = OrderConvert.dtoToEntity(request.getReqDtos());
        List<Order> orders = miniOrderService.selectOrderList(order);
        return FacadeConvertUtil.successForList(orders, OrderConvert::entityToDTO);
    }

    @Override
    public PageResponse<OrderMgtDTO> selectOrderListPage(PageRequest<OrderMgtDTO> dto) {
        return FacadeServerUtil.pagingQuery(dto,
                OrderConvert::dtoToEntity,
                miniOrderService::selectOrderList,
                OrderConvert::entityToDTO);
    }

    @Override
    public SimpleResponse<Integer> updateOrder(SimpleRequest<OrderMgtDTO> request) {
        Order order = OrderConvert.dtoToEntity(request.getReqDtos());
        return SimpleResponse.of(miniOrderService.updateOrder(order));
    }

    @Override
    public SimpleResponse<Integer> audit(SimpleRequest<OrderAuditDTO> request) {
        try {
            OrderAudit audit = OrderAuditConvert.dtoToEntity(request.getReqDtos());
            return SimpleResponse.of(miniOrderService.audit(audit));
        } catch (BusinessException e) {
            log.error("OrderMgtFacadeImpl audit businessException! request={} " +
                    "errorCode={} errorMsg={}", request, e.getErrCode(), e.getErrorMsg());
            return SimpleResponse.error(e.getErrCode(), e.getErrorMsg());
        } catch (Exception e) {
            log.error("OrderMgtFacadeImpl audit exception! request={}", request, e);
            return SimpleResponse.sysError();
        }
    }

}
