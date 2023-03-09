package com.suzz.mini.controller.driven;

import com.suzz.mini.convertor.driven.OrderLookConvertor;
import com.suzz.mini.dto.driven.OrderLookUpdateDTO;
import com.suzz.mini.facade.user.driven.OrderLookFacade;
import com.suzz.mini.vo.driven.OrderLookUpdateVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022/8/7 14:48
 **/
@Api(tags = "查看")
@RestController
@RequestMapping(path = "/order/look")
public class OrderLookController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private OrderLookFacade orderLookFacade;

    @PostMapping(path = "/update")
    @ApiOperation(value = "查看")
    @ResponseBody
    public ResponseDTO update(@RequestBody @Valid SimpleRequest<OrderLookUpdateVO> request) {
        SimpleRequest<OrderLookUpdateDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderLookConvertor::convertoToOrderLookUpdateDTO);
        return orderLookFacade.update(simpleRequest);
    }
}
