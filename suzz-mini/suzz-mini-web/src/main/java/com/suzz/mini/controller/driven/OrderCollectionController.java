package com.suzz.mini.controller.driven;

import com.suzz.mini.convertor.driven.OrderCollectionConvertor;
import com.suzz.mini.dto.driven.OrderCollectionUpdateDTO;
import com.suzz.mini.facade.user.driven.OrderCollectionFacade;
import com.suzz.mini.vo.driven.OrderCollectionUpdateVO;
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
 * @date 2022/8/6 23:59
 **/
@Api(tags = "收藏")
@RestController
@RequestMapping(path = "/order/collection")
public class OrderCollectionController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private OrderCollectionFacade orderCollectionFacade;

    @PostMapping(path = "/update")
    @ApiOperation(value = "收藏/取消收藏")
    @ResponseBody
    public ResponseDTO update(@RequestBody @Valid SimpleRequest<OrderCollectionUpdateVO> request) {
        SimpleRequest<OrderCollectionUpdateDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderCollectionConvertor::convertoToOrderCollectionUpdateDTO);
        return orderCollectionFacade.update(simpleRequest);
    }
}
