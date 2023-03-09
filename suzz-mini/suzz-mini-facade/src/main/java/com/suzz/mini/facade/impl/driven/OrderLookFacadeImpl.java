package com.suzz.mini.facade.impl.driven;

import com.suzz.mini.domain.OrderLook;
import com.suzz.mini.dto.driven.OrderLookUpdateDTO;
import com.suzz.mini.facade.user.driven.OrderLookFacade;
import com.suzz.mini.serivce.OrderLookService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/8/7 14:56
 **/
@DubboService(interfaceClass = OrderLookFacade.class)
@Api(tags = "orderLookFacadeImpl")
public class OrderLookFacadeImpl implements OrderLookFacade {

    @Autowired
    private OrderLookService orderLookService;

    @Override
    public ResponseDTO update(SimpleRequest<OrderLookUpdateDTO> orderLookUpdateDTO) {
        OrderLook orderLook = OrderLook.toOrderLook(orderLookUpdateDTO.getReqDtos());
        orderLookService.createOrUpdate(orderLook);
        return new ResponseDTO();
    }
}
