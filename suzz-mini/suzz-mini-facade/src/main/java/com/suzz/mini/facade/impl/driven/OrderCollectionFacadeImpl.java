package com.suzz.mini.facade.impl.driven;

import com.suzz.mini.domain.OrderCollection;
import com.suzz.mini.dto.driven.OrderCollectionUpdateDTO;
import com.suzz.mini.facade.user.driven.OrderCollectionFacade;
import com.suzz.mini.serivce.OrderCollectionService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/8/7 1:24
 **/
@DubboService(interfaceClass = OrderCollectionFacade.class)
@Api(tags = "orderCollectionFacadeImpl")
public class OrderCollectionFacadeImpl implements OrderCollectionFacade {

    @Autowired
    private OrderCollectionService orderCollectionService;

    @Override
    public ResponseDTO update(SimpleRequest<OrderCollectionUpdateDTO> request) {
        OrderCollection orderCollection = OrderCollection.toOrderCollection(request.getReqDtos());
        orderCollectionService.updateStatus(orderCollection);
        return new ResponseDTO();
    }
}
