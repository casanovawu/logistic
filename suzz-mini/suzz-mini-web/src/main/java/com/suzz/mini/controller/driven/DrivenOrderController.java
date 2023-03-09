package com.suzz.mini.controller.driven;

import com.suzz.mini.convertor.driven.OrderConvertor;
import com.suzz.mini.dto.driven.OrderSearchDetailInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchDetailQueryDTO;
import com.suzz.mini.dto.driven.OrderSearchInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchQueryDTO;
import com.suzz.mini.facade.user.driven.DrivenOrderFacade;
import com.suzz.mini.vo.driven.OrderSearchDetailInfoVO;
import com.suzz.mini.vo.driven.OrderSearchDetailQueryVO;
import com.suzz.mini.vo.driven.OrderSearchInfoVO;
import com.suzz.mini.vo.driven.OrderSearchQueryVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022/5/4 13:26
 **/
@Api(tags = "司机端订单")
@RestController
@RequestMapping(path = "/driven/order")
public class DrivenOrderController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private DrivenOrderFacade drivenOrderFacade;

    @PostMapping(path = "/search")
    @ApiOperation(value = "搜索")
    @ResponseBody
    public PageResponse<OrderSearchInfoVO> search(@RequestBody @Valid PageRequest<OrderSearchQueryVO> request) {
        PageRequest<OrderSearchQueryDTO> pageRequest = ControllerConvertUtil.convertForPage(request, OrderConvertor::convertorToOrderSearchQueryDTO);
        PageResponse<OrderSearchInfoDTO> pageResponse = drivenOrderFacade.search(pageRequest);
        return ControllerConvertUtil.successForPage(pageResponse,OrderConvertor::convertorToOrderSearchInfoVO);
    }

    @PostMapping(path = "/searchDetail")
    @ApiOperation(value = "搜索详情")
    @ResponseBody
    public SimpleResponse<OrderSearchDetailInfoVO> searchDetail(@RequestBody SimpleRequest<OrderSearchDetailQueryVO> request) {
        SimpleRequest<OrderSearchDetailQueryDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderConvertor::convertorToOrderSearchDetailQueryDTO);
        SimpleResponse<OrderSearchDetailInfoDTO> simpleResponse = drivenOrderFacade.searchDetail(simpleRequest);
       return ControllerConvertUtil.successForSimple(simpleResponse,OrderConvertor::toOrderSearchDetailInfoVO);
    }
}
